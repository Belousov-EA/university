package com.google.android.gms.internal;

public final class zzejt extends zzejy<zzejt> {
    private final Double zzncn;

    public zzejt(Double d, zzekd com_google_android_gms_internal_zzekd) {
        super(com_google_android_gms_internal_zzekd);
        this.zzncn = d;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzejt)) {
            return false;
        }
        zzejt com_google_android_gms_internal_zzejt = (zzejt) obj;
        return this.zzncn.equals(com_google_android_gms_internal_zzejt.zzncn) && this.zznbx.equals(com_google_android_gms_internal_zzejt.zznbx);
    }

    public final Object getValue() {
        return this.zzncn;
    }

    public final int hashCode() {
        return this.zzncn.hashCode() + this.zznbx.hashCode();
    }

    protected final /* synthetic */ int zza(zzejy com_google_android_gms_internal_zzejy) {
        return this.zzncn.compareTo(((zzejt) com_google_android_gms_internal_zzejy).zzncn);
    }

    public final String zza(zzekf com_google_android_gms_internal_zzekf) {
        String valueOf = String.valueOf(String.valueOf(zzb(com_google_android_gms_internal_zzekf)).concat("number:"));
        String valueOf2 = String.valueOf(zzelt.zzk(this.zzncn.doubleValue()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    protected final zzeka zzbzm() {
        return zzeka.Number;
    }

    public final /* synthetic */ zzekd zzf(zzekd com_google_android_gms_internal_zzekd) {
        return new zzejt(this.zzncn, com_google_android_gms_internal_zzekd);
    }
}
