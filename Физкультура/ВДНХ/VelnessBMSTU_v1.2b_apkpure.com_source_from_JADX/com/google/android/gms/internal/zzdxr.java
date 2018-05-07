package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;

public final class zzdxr {
    private static zzf<zzdxk> zzebf = new zzf();
    private static final zza<zzdxk, zzdxt> zzmfb = new zzdxs();
    public static final Api<zzdxt> zzmfc = new Api("InternalFirebaseAuth.FIREBASE_AUTH_API", zzmfb, zzebf);

    public static zzdwc zza(Context context, zzdxt com_google_android_gms_internal_zzdxt) {
        return new zzdwc(context, com_google_android_gms_internal_zzdxt);
    }
}
