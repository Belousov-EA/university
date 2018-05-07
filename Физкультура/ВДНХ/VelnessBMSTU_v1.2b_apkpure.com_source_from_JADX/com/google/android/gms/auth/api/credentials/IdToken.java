package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class IdToken extends zzbfm implements ReflectedParcelable {
    public static final Creator<IdToken> CREATOR = new zzi();
    @NonNull
    private final String zzeem;
    @NonNull
    private final String zzefs;

    public IdToken(@NonNull String str, @NonNull String str2) {
        boolean z = true;
        zzbq.checkArgument(!TextUtils.isEmpty(str), "account type string cannot be null or empty");
        if (TextUtils.isEmpty(str2)) {
            z = false;
        }
        zzbq.checkArgument(z, "id token string cannot be null or empty");
        this.zzeem = str;
        this.zzefs = str2;
    }

    @NonNull
    public final String getAccountType() {
        return this.zzeem;
    }

    @NonNull
    public final String getIdToken() {
        return this.zzefs;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, getAccountType(), false);
        zzbfp.zza(parcel, 2, getIdToken(), false);
        zzbfp.zzai(parcel, zze);
    }
}
