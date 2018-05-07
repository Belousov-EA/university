package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class zzbfj extends ConstantState {
    int mChangingConfigurations;
    int zzfyc;

    zzbfj(zzbfj com_google_android_gms_internal_zzbfj) {
        if (com_google_android_gms_internal_zzbfj != null) {
            this.mChangingConfigurations = com_google_android_gms_internal_zzbfj.mChangingConfigurations;
            this.zzfyc = com_google_android_gms_internal_zzbfj.zzfyc;
        }
    }

    public final int getChangingConfigurations() {
        return this.mChangingConfigurations;
    }

    public final Drawable newDrawable() {
        return new zzbff(this);
    }
}
