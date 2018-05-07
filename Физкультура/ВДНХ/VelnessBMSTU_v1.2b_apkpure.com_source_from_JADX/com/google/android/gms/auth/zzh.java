package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.zzey;
import java.io.IOException;

final class zzh implements zzj<Bundle> {
    private /* synthetic */ Account zzecd;

    zzh(Account account) {
        this.zzecd = account;
    }

    public final /* synthetic */ Object zzac(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        return (Bundle) zzd.zzp(zzey.zza(iBinder).zza(this.zzecd));
    }
}
