package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class zzn extends zzbfm {
    public static final Creator<zzn> CREATOR = new zzm();
    private Bundle mBundle;
    private int versionCode;
    private int zzeie;

    zzn(int i, int i2, Bundle bundle) {
        this.versionCode = i;
        this.zzeie = i2;
        this.mBundle = bundle;
    }

    public zzn(GoogleSignInOptionsExtension googleSignInOptionsExtension) {
        this(1, googleSignInOptionsExtension.getExtensionType(), googleSignInOptionsExtension.toBundle());
    }

    public final int getType() {
        return this.zzeie;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.versionCode);
        zzbfp.zzc(parcel, 2, this.zzeie);
        zzbfp.zza(parcel, 3, this.mBundle, false);
        zzbfp.zzai(parcel, zze);
    }
}
