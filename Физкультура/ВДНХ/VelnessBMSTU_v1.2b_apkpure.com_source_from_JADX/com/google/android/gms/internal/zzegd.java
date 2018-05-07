package com.google.android.gms.internal;

public final class zzegd {
    private final zzedk zzmks;
    private final long zzmwq;
    private final zzekd zzmwr;
    private final zzecy zzmws;
    private final boolean zzmwt;

    public zzegd(long j, zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy) {
        this.zzmwq = j;
        this.zzmks = com_google_android_gms_internal_zzedk;
        this.zzmwr = null;
        this.zzmws = com_google_android_gms_internal_zzecy;
        this.zzmwt = true;
    }

    public zzegd(long j, zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, boolean z) {
        this.zzmwq = j;
        this.zzmks = com_google_android_gms_internal_zzedk;
        this.zzmwr = com_google_android_gms_internal_zzekd;
        this.zzmws = null;
        this.zzmwt = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzegd com_google_android_gms_internal_zzegd = (zzegd) obj;
        if (this.zzmwq != com_google_android_gms_internal_zzegd.zzmwq) {
            return false;
        }
        if (!this.zzmks.equals(com_google_android_gms_internal_zzegd.zzmks)) {
            return false;
        }
        if (this.zzmwt != com_google_android_gms_internal_zzegd.zzmwt) {
            return false;
        }
        if (!this.zzmwr == null ? this.zzmwr.equals(com_google_android_gms_internal_zzegd.zzmwr) : com_google_android_gms_internal_zzegd.zzmwr == null) {
            return false;
        }
        if (this.zzmws != null) {
            if (this.zzmws.equals(com_google_android_gms_internal_zzegd.zzmws)) {
                return true;
            }
        } else if (com_google_android_gms_internal_zzegd.zzmws == null) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.zzmwr != null ? this.zzmwr.hashCode() : 0) + (((((Long.valueOf(this.zzmwq).hashCode() * 31) + Boolean.valueOf(this.zzmwt).hashCode()) * 31) + this.zzmks.hashCode()) * 31)) * 31;
        if (this.zzmws != null) {
            i = this.zzmws.hashCode();
        }
        return hashCode + i;
    }

    public final boolean isVisible() {
        return this.zzmwt;
    }

    public final String toString() {
        long j = this.zzmwq;
        String valueOf = String.valueOf(this.zzmks);
        boolean z = this.zzmwt;
        String valueOf2 = String.valueOf(this.zzmwr);
        String valueOf3 = String.valueOf(this.zzmws);
        return new StringBuilder(((String.valueOf(valueOf).length() + 78) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append("UserWriteRecord{id=").append(j).append(" path=").append(valueOf).append(" visible=").append(z).append(" overwrite=").append(valueOf2).append(" merge=").append(valueOf3).append("}").toString();
    }

    public final zzedk zzbsy() {
        return this.zzmks;
    }

    public final long zzbwy() {
        return this.zzmwq;
    }

    public final zzekd zzbwz() {
        if (this.zzmwr != null) {
            return this.zzmwr;
        }
        throw new IllegalArgumentException("Can't access overwrite when write is a merge!");
    }

    public final zzecy zzbxa() {
        if (this.zzmws != null) {
            return this.zzmws;
        }
        throw new IllegalArgumentException("Can't access merge when write is an overwrite!");
    }

    public final boolean zzbxb() {
        return this.zzmwr != null;
    }
}
