package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzv extends zzeu implements zzu {
    zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    public final void zza(zzs com_google_android_gms_auth_api_signin_internal_zzs, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_auth_api_signin_internal_zzs);
        zzew.zza(zzbe, (Parcelable) googleSignInOptions);
        zzb(101, zzbe);
    }

    public final void zzb(zzs com_google_android_gms_auth_api_signin_internal_zzs, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_auth_api_signin_internal_zzs);
        zzew.zza(zzbe, (Parcelable) googleSignInOptions);
        zzb(102, zzbe);
    }

    public final void zzc(zzs com_google_android_gms_auth_api_signin_internal_zzs, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_auth_api_signin_internal_zzs);
        zzew.zza(zzbe, (Parcelable) googleSignInOptions);
        zzb(103, zzbe);
    }
}
