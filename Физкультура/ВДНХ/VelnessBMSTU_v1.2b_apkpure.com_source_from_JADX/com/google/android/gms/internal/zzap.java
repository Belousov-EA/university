package com.google.android.gms.internal;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class zzap {
    private final int zzcd;
    private final List<zzl> zzce;
    private final int zzcf;
    private final InputStream zzcg;

    public zzap(int i, List<zzl> list) {
        this(i, list, -1, null);
    }

    public zzap(int i, List<zzl> list, int i2, InputStream inputStream) {
        this.zzcd = i;
        this.zzce = list;
        this.zzcf = i2;
        this.zzcg = inputStream;
    }

    public final InputStream getContent() {
        return this.zzcg;
    }

    public final int getContentLength() {
        return this.zzcf;
    }

    public final int getStatusCode() {
        return this.zzcd;
    }

    public final List<zzl> zzp() {
        return Collections.unmodifiableList(this.zzce);
    }
}
