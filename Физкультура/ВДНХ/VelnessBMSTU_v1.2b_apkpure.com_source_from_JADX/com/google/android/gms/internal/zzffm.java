package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzffm {
    private static volatile boolean zzpge = false;
    private static final Class<?> zzpgf = zzcxa();
    static final zzffm zzpgg = new zzffm(true);
    private final Map<Object, Object> zzpgh;

    zzffm() {
        this.zzpgh = new HashMap();
    }

    private zzffm(boolean z) {
        this.zzpgh = Collections.emptyMap();
    }

    private static Class<?> zzcxa() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static zzffm zzcxb() {
        return zzffl.zzcwz();
    }
}
