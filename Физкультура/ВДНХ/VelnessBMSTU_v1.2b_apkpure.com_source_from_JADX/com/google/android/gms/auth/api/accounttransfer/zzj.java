package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.internal.zzavd;
import com.google.android.gms.internal.zzavf;

final class zzj extends zzc {
    private /* synthetic */ zzavf zzedv;

    zzj(AccountTransferClient accountTransferClient, zzavf com_google_android_gms_internal_zzavf) {
        this.zzedv = com_google_android_gms_internal_zzavf;
        super();
    }

    protected final void zza(zzavd com_google_android_gms_internal_zzavd) throws RemoteException {
        com_google_android_gms_internal_zzavd.zza(this.zzedy, this.zzedv);
    }
}
