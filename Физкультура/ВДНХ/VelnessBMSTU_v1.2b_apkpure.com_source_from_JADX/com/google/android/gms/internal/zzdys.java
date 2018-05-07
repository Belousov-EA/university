package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzdys extends zzbfm {
    public static final Creator<zzdys> CREATOR = new zzdyt();
    private String zzegs;
    private String zzmgr;
    private String zzmgs;

    zzdys(String str, String str2, String str3) {
        this.zzegs = str;
        this.zzmgr = str2;
        this.zzmgs = str3;
    }

    public final String getEmail() {
        return this.zzegs;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.zzegs, false);
        zzbfp.zza(parcel, 3, this.zzmgr, false);
        zzbfp.zza(parcel, 4, this.zzmgs, false);
        zzbfp.zzai(parcel, zze);
    }

    public final String zzbry() {
        return this.zzmgr;
    }

    public final String zzbrz() {
        return this.zzmgs;
    }
}
