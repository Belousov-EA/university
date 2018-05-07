package com.google.android.gms.internal;

final class zzees implements Runnable {
    private /* synthetic */ zzedn zzmtq;

    zzees(zzedn com_google_android_gms_internal_zzedn) {
        this.zzmtq = com_google_android_gms_internal_zzedn;
    }

    public final void run() {
        this.zzmtq.interrupt();
    }
}
