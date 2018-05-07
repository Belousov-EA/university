package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.ForwardingListenableFuture.SimpleForwardingListenableFuture;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class MoreExecutors {

    @VisibleForTesting
    static class Application {
        Application() {
        }

        final ExecutorService getExitingExecutorService(ThreadPoolExecutor executor, long terminationTimeout, TimeUnit timeUnit) {
            MoreExecutors.useDaemonThreadFactory(executor);
            ExecutorService service = Executors.unconfigurableExecutorService(executor);
            addDelayedShutdownHook(service, terminationTimeout, timeUnit);
            return service;
        }

        final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor executor, long terminationTimeout, TimeUnit timeUnit) {
            MoreExecutors.useDaemonThreadFactory(executor);
            ScheduledExecutorService service = Executors.unconfigurableScheduledExecutorService(executor);
            addDelayedShutdownHook(service, terminationTimeout, timeUnit);
            return service;
        }

        final void addDelayedShutdownHook(ExecutorService service, long terminationTimeout, TimeUnit timeUnit) {
            Preconditions.checkNotNull(service);
            Preconditions.checkNotNull(timeUnit);
            final ExecutorService executorService = service;
            final long j = terminationTimeout;
            final TimeUnit timeUnit2 = timeUnit;
            addShutdownHook(MoreExecutors.newThread("DelayedShutdownHook-for-" + service, new Runnable() {
                public void run() {
                    try {
                        executorService.shutdown();
                        executorService.awaitTermination(j, timeUnit2);
                    } catch (InterruptedException e) {
                    }
                }
            }));
        }

        final ExecutorService getExitingExecutorService(ThreadPoolExecutor executor) {
            return getExitingExecutorService(executor, 120, TimeUnit.SECONDS);
        }

        final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor executor) {
            return getExitingScheduledExecutorService(executor, 120, TimeUnit.SECONDS);
        }

        @VisibleForTesting
        void addShutdownHook(Thread hook) {
            Runtime.getRuntime().addShutdownHook(hook);
        }
    }

    private static class ListeningDecorator extends AbstractListeningExecutorService {
        private final ExecutorService delegate;

        ListeningDecorator(ExecutorService delegate) {
            this.delegate = (ExecutorService) Preconditions.checkNotNull(delegate);
        }

        public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            return this.delegate.awaitTermination(timeout, unit);
        }

        public boolean isShutdown() {
            return this.delegate.isShutdown();
        }

        public boolean isTerminated() {
            return this.delegate.isTerminated();
        }

        public void shutdown() {
            this.delegate.shutdown();
        }

        public List<Runnable> shutdownNow() {
            return this.delegate.shutdownNow();
        }

        public void execute(Runnable command) {
            this.delegate.execute(command);
        }
    }

    private static class SameThreadExecutorService extends AbstractListeningExecutorService {
        private final Lock lock;
        private int runningTasks;
        private boolean shutdown;
        private final Condition termination;

        private SameThreadExecutorService() {
            this.lock = new ReentrantLock();
            this.termination = this.lock.newCondition();
            this.runningTasks = 0;
            this.shutdown = false;
        }

        public void execute(Runnable command) {
            startTask();
            try {
                command.run();
            } finally {
                endTask();
            }
        }

        public boolean isShutdown() {
            this.lock.lock();
            try {
                boolean z = this.shutdown;
                return z;
            } finally {
                this.lock.unlock();
            }
        }

        public void shutdown() {
            this.lock.lock();
            try {
                this.shutdown = true;
            } finally {
                this.lock.unlock();
            }
        }

        public List<Runnable> shutdownNow() {
            shutdown();
            return Collections.emptyList();
        }

        public boolean isTerminated() {
            this.lock.lock();
            try {
                boolean z = this.shutdown && this.runningTasks == 0;
                this.lock.unlock();
                return z;
            } catch (Throwable th) {
                this.lock.unlock();
            }
        }

        public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            long nanos = unit.toNanos(timeout);
            this.lock.lock();
            while (!isTerminated()) {
                if (nanos <= 0) {
                    return false;
                }
                try {
                    nanos = this.termination.awaitNanos(nanos);
                } finally {
                    this.lock.unlock();
                }
            }
            this.lock.unlock();
            return true;
        }

        private void startTask() {
            this.lock.lock();
            try {
                if (isShutdown()) {
                    throw new RejectedExecutionException("Executor already shutdown");
                }
                this.runningTasks++;
            } finally {
                this.lock.unlock();
            }
        }

        private void endTask() {
            this.lock.lock();
            try {
                this.runningTasks--;
                if (isTerminated()) {
                    this.termination.signalAll();
                }
                this.lock.unlock();
            } catch (Throwable th) {
                this.lock.unlock();
            }
        }
    }

    private static class ScheduledListeningDecorator extends ListeningDecorator implements ListeningScheduledExecutorService {
        final ScheduledExecutorService delegate;

        private static final class NeverSuccessfulListenableFutureTask extends AbstractFuture<Void> implements Runnable {
            private final Runnable delegate;

            public NeverSuccessfulListenableFutureTask(Runnable delegate) {
                this.delegate = (Runnable) Preconditions.checkNotNull(delegate);
            }

            public void run() {
                try {
                    this.delegate.run();
                } catch (Throwable t) {
                    setException(t);
                    RuntimeException propagate = Throwables.propagate(t);
                }
            }
        }

        private static final class ListenableScheduledTask<V> extends SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V> {
            private final ScheduledFuture<?> scheduledDelegate;

            public ListenableScheduledTask(ListenableFuture<V> listenableDelegate, ScheduledFuture<?> scheduledDelegate) {
                super(listenableDelegate);
                this.scheduledDelegate = scheduledDelegate;
            }

            public boolean cancel(boolean mayInterruptIfRunning) {
                boolean cancelled = super.cancel(mayInterruptIfRunning);
                if (cancelled) {
                    this.scheduledDelegate.cancel(mayInterruptIfRunning);
                }
                return cancelled;
            }

            public long getDelay(TimeUnit unit) {
                return this.scheduledDelegate.getDelay(unit);
            }

            public int compareTo(Delayed other) {
                return this.scheduledDelegate.compareTo(other);
            }
        }

        ScheduledListeningDecorator(ScheduledExecutorService delegate) {
            super(delegate);
            this.delegate = (ScheduledExecutorService) Preconditions.checkNotNull(delegate);
        }

        public ListenableScheduledFuture<?> schedule(Runnable command, long delay, TimeUnit unit) {
            ListenableFutureTask<Void> task = ListenableFutureTask.create(command, null);
            return new ListenableScheduledTask(task, this.delegate.schedule(task, delay, unit));
        }

        public <V> ListenableScheduledFuture<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
            ListenableFutureTask<V> task = ListenableFutureTask.create(callable);
            return new ListenableScheduledTask(task, this.delegate.schedule(task, delay, unit));
        }

        public ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
            NeverSuccessfulListenableFutureTask task = new NeverSuccessfulListenableFutureTask(command);
            return new ListenableScheduledTask(task, this.delegate.scheduleAtFixedRate(task, initialDelay, period, unit));
        }

        public ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
            NeverSuccessfulListenableFutureTask task = new NeverSuccessfulListenableFutureTask(command);
            return new ListenableScheduledTask(task, this.delegate.scheduleWithFixedDelay(task, initialDelay, delay, unit));
        }
    }

    private MoreExecutors() {
    }

    @Beta
    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor executor, long terminationTimeout, TimeUnit timeUnit) {
        return new Application().getExitingExecutorService(executor, terminationTimeout, timeUnit);
    }

    @Beta
    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor executor, long terminationTimeout, TimeUnit timeUnit) {
        return new Application().getExitingScheduledExecutorService(executor, terminationTimeout, timeUnit);
    }

    @Beta
    public static void addDelayedShutdownHook(ExecutorService service, long terminationTimeout, TimeUnit timeUnit) {
        new Application().addDelayedShutdownHook(service, terminationTimeout, timeUnit);
    }

    @Beta
    public static ExecutorService getExitingExecutorService(ThreadPoolExecutor executor) {
        return new Application().getExitingExecutorService(executor);
    }

    @Beta
    public static ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor executor) {
        return new Application().getExitingScheduledExecutorService(executor);
    }

    private static void useDaemonThreadFactory(ThreadPoolExecutor executor) {
        executor.setThreadFactory(new ThreadFactoryBuilder().setDaemon(true).setThreadFactory(executor.getThreadFactory()).build());
    }

    public static ListeningExecutorService sameThreadExecutor() {
        return new SameThreadExecutorService();
    }

    public static ListeningExecutorService listeningDecorator(ExecutorService delegate) {
        if (delegate instanceof ListeningExecutorService) {
            return (ListeningExecutorService) delegate;
        }
        return delegate instanceof ScheduledExecutorService ? new ScheduledListeningDecorator((ScheduledExecutorService) delegate) : new ListeningDecorator(delegate);
    }

    public static ListeningScheduledExecutorService listeningDecorator(ScheduledExecutorService delegate) {
        return delegate instanceof ListeningScheduledExecutorService ? (ListeningScheduledExecutorService) delegate : new ScheduledListeningDecorator(delegate);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> T invokeAnyImpl(com.google.common.util.concurrent.ListeningExecutorService r23, java.util.Collection<? extends java.util.concurrent.Callable<T>> r24, boolean r25, long r26) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        /*
        com.google.common.base.Preconditions.checkNotNull(r23);
        r13 = r24.size();
        if (r13 <= 0) goto L_0x0079;
    L_0x0009:
        r19 = 1;
    L_0x000b:
        com.google.common.base.Preconditions.checkArgument(r19);
        r10 = com.google.common.collect.Lists.newArrayListWithCapacity(r13);
        r9 = com.google.common.collect.Queues.newLinkedBlockingQueue();
        r5 = 0;
        if (r25 == 0) goto L_0x007c;
    L_0x0019:
        r14 = java.lang.System.nanoTime();	 Catch:{ all -> 0x008d }
    L_0x001d:
        r12 = r24.iterator();	 Catch:{ all -> 0x008d }
        r19 = r12.next();	 Catch:{ all -> 0x008d }
        r19 = (java.util.concurrent.Callable) r19;	 Catch:{ all -> 0x008d }
        r0 = r23;
        r1 = r19;
        r19 = submitAndAddQueueListener(r0, r1, r9);	 Catch:{ all -> 0x008d }
        r0 = r19;
        r10.add(r0);	 Catch:{ all -> 0x008d }
        r13 = r13 + -1;
        r4 = 1;
        r6 = r5;
    L_0x0038:
        r8 = r9.poll();	 Catch:{ all -> 0x00bc }
        r8 = (java.util.concurrent.Future) r8;	 Catch:{ all -> 0x00bc }
        if (r8 != 0) goto L_0x0059;
    L_0x0040:
        if (r13 <= 0) goto L_0x007f;
    L_0x0042:
        r13 = r13 + -1;
        r19 = r12.next();	 Catch:{ all -> 0x00bc }
        r19 = (java.util.concurrent.Callable) r19;	 Catch:{ all -> 0x00bc }
        r0 = r23;
        r1 = r19;
        r19 = submitAndAddQueueListener(r0, r1, r9);	 Catch:{ all -> 0x00bc }
        r0 = r19;
        r10.add(r0);	 Catch:{ all -> 0x00bc }
        r4 = r4 + 1;
    L_0x0059:
        if (r8 == 0) goto L_0x00e3;
    L_0x005b:
        r4 = r4 + -1;
        r19 = r8.get();	 Catch:{ ExecutionException -> 0x00d1, RuntimeException -> 0x00d6 }
        r11 = r10.iterator();
    L_0x0065:
        r20 = r11.hasNext();
        if (r20 == 0) goto L_0x00e0;
    L_0x006b:
        r8 = r11.next();
        r8 = (java.util.concurrent.Future) r8;
        r20 = 1;
        r0 = r20;
        r8.cancel(r0);
        goto L_0x0065;
    L_0x0079:
        r19 = 0;
        goto L_0x000b;
    L_0x007c:
        r14 = 0;
        goto L_0x001d;
    L_0x007f:
        if (r4 != 0) goto L_0x00a6;
    L_0x0081:
        if (r6 != 0) goto L_0x00e1;
    L_0x0083:
        r5 = new java.util.concurrent.ExecutionException;	 Catch:{ all -> 0x00bc }
        r19 = 0;
        r0 = r19;
        r5.<init>(r0);	 Catch:{ all -> 0x00bc }
    L_0x008c:
        throw r5;	 Catch:{ all -> 0x008d }
    L_0x008d:
        r19 = move-exception;
    L_0x008e:
        r11 = r10.iterator();
    L_0x0092:
        r20 = r11.hasNext();
        if (r20 == 0) goto L_0x00df;
    L_0x0098:
        r8 = r11.next();
        r8 = (java.util.concurrent.Future) r8;
        r20 = 1;
        r0 = r20;
        r8.cancel(r0);
        goto L_0x0092;
    L_0x00a6:
        if (r25 == 0) goto L_0x00ca;
    L_0x00a8:
        r19 = java.util.concurrent.TimeUnit.NANOSECONDS;	 Catch:{ all -> 0x00bc }
        r0 = r26;
        r2 = r19;
        r8 = r9.poll(r0, r2);	 Catch:{ all -> 0x00bc }
        r8 = (java.util.concurrent.Future) r8;	 Catch:{ all -> 0x00bc }
        if (r8 != 0) goto L_0x00bf;
    L_0x00b6:
        r19 = new java.util.concurrent.TimeoutException;	 Catch:{ all -> 0x00bc }
        r19.<init>();	 Catch:{ all -> 0x00bc }
        throw r19;	 Catch:{ all -> 0x00bc }
    L_0x00bc:
        r19 = move-exception;
        r5 = r6;
        goto L_0x008e;
    L_0x00bf:
        r16 = java.lang.System.nanoTime();	 Catch:{ all -> 0x00bc }
        r20 = r16 - r14;
        r26 = r26 - r20;
        r14 = r16;
        goto L_0x0059;
    L_0x00ca:
        r8 = r9.take();	 Catch:{ all -> 0x00bc }
        r8 = (java.util.concurrent.Future) r8;	 Catch:{ all -> 0x00bc }
        goto L_0x0059;
    L_0x00d1:
        r7 = move-exception;
        r5 = r7;
    L_0x00d3:
        r6 = r5;
        goto L_0x0038;
    L_0x00d6:
        r18 = move-exception;
        r5 = new java.util.concurrent.ExecutionException;	 Catch:{ all -> 0x00bc }
        r0 = r18;
        r5.<init>(r0);	 Catch:{ all -> 0x00bc }
        goto L_0x00d3;
    L_0x00df:
        throw r19;
    L_0x00e0:
        return r19;
    L_0x00e1:
        r5 = r6;
        goto L_0x008c;
    L_0x00e3:
        r5 = r6;
        goto L_0x00d3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.MoreExecutors.invokeAnyImpl(com.google.common.util.concurrent.ListeningExecutorService, java.util.Collection, boolean, long):T");
    }

    private static <T> ListenableFuture<T> submitAndAddQueueListener(ListeningExecutorService executorService, Callable<T> task, final BlockingQueue<Future<T>> queue) {
        final ListenableFuture<T> future = executorService.submit((Callable) task);
        future.addListener(new Runnable() {
            public void run() {
                queue.add(future);
            }
        }, sameThreadExecutor());
        return future;
    }

    @Beta
    public static ThreadFactory platformThreadFactory() {
        if (!isAppEngine()) {
            return Executors.defaultThreadFactory();
        }
        try {
            return (ThreadFactory) Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new Class[0]).invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e3);
        } catch (InvocationTargetException e4) {
            throw Throwables.propagate(e4.getCause());
        }
    }

    private static boolean isAppEngine() {
        if (System.getProperty("com.google.appengine.runtime.environment") == null) {
            return false;
        }
        try {
            if (Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke(null, new Object[0]) != null) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        } catch (InvocationTargetException e2) {
            return false;
        } catch (IllegalAccessException e3) {
            return false;
        } catch (NoSuchMethodException e4) {
            return false;
        }
    }

    static Thread newThread(String name, Runnable runnable) {
        Preconditions.checkNotNull(name);
        Preconditions.checkNotNull(runnable);
        Thread result = platformThreadFactory().newThread(runnable);
        try {
            result.setName(name);
        } catch (SecurityException e) {
        }
        return result;
    }

    static Executor renamingDecorator(final Executor executor, final Supplier<String> nameSupplier) {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(nameSupplier);
        return isAppEngine() ? executor : new Executor() {
            public void execute(Runnable command) {
                executor.execute(Callables.threadRenaming(command, nameSupplier));
            }
        };
    }

    static ExecutorService renamingDecorator(ExecutorService service, final Supplier<String> nameSupplier) {
        Preconditions.checkNotNull(service);
        Preconditions.checkNotNull(nameSupplier);
        return isAppEngine() ? service : new WrappingExecutorService(service) {
            protected <T> Callable<T> wrapTask(Callable<T> callable) {
                return Callables.threadRenaming((Callable) callable, nameSupplier);
            }

            protected Runnable wrapTask(Runnable command) {
                return Callables.threadRenaming(command, nameSupplier);
            }
        };
    }

    static ScheduledExecutorService renamingDecorator(ScheduledExecutorService service, final Supplier<String> nameSupplier) {
        Preconditions.checkNotNull(service);
        Preconditions.checkNotNull(nameSupplier);
        return isAppEngine() ? service : new WrappingScheduledExecutorService(service) {
            protected <T> Callable<T> wrapTask(Callable<T> callable) {
                return Callables.threadRenaming((Callable) callable, nameSupplier);
            }

            protected Runnable wrapTask(Runnable command) {
                return Callables.threadRenaming(command, nameSupplier);
            }
        };
    }

    @Beta
    public static boolean shutdownAndAwaitTermination(ExecutorService service, long timeout, TimeUnit unit) {
        Preconditions.checkNotNull(unit);
        service.shutdown();
        try {
            long halfTimeoutNanos = TimeUnit.NANOSECONDS.convert(timeout, unit) / 2;
            if (!service.awaitTermination(halfTimeoutNanos, TimeUnit.NANOSECONDS)) {
                service.shutdownNow();
                service.awaitTermination(halfTimeoutNanos, TimeUnit.NANOSECONDS);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            service.shutdownNow();
        }
        return service.isTerminated();
    }
}
