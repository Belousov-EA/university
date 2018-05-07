package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzauw;

final class zzk extends zzauw {
    private /* synthetic */ zzc zzedz;

    zzk(zzc com_google_android_gms_auth_api_accounttransfer_AccountTransferClient_zzc) {
        this.zzedz = com_google_android_gms_auth_api_accounttransfer_AccountTransferClient_zzc;
    }

    public final void onFailure(Status status) {
        this.zzedz.zzd(status);
    }

    public final void zzaau() {
        this.zzedz.setResult(null);
    }
}
