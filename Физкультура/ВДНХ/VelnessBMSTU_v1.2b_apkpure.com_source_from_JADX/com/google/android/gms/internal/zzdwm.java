package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zze;

final class zzdwm extends zzdxx<AuthResult, zza> implements zzdxz {
    @NonNull
    private final PhoneAuthCredential zzmer;

    public zzdwm(@NonNull PhoneAuthCredential phoneAuthCredential) {
        super(2);
        this.zzmer = (PhoneAuthCredential) zzbq.checkNotNull(phoneAuthCredential, "credential cannot be null");
    }

    public final void dispatch() throws RemoteException {
        this.zzmfg.zza(this.zzmff.zzbrg(), this.zzmer, this.zzmfe);
    }

    public final void zza(@NonNull Status status, @NonNull PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        zzbq.zza(this.zzmfd == 2, "Unexpected response type " + this.zzmfd);
        this.zzmfu = false;
        this.zzmft = phoneAuthCredential;
        if (this.zzmfi != null) {
            this.zzmfi.onError(status);
        }
        zzap(status);
    }

    public final void zzbrl() {
        FirebaseUser zzb = zzdwc.zza(this.zzmcx, this.zzmfp);
        ((zza) this.zzmfh).zza(this.zzmfo, zzb);
        zzbd(new zze(zzb));
    }
}
