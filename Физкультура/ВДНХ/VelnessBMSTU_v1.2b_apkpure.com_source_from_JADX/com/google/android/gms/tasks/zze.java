package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

final class zze<TResult> implements zzk<TResult> {
    private final Object mLock = new Object();
    private final Executor zzkev;
    private OnCompleteListener<TResult> zzkud;

    public zze(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.zzkev = executor;
        this.zzkud = onCompleteListener;
    }

    public final void cancel() {
        synchronized (this.mLock) {
            this.zzkud = null;
        }
    }

    public final void onComplete(@NonNull Task<TResult> task) {
        synchronized (this.mLock) {
            if (this.zzkud == null) {
                return;
            }
            this.zzkev.execute(new zzf(this, task));
        }
    }
}
