package com.google.android.gms.tasks;

import android.app.Activity;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.zzcf;
import com.google.android.gms.common.internal.zzbq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

final class zzn<TResult> extends Task<TResult> {
    private final Object mLock = new Object();
    private final zzl<TResult> zzkun = new zzl();
    private boolean zzkuo;
    private TResult zzkup;
    private Exception zzkuq;

    static class zza extends LifecycleCallback {
        private final List<WeakReference<zzk<?>>> zzezo = new ArrayList();

        private zza(zzcf com_google_android_gms_common_api_internal_zzcf) {
            super(com_google_android_gms_common_api_internal_zzcf);
            this.zzfud.zza("TaskOnStopCallback", (LifecycleCallback) this);
        }

        public static zza zzr(Activity activity) {
            zzcf zzn = LifecycleCallback.zzn(activity);
            zza com_google_android_gms_tasks_zzn_zza = (zza) zzn.zza("TaskOnStopCallback", zza.class);
            return com_google_android_gms_tasks_zzn_zza == null ? new zza(zzn) : com_google_android_gms_tasks_zzn_zza;
        }

        @MainThread
        public final void onStop() {
            synchronized (this.zzezo) {
                for (WeakReference weakReference : this.zzezo) {
                    zzk com_google_android_gms_tasks_zzk = (zzk) weakReference.get();
                    if (com_google_android_gms_tasks_zzk != null) {
                        com_google_android_gms_tasks_zzk.cancel();
                    }
                }
                this.zzezo.clear();
            }
        }

        public final <T> void zzb(zzk<T> com_google_android_gms_tasks_zzk_T) {
            synchronized (this.zzezo) {
                this.zzezo.add(new WeakReference(com_google_android_gms_tasks_zzk_T));
            }
        }
    }

    zzn() {
    }

    private final void zzbjk() {
        zzbq.zza(this.zzkuo, (Object) "Task is not yet complete");
    }

    private final void zzbjl() {
        zzbq.zza(!this.zzkuo, (Object) "Task is already complete");
    }

    private final void zzbjm() {
        synchronized (this.mLock) {
            if (this.zzkuo) {
                this.zzkun.zzb(this);
                return;
            }
        }
    }

    @NonNull
    public final Task<TResult> addOnCompleteListener(@NonNull Activity activity, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        zzk com_google_android_gms_tasks_zze = new zze(TaskExecutors.MAIN_THREAD, onCompleteListener);
        this.zzkun.zza(com_google_android_gms_tasks_zze);
        zza.zzr(activity).zzb(com_google_android_gms_tasks_zze);
        zzbjm();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.MAIN_THREAD, (OnCompleteListener) onCompleteListener);
    }

    @NonNull
    public final Task<TResult> addOnCompleteListener(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.zzkun.zza(new zze(executor, onCompleteListener));
        zzbjm();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnFailureListener(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
        zzk com_google_android_gms_tasks_zzg = new zzg(TaskExecutors.MAIN_THREAD, onFailureListener);
        this.zzkun.zza(com_google_android_gms_tasks_zzg);
        zza.zzr(activity).zzb(com_google_android_gms_tasks_zzg);
        zzbjm();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnFailureListener(@NonNull OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
    }

    @NonNull
    public final Task<TResult> addOnFailureListener(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.zzkun.zza(new zzg(executor, onFailureListener));
        zzbjm();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnSuccessListener(@NonNull Activity activity, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        zzk com_google_android_gms_tasks_zzi = new zzi(TaskExecutors.MAIN_THREAD, onSuccessListener);
        this.zzkun.zza(com_google_android_gms_tasks_zzi);
        zza.zzr(activity).zzb(com_google_android_gms_tasks_zzi);
        zzbjm();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.MAIN_THREAD, (OnSuccessListener) onSuccessListener);
    }

    @NonNull
    public final Task<TResult> addOnSuccessListener(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.zzkun.zza(new zzi(executor, onSuccessListener));
        zzbjm();
        return this;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation) {
        Task com_google_android_gms_tasks_zzn = new zzn();
        this.zzkun.zza(new zza(executor, continuation, com_google_android_gms_tasks_zzn));
        zzbjm();
        return com_google_android_gms_tasks_zzn;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        Task com_google_android_gms_tasks_zzn = new zzn();
        this.zzkun.zza(new zzc(executor, continuation, com_google_android_gms_tasks_zzn));
        zzbjm();
        return com_google_android_gms_tasks_zzn;
    }

    @Nullable
    public final Exception getException() {
        Exception exception;
        synchronized (this.mLock) {
            exception = this.zzkuq;
        }
        return exception;
    }

    public final TResult getResult() {
        TResult tResult;
        synchronized (this.mLock) {
            zzbjk();
            if (this.zzkuq != null) {
                throw new RuntimeExecutionException(this.zzkuq);
            }
            tResult = this.zzkup;
        }
        return tResult;
    }

    public final <X extends Throwable> TResult getResult(@NonNull Class<X> cls) throws Throwable {
        TResult tResult;
        synchronized (this.mLock) {
            zzbjk();
            if (cls.isInstance(this.zzkuq)) {
                throw ((Throwable) cls.cast(this.zzkuq));
            } else if (this.zzkuq != null) {
                throw new RuntimeExecutionException(this.zzkuq);
            } else {
                tResult = this.zzkup;
            }
        }
        return tResult;
    }

    public final boolean isComplete() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzkuo;
        }
        return z;
    }

    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzkuo && this.zzkuq == null;
        }
        return z;
    }

    public final void setException(@NonNull Exception exception) {
        zzbq.checkNotNull(exception, "Exception must not be null");
        synchronized (this.mLock) {
            zzbjl();
            this.zzkuo = true;
            this.zzkuq = exception;
        }
        this.zzkun.zzb(this);
    }

    public final void setResult(TResult tResult) {
        synchronized (this.mLock) {
            zzbjl();
            this.zzkuo = true;
            this.zzkup = tResult;
        }
        this.zzkun.zzb(this);
    }

    public final boolean trySetException(@NonNull Exception exception) {
        boolean z = true;
        zzbq.checkNotNull(exception, "Exception must not be null");
        synchronized (this.mLock) {
            if (this.zzkuo) {
                z = false;
            } else {
                this.zzkuo = true;
                this.zzkuq = exception;
                this.zzkun.zzb(this);
            }
        }
        return z;
    }

    public final boolean trySetResult(TResult tResult) {
        boolean z = true;
        synchronized (this.mLock) {
            if (this.zzkuo) {
                z = false;
            } else {
                this.zzkuo = true;
                this.zzkup = tResult;
                this.zzkun.zzb(this);
            }
        }
        return z;
    }
}
