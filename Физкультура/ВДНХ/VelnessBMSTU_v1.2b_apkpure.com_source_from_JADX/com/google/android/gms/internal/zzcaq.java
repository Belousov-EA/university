package com.google.android.gms.internal;

public abstract class zzcaq<T> {
    private final int zzbha;
    private final String zzbhb;
    private final T zzbhc;

    private zzcaq(int i, String str, T t) {
        this.zzbha = i;
        this.zzbhb = str;
        this.zzbhc = t;
        zzcbb.zzarb().zza(this);
    }

    public static zzcas zzb(int i, String str, Boolean bool) {
        return new zzcas(0, str, bool);
    }

    public static zzcat zzb(int i, String str, int i2) {
        return new zzcat(0, str, Integer.valueOf(i2));
    }

    public static zzcau zzb(int i, String str, long j) {
        return new zzcau(0, str, Long.valueOf(j));
    }

    public final String getKey() {
        return this.zzbhb;
    }

    public final int getSource() {
        return this.zzbha;
    }

    protected abstract T zza(zzcay com_google_android_gms_internal_zzcay);

    public final T zziv() {
        return this.zzbhc;
    }
}
