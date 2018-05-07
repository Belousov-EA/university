package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.firebase.auth.internal.zza;

final class zzdww extends zzdxx<Void, zza> {
    private String zzmev;

    public zzdww(String str) {
        super(9);
        this.zzmev = str;
    }

    public final void dispatch() throws RemoteException {
        this.zzmfg.zzi(this.zzmev, this.zzmfe);
    }

    public final void zzbrl() {
        zzbd(null);
    }
}
