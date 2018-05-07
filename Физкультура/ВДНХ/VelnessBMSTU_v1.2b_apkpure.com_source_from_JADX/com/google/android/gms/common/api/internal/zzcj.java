package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzbq;

final class zzcj extends Handler {
    private /* synthetic */ zzci zzfum;

    public zzcj(zzci com_google_android_gms_common_api_internal_zzci, Looper looper) {
        this.zzfum = com_google_android_gms_common_api_internal_zzci;
        super(looper);
    }

    public final void handleMessage(Message message) {
        boolean z = true;
        if (message.what != 1) {
            z = false;
        }
        zzbq.checkArgument(z);
        this.zzfum.zzb((zzcl) message.obj);
    }
}
