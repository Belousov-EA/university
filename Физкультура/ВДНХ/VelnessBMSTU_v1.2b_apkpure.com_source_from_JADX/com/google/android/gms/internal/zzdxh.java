package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zza;

final class zzdxh extends zzdxx<Void, zza> {
    @NonNull
    private final UserProfileChangeRequest zzmex;

    public zzdxh(UserProfileChangeRequest userProfileChangeRequest) {
        super(2);
        this.zzmex = (UserProfileChangeRequest) zzbq.checkNotNull(userProfileChangeRequest, "request cannot be null");
    }

    public final void dispatch() throws RemoteException {
        this.zzmfg.zza(this.zzmff.zzbrg(), this.zzmex, this.zzmfe);
    }

    public final void zzbrl() {
        ((zza) this.zzmfh).zza(this.zzmfo, zzdwc.zza(this.zzmcx, this.zzmfp));
        zzbd(null);
    }
}
