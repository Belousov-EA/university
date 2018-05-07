package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.internal.zzm;
import com.google.android.gms.maps.model.CameraPosition;

final class zzt extends zzm {
    private /* synthetic */ OnCameraChangeListener zzirt;

    zzt(GoogleMap googleMap, OnCameraChangeListener onCameraChangeListener) {
        this.zzirt = onCameraChangeListener;
    }

    public final void onCameraChange(CameraPosition cameraPosition) {
        this.zzirt.onCameraChange(cameraPosition);
    }
}
