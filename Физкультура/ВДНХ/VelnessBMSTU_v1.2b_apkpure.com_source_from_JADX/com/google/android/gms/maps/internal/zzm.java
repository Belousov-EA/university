package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.maps.model.CameraPosition;

public abstract class zzm extends zzev implements zzl {
    public zzm() {
        attachInterface(this, "com.google.android.gms.maps.internal.IOnCameraChangeListener");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        onCameraChange((CameraPosition) zzew.zza(parcel, CameraPosition.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
