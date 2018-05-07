package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public class DeviceMetaData extends zzbfm {
    public static final Creator<DeviceMetaData> CREATOR = new zzw();
    private int zzeck;
    private boolean zzeeq;
    private long zzeer;
    private final boolean zzees;

    DeviceMetaData(int i, boolean z, long j, boolean z2) {
        this.zzeck = i;
        this.zzeeq = z;
        this.zzeer = j;
        this.zzees = z2;
    }

    public long getMinAgeOfLockScreen() {
        return this.zzeer;
    }

    public boolean isChallengeAllowed() {
        return this.zzees;
    }

    public boolean isLockScreenSolved() {
        return this.zzeeq;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.zzeck);
        zzbfp.zza(parcel, 2, isLockScreenSolved());
        zzbfp.zza(parcel, 3, getMinAgeOfLockScreen());
        zzbfp.zza(parcel, 4, isChallengeAllowed());
        zzbfp.zzai(parcel, zze);
    }
}
