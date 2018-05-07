package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zzm implements Creator<StreetViewPanoramaCamera> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        float f = 0.0f;
        int zzd = zzbfn.zzd(parcel);
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    f3 = zzbfn.zzl(parcel, readInt);
                    break;
                case 3:
                    f2 = zzbfn.zzl(parcel, readInt);
                    break;
                case 4:
                    f = zzbfn.zzl(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new StreetViewPanoramaCamera(f3, f2, f);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new StreetViewPanoramaCamera[i];
    }
}
