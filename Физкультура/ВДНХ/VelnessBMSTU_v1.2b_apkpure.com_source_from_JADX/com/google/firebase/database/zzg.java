package com.google.firebase.database;

final class zzg implements Runnable {
    private /* synthetic */ FirebaseDatabase zzmkm;

    zzg(FirebaseDatabase firebaseDatabase) {
        this.zzmkm = firebaseDatabase;
    }

    public final void run() {
        this.zzmkm.zzmkl.purgeOutstandingWrites();
    }
}
