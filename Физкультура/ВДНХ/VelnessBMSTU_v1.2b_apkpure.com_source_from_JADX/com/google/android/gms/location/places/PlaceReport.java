package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.os.EnvironmentCompat;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbi;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.Arrays;

public class PlaceReport extends zzbfm implements ReflectedParcelable {
    public static final Creator<PlaceReport> CREATOR = new zzl();
    private final String mTag;
    private final String zzdrc;
    private int zzeck;
    private final String zzinh;

    PlaceReport(int i, String str, String str2, String str3) {
        this.zzeck = i;
        this.zzinh = str;
        this.mTag = str2;
        this.zzdrc = str3;
    }

    public static PlaceReport create(String str, String str2) {
        boolean z = false;
        String str3 = EnvironmentCompat.MEDIA_UNKNOWN;
        zzbq.checkNotNull(str);
        zzbq.zzgm(str2);
        zzbq.zzgm(str3);
        boolean z2 = true;
        switch (str3.hashCode()) {
            case -1436706272:
                if (str3.equals("inferredGeofencing")) {
                    z2 = true;
                    break;
                }
                break;
            case -1194968642:
                if (str3.equals("userReported")) {
                    z2 = true;
                    break;
                }
                break;
            case -284840886:
                if (str3.equals(EnvironmentCompat.MEDIA_UNKNOWN)) {
                    z2 = false;
                    break;
                }
                break;
            case -262743844:
                if (str3.equals("inferredReverseGeocoding")) {
                    z2 = true;
                    break;
                }
                break;
            case 1164924125:
                if (str3.equals("inferredSnappedToRoad")) {
                    z2 = true;
                    break;
                }
                break;
            case 1287171955:
                if (str3.equals("inferredRadioSignals")) {
                    z2 = true;
                    break;
                }
                break;
        }
        switch (z2) {
            case false:
            case true:
            case true:
            case true:
            case true:
            case true:
                z = true;
                break;
        }
        zzbq.checkArgument(z, "Invalid source");
        return new PlaceReport(1, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return zzbg.equal(this.zzinh, placeReport.zzinh) && zzbg.equal(this.mTag, placeReport.mTag) && zzbg.equal(this.zzdrc, placeReport.zzdrc);
    }

    public String getPlaceId() {
        return this.zzinh;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzinh, this.mTag, this.zzdrc});
    }

    public String toString() {
        zzbi zzx = zzbg.zzx(this);
        zzx.zzg("placeId", this.zzinh);
        zzx.zzg("tag", this.mTag);
        if (!EnvironmentCompat.MEDIA_UNKNOWN.equals(this.zzdrc)) {
            zzx.zzg(Param.SOURCE, this.zzdrc);
        }
        return zzx.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.zzeck);
        zzbfp.zza(parcel, 2, getPlaceId(), false);
        zzbfp.zza(parcel, 3, getTag(), false);
        zzbfp.zza(parcel, 4, this.zzdrc, false);
        zzbfp.zzai(parcel, zze);
    }
}
