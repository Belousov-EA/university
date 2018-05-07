package com.google.android.gms.common.api.internal;

final class zzw implements Runnable {
    private /* synthetic */ zzv zzfpu;

    zzw(zzv com_google_android_gms_common_api_internal_zzv) {
        this.zzfpu = com_google_android_gms_common_api_internal_zzv;
    }

    public final void run() {
        this.zzfpu.zzfps.lock();
        try {
            this.zzfpu.zzahl();
        } finally {
            this.zzfpu.zzfps.unlock();
        }
    }
}
