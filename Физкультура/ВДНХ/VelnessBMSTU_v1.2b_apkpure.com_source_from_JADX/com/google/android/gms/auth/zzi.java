package com.google.android.gms.auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.internal.zzaxb;
import com.google.android.gms.internal.zzey;
import java.io.IOException;

final class zzi implements zzj<Boolean> {
    private /* synthetic */ String zzeci;

    zzi(String str) {
        this.zzeci = str;
    }

    public final /* synthetic */ Object zzac(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Bundle bundle = (Bundle) zzd.zzp(zzey.zza(iBinder).zzp(this.zzeci));
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzaxb zzfb = zzaxb.zzfb(string);
        if (zzaxb.SUCCESS.equals(zzfb)) {
            return Boolean.valueOf(true);
        }
        if (zzaxb.zza(zzfb)) {
            Object[] objArr = new Object[1];
            String valueOf = String.valueOf(zzfb);
            objArr[0] = new StringBuilder(String.valueOf(valueOf).length() + 31).append("isUserRecoverableError status: ").append(valueOf).toString();
            zzd.zzecc.zzf("GoogleAuthUtil", objArr);
            throw new UserRecoverableAuthException(string, intent);
        }
        throw new GoogleAuthException(string);
    }
}
