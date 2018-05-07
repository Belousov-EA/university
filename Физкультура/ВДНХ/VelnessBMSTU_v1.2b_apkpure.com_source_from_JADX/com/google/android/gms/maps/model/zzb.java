package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zzb implements Creator<Cap> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Float f = null;
        int zzd = zzbfn.zzd(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 3:
                    iBinder = zzbfn.zzr(parcel, readInt);
                    break;
                case 4:
                    f = zzbfn.zzm(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new Cap(i, iBinder, f);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Cap[i];
    }
}
