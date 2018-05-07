package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.auth.internal.zza;

final class zzdwd extends zzdxx<Void, zza> {
    @NonNull
    private final String zzhqe;

    public zzdwd(@NonNull String str) {
        super(7);
        this.zzhqe = zzbq.zzh(str, "code cannot be null or empty");
    }

    public final void dispatch() throws RemoteException {
        this.zzmfg.zzh(this.zzhqe, this.zzmfe);
    }

    public final void zzbrl() {
        zzbd(null);
    }
}
