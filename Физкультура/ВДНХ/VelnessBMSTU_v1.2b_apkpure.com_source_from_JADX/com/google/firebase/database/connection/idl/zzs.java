package com.google.firebase.database.connection.idl;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzs extends zzeu implements zzq {
    zzs(IBinder iBinder) {
        super(iBinder, "com.google.firebase.database.connection.idl.IListenHashProvider");
    }

    public final String zzbuh() throws RemoteException {
        Parcel zza = zza(1, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final boolean zzbui() throws RemoteException {
        Parcel zza = zza(2, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final zza zzbvh() throws RemoteException {
        Parcel zza = zza(3, zzbe());
        zza com_google_firebase_database_connection_idl_zza = (zza) zzew.zza(zza, zza.CREATOR);
        zza.recycle();
        return com_google_firebase_database_connection_idl_zza;
    }
}
