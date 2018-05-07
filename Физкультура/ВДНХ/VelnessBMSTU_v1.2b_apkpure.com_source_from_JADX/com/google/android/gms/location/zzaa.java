package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zzaa implements Creator<zzz> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        String str = "";
        String str2 = "";
        String str3 = "";
        int i = 0;
        boolean z = true;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 2:
                    str3 = zzbfn.zzq(parcel, readInt);
                    break;
                case 3:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 4:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 5:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzz(str, str2, str3, i, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzz[i];
    }
}
