package com.google.android.gms.internal;

import android.os.RemoteException;

public final class zzcas extends zzcaq<Boolean> {
    public zzcas(int i, String str, Boolean bool) {
        super(0, str, bool);
    }

    private final Boolean zzb(zzcay com_google_android_gms_internal_zzcay) {
        try {
            return Boolean.valueOf(com_google_android_gms_internal_zzcay.getBooleanFlagValue(getKey(), ((Boolean) zziv()).booleanValue(), getSource()));
        } catch (RemoteException e) {
            return (Boolean) zziv();
        }
    }

    public final /* synthetic */ Object zza(zzcay com_google_android_gms_internal_zzcay) {
        return zzb(com_google_android_gms_internal_zzcay);
    }
}
