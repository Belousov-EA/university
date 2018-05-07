package com.google.api.client.util;

public interface Sleeper {
    public static final Sleeper DEFAULT = new C05751();

    static class C05751 implements Sleeper {
        C05751() {
        }

        public void sleep(long millis) throws InterruptedException {
            Thread.sleep(millis);
        }
    }

    void sleep(long j) throws InterruptedException;
}
