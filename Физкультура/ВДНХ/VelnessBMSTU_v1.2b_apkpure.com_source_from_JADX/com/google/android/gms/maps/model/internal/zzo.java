package com.google.android.gms.maps.model.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzo extends zzeu implements zzm {
    zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
    }

    public final void activate() throws RemoteException {
        zzb(3, zzbe());
    }

    public final String getName() throws RemoteException {
        Parcel zza = zza(1, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final String getShortName() throws RemoteException {
        Parcel zza = zza(2, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final int hashCodeRemote() throws RemoteException {
        Parcel zza = zza(5, zzbe());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final boolean zza(zzm com_google_android_gms_maps_model_internal_zzm) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_model_internal_zzm);
        zzbe = zza(4, zzbe);
        boolean zza = zzew.zza(zzbe);
        zzbe.recycle();
        return zza;
    }
}
