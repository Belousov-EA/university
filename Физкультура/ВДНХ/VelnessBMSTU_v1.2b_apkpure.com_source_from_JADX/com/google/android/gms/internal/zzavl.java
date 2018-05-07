package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;

public final class zzavl extends zzbfm {
    public static final Creator<zzavl> CREATOR = new zzavm();
    private String accountType;
    private int zzeck;
    private PendingIntent zzeev;

    zzavl(int i, String str, PendingIntent pendingIntent) {
        this.zzeck = 1;
        this.accountType = (String) zzbq.checkNotNull(str);
        this.zzeev = (PendingIntent) zzbq.checkNotNull(pendingIntent);
    }

    public zzavl(String str, PendingIntent pendingIntent) {
        this(1, str, pendingIntent);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.zzeck);
        zzbfp.zza(parcel, 2, this.accountType, false);
        zzbfp.zza(parcel, 3, this.zzeev, i, false);
        zzbfp.zzai(parcel, zze);
    }
}
