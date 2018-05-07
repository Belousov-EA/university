package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.maps.model.internal.zzq;

public abstract class zzae extends zzev implements zzad {
    public zzae() {
        attachInterface(this, "com.google.android.gms.maps.internal.IOnInfoWindowCloseListener");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        zzg(zzq.zzbk(parcel.readStrongBinder()));
        parcel2.writeNoException();
        return true;
    }
}
