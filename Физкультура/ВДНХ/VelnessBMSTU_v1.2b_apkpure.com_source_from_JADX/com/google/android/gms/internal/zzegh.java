package com.google.android.gms.internal;

import java.util.List;

final class zzegh implements zzehq<zzegd> {
    private /* synthetic */ boolean zzmxb;
    private /* synthetic */ List zzmxc;
    private /* synthetic */ zzedk zzmxd;

    zzegh(zzegg com_google_android_gms_internal_zzegg, boolean z, List list, zzedk com_google_android_gms_internal_zzedk) {
        this.zzmxb = z;
        this.zzmxc = list;
        this.zzmxd = com_google_android_gms_internal_zzedk;
    }

    public final /* synthetic */ boolean zzbs(Object obj) {
        zzegd com_google_android_gms_internal_zzegd = (zzegd) obj;
        return (com_google_android_gms_internal_zzegd.isVisible() || this.zzmxb) && !this.zzmxc.contains(Long.valueOf(com_google_android_gms_internal_zzegd.zzbwy())) && (com_google_android_gms_internal_zzegd.zzbsy().zzi(this.zzmxd) || this.zzmxd.zzi(com_google_android_gms_internal_zzegd.zzbsy()));
    }
}
