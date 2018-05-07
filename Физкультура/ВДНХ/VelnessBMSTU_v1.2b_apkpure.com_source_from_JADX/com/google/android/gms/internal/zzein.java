package com.google.android.gms.internal;

public final class zzein {
    private final zzehx zznaw;
    private final zzehx zznax;

    public zzein(zzehx com_google_android_gms_internal_zzehx, zzehx com_google_android_gms_internal_zzehx2) {
        this.zznaw = com_google_android_gms_internal_zzehx;
        this.zznax = com_google_android_gms_internal_zzehx2;
    }

    public final zzein zza(zzejw com_google_android_gms_internal_zzejw, boolean z, boolean z2) {
        return new zzein(new zzehx(com_google_android_gms_internal_zzejw, z, z2), this.zznax);
    }

    public final zzein zzb(zzejw com_google_android_gms_internal_zzejw, boolean z, boolean z2) {
        return new zzein(this.zznaw, new zzehx(com_google_android_gms_internal_zzejw, z, z2));
    }

    public final zzehx zzbzc() {
        return this.zznaw;
    }

    public final zzekd zzbzd() {
        return this.zznaw.zzbxz() ? this.zznaw.zzbsv() : null;
    }

    public final zzehx zzbze() {
        return this.zznax;
    }

    public final zzekd zzbzf() {
        return this.zznax.zzbxz() ? this.zznax.zzbsv() : null;
    }
}
