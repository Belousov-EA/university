package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfkn extends zzfjm<zzfkn> implements Cloneable {
    private String[] zzpqb;
    private String[] zzpqc;
    private int[] zzpqd;
    private long[] zzpqe;
    private long[] zzpqf;

    public zzfkn() {
        this.zzpqb = zzfjv.EMPTY_STRING_ARRAY;
        this.zzpqc = zzfjv.EMPTY_STRING_ARRAY;
        this.zzpqd = zzfjv.zzpnp;
        this.zzpqe = zzfjv.zzpnq;
        this.zzpqf = zzfjv.zzpnq;
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    private zzfkn zzdaw() {
        try {
            zzfkn com_google_android_gms_internal_zzfkn = (zzfkn) super.zzdaf();
            if (this.zzpqb != null && this.zzpqb.length > 0) {
                com_google_android_gms_internal_zzfkn.zzpqb = (String[]) this.zzpqb.clone();
            }
            if (this.zzpqc != null && this.zzpqc.length > 0) {
                com_google_android_gms_internal_zzfkn.zzpqc = (String[]) this.zzpqc.clone();
            }
            if (this.zzpqd != null && this.zzpqd.length > 0) {
                com_google_android_gms_internal_zzfkn.zzpqd = (int[]) this.zzpqd.clone();
            }
            if (this.zzpqe != null && this.zzpqe.length > 0) {
                com_google_android_gms_internal_zzfkn.zzpqe = (long[]) this.zzpqe.clone();
            }
            if (this.zzpqf != null && this.zzpqf.length > 0) {
                com_google_android_gms_internal_zzfkn.zzpqf = (long[]) this.zzpqf.clone();
            }
            return com_google_android_gms_internal_zzfkn;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzdaw();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfkn)) {
            return false;
        }
        zzfkn com_google_android_gms_internal_zzfkn = (zzfkn) obj;
        return !zzfjq.equals(this.zzpqb, com_google_android_gms_internal_zzfkn.zzpqb) ? false : !zzfjq.equals(this.zzpqc, com_google_android_gms_internal_zzfkn.zzpqc) ? false : !zzfjq.equals(this.zzpqd, com_google_android_gms_internal_zzfkn.zzpqd) ? false : !zzfjq.equals(this.zzpqe, com_google_android_gms_internal_zzfkn.zzpqe) ? false : !zzfjq.equals(this.zzpqf, com_google_android_gms_internal_zzfkn.zzpqf) ? false : (this.zzpnc == null || this.zzpnc.isEmpty()) ? com_google_android_gms_internal_zzfkn.zzpnc == null || com_google_android_gms_internal_zzfkn.zzpnc.isEmpty() : this.zzpnc.equals(com_google_android_gms_internal_zzfkn.zzpnc);
    }

    public final int hashCode() {
        int hashCode = (((((((((((getClass().getName().hashCode() + 527) * 31) + zzfjq.hashCode(this.zzpqb)) * 31) + zzfjq.hashCode(this.zzpqc)) * 31) + zzfjq.hashCode(this.zzpqd)) * 31) + zzfjq.hashCode(this.zzpqe)) * 31) + zzfjq.hashCode(this.zzpqf)) * 31;
        int hashCode2 = (this.zzpnc == null || this.zzpnc.isEmpty()) ? 0 : this.zzpnc.hashCode();
        return hashCode2 + hashCode;
    }

    public final /* synthetic */ zzfjs zza(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int zzcvt = com_google_android_gms_internal_zzfjj.zzcvt();
            int zzb;
            Object obj;
            int zzks;
            Object obj2;
            switch (zzcvt) {
                case 0:
                    break;
                case 10:
                    zzb = zzfjv.zzb(com_google_android_gms_internal_zzfjj, 10);
                    zzcvt = this.zzpqb == null ? 0 : this.zzpqb.length;
                    obj = new String[(zzb + zzcvt)];
                    if (zzcvt != 0) {
                        System.arraycopy(this.zzpqb, 0, obj, 0, zzcvt);
                    }
                    while (zzcvt < obj.length - 1) {
                        obj[zzcvt] = com_google_android_gms_internal_zzfjj.readString();
                        com_google_android_gms_internal_zzfjj.zzcvt();
                        zzcvt++;
                    }
                    obj[zzcvt] = com_google_android_gms_internal_zzfjj.readString();
                    this.zzpqb = obj;
                    continue;
                case 18:
                    zzb = zzfjv.zzb(com_google_android_gms_internal_zzfjj, 18);
                    zzcvt = this.zzpqc == null ? 0 : this.zzpqc.length;
                    obj = new String[(zzb + zzcvt)];
                    if (zzcvt != 0) {
                        System.arraycopy(this.zzpqc, 0, obj, 0, zzcvt);
                    }
                    while (zzcvt < obj.length - 1) {
                        obj[zzcvt] = com_google_android_gms_internal_zzfjj.readString();
                        com_google_android_gms_internal_zzfjj.zzcvt();
                        zzcvt++;
                    }
                    obj[zzcvt] = com_google_android_gms_internal_zzfjj.readString();
                    this.zzpqc = obj;
                    continue;
                case 24:
                    zzb = zzfjv.zzb(com_google_android_gms_internal_zzfjj, 24);
                    zzcvt = this.zzpqd == null ? 0 : this.zzpqd.length;
                    obj = new int[(zzb + zzcvt)];
                    if (zzcvt != 0) {
                        System.arraycopy(this.zzpqd, 0, obj, 0, zzcvt);
                    }
                    while (zzcvt < obj.length - 1) {
                        obj[zzcvt] = com_google_android_gms_internal_zzfjj.zzcvw();
                        com_google_android_gms_internal_zzfjj.zzcvt();
                        zzcvt++;
                    }
                    obj[zzcvt] = com_google_android_gms_internal_zzfjj.zzcvw();
                    this.zzpqd = obj;
                    continue;
                case 26:
                    zzks = com_google_android_gms_internal_zzfjj.zzks(com_google_android_gms_internal_zzfjj.zzcwi());
                    zzb = com_google_android_gms_internal_zzfjj.getPosition();
                    zzcvt = 0;
                    while (com_google_android_gms_internal_zzfjj.zzcwk() > 0) {
                        com_google_android_gms_internal_zzfjj.zzcvw();
                        zzcvt++;
                    }
                    com_google_android_gms_internal_zzfjj.zzmg(zzb);
                    zzb = this.zzpqd == null ? 0 : this.zzpqd.length;
                    obj2 = new int[(zzcvt + zzb)];
                    if (zzb != 0) {
                        System.arraycopy(this.zzpqd, 0, obj2, 0, zzb);
                    }
                    while (zzb < obj2.length) {
                        obj2[zzb] = com_google_android_gms_internal_zzfjj.zzcvw();
                        zzb++;
                    }
                    this.zzpqd = obj2;
                    com_google_android_gms_internal_zzfjj.zzkt(zzks);
                    continue;
                case 32:
                    zzb = zzfjv.zzb(com_google_android_gms_internal_zzfjj, 32);
                    zzcvt = this.zzpqe == null ? 0 : this.zzpqe.length;
                    obj = new long[(zzb + zzcvt)];
                    if (zzcvt != 0) {
                        System.arraycopy(this.zzpqe, 0, obj, 0, zzcvt);
                    }
                    while (zzcvt < obj.length - 1) {
                        obj[zzcvt] = com_google_android_gms_internal_zzfjj.zzcvv();
                        com_google_android_gms_internal_zzfjj.zzcvt();
                        zzcvt++;
                    }
                    obj[zzcvt] = com_google_android_gms_internal_zzfjj.zzcvv();
                    this.zzpqe = obj;
                    continue;
                case 34:
                    zzks = com_google_android_gms_internal_zzfjj.zzks(com_google_android_gms_internal_zzfjj.zzcwi());
                    zzb = com_google_android_gms_internal_zzfjj.getPosition();
                    zzcvt = 0;
                    while (com_google_android_gms_internal_zzfjj.zzcwk() > 0) {
                        com_google_android_gms_internal_zzfjj.zzcvv();
                        zzcvt++;
                    }
                    com_google_android_gms_internal_zzfjj.zzmg(zzb);
                    zzb = this.zzpqe == null ? 0 : this.zzpqe.length;
                    obj2 = new long[(zzcvt + zzb)];
                    if (zzb != 0) {
                        System.arraycopy(this.zzpqe, 0, obj2, 0, zzb);
                    }
                    while (zzb < obj2.length) {
                        obj2[zzb] = com_google_android_gms_internal_zzfjj.zzcvv();
                        zzb++;
                    }
                    this.zzpqe = obj2;
                    com_google_android_gms_internal_zzfjj.zzkt(zzks);
                    continue;
                case 40:
                    zzb = zzfjv.zzb(com_google_android_gms_internal_zzfjj, 40);
                    zzcvt = this.zzpqf == null ? 0 : this.zzpqf.length;
                    obj = new long[(zzb + zzcvt)];
                    if (zzcvt != 0) {
                        System.arraycopy(this.zzpqf, 0, obj, 0, zzcvt);
                    }
                    while (zzcvt < obj.length - 1) {
                        obj[zzcvt] = com_google_android_gms_internal_zzfjj.zzcvv();
                        com_google_android_gms_internal_zzfjj.zzcvt();
                        zzcvt++;
                    }
                    obj[zzcvt] = com_google_android_gms_internal_zzfjj.zzcvv();
                    this.zzpqf = obj;
                    continue;
                case 42:
                    zzks = com_google_android_gms_internal_zzfjj.zzks(com_google_android_gms_internal_zzfjj.zzcwi());
                    zzb = com_google_android_gms_internal_zzfjj.getPosition();
                    zzcvt = 0;
                    while (com_google_android_gms_internal_zzfjj.zzcwk() > 0) {
                        com_google_android_gms_internal_zzfjj.zzcvv();
                        zzcvt++;
                    }
                    com_google_android_gms_internal_zzfjj.zzmg(zzb);
                    zzb = this.zzpqf == null ? 0 : this.zzpqf.length;
                    obj2 = new long[(zzcvt + zzb)];
                    if (zzb != 0) {
                        System.arraycopy(this.zzpqf, 0, obj2, 0, zzb);
                    }
                    while (zzb < obj2.length) {
                        obj2[zzb] = com_google_android_gms_internal_zzfjj.zzcvv();
                        zzb++;
                    }
                    this.zzpqf = obj2;
                    com_google_android_gms_internal_zzfjj.zzkt(zzks);
                    continue;
                default:
                    if (!super.zza(com_google_android_gms_internal_zzfjj, zzcvt)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public final void zza(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        int i = 0;
        if (this.zzpqb != null && this.zzpqb.length > 0) {
            for (String str : this.zzpqb) {
                if (str != null) {
                    com_google_android_gms_internal_zzfjk.zzn(1, str);
                }
            }
        }
        if (this.zzpqc != null && this.zzpqc.length > 0) {
            for (String str2 : this.zzpqc) {
                if (str2 != null) {
                    com_google_android_gms_internal_zzfjk.zzn(2, str2);
                }
            }
        }
        if (this.zzpqd != null && this.zzpqd.length > 0) {
            for (int zzaa : this.zzpqd) {
                com_google_android_gms_internal_zzfjk.zzaa(3, zzaa);
            }
        }
        if (this.zzpqe != null && this.zzpqe.length > 0) {
            for (long zzf : this.zzpqe) {
                com_google_android_gms_internal_zzfjk.zzf(4, zzf);
            }
        }
        if (this.zzpqf != null && this.zzpqf.length > 0) {
            while (i < this.zzpqf.length) {
                com_google_android_gms_internal_zzfjk.zzf(5, this.zzpqf[i]);
                i++;
            }
        }
        super.zza(com_google_android_gms_internal_zzfjk);
    }

    public final /* synthetic */ zzfjm zzdaf() throws CloneNotSupportedException {
        return (zzfkn) clone();
    }

    public final /* synthetic */ zzfjs zzdag() throws CloneNotSupportedException {
        return (zzfkn) clone();
    }

    protected final int zzq() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int zzq = super.zzq();
        if (this.zzpqb == null || this.zzpqb.length <= 0) {
            i = zzq;
        } else {
            i2 = 0;
            i3 = 0;
            for (String str : this.zzpqb) {
                if (str != null) {
                    i3++;
                    i2 += zzfjk.zztt(str);
                }
            }
            i = (zzq + i2) + (i3 * 1);
        }
        if (this.zzpqc != null && this.zzpqc.length > 0) {
            i3 = 0;
            zzq = 0;
            for (String str2 : this.zzpqc) {
                if (str2 != null) {
                    zzq++;
                    i3 += zzfjk.zztt(str2);
                }
            }
            i = (i + i3) + (zzq * 1);
        }
        if (this.zzpqd != null && this.zzpqd.length > 0) {
            i3 = 0;
            for (int zzq2 : this.zzpqd) {
                i3 += zzfjk.zzlh(zzq2);
            }
            i = (i + i3) + (this.zzpqd.length * 1);
        }
        if (this.zzpqe != null && this.zzpqe.length > 0) {
            i3 = 0;
            for (long zzdi : this.zzpqe) {
                i3 += zzfjk.zzdi(zzdi);
            }
            i = (i + i3) + (this.zzpqe.length * 1);
        }
        if (this.zzpqf == null || this.zzpqf.length <= 0) {
            return i;
        }
        i2 = 0;
        while (i4 < this.zzpqf.length) {
            i2 += zzfjk.zzdi(this.zzpqf[i4]);
            i4++;
        }
        return (i + i2) + (this.zzpqf.length * 1);
    }
}
