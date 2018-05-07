package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;
import com.google.android.gms.internal.zzcfs;
import java.util.List;

public final class zzl implements Creator<GeofencingRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        List list = null;
        int i = 0;
        String str = "";
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    list = zzbfn.zzc(parcel, readInt, zzcfs.CREATOR);
                    break;
                case 2:
                    i = zzbfn.zzg(parcel, readInt);
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
        return new GeofencingRequest(list, i, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new GeofencingRequest[i];
    }
}
