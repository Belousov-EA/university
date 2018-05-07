package com.google.android.gms.internal;

import com.google.common.base.Ascii;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;

final class zzeld {
    private zzekz zzndt = null;
    private DataInputStream zzneo = null;
    private zzeku zznep = null;
    private byte[] zzneq = new byte[112];
    private zzekp zzner;
    private volatile boolean zznes = false;

    zzeld(zzeku com_google_android_gms_internal_zzeku) {
        this.zznep = com_google_android_gms_internal_zzeku;
    }

    private final int read(byte[] bArr, int i, int i2) throws IOException {
        this.zzneo.readFully(bArr, i, i2);
        return i2;
    }

    private final void zzc(zzela com_google_android_gms_internal_zzela) {
        this.zznes = true;
        this.zznep.zzb(com_google_android_gms_internal_zzela);
    }

    final void run() {
        this.zzndt = this.zznep.zzcat();
        while (!this.zznes) {
            try {
                int read = read(this.zzneq, 0, 1) + 0;
                Object obj = (this.zzneq[0] & 128) != 0 ? 1 : null;
                if (((this.zzneq[0] & 112) != 0 ? 1 : null) != null) {
                    throw new zzela("Invalid frame received");
                }
                byte b = (byte) (this.zzneq[0] & 15);
                int read2 = read + read(this.zzneq, read, 1);
                byte b2 = this.zzneq[1];
                long j = 0;
                if (b2 < (byte) 126) {
                    j = (long) b2;
                } else if (b2 == (byte) 126) {
                    read(this.zzneq, read2, 2);
                    j = (long) (((this.zzneq[2] & 255) << 8) | (this.zzneq[3] & 255));
                } else if (b2 == Ascii.DEL) {
                    int read3 = read(this.zzneq, read2, 8) + read2;
                    byte[] bArr = this.zzneq;
                    read3 -= 8;
                    j = ((long) (bArr[read3 + 7] & 255)) + (((((((((long) bArr[read3]) << 56) + (((long) (bArr[read3 + 1] & 255)) << 48)) + (((long) (bArr[read3 + 2] & 255)) << 40)) + (((long) (bArr[read3 + 3] & 255)) << 32)) + (((long) (bArr[read3 + 4] & 255)) << 24)) + ((long) ((bArr[read3 + 5] & 255) << 16))) + ((long) ((bArr[read3 + 6] & 255) << 8)));
                }
                byte[] bArr2 = new byte[((int) j)];
                read(bArr2, 0, (int) j);
                if (b == (byte) 8) {
                    this.zznep.zzcau();
                } else if (b == (byte) 10) {
                    continue;
                } else if (b != (byte) 1 && b != (byte) 2 && b != (byte) 9 && b != (byte) 0) {
                    throw new zzela("Unsupported opcode: " + b);
                } else if (b == (byte) 9) {
                    if (obj == null) {
                        throw new zzela("PING must not fragment across frames");
                    } else if (bArr2.length <= 125) {
                        this.zznep.zzaq(bArr2);
                    } else {
                        throw new zzela("PING frame too long");
                    }
                } else if (this.zzner != null && b != (byte) 0) {
                    throw new zzela("Failed to continue outstanding frame");
                } else if (this.zzner == null && b == (byte) 0) {
                    throw new zzela("Received continuing frame, but there's nothing to continue");
                } else {
                    if (this.zzner == null) {
                        this.zzner = b == (byte) 2 ? new zzeko() : new zzekq();
                    }
                    if (!this.zzner.zzao(bArr2)) {
                        throw new zzela("Failed to decode frame");
                    } else if (obj != null) {
                        zzelc zzcar = this.zzner.zzcar();
                        this.zzner = null;
                        if (zzcar == null) {
                            throw new zzela("Failed to decode whole message");
                        }
                        this.zzndt.zza(zzcar);
                    } else {
                        continue;
                    }
                }
            } catch (SocketTimeoutException e) {
            } catch (Throwable e2) {
                zzc(new zzela("IO Error", e2));
            } catch (zzela e3) {
                zzc(e3);
            }
        }
    }

    final void zza(DataInputStream dataInputStream) {
        this.zzneo = dataInputStream;
    }

    final void zzcba() {
        this.zznes = true;
    }
}
