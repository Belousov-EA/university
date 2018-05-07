package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;

public final class zzebb {
    private final List<List<String>> zzmnb;
    private final List<String> zzmnc;

    public zzebb(List<List<String>> list, List<String> list2) {
        if (list.size() != list2.size() - 1) {
            throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
        }
        this.zzmnb = list;
        this.zzmnc = list2;
    }

    public final List<List<String>> zzbtz() {
        return Collections.unmodifiableList(this.zzmnb);
    }

    public final List<String> zzbua() {
        return Collections.unmodifiableList(this.zzmnc);
    }
}
