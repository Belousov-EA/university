package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;
import com.google.android.gms.internal.zzbfo;
import java.util.HashSet;
import java.util.Set;

public final class zzt implements Creator<zzs> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int zzd = zzbfn.zzd(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        zzu com_google_android_gms_auth_api_accounttransfer_zzu = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    i = zzbfn.zzg(parcel, readInt);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    zzu com_google_android_gms_auth_api_accounttransfer_zzu2 = (zzu) zzbfn.zza(parcel, readInt, zzu.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    com_google_android_gms_auth_api_accounttransfer_zzu = com_google_android_gms_auth_api_accounttransfer_zzu2;
                    break;
                case 3:
                    str2 = zzbfn.zzq(parcel, readInt);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str = zzbfn.zzq(parcel, readInt);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        if (parcel.dataPosition() == zzd) {
            return new zzs(hashSet, i, com_google_android_gms_auth_api_accounttransfer_zzu, str2, str);
        }
        throw new zzbfo("Overread allowed size end=" + zzd, parcel);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzs[i];
    }
}
