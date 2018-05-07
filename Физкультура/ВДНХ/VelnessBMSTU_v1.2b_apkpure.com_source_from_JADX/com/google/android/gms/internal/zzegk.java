package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class zzegk implements zzedi {
    private static zzegk zzmxh = new zzegk();
    private HashMap<zzedh, List<zzedh>> zzmxg = new HashMap();

    private zzegk() {
    }

    public static zzegk zzbxf() {
        return zzmxh;
    }

    public final void zzd(zzedh com_google_android_gms_internal_zzedh) {
        int i = 0;
        synchronized (this.zzmxg) {
            List list = (List) this.zzmxg.get(com_google_android_gms_internal_zzedh);
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (list.get(i2) == com_google_android_gms_internal_zzedh) {
                        list.remove(i2);
                        break;
                    }
                }
                if (list.isEmpty()) {
                    this.zzmxg.remove(com_google_android_gms_internal_zzedh);
                }
            }
            if (!com_google_android_gms_internal_zzedh.zzbvp().isDefault()) {
                zzedh zza = com_google_android_gms_internal_zzedh.zza(zzeik.zzam(com_google_android_gms_internal_zzedh.zzbvp().zzbsy()));
                list = (List) this.zzmxg.get(zza);
                if (list != null) {
                    while (i < list.size()) {
                        if (list.get(i) == com_google_android_gms_internal_zzedh) {
                            list.remove(i);
                            break;
                        }
                        i++;
                    }
                    if (list.isEmpty()) {
                        this.zzmxg.remove(zza);
                    }
                }
            }
        }
    }

    public final void zzi(zzedh com_google_android_gms_internal_zzedh) {
        synchronized (this.zzmxg) {
            List list = (List) this.zzmxg.get(com_google_android_gms_internal_zzedh);
            if (list == null) {
                list = new ArrayList();
                this.zzmxg.put(com_google_android_gms_internal_zzedh, list);
            }
            list.add(com_google_android_gms_internal_zzedh);
            if (!com_google_android_gms_internal_zzedh.zzbvp().isDefault()) {
                zzedh zza = com_google_android_gms_internal_zzedh.zza(zzeik.zzam(com_google_android_gms_internal_zzedh.zzbvp().zzbsy()));
                list = (List) this.zzmxg.get(zza);
                if (list == null) {
                    list = new ArrayList();
                    this.zzmxg.put(zza, list);
                }
                list.add(com_google_android_gms_internal_zzedh);
            }
            com_google_android_gms_internal_zzedh.zzco(true);
            com_google_android_gms_internal_zzedh.zza((zzedi) this);
        }
    }

    public final void zzj(zzedh com_google_android_gms_internal_zzedh) {
        synchronized (this.zzmxg) {
            List list = (List) this.zzmxg.get(com_google_android_gms_internal_zzedh);
            if (!(list == null || list.isEmpty())) {
                if (com_google_android_gms_internal_zzedh.zzbvp().isDefault()) {
                    HashSet hashSet = new HashSet();
                    for (int size = list.size() - 1; size >= 0; size--) {
                        zzedh com_google_android_gms_internal_zzedh2 = (zzedh) list.get(size);
                        if (!hashSet.contains(com_google_android_gms_internal_zzedh2.zzbvp())) {
                            hashSet.add(com_google_android_gms_internal_zzedh2.zzbvp());
                            com_google_android_gms_internal_zzedh2.zzbwc();
                        }
                    }
                } else {
                    ((zzedh) list.get(0)).zzbwc();
                }
            }
        }
    }
}
