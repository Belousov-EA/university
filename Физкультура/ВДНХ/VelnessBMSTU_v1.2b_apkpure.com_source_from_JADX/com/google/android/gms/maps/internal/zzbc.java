package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.maps.model.PointOfInterest;

public abstract class zzbc extends zzev implements zzbb {
    public zzbc() {
        attachInterface(this, "com.google.android.gms.maps.internal.IOnPoiClickListener");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        zza((PointOfInterest) zzew.zza(parcel, PointOfInterest.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
