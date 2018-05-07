package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;

public final class zzdxq extends zzeu implements zzdxp {
    zzdxq(IBinder iBinder) {
        super(iBinder, "com.google.firebase.auth.api.internal.IFirebaseAuthService");
    }

    public final void zza(zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(16, zzbe);
    }

    public final void zza(zzdyu com_google_android_gms_internal_zzdyu, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) com_google_android_gms_internal_zzdyu);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(22, zzbe);
    }

    public final void zza(zzdyy com_google_android_gms_internal_zzdyy, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) com_google_android_gms_internal_zzdyy);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(3, zzbe);
    }

    public final void zza(PhoneAuthCredential phoneAuthCredential, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) phoneAuthCredential);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(23, zzbe);
    }

    public final void zza(String str, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(1, zzbe);
    }

    public final void zza(String str, zzdyy com_google_android_gms_internal_zzdyy, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzew.zza(zzbe, (Parcelable) com_google_android_gms_internal_zzdyy);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(12, zzbe);
    }

    public final void zza(String str, ActionCodeSettings actionCodeSettings, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzew.zza(zzbe, (Parcelable) actionCodeSettings);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(26, zzbe);
    }

    public final void zza(String str, PhoneAuthCredential phoneAuthCredential, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzew.zza(zzbe, (Parcelable) phoneAuthCredential);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(24, zzbe);
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzew.zza(zzbe, (Parcelable) userProfileChangeRequest);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(4, zzbe);
    }

    public final void zza(String str, String str2, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzbe.writeString(str2);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(5, zzbe);
    }

    public final void zza(String str, String str2, String str3, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzbe.writeString(str2);
        zzbe.writeString(str3);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(11, zzbe);
    }

    public final void zzb(String str, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(2, zzbe);
    }

    public final void zzb(String str, ActionCodeSettings actionCodeSettings, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzew.zza(zzbe, (Parcelable) actionCodeSettings);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(28, zzbe);
    }

    public final void zzb(String str, String str2, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzbe.writeString(str2);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(6, zzbe);
    }

    public final void zzc(String str, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(9, zzbe);
    }

    public final void zzc(String str, String str2, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzbe.writeString(str2);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(7, zzbe);
    }

    public final void zzd(String str, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(13, zzbe);
    }

    public final void zzd(String str, String str2, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzbe.writeString(str2);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(8, zzbe);
    }

    public final void zze(String str, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(15, zzbe);
    }

    public final void zze(String str, String str2, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzbe.writeString(str2);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(14, zzbe);
    }

    public final void zzf(String str, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(17, zzbe);
    }

    public final void zzf(String str, String str2, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzbe.writeString(str2);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(21, zzbe);
    }

    public final void zzg(String str, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(19, zzbe);
    }

    public final void zzh(String str, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(20, zzbe);
    }

    public final void zzi(String str, zzdxn com_google_android_gms_internal_zzdxn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_internal_zzdxn);
        zzb(27, zzbe);
    }
}
