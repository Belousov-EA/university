package com.google.android.gms.internal;

final class zzefm implements zzehp<zzefg, Void> {
    private /* synthetic */ zzefh zzmvz;

    zzefm(zzefh com_google_android_gms_internal_zzefh) {
        this.zzmvz = com_google_android_gms_internal_zzefh;
    }

    public final /* synthetic */ Object zza(zzedk com_google_android_gms_internal_zzedk, Object obj, Object obj2) {
        zzefg com_google_android_gms_internal_zzefg = (zzefg) obj;
        zzeik zzbyz;
        if (com_google_android_gms_internal_zzedk.isEmpty() || !com_google_android_gms_internal_zzefg.zzbwt()) {
            for (zzeil zzbyz2 : com_google_android_gms_internal_zzefg.zzbws()) {
                zzbyz = zzbyz2.zzbyz();
                this.zzmvz.zzmvt.zza(zzefh.zzd(zzbyz), this.zzmvz.zze(zzbyz));
            }
        } else {
            zzbyz = com_google_android_gms_internal_zzefg.zzbwu().zzbyz();
            this.zzmvz.zzmvt.zza(zzefh.zzd(zzbyz), this.zzmvz.zze(zzbyz));
        }
        return null;
    }
}
