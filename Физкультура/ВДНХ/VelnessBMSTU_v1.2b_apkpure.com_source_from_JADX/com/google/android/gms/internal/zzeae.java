package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zzeae<K, V> extends zzeag<K, V> {
    private final K[] zzmly;
    private final V[] zzmlz;
    private final Comparator<K> zzmma;

    public zzeae(Comparator<K> comparator) {
        this.zzmly = new Object[0];
        this.zzmlz = new Object[0];
        this.zzmma = comparator;
    }

    private zzeae(Comparator<K> comparator, K[] kArr, V[] vArr) {
        this.zzmly = kArr;
        this.zzmlz = vArr;
        this.zzmma = comparator;
    }

    public static <A, B, C> zzeae<A, C> zza(List<A> list, Map<B, C> map, zzeaj<A, B> com_google_android_gms_internal_zzeaj_A__B, Comparator<A> comparator) {
        Collections.sort(list, comparator);
        int size = list.size();
        Object[] objArr = new Object[size];
        Object[] objArr2 = new Object[size];
        size = 0;
        for (Object next : list) {
            objArr[size] = next;
            objArr2[size] = map.get(com_google_android_gms_internal_zzeaj_A__B.zzbk(next));
            size++;
        }
        return new zzeae(comparator, objArr, objArr2);
    }

    private static <T> T[] zza(T[] tArr, int i) {
        int length = tArr.length - 1;
        Object obj = new Object[length];
        System.arraycopy(tArr, 0, obj, 0, i);
        System.arraycopy(tArr, i + 1, obj, i, length - i);
        return obj;
    }

    private static <T> T[] zza(T[] tArr, int i, T t) {
        int length = tArr.length + 1;
        Object obj = new Object[length];
        System.arraycopy(tArr, 0, obj, 0, i);
        obj[i] = t;
        System.arraycopy(tArr, i, obj, i + 1, (length - i) - 1);
        return obj;
    }

    private static <T> T[] zzb(T[] tArr, int i, T t) {
        int length = tArr.length;
        Object obj = new Object[length];
        System.arraycopy(tArr, 0, obj, 0, length);
        obj[i] = t;
        return obj;
    }

    private final int zzbi(K k) {
        int i = 0;
        while (i < this.zzmly.length && this.zzmma.compare(this.zzmly[i], k) < 0) {
            i++;
        }
        return i;
    }

    private final int zzbj(K k) {
        int i = 0;
        Object[] objArr = this.zzmly;
        int length = objArr.length;
        int i2 = 0;
        while (i2 < length) {
            if (this.zzmma.compare(k, objArr[i2]) == 0) {
                return i;
            }
            i2++;
            i++;
        }
        return -1;
    }

    private final Iterator<Entry<K, V>> zzj(int i, boolean z) {
        return new zzeaf(this, i, z);
    }

    public final boolean containsKey(K k) {
        return zzbj(k) != -1;
    }

    public final V get(K k) {
        int zzbj = zzbj(k);
        return zzbj != -1 ? this.zzmlz[zzbj] : null;
    }

    public final Comparator<K> getComparator() {
        return this.zzmma;
    }

    public final int indexOf(K k) {
        return zzbj(k);
    }

    public final boolean isEmpty() {
        return this.zzmly.length == 0;
    }

    public final Iterator<Entry<K, V>> iterator() {
        return zzj(0, false);
    }

    public final int size() {
        return this.zzmly.length;
    }

    public final void zza(zzear<K, V> com_google_android_gms_internal_zzear_K__V) {
        for (int i = 0; i < this.zzmly.length; i++) {
            com_google_android_gms_internal_zzear_K__V.zzh(this.zzmly[i], this.zzmlz[i]);
        }
    }

    public final zzeag<K, V> zzbf(K k) {
        int zzbj = zzbj(k);
        if (zzbj == -1) {
            return this;
        }
        return new zzeae(this.zzmma, zza(this.zzmly, zzbj), zza(this.zzmlz, zzbj));
    }

    public final Iterator<Entry<K, V>> zzbg(K k) {
        return zzj(zzbi(k), false);
    }

    public final K zzbh(K k) {
        int zzbj = zzbj(k);
        if (zzbj != -1) {
            return zzbj > 0 ? this.zzmly[zzbj - 1] : null;
        } else {
            throw new IllegalArgumentException("Can't find predecessor of nonexistent key");
        }
    }

    public final K zzbtg() {
        return this.zzmly.length > 0 ? this.zzmly[0] : null;
    }

    public final K zzbth() {
        return this.zzmly.length > 0 ? this.zzmly[this.zzmly.length - 1] : null;
    }

    public final Iterator<Entry<K, V>> zzbti() {
        return zzj(this.zzmly.length - 1, true);
    }

    public final zzeag<K, V> zzg(K k, V v) {
        int zzbj = zzbj(k);
        if (zzbj != -1) {
            if (this.zzmly[zzbj] == k && this.zzmlz[zzbj] == v) {
                return this;
            }
            return new zzeae(this.zzmma, zzb(this.zzmly, zzbj, k), zzb(this.zzmlz, zzbj, v));
        } else if (this.zzmly.length > 25) {
            Map hashMap = new HashMap(this.zzmly.length + 1);
            for (zzbj = 0; zzbj < this.zzmly.length; zzbj++) {
                hashMap.put(this.zzmly[zzbj], this.zzmlz[zzbj]);
            }
            hashMap.put(k, v);
            return zzeau.zzb(hashMap, this.zzmma);
        } else {
            zzbj = zzbi(k);
            return new zzeae(this.zzmma, zza(this.zzmly, zzbj, k), zza(this.zzmlz, zzbj, v));
        }
    }
}
