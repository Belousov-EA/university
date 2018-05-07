package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfp;

public class EmailAuthCredential extends AuthCredential {
    public static final Creator<EmailAuthCredential> CREATOR = new zzf();
    private String zzeey;
    private String zzegs;

    EmailAuthCredential(@NonNull String str, @NonNull String str2) {
        this.zzegs = zzbq.zzgm(str);
        this.zzeey = zzbq.zzgm(str2);
    }

    @NonNull
    public final String getEmail() {
        return this.zzegs;
    }

    @NonNull
    public final String getPassword() {
        return this.zzeey;
    }

    @NonNull
    public String getProvider() {
        return EmailAuthProvider.PROVIDER_ID;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, this.zzegs, false);
        zzbfp.zza(parcel, 2, this.zzeey, false);
        zzbfp.zzai(parcel, zze);
    }
}
