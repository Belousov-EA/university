package com.google.android.gms.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzr extends zzeu implements zzp {
    zzr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.ILocationCallback");
    }

    public final void onLocationAvailability(LocationAvailability locationAvailability) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) locationAvailability);
        zzc(2, zzbe);
    }

    public final void onLocationResult(LocationResult locationResult) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) locationResult);
        zzc(1, zzbe);
    }
}
