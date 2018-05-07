package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;

public final class zzavh extends zzbfm {
    public static final Creator<zzavh> CREATOR = new zzavi();
    private String accountType;
    private int zzeck;

    zzavh(int i, String str) {
        this.zzeck = 1;
        this.accountType = (String) zzbq.checkNotNull(str);
    }

    public zzavh(String str) {
        this(1, str);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.zzeck);
        zzbfp.zza(parcel, 2, this.accountType, false);
        zzbfp.zzai(parcel, zze);
    }
}
