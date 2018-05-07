package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.maps.model.internal.IPolylineDelegate.zza;

public abstract class zzbg extends zzev implements zzbf {
    public zzbg() {
        attachInterface(this, "com.google.android.gms.maps.internal.IOnPolylineClickListener");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        zza(zza.zzbm(parcel.readStrongBinder()));
        parcel2.writeNoException();
        return true;
    }
}
