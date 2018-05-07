package com.google.android.gms.internal;

final class zzecb {
    private final zzece zzmpl;
    private final zzebz zzmpm;
    private final zzebl zzmpn;
    private final Long zzmpo;

    private zzecb(zzece com_google_android_gms_internal_zzece, zzebz com_google_android_gms_internal_zzebz, Long l, zzebl com_google_android_gms_internal_zzebl) {
        this.zzmpl = com_google_android_gms_internal_zzece;
        this.zzmpm = com_google_android_gms_internal_zzebz;
        this.zzmpn = com_google_android_gms_internal_zzebl;
        this.zzmpo = l;
    }

    public final String toString() {
        String com_google_android_gms_internal_zzebz = this.zzmpm.toString();
        String valueOf = String.valueOf(this.zzmpo);
        return new StringBuilder((String.valueOf(com_google_android_gms_internal_zzebz).length() + 8) + String.valueOf(valueOf).length()).append(com_google_android_gms_internal_zzebz).append(" (Tag: ").append(valueOf).append(")").toString();
    }

    public final zzebz zzbuu() {
        return this.zzmpm;
    }

    public final Long zzbuv() {
        return this.zzmpo;
    }

    public final zzebl zzbuw() {
        return this.zzmpn;
    }
}
