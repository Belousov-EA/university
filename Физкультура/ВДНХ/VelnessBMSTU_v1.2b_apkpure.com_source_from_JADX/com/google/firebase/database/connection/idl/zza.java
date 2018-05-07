package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzebb;
import com.google.android.gms.internal.zzebj;
import java.util.ArrayList;
import java.util.List;

final class zza extends zzbfm {
    public static final Creator<zza> CREATOR = new zzb();
    private List<String> zzmnb;
    private List<String> zzmnc;

    public zza(List<String> list, List<String> list2) {
        this.zzmnb = list;
        this.zzmnc = list2;
    }

    public static zzebb zza(zza com_google_firebase_database_connection_idl_zza) {
        List arrayList = new ArrayList(com_google_firebase_database_connection_idl_zza.zzmnb.size());
        for (String zzpm : com_google_firebase_database_connection_idl_zza.zzmnb) {
            arrayList.add(zzebj.zzpm(zzpm));
        }
        return new zzebb(arrayList, com_google_firebase_database_connection_idl_zza.zzmnc);
    }

    public static zza zza(zzebb com_google_android_gms_internal_zzebb) {
        List<List> zzbtz = com_google_android_gms_internal_zzebb.zzbtz();
        List arrayList = new ArrayList(zzbtz.size());
        for (List zzas : zzbtz) {
            arrayList.add(zzebj.zzas(zzas));
        }
        return new zza(arrayList, com_google_android_gms_internal_zzebb.zzbua());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzb(parcel, 2, this.zzmnb, false);
        zzbfp.zzb(parcel, 3, this.zzmnc, false);
        zzbfp.zzai(parcel, zze);
    }
}
