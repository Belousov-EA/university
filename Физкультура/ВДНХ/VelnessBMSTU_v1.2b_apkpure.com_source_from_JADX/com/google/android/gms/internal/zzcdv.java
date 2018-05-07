package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;

public final class zzcdv extends zzbfm {
    public static final Creator<zzcdv> CREATOR = new zzcdw();
    private String packageName;
    private int uid;

    public zzcdv(int i, String str) {
        this.uid = i;
        this.packageName = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof zzcdv)) {
            return false;
        }
        zzcdv com_google_android_gms_internal_zzcdv = (zzcdv) obj;
        return com_google_android_gms_internal_zzcdv.uid == this.uid && zzbg.equal(com_google_android_gms_internal_zzcdv.packageName, this.packageName);
    }

    public final int hashCode() {
        return this.uid;
    }

    public final String toString() {
        return String.format("%d:%s", new Object[]{Integer.valueOf(this.uid), this.packageName});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.uid);
        zzbfp.zza(parcel, 2, this.packageName, false);
        zzbfp.zzai(parcel, zze);
    }
}
