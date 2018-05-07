package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.auth.api.signin.internal.zzz;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

final class zzbe implements ResultCallback<Status> {
    private /* synthetic */ GoogleApiClient zzesc;
    private /* synthetic */ zzba zzfsj;
    private /* synthetic */ zzda zzfsl;
    private /* synthetic */ boolean zzfsm;

    zzbe(zzba com_google_android_gms_common_api_internal_zzba, zzda com_google_android_gms_common_api_internal_zzda, boolean z, GoogleApiClient googleApiClient) {
        this.zzfsj = com_google_android_gms_common_api_internal_zzba;
        this.zzfsl = com_google_android_gms_common_api_internal_zzda;
        this.zzfsm = z;
        this.zzesc = googleApiClient;
    }

    public final /* synthetic */ void onResult(@NonNull Result result) {
        Status status = (Status) result;
        zzz.zzbt(this.zzfsj.mContext).zzabv();
        if (status.isSuccess() && this.zzfsj.isConnected()) {
            this.zzfsj.reconnect();
        }
        this.zzfsl.setResult(status);
        if (this.zzfsm) {
            this.zzesc.disconnect();
        }
    }
}
