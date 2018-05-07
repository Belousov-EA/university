package com.google.android.gms.internal;

import com.google.firebase.FirebaseApp.zza;

final class zzdzz implements zza {
    private /* synthetic */ zzebm zzmlp;

    zzdzz(zzdzw com_google_android_gms_internal_zzdzw, zzebm com_google_android_gms_internal_zzebm) {
        this.zzmlp = com_google_android_gms_internal_zzebm;
    }

    public final void zzbf(boolean z) {
        if (z) {
            this.zzmlp.interrupt("app_in_background");
        } else {
            this.zzmlp.resume("app_in_background");
        }
    }
}
