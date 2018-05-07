package com.google.android.gms.internal;

import android.support.annotation.WorkerThread;

final class zzclh extends zzcgs {
    private /* synthetic */ zzclf zzjjf;

    zzclh(zzclf com_google_android_gms_internal_zzclf, zzcim com_google_android_gms_internal_zzcim) {
        this.zzjjf = com_google_android_gms_internal_zzclf;
        super(com_google_android_gms_internal_zzcim);
    }

    @WorkerThread
    public final void run() {
        this.zzjjf.zzbaw();
    }
}
