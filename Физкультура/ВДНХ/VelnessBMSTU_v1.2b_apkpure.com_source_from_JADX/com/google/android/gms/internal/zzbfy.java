package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzn;

final class zzbfy extends zzbfs {
    private final zzn<Status> zzgbw;

    public zzbfy(zzn<Status> com_google_android_gms_common_api_internal_zzn_com_google_android_gms_common_api_Status) {
        this.zzgbw = com_google_android_gms_common_api_internal_zzn_com_google_android_gms_common_api_Status;
    }

    public final void zzci(int i) throws RemoteException {
        this.zzgbw.setResult(new Status(i));
    }
}
