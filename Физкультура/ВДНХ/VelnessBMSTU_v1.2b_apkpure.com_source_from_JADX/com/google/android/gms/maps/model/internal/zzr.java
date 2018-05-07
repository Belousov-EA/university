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

public final class zzr extends zzeu implements zzp {
    zzr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IMarkerDelegate");
    }

    public final float getAlpha() throws RemoteException {
        Parcel zza = zza(26, zzbe());
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

    public final float getRotation() throws RemoteException {
        Parcel zza = zza(23, zzbe());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final String getSnippet() throws RemoteException {
        Parcel zza = zza(8, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final IObjectWrapper getTag() throws RemoteException {
        Parcel zza = zza(30, zzbe());
        IObjectWrapper zzaq = zza.zzaq(zza.readStrongBinder());
        zza.recycle();
        return zzaq;
    }

    public final String getTitle() throws RemoteException {
        Parcel zza = zza(6, zzbe());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final float getZIndex() throws RemoteException {
        Parcel zza = zza(28, zzbe());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final int hashCodeRemote() throws RemoteException {
        Parcel zza = zza(17, zzbe());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final void hideInfoWindow() throws RemoteException {
        zzb(12, zzbe());
    }

    public final boolean isDraggable() throws RemoteException {
        Parcel zza = zza(10, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isFlat() throws RemoteException {
        Parcel zza = zza(21, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isInfoWindowShown() throws RemoteException {
        Parcel zza = zza(13, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isVisible() throws RemoteException {
        Parcel zza = zza(15, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void remove() throws RemoteException {
        zzb(1, zzbe());
    }

    public final void setAlpha(float f) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzb(25, zzbe);
    }

    public final void setAnchor(float f, float f2) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzbe.writeFloat(f2);
        zzb(19, zzbe);
    }

    public final void setDraggable(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(9, zzbe);
    }

    public final void setFlat(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(20, zzbe);
    }

    public final void setInfoWindowAnchor(float f, float f2) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzbe.writeFloat(f2);
        zzb(24, zzbe);
    }

    public final void setPosition(LatLng latLng) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) latLng);
        zzb(3, zzbe);
    }

    public final void setRotation(float f) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzb(22, zzbe);
    }

    public final void setSnippet(String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzb(7, zzbe);
    }

    public final void setTag(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzb(29, zzbe);
    }

    public final void setTitle(String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzb(5, zzbe);
    }

    public final void setVisible(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(14, zzbe);
    }

    public final void setZIndex(float f) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzb(27, zzbe);
    }

    public final void showInfoWindow() throws RemoteException {
        zzb(11, zzbe());
    }

    public final void zzad(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzb(18, zzbe);
    }

    public final boolean zzj(zzp com_google_android_gms_maps_model_internal_zzp) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_model_internal_zzp);
        zzbe = zza(16, zzbe);
        boolean zza = zzew.zza(zzbe);
        zzbe.recycle();
        return zza;
    }
}
