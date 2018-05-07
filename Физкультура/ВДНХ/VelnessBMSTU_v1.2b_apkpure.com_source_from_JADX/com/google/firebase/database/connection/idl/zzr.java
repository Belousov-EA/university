package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;

public abstract class zzr extends zzev implements zzq {
    public zzr() {
        attachInterface(this, "com.google.firebase.database.connection.idl.IListenHashProvider");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                String zzbuh = zzbuh();
                parcel2.writeNoException();
                parcel2.writeString(zzbuh);
                return true;
            case 2:
                boolean zzbui = zzbui();
                parcel2.writeNoException();
                zzew.zza(parcel2, zzbui);
                return true;
            case 3:
                Parcelable zzbvh = zzbvh();
                parcel2.writeNoException();
                zzew.zzb(parcel2, zzbvh);
                return true;
            default:
                return false;
        }
    }
}
