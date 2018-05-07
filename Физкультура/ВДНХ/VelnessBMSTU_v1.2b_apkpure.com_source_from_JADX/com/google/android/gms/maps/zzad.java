package com.google.android.gms.maps;

import com.google.android.gms.maps.StreetViewPanorama.OnStreetViewPanoramaChangeListener;
import com.google.android.gms.maps.internal.zzbk;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

final class zzad extends zzbk {
    private /* synthetic */ OnStreetViewPanoramaChangeListener zzitf;

    zzad(StreetViewPanorama streetViewPanorama, OnStreetViewPanoramaChangeListener onStreetViewPanoramaChangeListener) {
        this.zzitf = onStreetViewPanoramaChangeListener;
    }

    public final void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation) {
        this.zzitf.onStreetViewPanoramaChange(streetViewPanoramaLocation);
    }
}
