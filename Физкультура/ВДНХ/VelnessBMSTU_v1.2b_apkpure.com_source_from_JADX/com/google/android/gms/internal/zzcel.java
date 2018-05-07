package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzcel extends zzcem {
    private /* synthetic */ PendingIntent zzikr;

    zzcel(zzceb com_google_android_gms_internal_zzceb, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        this.zzikr = pendingIntent;
        super(googleApiClient);
    }

    protected final /* synthetic */ void zza(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        ((zzcfk) com_google_android_gms_common_api_Api_zzb).zza(this.zzikr, new zzcen(this));
    }
}
