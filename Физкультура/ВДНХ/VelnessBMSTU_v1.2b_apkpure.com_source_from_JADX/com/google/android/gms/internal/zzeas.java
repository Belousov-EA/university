package com.google.android.gms.internal;

public final class zzeas<K, V> extends zzeat<K, V> {
    zzeas(K k, V v) {
        super(k, v, zzeao.zzbto(), zzeao.zzbto());
    }

    zzeas(K k, V v, zzeap<K, V> com_google_android_gms_internal_zzeap_K__V, zzeap<K, V> com_google_android_gms_internal_zzeap_K__V2) {
        super(k, v, com_google_android_gms_internal_zzeap_K__V, com_google_android_gms_internal_zzeap_K__V2);
    }

    public final int size() {
        return (zzbtp().size() + 1) + zzbtq().size();
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
        return new zzeas(key, value, zzbtp, zzbtq);
    }

    protected final int zzbtm() {
        return zzeaq.zzmml;
    }

    public final boolean zzbtn() {
        return true;
    }
}
