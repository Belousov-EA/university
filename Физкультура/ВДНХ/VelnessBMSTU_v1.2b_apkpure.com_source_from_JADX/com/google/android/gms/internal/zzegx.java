package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public final class zzegx implements zzegy {
    private boolean zzmls = false;

    private final void zzbtf() {
        zzelt.zzb(this.zzmls, "Transaction expected to already be in progress.");
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy, long j) {
        zzbtf();
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, long j) {
        zzbtf();
    }

    public final void zza(zzeik com_google_android_gms_internal_zzeik, zzekd com_google_android_gms_internal_zzekd) {
        zzbtf();
    }

    public final void zza(zzeik com_google_android_gms_internal_zzeik, Set<zzejg> set) {
        zzbtf();
    }

    public final void zza(zzeik com_google_android_gms_internal_zzeik, Set<zzejg> set, Set<zzejg> set2) {
        zzbtf();
    }

    public final void zzbl(long j) {
        zzbtf();
    }

    public final List<zzegd> zzbtb() {
        return Collections.emptyList();
    }

    public final void zzbte() {
        zzbtf();
    }

    public final void zzc(zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy) {
        zzbtf();
    }

    public final void zzd(zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy) {
        zzbtf();
    }

    public final <T> T zze(Callable<T> callable) {
        zzelt.zzb(!this.zzmls, "runInTransaction called when an existing transaction is already in progress.");
        this.zzmls = true;
        try {
            T call = callable.call();
            this.zzmls = false;
            return call;
        } catch (Throwable th) {
            this.zzmls = false;
        }
    }

    public final zzehx zzf(zzeik com_google_android_gms_internal_zzeik) {
        return new zzehx(zzejw.zza(zzeju.zzcaf(), com_google_android_gms_internal_zzeik.zzbyr()), false, false);
    }

    public final void zzg(zzeik com_google_android_gms_internal_zzeik) {
        zzbtf();
    }

    public final void zzh(zzeik com_google_android_gms_internal_zzeik) {
        zzbtf();
    }

    public final void zzi(zzeik com_google_android_gms_internal_zzeik) {
        zzbtf();
    }

    public final void zzk(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        zzbtf();
    }
}
