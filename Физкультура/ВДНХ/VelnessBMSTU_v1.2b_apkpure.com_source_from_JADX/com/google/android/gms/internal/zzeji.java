package com.google.android.gms.internal;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class zzeji implements zzekd {
    public static Comparator<zzejg> zznbw = new zzejj();
    private final zzeag<zzejg, zzekd> zzmyx;
    private final zzekd zznbx;
    private String zznby;

    protected zzeji() {
        this.zznby = null;
        this.zzmyx = zzeah.zza(zznbw);
        this.zznbx = zzeju.zzcaf();
    }

    protected zzeji(zzeag<zzejg, zzekd> com_google_android_gms_internal_zzeag_com_google_android_gms_internal_zzejg__com_google_android_gms_internal_zzekd, zzekd com_google_android_gms_internal_zzekd) {
        this.zznby = null;
        if (!com_google_android_gms_internal_zzeag_com_google_android_gms_internal_zzejg__com_google_android_gms_internal_zzekd.isEmpty() || com_google_android_gms_internal_zzekd.isEmpty()) {
            this.zznbx = com_google_android_gms_internal_zzekd;
            this.zzmyx = com_google_android_gms_internal_zzeag_com_google_android_gms_internal_zzejg__com_google_android_gms_internal_zzekd;
            return;
        }
        throw new IllegalArgumentException("Can't create empty ChildrenNode with priority!");
    }

    private static void zzb(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        }
    }

    private final void zzc(StringBuilder stringBuilder, int i) {
        if (this.zzmyx.isEmpty() && this.zznbx.isEmpty()) {
            stringBuilder.append("{ }");
            return;
        }
        stringBuilder.append("{\n");
        Iterator it = this.zzmyx.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzb(stringBuilder, i + 2);
            stringBuilder.append(((zzejg) entry.getKey()).asString());
            stringBuilder.append("=");
            if (entry.getValue() instanceof zzeji) {
                ((zzeji) entry.getValue()).zzc(stringBuilder, i + 2);
            } else {
                stringBuilder.append(((zzekd) entry.getValue()).toString());
            }
            stringBuilder.append("\n");
        }
        if (!this.zznbx.isEmpty()) {
            zzb(stringBuilder, i + 2);
            stringBuilder.append(".priority=");
            stringBuilder.append(this.zznbx.toString());
            stringBuilder.append("\n");
        }
        zzb(stringBuilder, i);
        stringBuilder.append("}");
    }

    public /* synthetic */ int compareTo(Object obj) {
        return zzg((zzekd) obj);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeji)) {
            return false;
        }
        zzeji com_google_android_gms_internal_zzeji = (zzeji) obj;
        if (!zzbzv().equals(com_google_android_gms_internal_zzeji.zzbzv())) {
            return false;
        }
        if (this.zzmyx.size() != com_google_android_gms_internal_zzeji.zzmyx.size()) {
            return false;
        }
        Iterator it = this.zzmyx.iterator();
        Iterator it2 = com_google_android_gms_internal_zzeji.zzmyx.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Entry entry = (Entry) it.next();
            Entry entry2 = (Entry) it2.next();
            if (((zzejg) entry.getKey()).equals(entry2.getKey())) {
                if (!((zzekd) entry.getValue()).equals(entry2.getValue())) {
                }
            }
            return false;
        }
        if (!it.hasNext() && !it2.hasNext()) {
            return true;
        }
        throw new IllegalStateException("Something went wrong internally.");
    }

    public int getChildCount() {
        return this.zzmyx.size();
    }

    public Object getValue() {
        return getValue(false);
    }

    public Object getValue(boolean z) {
        int i = 0;
        if (isEmpty()) {
            return null;
        }
        Map hashMap = new HashMap();
        Iterator it = this.zzmyx.iterator();
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (it.hasNext()) {
            int i5;
            Entry entry = (Entry) it.next();
            String asString = ((zzejg) entry.getKey()).asString();
            hashMap.put(asString, ((zzekd) entry.getValue()).getValue(z));
            int i6 = i4 + 1;
            if (i2 != 0) {
                if (asString.length() <= 1 || asString.charAt(0) != '0') {
                    Integer zzqg = zzelt.zzqg(asString);
                    if (zzqg != null && zzqg.intValue() >= 0) {
                        if (zzqg.intValue() > i3) {
                            i3 = zzqg.intValue();
                            i4 = i6;
                        }
                    }
                }
                i5 = 0;
                i2 = i5;
                i4 = i6;
            }
            i5 = i2;
            i2 = i5;
            i4 = i6;
        }
        if (z || i2 == 0 || i3 >= i4 * 2) {
            if (z && !this.zznbx.isEmpty()) {
                hashMap.put(".priority", this.zznbx.getValue());
            }
            return hashMap;
        }
        List arrayList = new ArrayList(i3 + 1);
        while (i <= i3) {
            arrayList.add(hashMap.get(i));
            i++;
        }
        return arrayList;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            zzekc com_google_android_gms_internal_zzekc = (zzekc) it.next();
            i = com_google_android_gms_internal_zzekc.zzbsv().hashCode() + (((i * 31) + com_google_android_gms_internal_zzekc.zzcao().hashCode()) * 17);
        }
        return i;
    }

    public boolean isEmpty() {
        return this.zzmyx.isEmpty();
    }

    public Iterator<zzekc> iterator() {
        return new zzejm(this.zzmyx.iterator());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        zzc(stringBuilder, 0);
        return stringBuilder.toString();
    }

    public String zza(zzekf com_google_android_gms_internal_zzekf) {
        int i = 0;
        if (com_google_android_gms_internal_zzekf != zzekf.V1) {
            throw new IllegalArgumentException("Hashes on children nodes only supported for V1");
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (!this.zznbx.isEmpty()) {
            stringBuilder.append("priority:");
            stringBuilder.append(this.zznbx.zza(zzekf.V1));
            stringBuilder.append(":");
        }
        List arrayList = new ArrayList();
        Iterator it = iterator();
        int i2 = 0;
        while (it.hasNext()) {
            zzekc com_google_android_gms_internal_zzekc = (zzekc) it.next();
            arrayList.add(com_google_android_gms_internal_zzekc);
            int i3 = (i2 == 0 && com_google_android_gms_internal_zzekc.zzbsv().zzbzv().isEmpty()) ? 0 : 1;
            i2 = i3;
        }
        if (i2 != 0) {
            Collections.sort(arrayList, zzeki.zzcap());
        }
        ArrayList arrayList2 = (ArrayList) arrayList;
        i2 = arrayList2.size();
        while (i < i2) {
            Object obj = arrayList2.get(i);
            i++;
            zzekc com_google_android_gms_internal_zzekc2 = (zzekc) obj;
            String zzbzt = com_google_android_gms_internal_zzekc2.zzbsv().zzbzt();
            if (!zzbzt.equals("")) {
                stringBuilder.append(":");
                stringBuilder.append(com_google_android_gms_internal_zzekc2.zzcao().asString());
                stringBuilder.append(":");
                stringBuilder.append(zzbzt);
            }
        }
        return stringBuilder.toString();
    }

    public final void zza(zzejl com_google_android_gms_internal_zzejl, boolean z) {
        if (!z || zzbzv().isEmpty()) {
            this.zzmyx.zza(com_google_android_gms_internal_zzejl);
        } else {
            this.zzmyx.zza(new zzejk(this, com_google_android_gms_internal_zzejl));
        }
    }

    public zzekd zzan(zzedk com_google_android_gms_internal_zzedk) {
        zzejg zzbwh = com_google_android_gms_internal_zzedk.zzbwh();
        return zzbwh == null ? this : zzm(zzbwh).zzan(com_google_android_gms_internal_zzedk.zzbwi());
    }

    public Iterator<zzekc> zzbti() {
        return new zzejm(this.zzmyx.zzbti());
    }

    public String zzbzt() {
        if (this.zznby == null) {
            String zza = zza(zzekf.V1);
            this.zznby = zza.isEmpty() ? "" : zzelt.zzqe(zza);
        }
        return this.zznby;
    }

    public boolean zzbzu() {
        return false;
    }

    public zzekd zzbzv() {
        return this.zznbx;
    }

    public final zzejg zzbzw() {
        return (zzejg) this.zzmyx.zzbtg();
    }

    public final zzejg zzbzx() {
        return (zzejg) this.zzmyx.zzbth();
    }

    public zzekd zze(zzejg com_google_android_gms_internal_zzejg, zzekd com_google_android_gms_internal_zzekd) {
        if (com_google_android_gms_internal_zzejg.zzbzr()) {
            return zzf(com_google_android_gms_internal_zzekd);
        }
        zzeag com_google_android_gms_internal_zzeag = this.zzmyx;
        if (com_google_android_gms_internal_zzeag.containsKey(com_google_android_gms_internal_zzejg)) {
            com_google_android_gms_internal_zzeag = com_google_android_gms_internal_zzeag.zzbf(com_google_android_gms_internal_zzejg);
        }
        if (!com_google_android_gms_internal_zzekd.isEmpty()) {
            com_google_android_gms_internal_zzeag = com_google_android_gms_internal_zzeag.zzg(com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzekd);
        }
        return com_google_android_gms_internal_zzeag.isEmpty() ? zzeju.zzcaf() : new zzeji(com_google_android_gms_internal_zzeag, this.zznbx);
    }

    public zzekd zzf(zzekd com_google_android_gms_internal_zzekd) {
        return this.zzmyx.isEmpty() ? zzeju.zzcaf() : new zzeji(this.zzmyx, com_google_android_gms_internal_zzekd);
    }

    public int zzg(zzekd com_google_android_gms_internal_zzekd) {
        return isEmpty() ? com_google_android_gms_internal_zzekd.isEmpty() ? 0 : -1 : com_google_android_gms_internal_zzekd.zzbzu() ? 1 : com_google_android_gms_internal_zzekd.isEmpty() ? 1 : com_google_android_gms_internal_zzekd == zzekd.zzndb ? -1 : 0;
    }

    public boolean zzk(zzejg com_google_android_gms_internal_zzejg) {
        return !zzm(com_google_android_gms_internal_zzejg).isEmpty();
    }

    public zzejg zzl(zzejg com_google_android_gms_internal_zzejg) {
        return (zzejg) this.zzmyx.zzbh(com_google_android_gms_internal_zzejg);
    }

    public zzekd zzl(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        zzejg zzbwh = com_google_android_gms_internal_zzedk.zzbwh();
        return zzbwh == null ? com_google_android_gms_internal_zzekd : zzbwh.zzbzr() ? zzf(com_google_android_gms_internal_zzekd) : zze(zzbwh, zzm(zzbwh).zzl(com_google_android_gms_internal_zzedk.zzbwi(), com_google_android_gms_internal_zzekd));
    }

    public zzekd zzm(zzejg com_google_android_gms_internal_zzejg) {
        return (!com_google_android_gms_internal_zzejg.zzbzr() || this.zznbx.isEmpty()) ? this.zzmyx.containsKey(com_google_android_gms_internal_zzejg) ? (zzekd) this.zzmyx.get(com_google_android_gms_internal_zzejg) : zzeju.zzcaf() : this.zznbx;
    }
}
