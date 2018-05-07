package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;

public abstract class zzaw extends zzev implements zzav {
    public zzaw() {
        attachInterface(this, "com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        boolean onMyLocationButtonClick = onMyLocationButtonClick();
        parcel2.writeNoException();
        zzew.zza(parcel2, onMyLocationButtonClick);
        return true;
    }
}
