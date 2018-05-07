package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zzm;

abstract class zzavw<R extends Result> extends zzm<R, zzavy> {
    zzavw(GoogleApiClient googleApiClient) {
        super(Auth.CREDENTIALS_API, googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }

    protected abstract void zza(Context context, zzawd com_google_android_gms_internal_zzawd) throws DeadObjectException, RemoteException;

    protected final /* synthetic */ void zza(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        zzavy com_google_android_gms_internal_zzavy = (zzavy) com_google_android_gms_common_api_Api_zzb;
        zza(com_google_android_gms_internal_zzavy.getContext(), (zzawd) com_google_android_gms_internal_zzavy.zzakn());
    }
}
