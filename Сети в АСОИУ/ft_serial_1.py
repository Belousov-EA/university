#! /usr/bin/env python
# -*- coding: utf-8 -*-
import ctypes
from serial import win32
from .code_Hemming import *

from .ft_serial import SerialBase, to_bytes
from . import ft_serial

class Serial(SerialBase):
	BAUDRATES = (50, 75, 110, 134, 150, 200, 300, 600, 1200, 1800,
				 2400, 4800,9600, 19200, 38400, 57600, 115200)

	def __init__(self, *args, **kwargs):
		self._port_handle = None
		self._overlapped_read = None
		self._overlapped_write = None
		super(Serial, self).__init__(*args, **kwargs)

	"""
		Open port with current settings 
	"""

	def open(self):
		if self._port is None:
			print("ERROR: Port must be configured before it can be used.")
			exit(1)
		if self.is_open:
			print("ERROR: Port is already opened.")
			exit(1)
		port = self.name
		try:
			if port.upper().startswith('COM') and int(port[3:]) > 8:
				port = '\\\\.\\' + port
		except ValueError:
			pass
		self._port_handle = win32.CreateFile(
			port,
			win32.GENERIC_READ | win32.GENERIC_WRITE,
			0, # exclusive access
			None, # no security
			win32.OPEN_EXISTING,
			win32.FILE_ATTRIBUTE_NORMAL | win32.FILE_FLAG_OVERLAPPED,
			0
		)
		"""
			Bad COM port
		"""
		if self._port_handle == win32.INVALID_HANDLE_VALUE:
			self._port_handle = None
			print("ERROR: Could not open port {}".format(self.port))
			exit(1)

		try:
			self._overlapped_read = win32.OVERLAPPED()
			self._overlapped_read.hEvent = win32.CreateEvent(None, 1, 0, None)
			self._overlapped_write = win32.OVERLAPPED()
			self._overlapped_write.hEvent = win32.CreateEvent(None, 0, 0, None)

			# Setup a 4k buffer
			win32.SetupComm(self._port_handle, 4096, 4096)

			# Save original timeout values:
			self._orgTimeouts = win32.COMMTIMEOUTS()
			win32.GetCommTimeouts(self._port_handle, ctypes.byref(self._orgTimeouts))

			self._reconfigure_port()

            # Clear buffers and terminates all outstanding operations
			win32.PurgeComm(
				self._port_handle,
				win32.PURGE_TXCLEAR | win32.PURGE_TXABORT |
				win32.PURGE_RXCLEAR | win32.PURGE_RXABORT)
		except:
			try:
				self._close()
			except:
				# ignore any exception when closing the port
				# also to keep original exception that happened when setting up
				pass
			self._port_handle = None
			raise
		else:
			self.is_open = True

	def _reconfigure_port(self):
		"""Set communication parameters on opened port."""
		if not self._port_handle:
			print("ERROR: Can only operate on a valid port handle")
			exit(1)

		timeouts = win32.COMMTIMEOUTS()
		if self._timeout is None:
			pass
		elif self._timeout == 0:
			timeouts.ReadIntervalTimeout = win32.MAXDWORD
		else:
			timeouts.ReadTotalTimeoutConstant = max(int(self._timeout * 1000), 1)
		if self._timeout != 0 and self._inter_byte_timeout is not None:
			timeouts.ReadIntervalTimeout = max(int(self._inter_byte_timeout * 1000), 1)

		if self._write_timeout is None:
			pass
		elif self._write_timeout == 0:
			timeouts.WriteTotalTimeoutConstant = win32.MAXDWORD
		else:
			timeouts.WriteTotalTimeoutConstant = max(int(self._write_timeout * 1000), 1)

		win32.SetCommTimeouts(self._port_handle, ctypes.byref(timeouts))
		win32.SetCommMask(self._port_handle, win32.EV_ERR)

		"""Setup the connection info
			Get state and modify it"""
		comDCB = win32.DCB()
		win32.GetCommState(self._port_handle, ctypes.byref(comDCB))
		"""Set baudrate"""
		comDCB.BaudRate = self._baudrate
		"""Set bytesize"""
		if self._bytesize == ft_serial.FIVEBITS:
			comDCB.ByteSize = 5
		elif self._bytesize == ft_serial.SIXBITS:
			comDCB.ByteSize = 6
		elif self._bytesize == ft_serial.SEVENBITS:
			comDCB.ByteSize = 7
		elif self._bytesize == ft_serial.EIGHTBITS:
			comDCB.ByteSize = 8

		"""Set parity"""
		if self._parity == ft_serial.PARITY_NONE:
			comDCB.Parity = win32.NOPARITY
			comDCB.fParity = 0
		elif self._parity == ft_serial.PARITY_EVEN:
			comDCB.Parity = win32.EVENPARITY
			comDCB.fParity = 1  # Enable Parity Check
		elif self._parity == ft_serial.PARITY_ODD:
			comDCB.Parity = win32.ODDPARITY
			comDCB.fParity = 1  # Enable Parity Check
		elif self._parity == ft_serial.PARITY_MARK:
			comDCB.Parity = win32.MARKPARITY
			comDCB.fParity = 1  # Enable Parity Check
		elif self._parity == ft_serial.PARITY_SPACE:
			comDCB.Parity = win32.SPACEPARITY
			comDCB.fParity = 1  # Enable Parity Check
		else:
			print("ERROR: Unsupported parity mode: {}".format(self._parity))
			exit(1)

		"""Set stopbit"""
		if self._stopbits == ft_serial.STOPBITS_ONE:
			comDCB.StopBits = win32.ONESTOPBIT
		elif self._stopbits == ft_serial.STOPBITS_ONE_POINT_FIVE:
			comDCB.StopBits = win32.ONE5STOPBITS
		elif self._stopbits == ft_serial.STOPBITS_TWO:
			comDCB.StopBits = win32.TWOSTOPBITS
		else:
			print("ERROR: Unsupported number of stop bits: {!r}".format(self._stopbits))
			exit(1)

		comDCB.fBinary = 1  # Enable Binary Transmission
		# Char. w/ Parity-Err are replaced with 0xff (if fErrorChar is set to TRUE)
		if self._rs485_mode is None:
			if self._rtscts:
				comDCB.fRtsControl = win32.RTS_CONTROL_HANDSHAKE
			else:
				comDCB.fRtsControl = win32.RTS_CONTROL_ENABLE if self._rts_state else win32.RTS_CONTROL_DISABLE
			comDCB.fOutxCtsFlow = self._rtscts

		if self._dsrdtr:
			comDCB.fDtrControl = win32.DTR_CONTROL_HANDSHAKE
		else:
			comDCB.fDtrControl = win32.DTR_CONTROL_ENABLE if self._dtr_state else win32.DTR_CONTROL_DISABLE
		comDCB.fOutxDsrFlow = self._dsrdtr
		comDCB.fOutX = self._xonxoff
		comDCB.fInX = self._xonxoff
		comDCB.fNull = 0
		comDCB.fErrorChar = 0
		comDCB.fAbortOnError = 0
		comDCB.XonChar = ft_serial.XON
		comDCB.XoffChar = ft_serial.XOFF

		if not win32.SetCommState(self._port_handle, ctypes.byref(comDCB)):
			print(
				'ERROR: Cannot configure port, something went wrong. '
				'Original message: {!r}'.format(ctypes.WinError()))
			exit(1)

	"""Close port"""
	def close(self):
		if self.is_open:
			self._close()
			self.is_open = False

	def _close(self):
		if self._port_handle is not None:
			win32.SetCommTimeouts(self._port_handle, self._orgTimeouts)
			if self._overlapped_read is not None:
				self.cancel_read()
				win32.CloseHandle(self._overlapped_read.hEvent)
				self._overlapped_read = None
			if self._overlapped_write is not None:
				self.cancel_write()
				win32.CloseHandle(self._overlapped_write.hEvent)
				self._overlapped_write = None
			win32.CloseHandle(self._port_handle)
			self._port_handle = None

	"""##-------------Stop read information-------##"""""
	def _cancel_overlapped_io(self, overlapped):
		"""Cancel a blocking read operation, may be called from other thread"""
		# check if read operation is pending
		rc = win32.DWORD()
		err = win32.GetOverlappedResult(
			self._port_handle,
			ctypes.byref(overlapped),
			ctypes.byref(rc),
			False)
		if not err and win32.GetLastError() in (win32.ERROR_IO_PENDING, win32.ERROR_IO_INCOMPLETE):
			# cancel, ignoring any errors (e.g. it may just have finished on its own)
			win32.CancelIoEx(self._port_handle, overlapped)

	def cancel_read(self):
		self._cancel_overlapped_io(self._overlapped_read)


	"""##-------------Stop write information-------##"""""
	def cancel_write(self):
		self._cancel_overlapped_io(self._overlapped_write)

	"""--------------------Write info---------------------"""

	def ft_write(self, data):
		if not self.is_open:
			print("Port is not opened")
			exit(1)
		data_encode = encode(data)('utf-8')
		n = win32.DWORD()
		success = win32.WriteFile(self._port_handle, data_encode, len(data_encode),
		                          ctypes.byref(n), self._overlapped_write)
		self._buffer.append(data_encode)
		return len(data)


	def write(self, data):
		if not self.is_open:
			print("Port is not opened")
			exit(1)
		data = to_bytes(data)
		if data:
			n = win32.DWORD()
			success = win32.WriteFile(self._port_handle, data, len(data),
			                          ctypes.byref(n), self._overlapped_write)
			if self._write_timeout != 0:
				if not success and win32.GetLastError() not in (win32.ERROR_SUCCESS, win32.ERROR_IO_PENDING):
					print("WriteFile failed ({!r})".format(ctypes.WinError()))
					exit(1)
				win32.GetOverlappedResult(self._port_handle, self._overlapped_write,
				                          ctypes.byref(n), True)
				if win32.GetLastError() == win32.ERROR_OPERATION_ABORTED:
					return n.value
				if n.value != len(data):
					print("Write timeout")
					exit(1)
				return n.value
			else:
				errorcode = win32.ERROR_SUCCESS if success else win32.GetLastError()
				if errorcode in (win32.ERROR_INVALID_USER_BUFFER, win32.ERROR_NOT_ENOUGH_MEMORY,
				                 win32.ERROR_OPERATION_ABORTED):
					return 0
				elif errorcode in (win32.ERROR_SUCCESS, win32.ERROR_IO_PENDING):
					# no info on true length provided by OS function in async mode
					return len(data)
				else:
					print("WriteFile failed ({!r})".format(ctypes.WinError()))
					exit(1)
		else:
			return 0

	@property
	def in_waiting(self):
		"""Return the number of bytes currently in the input buffer."""
		flags = win32.DWORD()
		comstat = win32.COMSTAT()
		if not win32.ClearCommError(self._port_handle, ctypes.byref(flags), ctypes.byref(comstat)):
			# print("ClearCommError failed ({!r})".format(ctypes.WinError()))
			pass
		return comstat.cbInQue

	"""--------------------Read info-----------------"""

	def ft_read(self, size=1):
		if not self.is_open:
			print("ERROR: Port is not opened")
		if size > 0:
			win32.ResetEvent(self._overlapped_read.hEvent)
			flags = win32.DWORD()
			comstat = win32.COMSTAT()
			n = min(comstat.cbInQue, size) if self.timeout == 0 else size
			if n > 0:
				buf = ctypes.create_string_buffer(n)
				rc = win32.DWORD()
				read_ok = win32.ReadFile(self._port_handle,
				                         buf,
				                         n,
				                         ctypes.byref(rc),
				                         ctypes.byref(self._overlapped_read))
				buffer = buf.raw.decode('utf-8')
				buffer = decode(buffer)
				return buffer
		else:
			return []

	def read(self, size=1):
		if not self.is_open:
			print("ERROR: Port is not opened")
			exit(1)
		if size > 0:
			win32.ResetEvent(self._overlapped_read.hEvent)
			flags = win32.DWORD()
			comstat = win32.COMSTAT()
			if not win32.ClearCommError(self._port_handle, ctypes.byref(flags), ctypes.byref(comstat)):
				print("ERROR: ClearCommError failed ({!r})".format(ctypes.WinError()))
				exit(1)
			n = min(comstat.cbInQue, size) if self.timeout == 0 else size
			if n > 0:
				buf = ctypes.create_string_buffer(n)
				rc = win32.DWORD()
				read_ok = win32.ReadFile(self._port_handle,
				                         buf,
				                         n,
				                         ctypes.byref(rc),
				                         ctypes.byref(self._overlapped_read))
				if not read_ok and win32.GetLastError() not in (win32.ERROR_SUCCESS, win32.ERROR_IO_PENDING):
					print("ERROR: ReadFile failed ({!r})".format(ctypes.WinError()))
					exit(1)
				if not read_ok:
					print("ERROR: Something bad")
					return buf.value
				result_ok = win32.GetOverlappedResult(self._port_handle,
				                                      ctypes.byref(self._overlapped_read),
				                                      ctypes.byref(rc),
				                                      True)
				if not result_ok:
					if win32.GetLastError() != win32.ERROR_OPERATION_ABORTED:
						raise SerialException("GetOverlappedResult failed ({!r})".format(ctypes.WinError()))
				read = buf.raw[:rc.value]
			else:
				read = bytes()
		else:
			read = bytes()
		return bytes(read)