package com.google.android.gms.internal;

public final class zzcbb {
    private static zzcbb zzhiv;
    private final zzcaw zzhiw = new zzcaw();
    private final zzcax zzhix = new zzcax();

    static {
        zzcbb com_google_android_gms_internal_zzcbb = new zzcbb();
        synchronized (zzcbb.class) {
            zzhiv = com_google_android_gms_internal_zzcbb;
        }
    }

    private zzcbb() {
    }

    private static zzcbb zzara() {
        zzcbb com_google_android_gms_internal_zzcbb;
        synchronized (zzcbb.class) {
            com_google_android_gms_internal_zzcbb = zzhiv;
        }
        return com_google_android_gms_internal_zzcbb;
    }

    public static zzcaw zzarb() {
        return zzara().zzhiw;
    }

    public static zzcax zzarc() {
        return zzara().zzhix;
    }
}
