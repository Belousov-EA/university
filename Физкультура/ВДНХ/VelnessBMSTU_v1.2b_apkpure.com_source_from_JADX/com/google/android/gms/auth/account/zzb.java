package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;

public abstract class zzb extends zzev implements zza {
    public zzb() {
        attachInterface(this, "com.google.android.gms.auth.account.IWorkAccountCallback");
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        switch (i) {
            case 1:
                zzd((Account) zzew.zza(parcel, Account.CREATOR));
                break;
            case 2:
                zzap(zzew.zza(parcel));
                break;
            default:
                return false;
        }
        return true;
    }
}
