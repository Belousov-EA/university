package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import javax.annotation.Nullable;

@Beta
public final class BloomFilter<T> implements Predicate<T>, Serializable {
    private static final Strategy DEFAULT_STRATEGY = getDefaultStrategyFromSystemProperty();
    @VisibleForTesting
    static final String USE_MITZ32_PROPERTY = "com.google.common.hash.BloomFilter.useMitz32";
    private final BitArray bits;
    private final Funnel<T> funnel;
    private final int numHashFunctions;
    private final Strategy strategy;

    private static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        final long[] data;
        final Funnel<T> funnel;
        final int numHashFunctions;
        final Strategy strategy;

        SerialForm(BloomFilter<T> bf) {
            this.data = bf.bits.data;
            this.numHashFunctions = bf.numHashFunctions;
            this.funnel = bf.funnel;
            this.strategy = bf.strategy;
        }

        Object readResolve() {
            return new BloomFilter(new BitArray(this.data), this.numHashFunctions, this.funnel, this.strategy);
        }
    }

    interface Strategy extends Serializable {
        <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, BitArray bitArray);

        int ordinal();

        <T> boolean put(T t, Funnel<? super T> funnel, int i, BitArray bitArray);
    }

    private BloomFilter(BitArray bits, int numHashFunctions, Funnel<T> funnel, Strategy strategy) {
        boolean z;
        Preconditions.checkArgument(numHashFunctions > 0, "numHashFunctions (%s) must be > 0", Integer.valueOf(numHashFunctions));
        if (numHashFunctions <= 255) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "numHashFunctions (%s) must be <= 255", Integer.valueOf(numHashFunctions));
        this.bits = (BitArray) Preconditions.checkNotNull(bits);
        this.numHashFunctions = numHashFunctions;
        this.funnel = (Funnel) Preconditions.checkNotNull(funnel);
        this.strategy = (Strategy) Preconditions.checkNotNull(strategy);
    }

    public BloomFilter<T> copy() {
        return new BloomFilter(this.bits.copy(), this.numHashFunctions, this.funnel, this.strategy);
    }

    public boolean mightContain(T object) {
        return this.strategy.mightContain(object, this.funnel, this.numHashFunctions, this.bits);
    }

    @Deprecated
    public boolean apply(T input) {
        return mightContain(input);
    }

    public boolean put(T object) {
        return this.strategy.put(object, this.funnel, this.numHashFunctions, this.bits);
    }

    public double expectedFpp() {
        return Math.pow(((double) this.bits.bitCount()) / ((double) bitSize()), (double) this.numHashFunctions);
    }

    @VisibleForTesting
    long bitSize() {
        return this.bits.bitSize();
    }

    public boolean isCompatible(BloomFilter<T> that) {
        Preconditions.checkNotNull(that);
        return this != that && this.numHashFunctions == that.numHashFunctions && bitSize() == that.bitSize() && this.strategy.equals(that.strategy) && this.funnel.equals(that.funnel);
    }

    public void putAll(BloomFilter<T> that) {
        boolean z;
        Preconditions.checkNotNull(that);
        Preconditions.checkArgument(this != that, "Cannot combine a BloomFilter with itself.");
        if (this.numHashFunctions == that.numHashFunctions) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "BloomFilters must have the same number of hash functions (%s != %s)", Integer.valueOf(this.numHashFunctions), Integer.valueOf(that.numHashFunctions));
        if (bitSize() == that.bitSize()) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "BloomFilters must have the same size underlying bit arrays (%s != %s)", Long.valueOf(bitSize()), Long.valueOf(that.bitSize()));
        Preconditions.checkArgument(this.strategy.equals(that.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, that.strategy);
        Preconditions.checkArgument(this.funnel.equals(that.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, that.funnel);
        this.bits.putAll(that.bits);
    }

    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof BloomFilter)) {
            return false;
        }
        BloomFilter<?> that = (BloomFilter) object;
        if (this.numHashFunctions == that.numHashFunctions && this.funnel.equals(that.funnel) && this.bits.equals(that.bits) && this.strategy.equals(that.strategy)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits);
    }

    @VisibleForTesting
    static Strategy getDefaultStrategyFromSystemProperty() {
        return Boolean.parseBoolean(System.getProperty(USE_MITZ32_PROPERTY)) ? BloomFilterStrategies.MURMUR128_MITZ_32 : BloomFilterStrategies.MURMUR128_MITZ_64;
    }

    public static <T> BloomFilter<T> create(Funnel<T> funnel, int expectedInsertions, double fpp) {
        return create(funnel, expectedInsertions, fpp, DEFAULT_STRATEGY);
    }

    @VisibleForTesting
    static <T> BloomFilter<T> create(Funnel<T> funnel, int expectedInsertions, double fpp, Strategy strategy) {
        boolean z;
        Preconditions.checkNotNull(funnel);
        if (expectedInsertions >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Expected insertions (%s) must be >= 0", Integer.valueOf(expectedInsertions));
        if (fpp > 0.0d) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "False positive probability (%s) must be > 0.0", Double.valueOf(fpp));
        if (fpp < 1.0d) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "False positive probability (%s) must be < 1.0", Double.valueOf(fpp));
        Preconditions.checkNotNull(strategy);
        if (expectedInsertions == 0) {
            expectedInsertions = 1;
        }
        long numBits = optimalNumOfBits((long) expectedInsertions, fpp);
        try {
            return new BloomFilter(new BitArray(numBits), optimalNumOfHashFunctions((long) expectedInsertions, numBits), funnel, strategy);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Could not create BloomFilter of " + numBits + " bits", e);
        }
    }

    public static <T> BloomFilter<T> create(Funnel<T> funnel, int expectedInsertions) {
        return create(funnel, expectedInsertions, 0.03d);
    }

    @VisibleForTesting
    static int optimalNumOfHashFunctions(long n, long m) {
        return Math.max(1, (int) Math.round(((double) (m / n)) * Math.log(2.0d)));
    }

    @VisibleForTesting
    static long optimalNumOfBits(long n, double p) {
        if (p == 0.0d) {
            p = Double.MIN_VALUE;
        }
        return (long) ((((double) (-n)) * Math.log(p)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }
}
