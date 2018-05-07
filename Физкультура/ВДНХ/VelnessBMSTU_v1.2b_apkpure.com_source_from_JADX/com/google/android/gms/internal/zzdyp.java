package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzdyp implements Creator<zzdyo> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int zzd = zzbfn.zzd(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    str7 = zzbfn.zzq(parcel, readInt);
                    break;
                case 3:
                    str6 = zzbfn.zzq(parcel, readInt);
                    break;
                case 4:
                    str5 = zzbfn.zzq(parcel, readInt);
                    break;
                case 5:
                    str4 = zzbfn.zzq(parcel, readInt);
                    break;
                case 6:
                    str3 = zzbfn.zzq(parcel, readInt);
                    break;
                case 7:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 8:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzdyo(str7, str6, str5, str4, str3, str2, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdyo[i];
    }
}
