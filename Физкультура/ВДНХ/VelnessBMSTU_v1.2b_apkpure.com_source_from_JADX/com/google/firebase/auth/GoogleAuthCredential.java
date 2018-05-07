package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzdyy;

public class GoogleAuthCredential extends AuthCredential {
    public static final Creator<GoogleAuthCredential> CREATOR = new zzq();
    private final String zzefs;
    private final String zzmcv;

    GoogleAuthCredential(@Nullable String str, @Nullable String str2) {
        if (str == null && str2 == null) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        this.zzefs = zzbb(str, "idToken");
        this.zzmcv = zzbb(str2, "accessToken");
    }

    public static zzdyy zza(@NonNull GoogleAuthCredential googleAuthCredential) {
        zzbq.checkNotNull(googleAuthCredential);
        return new zzdyy(googleAuthCredential.zzefs, googleAuthCredential.zzmcv, googleAuthCredential.getProvider(), null, null);
    }

    private static String zzbb(String str, String str2) {
        if (str == null || !TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(str2).concat(" must not be empty"));
    }

    public String getProvider() {
        return GoogleAuthProvider.PROVIDER_ID;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, this.zzefs, false);
        zzbfp.zza(parcel, 2, this.zzmcv, false);
        zzbfp.zzai(parcel, zze);
    }
}
