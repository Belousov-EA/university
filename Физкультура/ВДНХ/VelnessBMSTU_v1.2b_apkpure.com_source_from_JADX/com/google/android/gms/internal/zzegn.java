package com.google.android.gms.internal;

public final class zzegn extends zzego {
    private final zzecy zzmxk;

    public zzegn(zzegq com_google_android_gms_internal_zzegq, zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy) {
        super(zzegp.Merge, com_google_android_gms_internal_zzegq, com_google_android_gms_internal_zzedk);
        this.zzmxk = com_google_android_gms_internal_zzecy;
    }

    public final String toString() {
        return String.format("Merge { path=%s, source=%s, children=%s }", new Object[]{this.zzmks, this.zzmxm, this.zzmxk});
    }

    public final zzecy zzbxi() {
        return this.zzmxk;
    }

    public final zzego zzc(zzejg com_google_android_gms_internal_zzejg) {
        if (!this.zzmks.isEmpty()) {
            return this.zzmks.zzbwh().equals(com_google_android_gms_internal_zzejg) ? new zzegn(this.zzmxm, this.zzmks.zzbwi(), this.zzmxk) : null;
        } else {
            zzecy zzg = this.zzmxk.zzg(new zzedk(com_google_android_gms_internal_zzejg));
            return zzg.isEmpty() ? null : zzg.zzbvr() != null ? new zzegs(this.zzmxm, zzedk.zzbwe(), zzg.zzbvr()) : new zzegn(this.zzmxm, zzedk.zzbwe(), zzg);
        }
    }
}
