package com.google.android.gms.internal;

import java.util.Iterator;

final class zzeay implements Iterator<zzeaz> {
    private int zzmmw = (this.zzmmx.length - 1);
    private /* synthetic */ zzeax zzmmx;

    zzeay(zzeax com_google_android_gms_internal_zzeax) {
        this.zzmmx = com_google_android_gms_internal_zzeax;
    }

    public final boolean hasNext() {
        return this.zzmmw >= 0;
    }

    public final /* synthetic */ Object next() {
        boolean z = true;
        long zzb = this.zzmmx.value & ((long) (1 << this.zzmmw));
        zzeaz com_google_android_gms_internal_zzeaz = new zzeaz();
        if (zzb != 0) {
            z = false;
        }
        com_google_android_gms_internal_zzeaz.zzmmy = z;
        com_google_android_gms_internal_zzeaz.zzmmz = (int) Math.pow(2.0d, (double) this.zzmmw);
        this.zzmmw--;
        return com_google_android_gms_internal_zzeaz;
    }

    public final void remove() {
    }
}
