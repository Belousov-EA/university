package com.google.android.gms.internal;

final class zzejq implements zzejr {
    private final long zzncl;

    public zzejq(zzekd com_google_android_gms_internal_zzekd) {
        this.zzncl = Math.max(512, (long) Math.sqrt((double) (zzelo.zzn(com_google_android_gms_internal_zzekd) * 100)));
    }

    public final boolean zze(zzejp com_google_android_gms_internal_zzejp) {
        return ((long) com_google_android_gms_internal_zzejp.zzbzz()) > this.zzncl && (com_google_android_gms_internal_zzejp.zzcaa().isEmpty() || !com_google_android_gms_internal_zzejp.zzcaa().zzbwk().equals(zzejg.zzbzp()));
    }
}
