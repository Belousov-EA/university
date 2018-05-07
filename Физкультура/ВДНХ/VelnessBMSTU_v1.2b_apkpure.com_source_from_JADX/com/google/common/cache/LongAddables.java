package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

@GwtCompatible(emulated = true)
final class LongAddables {
    private static final Supplier<LongAddable> SUPPLIER;

    static class C06071 implements Supplier<LongAddable> {
        C06071() {
        }

        public LongAddable get() {
            return new LongAdder();
        }
    }

    static class C06082 implements Supplier<LongAddable> {
        C06082() {
        }

        public LongAddable get() {
            return new PureJavaLongAddable();
        }
    }

    private static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        private PureJavaLongAddable() {
        }

        public void increment() {
            getAndIncrement();
        }

        public void add(long x) {
            getAndAdd(x);
        }

        public long sum() {
            return get();
        }
    }

    LongAddables() {
    }

    static {
        Supplier<LongAddable> supplier;
        try {
            LongAdder longAdder = new LongAdder();
            supplier = new C06071();
        } catch (Throwable th) {
            supplier = new C06082();
        }
        SUPPLIER = supplier;
    }

    public static LongAddable create() {
        return (LongAddable) SUPPLIER.get();
    }
}
