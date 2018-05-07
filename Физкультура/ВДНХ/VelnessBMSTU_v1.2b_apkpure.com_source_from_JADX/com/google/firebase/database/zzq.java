package com.google.firebase.database;

import com.google.android.gms.internal.zzedh;

final class zzq implements Runnable {
    private /* synthetic */ Query zzmkz;
    private /* synthetic */ zzedh zzmla;

    zzq(Query query, zzedh com_google_android_gms_internal_zzedh) {
        this.zzmkz = query;
        this.zzmla = com_google_android_gms_internal_zzedh;
    }

    public final void run() {
        this.zzmkz.zzmkl.zze(this.zzmla);
    }
}
