package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zze;

final class zzdwx extends zzdxx<AuthResult, zza> {
    public zzdwx() {
        super(2);
    }

    public final void dispatch() throws RemoteException {
        this.zzmfg.zza(this.zzmfe);
    }

    public final void zzbrl() {
        FirebaseUser zzb = zzdwc.zza(this.zzmcx, this.zzmfp, true);
        ((zza) this.zzmfh).zza(this.zzmfo, zzb);
        zzbd(new zze(zzb));
    }
}
