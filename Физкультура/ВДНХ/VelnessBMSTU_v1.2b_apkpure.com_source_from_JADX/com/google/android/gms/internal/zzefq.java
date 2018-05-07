package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

final class zzefq implements Callable<List<? extends zzeib>> {
    private /* synthetic */ zzefh zzmvz;

    zzefq(zzefh com_google_android_gms_internal_zzefh) {
        this.zzmvz = com_google_android_gms_internal_zzefh;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzmvz.zzmvn.zzbte();
        if (this.zzmvz.zzmvp.zzbxe().isEmpty()) {
            return Collections.emptyList();
        }
        return this.zzmvz.zza(new zzegl(zzedk.zzbwe(), new zzehm(Boolean.valueOf(true)), true));
    }
}
