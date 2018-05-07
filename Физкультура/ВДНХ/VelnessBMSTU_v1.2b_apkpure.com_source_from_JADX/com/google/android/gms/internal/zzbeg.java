package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzbeg implements Creator<zzbef> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        long j = 0;
        int zzd = zzbfn.zzd(parcel);
        boolean z = false;
        long j2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 2:
                    j = zzbfn.zzi(parcel, readInt);
                    break;
                case 3:
                    j2 = zzbfn.zzi(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzbef(z, j2, j);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbef[i];
    }
}
