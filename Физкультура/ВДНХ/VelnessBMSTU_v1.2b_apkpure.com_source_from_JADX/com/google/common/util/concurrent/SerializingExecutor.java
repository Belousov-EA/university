package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

final class SerializingExecutor implements Executor {
    private static final Logger log = Logger.getLogger(SerializingExecutor.class.getName());
    private final Executor executor;
    private final Object internalLock = new C03881();
    @GuardedBy("internalLock")
    private boolean isThreadScheduled = false;
    private final TaskRunner taskRunner = new TaskRunner();
    @GuardedBy("internalLock")
    private final Queue<Runnable> waitQueue = new LinkedList();

    class C03881 {
        C03881() {
        }

        public String toString() {
            return "SerializingExecutor lock: " + super.toString();
        }
    }

    private class TaskRunner implements Runnable {
        private TaskRunner() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r7 = this;
            r2 = 1;
        L_0x0001:
            r3 = com.google.common.util.concurrent.SerializingExecutor.this;	 Catch:{ all -> 0x005b }
            r3 = r3.isThreadScheduled;	 Catch:{ all -> 0x005b }
            com.google.common.base.Preconditions.checkState(r3);	 Catch:{ all -> 0x005b }
            r3 = com.google.common.util.concurrent.SerializingExecutor.this;	 Catch:{ all -> 0x005b }
            r4 = r3.internalLock;	 Catch:{ all -> 0x005b }
            monitor-enter(r4);	 Catch:{ all -> 0x005b }
            r3 = com.google.common.util.concurrent.SerializingExecutor.this;	 Catch:{ all -> 0x006d }
            r3 = r3.waitQueue;	 Catch:{ all -> 0x006d }
            r1 = r3.poll();	 Catch:{ all -> 0x006d }
            r1 = (java.lang.Runnable) r1;	 Catch:{ all -> 0x006d }
            if (r1 != 0) goto L_0x0038;
        L_0x001f:
            r3 = com.google.common.util.concurrent.SerializingExecutor.this;	 Catch:{ all -> 0x006d }
            r5 = 0;
            r3.isThreadScheduled = r5;	 Catch:{ all -> 0x006d }
            r2 = 0;
            monitor-exit(r4);	 Catch:{ all -> 0x006d }
            if (r2 == 0) goto L_0x0037;
        L_0x0029:
            r3 = com.google.common.util.concurrent.SerializingExecutor.this;
            r4 = r3.internalLock;
            monitor-enter(r4);
            r3 = com.google.common.util.concurrent.SerializingExecutor.this;	 Catch:{ all -> 0x0070 }
            r5 = 0;
            r3.isThreadScheduled = r5;	 Catch:{ all -> 0x0070 }
            monitor-exit(r4);	 Catch:{ all -> 0x0070 }
        L_0x0037:
            return;
        L_0x0038:
            monitor-exit(r4);	 Catch:{ all -> 0x006d }
            r1.run();	 Catch:{ RuntimeException -> 0x003d }
            goto L_0x0001;
        L_0x003d:
            r0 = move-exception;
            r3 = com.google.common.util.concurrent.SerializingExecutor.log;	 Catch:{ all -> 0x005b }
            r4 = java.util.logging.Level.SEVERE;	 Catch:{ all -> 0x005b }
            r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005b }
            r5.<init>();	 Catch:{ all -> 0x005b }
            r6 = "Exception while executing runnable ";
            r5 = r5.append(r6);	 Catch:{ all -> 0x005b }
            r5 = r5.append(r1);	 Catch:{ all -> 0x005b }
            r5 = r5.toString();	 Catch:{ all -> 0x005b }
            r3.log(r4, r5, r0);	 Catch:{ all -> 0x005b }
            goto L_0x0001;
        L_0x005b:
            r3 = move-exception;
            if (r2 == 0) goto L_0x006c;
        L_0x005e:
            r4 = com.google.common.util.concurrent.SerializingExecutor.this;
            r4 = r4.internalLock;
            monitor-enter(r4);
            r5 = com.google.common.util.concurrent.SerializingExecutor.this;	 Catch:{ all -> 0x0073 }
            r6 = 0;
            r5.isThreadScheduled = r6;	 Catch:{ all -> 0x0073 }
            monitor-exit(r4);	 Catch:{ all -> 0x0073 }
        L_0x006c:
            throw r3;
        L_0x006d:
            r3 = move-exception;
            monitor-exit(r4);	 Catch:{ all -> 0x006d }
            throw r3;	 Catch:{ all -> 0x005b }
        L_0x0070:
            r3 = move-exception;
            monitor-exit(r4);	 Catch:{ all -> 0x0070 }
            throw r3;
        L_0x0073:
            r3 = move-exception;
            monitor-exit(r4);	 Catch:{ all -> 0x0073 }
            throw r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.SerializingExecutor.TaskRunner.run():void");
        }
    }

    public SerializingExecutor(Executor executor) {
        Preconditions.checkNotNull(executor, "'executor' must not be null.");
        this.executor = executor;
    }

    public void execute(Runnable r) {
        Preconditions.checkNotNull(r, "'r' must not be null.");
        boolean scheduleTaskRunner = false;
        synchronized (this.internalLock) {
            this.waitQueue.add(r);
            if (!this.isThreadScheduled) {
                this.isThreadScheduled = true;
                scheduleTaskRunner = true;
            }
        }
        if (scheduleTaskRunner) {
            try {
                this.executor.execute(this.taskRunner);
                if (false) {
                    synchronized (this.internalLock) {
                        this.isThreadScheduled = false;
                    }
                }
            } catch (Throwable th) {
                if (true) {
                    synchronized (this.internalLock) {
                        this.isThreadScheduled = false;
                    }
                }
            }
        }
    }
}
