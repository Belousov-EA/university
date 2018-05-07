package com.google.android.gms.internal;

import android.os.RemoteException;

public final class zzcav extends zzcaq<String> {
    public zzcav(int i, String str, String str2) {
        super(0, str, str2);
    }

    private final String zze(zzcay com_google_android_gms_internal_zzcay) {
        try {
            return com_google_android_gms_internal_zzcay.getStringFlagValue(getKey(), (String) zziv(), getSource());
        } catch (RemoteException e) {
            return (String) zziv();
        }
    }

    public final /* synthetic */ Object zza(zzcay com_google_android_gms_internal_zzcay) {
        return zze(com_google_android_gms_internal_zzcay);
    }
}
