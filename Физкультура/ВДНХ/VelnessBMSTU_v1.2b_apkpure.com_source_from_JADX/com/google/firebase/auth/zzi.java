package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth.AuthStateListener;

final class zzi implements Runnable {
    private /* synthetic */ FirebaseAuth zzmdi;
    private /* synthetic */ AuthStateListener zzmdj;

    zzi(FirebaseAuth firebaseAuth, AuthStateListener authStateListener) {
        this.zzmdi = firebaseAuth;
        this.zzmdj = authStateListener;
    }

    public final void run() {
        this.zzmdj.onAuthStateChanged(this.zzmdi);
    }
}
