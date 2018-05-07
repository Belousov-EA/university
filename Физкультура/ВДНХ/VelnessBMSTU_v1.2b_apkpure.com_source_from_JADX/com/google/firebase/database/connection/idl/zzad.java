package com.google.firebase.database.connection.idl;

import android.os.RemoteException;
import com.google.android.gms.internal.zzebg;

final class zzad extends zzl {
    private /* synthetic */ zzebg zzmqw;

    zzad(zzebg com_google_android_gms_internal_zzebg) {
        this.zzmqw = com_google_android_gms_internal_zzebg;
    }

    public final void zza(boolean z, zzn com_google_firebase_database_connection_idl_zzn) throws RemoteException {
        this.zzmqw.zza(z, new zzae(this, com_google_firebase_database_connection_idl_zzn));
    }
}
