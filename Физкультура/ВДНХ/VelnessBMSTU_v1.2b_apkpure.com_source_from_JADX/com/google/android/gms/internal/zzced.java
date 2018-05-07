package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzcm;
import com.google.android.gms.location.LocationCallback;

final class zzced extends zzcem {
    private /* synthetic */ LocationCallback zzilf;

    zzced(zzceb com_google_android_gms_internal_zzceb, GoogleApiClient googleApiClient, LocationCallback locationCallback) {
        this.zzilf = locationCallback;
        super(googleApiClient);
    }

    protected final /* synthetic */ void zza(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        ((zzcfk) com_google_android_gms_common_api_Api_zzb).zzb(zzcm.zzb(this.zzilf, LocationCallback.class.getSimpleName()), new zzcen(this));
    }
}
