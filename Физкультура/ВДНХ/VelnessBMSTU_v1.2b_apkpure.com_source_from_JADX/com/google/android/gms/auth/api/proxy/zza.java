package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zza implements Creator<ProxyRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int zzd = zzbfn.zzd(parcel);
        long j = 0;
        byte[] bArr = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 2:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 3:
                    j = zzbfn.zzi(parcel, readInt);
                    break;
                case 4:
                    bArr = zzbfn.zzt(parcel, readInt);
                    break;
                case 5:
                    bundle = zzbfn.zzs(parcel, readInt);
                    break;
                case 1000:
                    i2 = zzbfn.zzg(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new ProxyRequest(i2, str, i, j, bArr, bundle);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ProxyRequest[i];
    }
}
