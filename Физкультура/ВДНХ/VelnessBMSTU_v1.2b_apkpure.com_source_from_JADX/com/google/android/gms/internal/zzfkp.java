package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzfkp extends zzfjm<zzfkp> implements Cloneable {
    private byte[] zzpqh;
    private String zzpqi;
    private byte[][] zzpqj;
    private boolean zzpqk;

    public zzfkp() {
        this.zzpqh = zzfjv.zzpnv;
        this.zzpqi = "";
        this.zzpqj = zzfjv.zzpnu;
        this.zzpqk = false;
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    private zzfkp zzday() {
        try {
            zzfkp com_google_android_gms_internal_zzfkp = (zzfkp) super.zzdaf();
            if (this.zzpqj != null && this.zzpqj.length > 0) {
                com_google_android_gms_internal_zzfkp.zzpqj = (byte[][]) this.zzpqj.clone();
            }
            return com_google_android_gms_internal_zzfkp;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzday();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfkp)) {
            return false;
        }
        zzfkp com_google_android_gms_internal_zzfkp = (zzfkp) obj;
        if (!Arrays.equals(this.zzpqh, com_google_android_gms_internal_zzfkp.zzpqh)) {
            return false;
        }
        if (this.zzpqi == null) {
            if (com_google_android_gms_internal_zzfkp.zzpqi != null) {
                return false;
            }
        } else if (!this.zzpqi.equals(com_google_android_gms_internal_zzfkp.zzpqi)) {
            return false;
        }
        return !zzfjq.zza(this.zzpqj, com_google_android_gms_internal_zzfkp.zzpqj) ? false : this.zzpqk != com_google_android_gms_internal_zzfkp.zzpqk ? false : (this.zzpnc == null || this.zzpnc.isEmpty()) ? com_google_android_gms_internal_zzfkp.zzpnc == null || com_google_android_gms_internal_zzfkp.zzpnc.isEmpty() : this.zzpnc.equals(com_google_android_gms_internal_zzfkp.zzpnc);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.zzpqk ? 1231 : 1237) + (((((this.zzpqi == null ? 0 : this.zzpqi.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.zzpqh)) * 31)) * 31) + zzfjq.zzd(this.zzpqj)) * 31)) * 31;
        if (!(this.zzpnc == null || this.zzpnc.isEmpty())) {
            i = this.zzpnc.hashCode();
        }
        return hashCode + i;
    }

    public final /* synthetic */ zzfjs zza(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        while (true) {
            int zzcvt = com_google_android_gms_internal_zzfjj.zzcvt();
            switch (zzcvt) {
                case 0:
                    break;
                case 10:
                    this.zzpqh = com_google_android_gms_internal_zzfjj.readBytes();
                    continue;
                case 18:
                    int zzb = zzfjv.zzb(com_google_android_gms_internal_zzfjj, 18);
                    zzcvt = this.zzpqj == null ? 0 : this.zzpqj.length;
                    Object obj = new byte[(zzb + zzcvt)][];
                    if (zzcvt != 0) {
                        System.arraycopy(this.zzpqj, 0, obj, 0, zzcvt);
                    }
                    while (zzcvt < obj.length - 1) {
                        obj[zzcvt] = com_google_android_gms_internal_zzfjj.readBytes();
                        com_google_android_gms_internal_zzfjj.zzcvt();
                        zzcvt++;
                    }
                    obj[zzcvt] = com_google_android_gms_internal_zzfjj.readBytes();
                    this.zzpqj = obj;
                    continue;
                case 24:
                    this.zzpqk = com_google_android_gms_internal_zzfjj.zzcvz();
                    continue;
                case 34:
                    this.zzpqi = com_google_android_gms_internal_zzfjj.readString();
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
        if (!Arrays.equals(this.zzpqh, zzfjv.zzpnv)) {
            com_google_android_gms_internal_zzfjk.zzc(1, this.zzpqh);
        }
        if (this.zzpqj != null && this.zzpqj.length > 0) {
            for (byte[] bArr : this.zzpqj) {
                if (bArr != null) {
                    com_google_android_gms_internal_zzfjk.zzc(2, bArr);
                }
            }
        }
        if (this.zzpqk) {
            com_google_android_gms_internal_zzfjk.zzl(3, this.zzpqk);
        }
        if (!(this.zzpqi == null || this.zzpqi.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(4, this.zzpqi);
        }
        super.zza(com_google_android_gms_internal_zzfjk);
    }

    public final /* synthetic */ zzfjm zzdaf() throws CloneNotSupportedException {
        return (zzfkp) clone();
    }

    public final /* synthetic */ zzfjs zzdag() throws CloneNotSupportedException {
        return (zzfkp) clone();
    }

    protected final int zzq() {
        int i = 0;
        int zzq = super.zzq();
        if (!Arrays.equals(this.zzpqh, zzfjv.zzpnv)) {
            zzq += zzfjk.zzd(1, this.zzpqh);
        }
        if (this.zzpqj != null && this.zzpqj.length > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i < this.zzpqj.length) {
                byte[] bArr = this.zzpqj[i];
                if (bArr != null) {
                    i3++;
                    i2 += zzfjk.zzbg(bArr);
                }
                i++;
            }
            zzq = (zzq + i2) + (i3 * 1);
        }
        if (this.zzpqk) {
            zzq += zzfjk.zzlg(3) + 1;
        }
        return (this.zzpqi == null || this.zzpqi.equals("")) ? zzq : zzq + zzfjk.zzo(4, this.zzpqi);
    }
}
