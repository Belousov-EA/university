package com.google.android.gms.internal;

import java.util.concurrent.ScheduledExecutorService;

public final class zzecr {
    private final zzejc zzmlr;
    private long zzmra = 1000;
    private double zzmrc = 0.5d;
    private double zzmrd = 1.3d;
    private final ScheduledExecutorService zzmri;
    private long zzmrj = 30000;

    public zzecr(ScheduledExecutorService scheduledExecutorService, zzejd com_google_android_gms_internal_zzejd, String str) {
        this.zzmri = scheduledExecutorService;
        this.zzmlr = new zzejc(com_google_android_gms_internal_zzejd, str);
    }

    public final zzecr zzbs(long j) {
        this.zzmra = 1000;
        return this;
    }

    public final zzecr zzbt(long j) {
        this.zzmrj = 30000;
        return this;
    }

    public final zzecp zzbvk() {
        return new zzecp(this.zzmri, this.zzmlr, this.zzmra, this.zzmrj, this.zzmrd, this.zzmrc);
    }

    public final zzecr zzi(double d) {
        this.zzmrd = 1.3d;
        return this;
    }

    public final zzecr zzj(double d) {
        this.zzmrc = 0.7d;
        return this;
    }
}
