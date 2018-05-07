package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class CameraUpdateFactory {
    private static ICameraUpdateFactoryDelegate zziqx;

    private CameraUpdateFactory() {
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        try {
            return new CameraUpdate(zzawa().newCameraPosition(cameraPosition));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        try {
            return new CameraUpdate(zzawa().newLatLng(latLng));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i) {
        try {
            return new CameraUpdate(zzawa().newLatLngBounds(latLngBounds, i));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3) {
        try {
            return new CameraUpdate(zzawa().newLatLngBoundsWithSize(latLngBounds, i, i2, i3));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f) {
        try {
            return new CameraUpdate(zzawa().newLatLngZoom(latLng, f));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate scrollBy(float f, float f2) {
        try {
            return new CameraUpdate(zzawa().scrollBy(f, f2));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate zoomBy(float f) {
        try {
            return new CameraUpdate(zzawa().zoomBy(f));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate zoomBy(float f, Point point) {
        try {
            return new CameraUpdate(zzawa().zoomByWithFocus(f, point.x, point.y));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate zoomIn() {
        try {
            return new CameraUpdate(zzawa().zoomIn());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate zoomOut() {
        try {
            return new CameraUpdate(zzawa().zoomOut());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static CameraUpdate zoomTo(float f) {
        try {
            return new CameraUpdate(zzawa().zoomTo(f));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static void zza(ICameraUpdateFactoryDelegate iCameraUpdateFactoryDelegate) {
        zziqx = (ICameraUpdateFactoryDelegate) zzbq.checkNotNull(iCameraUpdateFactoryDelegate);
    }

    private static ICameraUpdateFactoryDelegate zzawa() {
        return (ICameraUpdateFactoryDelegate) zzbq.checkNotNull(zziqx, "CameraUpdateFactory is not initialized");
    }
}
