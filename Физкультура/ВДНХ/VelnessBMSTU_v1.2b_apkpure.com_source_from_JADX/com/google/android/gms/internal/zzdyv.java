package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzdyv implements Creator<zzdyu> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int zzd = zzbfn.zzd(parcel);
        long j = 0;
        boolean z = false;
        String str2 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 2:
                    j = zzbfn.zzi(parcel, readInt);
                    break;
                case 3:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 4:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzdyu(str2, j, z, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdyu[i];
    }
}
