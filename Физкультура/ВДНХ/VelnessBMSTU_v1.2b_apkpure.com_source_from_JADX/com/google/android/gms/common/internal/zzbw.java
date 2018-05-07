package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzbfn;

public final class zzbw implements Creator<zzbv> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int zzd = zzbfn.zzd(parcel);
        Scope[] scopeArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i3 = zzbfn.zzg(parcel, readInt);
                    break;
                case 2:
                    i2 = zzbfn.zzg(parcel, readInt);
                    break;
                case 3:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 4:
                    scopeArr = (Scope[]) zzbfn.zzb(parcel, readInt, Scope.CREATOR);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzbv(i3, i2, i, scopeArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbv[i];
    }
}
