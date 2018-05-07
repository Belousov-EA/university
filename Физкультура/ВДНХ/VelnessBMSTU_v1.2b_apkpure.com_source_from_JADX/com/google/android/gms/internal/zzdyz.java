package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzdyz implements Creator<zzdyy> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        boolean z = false;
        boolean z2 = false;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 3:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 4:
                    str3 = zzbfn.zzq(parcel, readInt);
                    break;
                case 5:
                    str4 = zzbfn.zzq(parcel, readInt);
                    break;
                case 6:
                    str5 = zzbfn.zzq(parcel, readInt);
                    break;
                case 7:
                    str6 = zzbfn.zzq(parcel, readInt);
                    break;
                case 8:
                    str7 = zzbfn.zzq(parcel, readInt);
                    break;
                case 9:
                    str8 = zzbfn.zzq(parcel, readInt);
                    break;
                case 10:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 11:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 12:
                    str9 = zzbfn.zzq(parcel, readInt);
                    break;
                case 13:
                    str10 = zzbfn.zzq(parcel, readInt);
                    break;
                case 14:
                    str11 = zzbfn.zzq(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzdyy(str, str2, str3, str4, str5, str6, str7, str8, z, z2, str9, str10, str11);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdyy[i];
    }
}
