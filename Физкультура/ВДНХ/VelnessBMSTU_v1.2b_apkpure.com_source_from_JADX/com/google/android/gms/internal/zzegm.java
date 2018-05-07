package com.google.android.gms.internal;

public final class zzegm extends zzego {
    public zzegm(zzegq com_google_android_gms_internal_zzegq, zzedk com_google_android_gms_internal_zzedk) {
        super(zzegp.ListenComplete, com_google_android_gms_internal_zzegq, com_google_android_gms_internal_zzedk);
    }

    public final String toString() {
        return String.format("ListenComplete { path=%s, source=%s }", new Object[]{this.zzmks, this.zzmxm});
    }

    public final zzego zzc(zzejg com_google_android_gms_internal_zzejg) {
        return this.zzmks.isEmpty() ? new zzegm(this.zzmxm, zzedk.zzbwe()) : new zzegm(this.zzmxm, this.zzmks.zzbwi());
    }
}
