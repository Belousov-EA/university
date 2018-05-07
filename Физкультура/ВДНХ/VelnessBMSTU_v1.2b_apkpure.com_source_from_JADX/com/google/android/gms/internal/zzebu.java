package com.google.android.gms.internal;

import java.util.List;
import java.util.Map;

final class zzebu implements zzebx {
    private /* synthetic */ zzebo zzmot;
    private /* synthetic */ zzecb zzmpa;

    zzebu(zzebo com_google_android_gms_internal_zzebo, zzecb com_google_android_gms_internal_zzecb) {
        this.zzmot = com_google_android_gms_internal_zzebo;
        this.zzmpa = com_google_android_gms_internal_zzecb;
    }

    public final void zzaj(Map<String, Object> map) {
        String str = (String) map.get("s");
        if (str.equals("ok")) {
            Map map2 = (Map) map.get("d");
            if (map2.containsKey("w")) {
                this.zzmot.zza((List) map2.get("w"), this.zzmpa.zzmpm);
            }
        }
        if (((zzecb) this.zzmot.zzmoh.get(this.zzmpa.zzbuu())) != this.zzmpa) {
            return;
        }
        if (str.equals("ok")) {
            this.zzmpa.zzmpl.zzbd(null, null);
            return;
        }
        this.zzmot.zza(this.zzmpa.zzbuu());
        this.zzmpa.zzmpl.zzbd(str, (String) map.get("d"));
    }
}
