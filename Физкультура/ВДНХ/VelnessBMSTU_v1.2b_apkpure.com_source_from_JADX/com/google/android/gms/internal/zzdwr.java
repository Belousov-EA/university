package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zze;
import com.google.firebase.auth.internal.zzn;

final class zzdwr extends zzdxx<AuthResult, zza> {
    @NonNull
    private final String zzeey;
    @NonNull
    private final String zzegs;

    public zzdwr(@NonNull String str, @NonNull String str2) {
        super(2);
        this.zzegs = zzbq.zzh(str, "email cannot be null or empty");
        this.zzeey = zzbq.zzh(str2, "password cannot be null or empty");
    }

    public final void dispatch() throws RemoteException {
        this.zzmfg.zzd(this.zzegs, this.zzeey, this.zzmfe);
    }

    public final void zzbrl() {
        FirebaseUser zzb = zzdwc.zza(this.zzmcx, this.zzmfp);
        if (this.zzmff.getUid().equalsIgnoreCase(zzb.getUid())) {
            ((zza) this.zzmfh).zza(this.zzmfo, zzb);
            zzbd(new zze(zzb));
            return;
        }
        zzap(zzn.zzbsg());
    }
}
