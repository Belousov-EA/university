package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzb;
import com.google.firebase.auth.internal.zze;

final class zzdwl extends zzdxx<AuthResult, zza> {
    @NonNull
    private final zzdyy zzmeq;

    public zzdwl(@NonNull AuthCredential authCredential) {
        super(2);
        zzbq.checkNotNull(authCredential, "credential cannot be null");
        this.zzmeq = zzb.zza(authCredential);
    }

    public final void dispatch() throws RemoteException {
        this.zzmfg.zza(this.zzmff.zzbrg(), this.zzmeq, this.zzmfe);
    }

    public final void zzbrl() {
        FirebaseUser zzb = zzdwc.zza(this.zzmcx, this.zzmfp);
        ((zza) this.zzmfh).zza(this.zzmfo, zzb);
        zzbd(new zze(zzb));
    }
}
