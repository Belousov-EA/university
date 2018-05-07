package com.google.android.gms.internal;

final class zze implements Runnable {
    private /* synthetic */ zzr zzn;
    private /* synthetic */ zzd zzo;

    zze(zzd com_google_android_gms_internal_zzd, zzr com_google_android_gms_internal_zzr) {
        this.zzo = com_google_android_gms_internal_zzd;
        this.zzn = com_google_android_gms_internal_zzr;
    }

    public final void run() {
        try {
            this.zzo.zzi.put(this.zzn);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
