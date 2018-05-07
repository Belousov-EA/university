package com.google.android.gms.maps.model;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import java.util.List;

public final class Polyline {
    private final IPolylineDelegate zzivs;

    public Polyline(IPolylineDelegate iPolylineDelegate) {
        this.zzivs = (IPolylineDelegate) zzbq.checkNotNull(iPolylineDelegate);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Polyline)) {
            return false;
        }
        try {
            return this.zzivs.equalsRemote(((Polyline) obj).zzivs);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getColor() {
        try {
            return this.zzivs.getColor();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @NonNull
    public final Cap getEndCap() {
        try {
            return this.zzivs.getEndCap().zzawf();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final String getId() {
        try {
            return this.zzivs.getId();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getJointType() {
        try {
            return this.zzivs.getJointType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Nullable
    public final List<PatternItem> getPattern() {
        try {
            return PatternItem.zzag(this.zzivs.getPattern());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final List<LatLng> getPoints() {
        try {
            return this.zzivs.getPoints();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @NonNull
    public final Cap getStartCap() {
        try {
            return this.zzivs.getStartCap().zzawf();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Nullable
    public final Object getTag() {
        try {
            return zzn.zzx(this.zzivs.getTag());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getWidth() {
        try {
            return this.zzivs.getWidth();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getZIndex() {
        try {
            return this.zzivs.getZIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int hashCode() {
        try {
            return this.zzivs.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isClickable() {
        try {
            return this.zzivs.isClickable();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isGeodesic() {
        try {
            return this.zzivs.isGeodesic();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isVisible() {
        try {
            return this.zzivs.isVisible();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void remove() {
        try {
            this.zzivs.remove();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setClickable(boolean z) {
        try {
            this.zzivs.setClickable(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setColor(int i) {
        try {
            this.zzivs.setColor(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setEndCap(@NonNull Cap cap) {
        zzbq.checkNotNull(cap, "endCap must not be null");
        try {
            this.zzivs.setEndCap(cap);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setGeodesic(boolean z) {
        try {
            this.zzivs.setGeodesic(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setJointType(int i) {
        try {
            this.zzivs.setJointType(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setPattern(@Nullable List<PatternItem> list) {
        try {
            this.zzivs.setPattern(list);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setPoints(List<LatLng> list) {
        try {
            this.zzivs.setPoints(list);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setStartCap(@NonNull Cap cap) {
        zzbq.checkNotNull(cap, "startCap must not be null");
        try {
            this.zzivs.setStartCap(cap);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTag(@Nullable Object obj) {
        try {
            this.zzivs.setTag(zzn.zzz(obj));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setVisible(boolean z) {
        try {
            this.zzivs.setVisible(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setWidth(float f) {
        try {
            this.zzivs.setWidth(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setZIndex(float f) {
        try {
            this.zzivs.setZIndex(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
