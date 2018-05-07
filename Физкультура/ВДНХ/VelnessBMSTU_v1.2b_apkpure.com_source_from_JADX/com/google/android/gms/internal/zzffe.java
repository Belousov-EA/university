package com.google.android.gms.internal;

import android.support.v4.media.TransportMediator;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

final class zzffe extends zzffb {
    private final byte[] buffer;
    private int pos;
    private int zzpfr;
    private int zzpft;
    private int zzpfu;
    private final InputStream zzpfv;
    private int zzpfw;
    private int zzpfx;
    private zzfff zzpfy;

    private zzffe(InputStream inputStream, int i) {
        super();
        this.zzpfu = Integer.MAX_VALUE;
        this.zzpfy = null;
        zzffz.zzc(inputStream, "input");
        this.zzpfv = inputStream;
        this.buffer = new byte[i];
        this.zzpfw = 0;
        this.pos = 0;
        this.zzpfx = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzcwn() throws java.io.IOException {
        /*
        r10 = this;
        r8 = 0;
        r0 = r10.pos;
        r1 = r10.zzpfw;
        if (r1 == r0) goto L_0x00b4;
    L_0x0008:
        r4 = r10.buffer;
        r1 = r0 + 1;
        r0 = r4[r0];
        if (r0 < 0) goto L_0x0014;
    L_0x0010:
        r10.pos = r1;
        r0 = (long) r0;
    L_0x0013:
        return r0;
    L_0x0014:
        r2 = r10.zzpfw;
        r2 = r2 - r1;
        r3 = 9;
        if (r2 < r3) goto L_0x00b4;
    L_0x001b:
        r2 = r1 + 1;
        r1 = r4[r1];
        r1 = r1 << 7;
        r0 = r0 ^ r1;
        if (r0 >= 0) goto L_0x002a;
    L_0x0024:
        r0 = r0 ^ -128;
        r0 = (long) r0;
    L_0x0027:
        r10.pos = r2;
        goto L_0x0013;
    L_0x002a:
        r3 = r2 + 1;
        r1 = r4[r2];
        r1 = r1 << 14;
        r0 = r0 ^ r1;
        if (r0 < 0) goto L_0x0038;
    L_0x0033:
        r0 = r0 ^ 16256;
        r0 = (long) r0;
        r2 = r3;
        goto L_0x0027;
    L_0x0038:
        r2 = r3 + 1;
        r1 = r4[r3];
        r1 = r1 << 21;
        r0 = r0 ^ r1;
        if (r0 >= 0) goto L_0x0047;
    L_0x0041:
        r1 = -2080896; // 0xffffffffffe03f80 float:NaN double:NaN;
        r0 = r0 ^ r1;
        r0 = (long) r0;
        goto L_0x0027;
    L_0x0047:
        r0 = (long) r0;
        r3 = r2 + 1;
        r2 = r4[r2];
        r6 = (long) r2;
        r2 = 28;
        r6 = r6 << r2;
        r0 = r0 ^ r6;
        r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r2 < 0) goto L_0x005b;
    L_0x0055:
        r4 = 266354560; // 0xfe03f80 float:2.2112565E-29 double:1.315966377E-315;
        r0 = r0 ^ r4;
        r2 = r3;
        goto L_0x0027;
    L_0x005b:
        r2 = r3 + 1;
        r3 = r4[r3];
        r6 = (long) r3;
        r3 = 35;
        r6 = r6 << r3;
        r0 = r0 ^ r6;
        r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r3 >= 0) goto L_0x006f;
    L_0x0068:
        r4 = -34093383808; // 0xfffffff80fe03f80 float:2.2112565E-29 double:NaN;
        r0 = r0 ^ r4;
        goto L_0x0027;
    L_0x006f:
        r3 = r2 + 1;
        r2 = r4[r2];
        r6 = (long) r2;
        r2 = 42;
        r6 = r6 << r2;
        r0 = r0 ^ r6;
        r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r2 < 0) goto L_0x0084;
    L_0x007c:
        r4 = 4363953127296; // 0x3f80fe03f80 float:2.2112565E-29 double:2.1560793202584E-311;
        r0 = r0 ^ r4;
        r2 = r3;
        goto L_0x0027;
    L_0x0084:
        r2 = r3 + 1;
        r3 = r4[r3];
        r6 = (long) r3;
        r3 = 49;
        r6 = r6 << r3;
        r0 = r0 ^ r6;
        r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r3 >= 0) goto L_0x0098;
    L_0x0091:
        r4 = -558586000294016; // 0xfffe03f80fe03f80 float:2.2112565E-29 double:NaN;
        r0 = r0 ^ r4;
        goto L_0x0027;
    L_0x0098:
        r3 = r2 + 1;
        r2 = r4[r2];
        r6 = (long) r2;
        r2 = 56;
        r6 = r6 << r2;
        r0 = r0 ^ r6;
        r6 = 71499008037633920; // 0xfe03f80fe03f80 float:2.2112565E-29 double:6.838959413692434E-304;
        r0 = r0 ^ r6;
        r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r2 >= 0) goto L_0x00ba;
    L_0x00ab:
        r2 = r3 + 1;
        r3 = r4[r3];
        r4 = (long) r3;
        r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r3 >= 0) goto L_0x0027;
    L_0x00b4:
        r0 = r10.zzcwj();
        goto L_0x0013;
    L_0x00ba:
        r2 = r3;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzffe.zzcwn():long");
    }

    private final int zzcwo() throws IOException {
        int i = this.pos;
        if (this.zzpfw - i < 4) {
            zzkw(4);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16));
    }

    private final long zzcwp() throws IOException {
        int i = this.pos;
        if (this.zzpfw - i < 8) {
            zzkw(8);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((((((((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8)) | ((((long) bArr[i + 2]) & 255) << 16)) | ((((long) bArr[i + 3]) & 255) << 24)) | ((((long) bArr[i + 4]) & 255) << 32)) | ((((long) bArr[i + 5]) & 255) << 40)) | ((((long) bArr[i + 6]) & 255) << 48));
    }

    private final void zzcwq() {
        this.zzpfw += this.zzpfr;
        int i = this.zzpfx + this.zzpfw;
        if (i > this.zzpfu) {
            this.zzpfr = i - this.zzpfu;
            this.zzpfw -= this.zzpfr;
            return;
        }
        this.zzpfr = 0;
    }

    private final byte zzcwr() throws IOException {
        if (this.pos == this.zzpfw) {
            zzkw(1);
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    private final void zzkw(int i) throws IOException {
        if (!zzkx(i)) {
            if (i > (this.zzpfo - this.zzpfx) - this.pos) {
                throw zzfge.zzcyh();
            }
            throw zzfge.zzcya();
        }
    }

    private final boolean zzkx(int i) throws IOException {
        while (this.pos + i > this.zzpfw) {
            if (i > (this.zzpfo - this.zzpfx) - this.pos || (this.zzpfx + this.pos) + i > this.zzpfu) {
                return false;
            }
            int i2 = this.pos;
            if (i2 > 0) {
                if (this.zzpfw > i2) {
                    System.arraycopy(this.buffer, i2, this.buffer, 0, this.zzpfw - i2);
                }
                this.zzpfx += i2;
                this.zzpfw -= i2;
                this.pos = 0;
            }
            i2 = this.zzpfv.read(this.buffer, this.zzpfw, Math.min(this.buffer.length - this.zzpfw, (this.zzpfo - this.zzpfx) - this.zzpfw));
            if (i2 == 0 || i2 < -1 || i2 > this.buffer.length) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + i2 + "\nThe InputStream implementation is buggy.");
            } else if (i2 <= 0) {
                return false;
            } else {
                this.zzpfw = i2 + this.zzpfw;
                zzcwq();
                if (this.zzpfw >= i) {
                    return true;
                }
            }
        }
        throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
    }

    private final byte[] zzky(int i) throws IOException {
        byte[] zzkz = zzkz(i);
        if (zzkz != null) {
            return zzkz;
        }
        int i2 = this.pos;
        int i3 = this.zzpfw - this.pos;
        this.zzpfx += this.zzpfw;
        this.pos = 0;
        this.zzpfw = 0;
        List<byte[]> zzla = zzla(i - i3);
        Object obj = new byte[i];
        System.arraycopy(this.buffer, i2, obj, 0, i3);
        i2 = i3;
        for (byte[] zzkz2 : zzla) {
            System.arraycopy(zzkz2, 0, obj, i2, zzkz2.length);
            i2 = zzkz2.length + i2;
        }
        return obj;
    }

    private final byte[] zzkz(int i) throws IOException {
        if (i == 0) {
            return zzffz.EMPTY_BYTE_ARRAY;
        }
        if (i < 0) {
            throw zzfge.zzcyb();
        }
        int i2 = (this.zzpfx + this.pos) + i;
        if (i2 - this.zzpfo > 0) {
            throw zzfge.zzcyh();
        } else if (i2 > this.zzpfu) {
            zzku((this.zzpfu - this.zzpfx) - this.pos);
            throw zzfge.zzcya();
        } else {
            i2 = this.zzpfw - this.pos;
            int i3 = i - i2;
            if (i3 >= 4096 && i3 > this.zzpfv.available()) {
                return null;
            }
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.pos, obj, 0, i2);
            this.zzpfx += this.zzpfw;
            this.pos = 0;
            this.zzpfw = 0;
            while (i2 < obj.length) {
                int read = this.zzpfv.read(obj, i2, i - i2);
                if (read == -1) {
                    throw zzfge.zzcya();
                }
                this.zzpfx += read;
                i2 += read;
            }
            return obj;
        }
    }

    private final List<byte[]> zzla(int i) throws IOException {
        List<byte[]> arrayList = new ArrayList();
        while (i > 0) {
            Object obj = new byte[Math.min(i, 4096)];
            int i2 = 0;
            while (i2 < obj.length) {
                int read = this.zzpfv.read(obj, i2, obj.length - i2);
                if (read == -1) {
                    throw zzfge.zzcya();
                }
                this.zzpfx += read;
                i2 += read;
            }
            i -= obj.length;
            arrayList.add(obj);
        }
        return arrayList;
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzcwp());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzcwo());
    }

    public final String readString() throws IOException {
        int zzcwi = zzcwi();
        String str;
        if (zzcwi > 0 && zzcwi <= this.zzpfw - this.pos) {
            str = new String(this.buffer, this.pos, zzcwi, zzffz.UTF_8);
            this.pos = zzcwi + this.pos;
            return str;
        } else if (zzcwi == 0) {
            return "";
        } else {
            if (zzcwi > this.zzpfw) {
                return new String(zzky(zzcwi), zzffz.UTF_8);
            }
            zzkw(zzcwi);
            str = new String(this.buffer, this.pos, zzcwi, zzffz.UTF_8);
            this.pos = zzcwi + this.pos;
            return str;
        }
    }

    public final <T extends zzffu<T, ?>> T zza(T t, zzffm com_google_android_gms_internal_zzffm) throws IOException {
        int zzcwi = zzcwi();
        if (this.zzpfm >= this.zzpfn) {
            throw zzfge.zzcyg();
        }
        zzcwi = zzks(zzcwi);
        this.zzpfm++;
        T zza = zzffu.zza((zzffu) t, (zzffb) this, com_google_android_gms_internal_zzffm);
        zzkp(0);
        this.zzpfm--;
        zzkt(zzcwi);
        return zza;
    }

    public final void zza(zzfhf com_google_android_gms_internal_zzfhf, zzffm com_google_android_gms_internal_zzffm) throws IOException {
        int zzcwi = zzcwi();
        if (this.zzpfm >= this.zzpfn) {
            throw zzfge.zzcyg();
        }
        zzcwi = zzks(zzcwi);
        this.zzpfm++;
        com_google_android_gms_internal_zzfhf.zzb(this, com_google_android_gms_internal_zzffm);
        zzkp(0);
        this.zzpfm--;
        zzkt(zzcwi);
    }

    public final int zzcvt() throws IOException {
        if (zzcwl()) {
            this.zzpft = 0;
            return 0;
        }
        this.zzpft = zzcwi();
        if ((this.zzpft >>> 3) != 0) {
            return this.zzpft;
        }
        throw zzfge.zzcyd();
    }

    public final long zzcvu() throws IOException {
        return zzcwn();
    }

    public final long zzcvv() throws IOException {
        return zzcwn();
    }

    public final int zzcvw() throws IOException {
        return zzcwi();
    }

    public final long zzcvx() throws IOException {
        return zzcwp();
    }

    public final int zzcvy() throws IOException {
        return zzcwo();
    }

    public final boolean zzcvz() throws IOException {
        return zzcwn() != 0;
    }

    public final String zzcwa() throws IOException {
        byte[] bArr;
        int zzcwi = zzcwi();
        int i = this.pos;
        if (zzcwi <= this.zzpfw - i && zzcwi > 0) {
            bArr = this.buffer;
            this.pos = i + zzcwi;
        } else if (zzcwi == 0) {
            return "";
        } else {
            if (zzcwi <= this.zzpfw) {
                zzkw(zzcwi);
                byte[] bArr2 = this.buffer;
                this.pos = zzcwi;
                bArr = bArr2;
                i = 0;
            } else {
                bArr = zzky(zzcwi);
                i = 0;
            }
        }
        if (zzfis.zzk(bArr, i, i + zzcwi)) {
            return new String(bArr, i, zzcwi, zzffz.UTF_8);
        }
        throw zzfge.zzcyi();
    }

    public final zzfes zzcwb() throws IOException {
        int zzcwi = zzcwi();
        if (zzcwi <= this.zzpfw - this.pos && zzcwi > 0) {
            zzfes zze = zzfes.zze(this.buffer, this.pos, zzcwi);
            this.pos = zzcwi + this.pos;
            return zze;
        } else if (zzcwi == 0) {
            return zzfes.zzpfg;
        } else {
            byte[] zzkz = zzkz(zzcwi);
            if (zzkz != null) {
                return zzfes.zzba(zzkz);
            }
            int i = this.pos;
            int i2 = this.zzpfw - this.pos;
            this.zzpfx += this.zzpfw;
            this.pos = 0;
            this.zzpfw = 0;
            List<byte[]> zzla = zzla(zzcwi - i2);
            Iterable arrayList = new ArrayList(zzla.size() + 1);
            arrayList.add(zzfes.zze(this.buffer, i, i2));
            for (byte[] zzkz2 : zzla) {
                arrayList.add(zzfes.zzba(zzkz2));
            }
            return zzfes.zzf(arrayList);
        }
    }

    public final int zzcwc() throws IOException {
        return zzcwi();
    }

    public final int zzcwd() throws IOException {
        return zzcwi();
    }

    public final int zzcwe() throws IOException {
        return zzcwo();
    }

    public final long zzcwf() throws IOException {
        return zzcwp();
    }

    public final int zzcwg() throws IOException {
        return zzffb.zzkv(zzcwi());
    }

    public final long zzcwh() throws IOException {
        return zzffb.zzcs(zzcwn());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzcwi() throws java.io.IOException {
        /*
        r5 = this;
        r0 = r5.pos;
        r1 = r5.zzpfw;
        if (r1 == r0) goto L_0x006c;
    L_0x0006:
        r3 = r5.buffer;
        r2 = r0 + 1;
        r0 = r3[r0];
        if (r0 < 0) goto L_0x0011;
    L_0x000e:
        r5.pos = r2;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = r5.zzpfw;
        r1 = r1 - r2;
        r4 = 9;
        if (r1 < r4) goto L_0x006c;
    L_0x0018:
        r1 = r2 + 1;
        r2 = r3[r2];
        r2 = r2 << 7;
        r0 = r0 ^ r2;
        if (r0 >= 0) goto L_0x0026;
    L_0x0021:
        r0 = r0 ^ -128;
    L_0x0023:
        r5.pos = r1;
        goto L_0x0010;
    L_0x0026:
        r2 = r1 + 1;
        r1 = r3[r1];
        r1 = r1 << 14;
        r0 = r0 ^ r1;
        if (r0 < 0) goto L_0x0033;
    L_0x002f:
        r0 = r0 ^ 16256;
        r1 = r2;
        goto L_0x0023;
    L_0x0033:
        r1 = r2 + 1;
        r2 = r3[r2];
        r2 = r2 << 21;
        r0 = r0 ^ r2;
        if (r0 >= 0) goto L_0x0041;
    L_0x003c:
        r2 = -2080896; // 0xffffffffffe03f80 float:NaN double:NaN;
        r0 = r0 ^ r2;
        goto L_0x0023;
    L_0x0041:
        r2 = r1 + 1;
        r1 = r3[r1];
        r4 = r1 << 28;
        r0 = r0 ^ r4;
        r4 = 266354560; // 0xfe03f80 float:2.2112565E-29 double:1.315966377E-315;
        r0 = r0 ^ r4;
        if (r1 >= 0) goto L_0x0072;
    L_0x004e:
        r1 = r2 + 1;
        r2 = r3[r2];
        if (r2 >= 0) goto L_0x0023;
    L_0x0054:
        r2 = r1 + 1;
        r1 = r3[r1];
        if (r1 >= 0) goto L_0x0072;
    L_0x005a:
        r1 = r2 + 1;
        r2 = r3[r2];
        if (r2 >= 0) goto L_0x0023;
    L_0x0060:
        r2 = r1 + 1;
        r1 = r3[r1];
        if (r1 >= 0) goto L_0x0072;
    L_0x0066:
        r1 = r2 + 1;
        r2 = r3[r2];
        if (r2 >= 0) goto L_0x0023;
    L_0x006c:
        r0 = r5.zzcwj();
        r0 = (int) r0;
        goto L_0x0010;
    L_0x0072:
        r1 = r2;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzffe.zzcwi():int");
    }

    final long zzcwj() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzcwr = zzcwr();
            j |= ((long) (zzcwr & TransportMediator.KEYCODE_MEDIA_PAUSE)) << i;
            if ((zzcwr & 128) == 0) {
                return j;
            }
        }
        throw zzfge.zzcyc();
    }

    public final int zzcwk() {
        if (this.zzpfu == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zzpfu - (this.zzpfx + this.pos);
    }

    public final boolean zzcwl() throws IOException {
        return this.pos == this.zzpfw && !zzkx(1);
    }

    public final int zzcwm() {
        return this.zzpfx + this.pos;
    }

    public final void zzkp(int i) throws zzfge {
        if (this.zzpft != i) {
            throw zzfge.zzcye();
        }
    }

    public final boolean zzkq(int i) throws IOException {
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.zzpfw - this.pos >= 10) {
                    while (i2 < 10) {
                        byte[] bArr = this.buffer;
                        int i3 = this.pos;
                        this.pos = i3 + 1;
                        if (bArr[i3] >= (byte) 0) {
                            return true;
                        }
                        i2++;
                    }
                    throw zzfge.zzcyc();
                }
                while (i2 < 10) {
                    if (zzcwr() >= (byte) 0) {
                        return true;
                    }
                    i2++;
                }
                throw zzfge.zzcyc();
            case 1:
                zzku(8);
                return true;
            case 2:
                zzku(zzcwi());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzku(4);
                return true;
            default:
                throw zzfge.zzcyf();
        }
        do {
            i2 = zzcvt();
            if (i2 != 0) {
            }
            zzkp(((i >>> 3) << 3) | 4);
            return true;
        } while (zzkq(i2));
        zzkp(((i >>> 3) << 3) | 4);
        return true;
    }

    public final int zzks(int i) throws zzfge {
        if (i < 0) {
            throw zzfge.zzcyb();
        }
        int i2 = (this.zzpfx + this.pos) + i;
        int i3 = this.zzpfu;
        if (i2 > i3) {
            throw zzfge.zzcya();
        }
        this.zzpfu = i2;
        zzcwq();
        return i3;
    }

    public final void zzkt(int i) {
        this.zzpfu = i;
        zzcwq();
    }

    public final void zzku(int i) throws IOException {
        if (i <= this.zzpfw - this.pos && i >= 0) {
            this.pos += i;
        } else if (i < 0) {
            throw zzfge.zzcyb();
        } else if ((this.zzpfx + this.pos) + i > this.zzpfu) {
            zzku((this.zzpfu - this.zzpfx) - this.pos);
            throw zzfge.zzcya();
        } else {
            int i2 = this.zzpfw - this.pos;
            this.pos = this.zzpfw;
            zzkw(1);
            while (i - i2 > this.zzpfw) {
                i2 += this.zzpfw;
                this.pos = this.zzpfw;
                zzkw(1);
            }
            this.pos = i - i2;
        }
    }
}
