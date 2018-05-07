package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class zzeal<T> implements Iterable<T> {
    private final zzeag<T, Void> zzmmi;

    private zzeal(zzeag<T, Void> com_google_android_gms_internal_zzeag_T__java_lang_Void) {
        this.zzmmi = com_google_android_gms_internal_zzeag_T__java_lang_Void;
    }

    public zzeal(List<T> list, Comparator<T> comparator) {
        this.zzmmi = zzeah.zzb(list, Collections.emptyMap(), zzeah.zzbtj(), comparator);
    }

    public final boolean contains(T t) {
        return this.zzmmi.containsKey(t);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeal)) {
            return false;
        }
        return this.zzmmi.equals(((zzeal) obj).zzmmi);
    }

    public final int hashCode() {
        return this.zzmmi.hashCode();
    }

    public final int indexOf(T t) {
        return this.zzmmi.indexOf(t);
    }

    public final boolean isEmpty() {
        return this.zzmmi.isEmpty();
    }

    public final Iterator<T> iterator() {
        return new zzeam(this.zzmmi.iterator());
    }

    public final int size() {
        return this.zzmmi.size();
    }

    public final Iterator<T> zzbg(T t) {
        return new zzeam(this.zzmmi.zzbg(t));
    }

    public final zzeal<T> zzbl(T t) {
        zzeag zzbf = this.zzmmi.zzbf(t);
        return zzbf == this.zzmmi ? this : new zzeal(zzbf);
    }

    public final zzeal<T> zzbm(T t) {
        return new zzeal(this.zzmmi.zzg(t, null));
    }

    public final T zzbn(T t) {
        return this.zzmmi.zzbh(t);
    }

    public final Iterator<T> zzbti() {
        return new zzeam(this.zzmmi.zzbti());
    }

    public final T zzbtk() {
        return this.zzmmi.zzbtg();
    }

    public final T zzbtl() {
        return this.zzmmi.zzbth();
    }
}
