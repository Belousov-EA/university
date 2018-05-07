package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;

public final class zzez extends zzeu implements zzex {
    zzez(IBinder iBinder) {
        super(iBinder, "com.google.android.auth.IAuthManagerService");
    }

    public final Bundle zza(Account account) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) account);
        Parcel zza = zza(7, zzbe);
        Bundle bundle = (Bundle) zzew.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }

    public final Bundle zza(Account account, String str, Bundle bundle) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) account);
        zzbe.writeString(str);
        zzew.zza(zzbe, (Parcelable) bundle);
        Parcel zza = zza(5, zzbe);
        Bundle bundle2 = (Bundle) zzew.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle2;
    }

    public final Bundle zza(String str, Bundle bundle) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzew.zza(zzbe, (Parcelable) bundle);
        Parcel zza = zza(2, zzbe);
        Bundle bundle2 = (Bundle) zzew.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle2;
    }

    public final AccountChangeEventsResponse zza(AccountChangeEventsRequest accountChangeEventsRequest) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) accountChangeEventsRequest);
        Parcel zza = zza(3, zzbe);
        AccountChangeEventsResponse accountChangeEventsResponse = (AccountChangeEventsResponse) zzew.zza(zza, AccountChangeEventsResponse.CREATOR);
        zza.recycle();
        return accountChangeEventsResponse;
    }

    public final Bundle zzp(String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        Parcel zza = zza(8, zzbe);
        Bundle bundle = (Bundle) zzew.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle;
    }
}
