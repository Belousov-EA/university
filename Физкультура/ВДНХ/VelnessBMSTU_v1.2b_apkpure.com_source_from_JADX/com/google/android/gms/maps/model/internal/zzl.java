package com.google.android.gms.maps.model.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;
import java.util.List;

public final class zzl extends zzeu implements zzj {
    zzl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
    }

    public final int getActiveLevelIndex() throws RemoteException {
        Parcel zza = zza(1, zzbe());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final List<IBinder> getLevels() throws RemoteException {
        Parcel zza = zza(3, zzbe());
        List createBinderArrayList = zza.createBinderArrayList();
        zza.recycle();
        return createBinderArrayList;
    }

    public final int hashCodeRemote() throws RemoteException {
        Parcel zza = zza(6, zzbe());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final boolean isUnderground() throws RemoteException {
        Parcel zza = zza(4, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean zzb(zzj com_google_android_gms_maps_model_internal_zzj) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_model_internal_zzj);
        zzbe = zza(5, zzbe);
        boolean zza = zzew.zza(zzbe);
        zzbe.recycle();
        return zza;
    }
}
