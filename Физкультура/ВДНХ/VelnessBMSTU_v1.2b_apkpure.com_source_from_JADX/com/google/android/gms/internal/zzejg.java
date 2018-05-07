package com.google.android.gms.internal;

public class zzejg implements Comparable<zzejg> {
    private static final zzejg zznbs = new zzejg("[MIN_KEY]");
    private static final zzejg zznbt = new zzejg("[MAX_KEY]");
    private static final zzejg zznbu = new zzejg(".priority");
    private static final zzejg zznbv = new zzejg(".info");
    private final String key;

    static class zza extends zzejg {
        private final int zzgcd;

        zza(String str, int i) {
            super(str);
            this.zzgcd = i;
        }

        protected final int intValue() {
            return this.zzgcd;
        }

        public final String toString() {
            String zzj = this.key;
            return new StringBuilder(String.valueOf(zzj).length() + 20).append("IntegerChildName(\"").append(zzj).append("\")").toString();
        }

        protected final boolean zzbzs() {
            return true;
        }
    }

    private zzejg(String str) {
        this.key = str;
    }

    public static zzejg zzbzn() {
        return zznbs;
    }

    public static zzejg zzbzo() {
        return zznbt;
    }

    public static zzejg zzbzp() {
        return zznbu;
    }

    public static zzejg zzbzq() {
        return zznbv;
    }

    public static zzejg zzpz(String str) {
        Integer zzqg = zzelt.zzqg(str);
        return zzqg != null ? new zza(str, zzqg.intValue()) : str.equals(".priority") ? zznbu : new zzejg(str);
    }

    public final String asString() {
        return this.key;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return zzi((zzejg) obj);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzejg)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.key.equals(((zzejg) obj).key);
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    protected int intValue() {
        return 0;
    }

    public String toString() {
        String str = this.key;
        return new StringBuilder(String.valueOf(str).length() + 12).append("ChildKey(\"").append(str).append("\")").toString();
    }

    public final boolean zzbzr() {
        return this == zznbu;
    }

    protected boolean zzbzs() {
        return false;
    }

    public final int zzi(zzejg com_google_android_gms_internal_zzejg) {
        if (this == com_google_android_gms_internal_zzejg) {
            return 0;
        }
        if (this == zznbs || com_google_android_gms_internal_zzejg == zznbt) {
            return -1;
        }
        if (com_google_android_gms_internal_zzejg == zznbs || this == zznbt) {
            return 1;
        }
        if (!zzbzs()) {
            return com_google_android_gms_internal_zzejg.zzbzs() ? 1 : this.key.compareTo(com_google_android_gms_internal_zzejg.key);
        } else {
            if (!com_google_android_gms_internal_zzejg.zzbzs()) {
                return -1;
            }
            int zzv = zzelt.zzv(intValue(), com_google_android_gms_internal_zzejg.intValue());
            return zzv == 0 ? zzelt.zzv(this.key.length(), com_google_android_gms_internal_zzejg.key.length()) : zzv;
        }
    }
}
