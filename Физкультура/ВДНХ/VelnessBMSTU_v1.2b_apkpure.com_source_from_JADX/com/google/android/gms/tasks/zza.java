package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

final class zza<TResult, TContinuationResult> implements zzk<TResult> {
    private final Executor zzkev;
    private final Continuation<TResult, TContinuationResult> zzkty;
    private final zzn<TContinuationResult> zzktz;

    public zza(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation, @NonNull zzn<TContinuationResult> com_google_android_gms_tasks_zzn_TContinuationResult) {
        this.zzkev = executor;
        this.zzkty = continuation;
        this.zzktz = com_google_android_gms_tasks_zzn_TContinuationResult;
    }

    public final void cancel() {
        throw new UnsupportedOperationException();
    }

    public final void onComplete(@NonNull Task<TResult> task) {
        this.zzkev.execute(new zzb(this, task));
    }
}
