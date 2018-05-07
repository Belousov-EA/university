package com.google.android.gms.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzdvo extends WeakReference<Throwable> {
    private final int zzmal;

    public zzdvo(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, null);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.zzmal = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzdvo com_google_android_gms_internal_zzdvo = (zzdvo) obj;
        return this.zzmal == com_google_android_gms_internal_zzdvo.zzmal && get() == com_google_android_gms_internal_zzdvo.get();
    }

    public final int hashCode() {
        return this.zzmal;
    }
}
