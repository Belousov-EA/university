package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@Beta
public final class Futures {
    private static final AsyncFunction<ListenableFuture<Object>, Object> DEREFERENCER = new C07793();
    private static final Ordering<Constructor<?>> WITH_STRING_PARAM_FIRST = Ordering.natural().onResultOf(new C07806()).reverse();

    private interface FutureCombiner<V, C> {
        C combine(List<Optional<V>> list);
    }

    static class C07793 implements AsyncFunction<ListenableFuture<Object>, Object> {
        C07793() {
        }

        public ListenableFuture<Object> apply(ListenableFuture<Object> input) {
            return input;
        }
    }

    static class C07806 implements Function<Constructor<?>, Boolean> {
        C07806() {
        }

        public Boolean apply(Constructor<?> input) {
            return Boolean.valueOf(Arrays.asList(input.getParameterTypes()).contains(String.class));
        }
    }

    static class C07817 implements FutureCombiner<V, List<V>> {
        C07817() {
        }

        public List<V> combine(List<Optional<V>> values) {
            List<V> result = Lists.newArrayList();
            for (Optional<V> element : values) {
                result.add(element != null ? element.orNull() : null);
            }
            return Collections.unmodifiableList(result);
        }
    }

    private static abstract class ImmediateFuture<V> implements ListenableFuture<V> {
        private static final Logger log = Logger.getLogger(ImmediateFuture.class.getName());

        public abstract V get() throws ExecutionException;

        private ImmediateFuture() {
        }

        public void addListener(Runnable listener, Executor executor) {
            Preconditions.checkNotNull(listener, "Runnable was null.");
            Preconditions.checkNotNull(executor, "Executor was null.");
            try {
                executor.execute(listener);
            } catch (RuntimeException e) {
                log.log(Level.SEVERE, "RuntimeException while executing runnable " + listener + " with executor " + executor, e);
            }
        }

        public boolean cancel(boolean mayInterruptIfRunning) {
            return false;
        }

        public V get(long timeout, TimeUnit unit) throws ExecutionException {
            Preconditions.checkNotNull(unit);
            return get();
        }

        public boolean isCancelled() {
            return false;
        }

        public boolean isDone() {
            return true;
        }
    }

    private static class ChainingListenableFuture<I, O> extends AbstractFuture<O> implements Runnable {
        private AsyncFunction<? super I, ? extends O> function;
        private ListenableFuture<? extends I> inputFuture;
        private final CountDownLatch outputCreated;
        private volatile ListenableFuture<? extends O> outputFuture;

        private ChainingListenableFuture(AsyncFunction<? super I, ? extends O> function, ListenableFuture<? extends I> inputFuture) {
            this.outputCreated = new CountDownLatch(1);
            this.function = (AsyncFunction) Preconditions.checkNotNull(function);
            this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(inputFuture);
        }

        public boolean cancel(boolean mayInterruptIfRunning) {
            if (!super.cancel(mayInterruptIfRunning)) {
                return false;
            }
            cancel(this.inputFuture, mayInterruptIfRunning);
            cancel(this.outputFuture, mayInterruptIfRunning);
            return true;
        }

        private void cancel(@Nullable Future<?> future, boolean mayInterruptIfRunning) {
            if (future != null) {
                future.cancel(mayInterruptIfRunning);
            }
        }

        public void run() {
            try {
                try {
                    final ListenableFuture<? extends O> outputFuture = (ListenableFuture) Preconditions.checkNotNull(this.function.apply(Uninterruptibles.getUninterruptibly(this.inputFuture)), "AsyncFunction may not return null.");
                    this.outputFuture = outputFuture;
                    if (isCancelled()) {
                        outputFuture.cancel(wasInterrupted());
                        this.outputFuture = null;
                        return;
                    }
                    outputFuture.addListener(new Runnable() {
                        public void run() {
                            try {
                                ChainingListenableFuture.this.set(Uninterruptibles.getUninterruptibly(outputFuture));
                            } catch (CancellationException e) {
                                ChainingListenableFuture.this.cancel(false);
                            } catch (ExecutionException e2) {
                                ChainingListenableFuture.this.setException(e2.getCause());
                            } finally {
                                ChainingListenableFuture.this.outputFuture = null;
                            }
                        }
                    }, MoreExecutors.sameThreadExecutor());
                    this.function = null;
                    this.inputFuture = null;
                    this.outputCreated.countDown();
                } catch (UndeclaredThrowableException e) {
                    setException(e.getCause());
                } catch (Throwable t) {
                    setException(t);
                } finally {
                    this.function = null;
                    this.inputFuture = null;
                    this.outputCreated.countDown();
                }
            } catch (CancellationException e2) {
                cancel(false);
                this.function = null;
                this.inputFuture = null;
                this.outputCreated.countDown();
            } catch (ExecutionException e3) {
                setException(e3.getCause());
                this.function = null;
                this.inputFuture = null;
                this.outputCreated.countDown();
            }
        }
    }

