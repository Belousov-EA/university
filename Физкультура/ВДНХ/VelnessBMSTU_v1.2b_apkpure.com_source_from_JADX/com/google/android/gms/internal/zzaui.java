package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.account.WorkAccountApi.AddAccountResult;
import com.google.android.gms.auth.account.zzc;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzm;

final class zzaui extends zzm<AddAccountResult, zzauq> {
    private /* synthetic */ String zzecf;

    zzaui(zzaug com_google_android_gms_internal_zzaug, Api api, GoogleApiClient googleApiClient, String str) {
        this.zzecf = str;
        super(api, googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((AddAccountResult) obj);
    }

    protected final /* synthetic */ void zza(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        ((zzc) ((zzauq) com_google_android_gms_common_api_Api_zzb).zzakn()).zza(new zzauj(this), this.zzecf);
    }

    protected final /* synthetic */ Result zzb(Status status) {
        return new zzaun(status, null);
    }
}
