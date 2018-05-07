package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public final class zzeah {
    private static final zzeaj zzmmf = new zzeai();

    public static <K, V> zzeag<K, V> zza(Comparator<K> comparator) {
        return new zzeae(comparator);
    }

    public static <A, B> zzeag<A, B> zza(Map<A, B> map, Comparator<A> comparator) {
        return map.size() < 25 ? zzeae.zza(new ArrayList(map.keySet()), map, zzmmf, comparator) : zzeau.zzb(map, comparator);
    }

    public static <A, B, C> zzeag<A, C> zzb(List<A> list, Map<B, C> map, zzeaj<A, B> com_google_android_gms_internal_zzeaj_A__B, Comparator<A> comparator) {
        return list.size() < 25 ? zzeae.zza(list, map, com_google_android_gms_internal_zzeaj_A__B, comparator) : zzeaw.zzc(list, map, com_google_android_gms_internal_zzeaj_A__B, comparator);
    }

    public static <A> zzeaj<A, A> zzbtj() {
        return zzmmf;
    }
}
