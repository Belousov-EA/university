package com.google.android.gms.internal;

import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzbq;

public final class zzcgc {
    public static Looper zzavy() {
        zzbq.zza(Looper.myLooper() != null, (Object) "Can't create handler inside thread that has not called Looper.prepare()");
        return Looper.myLooper();
    }

    public static Looper zzb(@Nullable Looper looper) {
        return looper != null ? looper : zzavy();
    }
}
