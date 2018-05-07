package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzfgy<K, V> extends LinkedHashMap<K, V> {
    private static final zzfgy zzpir;
    private boolean zzpfc = true;

    static {
        zzfgy com_google_android_gms_internal_zzfgy = new zzfgy();
        zzpir = com_google_android_gms_internal_zzfgy;
        com_google_android_gms_internal_zzfgy.zzpfc = false;
    }

    private zzfgy() {
    }

    private zzfgy(Map<K, V> map) {
        super(map);
    }

    private static int zzco(Object obj) {
        if (obj instanceof byte[]) {
            return zzffz.hashCode((byte[]) obj);
        }
        if (!(obj instanceof zzfga)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public static <K, V> zzfgy<K, V> zzcyp() {
        return zzpir;
    }

    private final void zzcyr() {
        if (!this.zzpfc) {
            throw new UnsupportedOperationException();
        }
    }

    public final void clear() {
        zzcyr();
        super.clear();
    }

    public final Set<Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Map) {
            Object obj2;
            obj = (Map) obj;
            if (this != obj) {
                if (size() == obj.size()) {
                    for (Entry entry : entrySet()) {
                        if (!obj.containsKey(entry.getKey())) {
                            obj2 = null;
                            break;
                        }
                        boolean equals;
                        Object value = entry.getValue();
                        Object obj3 = obj.get(entry.getKey());
                        if ((value instanceof byte[]) && (obj3 instanceof byte[])) {
                            equals = Arrays.equals((byte[]) value, (byte[]) obj3);
                            continue;
                        } else {
                            equals = value.equals(obj3);
                            continue;
                        }
                        if (!equals) {
                            obj2 = null;
                            break;
                        }
                    }
                }
                obj2 = null;
                if (obj2 != null) {
                    return true;
                }
            }
            int i = 1;
            if (obj2 != null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        for (Entry entry : entrySet()) {
            i = (zzco(entry.getValue()) ^ zzco(entry.getKey())) + i;
        }
        return i;
    }

    public final boolean isMutable() {
        return this.zzpfc;
    }

    public final V put(K k, V v) {
        zzcyr();
        zzffz.checkNotNull(k);
        zzffz.checkNotNull(v);
        return super.put(k, v);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        zzcyr();
        for (Object next : map.keySet()) {
            zzffz.checkNotNull(next);
            zzffz.checkNotNull(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        zzcyr();
        return super.remove(obj);
    }

    public final void zza(zzfgy<K, V> com_google_android_gms_internal_zzfgy_K__V) {
        zzcyr();
        if (!com_google_android_gms_internal_zzfgy_K__V.isEmpty()) {
            putAll(com_google_android_gms_internal_zzfgy_K__V);
        }
    }

    public final void zzbiy() {
        this.zzpfc = false;
    }

    public final zzfgy<K, V> zzcyq() {
        return isEmpty() ? new zzfgy() : new zzfgy(this);
    }
}
