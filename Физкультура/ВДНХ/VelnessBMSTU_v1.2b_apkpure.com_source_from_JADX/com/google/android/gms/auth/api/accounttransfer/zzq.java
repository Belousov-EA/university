package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;
import java.util.List;

public final class zzq implements Creator<zzp> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        List list = null;
        int zzd = zzbfn.zzd(parcel);
        int i = 0;
        List list2 = null;
        List list3 = null;
        List list4 = null;
        List list5 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 2:
                    list5 = zzbfn.zzac(parcel, readInt);
                    break;
                case 3:
                    list4 = zzbfn.zzac(parcel, readInt);
                    break;
                case 4:
                    list3 = zzbfn.zzac(parcel, readInt);
                    break;
                case 5:
                    list2 = zzbfn.zzac(parcel, readInt);
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
        return new zzp(i, list5, list4, list3, list2, list);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzp[i];
    }
}
