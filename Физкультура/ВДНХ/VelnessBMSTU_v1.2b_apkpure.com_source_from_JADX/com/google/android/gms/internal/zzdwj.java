package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.zza;

final class zzdwj extends zzdxx<GetTokenResult, zza> {
    @NonNull
    private final String zzmeo;

    public zzdwj(@NonNull String str) {
        super(1);
        this.zzmeo = zzbq.zzh(str, "refresh token cannot be null");
    }

    public final void dispatch() throws RemoteException {
        this.zzmfg.zza(this.zzmeo, this.zzmfe);
    }

    public final void zzbrl() {
        this.zzmfo.zzoz(this.zzmeo);
        ((zza) this.zzmfh).zza(this.zzmfo, this.zzmff);
        zzbd(new GetTokenResult(this.zzmfo.getAccessToken()));
    }
}
