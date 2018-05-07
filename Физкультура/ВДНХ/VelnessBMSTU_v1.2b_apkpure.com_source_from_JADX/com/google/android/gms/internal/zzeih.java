package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public final class zzeih {
    public static final zzeih zznae = new zzeih();
    private zzejv zznaa = zzeki.zzcap();
    private Integer zznaf;
    private int zznag;
    private zzekd zznah = null;
    private zzejg zznai = null;
    private zzekd zznaj = null;
    private zzejg zznak = null;
    private String zznal = null;

    public static zzeih zzam(Map<String, Object> map) {
        String str;
        zzeih com_google_android_gms_internal_zzeih = new zzeih();
        com_google_android_gms_internal_zzeih.zznaf = (Integer) map.get("l");
        if (map.containsKey("sp")) {
            com_google_android_gms_internal_zzeih.zznah = zze(zzekg.zza(map.get("sp"), zzeju.zzcaf()));
            str = (String) map.get("sn");
            if (str != null) {
                com_google_android_gms_internal_zzeih.zznai = zzejg.zzpz(str);
            }
        }
        if (map.containsKey("ep")) {
            com_google_android_gms_internal_zzeih.zznaj = zze(zzekg.zza(map.get("ep"), zzeju.zzcaf()));
            str = (String) map.get("en");
            if (str != null) {
                com_google_android_gms_internal_zzeih.zznak = zzejg.zzpz(str);
            }
        }
        str = (String) map.get("vf");
        if (str != null) {
            com_google_android_gms_internal_zzeih.zznag = str.equals("l") ? zzeij.zznan : zzeij.zznao;
        }
        str = (String) map.get("i");
        if (str != null) {
            zzejv zzcaq;
            if (str.equals(".value")) {
                zzcaq = zzekn.zzcaq();
            } else if (str.equals(".key")) {
                zzcaq = zzejx.zzcal();
            } else if (str.equals(".priority")) {
                throw new IllegalStateException("queryDefinition shouldn't ever be .priority since it's the default");
            } else {
                zzcaq = new zzekh(new zzedk(str));
            }
            com_google_android_gms_internal_zzeih.zznaa = zzcaq;
        }
        return com_google_android_gms_internal_zzeih;
    }

    private final zzeih zzbys() {
        zzeih com_google_android_gms_internal_zzeih = new zzeih();
        com_google_android_gms_internal_zzeih.zznaf = this.zznaf;
        com_google_android_gms_internal_zzeih.zznah = this.zznah;
        com_google_android_gms_internal_zzeih.zznai = this.zznai;
        com_google_android_gms_internal_zzeih.zznaj = this.zznaj;
        com_google_android_gms_internal_zzeih.zznak = this.zznak;
        com_google_android_gms_internal_zzeih.zznag = this.zznag;
        com_google_android_gms_internal_zzeih.zznaa = this.zznaa;
        return com_google_android_gms_internal_zzeih;
    }

    private static zzekd zze(zzekd com_google_android_gms_internal_zzekd) {
        if ((com_google_android_gms_internal_zzekd instanceof zzekl) || (com_google_android_gms_internal_zzekd instanceof zzejf) || (com_google_android_gms_internal_zzekd instanceof zzejt) || (com_google_android_gms_internal_zzekd instanceof zzeju)) {
            return com_google_android_gms_internal_zzekd;
        }
        if (com_google_android_gms_internal_zzekd instanceof zzekb) {
            return new zzejt(Double.valueOf(((Long) com_google_android_gms_internal_zzekd.getValue()).doubleValue()), zzeju.zzcaf());
        }
        String valueOf = String.valueOf(com_google_android_gms_internal_zzekd.getValue());
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 43).append("Unexpected value passed to normalizeValue: ").append(valueOf).toString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzeih com_google_android_gms_internal_zzeih = (zzeih) obj;
        return (this.zznaf == null ? com_google_android_gms_internal_zzeih.zznaf != null : !this.zznaf.equals(com_google_android_gms_internal_zzeih.zznaf)) ? false : (this.zznaa == null ? com_google_android_gms_internal_zzeih.zznaa != null : !this.zznaa.equals(com_google_android_gms_internal_zzeih.zznaa)) ? false : (this.zznak == null ? com_google_android_gms_internal_zzeih.zznak != null : !this.zznak.equals(com_google_android_gms_internal_zzeih.zznak)) ? false : (this.zznaj == null ? com_google_android_gms_internal_zzeih.zznaj != null : !this.zznaj.equals(com_google_android_gms_internal_zzeih.zznaj)) ? false : (this.zznai == null ? com_google_android_gms_internal_zzeih.zznai != null : !this.zznai.equals(com_google_android_gms_internal_zzeih.zznai)) ? false : (this.zznah == null ? com_google_android_gms_internal_zzeih.zznah != null : !this.zznah.equals(com_google_android_gms_internal_zzeih.zznah)) ? false : zzbyt() == com_google_android_gms_internal_zzeih.zzbyt();
    }

    public final int getLimit() {
        if (zzbyp()) {
            return this.zznaf.intValue();
        }
        throw new IllegalArgumentException("Cannot get limit if limit has not been set");
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.zznak != null ? this.zznak.hashCode() : 0) + (((this.zznaj != null ? this.zznaj.hashCode() : 0) + (((this.zznai != null ? this.zznai.hashCode() : 0) + (((this.zznah != null ? this.zznah.hashCode() : 0) + (((zzbyt() ? 1231 : 1237) + ((this.zznaf != null ? this.zznaf.intValue() : 0) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.zznaa != null) {
            i = this.zznaa.hashCode();
        }
        return hashCode + i;
    }

    public final boolean isDefault() {
        return zzbyv() && this.zznaa.equals(zzeki.zzcap());
    }

    public final String toString() {
        return zzbyu().toString();
    }

    public final zzeih zza(zzejv com_google_android_gms_internal_zzejv) {
        zzeih zzbys = zzbys();
        zzbys.zznaa = com_google_android_gms_internal_zzejv;
        return zzbys;
    }

    public final zzeih zza(zzekd com_google_android_gms_internal_zzekd, zzejg com_google_android_gms_internal_zzejg) {
        zzelt.zzcp(!(com_google_android_gms_internal_zzekd instanceof zzekb));
        zzeih zzbys = zzbys();
        zzbys.zznah = com_google_android_gms_internal_zzekd;
        zzbys.zznai = com_google_android_gms_internal_zzejg;
        return zzbys;
    }

    public final zzeih zzb(zzekd com_google_android_gms_internal_zzekd, zzejg com_google_android_gms_internal_zzejg) {
        zzelt.zzcp(!(com_google_android_gms_internal_zzekd instanceof zzekb));
        zzeih zzbys = zzbys();
        zzbys.zznaj = com_google_android_gms_internal_zzekd;
        zzbys.zznak = com_google_android_gms_internal_zzejg;
        return zzbys;
    }

    public final boolean zzbyj() {
        return this.zznah != null;
    }

    public final zzekd zzbyk() {
        if (zzbyj()) {
            return this.zznah;
        }
        throw new IllegalArgumentException("Cannot get index start value if start has not been set");
    }

    public final zzejg zzbyl() {
        if (zzbyj()) {
            return this.zznai != null ? this.zznai : zzejg.zzbzn();
        } else {
            throw new IllegalArgumentException("Cannot get index start name if start has not been set");
        }
    }

    public final boolean zzbym() {
        return this.zznaj != null;
    }

    public final zzekd zzbyn() {
        if (zzbym()) {
            return this.zznaj;
        }
        throw new IllegalArgumentException("Cannot get index end value if start has not been set");
    }

    public final zzejg zzbyo() {
        if (zzbym()) {
            return this.zznak != null ? this.zznak : zzejg.zzbzo();
        } else {
            throw new IllegalArgumentException("Cannot get index end name if start has not been set");
        }
    }

    public final boolean zzbyp() {
        return this.zznaf != null;
    }

    public final boolean zzbyq() {
        return zzbyp() && this.zznag != 0;
    }

    public final zzejv zzbyr() {
        return this.zznaa;
    }

    public final boolean zzbyt() {
        return this.zznag != 0 ? this.zznag == zzeij.zznan : zzbyj();
    }

    public final Map<String, Object> zzbyu() {
        Map<String, Object> hashMap = new HashMap();
        if (zzbyj()) {
            hashMap.put("sp", this.zznah.getValue());
            if (this.zznai != null) {
                hashMap.put("sn", this.zznai.asString());
            }
        }
        if (zzbym()) {
            hashMap.put("ep", this.zznaj.getValue());
            if (this.zznak != null) {
                hashMap.put("en", this.zznak.asString());
            }
        }
        if (this.zznaf != null) {
            hashMap.put("l", this.zznaf);
            int i = this.zznag;
            if (i == 0) {
                i = zzbyj() ? zzeij.zznan : zzeij.zznao;
            }
            switch (zzeii.zznam[i - 1]) {
                case 1:
                    hashMap.put("vf", "l");
                    break;
                case 2:
                    hashMap.put("vf", "r");
                    break;
            }
        }
        if (!this.zznaa.equals(zzeki.zzcap())) {
            hashMap.put("i", this.zznaa.zzcah());
        }
        return hashMap;
    }

    public final boolean zzbyv() {
        return (zzbyj() || zzbym() || zzbyp()) ? false : true;
    }

    public final String zzbyw() {
        if (this.zznal == null) {
            try {
                this.zznal = zzelh.zzbt(zzbyu());
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        return this.zznal;
    }

    public final zzeiw zzbyx() {
        return zzbyv() ? new zzeiu(this.zznaa) : zzbyp() ? new zzeiv(this) : new zzeiy(this);
    }

    public final zzeih zzgr(int i) {
        zzeih zzbys = zzbys();
        zzbys.zznaf = Integer.valueOf(i);
        zzbys.zznag = zzeij.zznan;
        return zzbys;
    }

    public final zzeih zzgs(int i) {
        zzeih zzbys = zzbys();
        zzbys.zznaf = Integer.valueOf(i);
        zzbys.zznag = zzeij.zznao;
        return zzbys;
    }
}
