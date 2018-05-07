package com.google.android.gms.auth.api.signin;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class GoogleSignInResult implements Result {
    private Status mStatus;
    private GoogleSignInAccount zzehu;

    public GoogleSignInResult(@Nullable GoogleSignInAccount googleSignInAccount, @NonNull Status status) {
        this.zzehu = googleSignInAccount;
        this.mStatus = status;
    }

    @Nullable
    public GoogleSignInAccount getSignInAccount() {
        return this.zzehu;
    }

    @NonNull
    public Status getStatus() {
        return this.mStatus;
    }

    public boolean isSuccess() {
        return this.mStatus.isSuccess();
    }
}
