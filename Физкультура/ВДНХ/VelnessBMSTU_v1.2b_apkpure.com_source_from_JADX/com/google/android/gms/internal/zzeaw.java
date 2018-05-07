package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzeaw<A, B, C> {
    private final Map<B, C> values;
    private final List<A> zzmms;
    private final zzeaj<A, B> zzmmt;
    private zzeat<A, C> zzmmu;
    private zzeat<A, C> zzmmv;

    private zzeaw(List<A> list, Map<B, C> map, zzeaj<A, B> com_google_android_gms_internal_zzeaj_A__B) {
        this.zzmms = list;
        this.values = map;
        this.zzmmt = com_google_android_gms_internal_zzeaj_A__B;
    }

    private final C zzbp(A a) {
        return this.values.get(this.zzmmt.zzbk(a));
    }

    public static <A, B, C> zzeau<A, C> zzc(List<A> list, Map<B, C> map, zzeaj<A, B> com_google_android_gms_internal_zzeaj_A__B, Comparator<A> comparator) {
        zzeaw com_google_android_gms_internal_zzeaw = new zzeaw(list, map, com_google_android_gms_internal_zzeaj_A__B);
        Collections.sort(list, comparator);
        Iterator it = new zzeax(list.size()).iterator();
        int size = list.size();
        while (it.hasNext()) {
            zzeaz com_google_android_gms_internal_zzeaz = (zzeaz) it.next();
            size -= com_google_android_gms_internal_zzeaz.zzmmz;
            if (com_google_android_gms_internal_zzeaz.zzmmy) {
                com_google_android_gms_internal_zzeaw.zzf(zzeaq.zzmmm, com_google_android_gms_internal_zzeaz.zzmmz, size);
            } else {
                com_google_android_gms_internal_zzeaw.zzf(zzeaq.zzmmm, com_google_android_gms_internal_zzeaz.zzmmz, size);
                size -= com_google_android_gms_internal_zzeaz.zzmmz;
                com_google_android_gms_internal_zzeaw.zzf(zzeaq.zzmml, com_google_android_gms_internal_zzeaz.zzmmz, size);
            }
        }
        return new zzeau(com_google_android_gms_internal_zzeaw.zzmmu == null ? zzeao.zzbto() : com_google_android_gms_internal_zzeaw.zzmmu, comparator);
    }

    private final void zzf(int i, int i2, int i3) {
        zzeap zzu = zzu(i3 + 1, i2 - 1);
        Object obj = this.zzmms.get(i3);
        zzeap com_google_android_gms_internal_zzeas = i == zzeaq.zzmml ? new zzeas(obj, zzbp(obj), null, zzu) : new zzean(obj, zzbp(obj), null, zzu);
        if (this.zzmmu == null) {
            this.zzmmu = com_google_android_gms_internal_zzeas;
            this.zzmmv = com_google_android_gms_internal_zzeas;
            return;
        }
        this.zzmmv.zza(com_google_android_gms_internal_zzeas);
        this.zzmmv = com_google_android_gms_internal_zzeas;
    }

    private final zzeap<A, C> zzu(int i, int i2) {
        if (i2 == 0) {
            return zzeao.zzbto();
        }
        if (i2 == 1) {
            Object obj = this.zzmms.get(i);
            return new zzean(obj, zzbp(obj), null, null);
        }
        int i3 = i2 / 2;
        int i4 = i + i3;
        zzeap zzu = zzu(i, i3);
        zzeap zzu2 = zzu(i4 + 1, i3);
        obj = this.zzmms.get(i4);
        return new zzean(obj, zzbp(obj), zzu, zzu2);
    }
}
