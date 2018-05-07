package com.google.android.gms.internal;

public final class zzegl extends zzego {
    private final boolean zzmxi;
    private final zzehm<Boolean> zzmxj;

    public zzegl(zzedk com_google_android_gms_internal_zzedk, zzehm<Boolean> com_google_android_gms_internal_zzehm_java_lang_Boolean, boolean z) {
        super(zzegp.AckUserWrite, zzegq.zzmxs, com_google_android_gms_internal_zzedk);
        this.zzmxj = com_google_android_gms_internal_zzehm_java_lang_Boolean;
        this.zzmxi = z;
    }

    public final String toString() {
        return String.format("AckUserWrite { path=%s, revert=%s, affectedTree=%s }", new Object[]{this.zzmks, Boolean.valueOf(this.zzmxi), this.zzmxj});
    }

    public final zzehm<Boolean> zzbxg() {
        return this.zzmxj;
    }

    public final boolean zzbxh() {
        return this.zzmxi;
    }

    public final zzego zzc(zzejg com_google_android_gms_internal_zzejg) {
        if (!this.zzmks.isEmpty()) {
            zzelt.zzb(this.zzmks.zzbwh().equals(com_google_android_gms_internal_zzejg), "operationForChild called for unrelated child.");
            return new zzegl(this.zzmks.zzbwi(), this.zzmxj, this.zzmxi);
        } else if (this.zzmxj.getValue() != null) {
            zzelt.zzb(this.zzmxj.zzbxx().isEmpty(), "affectedTree should not have overlapping affected paths.");
            return this;
        } else {
            return new zzegl(zzedk.zzbwe(), this.zzmxj.zzah(new zzedk(com_google_android_gms_internal_zzejg)), this.zzmxi);
        }
    }
}
