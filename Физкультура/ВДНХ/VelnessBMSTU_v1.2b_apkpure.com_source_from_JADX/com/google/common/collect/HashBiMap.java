package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable {
    private static final double LOAD_FACTOR = 1.0d;
    @GwtIncompatible("Not needed in emulated source")
    private static final long serialVersionUID = 0;
    private transient BiEntry<K, V>[] hashTableKToV;
    private transient BiEntry<K, V>[] hashTableVToK;
    private transient BiMap<V, K> inverse;
    private transient int mask;
    private transient int modCount;
    private transient int size;

    private static final class InverseSerializedForm<K, V> implements Serializable {
        private final HashBiMap<K, V> bimap;

        InverseSerializedForm(HashBiMap<K, V> bimap) {
            this.bimap = bimap;
        }

        Object readResolve() {
            return this.bimap.inverse();
        }
    }

    abstract class Itr<T> implements Iterator<T> {
        int expectedModCount = HashBiMap.this.modCount;
        BiEntry<K, V> next = null;
        int nextBucket = 0;
        BiEntry<K, V> toRemove = null;

        abstract T output(BiEntry<K, V> biEntry);

        Itr() {
        }

        private void checkForConcurrentModification() {
            if (HashBiMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            checkForConcurrentModification();
            if (this.next != null) {
                return true;
            }
            while (this.nextBucket < HashBiMap.this.hashTableKToV.length) {
                if (HashBiMap.this.hashTableKToV[this.nextBucket] != null) {
                    BiEntry[] access$100 = HashBiMap.this.hashTableKToV;
                    int i = this.nextBucket;
                    this.nextBucket = i + 1;
                    this.next = access$100[i];
                    return true;
                }
                this.nextBucket++;
            }
            return false;
        }

        public T next() {
            checkForConcurrentModification();
            if (hasNext()) {
                BiEntry<K, V> entry = this.next;
                this.next = entry.nextInKToVBucket;
                this.toRemove = entry;
                return output(entry);
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.toRemove != null);
            HashBiMap.this.delete(this.toRemove);
            this.expectedModCount = HashBiMap.this.modCount;
            this.toRemove = null;
        }
    }

    private final class Inverse extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {

        class C09191 extends EntrySet<V, K> {

            class C06291 extends Itr<Entry<V, K>> {

                class InverseEntry extends AbstractMapEntry<V, K> {
                    BiEntry<K, V> delegate;

                    InverseEntry(BiEntry<K, V> entry) {
                        this.delegate = entry;
                    }

                    public V getKey() {
                        return this.delegate.value;
                    }

                    public K getValue() {
                        return this.delegate.key;
                    }

                    public K setValue(K key) {
                        K oldKey = this.delegate.key;
                        int keyHash = HashBiMap.hash(key);
                        if (keyHash == this.delegate.keyHash && Objects.equal(key, oldKey)) {
                            return key;
                        }
                        boolean z;
                        if (HashBiMap.this.seekByKey(key, keyHash) == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Preconditions.checkArgument(z, "value already present: %s", key);
                        HashBiMap.this.delete(this.delegate);
                        HashBiMap.this.insert(new BiEntry(key, keyHash, this.delegate.value, this.delegate.valueHash));
                        C06291.this.expectedModCount = HashBiMap.this.modCount;
                        return oldKey;
                    }
                }

                C06291() {
                    super();
                }

                Entry<V, K> output(BiEntry<K, V> entry) {
                    return new InverseEntry(entry);
                }
            }

            C09191() {
            }

            Map<V, K> map() {
                return Inverse.this;
            }

            public Iterator<Entry<V, K>> iterator() {
                return new C06291();
            }
        }

        private final class InverseKeySet extends KeySet<V, K> {

            class C06301 extends Itr<V> {
                C06301() {
                    super();
                }

                V output(BiEntry<K, V> entry) {
                    return entry.value;
                }
            }

            InverseKeySet() {
                super(Inverse.this);
            }

            public boolean remove(@Nullable Object o) {
                BiEntry<K, V> entry = HashBiMap.this.seekByValue(o, HashBiMap.hash(o));
                if (entry == null) {
                    return false;
                }
                HashBiMap.this.delete(entry);
                return true;
            }

            public Iterator<V> iterator() {
                return new C06301();
            }
        }

        private Inverse() {
        }

        BiMap<K, V> forward() {
            return HashBiMap.this;
        }

        public int size() {
            return HashBiMap.this.size;
        }

        public void clear() {
            forward().clear();
        }

        public boolean containsKey(@Nullable Object value) {
            return forward().containsValue(value);
        }

        public K get(@Nullable Object value) {
            BiEntry<K, V> entry = HashBiMap.this.seekByValue(value, HashBiMap.hash(value));
            return entry == null ? null : entry.key;
        }

        public K put(@Nullable V value, @Nullable K key) {
            return HashBiMap.this.putInverse(value, key, false);
        }

        public K forcePut(@Nullable V value, @Nullable K key) {
            return HashBiMap.this.putInverse(value, key, true);
        }

        public K remove(@Nullable Object value) {
            BiEntry<K, V> entry = HashBiMap.this.seekByValue(value, HashBiMap.hash(value));
            if (entry == null) {
                return null;
            }
            HashBiMap.this.delete(entry);
            return entry.key;
        }

        public BiMap<K, V> inverse() {
            return forward();
        }

        public Set<V> keySet() {
            return new InverseKeySet();
        }

        public Set<K> values() {
            return forward().keySet();
        }

        public Set<Entry<V, K>> entrySet() {
            return new C09191();
        }

        Object writeReplace() {
            return new InverseSerializedForm(HashBiMap.this);
        }
    }

    private static final class BiEntry<K, V> extends ImmutableEntry<K, V> {
        final int keyHash;
        @Nullable
        BiEntry<K, V> nextInKToVBucket;
        @Nullable
        BiEntry<K, V> nextInVToKBucket;
        final int valueHash;

        BiEntry(K key, int keyHash, V value, int valueHash) {
            super(key, value);
            this.keyHash = keyHash;
            this.valueHash = valueHash;
        }
    }

    private final class EntrySet extends EntrySet<K, V> {

        class C06281 extends Itr<Entry<K, V>> {

            class MapEntry extends AbstractMapEntry<K, V> {
                BiEntry<K, V> delegate;

                MapEntry(BiEntry<K, V> entry) {
                    this.delegate = entry;
                }

                public K getKey() {
                    return this.delegate.key;
                }

                public V getValue() {
                    return this.delegate.value;
                }

                public V setValue(V value) {
                    V oldValue = this.delegate.value;
                    int valueHash = HashBiMap.hash(value);
                    if (valueHash == this.delegate.valueHash && Objects.equal(value, oldValue)) {
                        return value;
                    }
                    boolean z;
                    if (HashBiMap.this.seekByValue(value, valueHash) == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Preconditions.checkArgument(z, "value already present: %s", value);
                    HashBiMap.this.delete(this.delegate);
                    BiEntry<K, V> newEntry = new BiEntry(this.delegate.key, this.delegate.keyHash, value, valueHash);
                    HashBiMap.this.insert(newEntry);
                    C06281.this.expectedModCount = HashBiMap.this.modCount;
                    if (C06281.this.toRemove == this.delegate) {
                        C06281.this.toRemove = newEntry;
                    }
                    this.delegate = newEntry;
                    return oldValue;
                }
            }

            C06281() {
                super();
            }

            Entry<K, V> output(BiEntry<K, V> entry) {
                return new MapEntry(entry);
            }
        }

        private EntrySet() {
        }

        Map<K, V> map() {
            return HashBiMap.this;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C06281();
        }
    }

    private final class KeySet extends KeySet<K, V> {

        class C06311 extends Itr<K> {
            C06311() {
                super();
            }

            K output(BiEntry<K, V> entry) {
                return entry.key;
            }
        }

        KeySet() {
            super(HashBiMap.this);
        }

        public Iterator<K> iterator() {
            return new C06311();
        }

        public boolean remove(@Nullable Object o) {
            BiEntry<K, V> entry = HashBiMap.this.seekByKey(o, HashBiMap.hash(o));
            if (entry == null) {
                return false;
            }
            HashBiMap.this.delete(entry);
            return true;
        }
    }

    public static <K, V> HashBiMap<K, V> create() {
        return create(16);
    }

    public static <K, V> HashBiMap<K, V> create(int expectedSize) {
        return new HashBiMap(expectedSize);
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> bimap = create(map.size());
        bimap.putAll(map);
        return bimap;
    }

    private HashBiMap(int expectedSize) {
        init(expectedSize);
    }

    private void init(int expectedSize) {
        CollectPreconditions.checkNonnegative(expectedSize, "expectedSize");
        int tableSize = Hashing.closedTableSize(expectedSize, LOAD_FACTOR);
        this.hashTableKToV = createTable(tableSize);
        this.hashTableVToK = createTable(tableSize);
        this.mask = tableSize - 1;
        this.modCount = 0;
        this.size = 0;
    }

    private void delete(BiEntry<K, V> entry) {
        BiEntry<K, V> bucketEntry;
        int keyBucket = entry.keyHash & this.mask;
        BiEntry<K, V> prevBucketEntry = null;
        for (bucketEntry = this.hashTableKToV[keyBucket]; bucketEntry != entry; bucketEntry = bucketEntry.nextInKToVBucket) {
            prevBucketEntry = bucketEntry;
        }
        if (prevBucketEntry == null) {
            this.hashTableKToV[keyBucket] = entry.nextInKToVBucket;
        } else {
            prevBucketEntry.nextInKToVBucket = entry.nextInKToVBucket;
        }
        int valueBucket = entry.valueHash & this.mask;
        prevBucketEntry = null;
        for (bucketEntry = this.hashTableVToK[valueBucket]; bucketEntry != entry; bucketEntry = bucketEntry.nextInVToKBucket) {
            prevBucketEntry = bucketEntry;
        }
        if (prevBucketEntry == null) {
            this.hashTableVToK[valueBucket] = entry.nextInVToKBucket;
        } else {
            prevBucketEntry.nextInVToKBucket = entry.nextInVToKBucket;
        }
        this.size--;
        this.modCount++;
    }

    private void insert(BiEntry<K, V> entry) {
        int keyBucket = entry.keyHash & this.mask;
        entry.nextInKToVBucket = this.hashTableKToV[keyBucket];
        this.hashTableKToV[keyBucket] = entry;
        int valueBucket = entry.valueHash & this.mask;
        entry.nextInVToKBucket = this.hashTableVToK[valueBucket];
        this.hashTableVToK[valueBucket] = entry;
        this.size++;
        this.modCount++;
    }

    private static int hash(@Nullable Object o) {
        return Hashing.smear(o == null ? 0 : o.hashCode());
    }

    private BiEntry<K, V> seekByKey(@Nullable Object key, int keyHash) {
        BiEntry<K, V> entry = this.hashTableKToV[this.mask & keyHash];
        while (entry != null) {
            if (keyHash == entry.keyHash && Objects.equal(key, entry.key)) {
                return entry;
            }
            entry = entry.nextInKToVBucket;
        }
        return null;
    }

    private BiEntry<K, V> seekByValue(@Nullable Object value, int valueHash) {
        BiEntry<K, V> entry = this.hashTableVToK[this.mask & valueHash];
        while (entry != null) {
            if (valueHash == entry.valueHash && Objects.equal(value, entry.value)) {
                return entry;
            }
            entry = entry.nextInVToKBucket;
        }
        return null;
    }

    public boolean containsKey(@Nullable Object key) {
        return seekByKey(key, hash(key)) != null;
    }

    public boolean containsValue(@Nullable Object value) {
        return seekByValue(value, hash(value)) != null;
    }

    @Nullable
    public V get(@Nullable Object key) {
        BiEntry<K, V> entry = seekByKey(key, hash(key));
        return entry == null ? null : entry.value;
    }

    public V put(@Nullable K key, @Nullable V value) {
        return put(key, value, false);
    }

    public V forcePut(@Nullable K key, @Nullable V value) {
        return put(key, value, true);
    }

    private V put(@Nullable K key, @Nullable V value, boolean force) {
        int keyHash = hash(key);
        int valueHash = hash(value);
        BiEntry<K, V> oldEntryForKey = seekByKey(key, keyHash);
        if (oldEntryForKey != null && valueHash == oldEntryForKey.valueHash && Objects.equal(value, oldEntryForKey.value)) {
            return value;
        }
        V v;
        BiEntry<K, V> oldEntryForValue = seekByValue(value, valueHash);
        if (oldEntryForValue != null) {
            if (force) {
                delete(oldEntryForValue);
            } else {
                throw new IllegalArgumentException("value already present: " + value);
            }
        }
        if (oldEntryForKey != null) {
            delete(oldEntryForKey);
        }
        insert(new BiEntry(key, keyHash, value, valueHash));
        rehashIfNecessary();
        if (oldEntryForKey == null) {
            v = null;
        } else {
            v = oldEntryForKey.value;
        }
        return v;
    }

    @Nullable
    private K putInverse(@Nullable V value, @Nullable K key, boolean force) {
        int valueHash = hash(value);
        int keyHash = hash(key);
        BiEntry<K, V> oldEntryForValue = seekByValue(value, valueHash);
        if (oldEntryForValue != null && keyHash == oldEntryForValue.keyHash && Objects.equal(key, oldEntryForValue.key)) {
            return key;
        }
        K k;
        BiEntry<K, V> oldEntryForKey = seekByKey(key, keyHash);
        if (oldEntryForKey != null) {
            if (force) {
                delete(oldEntryForKey);
            } else {
                throw new IllegalArgumentException("value already present: " + key);
            }
        }
        if (oldEntryForValue != null) {
            delete(oldEntryForValue);
        }
        insert(new BiEntry(key, keyHash, value, valueHash));
        rehashIfNecessary();
        if (oldEntryForValue == null) {
            k = null;
        } else {
            k = oldEntryForValue.key;
        }
        return k;
    }

    private void rehashIfNecessary() {
        BiEntry<K, V>[] oldKToV = this.hashTableKToV;
        if (Hashing.needsResizing(this.size, oldKToV.length, LOAD_FACTOR)) {
            int newTableSize = oldKToV.length * 2;
            this.hashTableKToV = createTable(newTableSize);
            this.hashTableVToK = createTable(newTableSize);
            this.mask = newTableSize - 1;
            this.size = 0;
            for (BiEntry<K, V> entry : oldKToV) {
                BiEntry<K, V> entry2;
                while (entry2 != null) {
                    BiEntry<K, V> nextEntry = entry2.nextInKToVBucket;
                    insert(entry2);
                    entry2 = nextEntry;
                }
            }
            this.modCount++;
        }
    }

    private BiEntry<K, V>[] createTable(int length) {
        return new BiEntry[length];
    }

    public V remove(@Nullable Object key) {
        BiEntry<K, V> entry = seekByKey(key, hash(key));
        if (entry == null) {
            return null;
        }
        delete(entry);
        return entry.value;
    }

    public void clear() {
        this.size = 0;
        Arrays.fill(this.hashTableKToV, null);
        Arrays.fill(this.hashTableVToK, null);
        this.modCount++;
    }

    public int size() {
        return this.size;
    }

    public Set<K> keySet() {
        return new KeySet();
    }

    public Set<V> values() {
        return inverse().keySet();
    }

    public Set<Entry<K, V>> entrySet() {
        return new EntrySet();
    }

    public BiMap<V, K> inverse() {
        if (this.inverse != null) {
            return this.inverse;
        }
        BiMap<V, K> inverse = new Inverse();
        this.inverse = inverse;
        return inverse;
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        Serialization.writeMap(this, stream);
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        int size = Serialization.readCount(stream);
        init(size);
        Serialization.populateMap(this, stream, size);
    }
}
