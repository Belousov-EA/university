package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class zzavs extends zzavw<Status> {
    private /* synthetic */ Credential zzegf;

    zzavs(zzavp com_google_android_gms_internal_zzavp, GoogleApiClient googleApiClient, Credential credential) {
        this.zzegf = credential;
        super(googleApiClient);
    }

    protected final void zza(Context context, zzawd com_google_android_gms_internal_zzawd) throws RemoteException {
        com_google_android_gms_internal_zzawd.zza(new zzavv(this), new zzawf(this.zzegf));
    }

    protected final /* synthetic */ Result zzb(Status status) {
        return status;
    }
}
