package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzcew extends zzeu implements zzceu {
    zzcew(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    public final void zza(zzceo com_google_android_gms_internal_zzceo) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) com_google_android_gms_internal_zzceo);
        zzc(1, zzbe);
    }
}
