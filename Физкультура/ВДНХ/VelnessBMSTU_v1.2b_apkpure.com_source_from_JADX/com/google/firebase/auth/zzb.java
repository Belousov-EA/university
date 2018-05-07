package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zzb implements Creator<ActionCodeSettings> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzd = zzbfn.zzd(parcel);
        boolean z = false;
        String str2 = null;
        boolean z2 = false;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    str6 = zzbfn.zzq(parcel, readInt);
                    break;
                case 2:
                    str5 = zzbfn.zzq(parcel, readInt);
                    break;
                case 3:
                    str4 = zzbfn.zzq(parcel, readInt);
                    break;
                case 4:
                    str3 = zzbfn.zzq(parcel, readInt);
                    break;
                case 5:
                    z2 = zzbfn.zzc(parcel, readInt);
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
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new ActionCodeSettings(str6, str5, str4, str3, z2, str2, z, str, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ActionCodeSettings[i];
    }
}
