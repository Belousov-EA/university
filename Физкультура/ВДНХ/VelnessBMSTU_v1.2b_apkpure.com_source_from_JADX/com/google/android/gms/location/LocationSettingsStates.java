package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzbfr;

public final class LocationSettingsStates extends zzbfm {
    public static final Creator<LocationSettingsStates> CREATOR = new zzad();
    private final boolean zzikf;
    private final boolean zzikg;
    private final boolean zzikh;
    private final boolean zziki;
    private final boolean zzikj;
    private final boolean zzikk;

    public LocationSettingsStates(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.zzikf = z;
        this.zzikg = z2;
        this.zzikh = z3;
        this.zziki = z4;
        this.zzikj = z5;
        this.zzikk = z6;
    }

    public static LocationSettingsStates fromIntent(Intent intent) {
        return (LocationSettingsStates) zzbfr.zza(intent, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", CREATOR);
    }

    public final boolean isBlePresent() {
        return this.zzikk;
    }

    public final boolean isBleUsable() {
        return this.zzikh;
    }

    public final boolean isGpsPresent() {
        return this.zziki;
    }

    public final boolean isGpsUsable() {
        return this.zzikf;
    }

    public final boolean isLocationPresent() {
        return this.zziki || this.zzikj;
    }

    public final boolean isLocationUsable() {
        return this.zzikf || this.zzikg;
    }

    public final boolean isNetworkLocationPresent() {
        return this.zzikj;
    }

    public final boolean isNetworkLocationUsable() {
        return this.zzikg;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, isGpsUsable());
        zzbfp.zza(parcel, 2, isNetworkLocationUsable());
        zzbfp.zza(parcel, 3, isBleUsable());
        zzbfp.zza(parcel, 4, isGpsPresent());
        zzbfp.zza(parcel, 5, isNetworkLocationPresent());
        zzbfp.zza(parcel, 6, isBlePresent());
        zzbfp.zzai(parcel, zze);
    }
}
