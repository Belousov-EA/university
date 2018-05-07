package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.location.zze;
import java.util.List;

public final class zzcdy implements Creator<zzcdx> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        zze com_google_android_gms_location_zze = zzcdx.zzikw;
        List list = zzcdx.zzikv;
        String str = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    com_google_android_gms_location_zze = (zze) zzbfn.zza(parcel, readInt, zze.CREATOR);
                    break;
                case 2:
                    list = zzbfn.zzc(parcel, readInt, zzcdv.CREATOR);
                    break;
                case 3:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzcdx(com_google_android_gms_location_zze, list, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcdx[i];
    }
}
