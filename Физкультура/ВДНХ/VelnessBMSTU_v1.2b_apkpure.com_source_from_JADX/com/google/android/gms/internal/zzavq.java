package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class zzavq extends zzavw<CredentialRequestResult> {
    private /* synthetic */ CredentialRequest zzegd;

    zzavq(zzavp com_google_android_gms_internal_zzavp, GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
        this.zzegd = credentialRequest;
        super(googleApiClient);
    }

    protected final void zza(Context context, zzawd com_google_android_gms_internal_zzawd) throws RemoteException {
        com_google_android_gms_internal_zzawd.zza(new zzavr(this), this.zzegd);
    }

    protected final /* synthetic */ Result zzb(Status status) {
        return zzavo.zzf(status);
    }
}
