package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth.AuthStateListener;

final class zzk implements Runnable {
    private /* synthetic */ FirebaseAuth zzmdi;

    zzk(FirebaseAuth firebaseAuth) {
        this.zzmdi = firebaseAuth;
    }

    public final void run() {
        for (AuthStateListener onAuthStateChanged : this.zzmdi.zzmcy) {
            onAuthStateChanged.onAuthStateChanged(this.zzmdi);
        }
    }
}
