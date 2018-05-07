package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;

final class zzdxj extends zzdxx<Void, OnVerificationStateChangedCallbacks> {
    private final zzdyu zzmey;

    public zzdxj(zzdyu com_google_android_gms_internal_zzdyu) {
        super(8);
        this.zzmey = (zzdyu) zzbq.checkNotNull(com_google_android_gms_internal_zzdyu);
    }

    public final void dispatch() throws RemoteException {
        this.zzmfg.zza(this.zzmey, this.zzmfe);
    }

    public final void zzbrl() {
    }
}
