package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener;

final class zzu extends com.google.android.gms.maps.internal.zzu {
    private /* synthetic */ OnCameraMoveStartedListener zziru;

    zzu(GoogleMap googleMap, OnCameraMoveStartedListener onCameraMoveStartedListener) {
        this.zziru = onCameraMoveStartedListener;
    }

    public final void onCameraMoveStarted(int i) {
        this.zziru.onCameraMoveStarted(i);
    }
}
