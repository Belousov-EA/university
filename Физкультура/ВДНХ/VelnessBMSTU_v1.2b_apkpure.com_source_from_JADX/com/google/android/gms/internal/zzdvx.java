package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import java.util.Map;

final class zzdvx implements zzdwb {
    private final int zzmej;
    private final int zzmek;
    private final Map<String, Integer> zzmel;
    private final boolean zzmem;

    public zzdvx(int i, int i2, @NonNull Map<String, Integer> map, boolean z) {
        this.zzmej = i;
        this.zzmek = i2;
        this.zzmel = (Map) zzbq.checkNotNull(map);
        this.zzmem = z;
    }

    public final boolean zzd(zzdwa com_google_android_gms_internal_zzdwa) {
        if (!this.zzmem) {
            return true;
        }
        if (this.zzmek <= this.zzmej) {
            return false;
        }
        Integer num = (Integer) this.zzmel.get(com_google_android_gms_internal_zzdwa.zzbrk());
        return num == null ? false : num.intValue() > this.zzmej;
    }
}
