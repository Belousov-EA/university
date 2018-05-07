package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.data.DataHolder;

public abstract class zzai<L> implements zzcl<L> {
    private final DataHolder zzfqt;

    protected zzai(DataHolder dataHolder) {
        this.zzfqt = dataHolder;
    }

    protected abstract void zza(L l, DataHolder dataHolder);

    public final void zzahz() {
        if (this.zzfqt != null) {
            this.zzfqt.close();
        }
    }

    public final void zzu(L l) {
        zza(l, this.zzfqt);
    }
}
