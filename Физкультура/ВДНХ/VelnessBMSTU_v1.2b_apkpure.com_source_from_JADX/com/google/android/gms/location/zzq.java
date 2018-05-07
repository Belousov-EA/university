package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;

public abstract class zzq extends zzev implements zzp {
    public zzq() {
        attachInterface(this, "com.google.android.gms.location.ILocationCallback");
    }

    public static zzp zzbd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return queryLocalInterface instanceof zzp ? (zzp) queryLocalInterface : new zzr(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                onLocationResult((LocationResult) zzew.zza(parcel, LocationResult.CREATOR));
                break;
            case 2:
                onLocationAvailability((LocationAvailability) zzew.zza(parcel, LocationAvailability.CREATOR));
                break;
            default:
                return false;
        }
        return true;
    }
}
