package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zzn;
import com.google.android.gms.location.zzag;

final class zzces extends zzcet {
    private /* synthetic */ zzag zzill;

    zzces(zzceq com_google_android_gms_internal_zzceq, GoogleApiClient googleApiClient, zzag com_google_android_gms_location_zzag) {
        this.zzill = com_google_android_gms_location_zzag;
        super(googleApiClient);
    }

    protected final /* synthetic */ void zza(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        ((zzcfk) com_google_android_gms_common_api_Api_zzb).zza(this.zzill, (zzn) this);
    }
}
