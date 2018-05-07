package com.google.android.gms.internal;

public final class zzeik {
    private final zzedk zzmks;
    private final zzeih zzmkw;

    public zzeik(zzedk com_google_android_gms_internal_zzedk, zzeih com_google_android_gms_internal_zzeih) {
        this.zzmks = com_google_android_gms_internal_zzedk;
        this.zzmkw = com_google_android_gms_internal_zzeih;
    }

    public static zzeik zzam(zzedk com_google_android_gms_internal_zzedk) {
        return new zzeik(com_google_android_gms_internal_zzedk, zzeih.zznae);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzeik com_google_android_gms_internal_zzeik = (zzeik) obj;
        return !this.zzmks.equals(com_google_android_gms_internal_zzeik.zzmks) ? false : this.zzmkw.equals(com_google_android_gms_internal_zzeik.zzmkw);
    }

    public final int hashCode() {
        return (this.zzmks.hashCode() * 31) + this.zzmkw.hashCode();
    }

    public final boolean isDefault() {
        return this.zzmkw.isDefault();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzmks);
        String valueOf2 = String.valueOf(this.zzmkw);
        return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append(":").append(valueOf2).toString();
    }

    public final zzedk zzbsy() {
        return this.zzmks;
    }

    public final zzejv zzbyr() {
        return this.zzmkw.zzbyr();
    }

    public final boolean zzbyv() {
        return this.zzmkw.zzbyv();
    }

    public final zzeih zzbyy() {
        return this.zzmkw;
    }
}
