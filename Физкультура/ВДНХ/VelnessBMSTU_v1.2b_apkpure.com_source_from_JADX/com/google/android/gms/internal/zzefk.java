package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Callable;

final class zzefk implements Callable<List<? extends zzeib>> {
    private /* synthetic */ zzefh zzmvz;
    private /* synthetic */ zzedh zzmwc;

    zzefk(zzefh com_google_android_gms_internal_zzefh, zzedh com_google_android_gms_internal_zzedh) {
        this.zzmvz = com_google_android_gms_internal_zzefh;
        this.zzmwc = com_google_android_gms_internal_zzedh;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzefg com_google_android_gms_internal_zzefg;
        zzekd com_google_android_gms_internal_zzekd;
        zzefg com_google_android_gms_internal_zzefg2;
        zzehx com_google_android_gms_internal_zzehx;
        zzeik zzbvp = this.zzmwc.zzbvp();
        zzedk zzbsy = zzbvp.zzbsy();
        zzekd com_google_android_gms_internal_zzekd2 = null;
        zzedk com_google_android_gms_internal_zzedk = zzbsy;
        zzehm zzd = this.zzmvz.zzmvo;
        boolean z = false;
        while (!zzd.isEmpty()) {
            boolean z2;
            zzekd com_google_android_gms_internal_zzekd3;
            com_google_android_gms_internal_zzefg = (zzefg) zzd.getValue();
            if (com_google_android_gms_internal_zzefg != null) {
                if (com_google_android_gms_internal_zzekd2 == null) {
                    com_google_android_gms_internal_zzekd2 = com_google_android_gms_internal_zzefg.zzr(com_google_android_gms_internal_zzedk);
                }
                z2 = z || com_google_android_gms_internal_zzefg.zzbwt();
                com_google_android_gms_internal_zzekd3 = com_google_android_gms_internal_zzekd2;
            } else {
                z2 = z;
                com_google_android_gms_internal_zzekd3 = com_google_android_gms_internal_zzekd2;
            }
            zzd = zzd.zze(com_google_android_gms_internal_zzedk.isEmpty() ? zzejg.zzpz("") : com_google_android_gms_internal_zzedk.zzbwh());
            com_google_android_gms_internal_zzedk = com_google_android_gms_internal_zzedk.zzbwi();
            com_google_android_gms_internal_zzekd2 = com_google_android_gms_internal_zzekd3;
            z = z2;
        }
        com_google_android_gms_internal_zzefg = (zzefg) this.zzmvz.zzmvo.zzaj(zzbsy);
        zzefg com_google_android_gms_internal_zzefg3;
        boolean z3;
        if (com_google_android_gms_internal_zzefg == null) {
            com_google_android_gms_internal_zzefg = new zzefg(this.zzmvz.zzmvn);
            this.zzmvz.zzmvo = this.zzmvz.zzmvo.zzb(zzbsy, (Object) com_google_android_gms_internal_zzefg);
            com_google_android_gms_internal_zzefg3 = com_google_android_gms_internal_zzefg;
            com_google_android_gms_internal_zzekd = com_google_android_gms_internal_zzekd2;
            z3 = z;
            com_google_android_gms_internal_zzefg2 = com_google_android_gms_internal_zzefg3;
        } else {
            z = z || com_google_android_gms_internal_zzefg.zzbwt();
            if (com_google_android_gms_internal_zzekd2 == null) {
                com_google_android_gms_internal_zzekd2 = com_google_android_gms_internal_zzefg.zzr(zzedk.zzbwe());
            }
            com_google_android_gms_internal_zzefg3 = com_google_android_gms_internal_zzefg;
            com_google_android_gms_internal_zzekd = com_google_android_gms_internal_zzekd2;
            z3 = z;
            com_google_android_gms_internal_zzefg2 = com_google_android_gms_internal_zzefg3;
        }
        this.zzmvz.zzmvn.zzg(zzbvp);
        if (com_google_android_gms_internal_zzekd != null) {
            com_google_android_gms_internal_zzehx = new zzehx(zzejw.zza(com_google_android_gms_internal_zzekd, zzbvp.zzbyr()), true, false);
        } else {
            zzehx zzf = this.zzmvz.zzmvn.zzf(zzbvp);
            if (zzf.zzbxz()) {
                com_google_android_gms_internal_zzehx = zzf;
            } else {
                zzekd zzcaf = zzeju.zzcaf();
                Iterator it = this.zzmvz.zzmvo.zzah(zzbsy).zzbxx().iterator();
                while (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    zzefg com_google_android_gms_internal_zzefg4 = (zzefg) ((zzehm) entry.getValue()).getValue();
                    if (com_google_android_gms_internal_zzefg4 != null) {
                        zzekd zzr = com_google_android_gms_internal_zzefg4.zzr(zzedk.zzbwe());
                        if (zzr != null) {
                            com_google_android_gms_internal_zzekd = zzcaf.zze((zzejg) entry.getKey(), zzr);
                            zzcaf = com_google_android_gms_internal_zzekd;
                        }
                    }
                    com_google_android_gms_internal_zzekd = zzcaf;
                    zzcaf = com_google_android_gms_internal_zzekd;
                }
                for (zzekc com_google_android_gms_internal_zzekc : zzf.zzbsv()) {
                    if (!zzcaf.zzk(com_google_android_gms_internal_zzekc.zzcao())) {
                        zzcaf = zzcaf.zze(com_google_android_gms_internal_zzekc.zzcao(), com_google_android_gms_internal_zzekc.zzbsv());
                    }
                }
                com_google_android_gms_internal_zzehx = new zzehx(zzejw.zza(zzcaf, zzbvp.zzbyr()), false, false);
            }
        }
        boolean zzc = com_google_android_gms_internal_zzefg2.zzc(zzbvp);
        if (!(zzc || zzbvp.zzbyv())) {
            zzega zzf2 = this.zzmvz.zzbww();
            this.zzmvz.zzmvr.put(zzbvp, zzf2);
            this.zzmvz.zzmvq.put(zzf2, zzbvp);
        }
        List zza = com_google_android_gms_internal_zzefg2.zza(this.zzmwc, this.zzmvz.zzmvp.zzt(zzbsy), com_google_android_gms_internal_zzehx);
        if (!(zzc || r4)) {
            this.zzmvz.zza(zzbvp, com_google_android_gms_internal_zzefg2.zzb(zzbvp));
        }
        return zza;
    }
}
