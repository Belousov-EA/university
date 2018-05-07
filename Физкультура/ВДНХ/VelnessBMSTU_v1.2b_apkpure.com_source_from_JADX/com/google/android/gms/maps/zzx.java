package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap.OnCameraIdleListener;
import com.google.android.gms.maps.internal.zzo;

final class zzx extends zzo {
    private /* synthetic */ OnCameraIdleListener zzirx;

    zzx(GoogleMap googleMap, OnCameraIdleListener onCameraIdleListener) {
        this.zzirx = onCameraIdleListener;
    }

    public final void onCameraIdle() {
        this.zzirx.onCameraIdle();
    }
}
