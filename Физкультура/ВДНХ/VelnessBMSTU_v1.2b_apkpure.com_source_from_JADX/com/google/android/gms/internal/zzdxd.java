package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zze;

final class zzdxd extends zzdxx<AuthResult, zza> {
    @NonNull
    private String zzmew;

    public zzdxd(@NonNull String str) {
        super(2);
        this.zzmew = zzbq.zzh(str, "provider cannot be null or empty");
    }

    public final void dispatch() throws RemoteException {
        this.zzmfg.zze(this.zzmew, this.zzmff.zzbrg(), this.zzmfe);
    }

    public final void zzbrl() {
        FirebaseUser zzb = zzdwc.zza(this.zzmcx, this.zzmfp);
        ((zza) this.zzmfh).zza(this.zzmfo, zzb);
        zzbd(new zze(zzb));
    }
}
