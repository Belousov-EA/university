package com.google.android.gms.internal;

public final class zzw<T> {
    public final T result;
    public final zzc zzbh;
    public final zzad zzbi;
    public boolean zzbj;

    private zzw(zzad com_google_android_gms_internal_zzad) {
        this.zzbj = false;
        this.result = null;
        this.zzbh = null;
        this.zzbi = com_google_android_gms_internal_zzad;
    }

    private zzw(T t, zzc com_google_android_gms_internal_zzc) {
        this.zzbj = false;
        this.result = t;
        this.zzbh = com_google_android_gms_internal_zzc;
        this.zzbi = null;
    }

    public static <T> zzw<T> zza(T t, zzc com_google_android_gms_internal_zzc) {
        return new zzw(t, com_google_android_gms_internal_zzc);
    }

    public static <T> zzw<T> zzc(zzad com_google_android_gms_internal_zzad) {
        return new zzw(com_google_android_gms_internal_zzad);
    }
}
