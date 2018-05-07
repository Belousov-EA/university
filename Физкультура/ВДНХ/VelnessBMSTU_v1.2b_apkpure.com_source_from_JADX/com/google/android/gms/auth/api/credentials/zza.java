package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;
import java.util.List;

public final class zza implements Creator<Credential> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        int zzd = zzbfn.zzd(parcel);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        List list = null;
        Uri uri = null;
        String str7 = null;
        String str8 = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    str8 = zzbfn.zzq(parcel, readInt);
                    break;
                case 2:
                    str7 = zzbfn.zzq(parcel, readInt);
                    break;
                case 3:
                    uri = (Uri) zzbfn.zza(parcel, readInt, Uri.CREATOR);
                    break;
                case 4:
                    list = zzbfn.zzc(parcel, readInt, IdToken.CREATOR);
                    break;
                case 5:
                    str6 = zzbfn.zzq(parcel, readInt);
                    break;
                case 6:
                    str5 = zzbfn.zzq(parcel, readInt);
                    break;
                case 7:
                    str4 = zzbfn.zzq(parcel, readInt);
                    break;
                case 8:
                    str3 = zzbfn.zzq(parcel, readInt);
                    break;
                case 9:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 10:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new Credential(str8, str7, uri, list, str6, str5, str4, str3, str2, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new Credential[i];
    }
}
