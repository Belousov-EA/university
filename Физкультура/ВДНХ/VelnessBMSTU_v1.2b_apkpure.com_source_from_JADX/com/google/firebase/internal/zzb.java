package com.google.firebase.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public final class zzb {
    private static final AtomicReference<zzb> zzmba = new AtomicReference();

    private zzb(Context context) {
    }

    @Nullable
    public static zzb zzcjr() {
        return (zzb) zzmba.get();
    }

    public static Set<String> zzcjs() {
        return Collections.emptySet();
    }

    public static zzb zzew(Context context) {
        zzmba.compareAndSet(null, new zzb(context));
        return (zzb) zzmba.get();
    }

    public static void zzg(@NonNull FirebaseApp firebaseApp) {
    }

    public static FirebaseOptions zzrq(@NonNull String str) {
        return null;
    }
}
