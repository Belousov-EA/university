package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;

public final class zzdzv implements zzedj {
    private final Handler handler = new Handler(Looper.getMainLooper());

    public final void zzm(Runnable runnable) {
        this.handler.post(runnable);
    }
}
