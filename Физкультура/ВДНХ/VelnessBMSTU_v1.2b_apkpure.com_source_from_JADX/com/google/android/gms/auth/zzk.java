package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;
import java.util.List;

public final class zzk implements Creator<TokenData> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        List list = null;
        boolean z = false;
        int zzd = zzbfn.zzd(parcel);
        boolean z2 = false;
        Long l = null;
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 2:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 3:
                    l = zzbfn.zzj(parcel, readInt);
                    break;
                case 4:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 5:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 6:
                    list = zzbfn.zzac(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new TokenData(i, str, l, z2, z, list);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new TokenData[i];
    }
}
