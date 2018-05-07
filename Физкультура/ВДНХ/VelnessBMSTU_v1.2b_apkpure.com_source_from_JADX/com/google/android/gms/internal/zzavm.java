package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzavm implements Creator<zzavl> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        PendingIntent pendingIntent = null;
        int zzd = zzbfn.zzd(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 2:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 3:
                    pendingIntent = (PendingIntent) zzbfn.zza(parcel, readInt, PendingIntent.CREATOR);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzavl(i, str, pendingIntent);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzavl[i];
    }
}
