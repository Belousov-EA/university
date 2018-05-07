package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.Map.Entry;

final class zzeam<T> implements Iterator<T> {
    private Iterator<Entry<T, Void>> zzmmj;

    public zzeam(Iterator<Entry<T, Void>> it) {
        this.zzmmj = it;
    }

    public final boolean hasNext() {
        return this.zzmmj.hasNext();
    }

    public final T next() {
        return ((Entry) this.zzmmj.next()).getKey();
    }

    public final void remove() {
        this.zzmmj.remove();
    }
}
