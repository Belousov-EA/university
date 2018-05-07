package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zzaf implements Creator<zzae> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        long j = -1;
        int i = 1;
        int zzd = zzbfn.zzd(parcel);
        long j2 = -1;
        int i2 = 1;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i2 = zzbfn.zzg(parcel, readInt);
                    break;
                case 2:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 3:
                    j2 = zzbfn.zzi(parcel, readInt);
                    break;
                case 4:
                    j = zzbfn.zzi(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzae(i2, i, j2, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzae[i];
    }
}
