package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import java.util.concurrent.atomic.AtomicReference;

final class zzbc implements ConnectionCallbacks {
    private /* synthetic */ zzba zzfsj;
    private /* synthetic */ AtomicReference zzfsk;
    private /* synthetic */ zzda zzfsl;

    zzbc(zzba com_google_android_gms_common_api_internal_zzba, AtomicReference atomicReference, zzda com_google_android_gms_common_api_internal_zzda) {
        this.zzfsj = com_google_android_gms_common_api_internal_zzba;
        this.zzfsk = atomicReference;
        this.zzfsl = com_google_android_gms_common_api_internal_zzda;
    }

    public final void onConnected(Bundle bundle) {
        this.zzfsj.zza((GoogleApiClient) this.zzfsk.get(), this.zzfsl, true);
    }

    public final void onConnectionSuspended(int i) {
    }
}
