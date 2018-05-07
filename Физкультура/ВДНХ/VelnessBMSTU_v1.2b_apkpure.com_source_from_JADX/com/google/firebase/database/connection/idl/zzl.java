package com.google.firebase.database.connection.idl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;

public abstract class zzl extends zzev implements zzk {
    public zzl() {
        attachInterface(this, "com.google.firebase.database.connection.idl.IConnectionAuthTokenProvider");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        if (i != 1) {
            return false;
        }
        zzn com_google_firebase_database_connection_idl_zzn;
        boolean zza = zzew.zza(parcel);
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            com_google_firebase_database_connection_idl_zzn = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.firebase.database.connection.idl.IGetTokenCallback");
            com_google_firebase_database_connection_idl_zzn = queryLocalInterface instanceof zzn ? (zzn) queryLocalInterface : new zzp(readStrongBinder);
        }
        zza(zza, com_google_firebase_database_connection_idl_zzn);
        parcel2.writeNoException();
        return true;
    }
}
