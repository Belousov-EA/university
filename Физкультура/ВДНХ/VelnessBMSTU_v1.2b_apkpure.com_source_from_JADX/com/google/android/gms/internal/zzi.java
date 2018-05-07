package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class zzi implements zzz {
    private final Executor zzv;

    public zzi(Handler handler) {
        this.zzv = new zzj(this, handler);
    }

    public final void zza(zzr<?> com_google_android_gms_internal_zzr_, zzad com_google_android_gms_internal_zzad) {
        com_google_android_gms_internal_zzr_.zzb("post-error");
        this.zzv.execute(new zzk(this, com_google_android_gms_internal_zzr_, zzw.zzc(com_google_android_gms_internal_zzad), null));
    }

    public final void zza(zzr<?> com_google_android_gms_internal_zzr_, zzw<?> com_google_android_gms_internal_zzw_, Runnable runnable) {
        com_google_android_gms_internal_zzr_.zzj();
        com_google_android_gms_internal_zzr_.zzb("post-response");
        this.zzv.execute(new zzk(this, com_google_android_gms_internal_zzr_, com_google_android_gms_internal_zzw_, runnable));
    }

    public final void zzb(zzr<?> com_google_android_gms_internal_zzr_, zzw<?> com_google_android_gms_internal_zzw_) {
        zza(com_google_android_gms_internal_zzr_, com_google_android_gms_internal_zzw_, null);
    }
}
