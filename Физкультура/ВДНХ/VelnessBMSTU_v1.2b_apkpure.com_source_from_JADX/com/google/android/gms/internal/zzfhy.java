package com.google.android.gms.internal;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzfhy<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzktj;
    private final int zzpjz;
    private List<zzfid> zzpka;
    private Map<K, V> zzpkb;
    private volatile zzfif zzpkc;
    private Map<K, V> zzpkd;

    private zzfhy(int i) {
        this.zzpjz = i;
        this.zzpka = Collections.emptyList();
        this.zzpkb = Collections.emptyMap();
        this.zzpkd = Collections.emptyMap();
    }

    private final int zza(K k) {
        int compareTo;
        int size = this.zzpka.size() - 1;
        if (size >= 0) {
            compareTo = k.compareTo((Comparable) ((zzfid) this.zzpka.get(size)).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        int i2 = size;
        while (i <= i2) {
            size = (i + i2) / 2;
            compareTo = k.compareTo((Comparable) ((zzfid) this.zzpka.get(size)).getKey());
            if (compareTo < 0) {
                i2 = size - 1;
            } else if (compareTo <= 0) {
                return size;
            } else {
                i = size + 1;
            }
        }
        return -(i + 1);
    }

    private final void zzczl() {
        if (this.zzktj) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzczm() {
        zzczl();
        if (this.zzpkb.isEmpty() && !(this.zzpkb instanceof TreeMap)) {
            this.zzpkb = new TreeMap();
            this.zzpkd = ((TreeMap) this.zzpkb).descendingMap();
        }
        return (SortedMap) this.zzpkb;
    }

    static <FieldDescriptorType extends zzffs<FieldDescriptorType>> zzfhy<FieldDescriptorType, Object> zzma(int i) {
        return new zzfhz(i);
    }

    private final V zzmc(int i) {
        zzczl();
        V value = ((zzfid) this.zzpka.remove(i)).getValue();
        if (!this.zzpkb.isEmpty()) {
            Iterator it = zzczm().entrySet().iterator();
            this.zzpka.add(new zzfid(this, (Entry) it.next()));
            it.remove();
        }
        return value;
    }

    public void clear() {
        zzczl();
        if (!this.zzpka.isEmpty()) {
            this.zzpka.clear();
        }
        if (!this.zzpkb.isEmpty()) {
            this.zzpkb.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzpkb.containsKey(comparable);
    }

    public Set<Entry<K, V>> entrySet() {
        if (this.zzpkc == null) {
            this.zzpkc = new zzfif();
        }
        return this.zzpkc;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfhy)) {
            return super.equals(obj);
        }
        zzfhy com_google_android_gms_internal_zzfhy = (zzfhy) obj;
        int size = size();
        if (size != com_google_android_gms_internal_zzfhy.size()) {
            return false;
        }
        int zzczj = zzczj();
        if (zzczj != com_google_android_gms_internal_zzfhy.zzczj()) {
            return entrySet().equals(com_google_android_gms_internal_zzfhy.entrySet());
        }
        for (int i = 0; i < zzczj; i++) {
            if (!zzmb(i).equals(com_google_android_gms_internal_zzfhy.zzmb(i))) {
                return false;
            }
        }
        return zzczj != size ? this.zzpkb.equals(com_google_android_gms_internal_zzfhy.zzpkb) : true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        return zza >= 0 ? ((zzfid) this.zzpka.get(zza)).getValue() : this.zzpkb.get(comparable);
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < zzczj(); i2++) {
            i += ((zzfid) this.zzpka.get(i2)).hashCode();
        }
        return this.zzpkb.size() > 0 ? this.zzpkb.hashCode() + i : i;
    }

    public final boolean isImmutable() {
        return this.zzktj;
    }

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return zza((Comparable) obj, obj2);
    }

    public V remove(Object obj) {
        zzczl();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        return zza >= 0 ? zzmc(zza) : this.zzpkb.isEmpty() ? null : this.zzpkb.remove(comparable);
    }

    public int size() {
        return this.zzpka.size() + this.zzpkb.size();
    }

    public final V zza(K k, V v) {
        zzczl();
        int zza = zza((Comparable) k);
        if (zza >= 0) {
            return ((zzfid) this.zzpka.get(zza)).setValue(v);
        }
        zzczl();
        if (this.zzpka.isEmpty() && !(this.zzpka instanceof ArrayList)) {
            this.zzpka = new ArrayList(this.zzpjz);
        }
        int i = -(zza + 1);
        if (i >= this.zzpjz) {
            return zzczm().put(k, v);
        }
        if (this.zzpka.size() == this.zzpjz) {
            zzfid com_google_android_gms_internal_zzfid = (zzfid) this.zzpka.remove(this.zzpjz - 1);
            zzczm().put((Comparable) com_google_android_gms_internal_zzfid.getKey(), com_google_android_gms_internal_zzfid.getValue());
        }
        this.zzpka.add(i, new zzfid(this, k, v));
        return null;
    }

    public void zzbiy() {
        if (!this.zzktj) {
            this.zzpkb = this.zzpkb.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzpkb);
            this.zzpkd = this.zzpkd.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzpkd);
            this.zzktj = true;
        }
    }

    public final int zzczj() {
        return this.zzpka.size();
    }

    public final Iterable<Entry<K, V>> zzczk() {
        return this.zzpkb.isEmpty() ? zzfia.zzczn() : this.zzpkb.entrySet();
    }

    public final Entry<K, V> zzmb(int i) {
        return (Entry) this.zzpka.get(i);
    }
}
