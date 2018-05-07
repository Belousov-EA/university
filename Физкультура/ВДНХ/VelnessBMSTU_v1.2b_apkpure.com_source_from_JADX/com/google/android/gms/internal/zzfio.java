package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzg;
import java.io.IOException;
import java.util.Arrays;

public final class zzfio {
    private static final zzfio zzpkp = new zzfio(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzpfc;
    private int zzpgs;
    private int[] zzpkq;
    private Object[] zzpkr;

    private zzfio() {
        this(0, new int[8], new Object[8], true);
    }

    private zzfio(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzpgs = -1;
        this.count = i;
        this.zzpkq = iArr;
        this.zzpkr = objArr;
        this.zzpfc = z;
    }

    static zzfio zzb(zzfio com_google_android_gms_internal_zzfio, zzfio com_google_android_gms_internal_zzfio2) {
        int i = com_google_android_gms_internal_zzfio.count + com_google_android_gms_internal_zzfio2.count;
        Object copyOf = Arrays.copyOf(com_google_android_gms_internal_zzfio.zzpkq, i);
        System.arraycopy(com_google_android_gms_internal_zzfio2.zzpkq, 0, copyOf, com_google_android_gms_internal_zzfio.count, com_google_android_gms_internal_zzfio2.count);
        Object copyOf2 = Arrays.copyOf(com_google_android_gms_internal_zzfio.zzpkr, i);
        System.arraycopy(com_google_android_gms_internal_zzfio2.zzpkr, 0, copyOf2, com_google_android_gms_internal_zzfio.count, com_google_android_gms_internal_zzfio2.count);
        return new zzfio(i, copyOf, copyOf2, true);
    }

    private void zzc(int i, Object obj) {
        zzczl();
        if (this.count == this.zzpkq.length) {
            int i2 = (this.count < 4 ? 8 : this.count >> 1) + this.count;
            this.zzpkq = Arrays.copyOf(this.zzpkq, i2);
            this.zzpkr = Arrays.copyOf(this.zzpkr, i2);
        }
        this.zzpkq[this.count] = i;
        this.zzpkr[this.count] = obj;
        this.count++;
    }

    private final void zzczl() {
        if (!this.zzpfc) {
            throw new UnsupportedOperationException();
        }
    }

    public static zzfio zzczu() {
        return zzpkp;
    }

    static zzfio zzczv() {
        return new zzfio();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof zzfio)) {
            return false;
        }
        zzfio com_google_android_gms_internal_zzfio = (zzfio) obj;
        if (this.count == com_google_android_gms_internal_zzfio.count) {
            int i;
            boolean z;
            int[] iArr = this.zzpkq;
            int[] iArr2 = com_google_android_gms_internal_zzfio.zzpkq;
            int i2 = this.count;
            for (i = 0; i < i2; i++) {
                if (iArr[i] != iArr2[i]) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                Object[] objArr = this.zzpkr;
                Object[] objArr2 = com_google_android_gms_internal_zzfio.zzpkr;
                i2 = this.count;
                for (i = 0; i < i2; i++) {
                    if (!objArr[i].equals(objArr2[i])) {
                        z = false;
                        break;
                    }
                }
                z = true;
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.count + 527) * 31) + Arrays.hashCode(this.zzpkq)) * 31) + Arrays.deepHashCode(this.zzpkr);
    }

    public final void zza(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        for (int i = 0; i < this.count; i++) {
            int i2 = this.zzpkq[i];
            int i3 = i2 >>> 3;
            switch (i2 & 7) {
                case 0:
                    com_google_android_gms_internal_zzffg.zza(i3, ((Long) this.zzpkr[i]).longValue());
                    break;
                case 1:
                    com_google_android_gms_internal_zzffg.zzb(i3, ((Long) this.zzpkr[i]).longValue());
                    break;
                case 2:
                    com_google_android_gms_internal_zzffg.zza(i3, (zzfes) this.zzpkr[i]);
                    break;
                case 3:
                    com_google_android_gms_internal_zzffg.zzz(i3, 3);
                    ((zzfio) this.zzpkr[i]).zza(com_google_android_gms_internal_zzffg);
                    com_google_android_gms_internal_zzffg.zzz(i3, 4);
                    break;
                case 5:
                    com_google_android_gms_internal_zzffg.zzac(i3, ((Integer) this.zzpkr[i]).intValue());
                    break;
                default:
                    throw zzfge.zzcyf();
            }
        }
    }

    final void zza(zzfji com_google_android_gms_internal_zzfji) {
        int i;
        if (com_google_android_gms_internal_zzfji.zzcwv() == zzg.zzpho) {
            for (i = this.count - 1; i >= 0; i--) {
                com_google_android_gms_internal_zzfji.zzb(this.zzpkq[i] >>> 3, this.zzpkr[i]);
            }
            return;
        }
        for (i = 0; i < this.count; i++) {
            com_google_android_gms_internal_zzfji.zzb(this.zzpkq[i] >>> 3, this.zzpkr[i]);
        }
    }

    final boolean zzb(int i, zzffb com_google_android_gms_internal_zzffb) throws IOException {
        zzczl();
        int i2 = i >>> 3;
        switch (i & 7) {
            case 0:
                zzc(i, Long.valueOf(com_google_android_gms_internal_zzffb.zzcvv()));
                return true;
            case 1:
                zzc(i, Long.valueOf(com_google_android_gms_internal_zzffb.zzcvx()));
                return true;
            case 2:
                zzc(i, com_google_android_gms_internal_zzffb.zzcwb());
                return true;
            case 3:
                zzfio com_google_android_gms_internal_zzfio = new zzfio();
                int zzcvt;
                do {
                    zzcvt = com_google_android_gms_internal_zzffb.zzcvt();
                    if (zzcvt != 0) {
                    }
                    com_google_android_gms_internal_zzffb.zzkp((i2 << 3) | 4);
                    zzc(i, com_google_android_gms_internal_zzfio);
                    return true;
                } while (com_google_android_gms_internal_zzfio.zzb(zzcvt, com_google_android_gms_internal_zzffb));
                com_google_android_gms_internal_zzffb.zzkp((i2 << 3) | 4);
                zzc(i, com_google_android_gms_internal_zzfio);
                return true;
            case 4:
                return false;
            case 5:
                zzc(i, Integer.valueOf(com_google_android_gms_internal_zzffb.zzcvy()));
                return true;
            default:
                throw zzfge.zzcyf();
        }
    }

    public final void zzbiy() {
        this.zzpfc = false;
    }

    public final int zzczw() {
        int i = this.zzpgs;
        if (i == -1) {
            i = 0;
            for (int i2 = 0; i2 < this.count; i2++) {
                i += zzffg.zzd(this.zzpkq[i2] >>> 3, (zzfes) this.zzpkr[i2]);
            }
            this.zzpgs = i;
        }
        return i;
    }

    final void zzd(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzfhh.zzb(stringBuilder, i, String.valueOf(this.zzpkq[i2] >>> 3), this.zzpkr[i2]);
        }
    }

    public final int zzho() {
        int i = this.zzpgs;
        if (i == -1) {
            i = 0;
            for (int i2 = 0; i2 < this.count; i2++) {
                int i3 = this.zzpkq[i2];
                int i4 = i3 >>> 3;
                switch (i3 & 7) {
                    case 0:
                        i += zzffg.zzd(i4, ((Long) this.zzpkr[i2]).longValue());
                        break;
                    case 1:
                        i += zzffg.zze(i4, ((Long) this.zzpkr[i2]).longValue());
                        break;
                    case 2:
                        i += zzffg.zzc(i4, (zzfes) this.zzpkr[i2]);
                        break;
                    case 3:
                        i += ((zzfio) this.zzpkr[i2]).zzho() + (zzffg.zzlg(i4) << 1);
                        break;
                    case 5:
                        i += zzffg.zzaf(i4, ((Integer) this.zzpkr[i2]).intValue());
                        break;
                    default:
                        throw new IllegalStateException(zzfge.zzcyf());
                }
            }
            this.zzpgs = i;
        }
        return i;
    }
}
