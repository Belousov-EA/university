package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@Beta
public final class Runnables {
    private static final Runnable EMPTY_RUNNABLE = new C03871();

    static class C03871 implements Runnable {
        C03871() {
        }

        public void run() {
        }
    }

    public static Runnable doNothing() {
        return EMPTY_RUNNABLE;
    }

    private Runnables() {
    }
}
