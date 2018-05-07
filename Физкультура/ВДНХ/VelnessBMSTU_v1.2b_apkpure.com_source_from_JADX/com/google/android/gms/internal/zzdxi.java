package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzc;

final class zzdxi extends zzdxx<String, zza> {
    @NonNull
    private final String zzhqe;

    public zzdxi(@NonNull String str) {
        super(4);
        this.zzhqe = zzbq.zzh(str, "code cannot be null or empty");
    }

    public final void dispatch() throws RemoteException {
        this.zzmfg.zzg(this.zzhqe, this.zzmfe);
    }

    public final void zzbrl() {
        if (new zzc(this.zzmfr).getOperation() != 0) {
            zzap(new Status(17499));
        } else {
            zzbd(this.zzmfr.getEmail());
        }
    }
}
