package com.google.firebase.auth;

import android.support.annotation.NonNull;

public class PlayGamesAuthProvider {
    public static final String PROVIDER_ID = "playgames.google.com";

    private PlayGamesAuthProvider() {
    }

    public static AuthCredential getCredential(@NonNull String str) {
        return new PlayGamesAuthCredential(str);
    }
}
