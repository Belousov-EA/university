package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.internal.zzak;
import com.google.android.gms.maps.model.LatLng;

final class zzy extends zzak {
    private /* synthetic */ OnMapClickListener zziry;

    zzy(GoogleMap googleMap, OnMapClickListener onMapClickListener) {
        this.zziry = onMapClickListener;
    }

    public final void onMapClick(LatLng latLng) {
        this.zziry.onMapClick(latLng);
    }
}
