package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

final class zzc<TResult, TContinuationResult> implements OnFailureListener, OnSuccessListener<TContinuationResult>, zzk<TResult> {
    private final Executor zzkev;
    private final Continuation<TResult, Task<TContinuationResult>> zzkty;
    private final zzn<TContinuationResult> zzktz;

    public zzc(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation, @NonNull zzn<TContinuationResult> com_google_android_gms_tasks_zzn_TContinuationResult) {
        this.zzkev = executor;
        this.zzkty = continuation;
        this.zzktz = com_google_android_gms_tasks_zzn_TContinuationResult;
    }

    public final void cancel() {
        throw new UnsupportedOperationException();
    }

    public final void onComplete(@NonNull Task<TResult> task) {
        this.zzkev.execute(new zzd(this, task));
    }

    public final void onFailure(@NonNull Exception exception) {
        this.zzktz.setException(exception);
    }

    public final void onSuccess(TContinuationResult tContinuationResult) {
        this.zzktz.setResult(tContinuationResult);
    }
}
