package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public final class zzd extends Thread {
    private static final boolean DEBUG = zzae.DEBUG;
    private final BlockingQueue<zzr<?>> zzh;
    private final BlockingQueue<zzr<?>> zzi;
    private final zzb zzj;
    private final zzz zzk;
    private volatile boolean zzl = false;
    private final zzf zzm;

    public zzd(BlockingQueue<zzr<?>> blockingQueue, BlockingQueue<zzr<?>> blockingQueue2, zzb com_google_android_gms_internal_zzb, zzz com_google_android_gms_internal_zzz) {
        this.zzh = blockingQueue;
        this.zzi = blockingQueue2;
        this.zzj = com_google_android_gms_internal_zzb;
        this.zzk = com_google_android_gms_internal_zzz;
        this.zzm = new zzf(this);
    }

    public final void quit() {
        this.zzl = true;
        interrupt();
    }

    public final void run() {
        if (DEBUG) {
            zzae.zza("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzj.initialize();
        while (true) {
            try {
                zzr com_google_android_gms_internal_zzr = (zzr) this.zzh.take();
                com_google_android_gms_internal_zzr.zzb("cache-queue-take");
                zzc zza = this.zzj.zza(com_google_android_gms_internal_zzr.getUrl());
                if (zza == null) {
                    com_google_android_gms_internal_zzr.zzb("cache-miss");
                    if (!this.zzm.zzb(com_google_android_gms_internal_zzr)) {
                        this.zzi.put(com_google_android_gms_internal_zzr);
                    }
                } else if (zza.zza()) {
                    com_google_android_gms_internal_zzr.zzb("cache-hit-expired");
                    com_google_android_gms_internal_zzr.zza(zza);
                    if (!this.zzm.zzb(com_google_android_gms_internal_zzr)) {
                        this.zzi.put(com_google_android_gms_internal_zzr);
                    }
                } else {
                    com_google_android_gms_internal_zzr.zzb("cache-hit");
                    zzw zza2 = com_google_android_gms_internal_zzr.zza(new zzp(zza.data, zza.zzf));
                    com_google_android_gms_internal_zzr.zzb("cache-hit-parsed");
                    if ((zza.zze < System.currentTimeMillis() ? 1 : 0) == 0) {
                        this.zzk.zzb(com_google_android_gms_internal_zzr, zza2);
                    } else {
                        com_google_android_gms_internal_zzr.zzb("cache-hit-refresh-needed");
                        com_google_android_gms_internal_zzr.zza(zza);
                        zza2.zzbj = true;
                        if (this.zzm.zzb(com_google_android_gms_internal_zzr)) {
                            this.zzk.zzb(com_google_android_gms_internal_zzr, zza2);
                        } else {
                            this.zzk.zza(com_google_android_gms_internal_zzr, zza2, new zze(this, com_google_android_gms_internal_zzr));
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.zzl) {
                    return;
                }
            }
        }
    }
}
