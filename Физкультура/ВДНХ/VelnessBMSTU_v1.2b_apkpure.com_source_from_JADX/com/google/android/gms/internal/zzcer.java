package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzn;
import com.google.android.gms.location.GeofencingRequest;

final class zzcer extends zzcet {
    private /* synthetic */ PendingIntent zzhfb;
    private /* synthetic */ GeofencingRequest zzilk;

    zzcer(zzceq com_google_android_gms_internal_zzceq, GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        this.zzilk = geofencingRequest;
        this.zzhfb = pendingIntent;
        super(googleApiClient);
    }

    protected final /* synthetic */ void zza(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        ((zzcfk) com_google_android_gms_common_api_Api_zzb).zza(this.zzilk, this.zzhfb, (zzn) this);
    }
}
