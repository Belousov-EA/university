package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth.IdTokenListener;

final class zzh implements Runnable {
    private /* synthetic */ IdTokenListener zzmdh;
    private /* synthetic */ FirebaseAuth zzmdi;

    zzh(FirebaseAuth firebaseAuth, IdTokenListener idTokenListener) {
        this.zzmdi = firebaseAuth;
        this.zzmdh = idTokenListener;
    }

    public final void run() {
        this.zzmdh.onIdTokenChanged(this.zzmdi);
    }
}
