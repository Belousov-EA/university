package com.google.android.gms.internal;

final class zzfhx {
    private static final Class<?> zzpjv = zzczh();
    private static final zzfin<?, ?> zzpjw = zzdh(false);
    private static final zzfin<?, ?> zzpjx = zzdh(true);
    private static final zzfin<?, ?> zzpjy = new zzfip();

    public static zzfin<?, ?> zzcze() {
        return zzpjw;
    }

    public static zzfin<?, ?> zzczf() {
        return zzpjx;
    }

    public static zzfin<?, ?> zzczg() {
        return zzpjy;
    }

    private static Class<?> zzczh() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable th) {
            return null;
        }
    }

    private static Class<?> zzczi() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable th) {
            return null;
        }
    }

    private static zzfin<?, ?> zzdh(boolean z) {
        try {
            Class zzczi = zzczi();
            if (zzczi == null) {
                return null;
            }
            return (zzfin) zzczi.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable th) {
            return null;
        }
    }

    public static void zzm(Class<?> cls) {
        if (!zzffu.class.isAssignableFrom(cls) && zzpjv != null && !zzpjv.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }
}
