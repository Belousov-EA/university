package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.maps.model.internal.zzq;

public abstract class zzas extends zzev implements zzar {
    public zzas() {
        attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerClickListener");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        boolean zza = zza(zzq.zzbk(parcel.readStrongBinder()));
        parcel2.writeNoException();
        zzew.zza(parcel2, zza);
        return true;
    }
}
