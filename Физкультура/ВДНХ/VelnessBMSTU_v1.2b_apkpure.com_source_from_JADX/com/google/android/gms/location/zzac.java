package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzbfn;

public final class zzac implements Creator<LocationSettingsResult> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        LocationSettingsStates locationSettingsStates = null;
        Status status = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    status = (Status) zzbfn.zza(parcel, readInt, Status.CREATOR);
                    break;
                case 2:
                    locationSettingsStates = (LocationSettingsStates) zzbfn.zza(parcel, readInt, LocationSettingsStates.CREATOR);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new LocationSettingsResult(status, locationSettingsStates);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationSettingsResult[i];
    }
}
