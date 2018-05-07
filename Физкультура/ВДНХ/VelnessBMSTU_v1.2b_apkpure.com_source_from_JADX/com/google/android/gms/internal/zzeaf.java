package com.google.android.gms.internal;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Iterator;
import java.util.Map.Entry;

final class zzeaf implements Iterator<Entry<K, V>> {
    private int zzmmb = this.zzmmc;
    private /* synthetic */ int zzmmc;
    private /* synthetic */ boolean zzmmd;
    private /* synthetic */ zzeae zzmme;

    zzeaf(zzeae com_google_android_gms_internal_zzeae, int i, boolean z) {
        this.zzmme = com_google_android_gms_internal_zzeae;
        this.zzmmc = i;
        this.zzmmd = z;
    }

    public final boolean hasNext() {
        return this.zzmmd ? this.zzmmb >= 0 : this.zzmmb < this.zzmme.zzmly.length;
    }

    public final /* synthetic */ Object next() {
        Object obj = this.zzmme.zzmly[this.zzmmb];
        Object obj2 = this.zzmme.zzmlz[this.zzmmb];
        this.zzmmb = this.zzmmd ? this.zzmmb - 1 : this.zzmmb + 1;
        return new SimpleImmutableEntry(obj, obj2);
    }

    public final void remove() {
        throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
    }
}
