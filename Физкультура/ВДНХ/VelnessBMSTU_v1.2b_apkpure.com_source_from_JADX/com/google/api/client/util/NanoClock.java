package com.google.api.client.util;

public interface NanoClock {
    public static final NanoClock SYSTEM = new C05741();

    static class C05741 implements NanoClock {
        C05741() {
        }

        public long nanoTime() {
            return System.nanoTime();
        }
    }

    long nanoTime();
}
