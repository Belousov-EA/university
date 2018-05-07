package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zzcee extends zzcem {
    private /* synthetic */ boolean zzilg;

    zzcee(zzceb com_google_android_gms_internal_zzceb, GoogleApiClient googleApiClient, boolean z) {
        this.zzilg = z;
        super(googleApiClient);
    }

    protected final /* synthetic */ void zza(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        ((zzcfk) com_google_android_gms_common_api_Api_zzb).zzbj(this.zzilg);
        setResult(Status.zzfni);
    }
}
