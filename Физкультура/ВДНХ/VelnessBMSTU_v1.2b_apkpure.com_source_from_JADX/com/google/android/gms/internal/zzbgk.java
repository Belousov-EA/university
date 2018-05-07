package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzbgk extends zzbfm {
    public static final Creator<zzbgk> CREATOR = new zzbgm();
    private int versionCode;
    final String zzgcc;
    final int zzgcd;

    zzbgk(int i, String str, int i2) {
        this.versionCode = i;
        this.zzgcc = str;
        this.zzgcd = i2;
    }

    zzbgk(String str, int i) {
        this.versionCode = 1;
        this.zzgcc = str;
        this.zzgcd = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.versionCode);
        zzbfp.zza(parcel, 2, this.zzgcc, false);
        zzbfp.zzc(parcel, 3, this.zzgcd);
        zzbfp.zzai(parcel, zze);
    }
}
