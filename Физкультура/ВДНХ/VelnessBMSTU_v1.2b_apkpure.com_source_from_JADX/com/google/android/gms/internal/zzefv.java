package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

final class zzefv implements Callable<List<? extends zzeib>> {
    private /* synthetic */ zzedk zzmrv;
    private /* synthetic */ zzefh zzmvz;
    private /* synthetic */ zzega zzmwa;
    private /* synthetic */ zzekd zzmwl;

    zzefv(zzefh com_google_android_gms_internal_zzefh, zzega com_google_android_gms_internal_zzega, zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        this.zzmvz = com_google_android_gms_internal_zzefh;
        this.zzmwa = com_google_android_gms_internal_zzega;
        this.zzmrv = com_google_android_gms_internal_zzedk;
        this.zzmwl = com_google_android_gms_internal_zzekd;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzeik zza = this.zzmvz.zzb(this.zzmwa);
        if (zza == null) {
            return Collections.emptyList();
        }
        zzedk zza2 = zzedk.zza(zza.zzbsy(), this.zzmrv);
        this.zzmvz.zzmvn.zza(zza2.isEmpty() ? zza : zzeik.zzam(this.zzmrv), this.zzmwl);
        return this.zzmvz.zza(zza, new zzegs(zzegq.zzc(zza.zzbyy()), zza2, this.zzmwl));
    }
}
