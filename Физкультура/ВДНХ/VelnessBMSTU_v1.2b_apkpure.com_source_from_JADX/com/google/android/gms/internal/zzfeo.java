package com.google.android.gms.internal;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

abstract class zzfeo<E> extends AbstractList<E> implements zzfgd<E> {
    private boolean zzpfc = true;

    zzfeo() {
    }

    public void add(int i, E e) {
        zzcvj();
        super.add(i, e);
    }

    public boolean add(E e) {
        zzcvj();
        return super.add(e);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        zzcvj();
        return super.addAll(i, collection);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zzcvj();
        return super.addAll(collection);
    }

    public void clear() {
        zzcvj();
        super.clear();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < size(); i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public E remove(int i) {
        zzcvj();
        return super.remove(i);
    }

    public boolean remove(Object obj) {
        zzcvj();
        return super.remove(obj);
    }

    public boolean removeAll(Collection<?> collection) {
        zzcvj();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        zzcvj();
        return super.retainAll(collection);
    }

    public E set(int i, E e) {
        zzcvj();
        return super.set(i, e);
    }

    public final void zzbiy() {
        this.zzpfc = false;
    }

    public final boolean zzcvi() {
        return this.zzpfc;
    }

    protected final void zzcvj() {
        if (!this.zzpfc) {
            throw new UnsupportedOperationException();
        }
    }
}
