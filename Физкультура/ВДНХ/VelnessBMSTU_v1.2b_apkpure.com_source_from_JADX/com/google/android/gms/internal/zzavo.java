package com.google.android.gms.internal;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;

public final class zzavo implements CredentialRequestResult {
    private final Status mStatus;
    private final Credential zzegc;

    public zzavo(Status status, Credential credential) {
        this.mStatus = status;
        this.zzegc = credential;
    }

    public static zzavo zzf(Status status) {
        return new zzavo(status, null);
    }

    public final Credential getCredential() {
        return this.zzegc;
    }

    public final Status getStatus() {
        return this.mStatus;
    }
}
