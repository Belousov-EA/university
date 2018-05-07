package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

final class zzfho<E> extends zzfeo<E> {
    private static final zzfho<Object> zzpje;
    private final List<E> zzpjf;

    static {
        zzfeo com_google_android_gms_internal_zzfho = new zzfho();
        zzpje = com_google_android_gms_internal_zzfho;
        com_google_android_gms_internal_zzfho.zzbiy();
    }

    zzfho() {
        this(new ArrayList(10));
    }

    private zzfho(List<E> list) {
        this.zzpjf = list;
    }

    public static <E> zzfho<E> zzcza() {
        return zzpje;
    }

    public final void add(int i, E e) {
        zzcvj();
        this.zzpjf.add(i, e);
        this.modCount++;
    }

    public final E get(int i) {
        return this.zzpjf.get(i);
    }

    public final E remove(int i) {
        zzcvj();
        E remove = this.zzpjf.remove(i);
        this.modCount++;
        return remove;
    }

    public final E set(int i, E e) {
        zzcvj();
        E e2 = this.zzpjf.set(i, e);
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.zzpjf.size();
    }

    public final /* synthetic */ zzfgd zzly(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        List arrayList = new ArrayList(i);
        arrayList.addAll(this.zzpjf);
        return new zzfho(arrayList);
    }
}
