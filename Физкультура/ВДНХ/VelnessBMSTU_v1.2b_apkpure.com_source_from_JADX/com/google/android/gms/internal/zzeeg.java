package com.google.android.gms.internal;

final class zzeeg implements Runnable {
    private /* synthetic */ zzeik zzmtx;
    private /* synthetic */ zzefw zzmty;
    private /* synthetic */ zzeef zzmtz;

    zzeeg(zzeef com_google_android_gms_internal_zzeef, zzeik com_google_android_gms_internal_zzeik, zzefw com_google_android_gms_internal_zzefw) {
        this.zzmtz = com_google_android_gms_internal_zzeef;
        this.zzmtx = com_google_android_gms_internal_zzeik;
        this.zzmty = com_google_android_gms_internal_zzefw;
    }

    public final void run() {
        zzekd zzp = this.zzmtz.zzmti.zzmss.zzp(this.zzmtx.zzbsy());
        if (!zzp.isEmpty()) {
            this.zzmtz.zzmti.zzau(this.zzmtz.zzmti.zzmtd.zzi(this.zzmtx.zzbsy(), zzp));
            this.zzmty.zzb(null);
        }
    }
}
