package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.maps.model.LatLng;

public abstract class zzak extends zzev implements zzaj {
    public zzak() {
        attachInterface(this, "com.google.android.gms.maps.internal.IOnMapClickListener");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        onMapClick((LatLng) zzew.zza(parcel, LatLng.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
