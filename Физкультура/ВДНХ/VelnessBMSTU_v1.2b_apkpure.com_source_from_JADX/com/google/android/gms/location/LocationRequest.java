package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

public final class LocationRequest extends zzbfm implements ReflectedParcelable {
    public static final Creator<LocationRequest> CREATOR = new zzw();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    private int mPriority;
    private boolean zzhhr;
    private int zziiv;
    private long zziiz;
    private long zzijq;
    private long zzijr;
    private float zzijs;
    private long zzijt;

    public LocationRequest() {
        this.mPriority = 102;
        this.zzijq = 3600000;
        this.zzijr = 600000;
        this.zzhhr = false;
        this.zziiz = Long.MAX_VALUE;
        this.zziiv = Integer.MAX_VALUE;
        this.zzijs = 0.0f;
        this.zzijt = 0;
    }

    LocationRequest(int i, long j, long j2, boolean z, long j3, int i2, float f, long j4) {
        this.mPriority = i;
        this.zzijq = j;
        this.zzijr = j2;
        this.zzhhr = z;
        this.zziiz = j3;
        this.zziiv = i2;
        this.zzijs = f;
        this.zzijt = j4;
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    private static void zzai(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) obj;
        return this.mPriority == locationRequest.mPriority && this.zzijq == locationRequest.zzijq && this.zzijr == locationRequest.zzijr && this.zzhhr == locationRequest.zzhhr && this.zziiz == locationRequest.zziiz && this.zziiv == locationRequest.zziiv && this.zzijs == locationRequest.zzijs && getMaxWaitTime() == locationRequest.getMaxWaitTime();
    }

    public final long getExpirationTime() {
        return this.zziiz;
    }

    public final long getFastestInterval() {
        return this.zzijr;
    }

    public final long getInterval() {
        return this.zzijq;
    }

    public final long getMaxWaitTime() {
        long j = this.zzijt;
        return j < this.zzijq ? this.zzijq : j;
    }

    public final int getNumUpdates() {
        return this.zziiv;
    }

    public final int getPriority() {
        return this.mPriority;
    }

    public final float getSmallestDisplacement() {
        return this.zzijs;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mPriority), Long.valueOf(this.zzijq), Float.valueOf(this.zzijs), Long.valueOf(this.zzijt)});
    }

    public final boolean isFastestIntervalExplicitlySet() {
        return this.zzhhr;
    }

    public final LocationRequest setExpirationDuration(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (j > Long.MAX_VALUE - elapsedRealtime) {
            this.zziiz = Long.MAX_VALUE;
        } else {
            this.zziiz = elapsedRealtime + j;
        }
        if (this.zziiz < 0) {
            this.zziiz = 0;
        }
        return this;
    }

    public final LocationRequest setExpirationTime(long j) {
        this.zziiz = j;
        if (this.zziiz < 0) {
            this.zziiz = 0;
        }
        return this;
    }

    public final LocationRequest setFastestInterval(long j) {
        zzai(j);
        this.zzhhr = true;
        this.zzijr = j;
        return this;
    }

    public final LocationRequest setInterval(long j) {
        zzai(j);
        this.zzijq = j;
        if (!this.zzhhr) {
            this.zzijr = (long) (((double) this.zzijq) / 6.0d);
        }
        return this;
    }

    public final LocationRequest setMaxWaitTime(long j) {
        zzai(j);
        this.zzijt = j;
        return this;
    }

    public final LocationRequest setNumUpdates(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + i);
        }
        this.zziiv = i;
        return this;
    }

    public final LocationRequest setPriority(int i) {
        switch (i) {
            case 100:
            case 102:
            case 104:
            case 105:
                this.mPriority = i;
                return this;
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    public final LocationRequest setSmallestDisplacement(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
        this.zzijs = f;
        return this;
    }

    public final String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = stringBuilder.append("Request[");
        switch (this.mPriority) {
            case 100:
                str = "PRIORITY_HIGH_ACCURACY";
                break;
            case 102:
                str = "PRIORITY_BALANCED_POWER_ACCURACY";
                break;
            case 104:
                str = "PRIORITY_LOW_POWER";
                break;
            case 105:
                str = "PRIORITY_NO_POWER";
                break;
            default:
                str = "???";
                break;
        }
        append.append(str);
        if (this.mPriority != 105) {
            stringBuilder.append(" requested=");
            stringBuilder.append(this.zzijq).append("ms");
        }
        stringBuilder.append(" fastest=");
        stringBuilder.append(this.zzijr).append("ms");
        if (this.zzijt > this.zzijq) {
            stringBuilder.append(" maxWait=");
            stringBuilder.append(this.zzijt).append("ms");
        }
        if (this.zzijs > 0.0f) {
            stringBuilder.append(" smallestDisplacement=");
            stringBuilder.append(this.zzijs).append("m");
        }
        if (this.zziiz != Long.MAX_VALUE) {
            long elapsedRealtime = this.zziiz - SystemClock.elapsedRealtime();
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
        zzbfp.zzc(parcel, 1, this.mPriority);
        zzbfp.zza(parcel, 2, this.zzijq);
        zzbfp.zza(parcel, 3, this.zzijr);
        zzbfp.zza(parcel, 4, this.zzhhr);
        zzbfp.zza(parcel, 5, this.zziiz);
        zzbfp.zzc(parcel, 6, this.zziiv);
        zzbfp.zza(parcel, 7, this.zzijs);
        zzbfp.zza(parcel, 8, this.zzijt);
        zzbfp.zzai(parcel, zze);
    }
}
