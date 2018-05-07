package com.google.android.gms.internal;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public final class zzn extends Thread {
    private final BlockingQueue<zzr<?>> zzaa;
    private final zzm zzab;
    private final zzb zzj;
    private final zzz zzk;
    private volatile boolean zzl = false;

    public zzn(BlockingQueue<zzr<?>> blockingQueue, zzm com_google_android_gms_internal_zzm, zzb com_google_android_gms_internal_zzb, zzz com_google_android_gms_internal_zzz) {
        this.zzaa = blockingQueue;
        this.zzab = com_google_android_gms_internal_zzm;
        this.zzj = com_google_android_gms_internal_zzb;
        this.zzk = com_google_android_gms_internal_zzz;
    }

    public final void quit() {
        this.zzl = true;
        interrupt();
    }

    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                zzr com_google_android_gms_internal_zzr = (zzr) this.zzaa.take();
                try {
                    com_google_android_gms_internal_zzr.zzb("network-queue-take");
                    TrafficStats.setThreadStatsTag(com_google_android_gms_internal_zzr.zzd());
                    zzp zzc = this.zzab.zzc(com_google_android_gms_internal_zzr);
                    com_google_android_gms_internal_zzr.zzb("network-http-complete");
                    if (zzc.zzad && com_google_android_gms_internal_zzr.zzk()) {
                        com_google_android_gms_internal_zzr.zzc("not-modified");
                        com_google_android_gms_internal_zzr.zzl();
                    } else {
                        zzw zza = com_google_android_gms_internal_zzr.zza(zzc);
                        com_google_android_gms_internal_zzr.zzb("network-parse-complete");
                        if (com_google_android_gms_internal_zzr.zzg() && zza.zzbh != null) {
                            this.zzj.zza(com_google_android_gms_internal_zzr.getUrl(), zza.zzbh);
                            com_google_android_gms_internal_zzr.zzb("network-cache-written");
                        }
                        com_google_android_gms_internal_zzr.zzj();
                        this.zzk.zzb(com_google_android_gms_internal_zzr, zza);
                        com_google_android_gms_internal_zzr.zza(zza);
                    }
                } catch (zzad e) {
                    e.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.zzk.zza(com_google_android_gms_internal_zzr, e);
                    com_google_android_gms_internal_zzr.zzl();
                } catch (Throwable e2) {
                    zzae.zza(e2, "Unhandled exception %s", e2.toString());
                    zzad com_google_android_gms_internal_zzad = new zzad(e2);
                    com_google_android_gms_internal_zzad.zza(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.zzk.zza(com_google_android_gms_internal_zzr, com_google_android_gms_internal_zzad);
                    com_google_android_gms_internal_zzr.zzl();
                }
            } catch (InterruptedException e3) {
                if (this.zzl) {
                    return;
                }
            }
        }
    }
}
