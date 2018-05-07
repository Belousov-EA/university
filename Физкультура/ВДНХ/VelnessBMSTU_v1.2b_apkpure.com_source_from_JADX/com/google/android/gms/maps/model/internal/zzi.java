package com.google.android.gms.maps.model.internal;

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
import com.google.android.gms.maps.model.LatLngBounds;

public final class zzi extends zzeu implements zzg {
    zzi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IGroundOverlayDelegate");
    }

    public final float getBearing() throws RemoteException {
        Parcel zza = zza(12, zzbe());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final LatLngBounds getBounds() throws RemoteException {
        Parcel zza = zza(10, zzbe());
        LatLngBounds latLngBounds = (LatLngBounds) zzew.zza(zza, LatLngBounds.CREATOR);
        zza.recycle();
        return latLngBounds;
    }

    public final float getHeight() throws RemoteException {
        Parcel zza = zza(8, zzbe());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final String getId() throws RemoteException {
        Parcel zza = zza(2, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final LatLng getPosition() throws RemoteException {
        Parcel zza = zza(4, zzbe());
        LatLng latLng = (LatLng) zzew.zza(zza, LatLng.CREATOR);
        zza.recycle();
        return latLng;
    }

    public final IObjectWrapper getTag() throws RemoteException {
        Parcel zza = zza(25, zzbe());
        IObjectWrapper zzaq = zza.zzaq(zza.readStrongBinder());
        zza.recycle();
        return zzaq;
    }

    public final float getTransparency() throws RemoteException {
        Parcel zza = zza(18, zzbe());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final float getWidth() throws RemoteException {
        Parcel zza = zza(7, zzbe());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final float getZIndex() throws RemoteException {
        Parcel zza = zza(14, zzbe());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final int hashCodeRemote() throws RemoteException {
        Parcel zza = zza(20, zzbe());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final boolean isClickable() throws RemoteException {
        Parcel zza = zza(23, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isVisible() throws RemoteException {
        Parcel zza = zza(16, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void remove() throws RemoteException {
        zzb(1, zzbe());
    }

    public final void setBearing(float f) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzb(11, zzbe);
    }

    public final void setClickable(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(22, zzbe);
    }

    public final void setDimensions(float f) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzb(5, zzbe);
    }

    public final void setPosition(LatLng latLng) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) latLng);
        zzb(3, zzbe);
    }

    public final void setPositionFromBounds(LatLngBounds latLngBounds) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) latLngBounds);
        zzb(9, zzbe);
    }

    public final void setTag(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzb(24, zzbe);
    }

    public final void setTransparency(float f) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzb(17, zzbe);
    }

    public final void setVisible(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(15, zzbe);
    }

    public final void setZIndex(float f) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzb(13, zzbe);
    }

    public final void zzac(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzb(21, zzbe);
    }

    public final boolean zzb(zzg com_google_android_gms_maps_model_internal_zzg) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_model_internal_zzg);
        zzbe = zza(19, zzbe);
        boolean zza = zzew.zza(zzbe);
        zzbe.recycle();
        return zza;
    }

    public final void zzf(float f, float f2) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzbe.writeFloat(f2);
        zzb(6, zzbe);
    }
}
