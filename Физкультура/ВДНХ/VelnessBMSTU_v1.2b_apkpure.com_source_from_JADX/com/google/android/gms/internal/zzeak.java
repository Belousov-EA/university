package com.google.android.gms.internal;

import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Stack;

public final class zzeak<K, V> implements Iterator<Entry<K, V>> {
    private final Stack<zzeat<K, V>> zzmmg = new Stack();
    private final boolean zzmmh;

    zzeak(zzeap<K, V> com_google_android_gms_internal_zzeap_K__V, K k, Comparator<K> comparator, boolean z) {
        this.zzmmh = z;
        zzeap com_google_android_gms_internal_zzeap = com_google_android_gms_internal_zzeap_K__V;
        while (!com_google_android_gms_internal_zzeap.isEmpty()) {
            int compare = k != null ? z ? comparator.compare(k, com_google_android_gms_internal_zzeap.getKey()) : comparator.compare(com_google_android_gms_internal_zzeap.getKey(), k) : 1;
            if (compare < 0) {
                if (!z) {
                    com_google_android_gms_internal_zzeap = com_google_android_gms_internal_zzeap.zzbtq();
                }
            } else if (compare == 0) {
                this.zzmmg.push((zzeat) com_google_android_gms_internal_zzeap);
                return;
            } else {
                this.zzmmg.push((zzeat) com_google_android_gms_internal_zzeap);
                if (z) {
                    com_google_android_gms_internal_zzeap = com_google_android_gms_internal_zzeap.zzbtq();
                }
            }
            com_google_android_gms_internal_zzeap = com_google_android_gms_internal_zzeap.zzbtp();
        }
    }

    private final Entry<K, V> next() {
        try {
            zzeat com_google_android_gms_internal_zzeat = (zzeat) this.zzmmg.pop();
            Entry simpleEntry = new SimpleEntry(com_google_android_gms_internal_zzeat.getKey(), com_google_android_gms_internal_zzeat.getValue());
            zzeap zzbtp;
            if (this.zzmmh) {
                for (zzbtp = com_google_android_gms_internal_zzeat.zzbtp(); !zzbtp.isEmpty(); zzbtp = zzbtp.zzbtq()) {
                    this.zzmmg.push((zzeat) zzbtp);
                }
            } else {
                for (zzbtp = com_google_android_gms_internal_zzeat.zzbtq(); !zzbtp.isEmpty(); zzbtp = zzbtp.zzbtp()) {
                    this.zzmmg.push((zzeat) zzbtp);
                }
            }
            return simpleEntry;
        } catch (EmptyStackException e) {
            throw new NoSuchElementException();
        }
    }

    public final boolean hasNext() {
        return this.zzmmg.size() > 0;
    }

    public final void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }
}
