package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class zzdyq extends zzbfm {
    public static final Creator<zzdyq> CREATOR = new zzdyr();
    private List<zzdyo> zzmgq;

    public zzdyq() {
        this.zzmgq = new ArrayList();
    }

    zzdyq(List<zzdyo> list) {
        if (list == null || list.isEmpty()) {
            this.zzmgq = Collections.emptyList();
        } else {
            this.zzmgq = Collections.unmodifiableList(list);
        }
    }

    public static zzdyq zza(zzdyq com_google_android_gms_internal_zzdyq) {
        Collection collection = com_google_android_gms_internal_zzdyq.zzmgq;
        zzdyq com_google_android_gms_internal_zzdyq2 = new zzdyq();
        if (collection != null) {
            com_google_android_gms_internal_zzdyq2.zzmgq.addAll(collection);
        }
        return com_google_android_gms_internal_zzdyq2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 2, this.zzmgq, false);
        zzbfp.zzai(parcel, zze);
    }

    public final List<zzdyo> zzbrt() {
        return this.zzmgq;
    }
}
