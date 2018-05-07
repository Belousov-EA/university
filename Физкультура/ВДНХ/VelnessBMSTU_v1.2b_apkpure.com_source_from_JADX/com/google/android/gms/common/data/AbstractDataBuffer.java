package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {
    protected final DataHolder zzfqt;

    protected AbstractDataBuffer(DataHolder dataHolder) {
        this.zzfqt = dataHolder;
    }

    @Deprecated
    public final void close() {
        release();
    }

    public abstract T get(int i);

    public int getCount() {
        return this.zzfqt == null ? 0 : this.zzfqt.zzfwg;
    }

    @Deprecated
    public boolean isClosed() {
        return this.zzfqt == null || this.zzfqt.isClosed();
    }

    public Iterator<T> iterator() {
        return new zzb(this);
    }

    public void release() {
        if (this.zzfqt != null) {
            this.zzfqt.close();
        }
    }

    public Iterator<T> singleRefIterator() {
        return new zzh(this);
    }

    public final Bundle zzagk() {
        return this.zzfqt.zzagk();
    }
}
