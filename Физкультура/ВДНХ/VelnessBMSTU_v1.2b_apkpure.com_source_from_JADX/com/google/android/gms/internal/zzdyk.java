package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.List;

public final class zzdyk extends zzbfm {
    public static final Creator<zzdyk> CREATOR = new zzdyl();
    private long mCreationTimestamp;
    private String zzeey;
    private String zzegs;
    private String zzegt;
    private String zzimi;
    private String zzmdx;
    private String zzmgg;
    private boolean zzmgh;
    private zzdyq zzmgi;
    private long zzmgj;
    private boolean zzmgk;

    public zzdyk() {
        this.zzmgi = new zzdyq();
    }

    public zzdyk(String str, String str2, boolean z, String str3, String str4, zzdyq com_google_android_gms_internal_zzdyq, String str5, String str6, long j, long j2, boolean z2) {
        this.zzmgg = str;
        this.zzegs = str2;
        this.zzmgh = z;
        this.zzegt = str3;
        this.zzmdx = str4;
        this.zzmgi = com_google_android_gms_internal_zzdyq == null ? new zzdyq() : zzdyq.zza(com_google_android_gms_internal_zzdyq);
        this.zzeey = str5;
        this.zzimi = str6;
        this.mCreationTimestamp = j;
        this.zzmgj = j2;
        this.zzmgk = z2;
    }

    public final long getCreationTimestamp() {
        return this.mCreationTimestamp;
    }

    @Nullable
    public final String getDisplayName() {
        return this.zzegt;
    }

    @Nullable
    public final String getEmail() {
        return this.zzegs;
    }

    public final long getLastSignInTimestamp() {
        return this.zzmgj;
    }

    @NonNull
    public final String getLocalId() {
        return this.zzmgg;
    }

    @Nullable
    public final String getPhoneNumber() {
        return this.zzimi;
    }

    @Nullable
    public final Uri getPhotoUri() {
        return !TextUtils.isEmpty(this.zzmdx) ? Uri.parse(this.zzmdx) : null;
    }

    public final boolean isEmailVerified() {
        return this.zzmgh;
    }

    public final boolean isNewUser() {
        return this.zzmgk;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.zzmgg, false);
        zzbfp.zza(parcel, 3, this.zzegs, false);
        zzbfp.zza(parcel, 4, this.zzmgh);
        zzbfp.zza(parcel, 5, this.zzegt, false);
        zzbfp.zza(parcel, 6, this.zzmdx, false);
        zzbfp.zza(parcel, 7, this.zzmgi, i, false);
        zzbfp.zza(parcel, 8, this.zzeey, false);
        zzbfp.zza(parcel, 9, this.zzimi, false);
        zzbfp.zza(parcel, 10, this.mCreationTimestamp);
        zzbfp.zza(parcel, 11, this.zzmgj);
        zzbfp.zza(parcel, 12, this.zzmgk);
        zzbfp.zzai(parcel, zze);
    }

    @NonNull
    public final List<zzdyo> zzbrt() {
        return this.zzmgi.zzbrt();
    }
}
