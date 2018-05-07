package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.model.internal.zza;

public interface zze extends IInterface {
    IMapViewDelegate zza(IObjectWrapper iObjectWrapper, GoogleMapOptions googleMapOptions) throws RemoteException;

    IStreetViewPanoramaViewDelegate zza(IObjectWrapper iObjectWrapper, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException;

    IMapFragmentDelegate zzaa(IObjectWrapper iObjectWrapper) throws RemoteException;

    IStreetViewPanoramaFragmentDelegate zzab(IObjectWrapper iObjectWrapper) throws RemoteException;

    ICameraUpdateFactoryDelegate zzawc() throws RemoteException;

    zza zzawd() throws RemoteException;

    void zzi(IObjectWrapper iObjectWrapper, int i) throws RemoteException;
}
