package com.google.android.gms.internal;

final class zzecn implements Runnable {
    private /* synthetic */ zzeck zzmqg;

    zzecn(zzeck com_google_android_gms_internal_zzeck) {
        this.zzmqg = com_google_android_gms_internal_zzeck;
    }

    public final void run() {
        if (this.zzmqg.zzmqe.zzmlr.zzbzl()) {
            this.zzmqg.zzmqe.zzmlr.zzb("closed", null, new Object[0]);
        }
        this.zzmqg.zzmqe.zzbve();
    }
}
