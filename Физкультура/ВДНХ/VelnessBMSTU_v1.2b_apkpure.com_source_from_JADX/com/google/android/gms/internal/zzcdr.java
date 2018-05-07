package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zzcdr extends zzcds {
    private /* synthetic */ PendingIntent zzikr;

    zzcdr(zzcdp com_google_android_gms_internal_zzcdp, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        this.zzikr = pendingIntent;
        super(googleApiClient);
    }

    protected final /* synthetic */ void zza(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        ((zzcfk) com_google_android_gms_common_api_Api_zzb).zzc(this.zzikr);
        setResult(Status.zzfni);
    }
}
