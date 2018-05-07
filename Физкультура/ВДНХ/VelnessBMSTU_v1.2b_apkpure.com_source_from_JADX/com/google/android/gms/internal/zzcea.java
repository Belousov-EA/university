package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzcea implements Creator<zzcdz> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        IBinder iBinder = null;
        zzcdx com_google_android_gms_internal_zzcdx = null;
        int i = 1;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 2:
                    com_google_android_gms_internal_zzcdx = (zzcdx) zzbfn.zza(parcel, readInt, zzcdx.CREATOR);
                    break;
                case 3:
                    iBinder = zzbfn.zzr(parcel, readInt);
                    break;
                case 4:
                    iBinder2 = zzbfn.zzr(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzcdz(i, com_google_android_gms_internal_zzcdx, iBinder, iBinder2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcdz[i];
    }
}
