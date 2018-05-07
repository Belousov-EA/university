package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzdyn implements Creator<zzdym> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Long l = null;
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        Long l2 = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    str3 = zzbfn.zzq(parcel, readInt);
                    break;
                case 3:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 4:
                    l2 = zzbfn.zzj(parcel, readInt);
                    break;
                case 5:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 6:
                    l = zzbfn.zzj(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzdym(str3, str2, l2, str, l);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdym[i];
    }
}
