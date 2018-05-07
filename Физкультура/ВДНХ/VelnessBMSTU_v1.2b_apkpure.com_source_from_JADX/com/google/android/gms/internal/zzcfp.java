package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public final class zzcfp implements Creator<zzcfo> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzd = zzbfn.zzd(parcel);
        List list = zzcfo.zzikv;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        LocationRequest locationRequest = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    locationRequest = (LocationRequest) zzbfn.zza(parcel, readInt, LocationRequest.CREATOR);
                    break;
                case 5:
                    list = zzbfn.zzc(parcel, readInt, zzcdv.CREATOR);
                    break;
                case 6:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 7:
                    z3 = zzbfn.zzc(parcel, readInt);
                    break;
                case 8:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 9:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 10:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzcfo(locationRequest, list, str2, z3, z2, z, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcfo[i];
    }
}
