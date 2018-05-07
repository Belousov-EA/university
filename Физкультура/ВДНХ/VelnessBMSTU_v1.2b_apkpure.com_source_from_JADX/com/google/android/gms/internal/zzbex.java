package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzbex implements Creator<zzbew> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzd = zzbfn.zzd(parcel);
        boolean z = true;
        boolean z2 = false;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        int i3 = 0;
        String str4 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    str4 = zzbfn.zzq(parcel, readInt);
                    break;
                case 3:
                    i3 = zzbfn.zzg(parcel, readInt);
                    break;
                case 4:
                    i2 = zzbfn.zzg(parcel, readInt);
                    break;
                case 5:
                    str3 = zzbfn.zzq(parcel, readInt);
                    break;
                case 6:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 7:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 8:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 9:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 10:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzbew(str4, i3, i2, str3, str2, z, str, z2, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbew[i];
    }
}
