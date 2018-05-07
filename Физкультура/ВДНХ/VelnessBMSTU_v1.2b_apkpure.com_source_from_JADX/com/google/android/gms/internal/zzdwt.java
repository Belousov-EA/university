package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.firebase.auth.internal.zza;

final class zzdwt extends zzdxx<Void, zza> {
    public zzdwt() {
        super(2);
    }

    public final void dispatch() throws RemoteException {
        this.zzmfg.zze(this.zzmff.zzbrg(), this.zzmfe);
    }

    public final void zzbrl() {
        ((zza) this.zzmfh).zza(this.zzmfo, zzdwc.zza(this.zzmcx, this.zzmfp, this.zzmff.isAnonymous()));
        zzbd(null);
    }
}
