package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.zzaq;

final class zzak extends zzaq {
    private /* synthetic */ OnMapReadyCallback zzist;

    zzak(zza com_google_android_gms_maps_SupportMapFragment_zza, OnMapReadyCallback onMapReadyCallback) {
        this.zzist = onMapReadyCallback;
    }

    public final void zza(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
        this.zzist.onMapReady(new GoogleMap(iGoogleMapDelegate));
    }
}
