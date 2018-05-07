package com.google.android.gms.internal;

import java.util.List;

final class zzefn extends zzear<zzejg, zzehm<zzefg>> {
    private /* synthetic */ List zzmtm;
    private /* synthetic */ zzefh zzmvz;
    private /* synthetic */ zzekd zzmwe;
    private /* synthetic */ zzegj zzmwf;
    private /* synthetic */ zzego zzmwg;

    zzefn(zzefh com_google_android_gms_internal_zzefh, zzekd com_google_android_gms_internal_zzekd, zzegj com_google_android_gms_internal_zzegj, zzego com_google_android_gms_internal_zzego, List list) {
        this.zzmvz = com_google_android_gms_internal_zzefh;
        this.zzmwe = com_google_android_gms_internal_zzekd;
        this.zzmwf = com_google_android_gms_internal_zzegj;
        this.zzmwg = com_google_android_gms_internal_zzego;
        this.zzmtm = list;
    }

    public final /* synthetic */ void zzh(Object obj, Object obj2) {
        zzejg com_google_android_gms_internal_zzejg = (zzejg) obj;
        zzehm com_google_android_gms_internal_zzehm = (zzehm) obj2;
        zzekd com_google_android_gms_internal_zzekd = null;
        if (this.zzmwe != null) {
            com_google_android_gms_internal_zzekd = this.zzmwe.zzm(com_google_android_gms_internal_zzejg);
        }
        zzegj zzb = this.zzmwf.zzb(com_google_android_gms_internal_zzejg);
        zzego zzc = this.zzmwg.zzc(com_google_android_gms_internal_zzejg);
        if (zzc != null) {
            this.zzmtm.addAll(this.zzmvz.zzb(zzc, com_google_android_gms_internal_zzehm, com_google_android_gms_internal_zzekd, zzb));
        }
    }
}
