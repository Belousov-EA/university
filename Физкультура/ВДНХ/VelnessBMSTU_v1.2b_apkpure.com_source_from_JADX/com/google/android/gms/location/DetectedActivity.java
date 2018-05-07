package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.Comparator;

public class DetectedActivity extends zzbfm {
    public static final Creator<DetectedActivity> CREATOR = new zzd();
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int RUNNING = 8;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    public static final int WALKING = 7;
    private static Comparator<DetectedActivity> zziim = new zzc();
    private static int[] zziin = new int[]{9, 10};
    private static int[] zziio = new int[]{0, 1, 2, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 16, 17};
    private int zziip;
    private int zziiq;

    public DetectedActivity(int i, int i2) {
        this.zziip = i;
        this.zziiq = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DetectedActivity detectedActivity = (DetectedActivity) obj;
        return this.zziip == detectedActivity.zziip && this.zziiq == detectedActivity.zziiq;
    }

    public int getConfidence() {
        return this.zziiq;
    }

    public int getType() {
        int i = this.zziip;
        return i > 17 ? 4 : i;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zziip), Integer.valueOf(this.zziiq)});
    }

    public String toString() {
        String str;
        int type = getType();
        switch (type) {
            case 0:
                str = "IN_VEHICLE";
                break;
            case 1:
                str = "ON_BICYCLE";
                break;
            case 2:
                str = "ON_FOOT";
                break;
            case 3:
                str = "STILL";
                break;
            case 4:
                str = "UNKNOWN";
                break;
            case 5:
                str = "TILTING";
                break;
            case 7:
                str = "WALKING";
                break;
            case 8:
                str = "RUNNING";
                break;
            case 16:
                str = "IN_ROAD_VEHICLE";
                break;
            case 17:
                str = "IN_RAIL_VEHICLE";
                break;
            default:
                str = Integer.toString(type);
                break;
        }
        return new StringBuilder(String.valueOf(str).length() + 48).append("DetectedActivity [type=").append(str).append(", confidence=").append(this.zziiq).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.zziip);
        zzbfp.zzc(parcel, 2, this.zziiq);
        zzbfp.zzai(parcel, zze);
    }
}
