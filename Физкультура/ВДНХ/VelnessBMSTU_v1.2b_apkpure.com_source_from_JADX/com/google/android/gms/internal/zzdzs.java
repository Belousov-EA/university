package com.google.android.gms.internal;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.GetTokenResult;

final class zzdzs implements OnSuccessListener<GetTokenResult> {
    private /* synthetic */ zzecu zzmlh;

    zzdzs(zzdzq com_google_android_gms_internal_zzdzq, zzecu com_google_android_gms_internal_zzecu) {
        this.zzmlh = com_google_android_gms_internal_zzecu;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.zzmlh.zzpl(((GetTokenResult) obj).getToken());
    }
}
