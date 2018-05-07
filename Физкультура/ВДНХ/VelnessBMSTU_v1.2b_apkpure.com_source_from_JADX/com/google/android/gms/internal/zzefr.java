package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class zzefr implements Callable<List<? extends zzeib>> {
    private /* synthetic */ zzedk zzmrv;
    private /* synthetic */ zzekd zzmvx;
    private /* synthetic */ zzefh zzmvz;

    zzefr(zzefh com_google_android_gms_internal_zzefh, zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        this.zzmvz = com_google_android_gms_internal_zzefh;
        this.zzmrv = com_google_android_gms_internal_zzedk;
        this.zzmvx = com_google_android_gms_internal_zzekd;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzmvz.zzmvn.zza(zzeik.zzam(this.zzmrv), this.zzmvx);
        return this.zzmvz.zza(new zzegs(zzegq.zzmxt, this.zzmrv, this.zzmvx));
    }
}
