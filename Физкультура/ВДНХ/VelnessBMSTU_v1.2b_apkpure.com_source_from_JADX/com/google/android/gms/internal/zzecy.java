package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zzecy implements Iterable<Entry<zzedk, zzekd>> {
    private static final zzecy zzmrt = new zzecy(new zzehm(null));
    private final zzehm<zzekd> zzmru;

    private zzecy(zzehm<zzekd> com_google_android_gms_internal_zzehm_com_google_android_gms_internal_zzekd) {
        this.zzmru = com_google_android_gms_internal_zzehm_com_google_android_gms_internal_zzekd;
    }

    private final zzekd zza(zzedk com_google_android_gms_internal_zzedk, zzehm<zzekd> com_google_android_gms_internal_zzehm_com_google_android_gms_internal_zzekd, zzekd com_google_android_gms_internal_zzekd) {
        if (com_google_android_gms_internal_zzehm_com_google_android_gms_internal_zzekd.getValue() != null) {
            return com_google_android_gms_internal_zzekd.zzl(com_google_android_gms_internal_zzedk, (zzekd) com_google_android_gms_internal_zzehm_com_google_android_gms_internal_zzekd.getValue());
        }
        Iterator it = com_google_android_gms_internal_zzehm_com_google_android_gms_internal_zzekd.zzbxx().iterator();
        zzekd com_google_android_gms_internal_zzekd2 = null;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzehm com_google_android_gms_internal_zzehm = (zzehm) entry.getValue();
            zzejg com_google_android_gms_internal_zzejg = (zzejg) entry.getKey();
            if (com_google_android_gms_internal_zzejg.zzbzr()) {
                com_google_android_gms_internal_zzekd2 = (zzekd) com_google_android_gms_internal_zzehm.getValue();
            } else {
                com_google_android_gms_internal_zzekd = zza(com_google_android_gms_internal_zzedk.zza(com_google_android_gms_internal_zzejg), com_google_android_gms_internal_zzehm, com_google_android_gms_internal_zzekd);
            }
        }
        return (com_google_android_gms_internal_zzekd.zzan(com_google_android_gms_internal_zzedk).isEmpty() || com_google_android_gms_internal_zzekd2 == null) ? com_google_android_gms_internal_zzekd : com_google_android_gms_internal_zzekd.zzl(com_google_android_gms_internal_zzedk.zza(zzejg.zzbzp()), com_google_android_gms_internal_zzekd2);
    }

    public static zzecy zzak(Map<String, Object> map) {
        zzehm zzbxw = zzehm.zzbxw();
        zzehm com_google_android_gms_internal_zzehm = zzbxw;
        for (Entry entry : map.entrySet()) {
            com_google_android_gms_internal_zzehm = com_google_android_gms_internal_zzehm.zza(new zzedk((String) entry.getKey()), new zzehm(zzekg.zza(entry.getValue(), zzeju.zzcaf())));
        }
        return new zzecy(com_google_android_gms_internal_zzehm);
    }

    public static zzecy zzal(Map<zzedk, zzekd> map) {
        zzehm zzbxw = zzehm.zzbxw();
        zzehm com_google_android_gms_internal_zzehm = zzbxw;
        for (Entry entry : map.entrySet()) {
            com_google_android_gms_internal_zzehm = com_google_android_gms_internal_zzehm.zza((zzedk) entry.getKey(), new zzehm((zzekd) entry.getValue()));
        }
        return new zzecy(com_google_android_gms_internal_zzehm);
    }

    public static zzecy zzbvq() {
        return zzmrt;
    }

    public final boolean equals(Object obj) {
        return obj == this ? true : (obj == null || obj.getClass() != getClass()) ? false : ((zzecy) obj).zzcn(true).equals(zzcn(true));
    }

    public final int hashCode() {
        return zzcn(true).hashCode();
    }

    public final boolean isEmpty() {
        return this.zzmru.isEmpty();
    }

    public final Iterator<Entry<zzedk, zzekd>> iterator() {
        return this.zzmru.iterator();
    }

    public final String toString() {
        String obj = zzcn(true).toString();
        return new StringBuilder(String.valueOf(obj).length() + 15).append("CompoundWrite{").append(obj).append("}").toString();
    }

    public final zzecy zza(zzejg com_google_android_gms_internal_zzejg, zzekd com_google_android_gms_internal_zzekd) {
        return zze(new zzedk(com_google_android_gms_internal_zzejg), com_google_android_gms_internal_zzekd);
    }

    public final zzecy zzb(zzedk com_google_android_gms_internal_zzedk, zzecy com_google_android_gms_internal_zzecy) {
        return (zzecy) com_google_android_gms_internal_zzecy.zzmru.zzb((Object) this, new zzecz(this, com_google_android_gms_internal_zzedk));
    }

    public final zzekd zzb(zzekd com_google_android_gms_internal_zzekd) {
        return zza(zzedk.zzbwe(), this.zzmru, com_google_android_gms_internal_zzekd);
    }

    public final zzekd zzbvr() {
        return (zzekd) this.zzmru.getValue();
    }

    public final List<zzekc> zzbvs() {
        List<zzekc> arrayList = new ArrayList();
        if (this.zzmru.getValue() != null) {
            for (zzekc com_google_android_gms_internal_zzekc : (zzekd) this.zzmru.getValue()) {
                arrayList.add(new zzekc(com_google_android_gms_internal_zzekc.zzcao(), com_google_android_gms_internal_zzekc.zzbsv()));
            }
        } else {
            Iterator it = this.zzmru.zzbxx().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                zzehm com_google_android_gms_internal_zzehm = (zzehm) entry.getValue();
                if (com_google_android_gms_internal_zzehm.getValue() != null) {
                    arrayList.add(new zzekc((zzejg) entry.getKey(), (zzekd) com_google_android_gms_internal_zzehm.getValue()));
                }
            }
        }
        return arrayList;
    }

    public final Map<zzejg, zzecy> zzbvt() {
        Map<zzejg, zzecy> hashMap = new HashMap();
        Iterator it = this.zzmru.zzbxx().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            hashMap.put((zzejg) entry.getKey(), new zzecy((zzehm) entry.getValue()));
        }
        return hashMap;
    }

    public final Map<String, Object> zzcn(boolean z) {
        Map<String, Object> hashMap = new HashMap();
        this.zzmru.zza(new zzeda(this, hashMap, true));
        return hashMap;
    }

    public final zzecy zzd(zzedk com_google_android_gms_internal_zzedk) {
        return com_google_android_gms_internal_zzedk.isEmpty() ? zzmrt : new zzecy(this.zzmru.zza(com_google_android_gms_internal_zzedk, zzehm.zzbxw()));
    }

    public final zzecy zze(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        if (com_google_android_gms_internal_zzedk.isEmpty()) {
            return new zzecy(new zzehm(com_google_android_gms_internal_zzekd));
        }
        zzedk zzaf = this.zzmru.zzaf(com_google_android_gms_internal_zzedk);
        if (zzaf != null) {
            zzedk zza = zzedk.zza(zzaf, com_google_android_gms_internal_zzedk);
            zzekd com_google_android_gms_internal_zzekd2 = (zzekd) this.zzmru.zzaj(zzaf);
            zzejg zzbwk = zza.zzbwk();
            if (zzbwk != null && zzbwk.zzbzr() && com_google_android_gms_internal_zzekd2.zzan(zza.zzbwj()).isEmpty()) {
                return this;
            }
            return new zzecy(this.zzmru.zzb(zzaf, com_google_android_gms_internal_zzekd2.zzl(zza, com_google_android_gms_internal_zzekd)));
        }
        return new zzecy(this.zzmru.zza(com_google_android_gms_internal_zzedk, new zzehm(com_google_android_gms_internal_zzekd)));
    }

    public final boolean zze(zzedk com_google_android_gms_internal_zzedk) {
        return zzf(com_google_android_gms_internal_zzedk) != null;
    }

    public final zzekd zzf(zzedk com_google_android_gms_internal_zzedk) {
        zzedk zzaf = this.zzmru.zzaf(com_google_android_gms_internal_zzedk);
        return zzaf != null ? ((zzekd) this.zzmru.zzaj(zzaf)).zzan(zzedk.zza(zzaf, com_google_android_gms_internal_zzedk)) : null;
    }

    public final zzecy zzg(zzedk com_google_android_gms_internal_zzedk) {
        if (com_google_android_gms_internal_zzedk.isEmpty()) {
            return this;
        }
        zzekd zzf = zzf(com_google_android_gms_internal_zzedk);
        return zzf != null ? new zzecy(new zzehm(zzf)) : new zzecy(this.zzmru.zzah(com_google_android_gms_internal_zzedk));
    }
}
