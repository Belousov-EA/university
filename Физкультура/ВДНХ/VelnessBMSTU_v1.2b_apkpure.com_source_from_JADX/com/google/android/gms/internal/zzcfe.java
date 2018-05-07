package com.google.android.gms.internal;

import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzq;

final class zzcfe extends zzq {
    private final zzci<LocationCallback> zzfus;

    zzcfe(zzci<LocationCallback> com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationCallback) {
        this.zzfus = com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationCallback;
    }

    public final void onLocationAvailability(LocationAvailability locationAvailability) {
        this.zzfus.zza(new zzcfg(this, locationAvailability));
    }

    public final void onLocationResult(LocationResult locationResult) {
        this.zzfus.zza(new zzcff(this, locationResult));
    }

    public final synchronized void release() {
        this.zzfus.clear();
    }
}
