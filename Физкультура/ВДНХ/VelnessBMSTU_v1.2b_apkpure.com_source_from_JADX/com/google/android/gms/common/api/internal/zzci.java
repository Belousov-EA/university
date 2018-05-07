package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;

public final class zzci<L> {
    private final zzcj zzfuj;
    private volatile L zzfuk;
    private final zzck<L> zzful;

    zzci(@NonNull Looper looper, @NonNull L l, @NonNull String str) {
        this.zzfuj = new zzcj(this, looper);
        this.zzfuk = zzbq.checkNotNull(l, "Listener must not be null");
        this.zzful = new zzck(l, zzbq.zzgm(str));
    }

    public final void clear() {
        this.zzfuk = null;
    }

    public final void zza(zzcl<? super L> com_google_android_gms_common_api_internal_zzcl__super_L) {
        zzbq.checkNotNull(com_google_android_gms_common_api_internal_zzcl__super_L, "Notifier must not be null");
        this.zzfuj.sendMessage(this.zzfuj.obtainMessage(1, com_google_android_gms_common_api_internal_zzcl__super_L));
    }

    public final boolean zzaek() {
        return this.zzfuk != null;
    }

    @NonNull
    public final zzck<L> zzajo() {
        return this.zzful;
    }

    final void zzb(zzcl<? super L> com_google_android_gms_common_api_internal_zzcl__super_L) {
        Object obj = this.zzfuk;
        if (obj == null) {
            com_google_android_gms_common_api_internal_zzcl__super_L.zzahz();
            return;
        }
        try {
            com_google_android_gms_common_api_internal_zzcl__super_L.zzu(obj);
        } catch (RuntimeException e) {
            com_google_android_gms_common_api_internal_zzcl__super_L.zzahz();
            throw e;
        }
    }
}
