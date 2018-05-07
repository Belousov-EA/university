package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzejm implements Iterator<zzekc> {
    private final Iterator<Entry<zzejg, zzekd>> zzmmj;

    public zzejm(Iterator<Entry<zzejg, zzekd>> it) {
        this.zzmmj = it;
    }

    public final boolean hasNext() {
        return this.zzmmj.hasNext();
    }

    public final /* synthetic */ Object next() {
        Entry entry = (Entry) this.zzmmj.next();
        return new zzekc((zzejg) entry.getKey(), (zzekd) entry.getValue());
    }

    public final void remove() {
        this.zzmmj.remove();
    }
}
