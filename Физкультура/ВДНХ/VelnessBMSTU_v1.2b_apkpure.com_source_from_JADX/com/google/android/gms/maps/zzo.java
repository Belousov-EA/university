package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap.OnCircleClickListener;
import com.google.android.gms.maps.internal.zzw;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.internal.zzd;

final class zzo extends zzw {
    private /* synthetic */ OnCircleClickListener zziro;

    zzo(GoogleMap googleMap, OnCircleClickListener onCircleClickListener) {
        this.zziro = onCircleClickListener;
    }

    public final void zza(zzd com_google_android_gms_maps_model_internal_zzd) {
        this.zziro.onCircleClick(new Circle(com_google_android_gms_maps_model_internal_zzd));
    }
}
