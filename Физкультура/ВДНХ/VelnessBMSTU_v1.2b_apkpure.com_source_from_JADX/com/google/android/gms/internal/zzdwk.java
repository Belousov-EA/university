package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zze;

final class zzdwk extends zzdxx<AuthResult, zza> {
    @NonNull
    private final EmailAuthCredential zzmep;

    public zzdwk(@NonNull EmailAuthCredential emailAuthCredential) {
        super(2);
        this.zzmep = (EmailAuthCredential) zzbq.checkNotNull(emailAuthCredential, "credential cannot be null");
    }

    public final void dispatch() throws RemoteException {
        this.zzmfg.zza(this.zzmep.getEmail(), this.zzmep.getPassword(), this.zzmff.zzbrg(), this.zzmfe);
    }

    public final void zzbrl() {
        FirebaseUser zzb = zzdwc.zza(this.zzmcx, this.zzmfp);
        ((zza) this.zzmfh).zza(this.zzmfo, zzb);
        zzbd(new zze(zzb));
    }
}
