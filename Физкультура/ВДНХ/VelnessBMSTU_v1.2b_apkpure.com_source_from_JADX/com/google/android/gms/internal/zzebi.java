package com.google.android.gms.internal;

import java.util.concurrent.ScheduledExecutorService;

public final class zzebi {
    private final ScheduledExecutorService zzmlf;
    private final zzebg zzmnp;
    private final zzejd zzmnq;
    private final boolean zzmnr;
    private final String zzmns;
    private final String zzmnt;
    private final String zzmnu;

    public zzebi(zzejd com_google_android_gms_internal_zzejd, zzebg com_google_android_gms_internal_zzebg, ScheduledExecutorService scheduledExecutorService, boolean z, String str, String str2, String str3) {
        this.zzmnq = com_google_android_gms_internal_zzejd;
        this.zzmnp = com_google_android_gms_internal_zzebg;
        this.zzmlf = scheduledExecutorService;
        this.zzmnr = z;
        this.zzmns = str;
        this.zzmnt = str2;
        this.zzmnu = str3;
    }

    public final boolean isPersistenceEnabled() {
        return this.zzmnr;
    }

    public final zzejd zzbub() {
        return this.zzmnq;
    }

    public final zzebg zzbuc() {
        return this.zzmnp;
    }

    public final ScheduledExecutorService zzbud() {
        return this.zzmlf;
    }

    public final String zzbue() {
        return this.zzmns;
    }

    public final String zzbuf() {
        return this.zzmnt;
    }

    public final String zzbug() {
        return this.zzmnu;
    }
}
