package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class zzbgh extends zzbfm {
    public static final Creator<zzbgh> CREATOR = new zzbgi();
    private int zzeck;
    private final zzbgj zzgby;

    zzbgh(int i, zzbgj com_google_android_gms_internal_zzbgj) {
        this.zzeck = i;
        this.zzgby = com_google_android_gms_internal_zzbgj;
    }

    private zzbgh(zzbgj com_google_android_gms_internal_zzbgj) {
        this.zzeck = 1;
        this.zzgby = com_google_android_gms_internal_zzbgj;
    }

    public static zzbgh zza(zzbgp<?, ?> com_google_android_gms_internal_zzbgp___) {
        if (com_google_android_gms_internal_zzbgp___ instanceof zzbgj) {
            return new zzbgh((zzbgj) com_google_android_gms_internal_zzbgp___);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.zzeck);
        zzbfp.zza(parcel, 2, this.zzgby, i, false);
        zzbfp.zzai(parcel, zze);
    }

    public final zzbgp<?, ?> zzalt() {
        if (this.zzgby != null) {
            return this.zzgby;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }
}
