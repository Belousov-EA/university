package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.maps.internal.IProjectionDelegate;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.VisibleRegion;

public final class Projection {
    private final IProjectionDelegate zzitd;

    Projection(IProjectionDelegate iProjectionDelegate) {
        this.zzitd = iProjectionDelegate;
    }

    public final LatLng fromScreenLocation(Point point) {
        try {
            return this.zzitd.fromScreenLocation(zzn.zzz(point));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final VisibleRegion getVisibleRegion() {
        try {
            return this.zzitd.getVisibleRegion();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Point toScreenLocation(LatLng latLng) {
        try {
            return (Point) zzn.zzx(this.zzitd.toScreenLocation(latLng));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
