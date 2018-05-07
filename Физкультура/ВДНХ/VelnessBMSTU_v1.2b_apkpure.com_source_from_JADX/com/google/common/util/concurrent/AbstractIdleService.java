package com.google.common.util.concurrent;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.common.annotations.Beta;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.Service.Listener;
import com.google.common.util.concurrent.Service.State;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Beta
public abstract class AbstractIdleService implements Service {
    private final Service delegate = new C09882();
    private final Supplier<String> threadNameSupplier = new C07631();

    class C03673 implements Executor {
        C03673() {
        }

        public void execute(Runnable command) {
            MoreExecutors.newThread((String) AbstractIdleService.this.threadNameSupplier.get(), command).start();
        }
    }

    class C07631 implements Supplier<String> {
        C07631() {
        }

        public String get() {
            return AbstractIdleService.this.serviceName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + AbstractIdleService.this.state();
        }
    }

    class C09882 extends AbstractService {

        class C03651 implements Runnable {
            C03651() {
            }

            public void run() {
                try {
                    AbstractIdleService.this.startUp();
                    C09882.this.notifyStarted();
                } catch (Throwable t) {
                    C09882.this.notifyFailed(t);
                    RuntimeException propagate = Throwables.propagate(t);
                }
            }
        }

        class C03662 implements Runnable {
            C03662() {
            }

            public void run() {
                try {
                    AbstractIdleService.this.shutDown();
                    C09882.this.notifyStopped();
                } catch (Throwable t) {
                    C09882.this.notifyFailed(t);
                    RuntimeException propagate = Throwables.propagate(t);
                }
            }
        }

        C09882() {
        }

        protected final void doStart() {
            MoreExecutors.renamingDecorator(AbstractIdleService.this.executor(), AbstractIdleService.this.threadNameSupplier).execute(new C03651());
        }

        protected final void doStop() {
            MoreExecutors.renamingDecorator(AbstractIdleService.this.executor(), AbstractIdleService.this.threadNameSupplier).execute(new C03662());
        }
    }

    protected abstract void shutDown() throws Exception;

    protected abstract void startUp() throws Exception;

    protected AbstractIdleService() {
    }

    protected Executor executor() {
        return new C03673();
    }

    public String toString() {
        return serviceName() + " [" + state() + "]";
    }

    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    public final State state() {
        return this.delegate.state();
    }

    public final void addListener(Listener listener, Executor executor) {
        this.delegate.addListener(listener, executor);
    }

    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    public final void awaitRunning(long timeout, TimeUnit unit) throws TimeoutException {
        this.delegate.awaitRunning(timeout, unit);
    }

    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    public final void awaitTerminated(long timeout, TimeUnit unit) throws TimeoutException {
        this.delegate.awaitTerminated(timeout, unit);
    }

    protected String serviceName() {
        return getClass().getSimpleName();
    }
}
