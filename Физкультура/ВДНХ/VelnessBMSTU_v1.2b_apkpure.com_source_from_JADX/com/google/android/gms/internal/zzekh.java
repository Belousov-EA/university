package com.google.android.gms.internal;

public final class zzekh extends zzejv {
    private final zzedk zzndf;

    public zzekh(zzedk com_google_android_gms_internal_zzedk) {
        if (com_google_android_gms_internal_zzedk.size() == 1 && com_google_android_gms_internal_zzedk.zzbwh().zzbzr()) {
            throw new IllegalArgumentException("Can't create PathIndex with '.priority' as key. Please use PriorityIndex instead!");
        }
        this.zzndf = com_google_android_gms_internal_zzedk;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzekc com_google_android_gms_internal_zzekc = (zzekc) obj;
        zzekc com_google_android_gms_internal_zzekc2 = (zzekc) obj2;
        int compareTo = com_google_android_gms_internal_zzekc.zzbsv().zzan(this.zzndf).compareTo(com_google_android_gms_internal_zzekc2.zzbsv().zzan(this.zzndf));
        return compareTo == 0 ? com_google_android_gms_internal_zzekc.zzcao().zzi(com_google_android_gms_internal_zzekc2.zzcao()) : compareTo;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zzndf.equals(((zzekh) obj).zzndf);
    }

    public final int hashCode() {
        return this.zzndf.hashCode();
    }

    public final zzekc zzcag() {
        return new zzekc(zzejg.zzbzo(), zzeju.zzcaf().zzl(this.zzndf, zzekd.zzndb));
    }

    public final String zzcah() {
        return this.zzndf.zzbwf();
    }

    public final zzekc zzf(zzejg com_google_android_gms_internal_zzejg, zzekd com_google_android_gms_internal_zzekd) {
        return new zzekc(com_google_android_gms_internal_zzejg, zzeju.zzcaf().zzl(this.zzndf, com_google_android_gms_internal_zzekd));
    }

    public final boolean zzi(zzekd com_google_android_gms_internal_zzekd) {
        return !com_google_android_gms_internal_zzekd.zzan(this.zzndf).isEmpty();
    }
}
