package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zzm;

abstract class zzbfz<R extends Result> extends zzm<R, zzbgb> {
    public zzbfz(GoogleApiClient googleApiClient) {
        super(zzbft.API, googleApiClient);
    }
}
