package com.google.android.gms.internal;

import java.io.EOFException;

final class zzeco implements Runnable {
    private /* synthetic */ zzeck zzmqg;
    private /* synthetic */ zzela zzmqi;

    zzeco(zzeck com_google_android_gms_internal_zzeck, zzela com_google_android_gms_internal_zzela) {
        this.zzmqg = com_google_android_gms_internal_zzeck;
        this.zzmqi = com_google_android_gms_internal_zzela;
    }

    public final void run() {
        if (this.zzmqi.getCause() == null || !(this.zzmqi.getCause() instanceof EOFException)) {
            this.zzmqg.zzmqe.zzmlr.zzb("WebSocket error.", this.zzmqi, new Object[0]);
        } else {
            this.zzmqg.zzmqe.zzmlr.zzb("WebSocket reached EOF.", null, new Object[0]);
        }
        this.zzmqg.zzmqe.zzbve();
    }
}
