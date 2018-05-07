package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.maps.model.internal.zzq;

public abstract class zzi extends zzev implements zzh {
    public zzi() {
        attachInterface(this, "com.google.android.gms.maps.internal.IInfoWindowAdapter");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        IInterface zzh;
        switch (i) {
            case 1:
                zzh = zzh(zzq.zzbk(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzew.zza(parcel2, zzh);
                return true;
            case 2:
                zzh = zzi(zzq.zzbk(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzew.zza(parcel2, zzh);
                return true;
            default:
                return false;
        }
    }
}
