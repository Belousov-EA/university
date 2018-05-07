package com.google.android.gms.internal;

import com.google.firebase.database.DataSnapshot;

final class zzedw implements Runnable {
    private /* synthetic */ DataSnapshot zzmto;
    private /* synthetic */ zzeeo zzmtr;

    zzedw(zzedv com_google_android_gms_internal_zzedv, zzeeo com_google_android_gms_internal_zzeeo, DataSnapshot dataSnapshot) {
        this.zzmtr = com_google_android_gms_internal_zzeeo;
        this.zzmto = dataSnapshot;
    }

    public final void run() {
        this.zzmtr.zzmuh.onComplete(null, true, this.zzmto);
    }
}
