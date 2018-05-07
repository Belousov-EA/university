package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.maps.model.internal.zzj;
import com.google.android.gms.maps.model.internal.zzn;
import java.util.ArrayList;
import java.util.List;

public final class IndoorBuilding {
    private final zzj zziuy;

    public IndoorBuilding(zzj com_google_android_gms_maps_model_internal_zzj) {
        this.zziuy = (zzj) zzbq.checkNotNull(com_google_android_gms_maps_model_internal_zzj);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof IndoorBuilding)) {
            return false;
        }
        try {
            return this.zziuy.zzb(((IndoorBuilding) obj).zziuy);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getActiveLevelIndex() {
        try {
            return this.zziuy.getActiveLevelIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getDefaultLevelIndex() {
        try {
            return this.zziuy.getActiveLevelIndex();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final List<IndoorLevel> getLevels() {
        try {
            List<IBinder> levels = this.zziuy.getLevels();
            List<IndoorLevel> arrayList = new ArrayList(levels.size());
            for (IBinder zzbj : levels) {
                arrayList.add(new IndoorLevel(zzn.zzbj(zzbj)));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int hashCode() {
        try {
            return this.zziuy.hashCodeRemote();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isUnderground() {
        try {
            return this.zziuy.isUnderground();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
