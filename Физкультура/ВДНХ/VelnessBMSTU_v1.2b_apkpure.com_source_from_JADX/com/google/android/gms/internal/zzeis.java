package com.google.android.gms.internal;

final class zzeis implements zzeix {
    private final zzein zznar;
    private final zzegj zznbb;
    private final zzekd zznbc;

    public zzeis(zzegj com_google_android_gms_internal_zzegj, zzein com_google_android_gms_internal_zzein, zzekd com_google_android_gms_internal_zzekd) {
        this.zznbb = com_google_android_gms_internal_zzegj;
        this.zznar = com_google_android_gms_internal_zzein;
        this.zznbc = com_google_android_gms_internal_zzekd;
    }

    public final zzekc zza(zzejv com_google_android_gms_internal_zzejv, zzekc com_google_android_gms_internal_zzekc, boolean z) {
        return this.zznbb.zza(this.zznbc != null ? this.zznbc : this.zznar.zzbzf(), com_google_android_gms_internal_zzekc, z, com_google_android_gms_internal_zzejv);
    }

    public final zzekd zzh(zzejg com_google_android_gms_internal_zzejg) {
        zzehx zzbzc = this.zznar.zzbzc();
        if (zzbzc.zzf(com_google_android_gms_internal_zzejg)) {
            return zzbzc.zzbsv().zzm(com_google_android_gms_internal_zzejg);
        }
        return this.zznbb.zza(com_google_android_gms_internal_zzejg, this.zznbc != null ? new zzehx(zzejw.zza(this.zznbc, zzejx.zzcal()), true, false) : this.zznar.zzbze());
    }
}
