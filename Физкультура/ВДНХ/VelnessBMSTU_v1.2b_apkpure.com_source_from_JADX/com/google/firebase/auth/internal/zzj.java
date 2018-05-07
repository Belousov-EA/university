package com.google.firebase.auth.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzdyi;
import com.google.firebase.auth.ProviderQueryResult;
import java.util.List;

public final class zzj implements ProviderQueryResult {
    private List<String> zzmhm;

    public zzj(@NonNull zzdyi com_google_android_gms_internal_zzdyi) {
        zzbq.checkNotNull(com_google_android_gms_internal_zzdyi);
        this.zzmhm = com_google_android_gms_internal_zzdyi.getAllProviders();
    }

    @Nullable
    public final List<String> getProviders() {
        return this.zzmhm;
    }
}
