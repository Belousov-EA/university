package com.google.android.gms.internal;

import java.util.Map;

final class zzebr implements zzebx {
    private /* synthetic */ zzece zzmow;

    zzebr(zzebo com_google_android_gms_internal_zzebo, zzece com_google_android_gms_internal_zzece) {
        this.zzmow = com_google_android_gms_internal_zzece;
    }

    public final void zzaj(Map<String, Object> map) {
        String str = null;
        String str2 = (String) map.get("s");
        if (str2.equals("ok")) {
            str2 = null;
        } else {
            str = (String) map.get("d");
        }
        if (this.zzmow != null) {
            this.zzmow.zzbd(str2, str);
        }
    }
}
