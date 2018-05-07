package com.google.android.gms.internal;

public final class zzejf extends zzejy<zzejf> {
    private final boolean value;

    public zzejf(Boolean bool, zzekd com_google_android_gms_internal_zzekd) {
        super(com_google_android_gms_internal_zzekd);
        this.value = bool.booleanValue();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzejf)) {
            return false;
        }
        zzejf com_google_android_gms_internal_zzejf = (zzejf) obj;
        return this.value == com_google_android_gms_internal_zzejf.value && this.zznbx.equals(com_google_android_gms_internal_zzejf.zznbx);
    }

    public final Object getValue() {
        return Boolean.valueOf(this.value);
    }

    public final int hashCode() {
        return (this.value ? 1 : 0) + this.zznbx.hashCode();
    }

    protected final /* synthetic */ int zza(zzejy com_google_android_gms_internal_zzejy) {
        return this.value == ((zzejf) com_google_android_gms_internal_zzejy).value ? 0 : this.value ? 1 : -1;
    }

    public final String zza(zzekf com_google_android_gms_internal_zzekf) {
        String zzb = zzb(com_google_android_gms_internal_zzekf);
        return new StringBuilder(String.valueOf(zzb).length() + 13).append(zzb).append("boolean:").append(this.value).toString();
    }

    protected final zzeka zzbzm() {
        return zzeka.Boolean;
    }

    public final /* synthetic */ zzekd zzf(zzekd com_google_android_gms_internal_zzekd) {
        return new zzejf(Boolean.valueOf(this.value), com_google_android_gms_internal_zzekd);
    }
}
