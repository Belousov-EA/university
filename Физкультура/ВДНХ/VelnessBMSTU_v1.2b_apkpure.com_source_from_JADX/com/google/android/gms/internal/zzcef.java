package com.google.android.gms.internal;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zzcef extends zzcem {
    private /* synthetic */ Location zzilh;

    zzcef(zzceb com_google_android_gms_internal_zzceb, GoogleApiClient googleApiClient, Location location) {
        this.zzilh = location;
        super(googleApiClient);
    }

    protected final /* synthetic */ void zza(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        ((zzcfk) com_google_android_gms_common_api_Api_zzb).zzc(this.zzilh);
        setResult(Status.zzfni);
    }
}
