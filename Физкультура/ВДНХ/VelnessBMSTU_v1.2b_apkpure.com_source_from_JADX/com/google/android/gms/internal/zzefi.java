package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

final class zzefi implements Callable<List<? extends zzeib>> {
    private /* synthetic */ zzedk zzmrv;
    private /* synthetic */ long zzmuf;
    private /* synthetic */ boolean zzmvv;
    private /* synthetic */ zzekd zzmvw;
    private /* synthetic */ zzekd zzmvx;
    private /* synthetic */ boolean zzmvy;
    private /* synthetic */ zzefh zzmvz;

    zzefi(zzefh com_google_android_gms_internal_zzefh, boolean z, zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, long j, zzekd com_google_android_gms_internal_zzekd2, boolean z2) {
        this.zzmvz = com_google_android_gms_internal_zzefh;
        this.zzmvv = z;
        this.zzmrv = com_google_android_gms_internal_zzedk;
        this.zzmvw = com_google_android_gms_internal_zzekd;
        this.zzmuf = j;
        this.zzmvx = com_google_android_gms_internal_zzekd2;
        this.zzmvy = z2;
    }

    public final /* synthetic */ Object call() throws Exception {
        if (this.zzmvv) {
            this.zzmvz.zzmvn.zza(this.zzmrv, this.zzmvw, this.zzmuf);
        }
        this.zzmvz.zzmvp.zza(this.zzmrv, this.zzmvx, Long.valueOf(this.zzmuf), this.zzmvy);
        return !this.zzmvy ? Collections.emptyList() : this.zzmvz.zza(new zzegs(zzegq.zzmxs, this.zzmrv, this.zzmvx));
    }
}
