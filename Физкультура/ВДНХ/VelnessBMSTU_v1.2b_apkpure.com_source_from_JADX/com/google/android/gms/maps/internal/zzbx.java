package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzbx extends zzeu implements IUiSettingsDelegate {
    zzbx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IUiSettingsDelegate");
    }

    public final boolean isCompassEnabled() throws RemoteException {
        Parcel zza = zza(10, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isIndoorLevelPickerEnabled() throws RemoteException {
        Parcel zza = zza(17, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isMapToolbarEnabled() throws RemoteException {
        Parcel zza = zza(19, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isMyLocationButtonEnabled() throws RemoteException {
        Parcel zza = zza(11, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isRotateGesturesEnabled() throws RemoteException {
        Parcel zza = zza(15, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isScrollGesturesEnabled() throws RemoteException {
        Parcel zza = zza(12, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isTiltGesturesEnabled() throws RemoteException {
        Parcel zza = zza(14, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isZoomControlsEnabled() throws RemoteException {
        Parcel zza = zza(9, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isZoomGesturesEnabled() throws RemoteException {
        Parcel zza = zza(13, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void setAllGesturesEnabled(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(8, zzbe);
    }

    public final void setCompassEnabled(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(2, zzbe);
    }

    public final void setIndoorLevelPickerEnabled(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(16, zzbe);
    }

    public final void setMapToolbarEnabled(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(18, zzbe);
    }

    public final void setMyLocationButtonEnabled(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(3, zzbe);
    }

    public final void setRotateGesturesEnabled(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(7, zzbe);
    }

    public final void setScrollGesturesEnabled(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(4, zzbe);
    }

    public final void setTiltGesturesEnabled(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(6, zzbe);
    }

    public final void setZoomControlsEnabled(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(1, zzbe);
    }

    public final void setZoomGesturesEnabled(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(5, zzbe);
    }
}
