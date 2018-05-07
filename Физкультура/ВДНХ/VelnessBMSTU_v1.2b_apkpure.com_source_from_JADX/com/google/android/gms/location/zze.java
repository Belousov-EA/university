package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public final class zze extends zzbfm {
    public static final Creator<zze> CREATOR = new zzf();
    private boolean zziir;
    private long zziis;
    private float zziit;
    private long zziiu;
    private int zziiv;

    public zze() {
        this(true, 50, 0.0f, Long.MAX_VALUE, Integer.MAX_VALUE);
    }

    zze(boolean z, long j, float f, long j2, int i) {
        this.zziir = z;
        this.zziis = j;
        this.zziit = f;
        this.zziiu = j2;
        this.zziiv = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zze)) {
            return false;
        }
        zze com_google_android_gms_location_zze = (zze) obj;
        return this.zziir == com_google_android_gms_location_zze.zziir && this.zziis == com_google_android_gms_location_zze.zziis && Float.compare(this.zziit, com_google_android_gms_location_zze.zziit) == 0 && this.zziiu == com_google_android_gms_location_zze.zziiu && this.zziiv == com_google_android_gms_location_zze.zziiv;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.zziir), Long.valueOf(this.zziis), Float.valueOf(this.zziit), Long.valueOf(this.zziiu), Integer.valueOf(this.zziiv)});
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DeviceOrientationRequest[mShouldUseMag=").append(this.zziir);
        stringBuilder.append(" mMinimumSamplingPeriodMs=").append(this.zziis);
        stringBuilder.append(" mSmallestAngleChangeRadians=").append(this.zziit);
        if (this.zziiu != Long.MAX_VALUE) {
            long elapsedRealtime = this.zziiu - SystemClock.elapsedRealtime();
            stringBuilder.append(" expireIn=");
            stringBuilder.append(elapsedRealtime).append("ms");
        }
        if (this.zziiv != Integer.MAX_VALUE) {
            stringBuilder.append(" num=").append(this.zziiv);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, this.zziir);
        zzbfp.zza(parcel, 2, this.zziis);
        zzbfp.zza(parcel, 3, this.zziit);
        zzbfp.zza(parcel, 4, this.zziiu);
        zzbfp.zzc(parcel, 5, this.zziiv);
        zzbfp.zzai(parcel, zze);
    }
}
