package com.google.android.gms.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class zzefo implements Callable<List<? extends zzeib>> {
    private /* synthetic */ zzedk zzmrv;
    private /* synthetic */ long zzmuf;
    private /* synthetic */ boolean zzmvv;
    private /* synthetic */ zzefh zzmvz;
    private /* synthetic */ zzecy zzmwh;
    private /* synthetic */ zzecy zzmwi;

    zzefo(zzefh com_google_android_gms_internal_zzefh, boolean z, zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy, long j, zzecy com_google_android_gms_internal_zzecy2) {
        this.zzmvz = com_google_android_gms_internal_zzefh;
        this.zzmvv = z;
        this.zzmrv = com_google_android_gms_internal_zzedk;
        this.zzmwh = com_google_android_gms_internal_zzecy;
        this.zzmuf = j;
        this.zzmwi = com_google_android_gms_internal_zzecy2;
    }

    public final /* synthetic */ Object call() throws Exception {
        if (this.zzmvv) {
            this.zzmvz.zzmvn.zza(this.zzmrv, this.zzmwh, this.zzmuf);
        }
        this.zzmvz.zzmvp.zza(this.zzmrv, this.zzmwi, Long.valueOf(this.zzmuf));
        return this.zzmvz.zza(new zzegn(zzegq.zzmxs, this.zzmrv, this.zzmwi));
    }
}
