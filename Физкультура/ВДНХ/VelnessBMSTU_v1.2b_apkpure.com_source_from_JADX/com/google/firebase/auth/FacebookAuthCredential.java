package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzdyy;

public class FacebookAuthCredential extends AuthCredential {
    public static final Creator<FacebookAuthCredential> CREATOR = new zzg();
    private final String zzmcv;

    FacebookAuthCredential(@NonNull String str) {
        this.zzmcv = zzbq.zzgm(str);
    }

    public static zzdyy zza(@NonNull FacebookAuthCredential facebookAuthCredential) {
        zzbq.checkNotNull(facebookAuthCredential);
        return new zzdyy(null, facebookAuthCredential.zzmcv, facebookAuthCredential.getProvider(), null, null);
    }

    public String getProvider() {
        return FacebookAuthProvider.PROVIDER_ID;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, this.zzmcv, false);
        zzbfp.zzai(parcel, zze);
    }
}
