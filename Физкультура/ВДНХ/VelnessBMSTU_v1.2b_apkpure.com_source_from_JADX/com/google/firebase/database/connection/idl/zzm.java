package com.google.firebase.database.connection.idl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzm extends zzeu implements zzk {
    zzm(IBinder iBinder) {
        super(iBinder, "com.google.firebase.database.connection.idl.IConnectionAuthTokenProvider");
    }

    public final void zza(boolean z, zzn com_google_firebase_database_connection_idl_zzn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzew.zza(zzbe, (IInterface) com_google_firebase_database_connection_idl_zzn);
        zzb(1, zzbe);
    }
}
