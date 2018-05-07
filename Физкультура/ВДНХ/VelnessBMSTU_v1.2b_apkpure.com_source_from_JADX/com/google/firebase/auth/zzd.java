package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzdyy;

public class zzd extends AuthCredential {
    public static final Creator<zzd> CREATOR = new zze();
    private final String zzefs;
    private final String zzmcu;
    private final String zzmcv;
    private final zzdyy zzmcw;

    zzd(@NonNull String str, @Nullable String str2, @Nullable String str3, @Nullable zzdyy com_google_android_gms_internal_zzdyy) {
        this.zzmcu = str;
        this.zzefs = str2;
        this.zzmcv = str3;
        this.zzmcw = com_google_android_gms_internal_zzdyy;
    }

    public static zzdyy zza(@NonNull zzd com_google_firebase_auth_zzd) {
        zzbq.checkNotNull(com_google_firebase_auth_zzd);
        return com_google_firebase_auth_zzd.zzmcw != null ? com_google_firebase_auth_zzd.zzmcw : new zzdyy(com_google_firebase_auth_zzd.zzefs, com_google_firebase_auth_zzd.zzmcv, com_google_firebase_auth_zzd.getProvider(), null, null);
    }

    public static zzd zza(@NonNull zzdyy com_google_android_gms_internal_zzdyy) {
        return new zzd(null, null, null, (zzdyy) zzbq.checkNotNull(com_google_android_gms_internal_zzdyy, "Must specify a non-null webSignInCredential"));
    }

    public static zzd zzn(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            return new zzd(zzbq.zzh(str, "Must specify a non-empty providerId"), str2, str3, null);
        }
        throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
    }

    public String getProvider() {
        return this.zzmcu;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, getProvider(), false);
        zzbfp.zza(parcel, 2, this.zzefs, false);
        zzbfp.zza(parcel, 3, this.zzmcv, false);
        zzbfp.zza(parcel, 4, this.zzmcw, i, false);
        zzbfp.zzai(parcel, zze);
    }
}
