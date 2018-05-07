package com.google.android.gms.internal;

import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class zzecp {
    private final Random random;
    private final ScheduledExecutorService zzmlf;
    private final zzejc zzmlr;
    private final long zzmra;
    private final long zzmrb;
    private final double zzmrc;
    private final double zzmrd;
    private ScheduledFuture<?> zzmre;
    private long zzmrf;
    private boolean zzmrg;

    private zzecp(ScheduledExecutorService scheduledExecutorService, zzejc com_google_android_gms_internal_zzejc, long j, long j2, double d, double d2) {
        this.random = new Random();
        this.zzmrg = true;
        this.zzmlf = scheduledExecutorService;
        this.zzmlr = com_google_android_gms_internal_zzejc;
        this.zzmra = j;
        this.zzmrb = j2;
        this.zzmrd = d;
        this.zzmrc = d2;
    }

    public final void cancel() {
        if (this.zzmre != null) {
            this.zzmlr.zzb("Cancelling existing retry attempt", null, new Object[0]);
            this.zzmre.cancel(false);
            this.zzmre = null;
        } else {
            this.zzmlr.zzb("No existing retry attempt to cancel", null, new Object[0]);
        }
        this.zzmrf = 0;
    }

    public final void zzbvi() {
        this.zzmrg = true;
        this.zzmrf = 0;
    }

    public final void zzbvj() {
        this.zzmrf = this.zzmrb;
    }

    public final void zzn(Runnable runnable) {
        long j = 0;
        Runnable com_google_android_gms_internal_zzecq = new zzecq(this, runnable);
        if (this.zzmre != null) {
            this.zzmlr.zzb("Cancelling previous scheduled retry", null, new Object[0]);
            this.zzmre.cancel(false);
            this.zzmre = null;
        }
        if (!this.zzmrg) {
            if (this.zzmrf == 0) {
                this.zzmrf = this.zzmra;
            } else {
                this.zzmrf = Math.min((long) (((double) this.zzmrf) * this.zzmrd), this.zzmrb);
            }
            j = (long) (((1.0d - this.zzmrc) * ((double) this.zzmrf)) + ((this.zzmrc * ((double) this.zzmrf)) * this.random.nextDouble()));
        }
        this.zzmrg = false;
        this.zzmlr.zzb("Scheduling retry in %dms", null, Long.valueOf(j));
        this.zzmre = this.zzmlf.schedule(com_google_android_gms_internal_zzecq, j, TimeUnit.MILLISECONDS);
    }
}
