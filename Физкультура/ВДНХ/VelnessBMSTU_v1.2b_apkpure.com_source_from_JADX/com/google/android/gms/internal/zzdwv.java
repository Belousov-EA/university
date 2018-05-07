package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.internal.zza;

final class zzdwv extends zzdxx<Void, zza> {
    @NonNull
    private final String zzegs;
    @NonNull
    private final ActionCodeSettings zzmeu;

    public zzdwv(@NonNull String str, @NonNull ActionCodeSettings actionCodeSettings) {
        super(4);
        this.zzegs = zzbq.zzh(str, "email cannot be null or empty");
        this.zzmeu = actionCodeSettings;
    }

    public final void dispatch() throws RemoteException {
        this.zzmfg.zzb(this.zzegs, this.zzmeu, this.zzmfe);
    }

    public final void zzbrl() {
        zzbd(null);
    }
}
