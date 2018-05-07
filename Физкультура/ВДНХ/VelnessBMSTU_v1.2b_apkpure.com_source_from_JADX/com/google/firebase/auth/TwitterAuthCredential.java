package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzdyy;

public class TwitterAuthCredential extends AuthCredential {
    public static final Creator<TwitterAuthCredential> CREATOR = new zzt();
    private String zzecl;
    private String zzmdw;

    TwitterAuthCredential(@NonNull String str, @NonNull String str2) {
        this.zzecl = zzbq.zzgm(str);
        this.zzmdw = zzbq.zzgm(str2);
    }

    public static zzdyy zza(@NonNull TwitterAuthCredential twitterAuthCredential) {
        zzbq.checkNotNull(twitterAuthCredential);
        return new zzdyy(null, twitterAuthCredential.zzecl, twitterAuthCredential.getProvider(), null, twitterAuthCredential.zzmdw);
    }

    public String getProvider() {
        return TwitterAuthProvider.PROVIDER_ID;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, this.zzecl, false);
        zzbfp.zza(parcel, 2, this.zzmdw, false);
        zzbfp.zzai(parcel, zze);
    }
}
