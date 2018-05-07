package com.google.android.gms.internal;

public final class zzeki extends zzejv {
    private static final zzeki zzndg = new zzeki();

    private zzeki() {
    }

    public static zzeki zzcap() {
        return zzndg;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzekc com_google_android_gms_internal_zzekc = (zzekc) obj;
        zzekc com_google_android_gms_internal_zzekc2 = (zzekc) obj2;
        zzekd zzbzv = com_google_android_gms_internal_zzekc.zzbsv().zzbzv();
        zzekd zzbzv2 = com_google_android_gms_internal_zzekc2.zzbsv().zzbzv();
        zzejg zzcao = com_google_android_gms_internal_zzekc.zzcao();
        zzejg zzcao2 = com_google_android_gms_internal_zzekc2.zzcao();
        int compareTo = zzbzv.compareTo(zzbzv2);
        return compareTo != 0 ? compareTo : zzcao.zzi(zzcao2);
    }

    public final boolean equals(Object obj) {
        return obj instanceof zzeki;
    }

    public final int hashCode() {
        return 3155577;
    }

    public final String toString() {
        return "PriorityIndex";
    }

    public final zzekc zzcag() {
        return zzf(zzejg.zzbzo(), zzekd.zzndb);
    }

    public final String zzcah() {
        throw new IllegalArgumentException("Can't get query definition on priority index!");
    }

    public final zzekc zzf(zzejg com_google_android_gms_internal_zzejg, zzekd com_google_android_gms_internal_zzekd) {
        return new zzekc(com_google_android_gms_internal_zzejg, new zzekl("[PRIORITY-POST]", com_google_android_gms_internal_zzekd));
    }

    public final boolean zzi(zzekd com_google_android_gms_internal_zzekd) {
        return !com_google_android_gms_internal_zzekd.zzbzv().isEmpty();
    }
}
