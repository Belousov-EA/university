package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.internal.zzaw;

final class zzi extends zzaw {
    private /* synthetic */ OnMyLocationButtonClickListener zziri;

    zzi(GoogleMap googleMap, OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
        this.zziri = onMyLocationButtonClickListener;
    }

    public final boolean onMyLocationButtonClick() throws RemoteException {
        return this.zziri.onMyLocationButtonClick();
    }
}
