package com.google.firebase.auth;

import com.google.android.gms.internal.zzbfm;

public abstract class AuthCredential extends zzbfm {
    AuthCredential() {
    }

    public abstract String getProvider();
}
