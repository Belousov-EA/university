package com.google.android.gms.maps.internal;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.zza;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;

public abstract class zzbt extends zzev implements zzbs {
    public zzbt() {
        attachInterface(this, "com.google.android.gms.maps.internal.ISnapshotReadyCallback");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                onSnapshotReady((Bitmap) zzew.zza(parcel, Bitmap.CREATOR));
                break;
            case 2:
                zzz(zza.zzaq(parcel.readStrongBinder()));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
