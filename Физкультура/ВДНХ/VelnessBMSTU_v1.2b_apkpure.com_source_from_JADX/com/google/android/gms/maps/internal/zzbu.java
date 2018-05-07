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
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public final class zzbu extends zzeu implements IStreetViewPanoramaDelegate {
    zzbu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
    }

    public final void animateTo(StreetViewPanoramaCamera streetViewPanoramaCamera, long j) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) streetViewPanoramaCamera);
        zzbe.writeLong(j);
        zzb(9, zzbe);
    }

    public final void enablePanning(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(2, zzbe);
    }

    public final void enableStreetNames(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(4, zzbe);
    }

    public final void enableUserNavigation(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(3, zzbe);
    }

    public final void enableZoom(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(1, zzbe);
    }

    public final StreetViewPanoramaCamera getPanoramaCamera() throws RemoteException {
        Parcel zza = zza(10, zzbe());
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) zzew.zza(zza, StreetViewPanoramaCamera.CREATOR);
        zza.recycle();
        return streetViewPanoramaCamera;
    }

    public final StreetViewPanoramaLocation getStreetViewPanoramaLocation() throws RemoteException {
        Parcel zza = zza(14, zzbe());
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) zzew.zza(zza, StreetViewPanoramaLocation.CREATOR);
        zza.recycle();
        return streetViewPanoramaLocation;
    }

    public final boolean isPanningGesturesEnabled() throws RemoteException {
        Parcel zza = zza(6, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isStreetNamesEnabled() throws RemoteException {
        Parcel zza = zza(8, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isUserNavigationEnabled() throws RemoteException {
        Parcel zza = zza(7, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isZoomGesturesEnabled() throws RemoteException {
        Parcel zza = zza(5, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final IObjectWrapper orientationToPoint(StreetViewPanoramaOrientation streetViewPanoramaOrientation) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) streetViewPanoramaOrientation);
        zzbe = zza(19, zzbe);
        IObjectWrapper zzaq = zza.zzaq(zzbe.readStrongBinder());
        zzbe.recycle();
        return zzaq;
    }

    public final StreetViewPanoramaOrientation pointToOrientation(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        Parcel zza = zza(18, zzbe);
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) zzew.zza(zza, StreetViewPanoramaOrientation.CREATOR);
        zza.recycle();
        return streetViewPanoramaOrientation;
    }

    public final void setOnStreetViewPanoramaCameraChangeListener(zzbh com_google_android_gms_maps_internal_zzbh) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzbh);
        zzb(16, zzbe);
    }

    public final void setOnStreetViewPanoramaChangeListener(zzbj com_google_android_gms_maps_internal_zzbj) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzbj);
        zzb(15, zzbe);
    }

    public final void setOnStreetViewPanoramaClickListener(zzbl com_google_android_gms_maps_internal_zzbl) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzbl);
        zzb(17, zzbe);
    }

    public final void setOnStreetViewPanoramaLongClickListener(zzbn com_google_android_gms_maps_internal_zzbn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzbn);
        zzb(20, zzbe);
    }

    public final void setPosition(LatLng latLng) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) latLng);
        zzb(12, zzbe);
    }

    public final void setPositionWithID(String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzb(11, zzbe);
    }

    public final void setPositionWithRadius(LatLng latLng, int i) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) latLng);
        zzbe.writeInt(i);
        zzb(13, zzbe);
    }
}
