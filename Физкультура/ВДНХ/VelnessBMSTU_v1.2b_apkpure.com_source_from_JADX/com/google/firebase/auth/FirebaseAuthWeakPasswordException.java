package com.google.firebase.auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class FirebaseAuthWeakPasswordException extends FirebaseAuthInvalidCredentialsException {
    private final String zzbya;

    public FirebaseAuthWeakPasswordException(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        super(str, str2);
        this.zzbya = str3;
    }

    @Nullable
    public final String getReason() {
        return this.zzbya;
    }
}
