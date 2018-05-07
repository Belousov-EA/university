package com.google.android.gms.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class zzejy<T extends zzejy> implements zzekd {
    protected final zzekd zznbx;
    private String zznby;

    zzejy(zzekd com_google_android_gms_internal_zzekd) {
        this.zznbx = com_google_android_gms_internal_zzekd;
    }

    private static int zza(zzekb com_google_android_gms_internal_zzekb, zzejt com_google_android_gms_internal_zzejt) {
        return Double.valueOf((double) ((Long) com_google_android_gms_internal_zzekb.getValue()).longValue()).compareTo((Double) com_google_android_gms_internal_zzejt.getValue());
    }

    public /* synthetic */ int compareTo(Object obj) {
        zzekd com_google_android_gms_internal_zzekd = (zzekd) obj;
        if (com_google_android_gms_internal_zzekd.isEmpty()) {
            return 1;
        }
        if (com_google_android_gms_internal_zzekd instanceof zzeji) {
            return -1;
        }
        if ((this instanceof zzekb) && (com_google_android_gms_internal_zzekd instanceof zzejt)) {
            return zza((zzekb) this, (zzejt) com_google_android_gms_internal_zzekd);
        }
        if ((this instanceof zzejt) && (com_google_android_gms_internal_zzekd instanceof zzekb)) {
            return zza((zzekb) com_google_android_gms_internal_zzekd, (zzejt) this) * -1;
        }
        zzejy com_google_android_gms_internal_zzejy = (zzejy) com_google_android_gms_internal_zzekd;
        zzeka zzbzm = zzbzm();
        Enum zzbzm2 = com_google_android_gms_internal_zzejy.zzbzm();
        return zzbzm.equals(zzbzm2) ? zza(com_google_android_gms_internal_zzejy) : zzbzm.compareTo(zzbzm2);
    }

    public final int getChildCount() {
        return 0;
    }

    public final Object getValue(boolean z) {
        if (!z || this.zznbx.isEmpty()) {
            return getValue();
        }
        Map hashMap = new HashMap();
        hashMap.put(".value", getValue());
        hashMap.put(".priority", this.zznbx.getValue());
        return hashMap;
    }

    public final boolean isEmpty() {
        return false;
    }

    public Iterator<zzekc> iterator() {
        return Collections.emptyList().iterator();
    }

    public String toString() {
        String obj = getValue(true).toString();
        return obj.length() <= 100 ? obj : String.valueOf(obj.substring(0, 100)).concat("...");
    }

    protected abstract int zza(T t);

    public final zzekd zzan(zzedk com_google_android_gms_internal_zzedk) {
        return com_google_android_gms_internal_zzedk.isEmpty() ? this : com_google_android_gms_internal_zzedk.zzbwh().zzbzr() ? this.zznbx : zzeju.zzcaf();
    }

    protected final String zzb(zzekf com_google_android_gms_internal_zzekf) {
        switch (zzejz.zznct[com_google_android_gms_internal_zzekf.ordinal()]) {
            case 1:
            case 2:
                if (this.zznbx.isEmpty()) {
                    return "";
                }
                String zza = this.zznbx.zza(com_google_android_gms_internal_zzekf);
                return new StringBuilder(String.valueOf(zza).length() + 10).append("priority:").append(zza).append(":").toString();
            default:
                String valueOf = String.valueOf(com_google_android_gms_internal_zzekf);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Unknown hash version: ").append(valueOf).toString());
        }
    }

    public final Iterator<zzekc> zzbti() {
        return Collections.emptyList().iterator();
    }

    protected abstract zzeka zzbzm();

    public final String zzbzt() {
        if (this.zznby == null) {
            this.zznby = zzelt.zzqe(zza(zzekf.V1));
        }
        return this.zznby;
    }

    public final boolean zzbzu() {
        return true;
    }

    public final zzekd zzbzv() {
        return this.zznbx;
    }

    public final zzekd zze(zzejg com_google_android_gms_internal_zzejg, zzekd com_google_android_gms_internal_zzekd) {
        return com_google_android_gms_internal_zzejg.zzbzr() ? zzf(com_google_android_gms_internal_zzekd) : !com_google_android_gms_internal_zzekd.isEmpty() ? zzeju.zzcaf().zze(com_google_android_gms_internal_zzejg, com_google_android_gms_internal_zzekd).zzf(this.zznbx) : this;
    }

    public final boolean zzk(zzejg com_google_android_gms_internal_zzejg) {
        return false;
    }

    public final zzejg zzl(zzejg com_google_android_gms_internal_zzejg) {
        return null;
    }

    public final zzekd zzl(zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd) {
        zzejg zzbwh = com_google_android_gms_internal_zzedk.zzbwh();
        return zzbwh == null ? com_google_android_gms_internal_zzekd : (!com_google_android_gms_internal_zzekd.isEmpty() || zzbwh.zzbzr()) ? zze(zzbwh, zzeju.zzcaf().zzl(com_google_android_gms_internal_zzedk.zzbwi(), com_google_android_gms_internal_zzekd)) : this;
    }

    public final zzekd zzm(zzejg com_google_android_gms_internal_zzejg) {
        return com_google_android_gms_internal_zzejg.zzbzr() ? this.zznbx : zzeju.zzcaf();
    }
}
