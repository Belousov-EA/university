package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class LocationSettingsResult extends zzbfm implements Result {
    public static final Creator<LocationSettingsResult> CREATOR = new zzac();
    private final Status mStatus;
    private final LocationSettingsStates zzike;

    public LocationSettingsResult(Status status) {
        this(status, null);
    }

    public LocationSettingsResult(Status status, LocationSettingsStates locationSettingsStates) {
        this.mStatus = status;
        this.zzike = locationSettingsStates;
    }

    public final LocationSettingsStates getLocationSettingsStates() {
        return this.zzike;
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, getStatus(), i, false);
        zzbfp.zza(parcel, 2, getLocationSettingsStates(), i, false);
        zzbfp.zzai(parcel, zze);
    }
}
