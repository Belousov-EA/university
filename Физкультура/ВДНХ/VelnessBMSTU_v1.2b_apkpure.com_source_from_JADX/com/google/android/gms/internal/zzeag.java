package com.google.android.gms.internal;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class zzeag<K, V> implements Iterable<Entry<K, V>> {
    public abstract boolean containsKey(K k);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeag)) {
            return false;
        }
        zzeag com_google_android_gms_internal_zzeag = (zzeag) obj;
        if (!getComparator().equals(com_google_android_gms_internal_zzeag.getComparator())) {
            return false;
        }
        if (size() != com_google_android_gms_internal_zzeag.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = com_google_android_gms_internal_zzeag.iterator();
        while (it.hasNext()) {
            if (!((Entry) it.next()).equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract V get(K k);

    public abstract Comparator<K> getComparator();

    public int hashCode() {
        int hashCode = getComparator().hashCode();
        Iterator it = iterator();
        int i = hashCode;
        while (it.hasNext()) {
            i = ((Entry) it.next()).hashCode() + (i * 31);
        }
        return i;
    }

    public abstract int indexOf(K k);

    public abstract boolean isEmpty();

    public abstract Iterator<Entry<K, V>> iterator();

    public abstract int size();

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("{");
        Iterator it = iterator();
        Object obj = 1;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append("(");
            stringBuilder.append(entry.getKey());
            stringBuilder.append("=>");
            stringBuilder.append(entry.getValue());
            stringBuilder.append(")");
        }
        stringBuilder.append("};");
        return stringBuilder.toString();
    }

    public abstract void zza(zzear<K, V> com_google_android_gms_internal_zzear_K__V);

    public abstract zzeag<K, V> zzbf(K k);

    public abstract Iterator<Entry<K, V>> zzbg(K k);

    public abstract K zzbh(K k);

    public abstract K zzbtg();

    public abstract K zzbth();

    public abstract Iterator<Entry<K, V>> zzbti();

    public abstract zzeag<K, V> zzg(K k, V v);
}
