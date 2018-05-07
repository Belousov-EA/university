package com.google.firebase.database;

import com.google.android.gms.internal.zzedh;

final class zzr implements Runnable {
    private /* synthetic */ Query zzmkz;
    private /* synthetic */ zzedh zzmlb;

    zzr(Query query, zzedh com_google_android_gms_internal_zzedh) {
        this.zzmkz = query;
        this.zzmlb = com_google_android_gms_internal_zzedh;
    }

    public final void run() {
        this.zzmkz.zzmkl.zzf(this.zzmlb);
    }
}
