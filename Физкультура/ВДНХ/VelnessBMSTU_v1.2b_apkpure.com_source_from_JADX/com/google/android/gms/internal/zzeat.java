package com.google.android.gms.internal;

import java.util.Comparator;

public abstract class zzeat<K, V> implements zzeap<K, V> {
    private final V value;
    private final K zzmmo;
    private zzeap<K, V> zzmmp;
    private final zzeap<K, V> zzmmq;

    zzeat(K k, V v, zzeap<K, V> com_google_android_gms_internal_zzeap_K__V, zzeap<K, V> com_google_android_gms_internal_zzeap_K__V2) {
        zzeap zzbto;
        zzeap zzbto2;
        this.zzmmo = k;
        this.value = v;
        if (com_google_android_gms_internal_zzeap_K__V == null) {
            zzbto = zzeao.zzbto();
        }
        this.zzmmp = zzbto;
        if (com_google_android_gms_internal_zzeap_K__V2 == null) {
            zzbto2 = zzeao.zzbto();
        }
        this.zzmmq = zzbto2;
    }

    private static int zzb(zzeap com_google_android_gms_internal_zzeap) {
        return com_google_android_gms_internal_zzeap.zzbtn() ? zzeaq.zzmmm : zzeaq.zzmml;
    }

    private final zzeat<K, V> zzb(K k, V v, Integer num, zzeap<K, V> com_google_android_gms_internal_zzeap_K__V, zzeap<K, V> com_google_android_gms_internal_zzeap_K__V2) {
        zzeap com_google_android_gms_internal_zzeap;
        zzeap com_google_android_gms_internal_zzeap2;
        Object obj = this.zzmmo;
        Object obj2 = this.value;
        if (com_google_android_gms_internal_zzeap_K__V == null) {
            com_google_android_gms_internal_zzeap = this.zzmmp;
        }
        if (com_google_android_gms_internal_zzeap_K__V2 == null) {
            com_google_android_gms_internal_zzeap2 = this.zzmmq;
        }
        return num == zzeaq.zzmml ? new zzeas(obj, obj2, com_google_android_gms_internal_zzeap, com_google_android_gms_internal_zzeap2) : new zzean(obj, obj2, com_google_android_gms_internal_zzeap, com_google_android_gms_internal_zzeap2);
    }

    private final zzeap<K, V> zzbtt() {
        if (this.zzmmp.isEmpty()) {
            return zzeao.zzbto();
        }
        if (!(this.zzmmp.zzbtn() || this.zzmmp.zzbtp().zzbtn())) {
            this = zzbtu();
        }
        return zza(null, null, ((zzeat) this.zzmmp).zzbtt(), null).zzbtv();
    }

    private final zzeat<K, V> zzbtu() {
        zzeat<K, V> zzbty = zzbty();
        return zzbty.zzmmq.zzbtp().zzbtn() ? zzbty.zza(null, null, null, ((zzeat) zzbty.zzmmq).zzbtx()).zzbtw().zzbty() : zzbty;
    }

    private final zzeat<K, V> zzbtv() {
        zzeat<K, V> zzbtw;
        if (this.zzmmq.zzbtn() && !this.zzmmp.zzbtn()) {
            zzbtw = zzbtw();
        }
        if (zzbtw.zzmmp.zzbtn() && ((zzeat) zzbtw.zzmmp).zzmmp.zzbtn()) {
            zzbtw = zzbtw.zzbtx();
        }
        return (zzbtw.zzmmp.zzbtn() && zzbtw.zzmmq.zzbtn()) ? zzbtw.zzbty() : zzbtw;
    }

    private final zzeat<K, V> zzbtw() {
        return (zzeat) this.zzmmq.zza(null, null, zzbtm(), zzb(null, null, zzeaq.zzmml, null, ((zzeat) this.zzmmq).zzmmp), null);
    }

