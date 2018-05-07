package com.google.android.gms.internal;

final class zzdzy implements Runnable {
    private /* synthetic */ String val$message;
    private /* synthetic */ Throwable zzmlo;

    zzdzy(zzdzx com_google_android_gms_internal_zzdzx, String str, Throwable th) {
        this.val$message = str;
        this.zzmlo = th;
    }

    public final void run() {
        throw new RuntimeException(this.val$message, this.zzmlo);
    }
}
