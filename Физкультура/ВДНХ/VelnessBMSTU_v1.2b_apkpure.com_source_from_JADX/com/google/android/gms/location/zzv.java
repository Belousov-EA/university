package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zzv implements Creator<LocationAvailability> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 1;
        int zzd = zzbfn.zzd(parcel);
        int i2 = 1000;
        long j = 0;
        zzae[] com_google_android_gms_location_zzaeArr = null;
        int i3 = 1;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i3 = zzbfn.zzg(parcel, readInt);
                    break;
                case 2:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 3:
                    j = zzbfn.zzi(parcel, readInt);
                    break;
                case 4:
                    i2 = zzbfn.zzg(parcel, readInt);
                    break;
                case 5:
                    com_google_android_gms_location_zzaeArr = (zzae[]) zzbfn.zzb(parcel, readInt, zzae.CREATOR);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new LocationAvailability(i2, i3, i, j, com_google_android_gms_location_zzaeArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationAvailability[i];
    }
}
