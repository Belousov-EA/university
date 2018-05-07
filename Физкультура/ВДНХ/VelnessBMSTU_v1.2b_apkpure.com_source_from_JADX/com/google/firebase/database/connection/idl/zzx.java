package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.zza;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;

public abstract class zzx extends zzev implements zzw {
    public zzx() {
        attachInterface(this, "com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zza(parcel.createStringArrayList(), zza.zzaq(parcel.readStrongBinder()), zzew.zza(parcel), parcel.readLong());
                break;
            case 2:
                zza(parcel.createStringArrayList(), parcel.createTypedArrayList(zzak.CREATOR), zza.zzaq(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 3:
                zzbuk();
                break;
            case 4:
                onDisconnect();
                break;
            case 5:
                zzcl(zzew.zza(parcel));
                break;
            case 6:
                zzag(zza.zzaq(parcel.readStrongBinder()));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
