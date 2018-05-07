package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap.OnPolylineClickListener;
import com.google.android.gms.maps.internal.zzbg;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;

final class zzq extends zzbg {
    private /* synthetic */ OnPolylineClickListener zzirq;

    zzq(GoogleMap googleMap, OnPolylineClickListener onPolylineClickListener) {
        this.zzirq = onPolylineClickListener;
    }

    public final void zza(IPolylineDelegate iPolylineDelegate) {
        this.zzirq.onPolylineClick(new Polyline(iPolylineDelegate));
    }
}
