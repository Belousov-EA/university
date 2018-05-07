package com.google.android.gms.internal;

final class zzejk extends zzear<zzejg, zzekd> {
    private boolean zznbz = false;
    private /* synthetic */ zzejl zznca;
    private /* synthetic */ zzeji zzncb;

    zzejk(zzeji com_google_android_gms_internal_zzeji, zzejl com_google_android_gms_internal_zzejl) {
        this.zzncb = com_google_android_gms_internal_zzeji;
        this.zznca = com_google_android_gms_internal_zzejl;
    }

    public final /* synthetic */ void zzh(Object obj, Object obj2) {
        zzejg com_google_android_gms_internal_zzejg = (zzejg) obj;
        zzekd com_google_android_gms_internal_zzekd = (zzekd) obj2;
        if (!this.zznbz && com_google_android_gms_internal_zzejg.zzi(zzejg.zzbzp()) > 0) {
            this.zznbz = true;
            this.zznca.zzb(zzejg.zzbzp(), this.zzncb.zzbzv());
        }
        this.zznca.zzb(com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzekd);
    }
}
