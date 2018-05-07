package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class zzefg {
    private final Map<zzeih, zzeil> zzmvm = new HashMap();
    private final zzegy zzmvn;

    public zzefg(zzegy com_google_android_gms_internal_zzegy) {
        this.zzmvn = com_google_android_gms_internal_zzegy;
    }

    private final List<zzeia> zza(zzeil com_google_android_gms_internal_zzeil, zzego com_google_android_gms_internal_zzego, zzegj com_google_android_gms_internal_zzegj, zzekd com_google_android_gms_internal_zzekd) {
        zzeim zzb = com_google_android_gms_internal_zzeil.zzb(com_google_android_gms_internal_zzego, com_google_android_gms_internal_zzegj, com_google_android_gms_internal_zzekd);
        if (!com_google_android_gms_internal_zzeil.zzbyz().zzbyv()) {
            Set hashSet = new HashSet();
            Set hashSet2 = new HashSet();
            for (zzehz com_google_android_gms_internal_zzehz : zzb.zznav) {
                zzeic zzbye = com_google_android_gms_internal_zzehz.zzbye();
                if (zzbye == zzeic.CHILD_ADDED) {
                    hashSet2.add(com_google_android_gms_internal_zzehz.zzbyd());
                } else if (zzbye == zzeic.CHILD_REMOVED) {
                    hashSet.add(com_google_android_gms_internal_zzehz.zzbyd());
                }
            }
            if (!(hashSet2.isEmpty() && hashSet.isEmpty())) {
                this.zzmvn.zza(com_google_android_gms_internal_zzeil.zzbyz(), hashSet2, hashSet);
            }
        }
        return zzb.zznau;
    }

    public final boolean isEmpty() {
        return this.zzmvm.isEmpty();
    }

    public final zzelq<List<zzeik>, List<zzeib>> zza(zzeik com_google_android_gms_internal_zzeik, zzedh com_google_android_gms_internal_zzedh, DatabaseError databaseError) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        boolean zzbwt = zzbwt();
        zzeil com_google_android_gms_internal_zzeil;
        if (com_google_android_gms_internal_zzeik.isDefault()) {
            Iterator it = this.zzmvm.entrySet().iterator();
            while (it.hasNext()) {
                com_google_android_gms_internal_zzeil = (zzeil) ((Entry) it.next()).getValue();
                arrayList2.addAll(com_google_android_gms_internal_zzeil.zza(com_google_android_gms_internal_zzedh, databaseError));
                if (com_google_android_gms_internal_zzeil.isEmpty()) {
                    it.remove();
                    if (!com_google_android_gms_internal_zzeil.zzbyz().zzbyv()) {
                        arrayList.add(com_google_android_gms_internal_zzeil.zzbyz());
                    }
                }
            }
        } else {
            com_google_android_gms_internal_zzeil = (zzeil) this.zzmvm.get(com_google_android_gms_internal_zzeik.zzbyy());
            if (com_google_android_gms_internal_zzeil != null) {
                arrayList2.addAll(com_google_android_gms_internal_zzeil.zza(com_google_android_gms_internal_zzedh, databaseError));
                if (com_google_android_gms_internal_zzeil.isEmpty()) {
                    this.zzmvm.remove(com_google_android_gms_internal_zzeik.zzbyy());
                    if (!com_google_android_gms_internal_zzeil.zzbyz().zzbyv()) {
                        arrayList.add(com_google_android_gms_internal_zzeil.zzbyz());
                    }
                }
            }
        }
        if (zzbwt && !zzbwt()) {
            arrayList.add(zzeik.zzam(com_google_android_gms_internal_zzeik.zzbsy()));
        }
        return new zzelq(arrayList, arrayList2);
    }

    public final List<zzeia> zza(zzedh com_google_android_gms_internal_zzedh, zzegj com_google_android_gms_internal_zzegj, zzehx com_google_android_gms_internal_zzehx) {
        zzeik zzbvp = com_google_android_gms_internal_zzedh.zzbvp();
        zzeil com_google_android_gms_internal_zzeil = (zzeil) this.zzmvm.get(zzbvp.zzbyy());
        if (com_google_android_gms_internal_zzeil == null) {
            boolean z;
            zzekd zzc = com_google_android_gms_internal_zzegj.zzc(com_google_android_gms_internal_zzehx.zzbxz() ? com_google_android_gms_internal_zzehx.zzbsv() : null);
            if (zzc != null) {
                z = true;
            } else {
                zzc = com_google_android_gms_internal_zzegj.zzd(com_google_android_gms_internal_zzehx.zzbsv());
                z = false;
            }
            zzeil com_google_android_gms_internal_zzeil2 = new zzeil(zzbvp, new zzein(new zzehx(zzejw.zza(zzc, zzbvp.zzbyr()), z, false), com_google_android_gms_internal_zzehx));
            if (!zzbvp.zzbyv()) {
                Set hashSet = new HashSet();
                for (zzekc zzcao : com_google_android_gms_internal_zzeil2.zzbzb()) {
                    hashSet.add(zzcao.zzcao());
                }
                this.zzmvn.zza(zzbvp, hashSet);
            }
            this.zzmvm.put(zzbvp.zzbyy(), com_google_android_gms_internal_zzeil2);
            com_google_android_gms_internal_zzeil = com_google_android_gms_internal_zzeil2;
        }
        com_google_android_gms_internal_zzeil.zzb(com_google_android_gms_internal_zzedh);
        return com_google_android_gms_internal_zzeil.zzk(com_google_android_gms_internal_zzedh);
    }

    public final List<zzeia> zza(zzego com_google_android_gms_internal_zzego, zzegj com_google_android_gms_internal_zzegj, zzekd com_google_android_gms_internal_zzekd) {
        zzeih zzbxn = com_google_android_gms_internal_zzego.zzbxj().zzbxn();
        if (zzbxn != null) {
            return zza((zzeil) this.zzmvm.get(zzbxn), com_google_android_gms_internal_zzego, com_google_android_gms_internal_zzegj, com_google_android_gms_internal_zzekd);
        }
        List<zzeia> arrayList = new ArrayList();
        for (Entry value : this.zzmvm.entrySet()) {
            arrayList.addAll(zza((zzeil) value.getValue(), com_google_android_gms_internal_zzego, com_google_android_gms_internal_zzegj, com_google_android_gms_internal_zzekd));
        }
        return arrayList;
    }

    public final zzeil zzb(zzeik com_google_android_gms_internal_zzeik) {
        return com_google_android_gms_internal_zzeik.zzbyv() ? zzbwu() : (zzeil) this.zzmvm.get(com_google_android_gms_internal_zzeik.zzbyy());
    }

    public final List<zzeil> zzbws() {
        List<zzeil> arrayList = new ArrayList();
        for (Entry value : this.zzmvm.entrySet()) {
            zzeil com_google_android_gms_internal_zzeil = (zzeil) value.getValue();
            if (!com_google_android_gms_internal_zzeil.zzbyz().zzbyv()) {
                arrayList.add(com_google_android_gms_internal_zzeil);
            }
        }
        return arrayList;
    }

    public final boolean zzbwt() {
        return zzbwu() != null;
    }

    public final zzeil zzbwu() {
        for (Entry value : this.zzmvm.entrySet()) {
            zzeil com_google_android_gms_internal_zzeil = (zzeil) value.getValue();
            if (com_google_android_gms_internal_zzeil.zzbyz().zzbyv()) {
                return com_google_android_gms_internal_zzeil;
            }
        }
        return null;
    }

    public final boolean zzc(zzeik com_google_android_gms_internal_zzeik) {
        return zzb(com_google_android_gms_internal_zzeik) != null;
    }

    public final zzekd zzr(zzedk com_google_android_gms_internal_zzedk) {
        for (zzeil com_google_android_gms_internal_zzeil : this.zzmvm.values()) {
            if (com_google_android_gms_internal_zzeil.zzr(com_google_android_gms_internal_zzedk) != null) {
                return com_google_android_gms_internal_zzeil.zzr(com_google_android_gms_internal_zzedk);
            }
        }
        return null;
    }
}
