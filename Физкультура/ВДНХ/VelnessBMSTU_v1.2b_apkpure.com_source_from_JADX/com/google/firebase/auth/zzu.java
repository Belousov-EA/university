package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zzu implements Creator<UserProfileChangeRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        String str2 = null;
        boolean z2 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 3:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 4:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 5:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new UserProfileChangeRequest(str2, str, z2, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new UserProfileChangeRequest[i];
    }
}
