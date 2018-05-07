package com.google.android.gms.internal;

import java.util.Map;

final class zzebt implements zzebx {
    private /* synthetic */ String val$action;
    private /* synthetic */ zzebo zzmot;
    private /* synthetic */ zzece zzmow;
    private /* synthetic */ long zzmoy;
    private /* synthetic */ zzecc zzmoz;

    zzebt(zzebo com_google_android_gms_internal_zzebo, String str, long j, zzecc com_google_android_gms_internal_zzecc, zzece com_google_android_gms_internal_zzece) {
        this.zzmot = com_google_android_gms_internal_zzebo;
        this.val$action = str;
        this.zzmoy = j;
        this.zzmoz = com_google_android_gms_internal_zzecc;
        this.zzmow = com_google_android_gms_internal_zzece;
    }

    public final void zzaj(Map<String, Object> map) {
        if (this.zzmot.zzmlr.zzbzl()) {
            zzejc zza = this.zzmot.zzmlr;
            String str = this.val$action;
            String valueOf = String.valueOf(map);
            zza.zzb(new StringBuilder((String.valueOf(str).length() + 11) + String.valueOf(valueOf).length()).append(str).append(" response: ").append(valueOf).toString(), null, new Object[0]);
        }
        if (((zzecc) this.zzmot.zzmog.get(Long.valueOf(this.zzmoy))) == this.zzmoz) {
            this.zzmot.zzmog.remove(Long.valueOf(this.zzmoy));
            if (this.zzmow != null) {
                String str2 = (String) map.get("s");
                if (str2.equals("ok")) {
                    this.zzmow.zzbd(null, null);
                } else {
                    this.zzmow.zzbd(str2, (String) map.get("d"));
                }
            }
        } else if (this.zzmot.zzmlr.zzbzl()) {
            this.zzmot.zzmlr.zzb("Ignoring on complete for put " + this.zzmoy + " because it was removed already.", null, new Object[0]);
        }
        this.zzmot.zzbur();
    }
}
