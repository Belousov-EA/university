package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzbet extends zzeu implements zzbes {
    zzbet(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.clearcut.internal.IClearcutLoggerService");
    }

    public final void zza(zzbeq com_google_android_gms_internal_zzbeq, zzbeh com_google_android_gms_internal_zzbeh) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzbeq);
        zzew.zza(zzbe, (Parcelable) com_google_android_gms_internal_zzbeh);
        zzc(1, zzbe);
    }
}
