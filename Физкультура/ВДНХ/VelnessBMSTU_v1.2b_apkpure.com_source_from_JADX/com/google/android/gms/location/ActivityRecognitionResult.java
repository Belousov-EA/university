package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.internal.zzbfr;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ActivityRecognitionResult extends zzbfm implements ReflectedParcelable {
    public static final Creator<ActivityRecognitionResult> CREATOR = new zzb();
    private Bundle extras;
    private List<DetectedActivity> zziii;
    private long zziij;
    private long zziik;
    private int zziil;

    public ActivityRecognitionResult(DetectedActivity detectedActivity, long j, long j2) {
        this(detectedActivity, j, j2, 0, null);
    }

    private ActivityRecognitionResult(DetectedActivity detectedActivity, long j, long j2, int i, Bundle bundle) {
        this(Collections.singletonList(detectedActivity), j, j2, 0, null);
    }

    public ActivityRecognitionResult(List<DetectedActivity> list, long j, long j2) {
        this((List) list, j, j2, 0, null);
    }

    public ActivityRecognitionResult(List<DetectedActivity> list, long j, long j2, int i, Bundle bundle) {
        boolean z = true;
        boolean z2 = list != null && list.size() > 0;
        zzbq.checkArgument(z2, "Must have at least 1 detected activity");
        if (j <= 0 || j2 <= 0) {
            z = false;
        }
        zzbq.checkArgument(z, "Must set times");
        this.zziii = list;
        this.zziij = j;
        this.zziik = j2;
        this.zziil = i;
        this.extras = bundle;
    }

    public static ActivityRecognitionResult extractResult(Intent intent) {
        ActivityRecognitionResult activityRecognitionResult;
        if (hasResult(intent)) {
            Object obj = intent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
            if (obj instanceof byte[]) {
                activityRecognitionResult = (ActivityRecognitionResult) zzbfr.zza((byte[]) obj, CREATOR);
            } else if (obj instanceof ActivityRecognitionResult) {
                activityRecognitionResult = (ActivityRecognitionResult) obj;
            }
            if (activityRecognitionResult != null) {
                return activityRecognitionResult;
            }
            List zzl = zzl(intent);
            return (zzl != null || zzl.isEmpty()) ? null : (ActivityRecognitionResult) zzl.get(zzl.size() - 1);
        }
        activityRecognitionResult = null;
        if (activityRecognitionResult != null) {
            return activityRecognitionResult;
        }
        List zzl2 = zzl(intent);
        if (zzl2 != null) {
        }
    }

    public static boolean hasResult(Intent intent) {
        if (intent == null) {
            return false;
        }
        if (intent == null ? false : intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT")) {
            return true;
        }
        List zzl = zzl(intent);
        return (zzl == null || zzl.isEmpty()) ? false : true;
    }

    private static boolean zzc(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return true;
        }
        if ((bundle == null && bundle2 != null) || (bundle != null && bundle2 == null)) {
            return false;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            if (!bundle2.containsKey(str)) {
                return false;
            }
            if (bundle.get(str) == null) {
                if (bundle2.get(str) != null) {
                    return false;
                }
            } else if (bundle.get(str) instanceof Bundle) {
                if (!zzc(bundle.getBundle(str), bundle2.getBundle(str))) {
                    return false;
                }
            } else if (!bundle.get(str).equals(bundle2.get(str))) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    private static List<ActivityRecognitionResult> zzl(Intent intent) {
        return !(intent == null ? false : intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST")) ? null : zzbfr.zzb(intent, "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST", CREATOR);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
        return this.zziij == activityRecognitionResult.zziij && this.zziik == activityRecognitionResult.zziik && this.zziil == activityRecognitionResult.zziil && zzbg.equal(this.zziii, activityRecognitionResult.zziii) && zzc(this.extras, activityRecognitionResult.extras);
    }

    public int getActivityConfidence(int i) {
        for (DetectedActivity detectedActivity : this.zziii) {
            if (detectedActivity.getType() == i) {
                return detectedActivity.getConfidence();
            }
        }
        return 0;
    }

    public long getElapsedRealtimeMillis() {
        return this.zziik;
    }

    public DetectedActivity getMostProbableActivity() {
        return (DetectedActivity) this.zziii.get(0);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.zziii;
    }

    public long getTime() {
        return this.zziij;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zziij), Long.valueOf(this.zziik), Integer.valueOf(this.zziil), this.zziii, this.extras});
    }

    public String toString() {
        String valueOf = String.valueOf(this.zziii);
        long j = this.zziij;
        return new StringBuilder(String.valueOf(valueOf).length() + 124).append("ActivityRecognitionResult [probableActivities=").append(valueOf).append(", timeMillis=").append(j).append(", elapsedRealtimeMillis=").append(this.zziik).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.zziii, false);
        zzbfp.zza(parcel, 2, this.zziij);
        zzbfp.zza(parcel, 3, this.zziik);
        zzbfp.zzc(parcel, 4, this.zziil);
        zzbfp.zza(parcel, 5, this.extras, false);
        zzbfp.zzai(parcel, zze);
    }
}
