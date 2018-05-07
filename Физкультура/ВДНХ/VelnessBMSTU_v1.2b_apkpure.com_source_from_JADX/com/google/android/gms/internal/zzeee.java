package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseError;

final class zzeee implements Runnable {
    private /* synthetic */ zzeeo zzmts;
    private /* synthetic */ DatabaseError zzmtw;

    zzeee(zzedn com_google_android_gms_internal_zzedn, zzeeo com_google_android_gms_internal_zzeeo, DatabaseError databaseError) {
        this.zzmts = com_google_android_gms_internal_zzeeo;
        this.zzmtw = databaseError;
    }

    public final void run() {
        this.zzmts.zzmuh.onComplete(this.zzmtw, false, null);
    }
}
