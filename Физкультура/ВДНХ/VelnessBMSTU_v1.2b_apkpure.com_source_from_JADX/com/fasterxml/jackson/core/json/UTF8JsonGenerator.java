package com.fasterxml.jackson.core.json;

import android.support.v4.internal.view.SupportMenu;
import android.support.v4.media.TransportMediator;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class UTF8JsonGenerator extends JsonGeneratorImpl {
    private static final byte BYTE_0 = (byte) 48;
    private static final byte BYTE_BACKSLASH = (byte) 92;
    private static final byte BYTE_COLON = (byte) 58;
    private static final byte BYTE_COMMA = (byte) 44;
    private static final byte BYTE_LBRACKET = (byte) 91;
    private static final byte BYTE_LCURLY = (byte) 123;
    private static final byte BYTE_QUOTE = (byte) 34;
    private static final byte BYTE_RBRACKET = (byte) 93;
    private static final byte BYTE_RCURLY = (byte) 125;
    private static final byte BYTE_u = (byte) 117;
    private static final byte[] FALSE_BYTES = new byte[]{(byte) 102, (byte) 97, (byte) 108, (byte) 115, (byte) 101};
    static final byte[] HEX_CHARS = CharTypes.copyHexBytes();
    private static final int MAX_BYTES_TO_BUFFER = 512;
    private static final byte[] NULL_BYTES = new byte[]{(byte) 110, BYTE_u, (byte) 108, (byte) 108};
    protected static final int SURR1_FIRST = 55296;
    protected static final int SURR1_LAST = 56319;
    protected static final int SURR2_FIRST = 56320;
    protected static final int SURR2_LAST = 57343;
    private static final byte[] TRUE_BYTES = new byte[]{(byte) 116, (byte) 114, BYTE_u, (byte) 101};
    protected boolean _bufferRecyclable;
    protected char[] _charBuffer;
    protected final int _charBufferLength;
    protected byte[] _entityBuffer;
    protected byte[] _outputBuffer;
    protected final int _outputEnd;
    protected final int _outputMaxContiguous;
    protected final OutputStream _outputStream;
    protected int _outputTail = 0;

    public UTF8JsonGenerator(IOContext ctxt, int features, ObjectCodec codec, OutputStream out) {
        super(ctxt, features, codec);
        this._outputStream = out;
        this._bufferRecyclable = true;
        this._outputBuffer = ctxt.allocWriteEncodingBuffer();
        this._outputEnd = this._outputBuffer.length;
        this._outputMaxContiguous = this._outputEnd >> 3;
        this._charBuffer = ctxt.allocConcatBuffer();
        this._charBufferLength = this._charBuffer.length;
        if (isEnabled(Feature.ESCAPE_NON_ASCII)) {
            setHighestNonEscapedChar(TransportMediator.KEYCODE_MEDIA_PAUSE);
        }
    }

    public UTF8JsonGenerator(IOContext ctxt, int features, ObjectCodec codec, OutputStream out, byte[] outputBuffer, int outputOffset, boolean bufferRecyclable) {
        super(ctxt, features, codec);
        this._outputStream = out;
        this._bufferRecyclable = bufferRecyclable;
        this._outputTail = outputOffset;
        this._outputBuffer = outputBuffer;
        this._outputEnd = this._outputBuffer.length;
        this._outputMaxContiguous = this._outputEnd >> 3;
        this._charBuffer = ctxt.allocConcatBuffer();
        this._charBufferLength = this._charBuffer.length;
    }

    public Object getOutputTarget() {
        return this._outputStream;
    }

    public final void writeFieldName(String name) throws IOException, JsonGenerationException {
        boolean z = true;
        int status = this._writeContext.writeFieldName(name);
        if (status == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        if (this._cfgPrettyPrinter != null) {
            if (status != 1) {
                z = false;
            }
            _writePPFieldName(name, z);
            return;
        }
        if (status == 1) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_COMMA;
        }
        _writeFieldName(name);
    }

    public final void writeFieldName(SerializableString name) throws IOException, JsonGenerationException {
        boolean z = true;
        int status = this._writeContext.writeFieldName(name.getValue());
        if (status == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        if (this._cfgPrettyPrinter != null) {
            if (status != 1) {
                z = false;
            }
            _writePPFieldName(name, z);
            return;
        }
        if (status == 1) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_COMMA;
        }
        _writeFieldName(name);
    }

    public final void writeStartArray() throws IOException, JsonGenerationException {
        _verifyValueWrite("start an array");
        this._writeContext = this._writeContext.createChildArrayContext();
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeStartArray(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_LBRACKET;
    }

    public final void writeEndArray() throws IOException, JsonGenerationException {
        if (!this._writeContext.inArray()) {
            _reportError("Current context not an ARRAY but " + this._writeContext.getTypeDesc());
        }
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeEndArray(this, this._writeContext.getEntryCount());
        } else {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_RBRACKET;
        }
        this._writeContext = this._writeContext.getParent();
    }

    public final void writeStartObject() throws IOException, JsonGenerationException {
        _verifyValueWrite("start an object");
        this._writeContext = this._writeContext.createChildObjectContext();
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeStartObject(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_LCURLY;
    }

    public final void writeEndObject() throws IOException, JsonGenerationException {
        if (!this._writeContext.inObject()) {
            _reportError("Current context not an object but " + this._writeContext.getTypeDesc());
        }
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeEndObject(this, this._writeContext.getEntryCount());
        } else {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_RCURLY;
        }
        this._writeContext = this._writeContext.getParent();
    }

    protected final void _writeFieldName(String name) throws IOException, JsonGenerationException {
        if (isEnabled(Feature.QUOTE_FIELD_NAMES)) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_QUOTE;
            int len = name.length();
            if (len <= this._charBufferLength) {
                name.getChars(0, len, this._charBuffer, 0);
                if (len <= this._outputMaxContiguous) {
                    if (this._outputTail + len > this._outputEnd) {
                        _flushBuffer();
                    }
                    _writeStringSegment(this._charBuffer, 0, len);
                } else {
                    _writeStringSegments(this._charBuffer, 0, len);
                }
            } else {
                _writeStringSegments(name);
            }
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            bArr = this._outputBuffer;
            i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_QUOTE;
            return;
        }
        _writeStringSegments(name);
    }

    protected final void _writeFieldName(SerializableString name) throws IOException, JsonGenerationException {
        int len;
        if (isEnabled(Feature.QUOTE_FIELD_NAMES)) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_QUOTE;
            len = name.appendQuotedUTF8(this._outputBuffer, this._outputTail);
            if (len < 0) {
                _writeBytes(name.asQuotedUTF8());
            } else {
                this._outputTail += len;
            }
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            bArr = this._outputBuffer;
            i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_QUOTE;
            return;
        }
        len = name.appendQuotedUTF8(this._outputBuffer, this._outputTail);
        if (len < 0) {
            _writeBytes(name.asQuotedUTF8());
        } else {
            this._outputTail += len;
        }
    }

    protected final void _writePPFieldName(String name, boolean commaBefore) throws IOException, JsonGenerationException {
        if (commaBefore) {
            this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
        } else {
            this._cfgPrettyPrinter.beforeObjectEntries(this);
        }
        if (isEnabled(Feature.QUOTE_FIELD_NAMES)) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_QUOTE;
            int len = name.length();
            if (len <= this._charBufferLength) {
                name.getChars(0, len, this._charBuffer, 0);
                if (len <= this._outputMaxContiguous) {
                    if (this._outputTail + len > this._outputEnd) {
                        _flushBuffer();
                    }
                    _writeStringSegment(this._charBuffer, 0, len);
                } else {
                    _writeStringSegments(this._charBuffer, 0, len);
                }
            } else {
                _writeStringSegments(name);
            }
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            bArr = this._outputBuffer;
            i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_QUOTE;
            return;
        }
        _writeStringSegments(name);
    }

    protected final void _writePPFieldName(SerializableString name, boolean commaBefore) throws IOException, JsonGenerationException {
        if (commaBefore) {
            this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
        } else {
            this._cfgPrettyPrinter.beforeObjectEntries(this);
        }
        boolean addQuotes = isEnabled(Feature.QUOTE_FIELD_NAMES);
        if (addQuotes) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            byte[] bArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_QUOTE;
        }
        _writeBytes(name.asQuotedUTF8());
        if (addQuotes) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            bArr = this._outputBuffer;
            i = this._outputTail;
            this._outputTail = i + 1;
            bArr[i] = BYTE_QUOTE;
        }
    }

    public void writeString(String text) throws IOException, JsonGenerationException {
        _verifyValueWrite("write text value");
        if (text == null) {
            _writeNull();
            return;
        }
        int len = text.length();
        if (len > this._charBufferLength) {
            _writeLongString(text);
            return;
        }
        text.getChars(0, len, this._charBuffer, 0);
        if (len > this._outputMaxContiguous) {
            _writeLongString(this._charBuffer, 0, len);
            return;
        }
        if (this._outputTail + len >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        _writeStringSegment(this._charBuffer, 0, len);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        bArr = this._outputBuffer;
        i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
    }

    private void _writeLongString(String text) throws IOException, JsonGenerationException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        _writeStringSegments(text);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        bArr = this._outputBuffer;
        i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
    }

    private void _writeLongString(char[] text, int offset, int len) throws IOException, JsonGenerationException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        _writeStringSegments(this._charBuffer, 0, len);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        bArr = this._outputBuffer;
        i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
    }

    public void writeString(char[] text, int offset, int len) throws IOException, JsonGenerationException {
        _verifyValueWrite("write text value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        if (len <= this._outputMaxContiguous) {
            if (this._outputTail + len > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(text, offset, len);
        } else {
            _writeStringSegments(text, offset, len);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        bArr = this._outputBuffer;
        i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
    }

    public final void writeString(SerializableString text) throws IOException, JsonGenerationException {
        _verifyValueWrite("write text value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        int len = text.appendQuotedUTF8(this._outputBuffer, this._outputTail);
        if (len < 0) {
            _writeBytes(text.asQuotedUTF8());
        } else {
            this._outputTail += len;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        bArr = this._outputBuffer;
        i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
    }

    public void writeRawUTF8String(byte[] text, int offset, int length) throws IOException, JsonGenerationException {
        _verifyValueWrite("write text value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        _writeBytes(text, offset, length);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        bArr = this._outputBuffer;
        i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
    }

    public void writeUTF8String(byte[] text, int offset, int len) throws IOException, JsonGenerationException {
        _verifyValueWrite("write text value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        if (len <= this._outputMaxContiguous) {
            _writeUTF8Segment(text, offset, len);
        } else {
            _writeUTF8Segments(text, offset, len);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        bArr = this._outputBuffer;
        i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
    }

    public void writeRaw(String text) throws IOException, JsonGenerationException {
        int start = 0;
        int len = text.length();
        while (len > 0) {
            int len2;
            char[] buf = this._charBuffer;
            int blen = buf.length;
            if (len < blen) {
                len2 = len;
            } else {
                len2 = blen;
            }
            text.getChars(start, start + len2, buf, 0);
            writeRaw(buf, 0, len2);
            start += len2;
            len -= len2;
        }
    }

    public void writeRaw(String text, int offset, int len) throws IOException, JsonGenerationException {
        while (len > 0) {
            int len2;
            char[] buf = this._charBuffer;
            int blen = buf.length;
            if (len < blen) {
                len2 = len;
            } else {
                len2 = blen;
            }
            text.getChars(offset, offset + len2, buf, 0);
            writeRaw(buf, 0, len2);
            offset += len2;
            len -= len2;
        }
    }

    public void writeRaw(SerializableString text) throws IOException, JsonGenerationException {
        byte[] raw = text.asUnquotedUTF8();
        if (raw.length > 0) {
            _writeBytes(raw);
        }
    }

    public final void writeRaw(char[] cbuf, int offset, int len) throws IOException, JsonGenerationException {
        int len3 = (len + len) + len;
        if (this._outputTail + len3 > this._outputEnd) {
            if (this._outputEnd < len3) {
                _writeSegmentedRaw(cbuf, offset, len);
                return;
            }
            _flushBuffer();
        }
        len += offset;
        while (offset < len) {
            char ch;
            while (true) {
                ch = cbuf[offset];
                if (ch > Ascii.MAX) {
                    break;
                }
                byte[] bArr = this._outputBuffer;
                int i = this._outputTail;
                this._outputTail = i + 1;
                bArr[i] = (byte) ch;
                offset++;
                if (offset >= len) {
                    return;
                }
            }
            int offset2 = offset + 1;
            ch = cbuf[offset];
            if (ch < 'ࠀ') {
                bArr = this._outputBuffer;
                i = this._outputTail;
                this._outputTail = i + 1;
                bArr[i] = (byte) ((ch >> 6) | 192);
                bArr = this._outputBuffer;
                i = this._outputTail;
                this._outputTail = i + 1;
                bArr[i] = (byte) ((ch & 63) | 128);
            } else {
                _outputRawMultiByteChar(ch, cbuf, offset2, len);
            }
            offset = offset2;
        }
    }

    public void writeRaw(char ch) throws IOException, JsonGenerationException {
        if (this._outputTail + 3 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bbuf = this._outputBuffer;
        int i;
        if (ch <= Ascii.MAX) {
            i = this._outputTail;
            this._outputTail = i + 1;
            bbuf[i] = (byte) ch;
        } else if (ch < 'ࠀ') {
            i = this._outputTail;
            this._outputTail = i + 1;
            bbuf[i] = (byte) ((ch >> 6) | 192);
            i = this._outputTail;
            this._outputTail = i + 1;
            bbuf[i] = (byte) ((ch & 63) | 128);
        } else {
            _outputRawMultiByteChar(ch, null, 0, 0);
        }
    }

    private final void _writeSegmentedRaw(char[] cbuf, int offset, int len) throws IOException, JsonGenerationException {
        int end = this._outputEnd;
        byte[] bbuf = this._outputBuffer;
        while (offset < len) {
            char ch;
            while (true) {
                ch = cbuf[offset];
                if (ch >= '') {
                    break;
                }
                if (this._outputTail >= end) {
                    _flushBuffer();
                }
                int i = this._outputTail;
                this._outputTail = i + 1;
                bbuf[i] = (byte) ch;
                offset++;
                if (offset >= len) {
                    return;
                }
            }
            if (this._outputTail + 3 >= this._outputEnd) {
                _flushBuffer();
            }
            int offset2 = offset + 1;
            ch = cbuf[offset];
            if (ch < 'ࠀ') {
                i = this._outputTail;
                this._outputTail = i + 1;
                bbuf[i] = (byte) ((ch >> 6) | 192);
                i = this._outputTail;
                this._outputTail = i + 1;
                bbuf[i] = (byte) ((ch & 63) | 128);
            } else {
                _outputRawMultiByteChar(ch, cbuf, offset2, len);
            }
            offset = offset2;
        }
    }

    public void writeBinary(Base64Variant b64variant, byte[] data, int offset, int len) throws IOException, JsonGenerationException {
        _verifyValueWrite("write binary value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        _writeBinary(b64variant, data, offset, offset + len);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        bArr = this._outputBuffer;
        i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
    }

    public int writeBinary(Base64Variant b64variant, InputStream data, int dataLength) throws IOException, JsonGenerationException {
        int bytes;
        _verifyValueWrite("write binary value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        byte[] encodingBuffer = this._ioContext.allocBase64Buffer();
        if (dataLength < 0) {
            try {
                bytes = _writeBinary(b64variant, data, encodingBuffer);
            } catch (Throwable th) {
                this._ioContext.releaseBase64Buffer(encodingBuffer);
            }
        } else {
            int missing = _writeBinary(b64variant, data, encodingBuffer, dataLength);
            if (missing > 0) {
                _reportError("Too few bytes available: missing " + missing + " bytes (out of " + dataLength + ")");
            }
            bytes = dataLength;
        }
        this._ioContext.releaseBase64Buffer(encodingBuffer);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        bArr = this._outputBuffer;
        i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        return bytes;
    }

    public void writeNumber(int i) throws IOException, JsonGenerationException {
        _verifyValueWrite("write number");
        if (this._outputTail + 11 >= this._outputEnd) {
            _flushBuffer();
        }
        if (this._cfgNumbersAsStrings) {
            _writeQuotedInt(i);
        } else {
            this._outputTail = NumberOutput.outputInt(i, this._outputBuffer, this._outputTail);
        }
    }

    private void _writeQuotedInt(int i) throws IOException {
        if (this._outputTail + 13 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr[i2] = BYTE_QUOTE;
        this._outputTail = NumberOutput.outputInt(i, this._outputBuffer, this._outputTail);
        bArr = this._outputBuffer;
        i2 = this._outputTail;
        this._outputTail = i2 + 1;
        bArr[i2] = BYTE_QUOTE;
    }

    public void writeNumber(long l) throws IOException, JsonGenerationException {
        _verifyValueWrite("write number");
        if (this._cfgNumbersAsStrings) {
            _writeQuotedLong(l);
            return;
        }
        if (this._outputTail + 21 >= this._outputEnd) {
            _flushBuffer();
        }
        this._outputTail = NumberOutput.outputLong(l, this._outputBuffer, this._outputTail);
    }

    private void _writeQuotedLong(long l) throws IOException {
        if (this._outputTail + 23 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        this._outputTail = NumberOutput.outputLong(l, this._outputBuffer, this._outputTail);
        bArr = this._outputBuffer;
        i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
    }

    public void writeNumber(BigInteger value) throws IOException, JsonGenerationException {
        _verifyValueWrite("write number");
        if (value == null) {
            _writeNull();
        } else if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(value);
        } else {
            writeRaw(value.toString());
        }
    }

    public void writeNumber(double d) throws IOException, JsonGenerationException {
        if (this._cfgNumbersAsStrings || ((Double.isNaN(d) || Double.isInfinite(d)) && isEnabled(Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            writeString(String.valueOf(d));
            return;
        }
        _verifyValueWrite("write number");
        writeRaw(String.valueOf(d));
    }

    public void writeNumber(float f) throws IOException, JsonGenerationException {
        if (this._cfgNumbersAsStrings || ((Float.isNaN(f) || Float.isInfinite(f)) && isEnabled(Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            writeString(String.valueOf(f));
            return;
        }
        _verifyValueWrite("write number");
        writeRaw(String.valueOf(f));
    }

    public void writeNumber(BigDecimal value) throws IOException, JsonGenerationException {
        _verifyValueWrite("write number");
        if (value == null) {
            _writeNull();
        } else if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(value);
        } else {
            writeRaw(value.toString());
        }
    }

    public void writeNumber(String encodedValue) throws IOException, JsonGenerationException {
        _verifyValueWrite("write number");
        if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(encodedValue);
        } else {
            writeRaw(encodedValue);
        }
    }

    private void _writeQuotedRaw(Object value) throws IOException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] bArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
        writeRaw(value.toString());
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        bArr = this._outputBuffer;
        i = this._outputTail;
        this._outputTail = i + 1;
        bArr[i] = BYTE_QUOTE;
    }

    public void writeBoolean(boolean state) throws IOException, JsonGenerationException {
        _verifyValueWrite("write boolean value");
        if (this._outputTail + 5 >= this._outputEnd) {
            _flushBuffer();
        }
        byte[] keyword = state ? TRUE_BYTES : FALSE_BYTES;
        int len = keyword.length;
        System.arraycopy(keyword, 0, this._outputBuffer, this._outputTail, len);
        this._outputTail += len;
    }

    public void writeNull() throws IOException, JsonGenerationException {
        _verifyValueWrite("write null value");
        _writeNull();
    }

    protected final void _verifyValueWrite(String typeMsg) throws IOException, JsonGenerationException {
        int status = this._writeContext.writeValue();
        if (status == 5) {
            _reportError("Can not " + typeMsg + ", expecting field name");
        }
        if (this._cfgPrettyPrinter == null) {
            byte b;
            switch (status) {
                case 1:
                    b = BYTE_COMMA;
                    break;
                case 2:
                    b = BYTE_COLON;
                    break;
                case 3:
                    if (this._rootValueSeparator != null) {
                        byte[] raw = this._rootValueSeparator.asUnquotedUTF8();
                        if (raw.length > 0) {
                            _writeBytes(raw);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            this._outputBuffer[this._outputTail] = b;
            this._outputTail++;
            return;
        }
        _verifyPrettyValueWrite(typeMsg, status);
    }

    protected final void _verifyPrettyValueWrite(String typeMsg, int status) throws IOException, JsonGenerationException {
        switch (status) {
            case 0:
                if (this._writeContext.inArray()) {
                    this._cfgPrettyPrinter.beforeArrayValues(this);
                    return;
                } else if (this._writeContext.inObject()) {
                    this._cfgPrettyPrinter.beforeObjectEntries(this);
                    return;
                } else {
                    return;
                }
            case 1:
                this._cfgPrettyPrinter.writeArrayValueSeparator(this);
                return;
            case 2:
                this._cfgPrettyPrinter.writeObjectFieldValueSeparator(this);
                return;
            case 3:
                this._cfgPrettyPrinter.writeRootValueSeparator(this);
                return;
            default:
                _cantHappen();
                return;
        }
    }

    public final void flush() throws IOException {
        _flushBuffer();
        if (this._outputStream != null && isEnabled(Feature.FLUSH_PASSED_TO_STREAM)) {
            this._outputStream.flush();
        }
    }

    public void close() throws IOException {
        super.close();
        if (this._outputBuffer != null && isEnabled(Feature.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                JsonStreamContext ctxt = getOutputContext();
                if (!ctxt.inArray()) {
                    if (!ctxt.inObject()) {
                        break;
                    }
                    writeEndObject();
                } else {
                    writeEndArray();
                }
            }
        }
        _flushBuffer();
        if (this._outputStream != null) {
            if (this._ioContext.isResourceManaged() || isEnabled(Feature.AUTO_CLOSE_TARGET)) {
                this._outputStream.close();
            } else if (isEnabled(Feature.FLUSH_PASSED_TO_STREAM)) {
                this._outputStream.flush();
            }
        }
        _releaseBuffers();
    }

    protected void _releaseBuffers() {
        byte[] buf = this._outputBuffer;
        if (buf != null && this._bufferRecyclable) {
            this._outputBuffer = null;
            this._ioContext.releaseWriteEncodingBuffer(buf);
        }
        char[] cbuf = this._charBuffer;
        if (cbuf != null) {
            this._charBuffer = null;
            this._ioContext.releaseConcatBuffer(cbuf);
        }
    }

    private final void _writeBytes(byte[] bytes) throws IOException {
        int len = bytes.length;
        if (this._outputTail + len > this._outputEnd) {
            _flushBuffer();
            if (len > 512) {
                this._outputStream.write(bytes, 0, len);
                return;
            }
        }
        System.arraycopy(bytes, 0, this._outputBuffer, this._outputTail, len);
        this._outputTail += len;
    }

    private final void _writeBytes(byte[] bytes, int offset, int len) throws IOException {
        if (this._outputTail + len > this._outputEnd) {
            _flushBuffer();
            if (len > 512) {
                this._outputStream.write(bytes, offset, len);
                return;
            }
        }
        System.arraycopy(bytes, offset, this._outputBuffer, this._outputTail, len);
        this._outputTail += len;
    }

    private final void _writeStringSegments(String text) throws IOException, JsonGenerationException {
        int left = text.length();
        int offset = 0;
        char[] cbuf = this._charBuffer;
        while (left > 0) {
            int len = Math.min(this._outputMaxContiguous, left);
            text.getChars(offset, offset + len, cbuf, 0);
            if (this._outputTail + len > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(cbuf, 0, len);
            offset += len;
            left -= len;
        }
    }

    private final void _writeStringSegments(char[] cbuf, int offset, int totalLen) throws IOException, JsonGenerationException {
        do {
            int len = Math.min(this._outputMaxContiguous, totalLen);
            if (this._outputTail + len > this._outputEnd) {
                _flushBuffer();
            }
            _writeStringSegment(cbuf, offset, len);
            offset += len;
            totalLen -= len;
        } while (totalLen > 0);
    }

    private final void _writeStringSegment(char[] cbuf, int offset, int len) throws IOException, JsonGenerationException {
        len += offset;
        int outputPtr = this._outputTail;
        byte[] outputBuffer = this._outputBuffer;
        int[] escCodes = this._outputEscapes;
        int outputPtr2 = outputPtr;
        while (offset < len) {
            int ch = cbuf[offset];
            if (ch > TransportMediator.KEYCODE_MEDIA_PAUSE || escCodes[ch] != 0) {
                break;
            }
            outputPtr = outputPtr2 + 1;
            outputBuffer[outputPtr2] = (byte) ch;
            offset++;
            outputPtr2 = outputPtr;
        }
        this._outputTail = outputPtr2;
        if (offset >= len) {
            return;
        }
        if (this._characterEscapes != null) {
            _writeCustomStringSegment2(cbuf, offset, len);
        } else if (this._maximumNonEscapedChar == 0) {
            _writeStringSegment2(cbuf, offset, len);
        } else {
            _writeStringSegmentASCII2(cbuf, offset, len);
        }
    }

    private final void _writeStringSegment2(char[] cbuf, int offset, int end) throws IOException, JsonGenerationException {
        if (this._outputTail + ((end - offset) * 6) > this._outputEnd) {
            _flushBuffer();
        }
        int outputPtr = this._outputTail;
        byte[] outputBuffer = this._outputBuffer;
        int[] escCodes = this._outputEscapes;
        int outputPtr2 = outputPtr;
        int offset2 = offset;
        while (offset2 < end) {
            offset = offset2 + 1;
            int ch = cbuf[offset2];
            if (ch > TransportMediator.KEYCODE_MEDIA_PAUSE) {
                if (ch <= 2047) {
                    outputPtr = outputPtr2 + 1;
                    outputBuffer[outputPtr2] = (byte) ((ch >> 6) | 192);
                    outputPtr2 = outputPtr + 1;
                    outputBuffer[outputPtr] = (byte) ((ch & 63) | 128);
                    outputPtr = outputPtr2;
                } else {
                    outputPtr = _outputMultiByteChar(ch, outputPtr2);
                }
                outputPtr2 = outputPtr;
                offset2 = offset;
            } else if (escCodes[ch] == 0) {
                outputPtr = outputPtr2 + 1;
                outputBuffer[outputPtr2] = (byte) ch;
                outputPtr2 = outputPtr;
                offset2 = offset;
            } else {
                int escape = escCodes[ch];
                if (escape > 0) {
                    outputPtr = outputPtr2 + 1;
                    outputBuffer[outputPtr2] = BYTE_BACKSLASH;
                    outputPtr2 = outputPtr + 1;
                    outputBuffer[outputPtr] = (byte) escape;
                    offset2 = offset;
                } else {
                    outputPtr2 = _writeGenericEscape(ch, outputPtr2);
                    offset2 = offset;
                }
            }
        }
        this._outputTail = outputPtr2;
    }

    private final void _writeStringSegmentASCII2(char[] cbuf, int offset, int end) throws IOException, JsonGenerationException {
        if (this._outputTail + ((end - offset) * 6) > this._outputEnd) {
            _flushBuffer();
        }
        int outputPtr = this._outputTail;
        byte[] outputBuffer = this._outputBuffer;
        int[] escCodes = this._outputEscapes;
        int maxUnescaped = this._maximumNonEscapedChar;
        int outputPtr2 = outputPtr;
        int offset2 = offset;
        while (offset2 < end) {
            offset = offset2 + 1;
            int ch = cbuf[offset2];
            if (ch <= TransportMediator.KEYCODE_MEDIA_PAUSE) {
                if (escCodes[ch] == 0) {
                    outputPtr = outputPtr2 + 1;
                    outputBuffer[outputPtr2] = (byte) ch;
                    outputPtr2 = outputPtr;
                    offset2 = offset;
                } else {
                    int escape = escCodes[ch];
                    if (escape > 0) {
                        outputPtr = outputPtr2 + 1;
                        outputBuffer[outputPtr2] = BYTE_BACKSLASH;
                        outputPtr2 = outputPtr + 1;
                        outputBuffer[outputPtr] = (byte) escape;
                        offset2 = offset;
                    } else {
                        outputPtr2 = _writeGenericEscape(ch, outputPtr2);
                        offset2 = offset;
                    }
                }
            } else if (ch > maxUnescaped) {
                outputPtr2 = _writeGenericEscape(ch, outputPtr2);
                offset2 = offset;
            } else {
                if (ch <= 2047) {
                    outputPtr = outputPtr2 + 1;
                    outputBuffer[outputPtr2] = (byte) ((ch >> 6) | 192);
                    outputPtr2 = outputPtr + 1;
                    outputBuffer[outputPtr] = (byte) ((ch & 63) | 128);
                    outputPtr = outputPtr2;
                } else {
                    outputPtr = _outputMultiByteChar(ch, outputPtr2);
                }
                outputPtr2 = outputPtr;
                offset2 = offset;
            }
        }
        this._outputTail = outputPtr2;
    }

    private void _writeCustomStringSegment2(char[] cbuf, int offset, int end) throws IOException, JsonGenerationException {
        if (this._outputTail + ((end - offset) * 6) > this._outputEnd) {
            _flushBuffer();
        }
        int outputPtr = this._outputTail;
        byte[] outputBuffer = this._outputBuffer;
        int[] escCodes = this._outputEscapes;
        int maxUnescaped = this._maximumNonEscapedChar <= 0 ? SupportMenu.USER_MASK : this._maximumNonEscapedChar;
        CharacterEscapes customEscapes = this._characterEscapes;
        int outputPtr2 = outputPtr;
        int offset2 = offset;
        while (offset2 < end) {
            offset = offset2 + 1;
            int ch = cbuf[offset2];
            SerializableString esc;
            if (ch <= TransportMediator.KEYCODE_MEDIA_PAUSE) {
                if (escCodes[ch] == 0) {
                    outputPtr = outputPtr2 + 1;
                    outputBuffer[outputPtr2] = (byte) ch;
                    outputPtr2 = outputPtr;
                    offset2 = offset;
                } else {
                    int escape = escCodes[ch];
                    if (escape > 0) {
                        outputPtr = outputPtr2 + 1;
                        outputBuffer[outputPtr2] = BYTE_BACKSLASH;
                        outputPtr2 = outputPtr + 1;
                        outputBuffer[outputPtr] = (byte) escape;
                        offset2 = offset;
                    } else if (escape == -2) {
                        esc = customEscapes.getEscapeSequence(ch);
                        if (esc == null) {
                            _reportError("Invalid custom escape definitions; custom escape not found for character code 0x" + Integer.toHexString(ch) + ", although was supposed to have one");
                        }
                        outputPtr2 = _writeCustomEscape(outputBuffer, outputPtr2, esc, end - offset);
                        offset2 = offset;
                    } else {
                        outputPtr2 = _writeGenericEscape(ch, outputPtr2);
                        offset2 = offset;
                    }
                }
            } else if (ch > maxUnescaped) {
                outputPtr2 = _writeGenericEscape(ch, outputPtr2);
                offset2 = offset;
            } else {
                esc = customEscapes.getEscapeSequence(ch);
                if (esc != null) {
                    outputPtr2 = _writeCustomEscape(outputBuffer, outputPtr2, esc, end - offset);
                    offset2 = offset;
                } else {
                    if (ch <= 2047) {
                        outputPtr = outputPtr2 + 1;
                        outputBuffer[outputPtr2] = (byte) ((ch >> 6) | 192);
                        outputPtr2 = outputPtr + 1;
                        outputBuffer[outputPtr] = (byte) ((ch & 63) | 128);
                        outputPtr = outputPtr2;
                    } else {
                        outputPtr = _outputMultiByteChar(ch, outputPtr2);
                    }
                    outputPtr2 = outputPtr;
                    offset2 = offset;
                }
            }
        }
        this._outputTail = outputPtr2;
    }

    private int _writeCustomEscape(byte[] outputBuffer, int outputPtr, SerializableString esc, int remainingChars) throws IOException, JsonGenerationException {
        byte[] raw = esc.asUnquotedUTF8();
        int len = raw.length;
        if (len > 6) {
            return _handleLongCustomEscape(outputBuffer, outputPtr, this._outputEnd, raw, remainingChars);
        }
        System.arraycopy(raw, 0, outputBuffer, outputPtr, len);
        return outputPtr + len;
    }

    private int _handleLongCustomEscape(byte[] outputBuffer, int outputPtr, int outputEnd, byte[] raw, int remainingChars) throws IOException, JsonGenerationException {
        int len = raw.length;
        if (outputPtr + len > outputEnd) {
            this._outputTail = outputPtr;
            _flushBuffer();
            outputPtr = this._outputTail;
            if (len > outputBuffer.length) {
                this._outputStream.write(raw, 0, len);
                return outputPtr;
            }
            System.arraycopy(raw, 0, outputBuffer, outputPtr, len);
            outputPtr += len;
        }
        if ((remainingChars * 6) + outputPtr <= outputEnd) {
            return outputPtr;
        }
        _flushBuffer();
        return this._outputTail;
    }

    private void _writeUTF8Segments(byte[] utf8, int offset, int totalLen) throws IOException, JsonGenerationException {
        do {
            int len = Math.min(this._outputMaxContiguous, totalLen);
            _writeUTF8Segment(utf8, offset, len);
            offset += len;
            totalLen -= len;
        } while (totalLen > 0);
    }

    private void _writeUTF8Segment(byte[] utf8, int offset, int len) throws IOException, JsonGenerationException {
        int ptr;
        int[] escCodes = this._outputEscapes;
        int end = offset + len;
        int ptr2 = offset;
        while (ptr2 < end) {
            ptr = ptr2 + 1;
            int ch = utf8[ptr2];
            if (ch < 0 || escCodes[ch] == 0) {
                ptr2 = ptr;
            } else {
                _writeUTF8Segment2(utf8, offset, len);
                return;
            }
        }
        if (this._outputTail + len > this._outputEnd) {
            _flushBuffer();
        }
        System.arraycopy(utf8, offset, this._outputBuffer, this._outputTail, len);
        this._outputTail += len;
        ptr = ptr2;
    }

    private void _writeUTF8Segment2(byte[] utf8, int offset, int len) throws IOException, JsonGenerationException {
        int outputPtr = this._outputTail;
        if ((len * 6) + outputPtr > this._outputEnd) {
            _flushBuffer();
            outputPtr = this._outputTail;
        }
        byte[] outputBuffer = this._outputBuffer;
        int[] escCodes = this._outputEscapes;
        len += offset;
        int outputPtr2 = outputPtr;
        int offset2 = offset;
        while (offset2 < len) {
            offset = offset2 + 1;
            byte b = utf8[offset2];
            byte ch = b;
            if (ch < (byte) 0 || escCodes[ch] == 0) {
                outputPtr = outputPtr2 + 1;
                outputBuffer[outputPtr2] = b;
                outputPtr2 = outputPtr;
                offset2 = offset;
            } else {
                int escape = escCodes[ch];
                if (escape > 0) {
                    outputPtr = outputPtr2 + 1;
                    outputBuffer[outputPtr2] = BYTE_BACKSLASH;
                    outputPtr2 = outputPtr + 1;
                    outputBuffer[outputPtr] = (byte) escape;
                    outputPtr = outputPtr2;
                } else {
                    outputPtr = _writeGenericEscape(ch, outputPtr2);
                }
                outputPtr2 = outputPtr;
                offset2 = offset;
            }
        }
        this._outputTail = outputPtr2;
    }

    protected void _writeBinary(Base64Variant b64variant, byte[] input, int inputPtr, int inputEnd) throws IOException, JsonGenerationException {
        int safeInputEnd = inputEnd - 3;
        int safeOutputEnd = this._outputEnd - 6;
        int chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
        int inputPtr2 = inputPtr;
        while (inputPtr2 <= safeInputEnd) {
            if (this._outputTail > safeOutputEnd) {
                _flushBuffer();
            }
            inputPtr = inputPtr2 + 1;
            inputPtr2 = inputPtr + 1;
            inputPtr = inputPtr2 + 1;
            this._outputTail = b64variant.encodeBase64Chunk((((input[inputPtr2] << 8) | (input[inputPtr] & 255)) << 8) | (input[inputPtr2] & 255), this._outputBuffer, this._outputTail);
            chunksBeforeLF--;
            if (chunksBeforeLF <= 0) {
                byte[] bArr = this._outputBuffer;
                int i = this._outputTail;
                this._outputTail = i + 1;
                bArr[i] = BYTE_BACKSLASH;
                bArr = this._outputBuffer;
                i = this._outputTail;
                this._outputTail = i + 1;
                bArr[i] = (byte) 110;
                chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
            }
            inputPtr2 = inputPtr;
        }
        int inputLeft = inputEnd - inputPtr2;
        if (inputLeft > 0) {
            if (this._outputTail > safeOutputEnd) {
                _flushBuffer();
            }
            inputPtr = inputPtr2 + 1;
            int b24 = input[inputPtr2] << 16;
            if (inputLeft == 2) {
                b24 |= (input[inputPtr] & 255) << 8;
                inputPtr++;
            }
            this._outputTail = b64variant.encodeBase64Partial(b24, inputLeft, this._outputBuffer, this._outputTail);
            return;
        }
    }

    protected int _writeBinary(Base64Variant b64variant, InputStream data, byte[] readBuffer, int bytesLeft) throws IOException, JsonGenerationException {
        int inputPtr = 0;
        int inputEnd = 0;
        int lastFullOffset = -3;
        int safeOutputEnd = this._outputEnd - 6;
        int chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
        while (bytesLeft > 2) {
            if (inputPtr > lastFullOffset) {
                inputEnd = _readMore(data, readBuffer, inputPtr, inputEnd, bytesLeft);
                inputPtr = 0;
                if (inputEnd < 3) {
                    break;
                }
                lastFullOffset = inputEnd - 3;
            }
            if (this._outputTail > safeOutputEnd) {
                _flushBuffer();
            }
            int inputPtr2 = inputPtr + 1;
            inputPtr = inputPtr2 + 1;
            inputPtr2 = inputPtr + 1;
            bytesLeft -= 3;
            this._outputTail = b64variant.encodeBase64Chunk((((readBuffer[inputPtr] << 8) | (readBuffer[inputPtr2] & 255)) << 8) | (readBuffer[inputPtr] & 255), this._outputBuffer, this._outputTail);
            chunksBeforeLF--;
            if (chunksBeforeLF <= 0) {
                byte[] bArr = this._outputBuffer;
                int i = this._outputTail;
                this._outputTail = i + 1;
                bArr[i] = BYTE_BACKSLASH;
                bArr = this._outputBuffer;
                i = this._outputTail;
                this._outputTail = i + 1;
                bArr[i] = (byte) 110;
                chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
            }
            inputPtr = inputPtr2;
        }
        if (bytesLeft <= 0) {
            return bytesLeft;
        }
        inputEnd = _readMore(data, readBuffer, inputPtr, inputEnd, bytesLeft);
        if (inputEnd <= 0) {
            return bytesLeft;
        }
        int amount;
        if (this._outputTail > safeOutputEnd) {
            _flushBuffer();
        }
        inputPtr2 = 0 + 1;
        int b24 = readBuffer[0] << 16;
        if (inputPtr2 < inputEnd) {
            b24 |= (readBuffer[inputPtr2] & 255) << 8;
            amount = 2;
        } else {
            amount = 1;
        }
        this._outputTail = b64variant.encodeBase64Partial(b24, amount, this._outputBuffer, this._outputTail);
        inputPtr = inputPtr2;
        return bytesLeft - amount;
    }

    protected int _writeBinary(Base64Variant b64variant, InputStream data, byte[] readBuffer) throws IOException, JsonGenerationException {
        int inputPtr = 0;
        int inputEnd = 0;
        int lastFullOffset = -3;
        int bytesDone = 0;
        int safeOutputEnd = this._outputEnd - 6;
        int chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
        while (true) {
            if (inputPtr > lastFullOffset) {
                inputEnd = _readMore(data, readBuffer, inputPtr, inputEnd, readBuffer.length);
                inputPtr = 0;
                if (inputEnd < 3) {
                    break;
                }
                lastFullOffset = inputEnd - 3;
            }
            if (this._outputTail > safeOutputEnd) {
                _flushBuffer();
            }
            int inputPtr2 = inputPtr + 1;
            inputPtr = inputPtr2 + 1;
            inputPtr2 = inputPtr + 1;
            bytesDone += 3;
            this._outputTail = b64variant.encodeBase64Chunk((((readBuffer[inputPtr] << 8) | (readBuffer[inputPtr2] & 255)) << 8) | (readBuffer[inputPtr] & 255), this._outputBuffer, this._outputTail);
            chunksBeforeLF--;
            if (chunksBeforeLF <= 0) {
                byte[] bArr = this._outputBuffer;
                int i = this._outputTail;
                this._outputTail = i + 1;
                bArr[i] = BYTE_BACKSLASH;
                bArr = this._outputBuffer;
                i = this._outputTail;
                this._outputTail = i + 1;
                bArr[i] = (byte) 110;
                chunksBeforeLF = b64variant.getMaxLineLength() >> 2;
            }
            inputPtr = inputPtr2;
        }
        if (0 >= inputEnd) {
            return bytesDone;
        }
        if (this._outputTail > safeOutputEnd) {
            _flushBuffer();
        }
        inputPtr2 = 0 + 1;
        int b24 = readBuffer[0] << 16;
        int amount = 1;
        if (inputPtr2 < inputEnd) {
            b24 |= (readBuffer[inputPtr2] & 255) << 8;
            amount = 2;
        }
        bytesDone += amount;
        this._outputTail = b64variant.encodeBase64Partial(b24, amount, this._outputBuffer, this._outputTail);
        inputPtr = inputPtr2;
        return bytesDone;
    }

    private int _readMore(InputStream in, byte[] readBuffer, int inputPtr, int inputEnd, int maxRead) throws IOException {
        int i = 0;
        int inputPtr2 = inputPtr;
        while (inputPtr2 < inputEnd) {
            int i2 = i + 1;
            inputPtr = inputPtr2 + 1;
            readBuffer[i] = readBuffer[inputPtr2];
            i = i2;
            inputPtr2 = inputPtr;
        }
        inputEnd = i;
        maxRead = Math.min(maxRead, readBuffer.length);
        do {
            int count = in.read(readBuffer, inputEnd, maxRead - inputEnd);
            if (count < 0) {
                return inputEnd;
            }
            inputEnd += count;
        } while (inputEnd < 3);
        return inputEnd;
    }

    private int _outputRawMultiByteChar(int ch, char[] cbuf, int inputOffset, int inputLen) throws IOException {
        if (ch < SURR1_FIRST || ch > SURR2_LAST) {
            byte[] bbuf = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            bbuf[i] = (byte) ((ch >> 12) | 224);
            i = this._outputTail;
            this._outputTail = i + 1;
            bbuf[i] = (byte) (((ch >> 6) & 63) | 128);
            i = this._outputTail;
            this._outputTail = i + 1;
            bbuf[i] = (byte) ((ch & 63) | 128);
            return inputOffset;
        }
        if (inputOffset >= inputLen) {
            _reportError("Split surrogate on writeRaw() input (last character)");
        }
        _outputSurrogates(ch, cbuf[inputOffset]);
        return inputOffset + 1;
    }

    protected final void _outputSurrogates(int surr1, int surr2) throws IOException {
        int c = _decodeSurrogate(surr1, surr2);
        if (this._outputTail + 4 > this._outputEnd) {
            _flushBuffer();
        }
        byte[] bbuf = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        bbuf[i] = (byte) ((c >> 18) | 240);
        i = this._outputTail;
        this._outputTail = i + 1;
        bbuf[i] = (byte) (((c >> 12) & 63) | 128);
        i = this._outputTail;
        this._outputTail = i + 1;
        bbuf[i] = (byte) (((c >> 6) & 63) | 128);
        i = this._outputTail;
        this._outputTail = i + 1;
        bbuf[i] = (byte) ((c & 63) | 128);
    }

    private int _outputMultiByteChar(int ch, int outputPtr) throws IOException {
        byte[] bbuf = this._outputBuffer;
        if (ch < SURR1_FIRST || ch > SURR2_LAST) {
            int i = outputPtr + 1;
            bbuf[outputPtr] = (byte) ((ch >> 12) | 224);
            outputPtr = i + 1;
            bbuf[i] = (byte) (((ch >> 6) & 63) | 128);
            i = outputPtr + 1;
            bbuf[outputPtr] = (byte) ((ch & 63) | 128);
            return i;
        }
        i = outputPtr + 1;
        bbuf[outputPtr] = BYTE_BACKSLASH;
        outputPtr = i + 1;
        bbuf[i] = BYTE_u;
        i = outputPtr + 1;
        bbuf[outputPtr] = HEX_CHARS[(ch >> 12) & 15];
        outputPtr = i + 1;
        bbuf[i] = HEX_CHARS[(ch >> 8) & 15];
        i = outputPtr + 1;
        bbuf[outputPtr] = HEX_CHARS[(ch >> 4) & 15];
        outputPtr = i + 1;
        bbuf[i] = HEX_CHARS[ch & 15];
        return outputPtr;
    }

    protected final int _decodeSurrogate(int surr1, int surr2) throws IOException {
        if (surr2 < SURR2_FIRST || surr2 > SURR2_LAST) {
            _reportError("Incomplete surrogate pair: first char 0x" + Integer.toHexString(surr1) + ", second 0x" + Integer.toHexString(surr2));
        }
        return (65536 + ((surr1 - SURR1_FIRST) << 10)) + (surr2 - SURR2_FIRST);
    }

    private void _writeNull() throws IOException {
        if (this._outputTail + 4 >= this._outputEnd) {
            _flushBuffer();
        }
        System.arraycopy(NULL_BYTES, 0, this._outputBuffer, this._outputTail, 4);
        this._outputTail += 4;
    }

    private int _writeGenericEscape(int charToEscape, int outputPtr) throws IOException {
        byte[] bbuf = this._outputBuffer;
        int i = outputPtr + 1;
        bbuf[outputPtr] = BYTE_BACKSLASH;
        outputPtr = i + 1;
        bbuf[i] = BYTE_u;
        if (charToEscape > 255) {
            int hi = (charToEscape >> 8) & 255;
            i = outputPtr + 1;
            bbuf[outputPtr] = HEX_CHARS[hi >> 4];
            outputPtr = i + 1;
            bbuf[i] = HEX_CHARS[hi & 15];
            charToEscape &= 255;
        } else {
            i = outputPtr + 1;
            bbuf[outputPtr] = BYTE_0;
            outputPtr = i + 1;
            bbuf[i] = BYTE_0;
        }
        i = outputPtr + 1;
        bbuf[outputPtr] = HEX_CHARS[charToEscape >> 4];
        outputPtr = i + 1;
        bbuf[i] = HEX_CHARS[charToEscape & 15];
        return outputPtr;
    }

    protected final void _flushBuffer() throws IOException {
        int len = this._outputTail;
        if (len > 0) {
            this._outputTail = 0;
            this._outputStream.write(this._outputBuffer, 0, len);
        }
    }
}
