package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;

public abstract class zzt extends zzev implements zzs {
    public zzt() {
        attachInterface(this, "com.google.android.gms.location.ILocationListener");
    }

    public static zzs zzbe(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return queryLocalInterface instanceof zzs ? (zzs) queryLocalInterface : new zzu(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        onLocationChanged((Location) zzew.zza(parcel, Location.CREATOR));
        return true;
    }
}
