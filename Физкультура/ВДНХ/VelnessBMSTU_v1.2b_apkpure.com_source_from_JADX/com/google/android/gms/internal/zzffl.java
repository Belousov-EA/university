package com.google.android.gms.internal;

final class zzffl {
    private static Class<?> zzpgd = zzcwy();

    private static Class<?> zzcwy() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static zzffm zzcwz() {
        if (zzpgd != null) {
            try {
                return zztu("getEmptyRegistry");
            } catch (Exception e) {
            }
        }
        return zzffm.zzpgg;
    }

    private static final zzffm zztu(String str) throws Exception {
        return (zzffm) zzpgd.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
