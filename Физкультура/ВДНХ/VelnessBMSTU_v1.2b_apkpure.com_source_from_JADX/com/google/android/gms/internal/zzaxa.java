package com.google.android.gms.internal;

import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.Status;

final class zzaxa implements ProxyResult {
    private Status mStatus;
    private ProxyResponse zzegq;

    public zzaxa(ProxyResponse proxyResponse) {
        this.zzegq = proxyResponse;
        this.mStatus = Status.zzfni;
    }

    public zzaxa(Status status) {
        this.mStatus = status;
    }

    public final ProxyResponse getResponse() {
        return this.zzegq;
    }

    public final Status getStatus() {
        return this.mStatus;
    }
}
