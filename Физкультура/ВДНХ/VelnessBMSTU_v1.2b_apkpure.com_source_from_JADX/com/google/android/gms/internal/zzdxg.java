package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zza;

final class zzdxg extends zzdxx<Void, zza> {
    @NonNull
    private final PhoneAuthCredential zzmer;

    public zzdxg(PhoneAuthCredential phoneAuthCredential) {
        super(2);
        this.zzmer = (PhoneAuthCredential) zzbq.checkNotNull(phoneAuthCredential);
    }

    public final void dispatch() throws RemoteException {
        this.zzmfg.zza(this.zzmff.zzbrg(), this.zzmer, this.zzmfe);
    }

    public final void zzbrl() {
        ((zza) this.zzmfh).zza(this.zzmfo, zzdwc.zza(this.zzmcx, this.zzmfp));
        zzbd(null);
    }
}
