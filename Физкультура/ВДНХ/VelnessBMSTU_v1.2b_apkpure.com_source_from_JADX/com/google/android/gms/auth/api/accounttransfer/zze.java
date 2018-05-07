package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.internal.zzavd;
import com.google.android.gms.internal.zzavh;

final class zze extends zzb<byte[]> {
    private /* synthetic */ zzavh zzedq;

    zze(AccountTransferClient accountTransferClient, zzavh com_google_android_gms_internal_zzavh) {
        this.zzedq = com_google_android_gms_internal_zzavh;
        super();
    }

    protected final void zza(zzavd com_google_android_gms_internal_zzavd) throws RemoteException {
        com_google_android_gms_internal_zzavd.zza(new zzf(this, this), this.zzedq);
    }
}
