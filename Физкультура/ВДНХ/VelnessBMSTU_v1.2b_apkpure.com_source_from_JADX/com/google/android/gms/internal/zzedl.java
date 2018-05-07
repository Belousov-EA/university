package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzedl implements Iterator<zzejg> {
    private int offset = this.zzmsq.start;
    private /* synthetic */ zzedk zzmsq;

    zzedl(zzedk com_google_android_gms_internal_zzedk) {
        this.zzmsq = com_google_android_gms_internal_zzedk;
    }

    public final boolean hasNext() {
        return this.offset < this.zzmsq.end;
    }

    public final /* synthetic */ Object next() {
        if (hasNext()) {
            Object obj = this.zzmsq.zzmso[this.offset];
            this.offset++;
            return obj;
        }
        throw new NoSuchElementException("No more elements.");
    }

    public final void remove() {
        throw new UnsupportedOperationException("Can't remove component from immutable Path!");
    }
}
