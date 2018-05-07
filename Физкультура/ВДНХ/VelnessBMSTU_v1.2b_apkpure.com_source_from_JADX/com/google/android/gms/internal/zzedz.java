package com.google.android.gms.internal;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

final class zzedz implements Runnable {
    private /* synthetic */ zzeeo zzmts;
    private /* synthetic */ DatabaseError zzmtt;
    private /* synthetic */ DataSnapshot zzmtu;

    zzedz(zzedn com_google_android_gms_internal_zzedn, zzeeo com_google_android_gms_internal_zzeeo, DatabaseError databaseError, DataSnapshot dataSnapshot) {
        this.zzmts = com_google_android_gms_internal_zzeeo;
        this.zzmtt = databaseError;
        this.zzmtu = dataSnapshot;
    }

    public final void run() {
        this.zzmts.zzmuh.onComplete(this.zzmtt, false, this.zzmtu);
    }
}
