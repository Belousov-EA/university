package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzn;

final class zzcen extends zzcev {
    private final zzn<Status> zzgbw;

    public zzcen(zzn<Status> com_google_android_gms_common_api_internal_zzn_com_google_android_gms_common_api_Status) {
        this.zzgbw = com_google_android_gms_common_api_internal_zzn_com_google_android_gms_common_api_Status;
    }

    public final void zza(zzceo com_google_android_gms_internal_zzceo) {
        this.zzgbw.setResult(com_google_android_gms_internal_zzceo.getStatus());
    }
}
