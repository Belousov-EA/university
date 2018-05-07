package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.internal.zzo;

final class zzm implements zzo {
    private /* synthetic */ FirebaseAuth zzmdi;
    private /* synthetic */ FirebaseUser zzmdl;

    zzm(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        this.zzmdi = firebaseAuth;
        this.zzmdl = firebaseUser;
    }

    public final void onError(Status status) {
        if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005) {
            this.zzmdi.signOut();
        }
    }

    public final void zzbrd() {
        if (this.zzmdi.zzmda.getUid().equalsIgnoreCase(this.zzmdl.getUid())) {
            this.zzmdi.zzbrb();
        }
    }
}
