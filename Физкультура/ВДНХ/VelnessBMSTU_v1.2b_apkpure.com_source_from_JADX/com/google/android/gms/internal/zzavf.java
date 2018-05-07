package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;

public final class zzavf extends zzbfm {
    public static final Creator<zzavf> CREATOR = new zzavg();
    private String accountType;
    private int zzeck;
    private int zzeeu;

    zzavf(int i, String str, int i2) {
        this.zzeck = 1;
        this.accountType = (String) zzbq.checkNotNull(str);
        this.zzeeu = i2;
    }

    public zzavf(String str, int i) {
        this(1, str, i);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.zzeck);
        zzbfp.zza(parcel, 2, this.accountType, false);
        zzbfp.zzc(parcel, 3, this.zzeeu);
        zzbfp.zzai(parcel, zze);
    }
}
