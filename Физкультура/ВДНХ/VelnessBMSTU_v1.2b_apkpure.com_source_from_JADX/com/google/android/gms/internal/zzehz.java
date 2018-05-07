package com.google.android.gms.internal;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

public final class zzehz {
    private final zzejw zzmzi;
    private final zzeic zzmzn;
    private final zzejw zzmzo;
    private final zzejg zzmzp;
    private final zzejg zzmzq;

    private zzehz(zzeic com_google_android_gms_internal_zzeic, zzejw com_google_android_gms_internal_zzejw, zzejg com_google_android_gms_internal_zzejg, zzejg com_google_android_gms_internal_zzejg2, zzejw com_google_android_gms_internal_zzejw2) {
        this.zzmzn = com_google_android_gms_internal_zzeic;
        this.zzmzi = com_google_android_gms_internal_zzejw;
        this.zzmzp = com_google_android_gms_internal_zzejg;
        this.zzmzq = com_google_android_gms_internal_zzejg2;
        this.zzmzo = com_google_android_gms_internal_zzejw2;
    }

    public static zzehz zza(zzejg com_google_android_gms_internal_zzejg, zzejw com_google_android_gms_internal_zzejw) {
        return new zzehz(zzeic.CHILD_ADDED, com_google_android_gms_internal_zzejw, com_google_android_gms_internal_zzejg, null, null);
    }

    public static zzehz zza(zzejg com_google_android_gms_internal_zzejg, zzejw com_google_android_gms_internal_zzejw, zzejw com_google_android_gms_internal_zzejw2) {
        return new zzehz(zzeic.CHILD_CHANGED, com_google_android_gms_internal_zzejw, com_google_android_gms_internal_zzejg, null, com_google_android_gms_internal_zzejw2);
    }

    public static zzehz zza(zzejg com_google_android_gms_internal_zzejg, zzekd com_google_android_gms_internal_zzekd, zzekd com_google_android_gms_internal_zzekd2) {
        return zza(com_google_android_gms_internal_zzejg, zzejw.zzj(com_google_android_gms_internal_zzekd), zzejw.zzj(com_google_android_gms_internal_zzekd2));
    }

    public static zzehz zza(zzejw com_google_android_gms_internal_zzejw) {
        return new zzehz(zzeic.VALUE, com_google_android_gms_internal_zzejw, null, null, null);
    }

    public static zzehz zzb(zzejg com_google_android_gms_internal_zzejg, zzejw com_google_android_gms_internal_zzejw) {
        return new zzehz(zzeic.CHILD_REMOVED, com_google_android_gms_internal_zzejw, com_google_android_gms_internal_zzejg, null, null);
    }

    public static zzehz zzc(zzejg com_google_android_gms_internal_zzejg, zzejw com_google_android_gms_internal_zzejw) {
        return new zzehz(zzeic.CHILD_MOVED, com_google_android_gms_internal_zzejw, com_google_android_gms_internal_zzejg, null, null);
    }

    public static zzehz zzc(zzejg com_google_android_gms_internal_zzejg, zzekd com_google_android_gms_internal_zzekd) {
        return zza(com_google_android_gms_internal_zzejg, zzejw.zzj(com_google_android_gms_internal_zzekd));
    }

    public static zzehz zzd(zzejg com_google_android_gms_internal_zzejg, zzekd com_google_android_gms_internal_zzekd) {
        return zzb(com_google_android_gms_internal_zzejg, zzejw.zzj(com_google_android_gms_internal_zzekd));
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzmzn);
        String valueOf2 = String.valueOf(this.zzmzp);
        return new StringBuilder((String.valueOf(valueOf).length() + 9) + String.valueOf(valueOf2).length()).append("Change: ").append(valueOf).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(valueOf2).toString();
    }

    public final zzejw zzbyb() {
        return this.zzmzi;
    }

    public final zzejg zzbyd() {
        return this.zzmzp;
    }

    public final zzeic zzbye() {
        return this.zzmzn;
    }

    public final zzejg zzbyf() {
        return this.zzmzq;
    }

    public final zzejw zzbyg() {
        return this.zzmzo;
    }

    public final zzehz zzg(zzejg com_google_android_gms_internal_zzejg) {
        return new zzehz(this.zzmzn, this.zzmzi, this.zzmzp, com_google_android_gms_internal_zzejg, this.zzmzo);
    }
}
