package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;

final class zzdye implements zzdyg {
    private /* synthetic */ Status zzenv;

    zzdye(zzdya com_google_android_gms_internal_zzdya, Status status) {
        this.zzenv = status;
    }

    public final void zza(OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationFailed(zzdxm.zzao(this.zzenv));
    }
}
