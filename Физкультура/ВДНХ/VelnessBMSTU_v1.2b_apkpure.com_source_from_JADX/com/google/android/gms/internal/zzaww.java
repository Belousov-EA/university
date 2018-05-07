package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.zzd;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzm;

abstract class zzaww extends zzm<ProxyResult, zzawi> {
    public zzaww(GoogleApiClient googleApiClient) {
        super(zzd.API, googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((ProxyResult) obj);
    }

    protected abstract void zza(Context context, zzawl com_google_android_gms_internal_zzawl) throws RemoteException;

    protected final /* synthetic */ void zza(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        zzawi com_google_android_gms_internal_zzawi = (zzawi) com_google_android_gms_common_api_Api_zzb;
        zza(com_google_android_gms_internal_zzawi.getContext(), (zzawl) com_google_android_gms_internal_zzawi.zzakn());
    }

    protected final /* synthetic */ Result zzb(Status status) {
        return new zzaxa(status);
    }
}
