package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zzw implements Creator<DeviceMetaData> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzd = zzbfn.zzd(parcel);
        long j = 0;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 2:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 3:
                    j = zzbfn.zzi(parcel, readInt);
                    break;
                case 4:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new DeviceMetaData(i, z2, j, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new DeviceMetaData[i];
    }
}
