package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.maps.model.internal.zzw;

public final class TileOverlay {
    private final zzw zzivy;

    public TileOverlay(zzw com_google_android_gms_maps_model_internal_zzw) {
        this.zzivy = (zzw) zzbq.checkNotNull(com_google_android_gms_maps_model_internal_zzw);
    }

    public final void clearTileCache() {
        try {
            this.zzivy.clearTileCache();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TileOverlay)) {
            return false;
        }
        try {
            return this.zzivy.zza(((TileOverlay) obj).zzivy);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean getFadeIn() {
        try {
            return this.zzivy.getFadeIn();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final String getId() {
        try {
            return this.zzivy.getId();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getTransparency() {
        try {
            return this.zzivy.getTransparency();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getZIndex() {
        try {
            return this.zzivy.getZIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int hashCode() {
        try {
            return this.zzivy.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isVisible() {
        try {
            return this.zzivy.isVisible();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void remove() {
        try {
            this.zzivy.remove();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setFadeIn(boolean z) {
        try {
            this.zzivy.setFadeIn(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTransparency(float f) {
        try {
            this.zzivy.setTransparency(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setVisible(boolean z) {
        try {
            this.zzivy.setVisible(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setZIndex(float f) {
        try {
            this.zzivy.setZIndex(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
