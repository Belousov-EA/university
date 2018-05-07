package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.zzt;

final class zzcfi extends zzt {
    private final zzci<LocationListener> zzfus;

    zzcfi(zzci<LocationListener> com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationListener) {
        this.zzfus = com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationListener;
    }

    public final synchronized void onLocationChanged(Location location) {
        this.zzfus.zza(new zzcfj(this, location));
    }

    public final synchronized void release() {
        this.zzfus.clear();
    }
}
