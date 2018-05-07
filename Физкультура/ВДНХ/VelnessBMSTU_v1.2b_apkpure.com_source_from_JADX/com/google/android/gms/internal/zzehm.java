package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class zzehm<T> implements Iterable<Entry<zzedk, T>> {
    private static final zzeag zzmyy = zzeah.zza(zzeba.zze(zzejg.class));
    private static final zzehm zzmyz = new zzehm(null, zzmyy);
    private final T value;
    private final zzeag<zzejg, zzehm<T>> zzmyx;

    public zzehm(T t) {
        this(t, zzmyy);
    }

    private zzehm(T t, zzeag<zzejg, zzehm<T>> com_google_android_gms_internal_zzeag_com_google_android_gms_internal_zzejg__com_google_android_gms_internal_zzehm_T) {
        this.value = t;
        this.zzmyx = com_google_android_gms_internal_zzeag_com_google_android_gms_internal_zzejg__com_google_android_gms_internal_zzehm_T;
    }

    private final <R> R zza(zzedk com_google_android_gms_internal_zzedk, zzehp<? super T, R> com_google_android_gms_internal_zzehp__super_T__R, R r) {
        Iterator it = this.zzmyx.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            r = ((zzehm) entry.getValue()).zza(com_google_android_gms_internal_zzedk.zza((zzejg) entry.getKey()), com_google_android_gms_internal_zzehp__super_T__R, r);
        }
        return this.value != null ? com_google_android_gms_internal_zzehp__super_T__R.zza(com_google_android_gms_internal_zzedk, this.value, r) : r;
    }

    public static <V> zzehm<V> zzbxw() {
        return zzmyz;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzehm com_google_android_gms_internal_zzehm = (zzehm) obj;
        if (this.zzmyx == null ? com_google_android_gms_internal_zzehm.zzmyx != null : !this.zzmyx.equals(com_google_android_gms_internal_zzehm.zzmyx)) {
            return false;
        }
        if (this.value != null) {
            if (this.value.equals(com_google_android_gms_internal_zzehm.value)) {
                return true;
            }
        } else if (com_google_android_gms_internal_zzehm.value == null) {
            return true;
        }
        return false;
    }

    public final T getValue() {
        return this.value;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (this.value != null ? this.value.hashCode() : 0) * 31;
        if (this.zzmyx != null) {
            i = this.zzmyx.hashCode();
        }
        return hashCode + i;
    }

    public final boolean isEmpty() {
        return this.value == null && this.zzmyx.isEmpty();
    }

    public final Iterator<Entry<zzedk, T>> iterator() {
        List arrayList = new ArrayList();
        zza(new zzeho(this, arrayList));
        return arrayList.iterator();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ImmutableTree { value=");
        stringBuilder.append(this.value);
        stringBuilder.append(", children={");
        Iterator it = this.zzmyx.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            stringBuilder.append(((zzejg) entry.getKey()).asString());
            stringBuilder.append("=");
            stringBuilder.append(entry.getValue());
        }
        stringBuilder.append("} }");
        return stringBuilder.toString();
    }

    public final Collection<T> values() {
        Collection arrayList = new ArrayList();
        zza(new zzehn(this, arrayList));
        return arrayList;
    }

    public final zzedk zza(zzedk com_google_android_gms_internal_zzedk, zzehq<? super T> com_google_android_gms_internal_zzehq__super_T) {
        if (this.value != null && com_google_android_gms_internal_zzehq__super_T.zzbs(this.value)) {
            return zzedk.zzbwe();
        }
        if (com_google_android_gms_internal_zzedk.isEmpty()) {
            return null;
        }
        zzehm com_google_android_gms_internal_zzehm = (zzehm) this.zzmyx.get(com_google_android_gms_internal_zzedk.zzbwh());
        if (com_google_android_gms_internal_zzehm == null) {
            return null;
        }
        zzedk zza = com_google_android_gms_internal_zzehm.zza(com_google_android_gms_internal_zzedk.zzbwi(), (zzehq) com_google_android_gms_internal_zzehq__super_T);
        if (zza == null) {
            return null;
        }
        return new zzedk(r2).zzh(zza);
    }

    public final zzehm<T> zza(zzedk com_google_android_gms_internal_zzedk, zzehm<T> com_google_android_gms_internal_zzehm_T) {
        if (com_google_android_gms_internal_zzedk.isEmpty()) {
            return com_google_android_gms_internal_zzehm_T;
        }
        zzejg zzbwh = com_google_android_gms_internal_zzedk.zzbwh();
        zzehm com_google_android_gms_internal_zzehm = (zzehm) this.zzmyx.get(zzbwh);
        if (com_google_android_gms_internal_zzehm == null) {
            com_google_android_gms_internal_zzehm = zzmyz;
        }
        com_google_android_gms_internal_zzehm = com_google_android_gms_internal_zzehm.zza(com_google_android_gms_internal_zzedk.zzbwi(), (zzehm) com_google_android_gms_internal_zzehm_T);
        return new zzehm(this.value, com_google_android_gms_internal_zzehm.isEmpty() ? this.zzmyx.zzbf(zzbwh) : this.zzmyx.zzg(zzbwh, com_google_android_gms_internal_zzehm));
    }

    public final void zza(zzehp<T, Void> com_google_android_gms_internal_zzehp_T__java_lang_Void) {
        zza(zzedk.zzbwe(), com_google_android_gms_internal_zzehp_T__java_lang_Void, null);
    }

    public final zzedk zzaf(zzedk com_google_android_gms_internal_zzedk) {
        return zza(com_google_android_gms_internal_zzedk, zzehq.zzmzc);
    }

    public final T zzag(zzedk com_google_android_gms_internal_zzedk) {
        zzehq com_google_android_gms_internal_zzehq = zzehq.zzmzc;
        T t = (this.value == null || !com_google_android_gms_internal_zzehq.zzbs(this.value)) ? null : this.value;
        Iterator it = com_google_android_gms_internal_zzedk.iterator();
        T t2 = t;
        while (it.hasNext()) {
            zzehm com_google_android_gms_internal_zzehm = (zzehm) this.zzmyx.get((zzejg) it.next());
            if (com_google_android_gms_internal_zzehm == null) {
                break;
            }
            if (com_google_android_gms_internal_zzehm.value != null && com_google_android_gms_internal_zzehq.zzbs(com_google_android_gms_internal_zzehm.value)) {
                t2 = com_google_android_gms_internal_zzehm.value;
            }
            this = com_google_android_gms_internal_zzehm;
        }
        return t2;
    }

    public final zzehm<T> zzah(zzedk com_google_android_gms_internal_zzedk) {
        zzehm<T> com_google_android_gms_internal_zzehm_T;
        while (!com_google_android_gms_internal_zzedk.isEmpty()) {
            zzehm<T> com_google_android_gms_internal_zzehm_T2 = (zzehm) com_google_android_gms_internal_zzehm_T.zzmyx.get(com_google_android_gms_internal_zzedk.zzbwh());
            if (com_google_android_gms_internal_zzehm_T2 == null) {
                return zzmyz;
            }
            com_google_android_gms_internal_zzedk = com_google_android_gms_internal_zzedk.zzbwi();
            com_google_android_gms_internal_zzehm_T = com_google_android_gms_internal_zzehm_T2;
        }
        return com_google_android_gms_internal_zzehm_T;
    }

    public final zzehm<T> zzai(zzedk com_google_android_gms_internal_zzedk) {
        if (com_google_android_gms_internal_zzedk.isEmpty()) {
            return this.zzmyx.isEmpty() ? zzmyz : new zzehm(null, this.zzmyx);
        } else {
            zzejg zzbwh = com_google_android_gms_internal_zzedk.zzbwh();
            zzehm com_google_android_gms_internal_zzehm = (zzehm) this.zzmyx.get(zzbwh);
            if (com_google_android_gms_internal_zzehm == null) {
                return this;
            }
            com_google_android_gms_internal_zzehm = com_google_android_gms_internal_zzehm.zzai(com_google_android_gms_internal_zzedk.zzbwi());
            zzeag zzbf = com_google_android_gms_internal_zzehm.isEmpty() ? this.zzmyx.zzbf(zzbwh) : this.zzmyx.zzg(zzbwh, com_google_android_gms_internal_zzehm);
            return (this.value == null && zzbf.isEmpty()) ? zzmyz : new zzehm(this.value, zzbf);
        }
    }

    public final T zzaj(zzedk com_google_android_gms_internal_zzedk) {
        while (!com_google_android_gms_internal_zzedk.isEmpty()) {
            zzehm com_google_android_gms_internal_zzehm = (zzehm) this.zzmyx.get(com_google_android_gms_internal_zzedk.zzbwh());
            if (com_google_android_gms_internal_zzehm == null) {
                return null;
            }
            com_google_android_gms_internal_zzedk = com_google_android_gms_internal_zzedk.zzbwi();
            this = com_google_android_gms_internal_zzehm;
        }
        return this.value;
    }

    public final zzehm<T> zzb(zzedk com_google_android_gms_internal_zzedk, T t) {
        if (com_google_android_gms_internal_zzedk.isEmpty()) {
            return new zzehm(t, this.zzmyx);
        }
        zzejg zzbwh = com_google_android_gms_internal_zzedk.zzbwh();
        zzehm com_google_android_gms_internal_zzehm = (zzehm) this.zzmyx.get(zzbwh);
        if (com_google_android_gms_internal_zzehm == null) {
            com_google_android_gms_internal_zzehm = zzmyz;
        }
        return new zzehm(this.value, this.zzmyx.zzg(zzbwh, com_google_android_gms_internal_zzehm.zzb(com_google_android_gms_internal_zzedk.zzbwi(), (Object) t)));
    }

    public final T zzb(zzedk com_google_android_gms_internal_zzedk, zzehq<? super T> com_google_android_gms_internal_zzehq__super_T) {
        if (this.value != null && com_google_android_gms_internal_zzehq__super_T.zzbs(this.value)) {
            return this.value;
        }
        Iterator it = com_google_android_gms_internal_zzedk.iterator();
        while (it.hasNext()) {
            zzehm com_google_android_gms_internal_zzehm = (zzehm) this.zzmyx.get((zzejg) it.next());
            if (com_google_android_gms_internal_zzehm == null) {
                return null;
            }
            if (com_google_android_gms_internal_zzehm.value != null && com_google_android_gms_internal_zzehq__super_T.zzbs(com_google_android_gms_internal_zzehm.value)) {
                return com_google_android_gms_internal_zzehm.value;
            }
            this = com_google_android_gms_internal_zzehm;
        }
        return null;
    }

    public final <R> R zzb(R r, zzehp<? super T, R> com_google_android_gms_internal_zzehp__super_T__R) {
        return zza(zzedk.zzbwe(), com_google_android_gms_internal_zzehp__super_T__R, r);
    }

    public final boolean zzb(zzehq<? super T> com_google_android_gms_internal_zzehq__super_T) {
        if (this.value != null && com_google_android_gms_internal_zzehq__super_T.zzbs(this.value)) {
            return true;
        }
        Iterator it = this.zzmyx.iterator();
        while (it.hasNext()) {
            if (((zzehm) ((Entry) it.next()).getValue()).zzb(com_google_android_gms_internal_zzehq__super_T)) {
                return true;
            }
        }
        return false;
    }

    public final zzeag<zzejg, zzehm<T>> zzbxx() {
        return this.zzmyx;
    }

    public final zzehm<T> zze(zzejg com_google_android_gms_internal_zzejg) {
        zzehm<T> com_google_android_gms_internal_zzehm_T = (zzehm) this.zzmyx.get(com_google_android_gms_internal_zzejg);
        return com_google_android_gms_internal_zzehm_T != null ? com_google_android_gms_internal_zzehm_T : zzmyz;
    }
}
