package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

@Beta
public abstract class AbstractListeningExecutorService implements ListeningExecutorService {
    public ListenableFuture<?> submit(Runnable task) {
        ListenableFutureTask<Void> ftask = ListenableFutureTask.create(task, null);
        execute(ftask);
        return ftask;
    }

    public <T> ListenableFuture<T> submit(Runnable task, @Nullable T result) {
        ListenableFutureTask<T> ftask = ListenableFutureTask.create(task, result);
        execute(ftask);
        return ftask;
    }

    public <T> ListenableFuture<T> submit(Callable<T> task) {
        ListenableFutureTask<T> ftask = ListenableFutureTask.create(task);
        execute(ftask);
        return ftask;
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        try {
            return MoreExecutors.invokeAnyImpl(this, tasks, false, 0);
        } catch (TimeoutException e) {
            throw new AssertionError();
        }
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return MoreExecutors.invokeAnyImpl(this, tasks, true, unit.toNanos(timeout));
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        if (tasks == null) {
            throw new NullPointerException();
        }
        List<Future<T>> futures = new ArrayList(tasks.size());
        try {
            for (Callable<T> t : tasks) {
                ListenableFutureTask<T> f = ListenableFutureTask.create(t);
                futures.add(f);
                execute(f);
            }
            for (Future<T> f2 : futures) {
                if (!f2.isDone()) {
                    try {
                        f2.get();
                    } catch (CancellationException e) {
                    } catch (ExecutionException e2) {
                    }
                }
            }
            if (!true) {
                for (Future<T> f22 : futures) {
                    f22.cancel(true);
                }
            }
            return futures;
        } catch (Throwable th) {
            if (!false) {
                for (Future<T> f222 : futures) {
                    f222.cancel(true);
                }
            }
        }
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        if (tasks == null || unit == null) {
            throw new NullPointerException();
        }
        long nanos = unit.toNanos(timeout);
        List<Future<T>> futures = new ArrayList(tasks.size());
        try {
            long now;
            for (Callable<T> t : tasks) {
                futures.add(ListenableFutureTask.create(t));
            }
            long lastTime = System.nanoTime();
            Iterator<Future<T>> it = futures.iterator();
            while (it.hasNext()) {
                execute((Runnable) it.next());
                now = System.nanoTime();
                nanos -= now - lastTime;
                lastTime = now;
                if (nanos <= 0) {
                    if (null == null) {
                        for (Future<T> f : futures) {
                            f.cancel(true);
                        }
                    }
                    return futures;
                }
            }
            for (Future<T> f2 : futures) {
                if (!f2.isDone()) {
                    if (nanos <= 0) {
                        if (null == null) {
                            for (Future<T> f22 : futures) {
                                f22.cancel(true);
                            }
                        }
                        return futures;
                    }
                    try {
                        f22.get(nanos, TimeUnit.NANOSECONDS);
                    } catch (CancellationException e) {
                    } catch (ExecutionException e2) {
                    } catch (TimeoutException e3) {
                        if (null == null) {
                            for (Future<T> f222 : futures) {
                                f222.cancel(true);
                            }
                        }
                    }
                    now = System.nanoTime();
                    nanos -= now - lastTime;
                    lastTime = now;
                }
            }
            if (!true) {
                for (Future<T> f2222 : futures) {
                    f2222.cancel(true);
                }
            }
            return futures;
        } catch (Throwable th) {
            if (null == null) {
                for (Future<T> f22222 : futures) {
                    f22222.cancel(true);
                }
            }
        }
    }
}
