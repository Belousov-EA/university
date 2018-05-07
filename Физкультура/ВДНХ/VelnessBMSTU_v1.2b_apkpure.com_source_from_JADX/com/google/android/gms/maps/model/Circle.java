package com.google.android.gms.maps.model;

import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.maps.model.internal.zzd;
import java.util.List;

public final class Circle {
    private final zzd zziuj;

    public Circle(zzd com_google_android_gms_maps_model_internal_zzd) {
        this.zziuj = (zzd) zzbq.checkNotNull(com_google_android_gms_maps_model_internal_zzd);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Circle)) {
            return false;
        }
        try {
            return this.zziuj.zzb(((Circle) obj).zziuj);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final LatLng getCenter() {
        try {
            return this.zziuj.getCenter();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getFillColor() {
        try {
            return this.zziuj.getFillColor();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final String getId() {
        try {
            return this.zziuj.getId();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final double getRadius() {
        try {
            return this.zziuj.getRadius();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getStrokeColor() {
        try {
            return this.zziuj.getStrokeColor();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Nullable
    public final List<PatternItem> getStrokePattern() {
        try {
            return PatternItem.zzag(this.zziuj.getStrokePattern());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getStrokeWidth() {
        try {
            return this.zziuj.getStrokeWidth();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Nullable
    public final Object getTag() {
        try {
            return zzn.zzx(this.zziuj.getTag());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getZIndex() {
        try {
            return this.zziuj.getZIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int hashCode() {
        try {
            return this.zziuj.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isClickable() {
        try {
            return this.zziuj.isClickable();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isVisible() {
        try {
            return this.zziuj.isVisible();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void remove() {
        try {
            this.zziuj.remove();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setCenter(LatLng latLng) {
        try {
            this.zziuj.setCenter(latLng);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setClickable(boolean z) {
        try {
            this.zziuj.setClickable(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setFillColor(int i) {
        try {
            this.zziuj.setFillColor(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setRadius(double d) {
        try {
            this.zziuj.setRadius(d);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setStrokeColor(int i) {
        try {
            this.zziuj.setStrokeColor(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setStrokePattern(@Nullable List<PatternItem> list) {
        try {
            this.zziuj.setStrokePattern(list);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setStrokeWidth(float f) {
        try {
            this.zziuj.setStrokeWidth(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTag(@Nullable Object obj) {
        try {
            this.zziuj.setTag(zzn.zzz(obj));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setVisible(boolean z) {
        try {
            this.zziuj.setVisible(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setZIndex(float f) {
        try {
            this.zziuj.setZIndex(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
