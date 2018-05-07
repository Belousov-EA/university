package com.google.android.gms.internal;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Transaction.Handler;

final class zzedt implements Runnable {
    private /* synthetic */ Handler zzmkf;
    private /* synthetic */ DatabaseError zzmtn;
    private /* synthetic */ DataSnapshot zzmto;

    zzedt(zzedn com_google_android_gms_internal_zzedn, Handler handler, DatabaseError databaseError, DataSnapshot dataSnapshot) {
        this.zzmkf = handler;
        this.zzmtn = databaseError;
        this.zzmto = dataSnapshot;
    }

    public final void run() {
        this.zzmkf.onComplete(this.zzmtn, false, this.zzmto);
    }
}
