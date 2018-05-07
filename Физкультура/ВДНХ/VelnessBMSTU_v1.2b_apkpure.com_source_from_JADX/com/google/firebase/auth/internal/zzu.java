package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

public final class zzu implements Executor {
    private static zzu zzmie = new zzu();
    private Handler mHandler = new Handler(Looper.getMainLooper());

    private zzu() {
    }

    public static zzu zzbsj() {
        return zzmie;
    }

    public final void execute(@NonNull Runnable runnable) {
        this.mHandler.post(runnable);
    }
}
