package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;

public final class zzavj extends zzbfm {
    public static final Creator<zzavj> CREATOR = new zzavk();
    private String accountType;
    private int zzeck;
    private byte[] zzeen;

    zzavj(int i, String str, byte[] bArr) {
        this.zzeck = 1;
        this.accountType = (String) zzbq.checkNotNull(str);
        this.zzeen = (byte[]) zzbq.checkNotNull(bArr);
    }

    public zzavj(String str, byte[] bArr) {
        this(1, str, bArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.zzeck);
        zzbfp.zza(parcel, 2, this.accountType, false);
        zzbfp.zza(parcel, 3, this.zzeen, false);
        zzbfp.zzai(parcel, zze);
    }
}
