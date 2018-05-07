package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.auth.internal.zza;

final class zzdxe extends zzdxx<Void, zza> {
    @NonNull
    private final String zzegs;

    public zzdxe(String str) {
        super(2);
        this.zzegs = zzbq.zzh(str, "email cannot be null or empty");
    }

    public final void dispatch() throws RemoteException {
        this.zzmfg.zza(this.zzmff.zzbrg(), this.zzegs, this.zzmfe);
    }

    public final void zzbrl() {
        ((zza) this.zzmfh).zza(this.zzmfo, zzdwc.zza(this.zzmcx, this.zzmfp));
        zzbd(null);
    }
}
