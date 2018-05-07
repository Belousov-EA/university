package com.google.android.gms.internal;

import java.util.Iterator;

public final class zzeiv implements zzeiw {
    private final int limit;
    private final zzejv zznaa;
    private final zzeiy zznbe;
    private final boolean zznbf;

    public zzeiv(zzeih com_google_android_gms_internal_zzeih) {
        this.zznbe = new zzeiy(com_google_android_gms_internal_zzeih);
        this.zznaa = com_google_android_gms_internal_zzeih.zzbyr();
        this.limit = com_google_android_gms_internal_zzeih.getLimit();
        this.zznbf = !com_google_android_gms_internal_zzeih.zzbyt();
    }

    public final zzejw zza(zzejw com_google_android_gms_internal_zzejw, zzejg com_google_android_gms_internal_zzejg, zzekd com_google_android_gms_internal_zzekd, zzedk com_google_android_gms_internal_zzedk, zzeix com_google_android_gms_internal_zzeix, zzeit com_google_android_gms_internal_zzeit) {
        zzekd zzcaf = !this.zznbe.zza(new zzekc(com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzekd)) ? zzeju.zzcaf() : com_google_android_gms_internal_zzekd;
        if (com_google_android_gms_internal_zzejw.zzbsv().zzm(com_google_android_gms_internal_zzejg).equals(zzcaf)) {
            return com_google_android_gms_internal_zzejw;
        }
        if (com_google_android_gms_internal_zzejw.zzbsv().getChildCount() < this.limit) {
            return this.zznbe.zzbzh().zza(com_google_android_gms_internal_zzejw, com_google_android_gms_internal_zzejg, zzcaf, com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzeix, com_google_android_gms_internal_zzeit);
        }
        zzekc com_google_android_gms_internal_zzekc = new zzekc(com_google_android_gms_internal_zzejg, zzcaf);
        zzekc zzcaj = this.zznbf ? com_google_android_gms_internal_zzejw.zzcaj() : com_google_android_gms_internal_zzejw.zzcak();
        boolean zza = this.zznbe.zza(com_google_android_gms_internal_zzekc);
        if (com_google_android_gms_internal_zzejw.zzbsv().zzk(com_google_android_gms_internal_zzejg)) {
            zzekd zzm = com_google_android_gms_internal_zzejw.zzbsv().zzm(com_google_android_gms_internal_zzejg);
            zzekc zza2 = com_google_android_gms_internal_zzeix.zza(this.zznaa, zzcaj, this.zznbf);
            while (zza2 != null && (zza2.zzcao().equals(com_google_android_gms_internal_zzejg) || com_google_android_gms_internal_zzejw.zzbsv().zzk(zza2.zzcao()))) {
                zza2 = com_google_android_gms_internal_zzeix.zza(this.zznaa, zza2, this.zznbf);
            }
            Object obj = (!zza || zzcaf.isEmpty() || (zza2 == null ? 1 : this.zznaa.zza(zza2, com_google_android_gms_internal_zzekc, this.zznbf)) < 0) ? null : 1;
            if (obj != null) {
                if (com_google_android_gms_internal_zzeit != null) {
                    com_google_android_gms_internal_zzeit.zza(zzehz.zza(com_google_android_gms_internal_zzejg, zzcaf, zzm));
                }
                return com_google_android_gms_internal_zzejw.zzg(com_google_android_gms_internal_zzejg, zzcaf);
            }
            if (com_google_android_gms_internal_zzeit != null) {
                com_google_android_gms_internal_zzeit.zza(zzehz.zzd(com_google_android_gms_internal_zzejg, zzm));
            }
            com_google_android_gms_internal_zzejw = com_google_android_gms_internal_zzejw.zzg(com_google_android_gms_internal_zzejg, zzeju.zzcaf());
            obj = (zza2 == null || !this.zznbe.zza(zza2)) ? null : 1;
            if (obj == null) {
                return com_google_android_gms_internal_zzejw;
            }
            if (com_google_android_gms_internal_zzeit != null) {
                com_google_android_gms_internal_zzeit.zza(zzehz.zzc(zza2.zzcao(), zza2.zzbsv()));
            }
            return com_google_android_gms_internal_zzejw.zzg(zza2.zzcao(), zza2.zzbsv());
        } else if (zzcaf.isEmpty() || !zza || this.zznaa.zza(zzcaj, com_google_android_gms_internal_zzekc, this.zznbf) < 0) {
            return com_google_android_gms_internal_zzejw;
        } else {
            if (com_google_android_gms_internal_zzeit != null) {
                com_google_android_gms_internal_zzeit.zza(zzehz.zzd(zzcaj.zzcao(), zzcaj.zzbsv()));
                com_google_android_gms_internal_zzeit.zza(zzehz.zzc(com_google_android_gms_internal_zzejg, zzcaf));
            }
            return com_google_android_gms_internal_zzejw.zzg(com_google_android_gms_internal_zzejg, zzcaf).zzg(zzcaj.zzcao(), zzeju.zzcaf());
        }
    }

    public final zzejw zza(zzejw com_google_android_gms_internal_zzejw, zzejw com_google_android_gms_internal_zzejw2, zzeit com_google_android_gms_internal_zzeit) {
        zzejw zza;
        if (com_google_android_gms_internal_zzejw2.zzbsv().zzbzu() || com_google_android_gms_internal_zzejw2.zzbsv().isEmpty()) {
            zza = zzejw.zza(zzeju.zzcaf(), this.zznaa);
        } else {
            Object zzbzj;
            Iterator it;
            int i;
            zzejw zzk = com_google_android_gms_internal_zzejw2.zzk(zzeju.zzcaf());
            if (this.zznbf) {
                Iterator zzbti = com_google_android_gms_internal_zzejw2.zzbti();
                Object zzbzk = this.zznbe.zzbzk();
                zzbzj = this.zznbe.zzbzj();
                it = zzbti;
                i = -1;
            } else {
                Iterator it2 = com_google_android_gms_internal_zzejw2.iterator();
                zzekc zzbzj2 = this.zznbe.zzbzj();
                zzekc zzbzk2 = this.zznbe.zzbzk();
                zzekc com_google_android_gms_internal_zzekc = zzbzj2;
                i = 1;
                it = it2;
            }
            int i2 = 0;
            zza = zzk;
            Object obj = null;
            while (it.hasNext()) {
                zzekc com_google_android_gms_internal_zzekc2 = (zzekc) it.next();
                if (obj == null && this.zznaa.compare(r5, com_google_android_gms_internal_zzekc2) * i <= 0) {
                    obj = 1;
                }
                Object obj2 = (obj == null || i2 >= this.limit || this.zznaa.compare(com_google_android_gms_internal_zzekc2, zzbzj) * i > 0) ? null : 1;
                if (obj2 != null) {
                    i2++;
                } else {
                    zza = zza.zzg(com_google_android_gms_internal_zzekc2.zzcao(), zzeju.zzcaf());
                }
            }
        }
        return this.zznbe.zzbzh().zza(com_google_android_gms_internal_zzejw, zza, com_google_android_gms_internal_zzeit);
    }

    public final zzejw zza(zzejw com_google_android_gms_internal_zzejw, zzekd com_google_android_gms_internal_zzekd) {
        return com_google_android_gms_internal_zzejw;
    }

    public final zzejv zzbyr() {
        return this.zznaa;
    }

    public final zzeiw zzbzh() {
        return this.zznbe.zzbzh();
    }

    public final boolean zzbzi() {
        return true;
    }
}
