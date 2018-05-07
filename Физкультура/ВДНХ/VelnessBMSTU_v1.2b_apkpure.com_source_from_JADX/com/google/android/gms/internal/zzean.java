package com.google.android.gms.internal;

public final class zzean<K, V> extends zzeat<K, V> {
    private int size = -1;

    zzean(K k, V v, zzeap<K, V> com_google_android_gms_internal_zzeap_K__V, zzeap<K, V> com_google_android_gms_internal_zzeap_K__V2) {
        super(k, v, com_google_android_gms_internal_zzeap_K__V, com_google_android_gms_internal_zzeap_K__V2);
    }

    public final int size() {
        if (this.size == -1) {
            this.size = (zzbtp().size() + 1) + zzbtq().size();
        }
        return this.size;
    }

    protected final zzeat<K, V> zza(K k, V v, zzeap<K, V> com_google_android_gms_internal_zzeap_K__V, zzeap<K, V> com_google_android_gms_internal_zzeap_K__V2) {
        Object key;
        Object value;
        zzeap zzbtp;
        zzeap zzbtq;
        if (k == null) {
            key = getKey();
        }
        if (v == null) {
            value = getValue();
        }
        if (com_google_android_gms_internal_zzeap_K__V == null) {
            zzbtp = zzbtp();
        }
        if (com_google_android_gms_internal_zzeap_K__V2 == null) {
            zzbtq = zzbtq();
        }
        return new zzean(key, value, zzbtp, zzbtq);
    }

    final void zza(zzeap<K, V> com_google_android_gms_internal_zzeap_K__V) {
        if (this.size != -1) {
            throw new IllegalStateException("Can't set left after using size");
        }
        super.zza((zzeap) com_google_android_gms_internal_zzeap_K__V);
    }

    protected final int zzbtm() {
        return zzeaq.zzmmm;
    }

    public final boolean zzbtn() {
        return false;
    }
}
