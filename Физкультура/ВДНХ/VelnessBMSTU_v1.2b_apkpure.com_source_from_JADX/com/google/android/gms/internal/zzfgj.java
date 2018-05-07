package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzfgj<K> implements Iterator<Entry<K, Object>> {
    private Iterator<Entry<K, Object>> zzmmj;

    public zzfgj(Iterator<Entry<K, Object>> it) {
        this.zzmmj = it;
    }

    public final boolean hasNext() {
        return this.zzmmj.hasNext();
    }

    public final /* synthetic */ Object next() {
        Entry entry = (Entry) this.zzmmj.next();
        return entry.getValue() instanceof zzfgg ? new zzfgi(entry) : entry;
    }

    public final void remove() {
        this.zzmmj.remove();
    }
}
