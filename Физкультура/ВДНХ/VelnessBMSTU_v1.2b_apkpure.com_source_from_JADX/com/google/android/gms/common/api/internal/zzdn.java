package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzdn<A extends zzb, L> {
    private final zzck<L> zzful;

    protected zzdn(zzck<L> com_google_android_gms_common_api_internal_zzck_L) {
        this.zzful = com_google_android_gms_common_api_internal_zzck_L;
    }

    public final zzck<L> zzajo() {
        return this.zzful;
    }

    protected abstract void zzc(A a, TaskCompletionSource<Boolean> taskCompletionSource) throws RemoteException;
}
