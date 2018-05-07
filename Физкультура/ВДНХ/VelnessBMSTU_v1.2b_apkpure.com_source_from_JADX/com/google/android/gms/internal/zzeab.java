package com.google.android.gms.internal;

final class zzeab implements zzehp<Void, Integer> {
    private /* synthetic */ zzehm zzmlu;

    zzeab(zzeaa com_google_android_gms_internal_zzeaa, zzehm com_google_android_gms_internal_zzehm) {
        this.zzmlu = com_google_android_gms_internal_zzehm;
    }

    public final /* synthetic */ Object zza(zzedk com_google_android_gms_internal_zzedk, Object obj, Object obj2) {
        Integer num = (Integer) obj2;
        return Integer.valueOf(this.zzmlu.zzaj(com_google_android_gms_internal_zzedk) == null ? num.intValue() + 1 : num.intValue());
    }
}
