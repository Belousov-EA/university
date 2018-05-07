package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zze<TResult> extends zza {
    private final TaskCompletionSource<TResult> zzedx;
    private final zzdd<zzb, TResult> zzfns;
    private final zzcz zzfnt;

    public zze(int i, zzdd<zzb, TResult> com_google_android_gms_common_api_internal_zzdd_com_google_android_gms_common_api_Api_zzb__TResult, TaskCompletionSource<TResult> taskCompletionSource, zzcz com_google_android_gms_common_api_internal_zzcz) {
        super(i);
        this.zzedx = taskCompletionSource;
        this.zzfns = com_google_android_gms_common_api_internal_zzdd_com_google_android_gms_common_api_Api_zzb__TResult;
        this.zzfnt = com_google_android_gms_common_api_internal_zzcz;
    }

    public final void zza(@NonNull zzae com_google_android_gms_common_api_internal_zzae, boolean z) {
        com_google_android_gms_common_api_internal_zzae.zza(this.zzedx, z);
    }

    public final void zza(zzbo<?> com_google_android_gms_common_api_internal_zzbo_) throws DeadObjectException {
        try {
            this.zzfns.zza(com_google_android_gms_common_api_internal_zzbo_.zzahp(), this.zzedx);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            zzs(zza.zza(e2));
        }
    }

    public final void zzs(@NonNull Status status) {
        this.zzedx.trySetException(this.zzfnt.zzt(status));
    }
}
