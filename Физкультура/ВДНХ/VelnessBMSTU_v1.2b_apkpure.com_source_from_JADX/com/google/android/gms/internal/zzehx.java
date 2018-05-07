package com.google.android.gms.internal;

public final class zzehx {
    private final zzejw zzmzi;
    private final boolean zzmzj;
    private final boolean zzmzk;

    public zzehx(zzejw com_google_android_gms_internal_zzejw, boolean z, boolean z2) {
        this.zzmzi = com_google_android_gms_internal_zzejw;
        this.zzmzj = z;
        this.zzmzk = z2;
    }

    public final boolean zzal(zzedk com_google_android_gms_internal_zzedk) {
        return com_google_android_gms_internal_zzedk.isEmpty() ? this.zzmzj && !this.zzmzk : zzf(com_google_android_gms_internal_zzedk.zzbwh());
    }

    public final zzekd zzbsv() {
        return this.zzmzi.zzbsv();
    }

    public final boolean zzbxz() {
        return this.zzmzj;
    }

    public final boolean zzbya() {
        return this.zzmzk;
    }

    public final zzejw zzbyb() {
        return this.zzmzi;
    }

    public final boolean zzf(zzejg com_google_android_gms_internal_zzejg) {
        return (this.zzmzj && !this.zzmzk) || this.zzmzi.zzbsv().zzk(com_google_android_gms_internal_zzejg);
    }
}
