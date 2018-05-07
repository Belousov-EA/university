package com.google.android.gms.internal;

import com.google.firebase.internal.zzc;

final class zzdzu implements Runnable {
    private /* synthetic */ zzc zzmdk;
    private /* synthetic */ zzdzt zzmlk;

    zzdzu(zzdzt com_google_android_gms_internal_zzdzt, zzc com_google_firebase_internal_zzc) {
        this.zzmlk = com_google_android_gms_internal_zzdzt;
        this.zzmdk = com_google_firebase_internal_zzc;
    }

    public final void run() {
        this.zzmlk.zzmli.zzpu(this.zzmdk.getToken());
    }
}
