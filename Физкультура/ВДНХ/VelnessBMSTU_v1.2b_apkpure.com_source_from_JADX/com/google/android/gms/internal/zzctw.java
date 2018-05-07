package com.google.android.gms.internal;

import android.database.ContentObserver;
import android.os.Handler;

final class zzctw extends ContentObserver {
    private /* synthetic */ zzctv zzjwj;

    zzctw(zzctv com_google_android_gms_internal_zzctv, Handler handler) {
        this.zzjwj = com_google_android_gms_internal_zzctv;
        super(null);
    }

    public final void onChange(boolean z) {
        this.zzjwj.zzbcn();
    }
}
