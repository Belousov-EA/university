package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzdyy;

public class GithubAuthCredential extends AuthCredential {
    public static final Creator<GithubAuthCredential> CREATOR = new zzp();
    private String zzecl;

    GithubAuthCredential(@NonNull String str) {
        this.zzecl = zzbq.zzgm(str);
    }

    public static zzdyy zza(@NonNull GithubAuthCredential githubAuthCredential) {
        zzbq.checkNotNull(githubAuthCredential);
        return new zzdyy(null, githubAuthCredential.zzecl, githubAuthCredential.getProvider(), null, null);
    }

    public String getProvider() {
        return GithubAuthProvider.PROVIDER_ID;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, this.zzecl, false);
        zzbfp.zzai(parcel, zze);
    }
}
