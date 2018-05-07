package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.zzn;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.location.LocationSettingsResult;

final class zzcfn extends zzcfc {
    private zzn<LocationSettingsResult> zzilv;

    public zzcfn(zzn<LocationSettingsResult> com_google_android_gms_common_api_internal_zzn_com_google_android_gms_location_LocationSettingsResult) {
        zzbq.checkArgument(com_google_android_gms_common_api_internal_zzn_com_google_android_gms_location_LocationSettingsResult != null, "listener can't be null.");
        this.zzilv = com_google_android_gms_common_api_internal_zzn_com_google_android_gms_location_LocationSettingsResult;
    }

    public final void zza(LocationSettingsResult locationSettingsResult) throws RemoteException {
        this.zzilv.setResult(locationSettingsResult);
        this.zzilv = null;
    }
}
