package com.google.android.gms.internal;

public final class zzegs extends zzego {
    private final zzekd zzmya;

    public zzegs(zzegq com_google_android_gms_internal_zzegq, zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        super(zzegp.Overwrite, com_google_android_gms_internal_zzegq, com_google_android_gms_internal_zzedk);
        this.zzmya = com_google_android_gms_internal_zzekd;
    }

    public final String toString() {
        return String.format("Overwrite { path=%s, source=%s, snapshot=%s }", new Object[]{this.zzmks, this.zzmxm, this.zzmya});
    }

    public final zzekd zzbxo() {
        return this.zzmya;
    }

    public final zzego zzc(zzejg com_google_android_gms_internal_zzejg) {
        return this.zzmks.isEmpty() ? new zzegs(this.zzmxm, zzedk.zzbwe(), this.zzmya.zzm(com_google_android_gms_internal_zzejg)) : new zzegs(this.zzmxm, this.zzmks.zzbwi(), this.zzmya);
    }
}
