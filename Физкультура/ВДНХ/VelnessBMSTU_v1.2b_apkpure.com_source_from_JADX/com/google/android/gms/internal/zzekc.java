package com.google.android.gms.internal;

public final class zzekc {
    private static final zzekc zzncz = new zzekc(zzejg.zzbzn(), zzeju.zzcaf());
    private static final zzekc zznda = new zzekc(zzejg.zzbzo(), zzekd.zzndb);
    private final zzejg zzmzd;
    private final zzekd zzncq;

    public zzekc(zzejg com_google_android_gms_internal_zzejg, zzekd com_google_android_gms_internal_zzekd) {
        this.zzmzd = com_google_android_gms_internal_zzejg;
        this.zzncq = com_google_android_gms_internal_zzekd;
    }

    public static zzekc zzcam() {
        return zzncz;
    }

    public static zzekc zzcan() {
        return zznda;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzekc com_google_android_gms_internal_zzekc = (zzekc) obj;
        return !this.zzmzd.equals(com_google_android_gms_internal_zzekc.zzmzd) ? false : this.zzncq.equals(com_google_android_gms_internal_zzekc.zzncq);
    }

    public final int hashCode() {
        return (this.zzmzd.hashCode() * 31) + this.zzncq.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzmzd);
        String valueOf2 = String.valueOf(this.zzncq);
        return new StringBuilder((String.valueOf(valueOf).length() + 23) + String.valueOf(valueOf2).length()).append("NamedNode{name=").append(valueOf).append(", node=").append(valueOf2).append("}").toString();
    }

    public final zzekd zzbsv() {
        return this.zzncq;
    }

    public final zzejg zzcao() {
        return this.zzmzd;
    }
}
