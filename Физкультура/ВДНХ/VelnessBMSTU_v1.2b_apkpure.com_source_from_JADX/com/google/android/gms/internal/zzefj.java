package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

final class zzefj implements Callable<List<? extends zzeib>> {
    private /* synthetic */ zzedk zzmrv;
    private /* synthetic */ zzefh zzmvz;
    private /* synthetic */ zzega zzmwa;
    private /* synthetic */ Map zzmwb;

    zzefj(zzefh com_google_android_gms_internal_zzefh, zzega com_google_android_gms_internal_zzega, zzedk com_google_android_gms_internal_zzedk, Map map) {
        this.zzmvz = com_google_android_gms_internal_zzefh;
        this.zzmwa = com_google_android_gms_internal_zzega;
        this.zzmrv = com_google_android_gms_internal_zzedk;
        this.zzmwb = map;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzeik zza = this.zzmvz.zzb(this.zzmwa);
        if (zza == null) {
            return Collections.emptyList();
        }
        zzedk zza2 = zzedk.zza(zza.zzbsy(), this.zzmrv);
        zzecy zzal = zzecy.zzal(this.zzmwb);
        this.zzmvz.zzmvn.zzd(this.zzmrv, zzal);
        return this.zzmvz.zza(zza, new zzegn(zzegq.zzc(zza.zzbyy()), zza2, zzal));
    }
}
