package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.auth.internal.zza;

final class zzdwf extends zzdxx<Void, zza> {
    @NonNull
    private final String zzhqe;
    @NonNull
    private final String zzmen;

    public zzdwf(@NonNull String str, @NonNull String str2) {
        super(4);
        this.zzhqe = zzbq.zzh(str, "code cannot be null or empty");
        this.zzmen = zzbq.zzh(str2, "new password cannot be null or empty");
    }

    public final void dispatch() throws RemoteException {
        this.zzmfg.zzf(this.zzhqe, this.zzmen, this.zzmfe);
    }

    public final void zzbrl() {
        zzbd(null);
    }
}
