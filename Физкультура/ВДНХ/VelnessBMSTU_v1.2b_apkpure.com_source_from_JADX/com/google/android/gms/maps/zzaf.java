package com.google.android.gms.maps;

import com.google.android.gms.maps.StreetViewPanorama.OnStreetViewPanoramaClickListener;
import com.google.android.gms.maps.internal.zzbm;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

final class zzaf extends zzbm {
    private /* synthetic */ OnStreetViewPanoramaClickListener zzith;

    zzaf(StreetViewPanorama streetViewPanorama, OnStreetViewPanoramaClickListener onStreetViewPanoramaClickListener) {
        this.zzith = onStreetViewPanoramaClickListener;
    }

    public final void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        this.zzith.onStreetViewPanoramaClick(streetViewPanoramaOrientation);
    }
}
