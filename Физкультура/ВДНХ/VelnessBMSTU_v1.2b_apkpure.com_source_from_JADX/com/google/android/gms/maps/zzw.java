package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap.OnCameraMoveCanceledListener;
import com.google.android.gms.maps.internal.zzq;

final class zzw extends zzq {
    private /* synthetic */ OnCameraMoveCanceledListener zzirw;

    zzw(GoogleMap googleMap, OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        this.zzirw = onCameraMoveCanceledListener;
    }

    public final void onCameraMoveCanceled() {
        this.zzirw.onCameraMoveCanceled();
    }
}
