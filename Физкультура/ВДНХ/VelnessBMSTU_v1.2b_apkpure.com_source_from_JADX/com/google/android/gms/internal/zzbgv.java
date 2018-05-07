package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzbgv extends zzbfm {
    public static final Creator<zzbgv> CREATOR = new zzbgs();
    final String key;
    private int versionCode;
    final zzbgo<?, ?> zzgcs;

    zzbgv(int i, String str, zzbgo<?, ?> com_google_android_gms_internal_zzbgo___) {
        this.versionCode = i;
        this.key = str;
        this.zzgcs = com_google_android_gms_internal_zzbgo___;
    }

    zzbgv(String str, zzbgo<?, ?> com_google_android_gms_internal_zzbgo___) {
        this.versionCode = 1;
        this.key = str;
        this.zzgcs = com_google_android_gms_internal_zzbgo___;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.versionCode);
        zzbfp.zza(parcel, 2, this.key, false);
        zzbfp.zza(parcel, 3, this.zzgcs, i, false);
        zzbfp.zzai(parcel, zze);
    }
}
