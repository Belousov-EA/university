package com.google.android.gms.internal;

import com.google.android.gms.internal.zzffu.zzg;

final class zzffi implements zzfji {
    private final zzffg zzpfl;

    private zzffi(zzffg com_google_android_gms_internal_zzffg) {
        this.zzpfl = (zzffg) zzffz.zzc(com_google_android_gms_internal_zzffg, "output");
    }

    public static zzffi zzb(zzffg com_google_android_gms_internal_zzffg) {
        return com_google_android_gms_internal_zzffg.zzpga != null ? com_google_android_gms_internal_zzffg.zzpga : new zzffi(com_google_android_gms_internal_zzffg);
    }

    public final void zzb(int i, Object obj) {
        try {
            if (obj instanceof zzfes) {
                this.zzpfl.zzb(i, (zzfes) obj);
            } else {
                this.zzpfl.zzb(i, (zzfhe) obj);
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final int zzcwv() {
        return zzg.zzphn;
    }
}
