package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps.EntryTransformer;
import java.lang.reflect.Array;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible(emulated = true)
final class Platform {
    static <T> T[] newArray(T[] reference, int length) {
        return (Object[]) ((Object[]) Array.newInstance(reference.getClass().getComponentType(), length));
    }

    static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        return Sets.newSetFromMap(map);
    }

    static MapMaker tryWeakKeys(MapMaker mapMaker) {
        return mapMaker.weakKeys();
    }

    static <K, V1, V2> SortedMap<K, V2> mapsTransformEntriesSortedMap(SortedMap<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
        return Maps.transformEntriesIgnoreNavigable(fromMap, transformer);
    }

    static <K, V> SortedMap<K, V> mapsAsMapSortedSet(SortedSet<K> set, Function<? super K, V> function) {
        return Maps.asMapSortedIgnoreNavigable(set, function);
    }

    static <E> SortedSet<E> setsFilterSortedSet(SortedSet<E> set, Predicate<? super E> predicate) {
        return Sets.filterSortedIgnoreNavigable(set, predicate);
    }

    static <K, V> SortedMap<K, V> mapsFilterSortedMap(SortedMap<K, V> map, Predicate<? super Entry<K, V>> predicate) {
        return Maps.filterSortedIgnoreNavigable(map, predicate);
    }

    private Platform() {
    }
}
