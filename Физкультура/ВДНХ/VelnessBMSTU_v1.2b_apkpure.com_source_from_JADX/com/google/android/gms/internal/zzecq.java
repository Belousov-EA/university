package com.google.android.gms.internal;

final class zzecq implements Runnable {
    private /* synthetic */ Runnable zzews;
    private /* synthetic */ zzecp zzmrh;

    zzecq(zzecp com_google_android_gms_internal_zzecp, Runnable runnable) {
        this.zzmrh = com_google_android_gms_internal_zzecp;
        this.zzews = runnable;
    }

    public final void run() {
        this.zzmrh.zzmre = null;
        this.zzews.run();
    }
}
