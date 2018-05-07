package com.google.api.client.util;

import java.io.IOException;

public interface BackOff {
    public static final long STOP = -1;
    public static final BackOff STOP_BACKOFF = new C05722();
    public static final BackOff ZERO_BACKOFF = new C05711();

    static class C05711 implements BackOff {
        C05711() {
        }

        public void reset() throws IOException {
        }

        public long nextBackOffMillis() throws IOException {
            return 0;
        }
    }

    static class C05722 implements BackOff {
        C05722() {
        }

        public void reset() throws IOException {
        }

        public long nextBackOffMillis() throws IOException {
            return -1;
        }
    }

    long nextBackOffMillis() throws IOException;

    void reset() throws IOException;
}
