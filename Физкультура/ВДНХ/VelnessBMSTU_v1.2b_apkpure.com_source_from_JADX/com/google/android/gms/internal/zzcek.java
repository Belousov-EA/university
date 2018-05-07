package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzcm;
import com.google.android.gms.location.LocationListener;

final class zzcek extends zzcem {
    private /* synthetic */ LocationListener zzile;

    zzcek(zzceb com_google_android_gms_internal_zzceb, GoogleApiClient googleApiClient, LocationListener locationListener) {
        this.zzile = locationListener;
        super(googleApiClient);
    }

    protected final /* synthetic */ void zza(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        ((zzcfk) com_google_android_gms_common_api_Api_zzb).zza(zzcm.zzb(this.zzile, LocationListener.class.getSimpleName()), new zzcen(this));
    }
}
