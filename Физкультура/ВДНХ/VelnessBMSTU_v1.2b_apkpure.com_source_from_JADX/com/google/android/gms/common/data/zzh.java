package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public final class zzh<T> extends zzb<T> {
    private T zzfwq;

    public zzh(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    public final T next() {
        if (hasNext()) {
            this.zzfvv++;
            if (this.zzfvv == 0) {
                this.zzfwq = this.zzfvu.get(0);
                if (!(this.zzfwq instanceof zzc)) {
                    String valueOf = String.valueOf(this.zzfwq.getClass());
                    throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 44).append("DataBuffer reference of type ").append(valueOf).append(" is not movable").toString());
                }
            }
            ((zzc) this.zzfwq).zzbx(this.zzfvv);
            return this.zzfwq;
        }
        throw new NoSuchElementException("Cannot advance the iterator beyond " + this.zzfvv);
    }
}
