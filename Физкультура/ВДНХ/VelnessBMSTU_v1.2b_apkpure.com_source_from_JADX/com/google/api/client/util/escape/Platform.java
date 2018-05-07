package com.google.api.client.util.escape;

final class Platform {
    private static final ThreadLocal<char[]> DEST_TL = new C02791();

    static class C02791 extends ThreadLocal<char[]> {
        C02791() {
        }

        protected char[] initialValue() {
            return new char[1024];
        }
    }

    private Platform() {
    }

    static char[] charBufferFromThreadLocal() {
        return (char[]) DEST_TL.get();
    }
}
