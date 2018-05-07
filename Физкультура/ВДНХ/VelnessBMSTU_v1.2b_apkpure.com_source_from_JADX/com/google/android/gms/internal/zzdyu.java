package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzdyu extends zzbfm {
    public static final Creator<zzdyu> CREATOR = new zzdyv();
    private final String zzimi;
    private final long zzmgt;
    private final boolean zzmgu;
    private final String zzmgv;

    public zzdyu(String str, long j, boolean z, String str2) {
        this.zzimi = str;
        this.zzmgt = j;
        this.zzmgu = z;
        this.zzmgv = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, this.zzimi, false);
        zzbfp.zza(parcel, 2, this.zzmgt);
        zzbfp.zza(parcel, 3, this.zzmgu);
        zzbfp.zza(parcel, 4, this.zzmgv, false);
        zzbfp.zzai(parcel, zze);
    }
}
