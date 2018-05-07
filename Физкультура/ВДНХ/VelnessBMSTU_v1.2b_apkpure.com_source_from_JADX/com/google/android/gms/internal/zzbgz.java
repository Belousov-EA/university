package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzbgz implements Creator<zzbgy> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        zzbgt com_google_android_gms_internal_zzbgt = null;
        int zzd = zzbfn.zzd(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 2:
                    parcel2 = zzbfn.zzad(parcel, readInt);
                    break;
                case 3:
                    com_google_android_gms_internal_zzbgt = (zzbgt) zzbfn.zza(parcel, readInt, zzbgt.CREATOR);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzbgy(i, parcel2, com_google_android_gms_internal_zzbgt);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbgy[i];
    }
}
