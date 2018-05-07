package com.google.android.gms.internal;

import java.util.Map;

public final class zzejs extends zzejy<zzejs> {
    private Map<Object, Object> zzncm;

    public zzejs(Map<Object, Object> map, zzekd com_google_android_gms_internal_zzekd) {
        super(com_google_android_gms_internal_zzekd);
        this.zzncm = map;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzejs)) {
            return false;
        }
        zzejs com_google_android_gms_internal_zzejs = (zzejs) obj;
        return this.zzncm.equals(com_google_android_gms_internal_zzejs.zzncm) && this.zznbx.equals(com_google_android_gms_internal_zzejs.zznbx);
    }

    public final Object getValue() {
        return this.zzncm;
    }

    public final int hashCode() {
        return this.zzncm.hashCode() + this.zznbx.hashCode();
    }

    public final String zza(zzekf com_google_android_gms_internal_zzekf) {
        String zzb = zzb(com_google_android_gms_internal_zzekf);
        String valueOf = String.valueOf(this.zzncm);
        return new StringBuilder((String.valueOf(zzb).length() + 14) + String.valueOf(valueOf).length()).append(zzb).append("deferredValue:").append(valueOf).toString();
    }

    protected final zzeka zzbzm() {
        return zzeka.DeferredValue;
    }

    public final /* synthetic */ zzekd zzf(zzekd com_google_android_gms_internal_zzekd) {
        return new zzejs(this.zzncm, com_google_android_gms_internal_zzekd);
    }
}
