package com.google.firebase.auth.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.internal.zzdys;
import com.google.firebase.auth.ActionCodeResult;

public final class zzc implements ActionCodeResult {
    private final String zzegs;
    private final int zzikz;
    private final String zzmhd;

    public zzc(@NonNull zzdys com_google_android_gms_internal_zzdys) {
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzdys.zzbry())) {
            this.zzegs = com_google_android_gms_internal_zzdys.getEmail();
        } else {
            this.zzegs = com_google_android_gms_internal_zzdys.zzbry();
        }
        this.zzmhd = com_google_android_gms_internal_zzdys.getEmail();
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzdys.zzbrz())) {
            this.zzikz = 3;
        } else if (com_google_android_gms_internal_zzdys.zzbrz().equals("PASSWORD_RESET")) {
            this.zzikz = 0;
        } else if (com_google_android_gms_internal_zzdys.zzbrz().equals("VERIFY_EMAIL")) {
            this.zzikz = 1;
        } else if (com_google_android_gms_internal_zzdys.zzbrz().equals("RECOVER_EMAIL")) {
            this.zzikz = 2;
        } else {
            this.zzikz = 3;
        }
    }

    @Nullable
    public final String getData(int i) {
        switch (i) {
            case 0:
                return this.zzegs;
            case 1:
                return this.zzmhd;
            default:
                return null;
        }
    }

    public final int getOperation() {
        return this.zzikz;
    }
}
