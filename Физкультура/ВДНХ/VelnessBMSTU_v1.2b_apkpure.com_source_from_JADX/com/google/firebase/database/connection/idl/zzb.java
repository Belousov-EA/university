package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;
import java.util.List;

public final class zzb implements Creator<zza> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        List list = null;
        int zzd = zzbfn.zzd(parcel);
        List list2 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    list2 = zzbfn.zzac(parcel, readInt);
                    break;
                case 3:
                    list = zzbfn.zzac(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zza(list2, list);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zza[i];
    }
}
