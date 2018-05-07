package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class zzeft implements Callable<List<? extends zzeib>> {
    private /* synthetic */ zzedk zzmrv;
    private /* synthetic */ zzefh zzmvz;

    zzeft(zzefh com_google_android_gms_internal_zzefh, zzedk com_google_android_gms_internal_zzedk) {
        this.zzmvz = com_google_android_gms_internal_zzefh;
        this.zzmrv = com_google_android_gms_internal_zzedk;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzmvz.zzmvn.zzi(zzeik.zzam(this.zzmrv));
        return this.zzmvz.zza(new zzegm(zzegq.zzmxt, this.zzmrv));
    }
}
