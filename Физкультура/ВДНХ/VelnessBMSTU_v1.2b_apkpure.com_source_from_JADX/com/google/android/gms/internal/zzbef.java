package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public final class zzbef extends zzbfm {
    public static final Creator<zzbef> CREATOR = new zzbeg();
    private boolean zzfju;
    private long zzfjv;
    private long zzfjw;

    public zzbef(boolean z, long j, long j2) {
        this.zzfju = z;
        this.zzfjv = j;
        this.zzfjw = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbef)) {
            return false;
        }
        zzbef com_google_android_gms_internal_zzbef = (zzbef) obj;
        return this.zzfju == com_google_android_gms_internal_zzbef.zzfju && this.zzfjv == com_google_android_gms_internal_zzbef.zzfjv && this.zzfjw == com_google_android_gms_internal_zzbef.zzfjw;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.zzfju), Long.valueOf(this.zzfjv), Long.valueOf(this.zzfjw)});
    }

    public final String toString() {
        return "CollectForDebugParcelable[skipPersistentStorage: " + this.zzfju + ",collectForDebugStartTimeMillis: " + this.zzfjv + ",collectForDebugExpiryTimeMillis: " + this.zzfjw + "]";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, this.zzfju);
        zzbfp.zza(parcel, 2, this.zzfjw);
        zzbfp.zza(parcel, 3, this.zzfjv);
        zzbfp.zzai(parcel, zze);
    }
}
