package com.google.android.gms.internal;

import android.accounts.Account;
import com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult;
import com.google.android.gms.common.api.Status;

final class zzaun implements AddAccountResult {
    private final Status mStatus;
    private final Account zzebz;

    public zzaun(Status status, Account account) {
        this.mStatus = status;
        this.zzebz = account;
    }

    public final Account getAccount() {
        return this.zzebz;
    }

    public final Status getStatus() {
        return this.mStatus;
    }
}
