package com.google.android.gms.internal;

import java.util.Map.Entry;

final class zzfgi<K> implements Entry<K, Object> {
    private Entry<K, zzfgg> zzphx;

    private zzfgi(Entry<K, zzfgg> entry) {
        this.zzphx = entry;
    }

    public final K getKey() {
        return this.zzphx.getKey();
    }

    public final Object getValue() {
        return ((zzfgg) this.zzphx.getValue()) == null ? null : zzfgg.zzcyj();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzfhe) {
            return ((zzfgg) this.zzphx.getValue()).zzk((zzfhe) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzfgg zzcyk() {
        return (zzfgg) this.zzphx.getValue();
    }
}
