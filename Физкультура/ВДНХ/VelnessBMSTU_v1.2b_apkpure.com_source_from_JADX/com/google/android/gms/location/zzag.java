package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Collections;
import java.util.List;

public final class zzag extends zzbfm {
    public static final Creator<zzag> CREATOR = new zzah();
    private final String mTag;
    private final PendingIntent zzeeo;
    private final List<String> zzikp;

    zzag(@Nullable List<String> list, @Nullable PendingIntent pendingIntent, String str) {
        this.zzikp = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.zzeeo = pendingIntent;
        this.mTag = str;
    }

    public static zzag zzac(List<String> list) {
        zzbq.checkNotNull(list, "geofence can't be null.");
        zzbq.checkArgument(!list.isEmpty(), "Geofences must contains at least one id.");
        return new zzag(list, null, "");
    }

    public static zzag zzb(PendingIntent pendingIntent) {
        zzbq.checkNotNull(pendingIntent, "PendingIntent can not be null.");
        return new zzag(null, pendingIntent, "");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzb(parcel, 1, this.zzikp, false);
        zzbfp.zza(parcel, 2, this.zzeeo, i, false);
        zzbfp.zza(parcel, 3, this.mTag, false);
        zzbfp.zzai(parcel, zze);
    }
}
