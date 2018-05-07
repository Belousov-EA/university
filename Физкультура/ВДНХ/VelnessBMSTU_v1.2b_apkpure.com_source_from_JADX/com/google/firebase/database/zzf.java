package com.google.firebase.database;

import com.google.firebase.database.Transaction.Handler;

final class zzf implements Runnable {
    private /* synthetic */ DatabaseReference zzmkb;
    private /* synthetic */ Handler zzmkf;
    private /* synthetic */ boolean zzmkg;

    zzf(DatabaseReference databaseReference, Handler handler, boolean z) {
        this.zzmkb = databaseReference;
        this.zzmkf = handler;
        this.zzmkg = z;
    }

    public final void run() {
        this.zzmkb.zzmkl.zza(this.zzmkb.zzmks, this.zzmkf, this.zzmkg);
    }
}
