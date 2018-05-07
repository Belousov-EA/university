package com.google.android.gms.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.common.api.internal.zzcq;
import com.google.android.gms.internal.zzcfk;
import com.google.android.gms.internal.zzcfo;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzi extends zzcq<zzcfk, LocationCallback> {
    private /* synthetic */ zzci zzhlf;
    private /* synthetic */ zzcfo zziiw;

    zzi(FusedLocationProviderClient fusedLocationProviderClient, zzci com_google_android_gms_common_api_internal_zzci, zzcfo com_google_android_gms_internal_zzcfo, zzci com_google_android_gms_common_api_internal_zzci2) {
        this.zziiw = com_google_android_gms_internal_zzcfo;
        this.zzhlf = com_google_android_gms_common_api_internal_zzci2;
        super(com_google_android_gms_common_api_internal_zzci);
    }

    protected final /* synthetic */ void zzb(zzb com_google_android_gms_common_api_Api_zzb, TaskCompletionSource taskCompletionSource) throws RemoteException {
        ((zzcfk) com_google_android_gms_common_api_Api_zzb).zza(this.zziiw, this.zzhlf, new zza(taskCompletionSource));
    }
}
