package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;

public final class zzegv implements zzegy {
    private final zzejc zzmlr;
    private final zzegz zzmyc;
    private final zzehf zzmyd;
    private final zzegt zzmye;
    private long zzmyf;

    public zzegv(zzedc com_google_android_gms_internal_zzedc, zzegz com_google_android_gms_internal_zzegz, zzegt com_google_android_gms_internal_zzegt) {
        this(com_google_android_gms_internal_zzedc, com_google_android_gms_internal_zzegz, com_google_android_gms_internal_zzegt, new zzelj());
    }

    private zzegv(zzedc com_google_android_gms_internal_zzedc, zzegz com_google_android_gms_internal_zzegz, zzegt com_google_android_gms_internal_zzegt, zzeli com_google_android_gms_internal_zzeli) {
        this.zzmyf = 0;
        this.zzmyc = com_google_android_gms_internal_zzegz;
        this.zzmlr = com_google_android_gms_internal_zzedc.zzpv("Persistence");
        this.zzmyd = new zzehf(this.zzmyc, this.zzmlr, com_google_android_gms_internal_zzeli);
        this.zzmye = com_google_android_gms_internal_zzegt;
    }

    private final void zzbxr() {
        this.zzmyf++;
        if (this.zzmye.zzbx(this.zzmyf)) {
            if (this.zzmlr.zzbzl()) {
                this.zzmlr.zzb("Reached prune check threshold.", null, new Object[0]);
            }
            this.zzmyf = 0;
            int i = 1;
            long zzbtc = this.zzmyc.zzbtc();
            if (this.zzmlr.zzbzl()) {
                this.zzmlr.zzb("Cache size: " + zzbtc, null, new Object[0]);
            }
            while (i != 0 && this.zzmye.zzj(r2, this.zzmyd.zzbxu())) {
                zzeha zza = this.zzmyd.zza(this.zzmye);
                if (zza.zzbxs()) {
                    this.zzmyc.zza(zzedk.zzbwe(), zza);
                } else {
                    i = 0;
                }
                zzbtc = this.zzmyc.zzbtc();
                if (this.zzmlr.zzbzl()) {
                    this.zzmlr.zzb("Cache size after prune: " + zzbtc, null, new Object[0]);
                }
            }
        }
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy, long j) {
        this.zzmyc.zza(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzecy, j);
    }

    public final void zza(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, long j) {
        this.zzmyc.zza(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd, j);
    }

    public final void zza(zzeik com_google_android_gms_internal_zzeik, zzekd com_google_android_gms_internal_zzekd) {
        if (com_google_android_gms_internal_zzeik.zzbyv()) {
            this.zzmyc.zza(com_google_android_gms_internal_zzeik.zzbsy(), com_google_android_gms_internal_zzekd);
        } else {
            this.zzmyc.zzb(com_google_android_gms_internal_zzeik.zzbsy(), com_google_android_gms_internal_zzekd);
        }
        zzi(com_google_android_gms_internal_zzeik);
        zzbxr();
    }

    public final void zza(zzeik com_google_android_gms_internal_zzeik, Set<zzejg> set) {
        this.zzmyc.zza(this.zzmyd.zzk(com_google_android_gms_internal_zzeik).id, (Set) set);
    }

    public final void zza(zzeik com_google_android_gms_internal_zzeik, Set<zzejg> set, Set<zzejg> set2) {
        this.zzmyc.zza(this.zzmyd.zzk(com_google_android_gms_internal_zzeik).id, (Set) set, (Set) set2);
    }

    public final void zzbl(long j) {
        this.zzmyc.zzbl(j);
    }

    public final List<zzegd> zzbtb() {
        return this.zzmyc.zzbtb();
    }

    public final void zzbte() {
        this.zzmyc.zzbte();
    }

    public final void zzc(zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy) {
        Iterator it = com_google_android_gms_internal_zzecy.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzk(com_google_android_gms_internal_zzedk.zzh((zzedk) entry.getKey()), (zzekd) entry.getValue());
        }
    }

    public final void zzd(zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy) {
        this.zzmyc.zza(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzecy);
        zzbxr();
    }

    public final <T> T zze(Callable<T> callable) {
        this.zzmyc.beginTransaction();
        try {
            T call = callable.call();
            this.zzmyc.setTransactionSuccessful();
            this.zzmyc.endTransaction();
            return call;
        } catch (Throwable th) {
            this.zzmyc.endTransaction();
        }
    }

    public final zzehx zzf(zzeik com_google_android_gms_internal_zzeik) {
        boolean z;
        Set set;
        if (this.zzmyd.zzm(com_google_android_gms_internal_zzeik)) {
            zzehe zzk = this.zzmyd.zzk(com_google_android_gms_internal_zzeik);
            if (com_google_android_gms_internal_zzeik.zzbyv() || zzk == null || !zzk.complete) {
                set = null;
                z = true;
            } else {
                set = this.zzmyc.zzbo(zzk.id);
                z = true;
            }
        } else {
            set = this.zzmyd.zzaa(com_google_android_gms_internal_zzeik.zzbsy());
            z = false;
        }
        zzekd zza = this.zzmyc.zza(com_google_android_gms_internal_zzeik.zzbsy());
        if (r3 == null) {
            return new zzehx(zzejw.zza(zza, com_google_android_gms_internal_zzeik.zzbyr()), true, false);
        }
        zzeju zzcaf = zzeju.zzcaf();
        zzekd com_google_android_gms_internal_zzekd = zzcaf;
        for (zzejg com_google_android_gms_internal_zzejg : r3) {
            com_google_android_gms_internal_zzekd = com_google_android_gms_internal_zzekd.zze(com_google_android_gms_internal_zzejg, zza.zzm(com_google_android_gms_internal_zzejg));
        }
        return new zzehx(zzejw.zza(com_google_android_gms_internal_zzekd, com_google_android_gms_internal_zzeik.zzbyr()), z, true);
    }

    public final void zzg(zzeik com_google_android_gms_internal_zzeik) {
        this.zzmyd.zzg(com_google_android_gms_internal_zzeik);
    }

    public final void zzh(zzeik com_google_android_gms_internal_zzeik) {
        this.zzmyd.zzh(com_google_android_gms_internal_zzeik);
    }

    public final void zzi(zzeik com_google_android_gms_internal_zzeik) {
        if (com_google_android_gms_internal_zzeik.zzbyv()) {
            this.zzmyd.zzz(com_google_android_gms_internal_zzeik.zzbsy());
        } else {
            this.zzmyd.zzl(com_google_android_gms_internal_zzeik);
        }
    }

    public final void zzk(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        if (!this.zzmyd.zzac(com_google_android_gms_internal_zzedk)) {
            this.zzmyc.zza(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd);
            this.zzmyd.zzab(com_google_android_gms_internal_zzedk);
        }
    }
}
