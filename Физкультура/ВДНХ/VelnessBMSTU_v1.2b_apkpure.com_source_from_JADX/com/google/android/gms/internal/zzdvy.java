package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.zzcz;

final class zzdvy {
    private Context mContext;
    private Api zzfin;
    private zzcz zzfmh;

    zzdvy(zzdvv com_google_android_gms_internal_zzdvv, Context context, Api api, zzcz com_google_android_gms_common_api_internal_zzcz) {
        this.mContext = context;
        this.zzfin = api;
        this.zzfmh = com_google_android_gms_common_api_internal_zzcz;
    }

    final GoogleApi<O> zza(zzdvw com_google_android_gms_internal_zzdvw) {
        return new zzdvz(this.mContext, this.zzfin, com_google_android_gms_internal_zzdvw, this.zzfmh);
    }
}
