package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzebk;
import com.google.android.gms.internal.zzeje;
import java.io.File;
import java.util.List;

public final class zzc extends zzbfm {
    public static final Creator<zzc> CREATOR = new zze();
    final boolean zzmnr;
    final String zzmnt;
    final String zzmnu;
    final zzi zzmqj;
    final int zzmqk;
    final List<String> zzmql;
    final String zzmqm;

    public zzc(zzebk com_google_android_gms_internal_zzebk, zzeje com_google_android_gms_internal_zzeje, List<String> list, boolean z, String str, String str2, File file) {
        int i;
        switch (zzd.zzmqn[com_google_android_gms_internal_zzeje.ordinal()]) {
            case 1:
                i = 1;
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 3;
                break;
            case 4:
                i = 4;
                break;
            default:
                i = 0;
                break;
        }
        this.zzmqj = new zzi(com_google_android_gms_internal_zzebk.getHost(), com_google_android_gms_internal_zzebk.getNamespace(), com_google_android_gms_internal_zzebk.isSecure());
        this.zzmqk = i;
        this.zzmql = null;
        this.zzmnr = z;
        this.zzmqm = str;
        this.zzmnt = str2;
        this.zzmnu = file.getAbsolutePath();
    }

    public zzc(zzi com_google_firebase_database_connection_idl_zzi, int i, List<String> list, boolean z, String str, String str2, String str3) {
        this.zzmqj = com_google_firebase_database_connection_idl_zzi;
        this.zzmqk = i;
        this.zzmql = list;
        this.zzmnr = z;
        this.zzmqm = str;
        this.zzmnt = str2;
        this.zzmnu = str3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.zzmqj, i, false);
        zzbfp.zzc(parcel, 3, this.zzmqk);
        zzbfp.zzb(parcel, 4, this.zzmql, false);
        zzbfp.zza(parcel, 5, this.zzmnr);
        zzbfp.zza(parcel, 6, this.zzmqm, false);
        zzbfp.zza(parcel, 7, this.zzmnt, false);
        zzbfp.zza(parcel, 8, this.zzmnu, false);
        zzbfp.zzai(parcel, zze);
    }
}
