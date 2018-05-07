package com.google.android.gms.internal;

import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;

final class zzdyc implements zzdyg {
    private /* synthetic */ PhoneAuthCredential zzmga;

    zzdyc(zzdya com_google_android_gms_internal_zzdya, PhoneAuthCredential phoneAuthCredential) {
        this.zzmga = phoneAuthCredential;
    }

    public final void zza(OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationCompleted(this.zzmga);
    }
}
