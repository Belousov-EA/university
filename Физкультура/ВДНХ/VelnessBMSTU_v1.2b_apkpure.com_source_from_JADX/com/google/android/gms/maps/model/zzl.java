package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;
import java.util.List;

public final class zzl implements Creator<PolylineOptions> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        float f = 0.0f;
        List list = null;
        int i = 0;
        int zzd = zzbfn.zzd(parcel);
        Cap cap = null;
        Cap cap2 = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        float f2 = 0.0f;
        List list2 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    list2 = zzbfn.zzc(parcel, readInt, LatLng.CREATOR);
                    break;
                case 3:
                    f2 = zzbfn.zzl(parcel, readInt);
                    break;
                case 4:
                    i2 = zzbfn.zzg(parcel, readInt);
                    break;
                case 5:
                    f = zzbfn.zzl(parcel, readInt);
                    break;
                case 6:
                    z3 = zzbfn.zzc(parcel, readInt);
                    break;
                case 7:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 8:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 9:
                    cap2 = (Cap) zzbfn.zza(parcel, readInt, Cap.CREATOR);
                    break;
                case 10:
                    cap = (Cap) zzbfn.zza(parcel, readInt, Cap.CREATOR);
                    break;
                case 11:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 12:
                    list = zzbfn.zzc(parcel, readInt, PatternItem.CREATOR);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new PolylineOptions(list2, f2, i2, f, z3, z2, z, cap2, cap, i, list);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new PolylineOptions[i];
    }
}
