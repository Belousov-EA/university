package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class zzeil {
    private final zzeik zzmzz;
    private final zzeio zznaq;
    private zzein zznar;
    private final List<zzedh> zznas = new ArrayList();
    private final zzeid zznat;

    public zzeil(zzeik com_google_android_gms_internal_zzeik, zzein com_google_android_gms_internal_zzein) {
        this.zzmzz = com_google_android_gms_internal_zzeik;
        zzeiu com_google_android_gms_internal_zzeiu = new zzeiu(com_google_android_gms_internal_zzeik.zzbyr());
        zzeiw zzbyx = com_google_android_gms_internal_zzeik.zzbyy().zzbyx();
        this.zznaq = new zzeio(zzbyx);
        zzehx zzbze = com_google_android_gms_internal_zzein.zzbze();
        zzehx zzbzc = com_google_android_gms_internal_zzein.zzbzc();
        zzejw zza = zzejw.zza(zzeju.zzcaf(), com_google_android_gms_internal_zzeik.zzbyr());
        zzejw zza2 = com_google_android_gms_internal_zzeiu.zza(zza, zzbze.zzbyb(), null);
        zza = zzbyx.zza(zza, zzbzc.zzbyb(), null);
        this.zznar = new zzein(new zzehx(zza, zzbzc.zzbxz(), zzbyx.zzbzi()), new zzehx(zza2, zzbze.zzbxz(), false));
        this.zznat = new zzeid(com_google_android_gms_internal_zzeik);
    }

    private final List<zzeia> zza(List<zzehz> list, zzejw com_google_android_gms_internal_zzejw, zzedh com_google_android_gms_internal_zzedh) {
        List list2;
        if (com_google_android_gms_internal_zzedh == null) {
            list2 = this.zznas;
        } else {
            list2 = Arrays.asList(new zzedh[]{com_google_android_gms_internal_zzedh});
        }
        return this.zznat.zza(list, com_google_android_gms_internal_zzejw, list2);
    }

    public final boolean isEmpty() {
        return this.zznas.isEmpty();
    }

    public final List<zzeib> zza(zzedh com_google_android_gms_internal_zzedh, DatabaseError databaseError) {
        zzedh com_google_android_gms_internal_zzedh2;
        List<zzeib> list;
        if (databaseError != null) {
            List<zzeib> arrayList = new ArrayList();
            zzedk zzbsy = this.zzmzz.zzbsy();
            for (zzedh com_google_android_gms_internal_zzedh22 : this.zznas) {
                arrayList.add(new zzehy(com_google_android_gms_internal_zzedh22, databaseError, zzbsy));
            }
            list = arrayList;
        } else {
            list = Collections.emptyList();
        }
        if (com_google_android_gms_internal_zzedh != null) {
            int i = 0;
            int i2 = -1;
            while (i < this.zznas.size()) {
                com_google_android_gms_internal_zzedh22 = (zzedh) this.zznas.get(i);
                if (com_google_android_gms_internal_zzedh22.zzc(com_google_android_gms_internal_zzedh)) {
                    if (com_google_android_gms_internal_zzedh22.zzbwd()) {
                        break;
                    }
                    i2 = i;
                }
                i++;
            }
            i = i2;
            if (i != -1) {
                com_google_android_gms_internal_zzedh22 = (zzedh) this.zznas.get(i);
                this.zznas.remove(i);
                com_google_android_gms_internal_zzedh22.zzbwc();
            }
        } else {
            for (zzedh com_google_android_gms_internal_zzedh222 : this.zznas) {
                com_google_android_gms_internal_zzedh222.zzbwc();
            }
            this.zznas.clear();
        }
        return list;
    }

    public final zzeim zzb(zzego com_google_android_gms_internal_zzego, zzegj com_google_android_gms_internal_zzegj, zzekd com_google_android_gms_internal_zzekd) {
        if (com_google_android_gms_internal_zzego.zzbxk() == zzegp.Merge) {
            com_google_android_gms_internal_zzego.zzbxj().zzbxn();
        }
        zzeir zza = this.zznaq.zza(this.zznar, com_google_android_gms_internal_zzego, com_google_android_gms_internal_zzegj, com_google_android_gms_internal_zzekd);
        this.zznar = zza.zznar;
        return new zzeim(zza(zza.zznav, zza.zznar.zzbzc().zzbyb(), null), zza.zznav);
    }

    public final void zzb(zzedh com_google_android_gms_internal_zzedh) {
        this.zznas.add(com_google_android_gms_internal_zzedh);
    }

    public final zzeik zzbyz() {
        return this.zzmzz;
    }

    public final zzekd zzbza() {
        return this.zznar.zzbze().zzbsv();
    }

    public final zzekd zzbzb() {
        return this.zznar.zzbzc().zzbsv();
    }

    public final List<zzeia> zzk(zzedh com_google_android_gms_internal_zzedh) {
        zzehx zzbzc = this.zznar.zzbzc();
        List arrayList = new ArrayList();
        for (zzekc com_google_android_gms_internal_zzekc : zzbzc.zzbsv()) {
            arrayList.add(zzehz.zzc(com_google_android_gms_internal_zzekc.zzcao(), com_google_android_gms_internal_zzekc.zzbsv()));
        }
        if (zzbzc.zzbxz()) {
            arrayList.add(zzehz.zza(zzbzc.zzbyb()));
        }
        return zza(arrayList, zzbzc.zzbyb(), com_google_android_gms_internal_zzedh);
    }

    public final zzekd zzr(zzedk com_google_android_gms_internal_zzedk) {
        zzekd zzbzf = this.zznar.zzbzf();
        return (zzbzf == null || (!this.zzmzz.zzbyv() && (com_google_android_gms_internal_zzedk.isEmpty() || zzbzf.zzm(com_google_android_gms_internal_zzedk.zzbwh()).isEmpty()))) ? null : zzbzf.zzan(com_google_android_gms_internal_zzedk);
    }
}
