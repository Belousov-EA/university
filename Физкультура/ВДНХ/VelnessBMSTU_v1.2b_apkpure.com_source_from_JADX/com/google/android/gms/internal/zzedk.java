package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class zzedk implements Comparable<zzedk>, Iterable<zzejg> {
    private static final zzedk zzmsp = new zzedk("");
    private final int end;
    private final int start;
    private final zzejg[] zzmso;

    public zzedk(String str) {
        String[] split = str.split("/");
        int i = 0;
        for (String length : split) {
            if (length.length() > 0) {
                i++;
            }
        }
        this.zzmso = new zzejg[i];
        int length2 = split.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length2) {
            String str2 = split[i2];
            if (str2.length() > 0) {
                i = i3 + 1;
                this.zzmso[i3] = zzejg.zzpz(str2);
            } else {
                i = i3;
            }
            i2++;
            i3 = i;
        }
        this.start = 0;
        this.end = this.zzmso.length;
    }

    public zzedk(List<String> list) {
        this.zzmso = new zzejg[list.size()];
        int i = 0;
        for (String zzpz : list) {
            int i2 = i + 1;
            this.zzmso[i] = zzejg.zzpz(zzpz);
            i = i2;
        }
        this.start = 0;
        this.end = list.size();
    }

    public zzedk(zzejg... com_google_android_gms_internal_zzejgArr) {
        this.zzmso = (zzejg[]) Arrays.copyOf(com_google_android_gms_internal_zzejgArr, com_google_android_gms_internal_zzejgArr.length);
        this.start = 0;
        this.end = com_google_android_gms_internal_zzejgArr.length;
    }

    private zzedk(zzejg[] com_google_android_gms_internal_zzejgArr, int i, int i2) {
        this.zzmso = com_google_android_gms_internal_zzejgArr;
        this.start = i;
        this.end = i2;
    }

    public static zzedk zza(zzedk com_google_android_gms_internal_zzedk, zzedk com_google_android_gms_internal_zzedk2) {
        while (true) {
            zzejg zzbwh = com_google_android_gms_internal_zzedk.zzbwh();
            zzejg zzbwh2 = com_google_android_gms_internal_zzedk2.zzbwh();
            if (zzbwh == null) {
                return com_google_android_gms_internal_zzedk2;
            }
            if (zzbwh.equals(zzbwh2)) {
                com_google_android_gms_internal_zzedk = com_google_android_gms_internal_zzedk.zzbwi();
                com_google_android_gms_internal_zzedk2 = com_google_android_gms_internal_zzedk2.zzbwi();
            } else {
                String valueOf = String.valueOf(com_google_android_gms_internal_zzedk2);
                String valueOf2 = String.valueOf(com_google_android_gms_internal_zzedk);
                throw new DatabaseException(new StringBuilder((String.valueOf(valueOf).length() + 37) + String.valueOf(valueOf2).length()).append("INTERNAL ERROR: ").append(valueOf).append(" is not contained in ").append(valueOf2).toString());
            }
        }
    }

    public static zzedk zzbwe() {
        return zzmsp;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return zzj((zzedk) obj);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzedk)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzedk com_google_android_gms_internal_zzedk = (zzedk) obj;
        if (size() != com_google_android_gms_internal_zzedk.size()) {
            return false;
        }
        int i = this.start;
        int i2 = com_google_android_gms_internal_zzedk.start;
        while (i < this.end && i2 < com_google_android_gms_internal_zzedk.end) {
            if (!this.zzmso[i].equals(com_google_android_gms_internal_zzedk.zzmso[i2])) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 37) + this.zzmso[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.start >= this.end;
    }

    public final Iterator<zzejg> iterator() {
        return new zzedl(this);
    }

    public final int size() {
        return this.end - this.start;
    }

    public final String toString() {
        if (isEmpty()) {
            return "/";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = this.start; i < this.end; i++) {
            stringBuilder.append("/");
            stringBuilder.append(this.zzmso[i].asString());
        }
        return stringBuilder.toString();
    }

    public final zzedk zza(zzejg com_google_android_gms_internal_zzejg) {
        int size = size();
        Object obj = new zzejg[(size + 1)];
        System.arraycopy(this.zzmso, this.start, obj, 0, size);
        obj[size] = com_google_android_gms_internal_zzejg;
        return new zzedk(obj, 0, size + 1);
    }

    public final String zzbwf() {
        if (isEmpty()) {
            return "/";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = this.start; i < this.end; i++) {
            if (i > this.start) {
                stringBuilder.append("/");
            }
            stringBuilder.append(this.zzmso[i].asString());
        }
        return stringBuilder.toString();
    }

    public final List<String> zzbwg() {
        List<String> arrayList = new ArrayList(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.add(((zzejg) it.next()).asString());
        }
        return arrayList;
    }

    public final zzejg zzbwh() {
        return isEmpty() ? null : this.zzmso[this.start];
    }

    public final zzedk zzbwi() {
        int i = this.start;
        if (!isEmpty()) {
            i++;
        }
        return new zzedk(this.zzmso, i, this.end);
    }

    public final zzedk zzbwj() {
        return isEmpty() ? null : new zzedk(this.zzmso, this.start, this.end - 1);
    }

    public final zzejg zzbwk() {
        return !isEmpty() ? this.zzmso[this.end - 1] : null;
    }

    public final zzedk zzh(zzedk com_google_android_gms_internal_zzedk) {
        int size = size() + com_google_android_gms_internal_zzedk.size();
        Object obj = new zzejg[size];
        System.arraycopy(this.zzmso, this.start, obj, 0, size());
        System.arraycopy(com_google_android_gms_internal_zzedk.zzmso, com_google_android_gms_internal_zzedk.start, obj, size(), com_google_android_gms_internal_zzedk.size());
        return new zzedk(obj, 0, size);
    }

    public final boolean zzi(zzedk com_google_android_gms_internal_zzedk) {
        if (size() > com_google_android_gms_internal_zzedk.size()) {
            return false;
        }
        int i = this.start;
        int i2 = com_google_android_gms_internal_zzedk.start;
        while (i < this.end) {
            if (!this.zzmso[i].equals(com_google_android_gms_internal_zzedk.zzmso[i2])) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public final int zzj(zzedk com_google_android_gms_internal_zzedk) {
        int i = this.start;
        int i2 = com_google_android_gms_internal_zzedk.start;
        while (i < this.end && i2 < com_google_android_gms_internal_zzedk.end) {
            int zzi = this.zzmso[i].zzi(com_google_android_gms_internal_zzedk.zzmso[i2]);
            if (zzi != 0) {
                return zzi;
            }
            i++;
            i2++;
        }
        return (i == this.end && i2 == com_google_android_gms_internal_zzedk.end) ? 0 : i == this.end ? -1 : 1;
    }
}
