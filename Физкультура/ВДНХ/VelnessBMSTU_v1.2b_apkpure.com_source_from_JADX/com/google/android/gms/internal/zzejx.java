package com.google.android.gms.internal;

public final class zzejx extends zzejv {
    private static final zzejx zzncs = new zzejx();

    private zzejx() {
    }

    public static zzejx zzcal() {
        return zzncs;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((zzekc) obj).zzcao().zzi(((zzekc) obj2).zzcao());
    }

    public final boolean equals(Object obj) {
        return obj instanceof zzejx;
    }

    public final int hashCode() {
        return 37;
    }

    public final String toString() {
        return "KeyIndex";
    }

    public final zzekc zzcag() {
        return zzekc.zzcan();
    }

    public final String zzcah() {
        return ".key";
    }

    public final zzekc zzf(zzejg com_google_android_gms_internal_zzejg, zzekd com_google_android_gms_internal_zzekd) {
        return new zzekc(zzejg.zzpz((String) com_google_android_gms_internal_zzekd.getValue()), zzeju.zzcaf());
    }

    public final boolean zzi(zzekd com_google_android_gms_internal_zzekd) {
        return true;
    }
}
