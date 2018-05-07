package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.internal.zza;

final class zzdwu extends zzdxx<Void, zza> {
    @NonNull
    private String zzecl;
    @Nullable
    private ActionCodeSettings zzmeu;

    public zzdwu(@NonNull String str, @Nullable ActionCodeSettings actionCodeSettings) {
        super(6);
        this.zzecl = zzbq.zzh(str, "token cannot be null or empty");
        this.zzmeu = actionCodeSettings;
    }

    public final void dispatch() throws RemoteException {
        this.zzmfg.zza(this.zzecl, this.zzmeu, this.zzmfe);
    }

    public final void zzbrl() {
        zzbd(null);
    }
}
