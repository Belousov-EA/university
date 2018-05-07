package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzbgs implements Creator<zzbgv> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        zzbgo com_google_android_gms_internal_zzbgo = null;
        int zzd = zzbfn.zzd(parcel);
        int i = 0;
        String str = null;
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
                    com_google_android_gms_internal_zzbgo = (zzbgo) zzbfn.zza(parcel, readInt, zzbgo.CREATOR);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzbgv(i, str, com_google_android_gms_internal_zzbgo);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbgv[i];
    }
}
