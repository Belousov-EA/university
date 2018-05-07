package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public final class zzb extends zzeu implements ICameraUpdateFactoryDelegate {
    zzb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate");
    }

    public final IObjectWrapper newCameraPosition(CameraPosition cameraPosition) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) cameraPosition);
        zzbe = zza(7, zzbe);
        IObjectWrapper zzaq = zza.zzaq(zzbe.readStrongBinder());
        zzbe.recycle();
        return zzaq;
    }

    public final IObjectWrapper newLatLng(LatLng latLng) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) latLng);
        zzbe = zza(8, zzbe);
        IObjectWrapper zzaq = zza.zzaq(zzbe.readStrongBinder());
        zzbe.recycle();
        return zzaq;
    }

    public final IObjectWrapper newLatLngBounds(LatLngBounds latLngBounds, int i) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) latLngBounds);
        zzbe.writeInt(i);
        zzbe = zza(10, zzbe);
        IObjectWrapper zzaq = zza.zzaq(zzbe.readStrongBinder());
        zzbe.recycle();
        return zzaq;
    }

    public final IObjectWrapper newLatLngBoundsWithSize(LatLngBounds latLngBounds, int i, int i2, int i3) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) latLngBounds);
        zzbe.writeInt(i);
        zzbe.writeInt(i2);
        zzbe.writeInt(i3);
        zzbe = zza(11, zzbe);
        IObjectWrapper zzaq = zza.zzaq(zzbe.readStrongBinder());
        zzbe.recycle();
        return zzaq;
    }

    public final IObjectWrapper newLatLngZoom(LatLng latLng, float f) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) latLng);
        zzbe.writeFloat(f);
        zzbe = zza(9, zzbe);
        IObjectWrapper zzaq = zza.zzaq(zzbe.readStrongBinder());
        zzbe.recycle();
        return zzaq;
    }

    public final IObjectWrapper scrollBy(float f, float f2) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzbe.writeFloat(f2);
        zzbe = zza(3, zzbe);
        IObjectWrapper zzaq = zza.zzaq(zzbe.readStrongBinder());
        zzbe.recycle();
        return zzaq;
    }

    public final IObjectWrapper zoomBy(float f) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzbe = zza(5, zzbe);
        IObjectWrapper zzaq = zza.zzaq(zzbe.readStrongBinder());
        zzbe.recycle();
        return zzaq;
    }

    public final IObjectWrapper zoomByWithFocus(float f, int i, int i2) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzbe.writeInt(i);
        zzbe.writeInt(i2);
        zzbe = zza(6, zzbe);
        IObjectWrapper zzaq = zza.zzaq(zzbe.readStrongBinder());
        zzbe.recycle();
        return zzaq;
    }

    public final IObjectWrapper zoomIn() throws RemoteException {
        Parcel zza = zza(1, zzbe());
        IObjectWrapper zzaq = zza.zzaq(zza.readStrongBinder());
        zza.recycle();
        return zzaq;
    }

    public final IObjectWrapper zoomOut() throws RemoteException {
        Parcel zza = zza(2, zzbe());
        IObjectWrapper zzaq = zza.zzaq(zza.readStrongBinder());
        zza.recycle();
        return zzaq;
    }

    public final IObjectWrapper zoomTo(float f) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzbe = zza(4, zzbe);
        IObjectWrapper zzaq = zza.zzaq(zzbe.readStrongBinder());
        zzbe.recycle();
        return zzaq;
    }
}
