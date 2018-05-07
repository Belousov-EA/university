package com.google.android.gms.maps.model;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.maps.model.internal.zzg;

public final class GroundOverlay {
    private final zzg zziuq;

    public GroundOverlay(zzg com_google_android_gms_maps_model_internal_zzg) {
        this.zziuq = (zzg) zzbq.checkNotNull(com_google_android_gms_maps_model_internal_zzg);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof GroundOverlay)) {
            return false;
        }
        try {
            return this.zziuq.zzb(((GroundOverlay) obj).zziuq);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getBearing() {
        try {
            return this.zziuq.getBearing();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final LatLngBounds getBounds() {
        try {
            return this.zziuq.getBounds();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getHeight() {
        try {
            return this.zziuq.getHeight();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final String getId() {
        try {
            return this.zziuq.getId();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final LatLng getPosition() {
        try {
            return this.zziuq.getPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Object getTag() {
        try {
            return zzn.zzx(this.zziuq.getTag());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getTransparency() {
        try {
            return this.zziuq.getTransparency();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getWidth() {
        try {
            return this.zziuq.getWidth();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getZIndex() {
        try {
            return this.zziuq.getZIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int hashCode() {
        try {
            return this.zziuq.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isClickable() {
        try {
            return this.zziuq.isClickable();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isVisible() {
        try {
            return this.zziuq.isVisible();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void remove() {
        try {
            this.zziuq.remove();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBearing(float f) {
        try {
            this.zziuq.setBearing(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setClickable(boolean z) {
        try {
            this.zziuq.setClickable(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setDimensions(float f) {
        try {
            this.zziuq.setDimensions(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setDimensions(float f, float f2) {
        try {
            this.zziuq.zzf(f, f2);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setImage(@NonNull BitmapDescriptor bitmapDescriptor) {
        zzbq.checkNotNull(bitmapDescriptor, "imageDescriptor must not be null");
        try {
            this.zziuq.zzac(bitmapDescriptor.zzavz());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setPosition(LatLng latLng) {
        try {
            this.zziuq.setPosition(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setPositionFromBounds(LatLngBounds latLngBounds) {
        try {
            this.zziuq.setPositionFromBounds(latLngBounds);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTag(Object obj) {
        try {
            this.zziuq.setTag(zzn.zzz(obj));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTransparency(float f) {
        try {
            this.zziuq.setTransparency(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setVisible(boolean z) {
        try {
            this.zziuq.setVisible(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setZIndex(float f) {
        try {
            this.zziuq.setZIndex(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
