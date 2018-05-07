package com.google.android.gms.auth.api.accounttransfer;

import android.os.RemoteException;
import com.google.android.gms.internal.zzauz;
import com.google.android.gms.internal.zzavd;

final class zzg extends zzb<DeviceMetaData> {
    private /* synthetic */ zzauz zzeds;

    zzg(AccountTransferClient accountTransferClient, zzauz com_google_android_gms_internal_zzauz) {
        this.zzeds = com_google_android_gms_internal_zzauz;
        super();
    }

    protected final void zza(zzavd com_google_android_gms_internal_zzavd) throws RemoteException {
        com_google_android_gms_internal_zzavd.zza(new zzh(this, this), this.zzeds);
    }
}
