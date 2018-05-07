package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap.OnCameraMoveListener;
import com.google.android.gms.maps.internal.zzs;

final class zzv extends zzs {
    private /* synthetic */ OnCameraMoveListener zzirv;

    zzv(GoogleMap googleMap, OnCameraMoveListener onCameraMoveListener) {
        this.zzirv = onCameraMoveListener;
    }

    public final void onCameraMove() {
        this.zzirv.onCameraMove();
    }
}
