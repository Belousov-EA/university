package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneAuthCredential;

final class zzdwn<ResultT, CallbackT> extends zzdwa<zzdxk, ResultT> implements zzdxw<ResultT> {
    private TaskCompletionSource<ResultT> zzedx;
    private final String zzmes;
    private zzdxx<ResultT, CallbackT> zzmet;

    public zzdwn(zzdxx<ResultT, CallbackT> com_google_android_gms_internal_zzdxx_ResultT__CallbackT, String str) {
        this.zzmet = com_google_android_gms_internal_zzdxx_ResultT__CallbackT;
        this.zzmes = str;
    }

    protected final /* synthetic */ void zza(zzb com_google_android_gms_common_api_Api_zzb, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzdxk com_google_android_gms_internal_zzdxk = (zzdxk) com_google_android_gms_common_api_Api_zzb;
        this.zzedx = taskCompletionSource;
        zzdxx com_google_android_gms_internal_zzdxx = this.zzmet;
        com_google_android_gms_internal_zzdxx.zzmfg = com_google_android_gms_internal_zzdxk.zzbrm();
        com_google_android_gms_internal_zzdxx.dispatch();
    }

    public final void zza(ResultT resultT, Status status) {
        zzbq.checkNotNull(this.zzedx, "doExecute must be called before onComplete");
        if (status == null) {
            this.zzedx.setResult(resultT);
        } else if (this.zzmet.zzmft != null) {
            this.zzedx.setException(zzdxm.zzb(status, (PhoneAuthCredential) this.zzmet.zzmft.clone()));
            this.zzmet.zzmft = null;
        } else {
            this.zzedx.setException(zzdxm.zzao(status));
        }
    }

    final String zzbrk() {
        return this.zzmes;
    }
}
