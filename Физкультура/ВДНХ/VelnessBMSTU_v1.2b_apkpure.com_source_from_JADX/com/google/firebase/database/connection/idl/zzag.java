package com.google.firebase.database.connection.idl;

import android.os.RemoteException;
import com.google.android.gms.internal.zzebh;

final class zzag extends zzo {
    private /* synthetic */ zzebh zzmqz;

    zzag(zzaf com_google_firebase_database_connection_idl_zzaf, zzebh com_google_android_gms_internal_zzebh) {
        this.zzmqz = com_google_android_gms_internal_zzebh;
    }

    public final void onError(String str) throws RemoteException {
        this.zzmqz.onError(str);
    }

    public final void zzpl(String str) throws RemoteException {
        this.zzmqz.zzpl(str);
    }
}
