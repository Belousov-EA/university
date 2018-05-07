package com.google.firebase.database.connection.idl;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;

public final class zzaj extends zzeu implements zzah {
    zzaj(IBinder iBinder) {
        super(iBinder, "com.google.firebase.database.connection.idl.IRequestResultCallback");
    }

    public final void zzbd(String str, String str2) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzbe.writeString(str2);
        zzb(1, zzbe);
    }
}
