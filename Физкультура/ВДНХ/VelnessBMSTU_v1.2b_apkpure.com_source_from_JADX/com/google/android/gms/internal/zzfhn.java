package com.google.android.gms.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzfhn {
    private static final zzfhn zzpjb = new zzfhn();
    private final zzfhw zzpjc;
    private final ConcurrentMap<Class<?>, zzfhv<?>> zzpjd = new ConcurrentHashMap();

    private zzfhn() {
        zzfhw com_google_android_gms_internal_zzfhw = null;
        String[] strArr = new String[]{"com.google.protobuf.AndroidProto3SchemaFactory"};
        for (int i = 0; i <= 0; i++) {
            com_google_android_gms_internal_zzfhw = zztw(strArr[0]);
            if (com_google_android_gms_internal_zzfhw != null) {
                break;
            }
        }
        if (com_google_android_gms_internal_zzfhw == null) {
            com_google_android_gms_internal_zzfhw = new zzfgq();
        }
        this.zzpjc = com_google_android_gms_internal_zzfhw;
    }

    public static zzfhn zzcyz() {
        return zzpjb;
    }

    private static zzfhw zztw(String str) {
        try {
            return (zzfhw) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            return null;
        }
    }

    public final <T> zzfhv<T> zzl(Class<T> cls) {
        zzffz.zzc(cls, "messageType");
        zzfhv<T> com_google_android_gms_internal_zzfhv_T = (zzfhv) this.zzpjd.get(cls);
        if (com_google_android_gms_internal_zzfhv_T != null) {
            return com_google_android_gms_internal_zzfhv_T;
        }
        zzfhv<T> zzk = this.zzpjc.zzk(cls);
        zzffz.zzc(cls, "messageType");
        zzffz.zzc(zzk, "schema");
        com_google_android_gms_internal_zzfhv_T = (zzfhv) this.zzpjd.putIfAbsent(cls, zzk);
        return com_google_android_gms_internal_zzfhv_T != null ? com_google_android_gms_internal_zzfhv_T : zzk;
    }
}
