package com.google.firebase.auth.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.FirebaseNetworkException;

final class zzm implements OnFailureListener {
    private /* synthetic */ zzl zzmhw;

    zzm(zzl com_google_firebase_auth_internal_zzl) {
        this.zzmhw = com_google_firebase_auth_internal_zzl;
    }

    public final void onFailure(@NonNull Exception exception) {
        if (exception instanceof FirebaseNetworkException) {
            zzk.zzecc.zza("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            this.zzmhw.zzmhv.zzbse();
        }
    }
}
