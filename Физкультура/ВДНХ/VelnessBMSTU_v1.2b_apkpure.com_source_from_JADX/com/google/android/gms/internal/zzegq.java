package com.google.android.gms.internal;

public final class zzegq {
    public static final zzegq zzmxs = new zzegq(zzegr.User, null, false);
    public static final zzegq zzmxt = new zzegq(zzegr.Server, null, false);
    private final zzegr zzmxu;
    private final zzeih zzmxv;
    private final boolean zzmxw;

    private zzegq(zzegr com_google_android_gms_internal_zzegr, zzeih com_google_android_gms_internal_zzeih, boolean z) {
        this.zzmxu = com_google_android_gms_internal_zzegr;
        this.zzmxv = com_google_android_gms_internal_zzeih;
        this.zzmxw = z;
    }

    public static zzegq zzc(zzeih com_google_android_gms_internal_zzeih) {
        return new zzegq(zzegr.Server, com_google_android_gms_internal_zzeih, true);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzmxu);
        String valueOf2 = String.valueOf(this.zzmxv);
        return new StringBuilder((String.valueOf(valueOf).length() + 52) + String.valueOf(valueOf2).length()).append("OperationSource{source=").append(valueOf).append(", queryParams=").append(valueOf2).append(", tagged=").append(this.zzmxw).append("}").toString();
    }

    public final boolean zzbxl() {
        return this.zzmxu == zzegr.User;
    }

    public final boolean zzbxm() {
        return this.zzmxw;
    }

    public final zzeih zzbxn() {
        return this.zzmxv;
    }
}
