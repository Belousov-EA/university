package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.zzl;

final class zzt implements zzl {
    private /* synthetic */ zzs zzmid;

    zzt(zzs com_google_firebase_auth_internal_zzs) {
        this.zzmid = com_google_firebase_auth_internal_zzs;
    }

    public final void zzbf(boolean z) {
        if (z) {
            this.zzmid.zzmic = true;
            this.zzmid.cancel();
            return;
        }
        this.zzmid.zzmic = false;
        if (this.zzmid.zzbsi()) {
            this.zzmid.zzmib.zzbsd();
        }
    }
}
