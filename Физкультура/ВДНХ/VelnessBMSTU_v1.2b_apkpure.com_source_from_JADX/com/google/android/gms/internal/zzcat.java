package com.google.android.gms.internal;

import android.os.RemoteException;

public final class zzcat extends zzcaq<Integer> {
    public zzcat(int i, String str, Integer num) {
        super(0, str, num);
    }

    private final Integer zzc(zzcay com_google_android_gms_internal_zzcay) {
        try {
            return Integer.valueOf(com_google_android_gms_internal_zzcay.getIntFlagValue(getKey(), ((Integer) zziv()).intValue(), getSource()));
        } catch (RemoteException e) {
            return (Integer) zziv();
        }
    }

    public final /* synthetic */ Object zza(zzcay com_google_android_gms_internal_zzcay) {
        return zzc(com_google_android_gms_internal_zzcay);
    }
}
