package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.internal.zzbq;

public final class zzce {
    private final Object zzfuc;

    public zzce(Activity activity) {
        zzbq.checkNotNull(activity, "Activity must not be null");
        this.zzfuc = activity;
    }

    public final boolean zzajj() {
        return this.zzfuc instanceof FragmentActivity;
    }

    public final boolean zzajk() {
        return this.zzfuc instanceof Activity;
    }

    public final Activity zzajl() {
        return (Activity) this.zzfuc;
    }

    public final FragmentActivity zzajm() {
        return (FragmentActivity) this.zzfuc;
    }
}
