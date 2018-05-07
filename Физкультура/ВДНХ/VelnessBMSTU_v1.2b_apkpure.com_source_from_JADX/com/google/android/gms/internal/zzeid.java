package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzeid {
    private final zzeik zzmzz;
    private final zzejv zznaa;

    public zzeid(zzeik com_google_android_gms_internal_zzeik) {
        this.zzmzz = com_google_android_gms_internal_zzeik;
        this.zznaa = com_google_android_gms_internal_zzeik.zzbyr();
    }

    private final void zza(List<zzeia> list, zzeic com_google_android_gms_internal_zzeic, List<zzehz> list2, List<zzedh> list3, zzejw com_google_android_gms_internal_zzejw) {
        List arrayList = new ArrayList();
        for (zzehz com_google_android_gms_internal_zzehz : list2) {
            if (com_google_android_gms_internal_zzehz.zzbye().equals(com_google_android_gms_internal_zzeic)) {
                arrayList.add(com_google_android_gms_internal_zzehz);
            }
        }
        Collections.sort(arrayList, new zzeie(this));
        ArrayList arrayList2 = (ArrayList) arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            zzehz com_google_android_gms_internal_zzehz2 = (zzehz) arrayList2.get(i);
            for (zzedh com_google_android_gms_internal_zzedh : list3) {
                if (com_google_android_gms_internal_zzedh.zza(com_google_android_gms_internal_zzeic)) {
                    zzehz zzg = (com_google_android_gms_internal_zzehz2.zzbye().equals(zzeic.VALUE) || com_google_android_gms_internal_zzehz2.zzbye().equals(zzeic.CHILD_REMOVED)) ? com_google_android_gms_internal_zzehz2 : com_google_android_gms_internal_zzehz2.zzg(com_google_android_gms_internal_zzejw.zza(com_google_android_gms_internal_zzehz2.zzbyd(), com_google_android_gms_internal_zzehz2.zzbyb().zzbsv(), this.zznaa));
                    list.add(com_google_android_gms_internal_zzedh.zza(zzg, this.zzmzz));
                }
            }
            i = i2;
        }
    }

    public final List<zzeia> zza(List<zzehz> list, zzejw com_google_android_gms_internal_zzejw, List<zzedh> list2) {
        List<zzeia> arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        for (zzehz com_google_android_gms_internal_zzehz : list) {
            if (com_google_android_gms_internal_zzehz.zzbye().equals(zzeic.CHILD_CHANGED)) {
                if ((this.zznaa.compare(new zzekc(zzejg.zzbzn(), com_google_android_gms_internal_zzehz.zzbyg().zzbsv()), new zzekc(zzejg.zzbzn(), com_google_android_gms_internal_zzehz.zzbyb().zzbsv())) != 0 ? 1 : null) != null) {
                    arrayList2.add(zzehz.zzc(com_google_android_gms_internal_zzehz.zzbyd(), com_google_android_gms_internal_zzehz.zzbyb()));
                }
            }
        }
        zza(arrayList, zzeic.CHILD_REMOVED, list, list2, com_google_android_gms_internal_zzejw);
        zza(arrayList, zzeic.CHILD_ADDED, list, list2, com_google_android_gms_internal_zzejw);
        zza(arrayList, zzeic.CHILD_MOVED, arrayList2, list2, com_google_android_gms_internal_zzejw);
        zza(arrayList, zzeic.CHILD_CHANGED, list, list2, com_google_android_gms_internal_zzejw);
        zza(arrayList, zzeic.VALUE, list, list2, com_google_android_gms_internal_zzejw);
        return arrayList;
    }
}
