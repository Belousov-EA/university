package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Iterator;

public final class zzeju extends zzeji implements zzekd {
    private static final zzeju zznco = new zzeju();

    private zzeju() {
    }

    public static zzeju zzcaf() {
        return zznco;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return zzg((zzekd) obj);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzeju) {
            return true;
        }
        if ((obj instanceof zzekd) && ((zzekd) obj).isEmpty()) {
            if (this == null) {
                throw null;
            } else if (equals(((zzekd) obj).zzbzv())) {
                return true;
            }
        }
        return false;
    }

    public final int getChildCount() {
        return 0;
    }

    public final Object getValue() {
        return null;
    }

    public final Object getValue(boolean z) {
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    public final boolean isEmpty() {
        return true;
    }

    public final Iterator<zzekc> iterator() {
        return Collections.emptyList().iterator();
    }

    public final String toString() {
        return "<Empty Node>";
    }

    public final String zza(zzekf com_google_android_gms_internal_zzekf) {
        return "";
    }

    public final zzekd zzan(zzedk com_google_android_gms_internal_zzedk) {
        return this;
    }

    public final Iterator<zzekc> zzbti() {
        return Collections.emptyList().iterator();
    }

    public final String zzbzt() {
        return "";
    }

    public final boolean zzbzu() {
        return false;
    }

    public final zzekd zzbzv() {
        return this;
    }

    public final zzekd zze(zzejg com_google_android_gms_internal_zzejg, zzekd com_google_android_gms_internal_zzekd) {
        return (com_google_android_gms_internal_zzekd.isEmpty() || com_google_android_gms_internal_zzejg.zzbzr()) ? this : new zzeji().zze(com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzekd);
    }

    public final /* bridge */ /* synthetic */ zzekd zzf(zzekd com_google_android_gms_internal_zzekd) {
        if (this != null) {
            return this;
        }
        throw null;
    }

    public final int zzg(zzekd com_google_android_gms_internal_zzekd) {
        return com_google_android_gms_internal_zzekd.isEmpty() ? 0 : -1;
    }

    public final boolean zzk(zzejg com_google_android_gms_internal_zzejg) {
        return false;
    }

    public final zzejg zzl(zzejg com_google_android_gms_internal_zzejg) {
        return null;
    }

    public final zzekd zzl(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        if (com_google_android_gms_internal_zzedk.isEmpty()) {
            return com_google_android_gms_internal_zzekd;
        }
        zzejg zzbwh = com_google_android_gms_internal_zzedk.zzbwh();
        if (this != null) {
            return zze(zzbwh, zzl(com_google_android_gms_internal_zzedk.zzbwi(), com_google_android_gms_internal_zzekd));
        }
        throw null;
    }

    public final zzekd zzm(zzejg com_google_android_gms_internal_zzejg) {
        return this;
    }
}
