package com.google.android.gms.internal;

import java.util.List;
import java.util.Map;

final class zzebz {
    private final List<String> zzmph;
    private final Map<String, Object> zzmpi;

    public zzebz(List<String> list, Map<String, Object> map) {
        this.zzmph = list;
        this.zzmpi = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzebz)) {
            return false;
        }
        zzebz com_google_android_gms_internal_zzebz = (zzebz) obj;
        return this.zzmph.equals(com_google_android_gms_internal_zzebz.zzmph) ? this.zzmpi.equals(com_google_android_gms_internal_zzebz.zzmpi) : false;
    }

    public final int hashCode() {
        return (this.zzmph.hashCode() * 31) + this.zzmpi.hashCode();
    }

    public final String toString() {
        String zzas = zzebj.zzas(this.zzmph);
        String valueOf = String.valueOf(this.zzmpi);
        return new StringBuilder((String.valueOf(zzas).length() + 11) + String.valueOf(valueOf).length()).append(zzas).append(" (params: ").append(valueOf).append(")").toString();
    }
}
