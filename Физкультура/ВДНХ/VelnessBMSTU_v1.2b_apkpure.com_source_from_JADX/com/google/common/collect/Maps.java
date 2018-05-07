package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Joiner.MapJoiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.MapDifference.ValueDifference;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class Maps {
    static final MapJoiner STANDARD_JOINER = Collections2.STANDARD_JOINER.withKeyValueSeparator("=");

    public interface EntryTransformer<K, V1, V2> {
        V2 transformEntry(@Nullable K k, @Nullable V1 v1);
    }

    @GwtCompatible
    static abstract class ImprovedAbstractMap<K, V> extends AbstractMap<K, V> {
        private transient Set<Entry<K, V>> entrySet;
        private transient Set<K> keySet;
        private transient Collection<V> values;

        abstract Set<Entry<K, V>> createEntrySet();

        ImprovedAbstractMap() {
        }

        public Set<Entry<K, V>> entrySet() {
            Set<Entry<K, V>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            set = createEntrySet();
            this.entrySet = set;
            return set;
        }

        public Set<K> keySet() {
            Set<K> set = this.keySet;
            if (set != null) {
                return set;
            }
            set = createKeySet();
            this.keySet = set;
            return set;
        }

        Set<K> createKeySet() {
            return new KeySet(this);
        }

        public Collection<V> values() {
            Collection<V> collection = this.values;
            if (collection != null) {
                return collection;
            }
            collection = createValues();
            this.values = collection;
            return collection;
        }

        Collection<V> createValues() {
            return new Values(this);
        }
    }

    static class Values<K, V> extends AbstractCollection<V> {
        final Map<K, V> map;

        Values(Map<K, V> map) {
            this.map = (Map) Preconditions.checkNotNull(map);
        }

        final Map<K, V> map() {
            return this.map;
        }

        public Iterator<V> iterator() {
            return Maps.valueIterator(map().entrySet().iterator());
        }

        public boolean remove(Object o) {
            try {
                return super.remove(o);
            } catch (UnsupportedOperationException e) {
                for (Entry<K, V> entry : map().entrySet()) {
                    if (Objects.equal(o, entry.getValue())) {
                        map().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        public boolean removeAll(Collection<?> c) {
            try {
                return super.removeAll((Collection) Preconditions.checkNotNull(c));
            } catch (UnsupportedOperationException e) {
                Set<K> toRemove = Sets.newHashSet();
                for (Entry<K, V> entry : map().entrySet()) {
                    if (c.contains(entry.getValue())) {
                        toRemove.add(entry.getKey());
                    }
                }
                return map().keySet().removeAll(toRemove);
            }
        }

        public boolean retainAll(Collection<?> c) {
            try {
                return super.retainAll((Collection) Preconditions.checkNotNull(c));
            } catch (UnsupportedOperationException e) {
                Set<K> toRetain = Sets.newHashSet();
                for (Entry<K, V> entry : map().entrySet()) {
                    if (c.contains(entry.getValue())) {
                        toRetain.add(entry.getKey());
                    }
                }
                return map().keySet().retainAll(toRetain);
            }
        }

        public int size() {
            return map().size();
        }

        public boolean isEmpty() {
            return map().isEmpty();
        }

        public boolean contains(@Nullable Object o) {
            return map().containsValue(o);
        }

        public void clear() {
            map().clear();
        }
    }

    private static abstract class AbstractFilteredMap<K, V> extends ImprovedAbstractMap<K, V> {
        final Predicate<? super Entry<K, V>> predicate;
        final Map<K, V> unfiltered;

        AbstractFilteredMap(Map<K, V> unfiltered, Predicate<? super Entry<K, V>> predicate) {
            this.unfiltered = unfiltered;
            this.predicate = predicate;
        }

        boolean apply(@Nullable Object key, @Nullable V value) {
            return this.predicate.apply(Maps.immutableEntry(key, value));
        }

        public V put(K key, V value) {
            Preconditions.checkArgument(apply(key, value));
            return this.unfiltered.put(key, value);
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
                Preconditions.checkArgument(apply(entry.getKey(), entry.getValue()));
            }
            this.unfiltered.putAll(map);
        }

        public boolean containsKey(Object key) {
            return this.unfiltered.containsKey(key) && apply(key, this.unfiltered.get(key));
        }

        public V get(Object key) {
            V value = this.unfiltered.get(key);
            return (value == null || !apply(key, value)) ? null : value;
        }

        public boolean isEmpty() {
            return entrySet().isEmpty();
        }

        public V remove(Object key) {
            return containsKey(key) ? this.unfiltered.remove(key) : null;
        }

        Collection<V> createValues() {
            return new FilteredMapValues(this, this.unfiltered, this.predicate);
        }
    }

    private static class AsMapView<K, V> extends ImprovedAbstractMap<K, V> {
        final Function<? super K, V> function;
        private final Set<K> set;

        class C09381 extends EntrySet<K, V> {
            C09381() {
            }

            Map<K, V> map() {
                return AsMapView.this;
            }

            public Iterator<Entry<K, V>> iterator() {
                return Maps.asMapEntryIterator(AsMapView.this.backingSet(), AsMapView.this.function);
            }
        }

        Set<K> backingSet() {
            return this.set;
        }

        AsMapView(Set<K> set, Function<? super K, V> function) {
            this.set = (Set) Preconditions.checkNotNull(set);
            this.function = (Function) Preconditions.checkNotNull(function);
        }

        public Set<K> createKeySet() {
            return Maps.removeOnlySet(backingSet());
        }

        Collection<V> createValues() {
            return Collections2.transform(this.set, this.function);
        }

        public int size() {
            return backingSet().size();
        }

        public boolean containsKey(@Nullable Object key) {
            return backingSet().contains(key);
        }

        public V get(@Nullable Object key) {
            if (!Collections2.safeContains(backingSet(), key)) {
                return null;
            }
            return this.function.apply(key);
        }

        public V remove(@Nullable Object key) {
            if (!backingSet().remove(key)) {
                return null;
            }
            return this.function.apply(key);
        }

        public void clear() {
            backingSet().clear();
        }

        protected Set<Entry<K, V>> createEntrySet() {
            return new C09381();
        }
    }

    private enum EntryFunction implements Function<Entry<?, ?>, Object> {
        KEY {
            @Nullable
            public Object apply(Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE {
            @Nullable
            public Object apply(Entry<?, ?> entry) {
                return entry.getValue();
            }
        }
    }

    static abstract class EntrySet<K, V> extends ImprovedAbstractSet<Entry<K, V>> {
        abstract Map<K, V> map();

        EntrySet() {
        }

        public int size() {
            return map().size();
        }

        public void clear() {
            map().clear();
        }

        public boolean contains(Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            Entry<?, ?> entry = (Entry) o;
            Object key = entry.getKey();
            V value = Maps.safeGet(map(), key);
            if (!Objects.equal(value, entry.getValue())) {
                return false;
            }
            if (value != null || map().containsKey(key)) {
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            return map().isEmpty();
        }

        public boolean remove(Object o) {
            if (!contains(o)) {
                return false;
            }
            return map().keySet().remove(((Entry) o).getKey());
        }

        public boolean removeAll(Collection<?> c) {
            try {
                return super.removeAll((Collection) Preconditions.checkNotNull(c));
            } catch (UnsupportedOperationException e) {
                return Sets.removeAllImpl((Set) this, c.iterator());
            }
        }

        public boolean retainAll(Collection<?> c) {
            try {
                return super.retainAll((Collection) Preconditions.checkNotNull(c));
            } catch (UnsupportedOperationException e) {
                Set<Object> keys = Sets.newHashSetWithExpectedSize(c.size());
                for (Entry<?, ?> o : c) {
                    if (contains(o)) {
                        keys.add(o.getKey());
                    }
                }
                return map().keySet().retainAll(keys);
            }
        }
    }

    private static final class FilteredMapValues<K, V> extends Values<K, V> {
        Predicate<? super Entry<K, V>> predicate;
        Map<K, V> unfiltered;

        FilteredMapValues(Map<K, V> filteredMap, Map<K, V> unfiltered, Predicate<? super Entry<K, V>> predicate) {
            super(filteredMap);
            this.unfiltered = unfiltered;
            this.predicate = predicate;
        }

        public boolean remove(Object o) {
            return Iterables.removeFirstMatching(this.unfiltered.entrySet(), Predicates.and(this.predicate, Maps.valuePredicateOnEntries(Predicates.equalTo(o)))) != null;
        }

        private boolean removeIf(Predicate<? super V> valuePredicate) {
            return Iterables.removeIf(this.unfiltered.entrySet(), Predicates.and(this.predicate, Maps.valuePredicateOnEntries(valuePredicate)));
        }

        public boolean removeAll(Collection<?> collection) {
            return removeIf(Predicates.in(collection));
        }

        public boolean retainAll(Collection<?> collection) {
            return removeIf(Predicates.not(Predicates.in(collection)));
        }

        public Object[] toArray() {
            return Lists.newArrayList(iterator()).toArray();
        }

        public <T> T[] toArray(T[] array) {
            return Lists.newArrayList(iterator()).toArray(array);
        }
    }

    static class KeySet<K, V> extends ImprovedAbstractSet<K> {
        final Map<K, V> map;

        KeySet(Map<K, V> map) {
            this.map = (Map) Preconditions.checkNotNull(map);
        }

        Map<K, V> map() {
            return this.map;
        }

        public Iterator<K> iterator() {
            return Maps.keyIterator(map().entrySet().iterator());
        }

        public int size() {
            return map().size();
        }

        public boolean isEmpty() {
            return map().isEmpty();
        }

        public boolean contains(Object o) {
            return map().containsKey(o);
        }

        public boolean remove(Object o) {
            if (!contains(o)) {
                return false;
            }
            map().remove(o);
            return true;
        }

        public void clear() {
            map().clear();
        }
    }

    static class MapDifferenceImpl<K, V> implements MapDifference<K, V> {
        final Map<K, ValueDifference<V>> differences;
        final Map<K, V> onBoth;
        final Map<K, V> onlyOnLeft;
        final Map<K, V> onlyOnRight;

        MapDifferenceImpl(Map<K, V> onlyOnLeft, Map<K, V> onlyOnRight, Map<K, V> onBoth, Map<K, ValueDifference<V>> differences) {
            this.onlyOnLeft = Maps.unmodifiableMap(onlyOnLeft);
            this.onlyOnRight = Maps.unmodifiableMap(onlyOnRight);
            this.onBoth = Maps.unmodifiableMap(onBoth);
            this.differences = Maps.unmodifiableMap(differences);
        }

        public boolean areEqual() {
            return this.onlyOnLeft.isEmpty() && this.onlyOnRight.isEmpty() && this.differences.isEmpty();
        }

        public Map<K, V> entriesOnlyOnLeft() {
            return this.onlyOnLeft;
        }

        public Map<K, V> entriesOnlyOnRight() {
            return this.onlyOnRight;
        }

        public Map<K, V> entriesInCommon() {
            return this.onBoth;
        }

        public Map<K, ValueDifference<V>> entriesDiffering() {
            return this.differences;
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof MapDifference)) {
                return false;
            }
            MapDifference<?, ?> other = (MapDifference) object;
            if (entriesOnlyOnLeft().equals(other.entriesOnlyOnLeft()) && entriesOnlyOnRight().equals(other.entriesOnlyOnRight()) && entriesInCommon().equals(other.entriesInCommon()) && entriesDiffering().equals(other.entriesDiffering())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(entriesOnlyOnLeft(), entriesOnlyOnRight(), entriesInCommon(), entriesDiffering());
        }

        public String toString() {
            if (areEqual()) {
                return "equal";
            }
            StringBuilder result = new StringBuilder("not equal");
            if (!this.onlyOnLeft.isEmpty()) {
                result.append(": only on left=").append(this.onlyOnLeft);
            }
            if (!this.onlyOnRight.isEmpty()) {
                result.append(": only on right=").append(this.onlyOnRight);
            }
            if (!this.differences.isEmpty()) {
                result.append(": value differences=").append(this.differences);
            }
            return result.toString();
        }
    }

    static class TransformedEntriesMap<K, V1, V2> extends ImprovedAbstractMap<K, V2> {
        final Map<K, V1> fromMap;
        final EntryTransformer<? super K, ? super V1, V2> transformer;

        class C09421 extends EntrySet<K, V2> {
            C09421() {
            }

            Map<K, V2> map() {
                return TransformedEntriesMap.this;
            }

            public Iterator<Entry<K, V2>> iterator() {
                return Iterators.transform(TransformedEntriesMap.this.fromMap.entrySet().iterator(), Maps.asEntryToEntryFunction(TransformedEntriesMap.this.transformer));
            }
        }

        TransformedEntriesMap(Map<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
            this.fromMap = (Map) Preconditions.checkNotNull(fromMap);
            this.transformer = (EntryTransformer) Preconditions.checkNotNull(transformer);
        }

        public int size() {
            return this.fromMap.size();
        }

        public boolean containsKey(Object key) {
            return this.fromMap.containsKey(key);
        }

        public V2 get(Object key) {
            V1 value = this.fromMap.get(key);
            return (value != null || this.fromMap.containsKey(key)) ? this.transformer.transformEntry(key, value) : null;
        }

        public V2 remove(Object key) {
            return this.fromMap.containsKey(key) ? this.transformer.transformEntry(key, this.fromMap.remove(key)) : null;
        }

        public void clear() {
            this.fromMap.clear();
        }

        public Set<K> keySet() {
            return this.fromMap.keySet();
        }

        protected Set<Entry<K, V2>> createEntrySet() {
            return new C09421();
        }
    }

    static class ValueDifferenceImpl<V> implements ValueDifference<V> {
        private final V left;
        private final V right;

        static <V> ValueDifference<V> create(@Nullable V left, @Nullable V right) {
            return new ValueDifferenceImpl(left, right);
        }

        private ValueDifferenceImpl(@Nullable V left, @Nullable V right) {
            this.left = left;
            this.right = right;
        }

        public V leftValue() {
            return this.left;
        }

        public V rightValue() {
            return this.right;
        }

        public boolean equals(@Nullable Object object) {
            if (!(object instanceof ValueDifference)) {
                return false;
            }
            ValueDifference<?> that = (ValueDifference) object;
            if (Objects.equal(this.left, that.leftValue()) && Objects.equal(this.right, that.rightValue())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.left, this.right);
        }

        public String toString() {
            return "(" + this.left + ", " + this.right + ")";
        }
    }

    private static final class BiMapConverter<A, B> extends Converter<A, B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final BiMap<A, B> bimap;

        BiMapConverter(BiMap<A, B> bimap) {
            this.bimap = (BiMap) Preconditions.checkNotNull(bimap);
        }

        protected B doForward(A a) {
            return convert(this.bimap, a);
        }

        protected A doBackward(B b) {
            return convert(this.bimap.inverse(), b);
        }

        private static <X, Y> Y convert(BiMap<X, Y> bimap, X input) {
            boolean z;
            Y output = bimap.get(input);
            if (output != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "No non-null mapping present for input: %s", input);
            return output;
        }

        public boolean equals(@Nullable Object object) {
            if (!(object instanceof BiMapConverter)) {
                return false;
            }
            return this.bimap.equals(((BiMapConverter) object).bimap);
        }

        public int hashCode() {
            return this.bimap.hashCode();
        }

        public String toString() {
            return "Maps.asConverter(" + this.bimap + ")";
        }
    }

    static class FilteredEntryMap<K, V> extends AbstractFilteredMap<K, V> {
        final Set<Entry<K, V>> filteredEntrySet;

        class KeySet extends KeySet<K, V> {
            KeySet() {
                super(FilteredEntryMap.this);
            }

            public boolean remove(Object o) {
                if (!FilteredEntryMap.this.containsKey(o)) {
                    return false;
                }
                FilteredEntryMap.this.unfiltered.remove(o);
                return true;
            }

            private boolean removeIf(Predicate<? super K> keyPredicate) {
                return Iterables.removeIf(FilteredEntryMap.this.unfiltered.entrySet(), Predicates.and(FilteredEntryMap.this.predicate, Maps.keyPredicateOnEntries(keyPredicate)));
            }

            public boolean removeAll(Collection<?> c) {
                return removeIf(Predicates.in(c));
            }

            public boolean retainAll(Collection<?> c) {
                return removeIf(Predicates.not(Predicates.in(c)));
            }

            public Object[] toArray() {
                return Lists.newArrayList(iterator()).toArray();
            }

            public <T> T[] toArray(T[] array) {
                return Lists.newArrayList(iterator()).toArray(array);
            }
        }

        private class EntrySet extends ForwardingSet<Entry<K, V>> {
            private EntrySet() {
            }

            protected Set<Entry<K, V>> delegate() {
                return FilteredEntryMap.this.filteredEntrySet;
            }

            public Iterator<Entry<K, V>> iterator() {
                return new TransformedIterator<Entry<K, V>, Entry<K, V>>(FilteredEntryMap.this.filteredEntrySet.iterator()) {
                    Entry<K, V> transform(final Entry<K, V> entry) {
                        return new ForwardingMapEntry<K, V>() {
                            protected Entry<K, V> delegate() {
                                return entry;
                            }

                            public V setValue(V newValue) {
                                Preconditions.checkArgument(FilteredEntryMap.this.apply(getKey(), newValue));
                                return super.setValue(newValue);
                            }
                        };
                    }
                };
            }
        }

        FilteredEntryMap(Map<K, V> unfiltered, Predicate<? super Entry<K, V>> entryPredicate) {
            super(unfiltered, entryPredicate);
            this.filteredEntrySet = Sets.filter(unfiltered.entrySet(), this.predicate);
        }

        protected Set<Entry<K, V>> createEntrySet() {
            return new EntrySet();
        }

        Set<K> createKeySet() {
            return new KeySet();
        }
    }

    private static class FilteredKeyMap<K, V> extends AbstractFilteredMap<K, V> {
        Predicate<? super K> keyPredicate;

        FilteredKeyMap(Map<K, V> unfiltered, Predicate<? super K> keyPredicate, Predicate<? super Entry<K, V>> entryPredicate) {
            super(unfiltered, entryPredicate);
            this.keyPredicate = keyPredicate;
        }

        protected Set<Entry<K, V>> createEntrySet() {
            return Sets.filter(this.unfiltered.entrySet(), this.predicate);
        }

        Set<K> createKeySet() {
            return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
        }

        public boolean containsKey(Object key) {
            return this.unfiltered.containsKey(key) && this.keyPredicate.apply(key);
        }
    }

    private static class SortedAsMapView<K, V> extends AsMapView<K, V> implements SortedMap<K, V> {
        SortedAsMapView(SortedSet<K> set, Function<? super K, V> function) {
            super(set, function);
        }

        SortedSet<K> backingSet() {
            return (SortedSet) super.backingSet();
        }

        public Comparator<? super K> comparator() {
            return backingSet().comparator();
        }

        public Set<K> keySet() {
            return Maps.removeOnlySortedSet(backingSet());
        }

        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            return Maps.asMap(backingSet().subSet(fromKey, toKey), this.function);
        }

        public SortedMap<K, V> headMap(K toKey) {
            return Maps.asMap(backingSet().headSet(toKey), this.function);
        }

        public SortedMap<K, V> tailMap(K fromKey) {
            return Maps.asMap(backingSet().tailSet(fromKey), this.function);
        }

        public K firstKey() {
            return backingSet().first();
        }

        public K lastKey() {
            return backingSet().last();
        }
    }

    static class SortedKeySet<K, V> extends KeySet<K, V> implements SortedSet<K> {
        SortedKeySet(SortedMap<K, V> map) {
            super(map);
        }

        SortedMap<K, V> map() {
            return (SortedMap) super.map();
        }

        public Comparator<? super K> comparator() {
            return map().comparator();
        }

        public SortedSet<K> subSet(K fromElement, K toElement) {
            return new SortedKeySet(map().subMap(fromElement, toElement));
        }

        public SortedSet<K> headSet(K toElement) {
            return new SortedKeySet(map().headMap(toElement));
        }

        public SortedSet<K> tailSet(K fromElement) {
            return new SortedKeySet(map().tailMap(fromElement));
        }

        public K first() {
            return map().firstKey();
        }

        public K last() {
            return map().lastKey();
        }
    }

    static class SortedMapDifferenceImpl<K, V> extends MapDifferenceImpl<K, V> implements SortedMapDifference<K, V> {
        SortedMapDifferenceImpl(SortedMap<K, V> onlyOnLeft, SortedMap<K, V> onlyOnRight, SortedMap<K, V> onBoth, SortedMap<K, ValueDifference<V>> differences) {
            super(onlyOnLeft, onlyOnRight, onBoth, differences);
        }

        public SortedMap<K, ValueDifference<V>> entriesDiffering() {
            return (SortedMap) super.entriesDiffering();
        }

        public SortedMap<K, V> entriesInCommon() {
            return (SortedMap) super.entriesInCommon();
        }

        public SortedMap<K, V> entriesOnlyOnLeft() {
            return (SortedMap) super.entriesOnlyOnLeft();
        }

        public SortedMap<K, V> entriesOnlyOnRight() {
            return (SortedMap) super.entriesOnlyOnRight();
        }
    }

    static class TransformedEntriesSortedMap<K, V1, V2> extends TransformedEntriesMap<K, V1, V2> implements SortedMap<K, V2> {
        protected SortedMap<K, V1> fromMap() {
            return (SortedMap) this.fromMap;
        }

        TransformedEntriesSortedMap(SortedMap<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
            super(fromMap, transformer);
        }

        public Comparator<? super K> comparator() {
            return fromMap().comparator();
        }

        public K firstKey() {
            return fromMap().firstKey();
        }

        public SortedMap<K, V2> headMap(K toKey) {
            return Maps.transformEntries(fromMap().headMap(toKey), this.transformer);
        }

        public K lastKey() {
            return fromMap().lastKey();
        }

        public SortedMap<K, V2> subMap(K fromKey, K toKey) {
            return Maps.transformEntries(fromMap().subMap(fromKey, toKey), this.transformer);
        }

        public SortedMap<K, V2> tailMap(K fromKey) {
            return Maps.transformEntries(fromMap().tailMap(fromKey), this.transformer);
        }
    }

    private static class UnmodifiableBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final BiMap<? extends K, ? extends V> delegate;
        BiMap<V, K> inverse;
        final Map<K, V> unmodifiableMap;
        transient Set<V> values;

        UnmodifiableBiMap(BiMap<? extends K, ? extends V> delegate, @Nullable BiMap<V, K> inverse) {
            this.unmodifiableMap = Collections.unmodifiableMap(delegate);
            this.delegate = delegate;
            this.inverse = inverse;
        }

        protected Map<K, V> delegate() {
            return this.unmodifiableMap;
        }

        public V forcePut(K k, V v) {
            throw new UnsupportedOperationException();
        }

        public BiMap<V, K> inverse() {
            BiMap<V, K> biMap = this.inverse;
            if (biMap != null) {
                return biMap;
            }
            biMap = new UnmodifiableBiMap(this.delegate.inverse(), this);
            this.inverse = biMap;
            return biMap;
        }

        public Set<V> values() {
            Set<V> set = this.values;
            if (set != null) {
                return set;
            }
            set = Collections.unmodifiableSet(this.delegate.values());
            this.values = set;
            return set;
        }
    }

    static class UnmodifiableEntries<K, V> extends ForwardingCollection<Entry<K, V>> {
        private final Collection<Entry<K, V>> entries;

        UnmodifiableEntries(Collection<Entry<K, V>> entries) {
            this.entries = entries;
        }

        protected Collection<Entry<K, V>> delegate() {
            return this.entries;
        }

        public Iterator<Entry<K, V>> iterator() {
            final Iterator<Entry<K, V>> delegate = super.iterator();
            return new UnmodifiableIterator<Entry<K, V>>() {
                public boolean hasNext() {
                    return delegate.hasNext();
                }

                public Entry<K, V> next() {
                    return Maps.unmodifiableEntry((Entry) delegate.next());
                }
            };
        }

        public Object[] toArray() {
            return standardToArray();
        }

        public <T> T[] toArray(T[] array) {
            return standardToArray(array);
        }
    }

    static final class FilteredEntryBiMap<K, V> extends FilteredEntryMap<K, V> implements BiMap<K, V> {
        private final BiMap<V, K> inverse;

        private static <K, V> Predicate<Entry<V, K>> inversePredicate(final Predicate<? super Entry<K, V>> forwardPredicate) {
            return new Predicate<Entry<V, K>>() {
                public boolean apply(Entry<V, K> input) {
                    return forwardPredicate.apply(Maps.immutableEntry(input.getValue(), input.getKey()));
                }
            };
        }

        FilteredEntryBiMap(BiMap<K, V> delegate, Predicate<? super Entry<K, V>> predicate) {
            super(delegate, predicate);
            this.inverse = new FilteredEntryBiMap(delegate.inverse(), inversePredicate(predicate), this);
        }

        private FilteredEntryBiMap(BiMap<K, V> delegate, Predicate<? super Entry<K, V>> predicate, BiMap<V, K> inverse) {
            super(delegate, predicate);
            this.inverse = inverse;
        }

        BiMap<K, V> unfiltered() {
            return (BiMap) this.unfiltered;
        }

        public V forcePut(@Nullable K key, @Nullable V value) {
            Preconditions.checkArgument(apply(key, value));
            return unfiltered().forcePut(key, value);
        }

        public BiMap<V, K> inverse() {
            return this.inverse;
        }

        public Set<V> values() {
            return this.inverse.keySet();
        }
    }

    private static class FilteredEntrySortedMap<K, V> extends FilteredEntryMap<K, V> implements SortedMap<K, V> {

        class SortedKeySet extends KeySet implements SortedSet<K> {
            SortedKeySet() {
                super();
            }

            public Comparator<? super K> comparator() {
                return FilteredEntrySortedMap.this.sortedMap().comparator();
            }

            public SortedSet<K> subSet(K fromElement, K toElement) {
                return (SortedSet) FilteredEntrySortedMap.this.subMap(fromElement, toElement).keySet();
            }

            public SortedSet<K> headSet(K toElement) {
                return (SortedSet) FilteredEntrySortedMap.this.headMap(toElement).keySet();
            }

            public SortedSet<K> tailSet(K fromElement) {
                return (SortedSet) FilteredEntrySortedMap.this.tailMap(fromElement).keySet();
            }

            public K first() {
                return FilteredEntrySortedMap.this.firstKey();
            }

            public K last() {
                return FilteredEntrySortedMap.this.lastKey();
            }
        }

        FilteredEntrySortedMap(SortedMap<K, V> unfiltered, Predicate<? super Entry<K, V>> entryPredicate) {
            super(unfiltered, entryPredicate);
        }

        SortedMap<K, V> sortedMap() {
            return (SortedMap) this.unfiltered;
        }

        public SortedSet<K> keySet() {
            return (SortedSet) super.keySet();
        }

        SortedSet<K> createKeySet() {
            return new SortedKeySet();
        }

        public Comparator<? super K> comparator() {
            return sortedMap().comparator();
        }

        public K firstKey() {
            return keySet().iterator().next();
        }

        public K lastKey() {
            SortedMap<K, V> headMap = sortedMap();
            while (true) {
                K key = headMap.lastKey();
                if (apply(key, this.unfiltered.get(key))) {
                    return key;
                }
                headMap = sortedMap().headMap(key);
            }
        }

        public SortedMap<K, V> headMap(K toKey) {
            return new FilteredEntrySortedMap(sortedMap().headMap(toKey), this.predicate);
        }

        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            return new FilteredEntrySortedMap(sortedMap().subMap(fromKey, toKey), this.predicate);
        }

        public SortedMap<K, V> tailMap(K fromKey) {
            return new FilteredEntrySortedMap(sortedMap().tailMap(fromKey), this.predicate);
        }
    }

    static class UnmodifiableEntrySet<K, V> extends UnmodifiableEntries<K, V> implements Set<Entry<K, V>> {
        UnmodifiableEntrySet(Set<Entry<K, V>> entries) {
            super(entries);
        }

        public boolean equals(@Nullable Object object) {
            return Sets.equalsImpl(this, object);
        }

        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }

    private Maps() {
    }

    static <K> Function<Entry<K, ?>, K> keyFunction() {
        return EntryFunction.KEY;
    }

    static <V> Function<Entry<?, V>, V> valueFunction() {
        return EntryFunction.VALUE;
    }

    static <K, V> Iterator<K> keyIterator(Iterator<Entry<K, V>> entryIterator) {
        return Iterators.transform(entryIterator, keyFunction());
    }

    static <K, V> Iterator<V> valueIterator(Iterator<Entry<K, V>> entryIterator) {
        return Iterators.transform(entryIterator, valueFunction());
    }

    static <K, V> UnmodifiableIterator<V> valueIterator(final UnmodifiableIterator<Entry<K, V>> entryIterator) {
        return new UnmodifiableIterator<V>() {
            public boolean hasNext() {
                return entryIterator.hasNext();
            }

            public V next() {
                return ((Entry) entryIterator.next()).getValue();
            }
        };
    }

    @GwtCompatible(serializable = true)
    @Beta
    public static <K extends Enum<K>, V> ImmutableMap<K, V> immutableEnumMap(Map<K, ? extends V> map) {
        if (map instanceof ImmutableEnumMap) {
            return (ImmutableEnumMap) map;
        }
        if (map.isEmpty()) {
            return ImmutableMap.of();
        }
        for (Entry<K, ? extends V> entry : map.entrySet()) {
            Preconditions.checkNotNull(entry.getKey());
            Preconditions.checkNotNull(entry.getValue());
        }
        return ImmutableEnumMap.asImmutable(new EnumMap(map));
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap();
    }

    public static <K, V> HashMap<K, V> newHashMapWithExpectedSize(int expectedSize) {
        return new HashMap(capacity(expectedSize));
    }

    static int capacity(int expectedSize) {
        if (expectedSize < 3) {
            CollectPreconditions.checkNonnegative(expectedSize, "expectedSize");
            return expectedSize + 1;
        } else if (expectedSize < Ints.MAX_POWER_OF_TWO) {
            return (expectedSize / 3) + expectedSize;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static <K, V> HashMap<K, V> newHashMap(Map<? extends K, ? extends V> map) {
        return new HashMap(map);
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
        return new LinkedHashMap();
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(Map<? extends K, ? extends V> map) {
        return new LinkedHashMap(map);
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentMap() {
        return new MapMaker().makeMap();
    }

    public static <K extends Comparable, V> TreeMap<K, V> newTreeMap() {
        return new TreeMap();
    }

    public static <K, V> TreeMap<K, V> newTreeMap(SortedMap<K, ? extends V> map) {
        return new TreeMap(map);
    }

    public static <C, K extends C, V> TreeMap<K, V> newTreeMap(@Nullable Comparator<C> comparator) {
        return new TreeMap(comparator);
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Class<K> type) {
        return new EnumMap((Class) Preconditions.checkNotNull(type));
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Map<K, ? extends V> map) {
        return new EnumMap(map);
    }

    public static <K, V> IdentityHashMap<K, V> newIdentityHashMap() {
        return new IdentityHashMap();
    }

    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right) {
        if (left instanceof SortedMap) {
            return difference((SortedMap) left, (Map) right);
        }
        return difference(left, right, Equivalence.equals());
    }

    @Beta
    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right, Equivalence<? super V> valueEquivalence) {
        Preconditions.checkNotNull(valueEquivalence);
        Map<K, V> onlyOnLeft = newHashMap();
        Map<K, V> onlyOnRight = new HashMap(right);
        Map<K, V> onBoth = newHashMap();
        Map<K, ValueDifference<V>> differences = newHashMap();
        doDifference(left, right, valueEquivalence, onlyOnLeft, onlyOnRight, onBoth, differences);
        return new MapDifferenceImpl(onlyOnLeft, onlyOnRight, onBoth, differences);
    }

    private static <K, V> void doDifference(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right, Equivalence<? super V> valueEquivalence, Map<K, V> onlyOnLeft, Map<K, V> onlyOnRight, Map<K, V> onBoth, Map<K, ValueDifference<V>> differences) {
        for (Entry<? extends K, ? extends V> entry : left.entrySet()) {
            K leftKey = entry.getKey();
            V leftValue = entry.getValue();
            if (right.containsKey(leftKey)) {
                V rightValue = onlyOnRight.remove(leftKey);
                if (valueEquivalence.equivalent(leftValue, rightValue)) {
                    onBoth.put(leftKey, leftValue);
                } else {
                    differences.put(leftKey, ValueDifferenceImpl.create(leftValue, rightValue));
                }
            } else {
                onlyOnLeft.put(leftKey, leftValue);
            }
        }
    }

    private static <K, V> Map<K, V> unmodifiableMap(Map<K, V> map) {
        if (map instanceof SortedMap) {
            return Collections.unmodifiableSortedMap((SortedMap) map);
        }
        return Collections.unmodifiableMap(map);
    }

    public static <K, V> SortedMapDifference<K, V> difference(SortedMap<K, ? extends V> left, Map<? extends K, ? extends V> right) {
        Preconditions.checkNotNull(left);
        Preconditions.checkNotNull(right);
        Comparator comparator = orNaturalOrder(left.comparator());
        SortedMap<K, V> onlyOnLeft = newTreeMap(comparator);
        SortedMap<K, V> onlyOnRight = newTreeMap(comparator);
        onlyOnRight.putAll(right);
        SortedMap<K, V> onBoth = newTreeMap(comparator);
        SortedMap<K, ValueDifference<V>> differences = newTreeMap(comparator);
        doDifference(left, right, Equivalence.equals(), onlyOnLeft, onlyOnRight, onBoth, differences);
        return new SortedMapDifferenceImpl(onlyOnLeft, onlyOnRight, onBoth, differences);
    }

    static <E> Comparator<? super E> orNaturalOrder(@Nullable Comparator<? super E> comparator) {
        return comparator != null ? comparator : Ordering.natural();
    }

    @Beta
    public static <K, V> Map<K, V> asMap(Set<K> set, Function<? super K, V> function) {
        if (set instanceof SortedSet) {
            return asMap((SortedSet) set, (Function) function);
        }
        return new AsMapView(set, function);
    }

    @Beta
    public static <K, V> SortedMap<K, V> asMap(SortedSet<K> set, Function<? super K, V> function) {
        return Platform.mapsAsMapSortedSet(set, function);
    }

    static <K, V> SortedMap<K, V> asMapSortedIgnoreNavigable(SortedSet<K> set, Function<? super K, V> function) {
        return new SortedAsMapView(set, function);
    }

    static <K, V> Iterator<Entry<K, V>> asMapEntryIterator(Set<K> set, final Function<? super K, V> function) {
        return new TransformedIterator<K, Entry<K, V>>(set.iterator()) {
            Entry<K, V> transform(K key) {
                return Maps.immutableEntry(key, function.apply(key));
            }
        };
    }

    private static <E> Set<E> removeOnlySet(final Set<E> set) {
        return new ForwardingSet<E>() {
            protected Set<E> delegate() {
                return set;
            }

            public boolean add(E e) {
                throw new UnsupportedOperationException();
            }

            public boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }
        };
    }

    private static <E> SortedSet<E> removeOnlySortedSet(final SortedSet<E> set) {
        return new ForwardingSortedSet<E>() {
            protected SortedSet<E> delegate() {
                return set;
            }

            public boolean add(E e) {
                throw new UnsupportedOperationException();
            }

            public boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }

            public SortedSet<E> headSet(E toElement) {
                return Maps.removeOnlySortedSet(super.headSet(toElement));
            }

            public SortedSet<E> subSet(E fromElement, E toElement) {
                return Maps.removeOnlySortedSet(super.subSet(fromElement, toElement));
            }

            public SortedSet<E> tailSet(E fromElement) {
                return Maps.removeOnlySortedSet(super.tailSet(fromElement));
            }
        };
    }

    @Beta
    public static <K, V> ImmutableMap<K, V> toMap(Iterable<K> keys, Function<? super K, V> valueFunction) {
        return toMap(keys.iterator(), (Function) valueFunction);
    }

    @Beta
    public static <K, V> ImmutableMap<K, V> toMap(Iterator<K> keys, Function<? super K, V> valueFunction) {
        Preconditions.checkNotNull(valueFunction);
        Map<K, V> builder = newLinkedHashMap();
        while (keys.hasNext()) {
            K key = keys.next();
            builder.put(key, valueFunction.apply(key));
        }
        return ImmutableMap.copyOf(builder);
    }

    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterable<V> values, Function<? super V, K> keyFunction) {
        return uniqueIndex(values.iterator(), (Function) keyFunction);
    }

    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterator<V> values, Function<? super V, K> keyFunction) {
        Preconditions.checkNotNull(keyFunction);
        Builder<K, V> builder = ImmutableMap.builder();
        while (values.hasNext()) {
            V value = values.next();
            builder.put(keyFunction.apply(value), value);
        }
        return builder.build();
    }

    @GwtIncompatible("java.util.Properties")
    public static ImmutableMap<String, String> fromProperties(Properties properties) {
        Builder<String, String> builder = ImmutableMap.builder();
        Enumeration<?> e = properties.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            builder.put(key, properties.getProperty(key));
        }
        return builder.build();
    }

    @GwtCompatible(serializable = true)
    public static <K, V> Entry<K, V> immutableEntry(@Nullable K key, @Nullable V value) {
        return new ImmutableEntry(key, value);
    }

    static <K, V> Set<Entry<K, V>> unmodifiableEntrySet(Set<Entry<K, V>> entrySet) {
        return new UnmodifiableEntrySet(Collections.unmodifiableSet(entrySet));
    }

    static <K, V> Entry<K, V> unmodifiableEntry(final Entry<? extends K, ? extends V> entry) {
        Preconditions.checkNotNull(entry);
        return new AbstractMapEntry<K, V>() {
            public K getKey() {
                return entry.getKey();
            }

            public V getValue() {
                return entry.getValue();
            }
        };
    }

    @Beta
    public static <A, B> Converter<A, B> asConverter(BiMap<A, B> bimap) {
        return new BiMapConverter(bimap);
    }

    public static <K, V> BiMap<K, V> synchronizedBiMap(BiMap<K, V> bimap) {
        return Synchronized.biMap(bimap, null);
    }

    public static <K, V> BiMap<K, V> unmodifiableBiMap(BiMap<? extends K, ? extends V> bimap) {
        return new UnmodifiableBiMap(bimap, null);
    }

    public static <K, V1, V2> Map<K, V2> transformValues(Map<K, V1> fromMap, Function<? super V1, V2> function) {
        return transformEntries((Map) fromMap, asEntryTransformer(function));
    }

    public static <K, V1, V2> SortedMap<K, V2> transformValues(SortedMap<K, V1> fromMap, Function<? super V1, V2> function) {
        return transformEntries((SortedMap) fromMap, asEntryTransformer(function));
    }

    public static <K, V1, V2> Map<K, V2> transformEntries(Map<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
        if (fromMap instanceof SortedMap) {
            return transformEntries((SortedMap) fromMap, (EntryTransformer) transformer);
        }
        return new TransformedEntriesMap(fromMap, transformer);
    }

    public static <K, V1, V2> SortedMap<K, V2> transformEntries(SortedMap<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
        return Platform.mapsTransformEntriesSortedMap(fromMap, transformer);
    }

    static <K, V1, V2> SortedMap<K, V2> transformEntriesIgnoreNavigable(SortedMap<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
        return new TransformedEntriesSortedMap(fromMap, transformer);
    }

    static <K, V1, V2> EntryTransformer<K, V1, V2> asEntryTransformer(final Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return new EntryTransformer<K, V1, V2>() {
            public V2 transformEntry(K k, V1 value) {
                return function.apply(value);
            }
        };
    }

    static <K, V1, V2> Function<V1, V2> asValueToValueFunction(final EntryTransformer<? super K, V1, V2> transformer, final K key) {
        Preconditions.checkNotNull(transformer);
        return new Function<V1, V2>() {
            public V2 apply(@Nullable V1 v1) {
                return transformer.transformEntry(key, v1);
            }
        };
    }

    static <K, V1, V2> Function<Entry<K, V1>, V2> asEntryToValueFunction(final EntryTransformer<? super K, ? super V1, V2> transformer) {
        Preconditions.checkNotNull(transformer);
        return new Function<Entry<K, V1>, V2>() {
            public V2 apply(Entry<K, V1> entry) {
                return transformer.transformEntry(entry.getKey(), entry.getValue());
            }
        };
    }

    static <V2, K, V1> Entry<K, V2> transformEntry(final EntryTransformer<? super K, ? super V1, V2> transformer, final Entry<K, V1> entry) {
        Preconditions.checkNotNull(transformer);
        Preconditions.checkNotNull(entry);
        return new AbstractMapEntry<K, V2>() {
            public K getKey() {
                return entry.getKey();
            }

            public V2 getValue() {
                return transformer.transformEntry(entry.getKey(), entry.getValue());
            }
        };
    }

    static <K, V1, V2> Function<Entry<K, V1>, Entry<K, V2>> asEntryToEntryFunction(final EntryTransformer<? super K, ? super V1, V2> transformer) {
        Preconditions.checkNotNull(transformer);
        return new Function<Entry<K, V1>, Entry<K, V2>>() {
            public Entry<K, V2> apply(Entry<K, V1> entry) {
                return Maps.transformEntry(transformer, entry);
            }
        };
    }

    static <K> Predicate<Entry<K, ?>> keyPredicateOnEntries(Predicate<? super K> keyPredicate) {
        return Predicates.compose(keyPredicate, keyFunction());
    }

    static <V> Predicate<Entry<?, V>> valuePredicateOnEntries(Predicate<? super V> valuePredicate) {
        return Predicates.compose(valuePredicate, valueFunction());
    }

    public static <K, V> Map<K, V> filterKeys(Map<K, V> unfiltered, Predicate<? super K> keyPredicate) {
        if (unfiltered instanceof SortedMap) {
            return filterKeys((SortedMap) unfiltered, (Predicate) keyPredicate);
        }
        if (unfiltered instanceof BiMap) {
            return filterKeys((BiMap) unfiltered, (Predicate) keyPredicate);
        }
        Preconditions.checkNotNull(keyPredicate);
        Predicate entryPredicate = keyPredicateOnEntries(keyPredicate);
        return unfiltered instanceof AbstractFilteredMap ? filterFiltered((AbstractFilteredMap) unfiltered, entryPredicate) : new FilteredKeyMap((Map) Preconditions.checkNotNull(unfiltered), keyPredicate, entryPredicate);
    }

    public static <K, V> SortedMap<K, V> filterKeys(SortedMap<K, V> unfiltered, Predicate<? super K> keyPredicate) {
        return filterEntries((SortedMap) unfiltered, keyPredicateOnEntries(keyPredicate));
    }

    public static <K, V> BiMap<K, V> filterKeys(BiMap<K, V> unfiltered, Predicate<? super K> keyPredicate) {
        Preconditions.checkNotNull(keyPredicate);
        return filterEntries((BiMap) unfiltered, keyPredicateOnEntries(keyPredicate));
    }

    public static <K, V> Map<K, V> filterValues(Map<K, V> unfiltered, Predicate<? super V> valuePredicate) {
        if (unfiltered instanceof SortedMap) {
            return filterValues((SortedMap) unfiltered, (Predicate) valuePredicate);
        }
        if (unfiltered instanceof BiMap) {
            return filterValues((BiMap) unfiltered, (Predicate) valuePredicate);
        }
        return filterEntries((Map) unfiltered, valuePredicateOnEntries(valuePredicate));
    }

    public static <K, V> SortedMap<K, V> filterValues(SortedMap<K, V> unfiltered, Predicate<? super V> valuePredicate) {
        return filterEntries((SortedMap) unfiltered, valuePredicateOnEntries(valuePredicate));
    }

    public static <K, V> BiMap<K, V> filterValues(BiMap<K, V> unfiltered, Predicate<? super V> valuePredicate) {
        return filterEntries((BiMap) unfiltered, valuePredicateOnEntries(valuePredicate));
    }

    public static <K, V> Map<K, V> filterEntries(Map<K, V> unfiltered, Predicate<? super Entry<K, V>> entryPredicate) {
        if (unfiltered instanceof SortedMap) {
            return filterEntries((SortedMap) unfiltered, (Predicate) entryPredicate);
        }
        if (unfiltered instanceof BiMap) {
            return filterEntries((BiMap) unfiltered, (Predicate) entryPredicate);
        }
        Preconditions.checkNotNull(entryPredicate);
        return unfiltered instanceof AbstractFilteredMap ? filterFiltered((AbstractFilteredMap) unfiltered, (Predicate) entryPredicate) : new FilteredEntryMap((Map) Preconditions.checkNotNull(unfiltered), entryPredicate);
    }

    public static <K, V> SortedMap<K, V> filterEntries(SortedMap<K, V> unfiltered, Predicate<? super Entry<K, V>> entryPredicate) {
        return Platform.mapsFilterSortedMap(unfiltered, entryPredicate);
    }

    static <K, V> SortedMap<K, V> filterSortedIgnoreNavigable(SortedMap<K, V> unfiltered, Predicate<? super Entry<K, V>> entryPredicate) {
        Preconditions.checkNotNull(entryPredicate);
        return unfiltered instanceof FilteredEntrySortedMap ? filterFiltered((FilteredEntrySortedMap) unfiltered, (Predicate) entryPredicate) : new FilteredEntrySortedMap((SortedMap) Preconditions.checkNotNull(unfiltered), entryPredicate);
    }

    public static <K, V> BiMap<K, V> filterEntries(BiMap<K, V> unfiltered, Predicate<? super Entry<K, V>> entryPredicate) {
        Preconditions.checkNotNull(unfiltered);
        Preconditions.checkNotNull(entryPredicate);
        return unfiltered instanceof FilteredEntryBiMap ? filterFiltered((FilteredEntryBiMap) unfiltered, (Predicate) entryPredicate) : new FilteredEntryBiMap(unfiltered, entryPredicate);
    }

    private static <K, V> Map<K, V> filterFiltered(AbstractFilteredMap<K, V> map, Predicate<? super Entry<K, V>> entryPredicate) {
        return new FilteredEntryMap(map.unfiltered, Predicates.and(map.predicate, entryPredicate));
    }

    private static <K, V> SortedMap<K, V> filterFiltered(FilteredEntrySortedMap<K, V> map, Predicate<? super Entry<K, V>> entryPredicate) {
        return new FilteredEntrySortedMap(map.sortedMap(), Predicates.and(map.predicate, entryPredicate));
    }

    private static <K, V> BiMap<K, V> filterFiltered(FilteredEntryBiMap<K, V> map, Predicate<? super Entry<K, V>> entryPredicate) {
        return new FilteredEntryBiMap(map.unfiltered(), Predicates.and(map.predicate, entryPredicate));
    }

    @Nullable
    private static <K, V> Entry<K, V> unmodifiableOrNull(@Nullable Entry<K, V> entry) {
        return entry == null ? null : unmodifiableEntry(entry);
    }

    static <V> V safeGet(Map<?, V> map, @Nullable Object key) {
        V v = null;
        Preconditions.checkNotNull(map);
        try {
            v = map.get(key);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return v;
    }

    static boolean safeContainsKey(Map<?, ?> map, Object key) {
        boolean z = false;
        Preconditions.checkNotNull(map);
        try {
            z = map.containsKey(key);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return z;
    }

    static <V> V safeRemove(Map<?, V> map, Object key) {
        V v = null;
        Preconditions.checkNotNull(map);
        try {
            v = map.remove(key);
        } catch (ClassCastException e) {
        } catch (NullPointerException e2) {
        }
        return v;
    }

    static boolean containsKeyImpl(Map<?, ?> map, @Nullable Object key) {
        return Iterators.contains(keyIterator(map.entrySet().iterator()), key);
    }

    static boolean containsValueImpl(Map<?, ?> map, @Nullable Object value) {
        return Iterators.contains(valueIterator(map.entrySet().iterator()), value);
    }

    static <K, V> boolean containsEntryImpl(Collection<Entry<K, V>> c, Object o) {
        if (o instanceof Entry) {
            return c.contains(unmodifiableEntry((Entry) o));
        }
        return false;
    }

    static <K, V> boolean removeEntryImpl(Collection<Entry<K, V>> c, Object o) {
        if (o instanceof Entry) {
            return c.remove(unmodifiableEntry((Entry) o));
        }
        return false;
    }

    static boolean equalsImpl(Map<?, ?> map, Object object) {
        if (map == object) {
            return true;
        }
        if (!(object instanceof Map)) {
            return false;
        }
        return map.entrySet().equals(((Map) object).entrySet());
    }

    static String toStringImpl(Map<?, ?> map) {
        StringBuilder sb = Collections2.newStringBuilderForCollection(map.size()).append('{');
        STANDARD_JOINER.appendTo(sb, (Map) map);
        return sb.append('}').toString();
    }

    static <K, V> void putAllImpl(Map<K, V> self, Map<? extends K, ? extends V> map) {
        for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
            self.put(entry.getKey(), entry.getValue());
        }
    }

    @Nullable
    static <K> K keyOrNull(@Nullable Entry<K, ?> entry) {
        return entry == null ? null : entry.getKey();
    }

    @Nullable
    static <V> V valueOrNull(@Nullable Entry<?, V> entry) {
        return entry == null ? null : entry.getValue();
    }
}
