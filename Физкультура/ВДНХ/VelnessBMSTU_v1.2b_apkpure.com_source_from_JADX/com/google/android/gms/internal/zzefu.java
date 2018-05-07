package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

final class zzefu implements Callable<List<? extends zzeib>> {
    private /* synthetic */ zzefh zzmvz;
    private /* synthetic */ zzega zzmwa;

    zzefu(zzefh com_google_android_gms_internal_zzefh, zzega com_google_android_gms_internal_zzega) {
        this.zzmvz = com_google_android_gms_internal_zzefh;
        this.zzmwa = com_google_android_gms_internal_zzega;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzeik zza = this.zzmvz.zzb(this.zzmwa);
        if (zza == null) {
            return Collections.emptyList();
        }
        this.zzmvz.zzmvn.zzi(zza);
        return this.zzmvz.zza(zza, new zzegm(zzegq.zzc(zza.zzbyy()), zzedk.zzbwe()));
    }
}
