package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

final class zzj implements Executor {
    private /* synthetic */ Handler zzw;

    zzj(zzi com_google_android_gms_internal_zzi, Handler handler) {
        this.zzw = handler;
    }

    public final void execute(Runnable runnable) {
        this.zzw.post(runnable);
    }
}
