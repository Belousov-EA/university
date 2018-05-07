package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;

final class zzcej extends zzcem {
    private /* synthetic */ PendingIntent zzikr;
    private /* synthetic */ LocationRequest zzild;

    zzcej(zzceb com_google_android_gms_internal_zzceb, GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
        this.zzild = locationRequest;
        this.zzikr = pendingIntent;
        super(googleApiClient);
    }

    protected final /* synthetic */ void zza(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        ((zzcfk) com_google_android_gms_common_api_Api_zzb).zza(this.zzild, this.zzikr, new zzcen(this));
    }
}
