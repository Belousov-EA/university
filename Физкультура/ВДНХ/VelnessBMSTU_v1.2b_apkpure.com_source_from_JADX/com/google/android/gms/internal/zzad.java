package com.google.android.gms.internal;

public class zzad extends Exception {
    private long zzae;
    private zzp zzbk;

    public zzad() {
        this.zzbk = null;
    }

    public zzad(zzp com_google_android_gms_internal_zzp) {
        this.zzbk = com_google_android_gms_internal_zzp;
    }

    public zzad(String str) {
        super(str);
        this.zzbk = null;
    }

    public zzad(Throwable th) {
        super(th);
        this.zzbk = null;
    }

    final void zza(long j) {
        this.zzae = j;
    }
}
