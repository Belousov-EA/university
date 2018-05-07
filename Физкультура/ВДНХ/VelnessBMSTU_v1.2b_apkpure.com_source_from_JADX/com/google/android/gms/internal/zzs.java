package com.google.android.gms.internal;

final class zzs implements Runnable {
    private /* synthetic */ String zzat;
    private /* synthetic */ long zzau;
    private /* synthetic */ zzr zzav;

    zzs(zzr com_google_android_gms_internal_zzr, String str, long j) {
        this.zzav = com_google_android_gms_internal_zzr;
        this.zzat = str;
        this.zzau = j;
    }

    public final void run() {
        this.zzav.zzaf.zza(this.zzat, this.zzau);
        this.zzav.zzaf.zzc(toString());
    }
}
