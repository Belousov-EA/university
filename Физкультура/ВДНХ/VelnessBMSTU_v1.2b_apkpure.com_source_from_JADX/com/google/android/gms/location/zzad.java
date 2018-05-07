package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zzad implements Creator<LocationSettingsStates> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzd = zzbfn.zzd(parcel);
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    z6 = zzbfn.zzc(parcel, readInt);
                    break;
                case 2:
                    z5 = zzbfn.zzc(parcel, readInt);
                    break;
                case 3:
                    z4 = zzbfn.zzc(parcel, readInt);
                    break;
                case 4:
                    z3 = zzbfn.zzc(parcel, readInt);
                    break;
                case 5:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 6:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new LocationSettingsStates(z6, z5, z4, z3, z2, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new LocationSettingsStates[i];
    }
}
