package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzecd;
import java.util.List;

final class zzak extends zzbfm {
    public static final Creator<zzak> CREATOR = new zzal();
    private List<String> zzmpr;
    private List<String> zzmps;

    public zzak(List<String> list, List<String> list2) {
        this.zzmpr = list;
        this.zzmps = list2;
    }

    public static zzecd zza(zzak com_google_firebase_database_connection_idl_zzak, Object obj) {
        return new zzecd(com_google_firebase_database_connection_idl_zzak.zzmpr, com_google_firebase_database_connection_idl_zzak.zzmps, obj);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzb(parcel, 2, this.zzmpr, false);
        zzbfp.zzb(parcel, 3, this.zzmps, false);
        zzbfp.zzai(parcel, zze);
    }
}
