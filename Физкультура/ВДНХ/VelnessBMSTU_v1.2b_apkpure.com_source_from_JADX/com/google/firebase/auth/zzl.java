package com.google.firebase.auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzdym;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzp;

final class zzl implements zza, zzp {
    private /* synthetic */ FirebaseAuth zzmdi;

    zzl(FirebaseAuth firebaseAuth) {
        this.zzmdi = firebaseAuth;
    }

    public final void onError(Status status) {
        int statusCode = status.getStatusCode();
        if (statusCode == 17011 || statusCode == 17021 || statusCode == 17005) {
            this.zzmdi.signOut();
        }
    }

    public final void zza(@NonNull zzdym com_google_android_gms_internal_zzdym, @NonNull FirebaseUser firebaseUser) {
        this.zzmdi.zza(firebaseUser, com_google_android_gms_internal_zzdym, true);
    }
}
