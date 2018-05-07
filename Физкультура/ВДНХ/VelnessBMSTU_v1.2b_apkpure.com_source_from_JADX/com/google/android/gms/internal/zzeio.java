package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zzeio {
    private static zzeix zznaz = new zzeip();
    private final zzeiw zznay;

    public zzeio(zzeiw com_google_android_gms_internal_zzeiw) {
        this.zznay = com_google_android_gms_internal_zzeiw;
    }

    private final zzein zza(zzein com_google_android_gms_internal_zzein, zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy, zzegj com_google_android_gms_internal_zzegj, zzekd com_google_android_gms_internal_zzekd, boolean z, zzeit com_google_android_gms_internal_zzeit) {
        if (com_google_android_gms_internal_zzein.zzbze().zzbsv().isEmpty() && !com_google_android_gms_internal_zzein.zzbze().zzbxz()) {
            return com_google_android_gms_internal_zzein;
        }
        if (!com_google_android_gms_internal_zzedk.isEmpty()) {
            com_google_android_gms_internal_zzecy = zzecy.zzbvq().zzb(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzecy);
        }
        zzekd zzbsv = com_google_android_gms_internal_zzein.zzbze().zzbsv();
        Map zzbvt = com_google_android_gms_internal_zzecy.zzbvt();
        zzein com_google_android_gms_internal_zzein2 = com_google_android_gms_internal_zzein;
        for (Entry entry : zzbvt.entrySet()) {
            zzejg com_google_android_gms_internal_zzejg = (zzejg) entry.getKey();
            if (zzbsv.zzk(com_google_android_gms_internal_zzejg)) {
                com_google_android_gms_internal_zzein2 = zza(com_google_android_gms_internal_zzein2, new zzedk(com_google_android_gms_internal_zzejg), ((zzecy) entry.getValue()).zzb(zzbsv.zzm(com_google_android_gms_internal_zzejg)), com_google_android_gms_internal_zzegj, com_google_android_gms_internal_zzekd, z, com_google_android_gms_internal_zzeit);
            }
        }
        for (Entry entry2 : zzbvt.entrySet()) {
            com_google_android_gms_internal_zzejg = (zzejg) entry2.getKey();
            Object obj = (com_google_android_gms_internal_zzein.zzbze().zzf(com_google_android_gms_internal_zzejg) || ((zzecy) entry2.getValue()).zzbvr() != null) ? null : 1;
            if (!zzbsv.zzk(com_google_android_gms_internal_zzejg) && obj == null) {
                com_google_android_gms_internal_zzein2 = zza(com_google_android_gms_internal_zzein2, new zzedk(com_google_android_gms_internal_zzejg), ((zzecy) entry2.getValue()).zzb(zzbsv.zzm(com_google_android_gms_internal_zzejg)), com_google_android_gms_internal_zzegj, com_google_android_gms_internal_zzekd, z, com_google_android_gms_internal_zzeit);
            }
        }
        return com_google_android_gms_internal_zzein2;
    }

    private final zzein zza(zzein com_google_android_gms_internal_zzein, zzedk com_google_android_gms_internal_zzedk, zzegj com_google_android_gms_internal_zzegj, zzeix com_google_android_gms_internal_zzeix, zzeit com_google_android_gms_internal_zzeit) {
        zzehx zzbzc = com_google_android_gms_internal_zzein.zzbzc();
        if (com_google_android_gms_internal_zzegj.zzu(com_google_android_gms_internal_zzedk) != null) {
            return com_google_android_gms_internal_zzein;
        }
        zzejw zza;
        zzekd zzbzf;
        if (com_google_android_gms_internal_zzedk.isEmpty()) {
            if (com_google_android_gms_internal_zzein.zzbze().zzbya()) {
                zzbzf = com_google_android_gms_internal_zzein.zzbzf();
                if (!(zzbzf instanceof zzeji)) {
                    zzbzf = zzeju.zzcaf();
                }
                zzbzf = com_google_android_gms_internal_zzegj.zzd(zzbzf);
            } else {
                zzbzf = com_google_android_gms_internal_zzegj.zzc(com_google_android_gms_internal_zzein.zzbzf());
            }
            zza = this.zznay.zza(com_google_android_gms_internal_zzein.zzbzc().zzbyb(), zzejw.zza(zzbzf, this.zznay.zzbyr()), com_google_android_gms_internal_zzeit);
        } else {
            zzejg zzbwh = com_google_android_gms_internal_zzedk.zzbwh();
            if (zzbwh.zzbzr()) {
                zzbzf = com_google_android_gms_internal_zzegj.zza(com_google_android_gms_internal_zzedk, zzbzc.zzbsv(), com_google_android_gms_internal_zzein.zzbze().zzbsv());
                zza = zzbzf != null ? this.zznay.zza(zzbzc.zzbyb(), zzbzf) : zzbzc.zzbyb();
            } else {
                zzekd zzl;
                zzedk zzbwi = com_google_android_gms_internal_zzedk.zzbwi();
                if (zzbzc.zzf(zzbwh)) {
                    zzbzf = com_google_android_gms_internal_zzegj.zza(com_google_android_gms_internal_zzedk, zzbzc.zzbsv(), com_google_android_gms_internal_zzein.zzbze().zzbsv());
                    zzl = zzbzf != null ? zzbzc.zzbsv().zzm(zzbwh).zzl(zzbwi, zzbzf) : zzbzc.zzbsv().zzm(zzbwh);
                } else {
                    zzl = com_google_android_gms_internal_zzegj.zza(zzbwh, com_google_android_gms_internal_zzein.zzbze());
                }
                zza = zzl != null ? this.zznay.zza(zzbzc.zzbyb(), zzbwh, zzl, zzbwi, com_google_android_gms_internal_zzeix, com_google_android_gms_internal_zzeit) : zzbzc.zzbyb();
            }
        }
        boolean z = zzbzc.zzbxz() || com_google_android_gms_internal_zzedk.isEmpty();
        return com_google_android_gms_internal_zzein.zza(zza, z, this.zznay.zzbzi());
    }

    private final zzein zza(zzein com_google_android_gms_internal_zzein, zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, zzegj com_google_android_gms_internal_zzegj, zzekd com_google_android_gms_internal_zzekd2, zzeit com_google_android_gms_internal_zzeit) {
        zzehx zzbzc = com_google_android_gms_internal_zzein.zzbzc();
        zzeix com_google_android_gms_internal_zzeis = new zzeis(com_google_android_gms_internal_zzegj, com_google_android_gms_internal_zzein, com_google_android_gms_internal_zzekd2);
        if (com_google_android_gms_internal_zzedk.isEmpty()) {
            return com_google_android_gms_internal_zzein.zza(this.zznay.zza(com_google_android_gms_internal_zzein.zzbzc().zzbyb(), zzejw.zza(com_google_android_gms_internal_zzekd, this.zznay.zzbyr()), com_google_android_gms_internal_zzeit), true, this.zznay.zzbzi());
        }
        zzejg zzbwh = com_google_android_gms_internal_zzedk.zzbwh();
        if (zzbwh.zzbzr()) {
            return com_google_android_gms_internal_zzein.zza(this.zznay.zza(com_google_android_gms_internal_zzein.zzbzc().zzbyb(), com_google_android_gms_internal_zzekd), zzbzc.zzbxz(), zzbzc.zzbya());
        }
        zzekd com_google_android_gms_internal_zzekd3;
        zzedk zzbwi = com_google_android_gms_internal_zzedk.zzbwi();
        zzekd zzm = zzbzc.zzbsv().zzm(zzbwh);
        if (zzbwi.isEmpty()) {
            com_google_android_gms_internal_zzekd3 = com_google_android_gms_internal_zzekd;
        } else {
            com_google_android_gms_internal_zzekd3 = com_google_android_gms_internal_zzeis.zzh(zzbwh);
            if (com_google_android_gms_internal_zzekd3 == null) {
                com_google_android_gms_internal_zzekd3 = zzeju.zzcaf();
            } else if (!(zzbwi.zzbwk().zzbzr() && com_google_android_gms_internal_zzekd3.zzan(zzbwi.zzbwj()).isEmpty())) {
                com_google_android_gms_internal_zzekd3 = com_google_android_gms_internal_zzekd3.zzl(zzbwi, com_google_android_gms_internal_zzekd);
            }
        }
        return !zzm.equals(com_google_android_gms_internal_zzekd3) ? com_google_android_gms_internal_zzein.zza(this.zznay.zza(zzbzc.zzbyb(), zzbwh, com_google_android_gms_internal_zzekd3, zzbwi, com_google_android_gms_internal_zzeis, com_google_android_gms_internal_zzeit), zzbzc.zzbxz(), this.zznay.zzbzi()) : com_google_android_gms_internal_zzein;
    }

    private final zzein zza(zzein com_google_android_gms_internal_zzein, zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, zzegj com_google_android_gms_internal_zzegj, zzekd com_google_android_gms_internal_zzekd2, boolean z, zzeit com_google_android_gms_internal_zzeit) {
        zzejw zza;
        zzehx zzbze = com_google_android_gms_internal_zzein.zzbze();
        zzeiw zzbzh = z ? this.zznay : this.zznay.zzbzh();
        if (com_google_android_gms_internal_zzedk.isEmpty()) {
            zza = zzbzh.zza(zzbze.zzbyb(), zzejw.zza(com_google_android_gms_internal_zzekd, zzbzh.zzbyr()), null);
        } else if (!zzbzh.zzbzi() || zzbze.zzbya()) {
            zzejg zzbwh = com_google_android_gms_internal_zzedk.zzbwh();
            if (!zzbze.zzal(com_google_android_gms_internal_zzedk) && com_google_android_gms_internal_zzedk.size() > 1) {
                return com_google_android_gms_internal_zzein;
            }
            zzedk zzbwi = com_google_android_gms_internal_zzedk.zzbwi();
            zzekd zzl = zzbze.zzbsv().zzm(zzbwh).zzl(zzbwi, com_google_android_gms_internal_zzekd);
            zza = zzbwh.zzbzr() ? zzbzh.zza(zzbze.zzbyb(), zzl) : zzbzh.zza(zzbze.zzbyb(), zzbwh, zzl, zzbwi, zznaz, null);
        } else {
            zzejg zzbwh2 = com_google_android_gms_internal_zzedk.zzbwh();
            zza = zzbzh.zza(zzbze.zzbyb(), zzbze.zzbyb().zzg(zzbwh2, zzbze.zzbsv().zzm(zzbwh2).zzl(com_google_android_gms_internal_zzedk.zzbwi(), com_google_android_gms_internal_zzekd)), null);
        }
        boolean z2 = zzbze.zzbxz() || com_google_android_gms_internal_zzedk.isEmpty();
        zzein zzb = com_google_android_gms_internal_zzein.zzb(zza, z2, zzbzh.zzbzi());
        return zza(zzb, com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzegj, new zzeis(com_google_android_gms_internal_zzegj, zzb, com_google_android_gms_internal_zzekd2), com_google_android_gms_internal_zzeit);
    }

    private static boolean zza(zzein com_google_android_gms_internal_zzein, zzejg com_google_android_gms_internal_zzejg) {
        return com_google_android_gms_internal_zzein.zzbzc().zzf(com_google_android_gms_internal_zzejg);
    }

    public final zzeir zza(zzein com_google_android_gms_internal_zzein, zzego com_google_android_gms_internal_zzego, zzegj com_google_android_gms_internal_zzegj, zzekd com_google_android_gms_internal_zzekd) {
        zzein zza;
        zzeit com_google_android_gms_internal_zzeit = new zzeit();
        boolean z;
        zzehx zzbze;
        zzedk zzh;
        boolean z2;
        switch (zzeiq.zznba[com_google_android_gms_internal_zzego.zzbxk().ordinal()]) {
            case 1:
                zzegs com_google_android_gms_internal_zzegs = (zzegs) com_google_android_gms_internal_zzego;
                if (!com_google_android_gms_internal_zzegs.zzbxj().zzbxl()) {
                    z = com_google_android_gms_internal_zzegs.zzbxj().zzbxm() || (com_google_android_gms_internal_zzein.zzbze().zzbya() && !com_google_android_gms_internal_zzegs.zzbsy().isEmpty());
                    zza = zza(com_google_android_gms_internal_zzein, com_google_android_gms_internal_zzegs.zzbsy(), com_google_android_gms_internal_zzegs.zzbxo(), com_google_android_gms_internal_zzegj, com_google_android_gms_internal_zzekd, z, com_google_android_gms_internal_zzeit);
                    break;
                }
                zza = zza(com_google_android_gms_internal_zzein, com_google_android_gms_internal_zzegs.zzbsy(), com_google_android_gms_internal_zzegs.zzbxo(), com_google_android_gms_internal_zzegj, com_google_android_gms_internal_zzekd, com_google_android_gms_internal_zzeit);
                break;
                break;
            case 2:
                zzegn com_google_android_gms_internal_zzegn = (zzegn) com_google_android_gms_internal_zzego;
                if (!com_google_android_gms_internal_zzegn.zzbxj().zzbxl()) {
                    z = com_google_android_gms_internal_zzegn.zzbxj().zzbxm() || com_google_android_gms_internal_zzein.zzbze().zzbya();
                    zza = zza(com_google_android_gms_internal_zzein, com_google_android_gms_internal_zzegn.zzbsy(), com_google_android_gms_internal_zzegn.zzbxi(), com_google_android_gms_internal_zzegj, com_google_android_gms_internal_zzekd, z, com_google_android_gms_internal_zzeit);
                    break;
                }
                Entry entry;
                zzedk zzh2;
                zzedk zzbsy = com_google_android_gms_internal_zzegn.zzbsy();
                zzecy zzbxi = com_google_android_gms_internal_zzegn.zzbxi();
                Iterator it = zzbxi.iterator();
                zzein com_google_android_gms_internal_zzein2 = com_google_android_gms_internal_zzein;
                while (it.hasNext()) {
                    entry = (Entry) it.next();
                    zzh2 = zzbsy.zzh((zzedk) entry.getKey());
                    if (zza(com_google_android_gms_internal_zzein, zzh2.zzbwh())) {
                        com_google_android_gms_internal_zzein2 = zza(com_google_android_gms_internal_zzein2, zzh2, (zzekd) entry.getValue(), com_google_android_gms_internal_zzegj, com_google_android_gms_internal_zzekd, com_google_android_gms_internal_zzeit);
                    }
                }
                Iterator it2 = zzbxi.iterator();
                while (it2.hasNext()) {
                    entry = (Entry) it2.next();
                    zzh2 = zzbsy.zzh((zzedk) entry.getKey());
                    if (!zza(com_google_android_gms_internal_zzein, zzh2.zzbwh())) {
                        com_google_android_gms_internal_zzein2 = zza(com_google_android_gms_internal_zzein2, zzh2, (zzekd) entry.getValue(), com_google_android_gms_internal_zzegj, com_google_android_gms_internal_zzekd, com_google_android_gms_internal_zzeit);
                    }
                }
                zza = com_google_android_gms_internal_zzein2;
                break;
                break;
            case 3:
                zzegl com_google_android_gms_internal_zzegl = (zzegl) com_google_android_gms_internal_zzego;
                if (!com_google_android_gms_internal_zzegl.zzbxh()) {
                    zzedk zzbsy2 = com_google_android_gms_internal_zzegl.zzbsy();
                    zzehm zzbxg = com_google_android_gms_internal_zzegl.zzbxg();
                    if (com_google_android_gms_internal_zzegj.zzu(zzbsy2) == null) {
                        z = com_google_android_gms_internal_zzein.zzbze().zzbya();
                        zzbze = com_google_android_gms_internal_zzein.zzbze();
                        zzecy zzbvq;
                        if (zzbxg.getValue() != null) {
                            if ((!zzbsy2.isEmpty() || !zzbze.zzbxz()) && !zzbze.zzal(zzbsy2)) {
                                if (!zzbsy2.isEmpty()) {
                                    zza = com_google_android_gms_internal_zzein;
                                    break;
                                }
                                zzbvq = zzecy.zzbvq();
                                for (zzekc com_google_android_gms_internal_zzekc : zzbze.zzbsv()) {
                                    zzbvq = zzbvq.zza(com_google_android_gms_internal_zzekc.zzcao(), com_google_android_gms_internal_zzekc.zzbsv());
                                }
                                zza = zza(com_google_android_gms_internal_zzein, zzbsy2, zzbvq, com_google_android_gms_internal_zzegj, com_google_android_gms_internal_zzekd, z, com_google_android_gms_internal_zzeit);
                                break;
                            }
                            zza = zza(com_google_android_gms_internal_zzein, zzbsy2, zzbze.zzbsv().zzan(zzbsy2), com_google_android_gms_internal_zzegj, com_google_android_gms_internal_zzekd, z, com_google_android_gms_internal_zzeit);
                            break;
                        }
                        zzbvq = zzecy.zzbvq();
                        Iterator it3 = zzbxg.iterator();
                        while (it3.hasNext()) {
                            zzedk com_google_android_gms_internal_zzedk = (zzedk) ((Entry) it3.next()).getKey();
                            zzh = zzbsy2.zzh(com_google_android_gms_internal_zzedk);
                            if (zzbze.zzal(zzh)) {
                                zzbvq = zzbvq.zze(com_google_android_gms_internal_zzedk, zzbze.zzbsv().zzan(zzh));
                            }
                        }
                        zza = zza(com_google_android_gms_internal_zzein, zzbsy2, zzbvq, com_google_android_gms_internal_zzegj, com_google_android_gms_internal_zzekd, z, com_google_android_gms_internal_zzeit);
                        break;
                    }
                    zza = com_google_android_gms_internal_zzein;
                    break;
                }
                zzedk zzbsy3 = com_google_android_gms_internal_zzegl.zzbsy();
                if (com_google_android_gms_internal_zzegj.zzu(zzbsy3) != null) {
                    zza = com_google_android_gms_internal_zzein;
                    break;
                }
                zzeix com_google_android_gms_internal_zzeis = new zzeis(com_google_android_gms_internal_zzegj, com_google_android_gms_internal_zzein, com_google_android_gms_internal_zzekd);
                zzejw zzbyb = com_google_android_gms_internal_zzein.zzbzc().zzbyb();
                if (zzbsy3.isEmpty() || zzbsy3.zzbwh().zzbzr()) {
                    zzbyb = this.zznay.zza(zzbyb, zzejw.zza(com_google_android_gms_internal_zzein.zzbze().zzbxz() ? com_google_android_gms_internal_zzegj.zzc(com_google_android_gms_internal_zzein.zzbzf()) : com_google_android_gms_internal_zzegj.zzd(com_google_android_gms_internal_zzein.zzbze().zzbsv()), this.zznay.zzbyr()), com_google_android_gms_internal_zzeit);
                } else {
                    zzejg zzbwh = zzbsy3.zzbwh();
                    zzekd zza2 = com_google_android_gms_internal_zzegj.zza(zzbwh, com_google_android_gms_internal_zzein.zzbze());
                    if (zza2 == null && com_google_android_gms_internal_zzein.zzbze().zzf(zzbwh)) {
                        zza2 = zzbyb.zzbsv().zzm(zzbwh);
                    }
                    if (zza2 != null) {
                        zzbyb = this.zznay.zza(zzbyb, zzbwh, zza2, zzbsy3.zzbwi(), com_google_android_gms_internal_zzeis, com_google_android_gms_internal_zzeit);
                    } else if (zza2 == null && com_google_android_gms_internal_zzein.zzbzc().zzbsv().zzk(zzbwh)) {
                        zzbyb = this.zznay.zza(zzbyb, zzbwh, zzeju.zzcaf(), zzbsy3.zzbwi(), com_google_android_gms_internal_zzeis, com_google_android_gms_internal_zzeit);
                    }
                    if (zzbyb.zzbsv().isEmpty() && com_google_android_gms_internal_zzein.zzbze().zzbxz()) {
                        zzekd zzc = com_google_android_gms_internal_zzegj.zzc(com_google_android_gms_internal_zzein.zzbzf());
                        if (zzc.zzbzu()) {
                            zzbyb = this.zznay.zza(zzbyb, zzejw.zza(zzc, this.zznay.zzbyr()), com_google_android_gms_internal_zzeit);
                        }
                    }
                }
                if (!com_google_android_gms_internal_zzein.zzbze().zzbxz()) {
                    if (com_google_android_gms_internal_zzegj.zzu(zzedk.zzbwe()) == null) {
                        z2 = false;
                        zza = com_google_android_gms_internal_zzein.zza(zzbyb, z2, this.zznay.zzbzi());
                        break;
                    }
                }
                z2 = true;
                zza = com_google_android_gms_internal_zzein.zza(zzbyb, z2, this.zznay.zzbzi());
                break;
            case 4:
                zzh = com_google_android_gms_internal_zzego.zzbsy();
                zzbze = com_google_android_gms_internal_zzein.zzbze();
                zzejw zzbyb2 = zzbze.zzbyb();
                z2 = zzbze.zzbxz() || zzh.isEmpty();
                zza = zza(com_google_android_gms_internal_zzein.zzb(zzbyb2, z2, zzbze.zzbya()), zzh, com_google_android_gms_internal_zzegj, zznaz, com_google_android_gms_internal_zzeit);
                break;
            default:
                String valueOf = String.valueOf(com_google_android_gms_internal_zzego.zzbxk());
                throw new AssertionError(new StringBuilder(String.valueOf(valueOf).length() + 19).append("Unknown operation: ").append(valueOf).toString());
        }
        List arrayList = new ArrayList(com_google_android_gms_internal_zzeit.zzbzg());
        zzehx zzbzc = zza.zzbzc();
        if (zzbzc.zzbxz()) {
            Object obj = (zzbzc.zzbsv().zzbzu() || zzbzc.zzbsv().isEmpty()) ? 1 : null;
            if (!(arrayList.isEmpty() && com_google_android_gms_internal_zzein.zzbzc().zzbxz() && ((obj == null || zzbzc.zzbsv().equals(com_google_android_gms_internal_zzein.zzbzd())) && zzbzc.zzbsv().zzbzv().equals(com_google_android_gms_internal_zzein.zzbzd().zzbzv())))) {
                arrayList.add(zzehz.zza(zzbzc.zzbyb()));
            }
        }
        return new zzeir(zza, arrayList);
    }
}
