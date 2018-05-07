package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zze extends zzeu implements zzc {
    zze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.account.IWorkAccountService");
    }

    public final void zza(zza com_google_android_gms_auth_account_zza, Account account) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_auth_account_zza);
        zzew.zza(zzbe, (Parcelable) account);
        zzb(3, zzbe);
    }

    public final void zza(zza com_google_android_gms_auth_account_zza, String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_auth_account_zza);
        zzbe.writeString(str);
        zzb(2, zzbe);
    }

    public final void zzaq(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(1, zzbe);
    }
}
