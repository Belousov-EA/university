package com.google.android.gms.internal;

import java.lang.Thread.UncaughtExceptionHandler;

final class zzeln implements UncaughtExceptionHandler {
    private /* synthetic */ zzelm zznfa;

    zzeln(zzelm com_google_android_gms_internal_zzelm) {
        this.zznfa = com_google_android_gms_internal_zzelm;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        this.zznfa.zznez.zzi(th);
    }
}
