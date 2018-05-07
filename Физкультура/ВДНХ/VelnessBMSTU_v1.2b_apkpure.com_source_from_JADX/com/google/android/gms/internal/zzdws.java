package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzn;

final class zzdws extends zzdxx<Void, zza> {
    @NonNull
    private final PhoneAuthCredential zzmer;

    public zzdws(@NonNull PhoneAuthCredential phoneAuthCredential) {
        super(2);
        zzbq.checkNotNull(phoneAuthCredential, "credential cannot be null");
        this.zzmer = phoneAuthCredential.zzcg(false);
    }

    public final void dispatch() throws RemoteException {
        this.zzmfg.zza(this.zzmer, this.zzmfe);
    }

    public final void zzbrl() {
        FirebaseUser zzb = zzdwc.zza(this.zzmcx, this.zzmfp);
        if (this.zzmff.getUid().equalsIgnoreCase(zzb.getUid())) {
            ((zza) this.zzmfh).zza(this.zzmfo, zzb);
            zzbd(null);
            return;
        }
        zzap(zzn.zzbsg());
    }
}
