package com.google.android.gms.internal;

import java.util.Map;

final class zzebv implements zzebx {
    private /* synthetic */ zzebo zzmot;

    zzebv(zzebo com_google_android_gms_internal_zzebo) {
        this.zzmot = com_google_android_gms_internal_zzebo;
    }

    public final void zzaj(Map<String, Object> map) {
        String str = (String) map.get("s");
        if (!str.equals("ok")) {
            String str2 = (String) map.get("d");
            if (this.zzmot.zzmlr.zzbzl()) {
                this.zzmot.zzmlr.zzb(new StringBuilder((String.valueOf(str).length() + 34) + String.valueOf(str2).length()).append("Failed to send stats: ").append(str).append(" (message: ").append(str2).append(")").toString(), null, new Object[0]);
            }
        }
    }
}
