package com.google.api.client.util;

public interface Clock {
    public static final Clock SYSTEM = new C05731();

    static class C05731 implements Clock {
        C05731() {
        }

        public long currentTimeMillis() {
            return System.currentTimeMillis();
        }
    }

    long currentTimeMillis();
}
