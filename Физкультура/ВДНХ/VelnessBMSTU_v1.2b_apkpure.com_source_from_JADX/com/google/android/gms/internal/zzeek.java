package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseReference.CompletionListener;

final class zzeek implements Runnable {
    private /* synthetic */ CompletionListener zzmtl;
    private /* synthetic */ DatabaseError zzmud;
    private /* synthetic */ DatabaseReference zzmue;

    zzeek(zzedn com_google_android_gms_internal_zzedn, CompletionListener completionListener, DatabaseError databaseError, DatabaseReference databaseReference) {
        this.zzmtl = completionListener;
        this.zzmud = databaseError;
        this.zzmue = databaseReference;
    }

    public final void run() {
        this.zzmtl.onComplete(this.zzmud, this.zzmue);
    }
}
