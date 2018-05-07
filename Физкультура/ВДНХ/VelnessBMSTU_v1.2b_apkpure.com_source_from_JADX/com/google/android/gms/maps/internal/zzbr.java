package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

public final class zzbr extends zzeu implements IProjectionDelegate {
    zzbr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IProjectionDelegate");
    }

    public final LatLng fromScreenLocation(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        Parcel zza = zza(1, zzbe);
        LatLng latLng = (LatLng) zzew.zza(zza, LatLng.CREATOR);
        zza.recycle();
        return latLng;
    }

    public final VisibleRegion getVisibleRegion() throws RemoteException {
        Parcel zza = zza(3, zzbe());
        VisibleRegion visibleRegion = (VisibleRegion) zzew.zza(zza, VisibleRegion.CREATOR);
        zza.recycle();
        return visibleRegion;
    }

    public final IObjectWrapper toScreenLocation(LatLng latLng) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) latLng);
        zzbe = zza(2, zzbe);
        IObjectWrapper zzaq = zza.zzaq(zzbe.readStrongBinder());
        zzbe.recycle();
        return zzaq;
    }
}
