package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzbgi implements Creator<zzbgh> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        int i = 0;
        zzbgj com_google_android_gms_internal_zzbgj = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 2:
                    com_google_android_gms_internal_zzbgj = (zzbgj) zzbfn.zza(parcel, readInt, zzbgj.CREATOR);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzbgh(i, com_google_android_gms_internal_zzbgj);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbgh[i];
    }
}
