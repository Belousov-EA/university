package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap.OnPolygonClickListener;
import com.google.android.gms.maps.internal.zzbe;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.internal.zzs;

final class zzp extends zzbe {
    private /* synthetic */ OnPolygonClickListener zzirp;

    zzp(GoogleMap googleMap, OnPolygonClickListener onPolygonClickListener) {
        this.zzirp = onPolygonClickListener;
    }

    public final void zza(zzs com_google_android_gms_maps_model_internal_zzs) {
        this.zzirp.onPolygonClick(new Polygon(com_google_android_gms_maps_model_internal_zzs));
    }
}
