package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzcfr implements Creator<zzcfq> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        IBinder iBinder = null;
        int zzd = zzbfn.zzd(parcel);
        int i = 1;
        IBinder iBinder2 = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder3 = null;
        zzcfo com_google_android_gms_internal_zzcfo = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 2:
                    com_google_android_gms_internal_zzcfo = (zzcfo) zzbfn.zza(parcel, readInt, zzcfo.CREATOR);
                    break;
                case 3:
                    iBinder3 = zzbfn.zzr(parcel, readInt);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) zzbfn.zza(parcel, readInt, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder2 = zzbfn.zzr(parcel, readInt);
                    break;
                case 6:
                    iBinder = zzbfn.zzr(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzcfq(i, com_google_android_gms_internal_zzcfo, iBinder3, pendingIntent, iBinder2, iBinder);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzcfq[i];
    }
}
