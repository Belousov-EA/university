package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;

final class zzbm implements zzbo<R, T> {
    private /* synthetic */ Response zzgbk;

    zzbm(Response response) {
        this.zzgbk = response;
    }

    public final /* synthetic */ Object zzb(Result result) {
        this.zzgbk.setResult(result);
        return this.zzgbk;
    }
}
