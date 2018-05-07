package com.google.firebase.database.connection.idl;

import com.google.android.gms.internal.zzebg;
import com.google.android.gms.internal.zzebh;

final class zzaf implements zzebg {
    private /* synthetic */ zzk zzmqy;

    zzaf(zzk com_google_firebase_database_connection_idl_zzk) {
        this.zzmqy = com_google_firebase_database_connection_idl_zzk;
    }

    public final void zza(boolean z, zzebh com_google_android_gms_internal_zzebh) {
        try {
            this.zzmqy.zza(z, new zzag(this, com_google_android_gms_internal_zzebh));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