    private static class CombinedFuture<V, C> extends AbstractFuture<C> {
        private static final Logger logger = Logger.getLogger(CombinedFuture.class.getName());
        final boolean allMustSucceed;
        FutureCombiner<V, C> combiner;
        ImmutableCollection<? extends ListenableFuture<? extends V>> futures;
        final AtomicInteger remaining;
        Set<Throwable> seenExceptions;
        final Object seenExceptionsLock = new Object();
        List<Optional<V>> values;

        class C03801 implements Runnable {
            C03801() {
            }

            public void run() {
                if (CombinedFuture.this.isCancelled()) {
                    Iterator i$ = CombinedFuture.this.futures.iterator();
                    while (i$.hasNext()) {
                        ((ListenableFuture) i$.next()).cancel(CombinedFuture.this.wasInterrupted());
                    }
                }
                CombinedFuture.this.futures = null;
                CombinedFuture.this.values = null;
                CombinedFuture.this.combiner = null;
            }
        }

        private void setOneValue(int r11, java.util.concurrent.Future<? extends V> r12) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x004e in list [B:17:0x0041]
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r10 = this;
            r8 = 1;
            r7 = 0;
            r2 = r10.values;
            r6 = r10.isDone();
            if (r6 != 0) goto L_0x000c;
        L_0x000a:
            if (r2 != 0) goto L_0x001c;
        L_0x000c:
            r6 = r10.allMustSucceed;
            if (r6 != 0) goto L_0x0016;
        L_0x0010:
            r6 = r10.isCancelled();
            if (r6 == 0) goto L_0x004f;
        L_0x0016:
            r6 = r8;
        L_0x0017:
            r9 = "Future was done before all dependencies completed";
            com.google.common.base.Preconditions.checkState(r6, r9);
        L_0x001c:
            r6 = r12.isDone();	 Catch:{ CancellationException -> 0x005b, ExecutionException -> 0x008b, Throwable -> 0x00ba, all -> 0x00e7 }
            r9 = "Tried to set value from future which is not done";	 Catch:{ CancellationException -> 0x005b, ExecutionException -> 0x008b, Throwable -> 0x00ba, all -> 0x00e7 }
            com.google.common.base.Preconditions.checkState(r6, r9);	 Catch:{ CancellationException -> 0x005b, ExecutionException -> 0x008b, Throwable -> 0x00ba, all -> 0x00e7 }
            r4 = com.google.common.util.concurrent.Uninterruptibles.getUninterruptibly(r12);	 Catch:{ CancellationException -> 0x005b, ExecutionException -> 0x008b, Throwable -> 0x00ba, all -> 0x00e7 }
            if (r2 == 0) goto L_0x0032;	 Catch:{ CancellationException -> 0x005b, ExecutionException -> 0x008b, Throwable -> 0x00ba, all -> 0x00e7 }
        L_0x002b:
            r6 = com.google.common.base.Optional.fromNullable(r4);	 Catch:{ CancellationException -> 0x005b, ExecutionException -> 0x008b, Throwable -> 0x00ba, all -> 0x00e7 }
            r2.set(r11, r6);	 Catch:{ CancellationException -> 0x005b, ExecutionException -> 0x008b, Throwable -> 0x00ba, all -> 0x00e7 }
        L_0x0032:
            r6 = r10.remaining;
            r3 = r6.decrementAndGet();
            if (r3 < 0) goto L_0x0051;
        L_0x003a:
            r6 = "Less than 0 remaining futures";
            com.google.common.base.Preconditions.checkState(r8, r6);
            if (r3 != 0) goto L_0x004e;
        L_0x0041:
            r1 = r10.combiner;
            if (r1 == 0) goto L_0x0053;
        L_0x0045:
            if (r2 == 0) goto L_0x0053;
        L_0x0047:
            r6 = r1.combine(r2);
            r10.set(r6);
        L_0x004e:
            return;
        L_0x004f:
            r6 = r7;
            goto L_0x0017;
        L_0x0051:
            r8 = r7;
            goto L_0x003a;
        L_0x0053:
            r6 = r10.isDone();
            com.google.common.base.Preconditions.checkState(r6);
            goto L_0x004e;
        L_0x005b:
            r0 = move-exception;
            r6 = r10.allMustSucceed;	 Catch:{ CancellationException -> 0x005b, ExecutionException -> 0x008b, Throwable -> 0x00ba, all -> 0x00e7 }
            if (r6 == 0) goto L_0x0064;	 Catch:{ CancellationException -> 0x005b, ExecutionException -> 0x008b, Throwable -> 0x00ba, all -> 0x00e7 }
        L_0x0060:
            r6 = 0;	 Catch:{ CancellationException -> 0x005b, ExecutionException -> 0x008b, Throwable -> 0x00ba, all -> 0x00e7 }
            r10.cancel(r6);	 Catch:{ CancellationException -> 0x005b, ExecutionException -> 0x008b, Throwable -> 0x00ba, all -> 0x00e7 }
        L_0x0064:
            r6 = r10.remaining;
            r3 = r6.decrementAndGet();
            if (r3 < 0) goto L_0x0081;
        L_0x006c:
            r6 = "Less than 0 remaining futures";
            com.google.common.base.Preconditions.checkState(r8, r6);
            if (r3 != 0) goto L_0x004e;
        L_0x0073:
            r1 = r10.combiner;
            if (r1 == 0) goto L_0x0083;
        L_0x0077:
            if (r2 == 0) goto L_0x0083;
        L_0x0079:
            r6 = r1.combine(r2);
            r10.set(r6);
            goto L_0x004e;
        L_0x0081:
            r8 = r7;
            goto L_0x006c;
        L_0x0083:
            r6 = r10.isDone();
            com.google.common.base.Preconditions.checkState(r6);
            goto L_0x004e;
        L_0x008b:
            r0 = move-exception;
            r6 = r0.getCause();	 Catch:{ CancellationException -> 0x005b, ExecutionException -> 0x008b, Throwable -> 0x00ba, all -> 0x00e7 }
            r10.setExceptionAndMaybeLog(r6);	 Catch:{ CancellationException -> 0x005b, ExecutionException -> 0x008b, Throwable -> 0x00ba, all -> 0x00e7 }
            r6 = r10.remaining;
            r3 = r6.decrementAndGet();
            if (r3 < 0) goto L_0x00b0;
        L_0x009b:
            r6 = "Less than 0 remaining futures";
            com.google.common.base.Preconditions.checkState(r8, r6);
            if (r3 != 0) goto L_0x004e;
        L_0x00a2:
            r1 = r10.combiner;
            if (r1 == 0) goto L_0x00b2;
        L_0x00a6:
            if (r2 == 0) goto L_0x00b2;
        L_0x00a8:
            r6 = r1.combine(r2);
            r10.set(r6);
            goto L_0x004e;
        L_0x00b0:
            r8 = r7;
            goto L_0x009b;
        L_0x00b2:
            r6 = r10.isDone();
            com.google.common.base.Preconditions.checkState(r6);
            goto L_0x004e;
        L_0x00ba:
            r5 = move-exception;
            r10.setExceptionAndMaybeLog(r5);	 Catch:{ CancellationException -> 0x005b, ExecutionException -> 0x008b, Throwable -> 0x00ba, all -> 0x00e7 }
            r6 = r10.remaining;
            r3 = r6.decrementAndGet();
            if (r3 < 0) goto L_0x00dc;
        L_0x00c6:
            r6 = "Less than 0 remaining futures";
            com.google.common.base.Preconditions.checkState(r8, r6);
            if (r3 != 0) goto L_0x004e;
        L_0x00cd:
            r1 = r10.combiner;
            if (r1 == 0) goto L_0x00de;
        L_0x00d1:
            if (r2 == 0) goto L_0x00de;
        L_0x00d3:
            r6 = r1.combine(r2);
            r10.set(r6);
            goto L_0x004e;
        L_0x00dc:
            r8 = r7;
            goto L_0x00c6;
        L_0x00de:
            r6 = r10.isDone();
            com.google.common.base.Preconditions.checkState(r6);
            goto L_0x004e;
        L_0x00e7:
            r6 = move-exception;
            r9 = r10.remaining;
            r3 = r9.decrementAndGet();
            if (r3 < 0) goto L_0x0105;
        L_0x00f0:
            r7 = "Less than 0 remaining futures";
            com.google.common.base.Preconditions.checkState(r8, r7);
            if (r3 != 0) goto L_0x0104;
        L_0x00f7:
            r1 = r10.combiner;
            if (r1 == 0) goto L_0x0107;
        L_0x00fb:
            if (r2 == 0) goto L_0x0107;
        L_0x00fd:
            r7 = r1.combine(r2);
            r10.set(r7);
        L_0x0104:
            throw r6;
        L_0x0105:
            r8 = r7;
            goto L_0x00f0;
        L_0x0107:
            r7 = r10.isDone();
            com.google.common.base.Preconditions.checkState(r7);
            goto L_0x0104;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Futures.CombinedFuture.setOneValue(int, java.util.concurrent.Future):void");
        }

        CombinedFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> futures, boolean allMustSucceed, Executor listenerExecutor, FutureCombiner<V, C> combiner) {
            this.futures = futures;
            this.allMustSucceed = allMustSucceed;
            this.remaining = new AtomicInteger(futures.size());
            this.combiner = combiner;
            this.values = Lists.newArrayListWithCapacity(futures.size());
            init(listenerExecutor);
        }

        protected void init(Executor listenerExecutor) {
            addListener(new C03801(), MoreExecutors.sameThreadExecutor());
            if (this.futures.isEmpty()) {
                set(this.combiner.combine(ImmutableList.of()));
                return;
            }
            int i;
            for (i = 0; i < this.futures.size(); i++) {
                this.values.add(null);
            }
            i = 0;
            Iterator i$ = this.futures.iterator();
            while (i$.hasNext()) {
                final ListenableFuture<? extends V> listenable = (ListenableFuture) i$.next();
                int i2 = i + 1;
                final int index = i;
                listenable.addListener(new Runnable() {
                    public void run() {
                        CombinedFuture.this.setOneValue(index, listenable);
                    }
                }, listenerExecutor);
                i = i2;
            }
        }

        private void setExceptionAndMaybeLog(Throwable throwable) {
            boolean visibleFromOutputFuture = false;
            boolean firstTimeSeeingThisException = true;
            if (this.allMustSucceed) {
                visibleFromOutputFuture = super.setException(throwable);
                synchronized (this.seenExceptionsLock) {
                    if (this.seenExceptions == null) {
                        this.seenExceptions = Sets.newHashSet();
                    }
                    firstTimeSeeingThisException = this.seenExceptions.add(throwable);
                }
            }
            if ((throwable instanceof Error) || (this.allMustSucceed && !visibleFromOutputFuture && firstTimeSeeingThisException)) {
                logger.log(Level.SEVERE, "input future failed.", throwable);
            }
        }
    }

    private static class FallbackFuture<V> extends AbstractFuture<V> {
        private volatile ListenableFuture<? extends V> running;

        FallbackFuture(ListenableFuture<? extends V> input, final FutureFallback<? extends V> fallback, Executor executor) {
            this.running = input;
            Futures.addCallback(this.running, new FutureCallback<V>() {

                class C07821 implements FutureCallback<V> {
                    C07821() {
                    }

                    public void onSuccess(V value) {
                        FallbackFuture.this.set(value);
                    }

                    public void onFailure(Throwable t) {
                        if (FallbackFuture.this.running.isCancelled()) {
                            FallbackFuture.this.cancel(false);
                        } else {
                            FallbackFuture.this.setException(t);
                        }
                    }
                }

                public void onSuccess(V value) {
                    FallbackFuture.this.set(value);
                }

                public void onFailure(Throwable t) {
                    if (!FallbackFuture.this.isCancelled()) {
                        try {
                            FallbackFuture.this.running = fallback.create(t);
                            if (FallbackFuture.this.isCancelled()) {
                                FallbackFuture.this.running.cancel(FallbackFuture.this.wasInterrupted());
                            } else {
                                Futures.addCallback(FallbackFuture.this.running, new C07821(), MoreExecutors.sameThreadExecutor());
                            }
                        } catch (Throwable e) {
                            FallbackFuture.this.setException(e);
                        }
                    }
                }
            }, executor);
        }

        public boolean cancel(boolean mayInterruptIfRunning) {
            if (!super.cancel(mayInterruptIfRunning)) {
                return false;
            }
            this.running.cancel(mayInterruptIfRunning);
            return true;
        }
    }

    private static class ImmediateCancelledFuture<V> extends ImmediateFuture<V> {
        private final CancellationException thrown = new CancellationException("Immediate cancelled future.");

        ImmediateCancelledFuture() {
            super();
        }

        public boolean isCancelled() {
            return true;
        }

        public V get() {
            throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", this.thrown);
        }
    }

    private static class ImmediateFailedCheckedFuture<V, X extends Exception> extends ImmediateFuture<V> implements CheckedFuture<V, X> {
        private final X thrown;

        ImmediateFailedCheckedFuture(X thrown) {
            super();
            this.thrown = thrown;
        }

        public V get() throws ExecutionException {
            throw new ExecutionException(this.thrown);
        }

        public V checkedGet() throws Exception {
            throw this.thrown;
        }

        public V checkedGet(long timeout, TimeUnit unit) throws Exception {
            Preconditions.checkNotNull(unit);
            throw this.thrown;
        }
    }

    private static class ImmediateFailedFuture<V> extends ImmediateFuture<V> {
        private final Throwable thrown;

        ImmediateFailedFuture(Throwable thrown) {
            super();
            this.thrown = thrown;
        }

        public V get() throws ExecutionException {
            throw new ExecutionException(this.thrown);
        }
    }

    private static class ImmediateSuccessfulCheckedFuture<V, X extends Exception> extends ImmediateFuture<V> implements CheckedFuture<V, X> {
        @Nullable
        private final V value;

        ImmediateSuccessfulCheckedFuture(@Nullable V value) {
            super();
            this.value = value;
        }

        public V get() {
            return this.value;
        }

        public V checkedGet() {
            return this.value;
        }

        public V checkedGet(long timeout, TimeUnit unit) {
            Preconditions.checkNotNull(unit);
            return this.value;
        }
    }

    private static class ImmediateSuccessfulFuture<V> extends ImmediateFuture<V> {
        @Nullable
        private final V value;

        ImmediateSuccessfulFuture(@Nullable V value) {
            super();
            this.value = value;
        }

        public V get() {
            return this.value;
        }
    }

    private static class NonCancellationPropagatingFuture<V> extends AbstractFuture<V> {
        NonCancellationPropagatingFuture(final ListenableFuture<V> delegate) {
            Preconditions.checkNotNull(delegate);
            Futures.addCallback(delegate, new FutureCallback<V>() {
                public void onSuccess(V result) {
                    NonCancellationPropagatingFuture.this.set(result);
                }

                public void onFailure(Throwable t) {
                    if (delegate.isCancelled()) {
                        NonCancellationPropagatingFuture.this.cancel(false);
                    } else {
                        NonCancellationPropagatingFuture.this.setException(t);
                    }
                }
            }, MoreExecutors.sameThreadExecutor());
        }
    }

    private static class MappingCheckedFuture<V, X extends Exception> extends AbstractCheckedFuture<V, X> {
        final Function<Exception, X> mapper;

        MappingCheckedFuture(ListenableFuture<V> delegate, Function<Exception, X> mapper) {
            super(delegate);
            this.mapper = (Function) Preconditions.checkNotNull(mapper);
        }

        protected X mapException(Exception e) {
            return (Exception) this.mapper.apply(e);
        }
    }

    private Futures() {
    }

    public static <V, X extends Exception> CheckedFuture<V, X> makeChecked(ListenableFuture<V> future, Function<Exception, X> mapper) {
        return new MappingCheckedFuture((ListenableFuture) Preconditions.checkNotNull(future), mapper);
    }

    public static <V> ListenableFuture<V> immediateFuture(@Nullable V value) {
        return new ImmediateSuccessfulFuture(value);
    }

    public static <V, X extends Exception> CheckedFuture<V, X> immediateCheckedFuture(@Nullable V value) {
        return new ImmediateSuccessfulCheckedFuture(value);
    }

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable throwable) {
        Preconditions.checkNotNull(throwable);
        return new ImmediateFailedFuture(throwable);
    }

    public static <V> ListenableFuture<V> immediateCancelledFuture() {
        return new ImmediateCancelledFuture();
    }

    public static <V, X extends Exception> CheckedFuture<V, X> immediateFailedCheckedFuture(X exception) {
        Preconditions.checkNotNull(exception);
        return new ImmediateFailedCheckedFuture(exception);
    }

    public static <V> ListenableFuture<V> withFallback(ListenableFuture<? extends V> input, FutureFallback<? extends V> fallback) {
        return withFallback(input, fallback, MoreExecutors.sameThreadExecutor());
    }

    public static <V> ListenableFuture<V> withFallback(ListenableFuture<? extends V> input, FutureFallback<? extends V> fallback, Executor executor) {
        Preconditions.checkNotNull(fallback);
        return new FallbackFuture(input, fallback, executor);
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> input, AsyncFunction<? super I, ? extends O> function) {
        return transform((ListenableFuture) input, (AsyncFunction) function, MoreExecutors.sameThreadExecutor());
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> input, AsyncFunction<? super I, ? extends O> function, Executor executor) {
        ChainingListenableFuture<I, O> output = new ChainingListenableFuture(function, input);
        input.addListener(output, executor);
        return output;
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> input, Function<? super I, ? extends O> function) {
        return transform((ListenableFuture) input, (Function) function, MoreExecutors.sameThreadExecutor());
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> input, final Function<? super I, ? extends O> function, Executor executor) {
        Preconditions.checkNotNull(function);
        return transform((ListenableFuture) input, new AsyncFunction<I, O>() {
            public ListenableFuture<O> apply(I input) {
                return Futures.immediateFuture(function.apply(input));
            }
        }, executor);
    }

    public static <I, O> Future<O> lazyTransform(final Future<I> input, final Function<? super I, ? extends O> function) {
        Preconditions.checkNotNull(input);
        Preconditions.checkNotNull(function);
        return new Future<O>() {
            public boolean cancel(boolean mayInterruptIfRunning) {
                return input.cancel(mayInterruptIfRunning);
            }

            public boolean isCancelled() {
                return input.isCancelled();
            }

            public boolean isDone() {
                return input.isDone();
            }

            public O get() throws InterruptedException, ExecutionException {
                return applyTransformation(input.get());
            }

            public O get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return applyTransformation(input.get(timeout, unit));
            }

            private O applyTransformation(I input) throws ExecutionException {
                try {
                    return function.apply(input);
                } catch (Throwable t) {
                    ExecutionException executionException = new ExecutionException(t);
                }
            }
        };
    }

    public static <V> ListenableFuture<V> dereference(ListenableFuture<? extends ListenableFuture<? extends V>> nested) {
        return transform((ListenableFuture) nested, DEREFERENCER);
    }

    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(ListenableFuture<? extends V>... futures) {
        return listFuture(ImmutableList.copyOf((Object[]) futures), true, MoreExecutors.sameThreadExecutor());
    }

    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(Iterable<? extends ListenableFuture<? extends V>> futures) {
        return listFuture(ImmutableList.copyOf((Iterable) futures), true, MoreExecutors.sameThreadExecutor());
    }

    public static <V> ListenableFuture<V> nonCancellationPropagating(ListenableFuture<V> future) {
        return new NonCancellationPropagatingFuture(future);
    }

    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(ListenableFuture<? extends V>... futures) {
        return listFuture(ImmutableList.copyOf((Object[]) futures), false, MoreExecutors.sameThreadExecutor());
    }

    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(Iterable<? extends ListenableFuture<? extends V>> futures) {
        return listFuture(ImmutableList.copyOf((Iterable) futures), false, MoreExecutors.sameThreadExecutor());
    }

    @Beta
    public static <T> ImmutableList<ListenableFuture<T>> inCompletionOrder(Iterable<? extends ListenableFuture<? extends T>> futures) {
        final ConcurrentLinkedQueue<AsyncSettableFuture<T>> delegates = Queues.newConcurrentLinkedQueue();
        Builder<ListenableFuture<T>> listBuilder = ImmutableList.builder();
        SerializingExecutor executor = new SerializingExecutor(MoreExecutors.sameThreadExecutor());
        for (final ListenableFuture<? extends T> future : futures) {
            Object delegate = AsyncSettableFuture.create();
            delegates.add(delegate);
            future.addListener(new Runnable() {
                public void run() {
                    ((AsyncSettableFuture) delegates.remove()).setFuture(future);
                }
            }, executor);
            listBuilder.add(delegate);
        }
        return listBuilder.build();
    }

    public static <V> void addCallback(ListenableFuture<V> future, FutureCallback<? super V> callback) {
        addCallback(future, callback, MoreExecutors.sameThreadExecutor());
    }

    public static <V> void addCallback(final ListenableFuture<V> future, final FutureCallback<? super V> callback, Executor executor) {
        Preconditions.checkNotNull(callback);
        future.addListener(new Runnable() {
            public void run() {
                try {
                    callback.onSuccess(Uninterruptibles.getUninterruptibly(future));
                } catch (ExecutionException e) {
                    callback.onFailure(e.getCause());
                } catch (RuntimeException e2) {
                    callback.onFailure(e2);
                } catch (Error e3) {
                    callback.onFailure(e3);
                }
            }
        }, executor);
    }

    public static <V, X extends Exception> V get(Future<V> future, Class<X> exceptionClass) throws Exception {
        boolean z;
        Preconditions.checkNotNull(future);
        if (RuntimeException.class.isAssignableFrom(exceptionClass)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "Futures.get exception type (%s) must not be a RuntimeException", exceptionClass);
        try {
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw newWithCause(exceptionClass, e);
        } catch (ExecutionException e2) {
            wrapAndThrowExceptionOrError(e2.getCause(), exceptionClass);
            throw new AssertionError();
        }
    }

    public static <V, X extends Exception> V get(Future<V> future, long timeout, TimeUnit unit, Class<X> exceptionClass) throws Exception {
        boolean z;
        Preconditions.checkNotNull(future);
        Preconditions.checkNotNull(unit);
        if (RuntimeException.class.isAssignableFrom(exceptionClass)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "Futures.get exception type (%s) must not be a RuntimeException", exceptionClass);
        try {
            return future.get(timeout, unit);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw newWithCause(exceptionClass, e);
        } catch (TimeoutException e2) {
            throw newWithCause(exceptionClass, e2);
        } catch (ExecutionException e3) {
            wrapAndThrowExceptionOrError(e3.getCause(), exceptionClass);
            throw new AssertionError();
        }
    }

    private static <X extends Exception> void wrapAndThrowExceptionOrError(Throwable cause, Class<X> exceptionClass) throws Exception {
        if (cause instanceof Error) {
            throw new ExecutionError((Error) cause);
        } else if (cause instanceof RuntimeException) {
            throw new UncheckedExecutionException(cause);
        } else {
            throw newWithCause(exceptionClass, cause);
        }
    }

    public static <V> V getUnchecked(Future<V> future) {
        Preconditions.checkNotNull(future);
        try {
            return Uninterruptibles.getUninterruptibly(future);
        } catch (ExecutionException e) {
            wrapAndThrowUnchecked(e.getCause());
            throw new AssertionError();
        }
    }

    private static void wrapAndThrowUnchecked(Throwable cause) {
        if (cause instanceof Error) {
            throw new ExecutionError((Error) cause);
        }
        throw new UncheckedExecutionException(cause);
    }

    private static <X extends Exception> X newWithCause(Class<X> exceptionClass, Throwable cause) {
        for (Constructor<X> constructor : preferringStrings(Arrays.asList(exceptionClass.getConstructors()))) {
            Exception instance = (Exception) newFromConstructor(constructor, cause);
            if (instance != null) {
                if (instance.getCause() == null) {
                    instance.initCause(cause);
                }
                return instance;
            }
        }
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + exceptionClass + " in response to chained exception", cause);
    }

    private static <X extends Exception> List<Constructor<X>> preferringStrings(List<Constructor<X>> constructors) {
        return WITH_STRING_PARAM_FIRST.sortedCopy(constructors);
    }

    @Nullable
    private static <X> X newFromConstructor(Constructor<X> constructor, Throwable cause) {
        X x = null;
        Class<?>[] paramTypes = constructor.getParameterTypes();
        Object[] params = new Object[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            Class<?> paramType = paramTypes[i];
            if (!paramType.equals(String.class)) {
                if (!paramType.equals(Throwable.class)) {
                    break;
                }
                params[i] = cause;
            } else {
                params[i] = cause.toString();
            }
        }
        try {
            x = constructor.newInstance(params);
        } catch (IllegalArgumentException e) {
        } catch (InstantiationException e2) {
        } catch (IllegalAccessException e3) {
        } catch (InvocationTargetException e4) {
        }
        return x;
    }

    private static <V> ListenableFuture<List<V>> listFuture(ImmutableList<ListenableFuture<? extends V>> futures, boolean allMustSucceed, Executor listenerExecutor) {
        return new CombinedFuture(futures, allMustSucceed, listenerExecutor, new C07817());
    }
}
