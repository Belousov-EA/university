package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zza implements Creator<AccountChangeEvent> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzd = zzbfn.zzd(parcel);
        long j = 0;
        int i2 = 0;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i3 = zzbfn.zzg(parcel, readInt);
                    break;
                case 2:
                    j = zzbfn.zzi(parcel, readInt);
                    break;
                case 3:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 4:
                    i2 = zzbfn.zzg(parcel, readInt);
                    break;
                case 5:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 6:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new AccountChangeEvent(i3, j, str2, i2, i, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new AccountChangeEvent[i];
    }
}
