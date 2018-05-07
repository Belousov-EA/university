package com.google.android.gms.internal;

final class zzecl implements Runnable {
    private /* synthetic */ zzeck zzmqg;

    zzecl(zzeck com_google_android_gms_internal_zzeck) {
        this.zzmqg = com_google_android_gms_internal_zzeck;
    }

    public final void run() {
        this.zzmqg.zzmqe.zzmqc.cancel(false);
        this.zzmqg.zzmqe.zzmpw = true;
        if (this.zzmqg.zzmqe.zzmlr.zzbzl()) {
            this.zzmqg.zzmqe.zzmlr.zzb("websocket opened", null, new Object[0]);
        }
        this.zzmqg.zzmqe.zzbvd();
    }
}
