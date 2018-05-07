package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;
import com.google.android.gms.internal.zzbfo;
import java.util.HashSet;
import java.util.Set;

public final class zzv implements Creator<zzu> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        DeviceMetaData deviceMetaData = null;
        int zzd = zzbfn.zzd(parcel);
        Set hashSet = new HashSet();
        PendingIntent pendingIntent = null;
        byte[] bArr = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i2 = zzbfn.zzg(parcel, readInt);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = zzbfn.zzq(parcel, readInt);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    i = zzbfn.zzg(parcel, readInt);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    bArr = zzbfn.zzt(parcel, readInt);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    PendingIntent pendingIntent2 = (PendingIntent) zzbfn.zza(parcel, readInt, PendingIntent.CREATOR);
                    hashSet.add(Integer.valueOf(5));
                    pendingIntent = pendingIntent2;
                    break;
                case 6:
                    DeviceMetaData deviceMetaData2 = (DeviceMetaData) zzbfn.zza(parcel, readInt, DeviceMetaData.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    deviceMetaData = deviceMetaData2;
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == zzd) {
            return new zzu(hashSet, i2, str, i, bArr, pendingIntent, deviceMetaData);
        }
        throw new zzbfo("Overread allowed size end=" + zzd, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzu[i];
    }
}
