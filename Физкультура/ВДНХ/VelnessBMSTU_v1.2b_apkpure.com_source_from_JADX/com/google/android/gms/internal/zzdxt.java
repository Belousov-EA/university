package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.internal.zzbq;

public final class zzdxt extends zzdvw implements HasOptions {
    private final String zzmbb;

    private zzdxt(@NonNull String str) {
        this.zzmbb = zzbq.zzh(str, "A valid API key must be provided");
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new zzdxu(this.zzmbb).zzbrq();
    }

    public final String getApiKey() {
        return this.zzmbb;
    }

    public final /* synthetic */ zzdvw zzbrj() {
        return (zzdxt) clone();
    }
}
