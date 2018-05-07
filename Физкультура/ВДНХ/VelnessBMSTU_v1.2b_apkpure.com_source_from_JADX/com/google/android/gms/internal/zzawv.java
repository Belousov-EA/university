package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzdd;
import com.google.android.gms.common.api.internal.zzde;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzawv extends zzdd<zzawr, Void> {
    private TaskCompletionSource<Void> zzedx;

    private zzawv() {
    }

    protected final /* synthetic */ void zza(zzb com_google_android_gms_common_api_Api_zzb, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzawr com_google_android_gms_internal_zzawr = (zzawr) com_google_android_gms_common_api_Api_zzb;
        this.zzedx = taskCompletionSource;
        zza((zzawn) com_google_android_gms_internal_zzawr.zzakn());
    }

    protected abstract void zza(zzawn com_google_android_gms_internal_zzawn) throws RemoteException;

    protected final void zzh(Status status) {
        zzde.zza(status, null, this.zzedx);
    }
}
