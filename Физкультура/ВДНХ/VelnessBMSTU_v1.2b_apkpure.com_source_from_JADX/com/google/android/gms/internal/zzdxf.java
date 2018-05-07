package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.auth.internal.zza;

final class zzdxf extends zzdxx<Void, zza> {
    @NonNull
    private final String zzeey;

    public zzdxf(@NonNull String str) {
        super(2);
        this.zzeey = zzbq.zzh(str, "password cannot be null or empty");
    }

    public final void dispatch() throws RemoteException {
        this.zzmfg.zzb(this.zzmff.zzbrg(), this.zzeey, this.zzmfe);
    }

    public final void zzbrl() {
        ((zza) this.zzmfh).zza(this.zzmfo, zzdwc.zza(this.zzmcx, this.zzmfp));
        zzbd(null);
    }
}
