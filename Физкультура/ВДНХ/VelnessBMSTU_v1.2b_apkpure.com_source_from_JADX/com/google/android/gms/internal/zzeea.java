package com.google.android.gms.internal;

final class zzeea implements zzecv {
    private /* synthetic */ zzedn zzmti;

    zzeea(zzedn com_google_android_gms_internal_zzedn) {
        this.zzmti = com_google_android_gms_internal_zzedn;
    }

    public final void zzpu(String str) {
        this.zzmti.zzmsy.zzb("Auth token changed, triggering auth token refresh", null, new Object[0]);
        this.zzmti.zzmqr.zzpn(str);
    }
}
