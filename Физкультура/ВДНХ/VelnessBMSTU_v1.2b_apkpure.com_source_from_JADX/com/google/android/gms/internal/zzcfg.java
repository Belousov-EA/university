package com.google.android.gms.internal;

import com.google.android.gms.common.api.internal.zzcl;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;

final class zzcfg implements zzcl<LocationCallback> {
    private /* synthetic */ LocationAvailability zzils;

    zzcfg(zzcfe com_google_android_gms_internal_zzcfe, LocationAvailability locationAvailability) {
        this.zzils = locationAvailability;
    }

    public final void zzahz() {
    }

    public final /* synthetic */ void zzu(Object obj) {
        ((LocationCallback) obj).onLocationAvailability(this.zzils);
    }
}
