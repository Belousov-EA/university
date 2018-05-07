package com.google.android.gms.internal;

final class zzedy implements Runnable {
    private /* synthetic */ zzedn zzmti;
    private /* synthetic */ zzeeo zzmts;

    zzedy(zzedn com_google_android_gms_internal_zzedn, zzeeo com_google_android_gms_internal_zzeeo) {
        this.zzmti = com_google_android_gms_internal_zzedn;
        this.zzmts = com_google_android_gms_internal_zzeeo;
    }

    public final void run() {
        this.zzmti.zze(new zzegf(this.zzmti, this.zzmts.zzmui, zzeik.zzam(this.zzmts.zzmks)));
    }
}
