package com.google.android.gms.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class zzfif extends AbstractSet<Entry<K, V>> {
    private /* synthetic */ zzfhy zzpkh;

    private zzfif(zzfhy com_google_android_gms_internal_zzfhy) {
        this.zzpkh = com_google_android_gms_internal_zzfhy;
    }

    public /* synthetic */ boolean add(Object obj) {
        Entry entry = (Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzpkh.zza((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public void clear() {
        this.zzpkh.clear();
    }

    public boolean contains(Object obj) {
        Entry entry = (Entry) obj;
        Object obj2 = this.zzpkh.get(entry.getKey());
        Object value = entry.getValue();
        return obj2 == value || (obj2 != null && obj2.equals(value));
    }

    public Iterator<Entry<K, V>> iterator() {
        return new zzfie(this.zzpkh);
    }

    public boolean remove(Object obj) {
        Entry entry = (Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzpkh.remove(entry.getKey());
        return true;
    }

    public int size() {
        return this.zzpkh.size();
    }
}
