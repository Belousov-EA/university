package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

final class zzell extends ScheduledThreadPoolExecutor {
    private /* synthetic */ zzelk zznez;

    zzell(zzelk com_google_android_gms_internal_zzelk, int i, ThreadFactory threadFactory) {
        this.zznez = com_google_android_gms_internal_zzelk;
        super(1, threadFactory);
    }

    protected final void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            Future future = (Future) runnable;
            try {
                if (future.isDone()) {
                    future.get();
                }
            } catch (CancellationException e) {
            } catch (ExecutionException e2) {
                th = e2.getCause();
            } catch (InterruptedException e3) {
                Thread.currentThread().interrupt();
            }
        }
        if (th != null) {
            this.zznez.zzi(th);
        }
    }
}
