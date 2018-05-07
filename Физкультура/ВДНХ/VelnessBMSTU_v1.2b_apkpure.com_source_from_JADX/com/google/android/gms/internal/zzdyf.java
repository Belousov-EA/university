package com.google.android.gms.internal;

import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;

final class zzdyf implements Runnable {
    private /* synthetic */ zzdyg zzmgb;
    private /* synthetic */ zzdya zzmgc;

    zzdyf(zzdya com_google_android_gms_internal_zzdya, zzdyg com_google_android_gms_internal_zzdyg) {
        this.zzmgc = com_google_android_gms_internal_zzdya;
        this.zzmgb = com_google_android_gms_internal_zzdyg;
    }

    public final void run() {
        synchronized (this.zzmgc.zzmfy.zzmfk) {
            if (!this.zzmgc.zzmfy.zzmfk.isEmpty()) {
                this.zzmgb.zza((OnVerificationStateChangedCallbacks) this.zzmgc.zzmfy.zzmfk.get(0), new Object[0]);
            }
        }
    }
}
