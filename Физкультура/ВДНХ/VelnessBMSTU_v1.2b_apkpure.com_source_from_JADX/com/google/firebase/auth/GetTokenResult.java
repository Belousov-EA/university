package com.google.firebase.auth;

import android.support.annotation.Nullable;

public class GetTokenResult {
    private String zzecl;

    public GetTokenResult(String str) {
        this.zzecl = str;
    }

    @Nullable
    public String getToken() {
        return this.zzecl;
    }
}
