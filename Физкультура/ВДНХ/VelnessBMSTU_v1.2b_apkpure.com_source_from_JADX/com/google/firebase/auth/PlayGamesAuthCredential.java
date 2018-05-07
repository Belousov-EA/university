package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzdyy;

public class PlayGamesAuthCredential extends AuthCredential {
    public static final Creator<PlayGamesAuthCredential> CREATOR = new zzs();
    private final String zzegv;

    PlayGamesAuthCredential(@NonNull String str) {
        this.zzegv = zzbq.zzgm(str);
    }

    public static zzdyy zza(@NonNull PlayGamesAuthCredential playGamesAuthCredential) {
        zzbq.checkNotNull(playGamesAuthCredential);
        return new zzdyy(null, null, playGamesAuthCredential.getProvider(), null, null, playGamesAuthCredential.zzegv);
    }

    public String getProvider() {
        return PlayGamesAuthProvider.PROVIDER_ID;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, this.zzegv, false);
        zzbfp.zzai(parcel, zze);
    }
}
