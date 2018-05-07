package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzn;
import com.google.android.gms.location.LocationServices.zza;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;

final class zzcfw extends zza<LocationSettingsResult> {
    private /* synthetic */ LocationSettingsRequest zzime;
    private /* synthetic */ String zzimf = null;

    zzcfw(zzcfv com_google_android_gms_internal_zzcfv, GoogleApiClient googleApiClient, LocationSettingsRequest locationSettingsRequest, String str) {
        this.zzime = locationSettingsRequest;
        super(googleApiClient);
    }

    protected final /* synthetic */ void zza(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        ((zzcfk) com_google_android_gms_common_api_Api_zzb).zza(this.zzime, (zzn) this, this.zzimf);
    }

    public final /* synthetic */ Result zzb(Status status) {
        return new LocationSettingsResult(status);
    }
}
