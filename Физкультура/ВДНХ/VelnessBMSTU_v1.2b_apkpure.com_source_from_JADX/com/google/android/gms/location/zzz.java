package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class zzz extends zzbfm {
    public static final Creator<zzz> CREATOR = new zzaa();
    private final String zzeuy;
    private final String zzijw;
    private final String zzijx;
    private final int zzijy;
    private final boolean zzijz;

    zzz(String str, String str2, String str3, int i, boolean z) {
        this.zzeuy = str;
        this.zzijw = str2;
        this.zzijx = str3;
        this.zzijy = i;
        this.zzijz = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, this.zzijw, false);
        zzbfp.zza(parcel, 2, this.zzijx, false);
        zzbfp.zzc(parcel, 3, this.zzijy);
        zzbfp.zza(parcel, 4, this.zzijz);
        zzbfp.zza(parcel, 5, this.zzeuy, false);
        zzbfp.zzai(parcel, zze);
    }
}
