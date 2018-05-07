package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import java.util.ArrayList;

public final class zzbgw implements Creator<zzbgt> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int zzd = zzbfn.zzd(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 2:
                    arrayList = zzbfn.zzc(parcel, readInt, zzbgu.CREATOR);
                    break;
                case 3:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzbgt(i, arrayList, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbgt[i];
    }
}
