package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zzf implements Creator<zze> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        boolean z = true;
        long j = 50;
        float f = 0.0f;
        long j2 = Long.MAX_VALUE;
        int i = Integer.MAX_VALUE;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 2:
                    j = zzbfn.zzi(parcel, readInt);
                    break;
                case 3:
                    f = zzbfn.zzl(parcel, readInt);
                    break;
                case 4:
                    j2 = zzbfn.zzi(parcel, readInt);
                    break;
                case 5:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zze(z, j, f, j2, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zze[i];
    }
}
