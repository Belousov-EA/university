package com.google.firebase.database.connection.idl;

import com.google.android.gms.internal.zzebb;
import com.google.android.gms.internal.zzebl;

final class zzz implements zzebl {
    private /* synthetic */ zzq zzmqs;

    zzz(IPersistentConnectionImpl iPersistentConnectionImpl, zzq com_google_firebase_database_connection_idl_zzq) {
        this.zzmqs = com_google_firebase_database_connection_idl_zzq;
    }

    public final String zzbuh() {
        try {
            return this.zzmqs.zzbuh();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final boolean zzbui() {
        try {
            return this.zzmqs.zzbui();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final zzebb zzbuj() {
        try {
            return zza.zza(this.zzmqs.zzbvh());
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
