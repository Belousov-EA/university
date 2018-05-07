package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;

final class zzefp implements Callable<List<? extends zzeib>> {
    private /* synthetic */ long zzmuf;
    private /* synthetic */ boolean zzmvv;
    private /* synthetic */ zzefh zzmvz;
    private /* synthetic */ boolean zzmwj;
    private /* synthetic */ zzeli zzmwk;

    zzefp(zzefh com_google_android_gms_internal_zzefh, boolean z, long j, boolean z2, zzeli com_google_android_gms_internal_zzeli) {
        this.zzmvz = com_google_android_gms_internal_zzefh;
        this.zzmvv = z;
        this.zzmuf = j;
        this.zzmwj = z2;
        this.zzmwk = com_google_android_gms_internal_zzeli;
    }

    public final /* synthetic */ Object call() throws Exception {
        if (this.zzmvv) {
            this.zzmvz.zzmvn.zzbl(this.zzmuf);
        }
        zzegd zzbv = this.zzmvz.zzmvp.zzbv(this.zzmuf);
        boolean zzbw = this.zzmvz.zzmvp.zzbw(this.zzmuf);
        if (zzbv.isVisible() && !this.zzmwj) {
            Map zza = zzeex.zza(this.zzmwk);
            if (zzbv.zzbxb()) {
                this.zzmvz.zzmvn.zzk(zzbv.zzbsy(), zzeex.zza(zzbv.zzbwz(), zza));
            } else {
                this.zzmvz.zzmvn.zzc(zzbv.zzbsy(), zzeex.zza(zzbv.zzbxa(), zza));
            }
        }
        if (!zzbw) {
            return Collections.emptyList();
        }
        zzehm zzb;
        zzehm zzbxw = zzehm.zzbxw();
        if (zzbv.zzbxb()) {
            zzb = zzbxw.zzb(zzedk.zzbwe(), Boolean.valueOf(true));
        } else {
            Iterator it = zzbv.zzbxa().iterator();
            zzb = zzbxw;
            while (it.hasNext()) {
                zzb = zzb.zzb((zzedk) ((Entry) it.next()).getKey(), Boolean.valueOf(true));
            }
        }
        return this.zzmvz.zza(new zzegl(zzbv.zzbsy(), zzb, this.zzmwj));
    }
}
