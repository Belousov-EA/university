package com.google.android.gms.maps.model.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzy extends zzeu implements zzw {
    zzy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
    }

    public final void clearTileCache() throws RemoteException {
        zzb(2, zzbe());
    }

    public final boolean getFadeIn() throws RemoteException {
        Parcel zza = zza(11, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final String getId() throws RemoteException {
        Parcel zza = zza(3, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final float getTransparency() throws RemoteException {
        Parcel zza = zza(13, zzbe());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final float getZIndex() throws RemoteException {
        Parcel zza = zza(5, zzbe());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final int hashCodeRemote() throws RemoteException {
        Parcel zza = zza(9, zzbe());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final boolean isVisible() throws RemoteException {
        Parcel zza = zza(7, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void remove() throws RemoteException {
        zzb(1, zzbe());
    }

    public final void setFadeIn(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(10, zzbe);
    }

    public final void setTransparency(float f) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzb(12, zzbe);
    }

    public final void setVisible(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(6, zzbe);
    }

    public final void setZIndex(float f) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzb(4, zzbe);
    }

    public final boolean zza(zzw com_google_android_gms_maps_model_internal_zzw) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_model_internal_zzw);
        zzbe = zza(8, zzbe);
        boolean zza = zzew.zza(zzbe);
        zzbe.recycle();
        return zza;
    }
}
