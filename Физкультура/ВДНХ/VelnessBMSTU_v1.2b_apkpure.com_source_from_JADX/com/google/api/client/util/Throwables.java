package com.google.api.client.util;

public final class Throwables {
    public static RuntimeException propagate(Throwable throwable) {
        return com.google.api.client.repackaged.com.google.common.base.Throwables.propagate(throwable);
    }

    public static void propagateIfPossible(Throwable throwable) {
        if (throwable == null) {
            return;
        }
        if (throwable instanceof RuntimeException) {
            throw ((RuntimeException) throwable);
        } else if (throwable instanceof Error) {
            throw ((Error) throwable);
        }
    }

    public static <X extends Throwable> void propagateIfPossible(Throwable throwable, Class<X> declaredType) throws Throwable {
        com.google.api.client.repackaged.com.google.common.base.Throwables.propagateIfPossible(throwable, declaredType);
    }

    private Throwables() {
    }
}
