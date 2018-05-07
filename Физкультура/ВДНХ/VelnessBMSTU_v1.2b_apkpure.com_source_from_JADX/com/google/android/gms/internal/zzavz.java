package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;

public final class zzavz extends zzbfm {
    public static final Creator<zzavz> CREATOR = new zzawa();
    private final Credential zzegc;

    public zzavz(Credential credential) {
        this.zzegc = credential;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, this.zzegc, i, false);
        zzbfp.zzai(parcel, zze);
    }
}
