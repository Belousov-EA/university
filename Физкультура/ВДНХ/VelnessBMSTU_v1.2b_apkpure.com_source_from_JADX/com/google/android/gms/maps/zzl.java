package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.ILocationSourceDelegate.zza;
import com.google.android.gms.maps.internal.zzah;

final class zzl extends zza {
    private /* synthetic */ LocationSource zzirl;

    zzl(GoogleMap googleMap, LocationSource locationSource) {
        this.zzirl = locationSource;
    }

    public final void activate(zzah com_google_android_gms_maps_internal_zzah) {
        this.zzirl.activate(new zzm(this, com_google_android_gms_maps_internal_zzah));
    }

    public final void deactivate() {
        this.zzirl.deactivate();
    }
}
