package com.google.android.gms.internal;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

final class zzefs implements Callable<List<? extends zzeib>> {
    private /* synthetic */ zzedk zzmrv;
    private /* synthetic */ zzefh zzmvz;
    private /* synthetic */ Map zzmwb;

    zzefs(zzefh com_google_android_gms_internal_zzefh, Map map, zzedk com_google_android_gms_internal_zzedk) {
        this.zzmvz = com_google_android_gms_internal_zzefh;
        this.zzmwb = map;
        this.zzmrv = com_google_android_gms_internal_zzedk;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzecy zzal = zzecy.zzal(this.zzmwb);
        this.zzmvz.zzmvn.zzd(this.zzmrv, zzal);
        return this.zzmvz.zza(new zzegn(zzegq.zzmxt, this.zzmrv, zzal));
    }
}
