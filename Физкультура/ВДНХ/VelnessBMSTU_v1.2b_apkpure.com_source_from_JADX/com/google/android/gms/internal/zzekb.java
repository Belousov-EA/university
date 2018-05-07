package com.google.android.gms.internal;

public final class zzekb extends zzejy<zzekb> {
    private final long value;

    public zzekb(Long l, zzekd com_google_android_gms_internal_zzekd) {
        super(com_google_android_gms_internal_zzekd);
        this.value = l.longValue();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzekb)) {
            return false;
        }
        zzekb com_google_android_gms_internal_zzekb = (zzekb) obj;
        return this.value == com_google_android_gms_internal_zzekb.value && this.zznbx.equals(com_google_android_gms_internal_zzekb.zznbx);
    }

    public final Object getValue() {
        return Long.valueOf(this.value);
    }

    public final int hashCode() {
        return ((int) (this.value ^ (this.value >>> 32))) + this.zznbx.hashCode();
    }

    protected final /* synthetic */ int zza(zzejy com_google_android_gms_internal_zzejy) {
        return zzelt.zzi(this.value, ((zzekb) com_google_android_gms_internal_zzejy).value);
    }

    public final String zza(zzekf com_google_android_gms_internal_zzekf) {
        String valueOf = String.valueOf(String.valueOf(zzb(com_google_android_gms_internal_zzekf)).concat("number:"));
        String valueOf2 = String.valueOf(zzelt.zzk((double) this.value));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    protected final zzeka zzbzm() {
        return zzeka.Number;
    }

    public final /* synthetic */ zzekd zzf(zzekd com_google_android_gms_internal_zzekd) {
        return new zzekb(Long.valueOf(this.value), com_google_android_gms_internal_zzekd);
    }
}
