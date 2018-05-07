package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import java.util.List;

public final class zzdyi extends zzbfm {
    public static final Creator<zzdyi> CREATOR = new zzdyj();
    private boolean mRegistered;
    private String zzmcu;
    private String zzmgd;
    private boolean zzmge;
    private zzdyw zzmgf;

    public zzdyi() {
        this.zzmgf = zzdyw.zzbsb();
    }

    public zzdyi(String str, boolean z, String str2, boolean z2, zzdyw com_google_android_gms_internal_zzdyw) {
        this.zzmgd = str;
        this.mRegistered = z;
        this.zzmcu = str2;
        this.zzmge = z2;
        this.zzmgf = com_google_android_gms_internal_zzdyw == null ? zzdyw.zzbsb() : zzdyw.zza(com_google_android_gms_internal_zzdyw);
    }

    @Nullable
    public final List<String> getAllProviders() {
        return this.zzmgf.zzbsa();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.zzmgd, false);
        zzbfp.zza(parcel, 3, this.mRegistered);
        zzbfp.zza(parcel, 4, this.zzmcu, false);
        zzbfp.zza(parcel, 5, this.zzmge);
        zzbfp.zza(parcel, 6, this.zzmgf, i, false);
        zzbfp.zzai(parcel, zze);
    }
}
