package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzawy extends zzaww {
    private /* synthetic */ ProxyRequest zzego;

    zzawy(zzawx com_google_android_gms_internal_zzawx, GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        this.zzego = proxyRequest;
        super(googleApiClient);
    }

    protected final void zza(Context context, zzawl com_google_android_gms_internal_zzawl) throws RemoteException {
        com_google_android_gms_internal_zzawl.zza(new zzawz(this), this.zzego);
    }
}
