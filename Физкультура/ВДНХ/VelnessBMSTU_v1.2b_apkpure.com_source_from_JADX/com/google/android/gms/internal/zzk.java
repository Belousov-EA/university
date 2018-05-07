package com.google.android.gms.internal;

final class zzk implements Runnable {
    private final zzr zzx;
    private final zzw zzy;
    private final Runnable zzz;

    public zzk(zzi com_google_android_gms_internal_zzi, zzr com_google_android_gms_internal_zzr, zzw com_google_android_gms_internal_zzw, Runnable runnable) {
        this.zzx = com_google_android_gms_internal_zzr;
        this.zzy = com_google_android_gms_internal_zzw;
        this.zzz = runnable;
    }

    public final void run() {
        if ((this.zzy.zzbi == null ? 1 : null) != null) {
            this.zzx.zza(this.zzy.result);
        } else {
            this.zzx.zzb(this.zzy.zzbi);
        }
        if (this.zzy.zzbj) {
            this.zzx.zzb("intermediate-response");
        } else {
            this.zzx.zzc("done");
        }
        if (this.zzz != null) {
            this.zzz.run();
        }
    }
}
