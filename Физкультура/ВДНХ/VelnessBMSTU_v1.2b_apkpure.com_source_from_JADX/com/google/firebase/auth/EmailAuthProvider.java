package com.google.firebase.auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;

public class EmailAuthProvider {
    public static final String PROVIDER_ID = "password";

    private EmailAuthProvider() {
    }

    public static AuthCredential getCredential(@NonNull String str, @NonNull String str2) {
        zzbq.zzgm(str);
        zzbq.zzgm(str2);
        return new EmailAuthCredential(str, str2);
    }
}
