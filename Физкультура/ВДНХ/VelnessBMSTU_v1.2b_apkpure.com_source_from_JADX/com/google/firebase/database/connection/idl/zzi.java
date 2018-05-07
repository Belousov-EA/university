package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzebk;

final class zzi extends zzbfm {
    public static final Creator<zzi> CREATOR = new zzj();
    private String host;
    private boolean secure;
    private String zzjrg;

    public zzi(String str, String str2, boolean z) {
        this.host = str;
        this.zzjrg = str2;
        this.secure = z;
    }

    public static zzebk zza(zzi com_google_firebase_database_connection_idl_zzi) {
        return new zzebk(com_google_firebase_database_connection_idl_zzi.host, com_google_firebase_database_connection_idl_zzi.zzjrg, com_google_firebase_database_connection_idl_zzi.secure);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.host, false);
        zzbfp.zza(parcel, 3, this.zzjrg, false);
        zzbfp.zza(parcel, 4, this.secure);
        zzbfp.zzai(parcel, zze);
    }
}
