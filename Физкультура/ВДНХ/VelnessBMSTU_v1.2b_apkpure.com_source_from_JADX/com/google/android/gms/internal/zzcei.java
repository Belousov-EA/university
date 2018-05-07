package com.google.android.gms.internal;

import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzcm;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;

final class zzcei extends zzcem {
    private /* synthetic */ LocationRequest zzild;
    private /* synthetic */ LocationCallback zzilf;
    private /* synthetic */ Looper zzili;

    zzcei(zzceb com_google_android_gms_internal_zzceb, GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        this.zzild = locationRequest;
        this.zzilf = locationCallback;
        this.zzili = looper;
        super(googleApiClient);
    }

    protected final /* synthetic */ void zza(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        ((zzcfk) com_google_android_gms_common_api_Api_zzb).zza(zzcfo.zza(this.zzild), zzcm.zzb(this.zzilf, zzcgc.zzb(this.zzili), LocationCallback.class.getSimpleName()), new zzcen(this));
    }
}
