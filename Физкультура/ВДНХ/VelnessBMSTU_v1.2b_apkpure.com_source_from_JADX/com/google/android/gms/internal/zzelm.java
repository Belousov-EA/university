package com.google.android.gms.internal;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class zzelm implements ThreadFactory {
    final /* synthetic */ zzelk zznez;

    private zzelm(zzelk com_google_android_gms_internal_zzelk) {
        this.zznez = com_google_android_gms_internal_zzelk;
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
        zzegb com_google_android_gms_internal_zzegb = zzegb.zzmwp;
        com_google_android_gms_internal_zzegb.zza(newThread, "FirebaseDatabaseWorker");
        com_google_android_gms_internal_zzegb.zza(newThread, true);
        com_google_android_gms_internal_zzegb.zza(newThread, new zzeln(this));
        return newThread;
    }
}
