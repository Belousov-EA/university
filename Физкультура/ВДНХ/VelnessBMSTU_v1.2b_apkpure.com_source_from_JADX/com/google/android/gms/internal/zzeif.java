package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

public final class zzeif {
    private final zzejc zzmlr;
    private final zzedj zzmsc;

    public zzeif(zzedc com_google_android_gms_internal_zzedc) {
        this.zzmsc = com_google_android_gms_internal_zzedc.zzbwa();
        this.zzmlr = com_google_android_gms_internal_zzedc.zzpv("EventRaiser");
    }

    public final void zzaw(List<? extends zzeib> list) {
        if (this.zzmlr.zzbzl()) {
            this.zzmlr.zzb("Raising " + list.size() + " event(s)", null, new Object[0]);
        }
        this.zzmsc.zzm(new zzeig(this, new ArrayList(list)));
    }
}
