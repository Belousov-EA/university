package com.google.android.gms.internal;

import java.util.Map;

public final class zzelg {
    private final String zzldj;
    private final Map<String, Object> zznex;

    private zzelg(String str, Map<String, Object> map) {
        this.zzldj = str;
        this.zznex = map;
    }

    public static zzelg zzqa(String str) {
        if (!str.startsWith("gauth|")) {
            return null;
        }
        try {
            Map zzqb = zzelh.zzqb(str.substring(6));
            return new zzelg((String) zzqb.get("token"), (Map) zzqb.get("auth"));
        } catch (Throwable e) {
            throw new RuntimeException("Failed to parse gauth token", e);
        }
    }

    public final String getToken() {
        return this.zzldj;
    }

    public final Map<String, Object> zzcbf() {
        return this.zznex;
    }
}
