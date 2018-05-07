package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements SetMultimap<K, V> {
    @GwtIncompatible("not needed in emulated source.")
    private static final long serialVersionUID = 0;
    private final transient ImmutableSet<V> emptySet;
    private transient ImmutableSet<Entry<K, V>> entries;
    private transient ImmutableSetMultimap<V, K> inverse;

    public static final class Builder<K, V> extends com.google.common.collect.ImmutableMultimap.Builder<K, V> {
        public Builder() {
            this.builderMultimap = new BuilderMultimap();
        }

        public Builder<K, V> put(K key, V value) {
            this.builderMultimap.put(Preconditions.checkNotNull(key), Preconditions.checkNotNull(value));
            return this;
        }

        public Builder<K, V> put(Entry<? extends K, ? extends V> entry) {
            this.builderMultimap.put(Preconditions.checkNotNull(entry.getKey()), Preconditions.checkNotNull(entry.getValue()));
            return this;
        }

        public Builder<K, V> putAll(K key, Iterable<? extends V> values) {
            Collection<V> collection = this.builderMultimap.get(Preconditions.checkNotNull(key));
            for (V value : values) {
                collection.add(Preconditions.checkNotNull(value));
            }
            return this;
        }

        public Builder<K, V> putAll(K key, V... values) {
            return putAll((Object) key, Arrays.asList(values));
        }

        public Builder<K, V> putAll(Multimap<? extends K, ? extends V> multimap) {
            for (Entry<? extends K, ? extends Collection<? extends V>> entry : multimap.asMap().entrySet()) {
                putAll(entry.getKey(), (Iterable) entry.getValue());
            }
            return this;
        }

        public Builder<K, V> orderKeysBy(Comparator<? super K> keyComparator) {
            this.keyComparator = (Comparator) Preconditions.checkNotNull(keyComparator);
            return this;
        }

        public Builder<K, V> orderValuesBy(Comparator<? super V> valueComparator) {
            super.orderValuesBy(valueComparator);
            return this;
        }

        public ImmutableSetMultimap<K, V> build() {
            if (this.keyComparator != null) {
                Multimap<K, V> sortedCopy = new BuilderMultimap();
                List<Entry<K, Collection<V>>> entries = Lists.newArrayList(this.builderMultimap.asMap().entrySet());
                Collections.sort(entries, Ordering.from(this.keyComparator).onKeys());
                for (Entry<K, Collection<V>> entry : entries) {
                    sortedCopy.putAll(entry.getKey(), (Iterable) entry.getValue());
                }
                this.builderMultimap = sortedCopy;
            }
            return ImmutableSetMultimap.copyOf(this.builderMultimap, this.valueComparator);
        }
    }

    private static final class EntrySet<K, V> extends ImmutableSet<Entry<K, V>> {
        private final transient ImmutableSetMultimap<K, V> multimap;

        EntrySet(ImmutableSetMultimap<K, V> multimap) {
            this.multimap = multimap;
        }

        public boolean contains(@Nullable Object object) {
            if (!(object instanceof Entry)) {
                return false;
            }
            Entry<?, ?> entry = (Entry) object;
            return this.multimap.containsEntry(entry.getKey(), entry.getValue());
        }

        public int size() {
            return this.multimap.size();
        }

        public UnmodifiableIterator<Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }

        boolean isPartialView() {
            return false;
        }
    }

    private static class BuilderMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {
        private static final long serialVersionUID = 0;

        BuilderMultimap() {
            super(new LinkedHashMap());
        }

        Collection<V> createCollection() {
            return Sets.newLinkedHashSet();
        }
    }

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k1, V v1) {
        Builder<K, V> builder = builder();
        builder.put((Object) k1, (Object) v1);
        return builder.build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k1, V v1, K k2, V v2) {
        Builder<K, V> builder = builder();
        builder.put((Object) k1, (Object) v1);
        builder.put((Object) k2, (Object) v2);
        return builder.build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3) {
        Builder<K, V> builder = builder();
        builder.put((Object) k1, (Object) v1);
        builder.put((Object) k2, (Object) v2);
        builder.put((Object) k3, (Object) v3);
        return builder.build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        Builder<K, V> builder = builder();
        builder.put((Object) k1, (Object) v1);
        builder.put((Object) k2, (Object) v2);
        builder.put((Object) k3, (Object) v3);
        builder.put((Object) k4, (Object) v4);
        return builder.build();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Builder<K, V> builder = builder();
        builder.put((Object) k1, (Object) v1);
        builder.put((Object) k2, (Object) v2);
        builder.put((Object) k3, (Object) v3);
        builder.put((Object) k4, (Object) v4);
        builder.put((Object) k5, (Object) v5);
        return builder.build();
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        return copyOf(multimap, null);
    }

    private static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap, Comparator<? super V> valueComparator) {
        Preconditions.checkNotNull(multimap);
        if (multimap.isEmpty() && valueComparator == null) {
            return of();
        }
        if (multimap instanceof ImmutableSetMultimap) {
            ImmutableSetMultimap<K, V> kvMultimap = (ImmutableSetMultimap) multimap;
            if (!kvMultimap.isPartialView()) {
                return kvMultimap;
            }
        }
        com.google.common.collect.ImmutableMap.Builder<K, ImmutableSet<V>> builder = ImmutableMap.builder();
        int size = 0;
        for (Entry<? extends K, ? extends Collection<? extends V>> entry : multimap.asMap().entrySet()) {
            K key = entry.getKey();
            ImmutableSet<V> set = valueSet(valueComparator, (Collection) entry.getValue());
            if (!set.isEmpty()) {
                builder.put(key, set);
                size += set.size();
            }
        }
        return new ImmutableSetMultimap(builder.build(), size, valueComparator);
    }

    ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> map, int size, @Nullable Comparator<? super V> valueComparator) {
        super(map, size);
        this.emptySet = emptySet(valueComparator);
    }

    public ImmutableSet<V> get(@Nullable K key) {
        return (ImmutableSet) Objects.firstNonNull((ImmutableSet) this.map.get(key), this.emptySet);
    }

    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> immutableSetMultimap = this.inverse;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        immutableSetMultimap = invert();
        this.inverse = immutableSetMultimap;
        return immutableSetMultimap;
    }

    private ImmutableSetMultimap<V, K> invert() {
        Builder<V, K> builder = builder();
        Iterator i$ = entries().iterator();
        while (i$.hasNext()) {
            Entry<K, V> entry = (Entry) i$.next();
            builder.put(entry.getValue(), entry.getKey());
        }
        ImmutableSetMultimap<V, K> invertedMultimap = builder.build();
        invertedMultimap.inverse = this;
        return invertedMultimap;
    }

    @Deprecated
    public ImmutableSet<V> removeAll(Object key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public ImmutableSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    public ImmutableSet<Entry<K, V>> entries() {
        ImmutableSet<Entry<K, V>> immutableSet = this.entries;
        if (immutableSet != null) {
            return immutableSet;
        }
        immutableSet = new EntrySet(this);
        this.entries = immutableSet;
        return immutableSet;
    }

    private static <V> ImmutableSet<V> valueSet(@Nullable Comparator<? super V> valueComparator, Collection<? extends V> values) {
        return valueComparator == null ? ImmutableSet.copyOf((Collection) values) : ImmutableSortedSet.copyOf((Comparator) valueComparator, (Collection) values);
    }

    private static <V> ImmutableSet<V> emptySet(@Nullable Comparator<? super V> valueComparator) {
        return valueComparator == null ? ImmutableSet.of() : ImmutableSortedSet.emptySet(valueComparator);
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(valueComparator());
        Serialization.writeMultimap(this, stream);
    }

    @Nullable
    Comparator<? super V> valueComparator() {
        return this.emptySet instanceof ImmutableSortedSet ? ((ImmutableSortedSet) this.emptySet).comparator() : null;
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        Comparator<Object> valueComparator = (Comparator) stream.readObject();
        int keyCount = stream.readInt();
        if (keyCount < 0) {
            throw new InvalidObjectException("Invalid key count " + keyCount);
        }
        com.google.common.collect.ImmutableMap.Builder<Object, ImmutableSet<Object>> builder = ImmutableMap.builder();
        int tmpSize = 0;
        for (int i = 0; i < keyCount; i++) {
            Object key = stream.readObject();
            int valueCount = stream.readInt();
            if (valueCount <= 0) {
                throw new InvalidObjectException("Invalid value count " + valueCount);
            }
            Object[] array = new Object[valueCount];
            for (int j = 0; j < valueCount; j++) {
                array[j] = stream.readObject();
            }
            ImmutableSet<Object> valueSet = valueSet(valueComparator, Arrays.asList(array));
            if (valueSet.size() != array.length) {
                throw new InvalidObjectException("Duplicate key-value pairs exist for key " + key);
            }
            builder.put(key, valueSet);
            tmpSize += valueCount;
        }
        try {
            FieldSettersHolder.MAP_FIELD_SETTER.set((Object) this, builder.build());
            FieldSettersHolder.SIZE_FIELD_SETTER.set((Object) this, tmpSize);
            FieldSettersHolder.EMPTY_SET_FIELD_SETTER.set((Object) this, emptySet(valueComparator));
        } catch (IllegalArgumentException e) {
            throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
        }
    }
}
