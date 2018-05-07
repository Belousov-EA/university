package com.google.android.gms.location;

import android.location.Location;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.internal.zzdd;
import com.google.android.gms.internal.zzcfk;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzg extends zzdd<zzcfk, Location> {
    zzg(FusedLocationProviderClient fusedLocationProviderClient) {
    }

    protected final /* synthetic */ void zza(zzb com_google_android_gms_common_api_Api_zzb, TaskCompletionSource taskCompletionSource) throws RemoteException {
        taskCompletionSource.setResult(((zzcfk) com_google_android_gms_common_api_Api_zzb).getLastLocation());
    }
}
