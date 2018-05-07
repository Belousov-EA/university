package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.auth.ProviderQueryResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzj;

final class zzdwi extends zzdxx<ProviderQueryResult, zza> {
    @NonNull
    private final String zzegs;

    public zzdwi(@NonNull String str) {
        super(3);
        this.zzegs = zzbq.zzh(str, "email cannot be null or empty");
    }

    public final void dispatch() throws RemoteException {
        this.zzmfg.zzc(this.zzegs, this.zzmfe);
    }

    public final void zzbrl() {
        zzbd(new zzj(this.zzmfq));
    }
}
