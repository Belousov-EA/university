package com.google.android.gms.internal;

public final class zzekn extends zzejv {
    private static final zzekn zzndk = new zzekn();

    private zzekn() {
    }

    public static zzekn zzcaq() {
        return zzndk;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzekc com_google_android_gms_internal_zzekc = (zzekc) obj;
        zzekc com_google_android_gms_internal_zzekc2 = (zzekc) obj2;
        int compareTo = com_google_android_gms_internal_zzekc.zzbsv().compareTo(com_google_android_gms_internal_zzekc2.zzbsv());
        return compareTo == 0 ? com_google_android_gms_internal_zzekc.zzcao().zzi(com_google_android_gms_internal_zzekc2.zzcao()) : compareTo;
    }

    public final boolean equals(Object obj) {
        return obj instanceof zzekn;
    }

    public final int hashCode() {
        return 4;
    }

    public final String toString() {
        return "ValueIndex";
    }

    public final zzekc zzcag() {
        return new zzekc(zzejg.zzbzo(), zzekd.zzndb);
    }

    public final String zzcah() {
        return ".value";
    }

    public final zzekc zzf(zzejg com_google_android_gms_internal_zzejg, zzekd com_google_android_gms_internal_zzekd) {
        return new zzekc(com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzekd);
    }

    public final boolean zzi(zzekd com_google_android_gms_internal_zzekd) {
        return true;
    }
}
