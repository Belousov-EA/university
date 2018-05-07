package com.google.android.gms.internal;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class zzelk implements zzeew {
    private ScheduledThreadPoolExecutor zzney = new zzell(this, 1, new zzelm());

    public zzelk() {
        this.zzney.setKeepAliveTime(3, TimeUnit.SECONDS);
    }

    public final void restart() {
        this.zzney.setCorePoolSize(1);
    }

    public final void shutdown() {
        this.zzney.setCorePoolSize(0);
    }

    public final ScheduledExecutorService zzbud() {
        return this.zzney;
    }

    public abstract void zzi(Throwable th);

    public final void zzo(Runnable runnable) {
        this.zzney.execute(runnable);
    }
}
