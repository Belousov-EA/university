package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zzd extends zzb<Void> {
    private zzcq<zzb, ?> zzfnq;
    private zzdn<zzb, ?> zzfnr;

    public zzd(zzcr com_google_android_gms_common_api_internal_zzcr, TaskCompletionSource<Void> taskCompletionSource) {
        super(3, taskCompletionSource);
        this.zzfnq = com_google_android_gms_common_api_internal_zzcr.zzfnq;
        this.zzfnr = com_google_android_gms_common_api_internal_zzcr.zzfnr;
    }

    public final /* bridge */ /* synthetic */ void zza(@NonNull zzae com_google_android_gms_common_api_internal_zzae, boolean z) {
    }

    public final void zzb(zzbo<?> com_google_android_gms_common_api_internal_zzbo_) throws RemoteException {
        this.zzfnq.zzb(com_google_android_gms_common_api_internal_zzbo_.zzahp(), this.zzedx);
        if (this.zzfnq.zzajo() != null) {
            com_google_android_gms_common_api_internal_zzbo_.zzaiy().put(this.zzfnq.zzajo(), new zzcr(this.zzfnq, this.zzfnr));
        }
    }

    public final /* bridge */ /* synthetic */ void zzs(@NonNull Status status) {
        super.zzs(status);
    }
}
