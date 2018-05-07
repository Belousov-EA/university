package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMap.OnPoiClickListener;
import com.google.android.gms.maps.internal.zzbc;
import com.google.android.gms.maps.model.PointOfInterest;

final class zzs extends zzbc {
    private /* synthetic */ OnPoiClickListener zzirs;

    zzs(GoogleMap googleMap, OnPoiClickListener onPoiClickListener) {
        this.zzirs = onPoiClickListener;
    }

    public final void zza(PointOfInterest pointOfInterest) throws RemoteException {
        this.zzirs.onPoiClick(pointOfInterest);
    }
}
