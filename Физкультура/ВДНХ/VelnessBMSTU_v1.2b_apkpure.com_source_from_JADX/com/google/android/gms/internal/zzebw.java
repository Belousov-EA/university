package com.google.android.gms.internal;

final class zzebw implements Runnable {
    private /* synthetic */ zzebo zzmot;

    zzebw(zzebo com_google_android_gms_internal_zzebo) {
        this.zzmot = com_google_android_gms_internal_zzebo;
    }

    public final void run() {
        this.zzmot.zzmop = null;
        if (this.zzmot.zzbus()) {
            this.zzmot.interrupt("connection_idle");
        } else {
            this.zzmot.zzbur();
        }
    }
}
