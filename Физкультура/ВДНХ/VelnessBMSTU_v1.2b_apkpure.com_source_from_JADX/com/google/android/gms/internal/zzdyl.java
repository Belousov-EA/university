package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzdyl implements Creator<zzdyk> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        String str = null;
        String str2 = null;
        boolean z = false;
        String str3 = null;
        String str4 = null;
        zzdyq com_google_android_gms_internal_zzdyq = null;
        String str5 = null;
        String str6 = null;
        long j = 0;
        long j2 = 0;
        boolean z2 = false;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 3:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 4:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 5:
                    str3 = zzbfn.zzq(parcel, readInt);
                    break;
                case 6:
                    str4 = zzbfn.zzq(parcel, readInt);
                    break;
                case 7:
                    com_google_android_gms_internal_zzdyq = (zzdyq) zzbfn.zza(parcel, readInt, zzdyq.CREATOR);
                    break;
                case 8:
                    str5 = zzbfn.zzq(parcel, readInt);
                    break;
                case 9:
                    str6 = zzbfn.zzq(parcel, readInt);
                    break;
                case 10:
                    j = zzbfn.zzi(parcel, readInt);
                    break;
                case 11:
                    j2 = zzbfn.zzi(parcel, readInt);
                    break;
                case 12:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzdyk(str, str2, z, str3, str4, com_google_android_gms_internal_zzdyq, str5, str6, j, j2, z2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdyk[i];
    }
}
