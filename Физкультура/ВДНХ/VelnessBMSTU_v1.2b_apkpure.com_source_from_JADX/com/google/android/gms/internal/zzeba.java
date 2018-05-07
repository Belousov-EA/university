package com.google.android.gms.internal;

import java.util.Comparator;

public final class zzeba<A extends Comparable<A>> implements Comparator<A> {
    private static zzeba zzmna = new zzeba();

    private zzeba() {
    }

    public static <T extends Comparable<T>> zzeba<T> zze(Class<T> cls) {
        return zzmna;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((Comparable) obj).compareTo((Comparable) obj2);
    }
}
