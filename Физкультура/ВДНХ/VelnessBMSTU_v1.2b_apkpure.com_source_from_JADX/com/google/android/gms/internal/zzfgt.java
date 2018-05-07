package com.google.android.gms.internal;

final class zzfgt implements zzfhd {
    private zzfhd[] zzpii;

    zzfgt(zzfhd... com_google_android_gms_internal_zzfhdArr) {
        this.zzpii = com_google_android_gms_internal_zzfhdArr;
    }

    public final boolean zzi(Class<?> cls) {
        for (zzfhd zzi : this.zzpii) {
            if (zzi.zzi(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzfhc zzj(Class<?> cls) {
        for (zzfhd com_google_android_gms_internal_zzfhd : this.zzpii) {
            if (com_google_android_gms_internal_zzfhd.zzi(cls)) {
                return com_google_android_gms_internal_zzfhd.zzj(cls);
            }
        }
        String str = "No factory is available for message type: ";
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }
}
