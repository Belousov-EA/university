package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

public final class zzawe extends zzeu implements zzawd {
    zzawe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    }

    public final void zza(zzawb com_google_android_gms_internal_zzawb) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzawb);
        zzb(4, zzbe);
    }

    public final void zza(zzawb com_google_android_gms_internal_zzawb, CredentialRequest credentialRequest) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzawb);
        zzew.zza(zzbe, (Parcelable) credentialRequest);
        zzb(1, zzbe);
    }

    public final void zza(zzawb com_google_android_gms_internal_zzawb, zzavz com_google_android_gms_internal_zzavz) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzawb);
        zzew.zza(zzbe, (Parcelable) com_google_android_gms_internal_zzavz);
        zzb(3, zzbe);
    }

    public final void zza(zzawb com_google_android_gms_internal_zzawb, zzawf com_google_android_gms_internal_zzawf) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzawb);
        zzew.zza(zzbe, (Parcelable) com_google_android_gms_internal_zzawf);
        zzb(2, zzbe);
    }
}
