package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public abstract class zzbo extends zzev implements zzbn {
    public zzbo() {
        attachInterface(this, "com.google.android.gms.maps.internal.IOnStreetViewPanoramaLongClickListener");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        onStreetViewPanoramaLongClick((StreetViewPanoramaOrientation) zzew.zza(parcel, StreetViewPanoramaOrientation.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
