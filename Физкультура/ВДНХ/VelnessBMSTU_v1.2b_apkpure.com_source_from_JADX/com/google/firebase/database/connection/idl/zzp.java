package com.google.firebase.database.connection.idl;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;

public final class zzp extends zzeu implements zzn {
    zzp(IBinder iBinder) {
        super(iBinder, "com.google.firebase.database.connection.idl.IGetTokenCallback");
    }

    public final void onError(String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzb(2, zzbe);
    }

    public final void zzpl(String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzb(1, zzbe);
    }
}
