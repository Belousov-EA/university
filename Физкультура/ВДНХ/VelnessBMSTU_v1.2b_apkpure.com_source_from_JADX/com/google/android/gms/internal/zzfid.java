package com.google.android.gms.internal;

import java.util.Map.Entry;

final class zzfid implements Comparable<zzfid>, Entry<K, V> {
    private V value;
    private final K zzpkg;
    private /* synthetic */ zzfhy zzpkh;

    zzfid(zzfhy com_google_android_gms_internal_zzfhy, K k, V v) {
        this.zzpkh = com_google_android_gms_internal_zzfhy;
        this.zzpkg = k;
        this.value = v;
    }

    zzfid(zzfhy com_google_android_gms_internal_zzfhy, Entry<K, V> entry) {
        this(com_google_android_gms_internal_zzfhy, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean equals(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzfid) obj).getKey());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return equals(this.zzpkg, entry.getKey()) && equals(this.value, entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        return this.zzpkg;
    }

    public final V getValue() {
        return this.value;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = this.zzpkg == null ? 0 : this.zzpkg.hashCode();
        if (this.value != null) {
            i = this.value.hashCode();
        }
        return hashCode ^ i;
    }

    public final V setValue(V v) {
        this.zzpkh.zzczl();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzpkg);
        String valueOf2 = String.valueOf(this.value);
        return new StringBuilder((String.valueOf(valueOf).length() + 1) + String.valueOf(valueOf2).length()).append(valueOf).append("=").append(valueOf2).toString();
    }
}
