package com.google.firebase.database.connection.idl;

import com.google.android.gms.internal.zzebh;

final class zzae implements zzebh {
    private /* synthetic */ zzn zzmqx;

    zzae(zzad com_google_firebase_database_connection_idl_zzad, zzn com_google_firebase_database_connection_idl_zzn) {
        this.zzmqx = com_google_firebase_database_connection_idl_zzn;
    }

    public final void onError(String str) {
        try {
            this.zzmqx.onError(str);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void zzpl(String str) {
        try {
            this.zzmqx.zzpl(str);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