    private final zzeat<K, V> zzbtx() {
        return (zzeat) this.zzmmp.zza(null, null, zzbtm(), null, zzb(null, null, zzeaq.zzmml, ((zzeat) this.zzmmp).zzmmq, null));
    }

    private final zzeat<K, V> zzbty() {
        return zzb(null, null, zzb(this), this.zzmmp.zza(null, null, zzb(this.zzmmp), null, null), this.zzmmq.zza(null, null, zzb(this.zzmmq), null, null));
    }

    public final K getKey() {
        return this.zzmmo;
    }

    public final V getValue() {
        return this.value;
    }

    public final boolean isEmpty() {
        return false;
    }

    public final /* synthetic */ zzeap zza(Object obj, Object obj2, int i, zzeap com_google_android_gms_internal_zzeap, zzeap com_google_android_gms_internal_zzeap2) {
        return zzb(null, null, i, com_google_android_gms_internal_zzeap, com_google_android_gms_internal_zzeap2);
    }

    public final zzeap<K, V> zza(K k, V v, Comparator<K> comparator) {
        int compare = comparator.compare(k, this.zzmmo);
        zzeat zza = compare < 0 ? zza(null, null, this.zzmmp.zza(k, v, comparator), null) : compare == 0 ? zza(k, v, null, null) : zza(null, null, null, this.zzmmq.zza(k, v, comparator));
        return zza.zzbtv();
    }

    public final zzeap<K, V> zza(K k, Comparator<K> comparator) {
        zzeat zza;
        if (comparator.compare(k, this.zzmmo) < 0) {
            if (!(this.zzmmp.isEmpty() || this.zzmmp.zzbtn() || ((zzeat) this.zzmmp).zzmmp.zzbtn())) {
                this = zzbtu();
            }
            zza = zza(null, null, this.zzmmp.zza(k, comparator), null);
        } else {
            if (this.zzmmp.zzbtn()) {
                this = zzbtx();
            }
            if (!(this.zzmmq.isEmpty() || this.zzmmq.zzbtn() || ((zzeat) this.zzmmq).zzmmp.zzbtn())) {
                zza = zzbty();
                if (zza.zzmmp.zzbtp().zzbtn()) {
                    zza = zza.zzbtx().zzbty();
                }
                this = zza;
            }
            if (comparator.compare(k, this.zzmmo) == 0) {
                if (this.zzmmq.isEmpty()) {
                    return zzeao.zzbto();
                }
                zzeap zzbtr = this.zzmmq.zzbtr();
                this = zza(zzbtr.getKey(), zzbtr.getValue(), null, ((zzeat) this.zzmmq).zzbtt());
            }
            zza = zza(null, null, null, this.zzmmq.zza(k, comparator));
        }
        return zza.zzbtv();
    }

    protected abstract zzeat<K, V> zza(K k, V v, zzeap<K, V> com_google_android_gms_internal_zzeap_K__V, zzeap<K, V> com_google_android_gms_internal_zzeap_K__V2);

    void zza(zzeap<K, V> com_google_android_gms_internal_zzeap_K__V) {
        this.zzmmp = com_google_android_gms_internal_zzeap_K__V;
    }

    public final void zza(zzear<K, V> com_google_android_gms_internal_zzear_K__V) {
        this.zzmmp.zza(com_google_android_gms_internal_zzear_K__V);
        com_google_android_gms_internal_zzear_K__V.zzh(this.zzmmo, this.value);
        this.zzmmq.zza(com_google_android_gms_internal_zzear_K__V);
    }

    protected abstract int zzbtm();

    public final zzeap<K, V> zzbtp() {
        return this.zzmmp;
    }

    public final zzeap<K, V> zzbtq() {
        return this.zzmmq;
    }

    public final zzeap<K, V> zzbtr() {
        return this.zzmmp.isEmpty() ? this : this.zzmmp.zzbtr();
    }

    public final zzeap<K, V> zzbts() {
        return this.zzmmq.isEmpty() ? this : this.zzmmq.zzbts();
    }
}
