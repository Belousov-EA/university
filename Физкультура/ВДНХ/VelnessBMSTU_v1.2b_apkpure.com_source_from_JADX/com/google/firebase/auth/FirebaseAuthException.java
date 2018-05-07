package com.google.firebase.auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.FirebaseException;

public class FirebaseAuthException extends FirebaseException {
    private final String zzmdm;

    public FirebaseAuthException(@NonNull String str, @NonNull String str2) {
        super(str2);
        this.zzmdm = zzbq.zzgm(str);
    }

    @NonNull
    public String getErrorCode() {
        return this.zzmdm;
    }
}
