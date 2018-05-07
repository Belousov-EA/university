package com.google.android.gms.internal;

import android.os.RemoteException;

public final class zzcau extends zzcaq<Long> {
    public zzcau(int i, String str, Long l) {
        super(0, str, l);
    }

    private final Long zzd(zzcay com_google_android_gms_internal_zzcay) {
        try {
            return Long.valueOf(com_google_android_gms_internal_zzcay.getLongFlagValue(getKey(), ((Long) zziv()).longValue(), getSource()));
        } catch (RemoteException e) {
            return (Long) zziv();
        }
    }

    public final /* synthetic */ Object zza(zzcay com_google_android_gms_internal_zzcay) {
        return zzd(com_google_android_gms_internal_zzcay);
    }
}
