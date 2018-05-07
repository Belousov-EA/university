package com.google.android.gms.internal;

public final class zzeha {
    private static final zzehq<Boolean> zzmyi = new zzehb();
    private static final zzehq<Boolean> zzmyj = new zzehc();
    private static final zzehm<Boolean> zzmyk = new zzehm(Boolean.valueOf(true));
    private static final zzehm<Boolean> zzmyl = new zzehm(Boolean.valueOf(false));
    private final zzehm<Boolean> zzmyh;

    public zzeha() {
        this.zzmyh = zzehm.zzbxw();
    }

    private zzeha(zzehm<Boolean> com_google_android_gms_internal_zzehm_java_lang_Boolean) {
        this.zzmyh = com_google_android_gms_internal_zzehm_java_lang_Boolean;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeha)) {
            return false;
        }
        return this.zzmyh.equals(((zzeha) obj).zzmyh);
    }

    public final int hashCode() {
        return this.zzmyh.hashCode();
    }

    public final String toString() {
        String com_google_android_gms_internal_zzehm = this.zzmyh.toString();
        return new StringBuilder(String.valueOf(com_google_android_gms_internal_zzehm).length() + 14).append("{PruneForest:").append(com_google_android_gms_internal_zzehm).append("}").toString();
    }

    public final <T> T zza(T t, zzehp<Void, T> com_google_android_gms_internal_zzehp_java_lang_Void__T) {
        return this.zzmyh.zzb((Object) t, new zzehd(this, com_google_android_gms_internal_zzehp_java_lang_Void__T));
    }

    public final boolean zzbxs() {
        return this.zzmyh.zzb(zzmyj);
    }

    public final zzeha zzd(zzejg com_google_android_gms_internal_zzejg) {
        zzehm zze = this.zzmyh.zze(com_google_android_gms_internal_zzejg);
        zzehm com_google_android_gms_internal_zzehm = zze == null ? new zzehm((Boolean) this.zzmyh.getValue()) : (zze.getValue() != null || this.zzmyh.getValue() == null) ? zze : zze.zzb(zzedk.zzbwe(), (Boolean) this.zzmyh.getValue());
        return new zzeha(com_google_android_gms_internal_zzehm);
    }

    public final boolean zzv(zzedk com_google_android_gms_internal_zzedk) {
        Boolean bool = (Boolean) this.zzmyh.zzag(com_google_android_gms_internal_zzedk);
        return bool != null && bool.booleanValue();
    }

    public final boolean zzw(zzedk com_google_android_gms_internal_zzedk) {
        Boolean bool = (Boolean) this.zzmyh.zzag(com_google_android_gms_internal_zzedk);
        return (bool == null || bool.booleanValue()) ? false : true;
    }

    public final zzeha zzx(zzedk com_google_android_gms_internal_zzedk) {
        if (this.zzmyh.zzb(com_google_android_gms_internal_zzedk, zzmyi) == null) {
            return this.zzmyh.zzb(com_google_android_gms_internal_zzedk, zzmyj) != null ? this : new zzeha(this.zzmyh.zza(com_google_android_gms_internal_zzedk, zzmyk));
        } else {
            throw new IllegalArgumentException("Can't prune path that was kept previously!");
        }
    }

    public final zzeha zzy(zzedk com_google_android_gms_internal_zzedk) {
        return this.zzmyh.zzb(com_google_android_gms_internal_zzedk, zzmyi) != null ? this : new zzeha(this.zzmyh.zza(com_google_android_gms_internal_zzedk, zzmyl));
    }
}
