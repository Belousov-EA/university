package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzdd<A extends zzb, TResult> {
    protected abstract void zza(A a, TaskCompletionSource<TResult> taskCompletionSource) throws RemoteException;
}
