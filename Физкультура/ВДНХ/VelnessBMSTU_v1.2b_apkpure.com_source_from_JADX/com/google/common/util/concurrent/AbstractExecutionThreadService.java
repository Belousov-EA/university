package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Supplier;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.Service.Listener;
import com.google.common.util.concurrent.Service.State;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Logger;

@Beta
public abstract class AbstractExecutionThreadService implements Service {
    private static final Logger logger = Logger.getLogger(AbstractExecutionThreadService.class.getName());
    private final Service delegate = new C09871();

    class C03642 implements Executor {
        C03642() {
        }

        public void execute(Runnable command) {
            MoreExecutors.newThread(AbstractExecutionThreadService.this.serviceName(), command).start();
        }
    }

    class C09871 extends AbstractService {

        class C03632 implements Runnable {
            C03632() {
            }

            public void run() {
                try {
                    AbstractExecutionThreadService.this.startUp();
                    C09871.this.notifyStarted();
                    if (C09871.this.isRunning()) {
                        AbstractExecutionThreadService.this.run();
                    }
                    AbstractExecutionThreadService.this.shutDown();
                    C09871.this.notifyStopped();
                } catch (Throwable t) {
                    C09871.this.notifyFailed(t);
                    RuntimeException propagate = Throwables.propagate(t);
                }
            }
        }

        class C07621 implements Supplier<String> {
            C07621() {
            }

            public String get() {
                return AbstractExecutionThreadService.this.serviceName();
            }
        }

        C09871() {
        }

        protected final void doStart() {
            MoreExecutors.renamingDecorator(AbstractExecutionThreadService.this.executor(), new C07621()).execute(new C03632());
        }

        protected void doStop() {
            AbstractExecutionThreadService.this.triggerShutdown();
        }
    }

    protected abstract void run() throws Exception;

    protected AbstractExecutionThreadService() {
    }

    protected void startUp() throws Exception {
    }

    protected void shutDown() throws Exception {
    }

    protected void triggerShutdown() {
    }

    protected Executor executor() {
        return new C03642();
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
