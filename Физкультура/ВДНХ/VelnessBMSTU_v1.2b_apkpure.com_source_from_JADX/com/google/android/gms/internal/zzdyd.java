package com.google.android.gms.internal;

import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;

final class zzdyd implements zzdyg {
    private /* synthetic */ String zzmfz;

    zzdyd(zzdya com_google_android_gms_internal_zzdya, String str) {
        this.zzmfz = str;
    }

    public final void zza(OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onCodeAutoRetrievalTimeOut(this.zzmfz);
    }
}
