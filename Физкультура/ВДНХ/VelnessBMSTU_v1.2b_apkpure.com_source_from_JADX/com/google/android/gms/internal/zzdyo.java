package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;

public final class zzdyo extends zzbfm {
    public static final Creator<zzdyo> CREATOR = new zzdyp();
    private String zzegs;
    private String zzegt;
    private String zzimi;
    private String zzmcu;
    private String zzmdx;
    private String zzmgo;
    private String zzmgp;

    zzdyo(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.zzmgo = str;
        this.zzegt = str2;
        this.zzmdx = str3;
        this.zzmcu = str4;
        this.zzmgp = str5;
        this.zzimi = str6;
        this.zzegs = str7;
    }

    @Nullable
    public final String getDisplayName() {
        return this.zzegt;
    }

    @Nullable
    public final String getEmail() {
        return this.zzegs;
    }

    public final String getPhoneNumber() {
        return this.zzimi;
    }

    @Nullable
    public final Uri getPhotoUri() {
        return !TextUtils.isEmpty(this.zzmdx) ? Uri.parse(this.zzmdx) : null;
    }

    public final String getProviderId() {
        return this.zzmcu;
    }

    @Nullable
    public final String getRawUserInfo() {
        return this.zzmgp;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.zzmgo, false);
        zzbfp.zza(parcel, 3, this.zzegt, false);
        zzbfp.zza(parcel, 4, this.zzmdx, false);
        zzbfp.zza(parcel, 5, this.zzmcu, false);
        zzbfp.zza(parcel, 6, this.zzmgp, false);
        zzbfp.zza(parcel, 7, this.zzimi, false);
        zzbfp.zza(parcel, 8, this.zzegs, false);
        zzbfp.zzai(parcel, zze);
    }

    public final String zzbrx() {
        return this.zzmgo;
    }
}
