package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zze implements Creator<WebImage> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        int i = 0;
        Uri uri = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i2 = zzbfn.zzg(parcel, readInt);
                    break;
                case 2:
                    uri = (Uri) zzbfn.zza(parcel, readInt, Uri.CREATOR);
                    break;
                case 3:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 4:
                    i3 = zzbfn.zzg(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new WebImage(i2, uri, i, i3);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new WebImage[i];
    }
}
