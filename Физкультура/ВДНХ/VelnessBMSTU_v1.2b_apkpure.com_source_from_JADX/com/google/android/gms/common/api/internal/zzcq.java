package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzcq<A extends zzb, L> {
    private final zzci<L> zzfus;

    protected zzcq(zzci<L> com_google_android_gms_common_api_internal_zzci_L) {
        this.zzfus = com_google_android_gms_common_api_internal_zzci_L;
    }

    public final zzck<L> zzajo() {
        return this.zzfus.zzajo();
    }

    public final void zzajp() {
        this.zzfus.clear();
    }

    protected abstract void zzb(A a, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException;
}
