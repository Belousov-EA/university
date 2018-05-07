package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public final class zzk extends zzax {
    private zzd zzfzc;
    private final int zzfzd;

    public zzk(@NonNull zzd com_google_android_gms_common_internal_zzd, int i) {
        this.zzfzc = com_google_android_gms_common_internal_zzd;
        this.zzfzd = i;
    }

    @BinderThread
    public final void zza(int i, @Nullable Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @BinderThread
    public final void zza(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
        zzbq.checkNotNull(this.zzfzc, "onPostInitComplete can be called only once per call to getRemoteService");
        this.zzfzc.zza(i, iBinder, bundle, this.zzfzd);
        this.zzfzc = null;
    }
}
