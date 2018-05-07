package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzefh {
    private final zzejc zzmlr;
    private final zzegy zzmvn;
    private zzehm<zzefg> zzmvo = zzehm.zzbxw();
    private final zzegg zzmvp = new zzegg();
    private final Map<zzega, zzeik> zzmvq = new HashMap();
    private final Map<zzeik, zzega> zzmvr = new HashMap();
    private final Set<zzeik> zzmvs = new HashSet();
    private final zzefz zzmvt;
    private long zzmvu = 1;

    public zzefh(zzedc com_google_android_gms_internal_zzedc, zzegy com_google_android_gms_internal_zzegy, zzefz com_google_android_gms_internal_zzefz) {
        this.zzmvt = com_google_android_gms_internal_zzefz;
        this.zzmvn = com_google_android_gms_internal_zzegy;
        this.zzmlr = com_google_android_gms_internal_zzedc.zzpv("SyncTree");
    }

    private final List<zzeib> zza(zzego com_google_android_gms_internal_zzego) {
        return zza(com_google_android_gms_internal_zzego, this.zzmvo, null, this.zzmvp.zzt(zzedk.zzbwe()));
    }

    private final List<zzeib> zza(zzego com_google_android_gms_internal_zzego, zzehm<zzefg> com_google_android_gms_internal_zzehm_com_google_android_gms_internal_zzefg, zzekd com_google_android_gms_internal_zzekd, zzegj com_google_android_gms_internal_zzegj) {
        if (com_google_android_gms_internal_zzego.zzbsy().isEmpty()) {
            return zzb(com_google_android_gms_internal_zzego, com_google_android_gms_internal_zzehm_com_google_android_gms_internal_zzefg, com_google_android_gms_internal_zzekd, com_google_android_gms_internal_zzegj);
        }
        zzefg com_google_android_gms_internal_zzefg = (zzefg) com_google_android_gms_internal_zzehm_com_google_android_gms_internal_zzefg.getValue();
        if (com_google_android_gms_internal_zzekd == null && com_google_android_gms_internal_zzefg != null) {
            com_google_android_gms_internal_zzekd = com_google_android_gms_internal_zzefg.zzr(zzedk.zzbwe());
        }
        List<zzeib> arrayList = new ArrayList();
        zzejg zzbwh = com_google_android_gms_internal_zzego.zzbsy().zzbwh();
        zzego zzc = com_google_android_gms_internal_zzego.zzc(zzbwh);
        zzehm com_google_android_gms_internal_zzehm = (zzehm) com_google_android_gms_internal_zzehm_com_google_android_gms_internal_zzefg.zzbxx().get(zzbwh);
        if (!(com_google_android_gms_internal_zzehm == null || zzc == null)) {
            arrayList.addAll(zza(zzc, com_google_android_gms_internal_zzehm, com_google_android_gms_internal_zzekd != null ? com_google_android_gms_internal_zzekd.zzm(zzbwh) : null, com_google_android_gms_internal_zzegj.zzb(zzbwh)));
        }
        if (com_google_android_gms_internal_zzefg != null) {
            arrayList.addAll(com_google_android_gms_internal_zzefg.zza(com_google_android_gms_internal_zzego, com_google_android_gms_internal_zzegj, com_google_android_gms_internal_zzekd));
        }
        return arrayList;
    }

    private final List<zzeil> zza(zzehm<zzefg> com_google_android_gms_internal_zzehm_com_google_android_gms_internal_zzefg) {
        List arrayList = new ArrayList();
        zza((zzehm) com_google_android_gms_internal_zzehm_com_google_android_gms_internal_zzefg, arrayList);
        return arrayList;
    }

    private final List<? extends zzeib> zza(zzeik com_google_android_gms_internal_zzeik, zzego com_google_android_gms_internal_zzego) {
        zzedk zzbsy = com_google_android_gms_internal_zzeik.zzbsy();
        return ((zzefg) this.zzmvo.zzaj(zzbsy)).zza(com_google_android_gms_internal_zzego, this.zzmvp.zzt(zzbsy), null);
    }

    private final void zza(zzehm<zzefg> com_google_android_gms_internal_zzehm_com_google_android_gms_internal_zzefg, List<zzeil> list) {
        zzefg com_google_android_gms_internal_zzefg = (zzefg) com_google_android_gms_internal_zzehm_com_google_android_gms_internal_zzefg.getValue();
        if (com_google_android_gms_internal_zzefg == null || !com_google_android_gms_internal_zzefg.zzbwt()) {
            if (com_google_android_gms_internal_zzefg != null) {
                list.addAll(com_google_android_gms_internal_zzefg.zzbws());
            }
            Iterator it = com_google_android_gms_internal_zzehm_com_google_android_gms_internal_zzefg.zzbxx().iterator();
            while (it.hasNext()) {
                zza((zzehm) ((Entry) it.next()).getValue(), (List) list);
            }
            return;
        }
        list.add(com_google_android_gms_internal_zzefg.zzbwu());
    }

    private final void zza(zzeik com_google_android_gms_internal_zzeik, zzeil com_google_android_gms_internal_zzeil) {
        zzedk zzbsy = com_google_android_gms_internal_zzeik.zzbsy();
        zzega zze = zze(com_google_android_gms_internal_zzeik);
        Object com_google_android_gms_internal_zzefy = new zzefy(this, com_google_android_gms_internal_zzeil);
        this.zzmvt.zza(zzd(com_google_android_gms_internal_zzeik), zze, com_google_android_gms_internal_zzefy, com_google_android_gms_internal_zzefy);
        zzehm zzah = this.zzmvo.zzah(zzbsy);
        if (zze == null) {
            zzah.zza(new zzefm(this));
        }
    }

    private final void zzav(List<zzeik> list) {
        for (zzeik com_google_android_gms_internal_zzeik : list) {
            if (!com_google_android_gms_internal_zzeik.zzbyv()) {
                zzega zze = zze(com_google_android_gms_internal_zzeik);
                this.zzmvr.remove(com_google_android_gms_internal_zzeik);
                this.zzmvq.remove(zze);
            }
        }
    }

    private final zzeik zzb(zzega com_google_android_gms_internal_zzega) {
        return (zzeik) this.zzmvq.get(com_google_android_gms_internal_zzega);
    }

    private final List<zzeib> zzb(zzego com_google_android_gms_internal_zzego, zzehm<zzefg> com_google_android_gms_internal_zzehm_com_google_android_gms_internal_zzefg, zzekd com_google_android_gms_internal_zzekd, zzegj com_google_android_gms_internal_zzegj) {
        zzefg com_google_android_gms_internal_zzefg = (zzefg) com_google_android_gms_internal_zzehm_com_google_android_gms_internal_zzefg.getValue();
        zzekd zzr = (com_google_android_gms_internal_zzekd != null || com_google_android_gms_internal_zzefg == null) ? com_google_android_gms_internal_zzekd : com_google_android_gms_internal_zzefg.zzr(zzedk.zzbwe());
        List<zzeib> arrayList = new ArrayList();
        com_google_android_gms_internal_zzehm_com_google_android_gms_internal_zzefg.zzbxx().zza(new zzefn(this, zzr, com_google_android_gms_internal_zzegj, com_google_android_gms_internal_zzego, arrayList));
        if (com_google_android_gms_internal_zzefg != null) {
            arrayList.addAll(com_google_android_gms_internal_zzefg.zza(com_google_android_gms_internal_zzego, com_google_android_gms_internal_zzegj, zzr));
        }
        return arrayList;
    }

    private final List<zzeib> zzb(zzeik com_google_android_gms_internal_zzeik, zzedh com_google_android_gms_internal_zzedh, DatabaseError databaseError) {
        return (List) this.zzmvn.zze(new zzefl(this, com_google_android_gms_internal_zzeik, com_google_android_gms_internal_zzedh, databaseError));
    }

    private final zzega zzbww() {
        long j = this.zzmvu;
        this.zzmvu = 1 + j;
        return new zzega(j);
    }

    private static zzeik zzd(zzeik com_google_android_gms_internal_zzeik) {
        return (!com_google_android_gms_internal_zzeik.zzbyv() || com_google_android_gms_internal_zzeik.isDefault()) ? com_google_android_gms_internal_zzeik : zzeik.zzam(com_google_android_gms_internal_zzeik.zzbsy());
    }

    private final zzega zze(zzeik com_google_android_gms_internal_zzeik) {
        return (zzega) this.zzmvr.get(com_google_android_gms_internal_zzeik);
    }

    public final boolean isEmpty() {
        return this.zzmvo.isEmpty();
    }

    public final List<? extends zzeib> zza(long j, boolean z, boolean z2, zzeli com_google_android_gms_internal_zzeli) {
        return (List) this.zzmvn.zze(new zzefp(this, z2, j, z, com_google_android_gms_internal_zzeli));
    }

    public final List<? extends zzeib> zza(zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy, zzecy com_google_android_gms_internal_zzecy2, long j, boolean z) {
        return (List) this.zzmvn.zze(new zzefo(this, z, com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzecy, j, com_google_android_gms_internal_zzecy2));
    }

    public final List<? extends zzeib> zza(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, zzega com_google_android_gms_internal_zzega) {
        return (List) this.zzmvn.zze(new zzefv(this, com_google_android_gms_internal_zzega, com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd));
    }

    public final List<? extends zzeib> zza(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, zzekd com_google_android_gms_internal_zzekd2, long j, boolean z, boolean z2) {
        boolean z3 = z || !z2;
        zzelt.zzb(z3, "We shouldn't be persisting non-visible writes.");
        return (List) this.zzmvn.zze(new zzefi(this, z2, com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd, j, com_google_android_gms_internal_zzekd2, z));
    }

    public final List<? extends zzeib> zza(zzedk com_google_android_gms_internal_zzedk, List<zzekk> list, zzega com_google_android_gms_internal_zzega) {
        zzeik zzb = zzb(com_google_android_gms_internal_zzega);
        if (zzb == null) {
            return Collections.emptyList();
        }
        zzekd zzbza = ((zzefg) this.zzmvo.zzaj(zzb.zzbsy())).zzb(zzb).zzbza();
        zzekd com_google_android_gms_internal_zzekd = zzbza;
        for (zzekk zzm : list) {
            com_google_android_gms_internal_zzekd = zzm.zzm(com_google_android_gms_internal_zzekd);
        }
        return zza(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd, com_google_android_gms_internal_zzega);
    }

    public final List<? extends zzeib> zza(zzedk com_google_android_gms_internal_zzedk, Map<zzedk, zzekd> map) {
        return (List) this.zzmvn.zze(new zzefs(this, map, com_google_android_gms_internal_zzedk));
    }

    public final List<? extends zzeib> zza(zzedk com_google_android_gms_internal_zzedk, Map<zzedk, zzekd> map, zzega com_google_android_gms_internal_zzega) {
        return (List) this.zzmvn.zze(new zzefj(this, com_google_android_gms_internal_zzega, com_google_android_gms_internal_zzedk, map));
    }

    public final List<? extends zzeib> zza(zzega com_google_android_gms_internal_zzega) {
        return (List) this.zzmvn.zze(new zzefu(this, com_google_android_gms_internal_zzega));
    }

    public final List<zzeib> zza(zzeik com_google_android_gms_internal_zzeik, DatabaseError databaseError) {
        return zzb(com_google_android_gms_internal_zzeik, null, databaseError);
    }

    public final void zza(zzeik com_google_android_gms_internal_zzeik, boolean z) {
        if (z && !this.zzmvs.contains(com_google_android_gms_internal_zzeik)) {
            zzg(new zzefx(com_google_android_gms_internal_zzeik));
            this.zzmvs.add(com_google_android_gms_internal_zzeik);
        } else if (!z && this.zzmvs.contains(com_google_android_gms_internal_zzeik)) {
            zzh(new zzefx(com_google_android_gms_internal_zzeik));
            this.zzmvs.remove(com_google_android_gms_internal_zzeik);
        }
    }

    public final List<? extends zzeib> zzb(zzedk com_google_android_gms_internal_zzedk, List<zzekk> list) {
        zzefg com_google_android_gms_internal_zzefg = (zzefg) this.zzmvo.zzaj(com_google_android_gms_internal_zzedk);
        if (com_google_android_gms_internal_zzefg == null) {
            return Collections.emptyList();
        }
        zzeil zzbwu = com_google_android_gms_internal_zzefg.zzbwu();
        if (zzbwu == null) {
            return Collections.emptyList();
        }
        zzekd zzbza = zzbwu.zzbza();
        zzekd com_google_android_gms_internal_zzekd = zzbza;
        for (zzekk zzm : list) {
            com_google_android_gms_internal_zzekd = zzm.zzm(com_google_android_gms_internal_zzekd);
        }
        return zzi(com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd);
    }

    public final List<? extends zzeib> zzbwv() {
        return (List) this.zzmvn.zze(new zzefq(this));
    }

    public final zzekd zzc(zzedk com_google_android_gms_internal_zzedk, List<Long> list) {
        zzekd zzr;
        zzehm com_google_android_gms_internal_zzehm = this.zzmvo;
        com_google_android_gms_internal_zzehm.getValue();
        zzekd com_google_android_gms_internal_zzekd = null;
        zzedk zzbwe = zzedk.zzbwe();
        zzehm com_google_android_gms_internal_zzehm2 = com_google_android_gms_internal_zzehm;
        zzedk com_google_android_gms_internal_zzedk2 = com_google_android_gms_internal_zzedk;
        while (true) {
            zzejg zzbwh = com_google_android_gms_internal_zzedk2.zzbwh();
            zzedk zzbwi = com_google_android_gms_internal_zzedk2.zzbwi();
            com_google_android_gms_internal_zzedk2 = zzbwe.zza(zzbwh);
            zzedk zza = zzedk.zza(com_google_android_gms_internal_zzedk2, com_google_android_gms_internal_zzedk);
            com_google_android_gms_internal_zzehm2 = zzbwh != null ? com_google_android_gms_internal_zzehm2.zze(zzbwh) : zzehm.zzbxw();
            zzefg com_google_android_gms_internal_zzefg = (zzefg) com_google_android_gms_internal_zzehm2.getValue();
            zzr = com_google_android_gms_internal_zzefg != null ? com_google_android_gms_internal_zzefg.zzr(zza) : com_google_android_gms_internal_zzekd;
            if (!zzbwi.isEmpty() && zzr == null) {
                com_google_android_gms_internal_zzekd = zzr;
                zzbwe = com_google_android_gms_internal_zzedk2;
                com_google_android_gms_internal_zzedk2 = zzbwi;
            }
        }
        return this.zzmvp.zza(com_google_android_gms_internal_zzedk, zzr, (List) list, true);
    }

    public final List<? extends zzeib> zzg(zzedh com_google_android_gms_internal_zzedh) {
        return (List) this.zzmvn.zze(new zzefk(this, com_google_android_gms_internal_zzedh));
    }

    public final List<zzeib> zzh(zzedh com_google_android_gms_internal_zzedh) {
        return zzb(com_google_android_gms_internal_zzedh.zzbvp(), com_google_android_gms_internal_zzedh, null);
    }

    public final List<? extends zzeib> zzi(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        return (List) this.zzmvn.zze(new zzefr(this, com_google_android_gms_internal_zzedk, com_google_android_gms_internal_zzekd));
    }

    public final List<? extends zzeib> zzs(zzedk com_google_android_gms_internal_zzedk) {
        return (List) this.zzmvn.zze(new zzeft(this, com_google_android_gms_internal_zzedk));
    }
}
