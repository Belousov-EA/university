package com.google.android.gms.internal;

public class zzfgk {
    private static final zzffm zzpfe = zzffm.zzcxb();
    private zzfes zzphy;
    private volatile zzfhe zzphz;
    private volatile zzfes zzpia;

    private zzfhe zzj(zzfhe com_google_android_gms_internal_zzfhe) {
        if (this.zzphz == null) {
            synchronized (this) {
                if (this.zzphz != null) {
                } else {
                    try {
                        this.zzphz = com_google_android_gms_internal_zzfhe;
                        this.zzpia = zzfes.zzpfg;
                    } catch (zzfge e) {
                        this.zzphz = com_google_android_gms_internal_zzfhe;
                        this.zzpia = zzfes.zzpfg;
                    }
                }
            }
        }
        return this.zzphz;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfgk)) {
            return false;
        }
        zzfgk com_google_android_gms_internal_zzfgk = (zzfgk) obj;
        zzfhe com_google_android_gms_internal_zzfhe = this.zzphz;
        zzfhe com_google_android_gms_internal_zzfhe2 = com_google_android_gms_internal_zzfgk.zzphz;
        return (com_google_android_gms_internal_zzfhe == null && com_google_android_gms_internal_zzfhe2 == null) ? toByteString().equals(com_google_android_gms_internal_zzfgk.toByteString()) : (com_google_android_gms_internal_zzfhe == null || com_google_android_gms_internal_zzfhe2 == null) ? com_google_android_gms_internal_zzfhe != null ? com_google_android_gms_internal_zzfhe.equals(com_google_android_gms_internal_zzfgk.zzj(com_google_android_gms_internal_zzfhe.zzcxq())) : zzj(com_google_android_gms_internal_zzfhe2.zzcxq()).equals(com_google_android_gms_internal_zzfhe2) : com_google_android_gms_internal_zzfhe.equals(com_google_android_gms_internal_zzfhe2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzfes toByteString() {
        if (this.zzpia != null) {
            return this.zzpia;
        }
        synchronized (this) {
            if (this.zzpia != null) {
                zzfes com_google_android_gms_internal_zzfes = this.zzpia;
                return com_google_android_gms_internal_zzfes;
            }
            if (this.zzphz == null) {
                this.zzpia = zzfes.zzpfg;
            } else {
                this.zzpia = this.zzphz.toByteString();
            }
            com_google_android_gms_internal_zzfes = this.zzpia;
            return com_google_android_gms_internal_zzfes;
        }
    }

    public final int zzho() {
        return this.zzpia != null ? this.zzpia.size() : this.zzphz != null ? this.zzphz.zzho() : 0;
    }

    public final zzfhe zzk(zzfhe com_google_android_gms_internal_zzfhe) {
        zzfhe com_google_android_gms_internal_zzfhe2 = this.zzphz;
        this.zzphy = null;
        this.zzpia = null;
        this.zzphz = com_google_android_gms_internal_zzfhe;
        return com_google_android_gms_internal_zzfhe2;
    }
}
