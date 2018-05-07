package com.google.firebase.auth.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

final class zzl implements Runnable {
    private final String zzmhj;
    final /* synthetic */ zzk zzmhv;

    zzl(@NonNull zzk com_google_firebase_auth_internal_zzk, String str) {
        this.zzmhv = com_google_firebase_auth_internal_zzk;
        this.zzmhj = zzbq.zzgm(str);
    }

    public final void run() {
        FirebaseAuth instance = FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzmhj));
        if (instance.getCurrentUser() != null) {
            Task zzce = instance.zzce(true);
            zzk.zzecc.zza("Token refreshing started", new Object[0]);
            zzce.addOnFailureListener(new zzm(this));
        }
    }
}
