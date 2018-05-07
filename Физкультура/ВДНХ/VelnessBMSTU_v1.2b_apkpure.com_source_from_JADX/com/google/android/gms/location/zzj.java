package com.google.android.gms.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.internal.zzck;
import com.google.android.gms.common.api.internal.zzdn;
import com.google.android.gms.internal.zzcfk;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzj extends zzdn<zzcfk, LocationCallback> {
    private /* synthetic */ FusedLocationProviderClient zziix;

    zzj(FusedLocationProviderClient fusedLocationProviderClient, zzck com_google_android_gms_common_api_internal_zzck) {
        this.zziix = fusedLocationProviderClient;
        super(com_google_android_gms_common_api_internal_zzck);
    }

    protected final /* synthetic */ void zzc(zzb com_google_android_gms_common_api_Api_zzb, TaskCompletionSource taskCompletionSource) throws RemoteException {
        try {
            ((zzcfk) com_google_android_gms_common_api_Api_zzb).zzb(zzajo(), this.zziix.zzc(taskCompletionSource));
        } catch (Exception e) {
            taskCompletionSource.trySetException(e);
        }
    }
}
