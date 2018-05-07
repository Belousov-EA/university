package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;
import java.util.List;

public final class zze implements Creator<zzc> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzd = zzbfn.zzd(parcel);
        String str2 = null;
        String str3 = null;
        List list = null;
        int i = 0;
        zzi com_google_firebase_database_connection_idl_zzi = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    com_google_firebase_database_connection_idl_zzi = (zzi) zzbfn.zza(parcel, readInt, zzi.CREATOR);
                    break;
                case 3:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 4:
                    list = zzbfn.zzac(parcel, readInt);
                    break;
                case 5:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 6:
                    str3 = zzbfn.zzq(parcel, readInt);
                    break;
                case 7:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 8:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzc(com_google_firebase_database_connection_idl_zzi, i, list, z, str3, str2, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzc[i];
    }
}
