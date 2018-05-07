package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zzcdq extends zzcds {
    private /* synthetic */ long zzikq;
    private /* synthetic */ PendingIntent zzikr;

    zzcdq(zzcdp com_google_android_gms_internal_zzcdp, GoogleApiClient googleApiClient, long j, PendingIntent pendingIntent) {
        this.zzikq = j;
        this.zzikr = pendingIntent;
        super(googleApiClient);
    }

    protected final /* synthetic */ void zza(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        ((zzcfk) com_google_android_gms_common_api_Api_zzb).zza(this.zzikq, this.zzikr);
        setResult(Status.zzfni);
    }
}
