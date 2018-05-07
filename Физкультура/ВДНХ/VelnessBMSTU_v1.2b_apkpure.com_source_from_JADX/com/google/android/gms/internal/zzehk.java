package com.google.android.gms.internal;

import java.util.Map;
import java.util.Map.Entry;

final class zzehk implements zzehp<Map<zzeih, zzehe>, Void> {
    private /* synthetic */ zzehf zzmyw;

    zzehk(zzehf com_google_android_gms_internal_zzehf) {
        this.zzmyw = com_google_android_gms_internal_zzehf;
    }

    public final /* synthetic */ Object zza(zzedk com_google_android_gms_internal_zzedk, Object obj, Object obj2) {
        for (Entry value : ((Map) obj).entrySet()) {
            zzehe com_google_android_gms_internal_zzehe = (zzehe) value.getValue();
            if (!com_google_android_gms_internal_zzehe.complete) {
                this.zzmyw.zza(com_google_android_gms_internal_zzehe.zzbxt());
            }
        }
        return null;
    }
}
