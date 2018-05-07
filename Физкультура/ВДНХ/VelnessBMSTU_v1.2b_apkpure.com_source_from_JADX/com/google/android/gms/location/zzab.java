package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;
import java.util.List;

public final class zzab implements Creator<LocationSettingsRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        zzz com_google_android_gms_location_zzz = null;
        boolean z = false;
        int zzd = zzbfn.zzd(parcel);
        boolean z2 = false;
        List list = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    list = zzbfn.zzc(parcel, readInt, LocationRequest.CREATOR);
                    break;
                case 2:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 3:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 5:
                    com_google_android_gms_location_zzz = (zzz) zzbfn.zza(parcel, readInt, zzz.CREATOR);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new LocationSettingsRequest(list, z2, z, com_google_android_gms_location_zzz);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationSettingsRequest[i];
    }
}
