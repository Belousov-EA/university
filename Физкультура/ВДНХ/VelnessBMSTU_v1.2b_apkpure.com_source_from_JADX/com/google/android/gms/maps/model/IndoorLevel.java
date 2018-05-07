package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.maps.model.internal.zzm;

public final class IndoorLevel {
    private final zzm zziuz;

    public IndoorLevel(zzm com_google_android_gms_maps_model_internal_zzm) {
        this.zziuz = (zzm) zzbq.checkNotNull(com_google_android_gms_maps_model_internal_zzm);
    }

    public final void activate() {
        try {
            this.zziuz.activate();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof IndoorLevel)) {
            return false;
        }
        try {
            return this.zziuz.zza(((IndoorLevel) obj).zziuz);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final String getName() {
        try {
            return this.zziuz.getName();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final String getShortName() {
        try {
            return this.zziuz.getShortName();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int hashCode() {
        try {
            return this.zziuz.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
