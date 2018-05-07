package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.common.api.internal.zzcl;
import com.google.android.gms.location.LocationListener;

final class zzcfj implements zzcl<LocationListener> {
    private /* synthetic */ Location zzilt;

    zzcfj(zzcfi com_google_android_gms_internal_zzcfi, Location location) {
        this.zzilt = location;
    }

    public final void zzahz() {
    }

    public final /* synthetic */ void zzu(Object obj) {
        ((LocationListener) obj).onLocationChanged(this.zzilt);
    }
}
