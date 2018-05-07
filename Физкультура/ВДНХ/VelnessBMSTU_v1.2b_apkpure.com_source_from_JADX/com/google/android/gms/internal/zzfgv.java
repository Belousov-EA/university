package com.google.android.gms.internal;

import java.io.IOException;

public final class zzfgv<K, V> {
    private final V value;
    private final K zzmmo;
    private final zzfgx<K, V> zzpin;

    private zzfgv(zzfiy com_google_android_gms_internal_zzfiy, K k, zzfiy com_google_android_gms_internal_zzfiy2, V v) {
        this.zzpin = new zzfgx(com_google_android_gms_internal_zzfiy, k, com_google_android_gms_internal_zzfiy2, v);
        this.zzmmo = k;
        this.value = v;
    }

    static <K, V> int zza(zzfgx<K, V> com_google_android_gms_internal_zzfgx_K__V, K k, V v) {
        return zzffq.zza(com_google_android_gms_internal_zzfgx_K__V.zzpio, 1, (Object) k) + zzffq.zza(com_google_android_gms_internal_zzfgx_K__V.zzpiq, 2, (Object) v);
    }

    public static <K, V> zzfgv<K, V> zza(zzfiy com_google_android_gms_internal_zzfiy, K k, zzfiy com_google_android_gms_internal_zzfiy2, V v) {
        return new zzfgv(com_google_android_gms_internal_zzfiy, k, com_google_android_gms_internal_zzfiy2, v);
    }

    private static <T> T zza(zzffb com_google_android_gms_internal_zzffb, zzffm com_google_android_gms_internal_zzffm, zzfiy com_google_android_gms_internal_zzfiy, T t) throws IOException {
        switch (zzfgw.zzpgo[com_google_android_gms_internal_zzfiy.ordinal()]) {
            case 1:
                zzfhf zzcxp = ((zzfhe) t).zzcxp();
                com_google_android_gms_internal_zzffb.zza(zzcxp, com_google_android_gms_internal_zzffm);
                return zzcxp.zzcxu();
            case 2:
                return Integer.valueOf(com_google_android_gms_internal_zzffb.zzcwd());
            case 3:
                throw new RuntimeException("Groups are not allowed in maps.");
            default:
                return zzffq.zza(com_google_android_gms_internal_zzffb, com_google_android_gms_internal_zzfiy, true);
        }
    }

    static <K, V> void zza(zzffg com_google_android_gms_internal_zzffg, zzfgx<K, V> com_google_android_gms_internal_zzfgx_K__V, K k, V v) throws IOException {
        zzffq.zza(com_google_android_gms_internal_zzffg, com_google_android_gms_internal_zzfgx_K__V.zzpio, 1, k);
        zzffq.zza(com_google_android_gms_internal_zzffg, com_google_android_gms_internal_zzfgx_K__V.zzpiq, 2, v);
    }

    public final void zza(zzffg com_google_android_gms_internal_zzffg, int i, K k, V v) throws IOException {
        com_google_android_gms_internal_zzffg.zzz(i, 2);
        com_google_android_gms_internal_zzffg.zzld(zza(this.zzpin, (Object) k, (Object) v));
        zza(com_google_android_gms_internal_zzffg, this.zzpin, (Object) k, (Object) v);
    }

    public final void zza(zzfgy<K, V> com_google_android_gms_internal_zzfgy_K__V, zzffb com_google_android_gms_internal_zzffb, zzffm com_google_android_gms_internal_zzffm) throws IOException {
        int zzks = com_google_android_gms_internal_zzffb.zzks(com_google_android_gms_internal_zzffb.zzcwi());
        Object obj = this.zzpin.zzpip;
        Object obj2 = this.zzpin.zzjxd;
        while (true) {
            int zzcvt = com_google_android_gms_internal_zzffb.zzcvt();
            if (zzcvt == 0) {
                break;
            } else if (zzcvt == (this.zzpin.zzpio.zzdae() | 8)) {
                obj = zza(com_google_android_gms_internal_zzffb, com_google_android_gms_internal_zzffm, this.zzpin.zzpio, obj);
            } else if (zzcvt == (this.zzpin.zzpiq.zzdae() | 16)) {
                obj2 = zza(com_google_android_gms_internal_zzffb, com_google_android_gms_internal_zzffm, this.zzpin.zzpiq, obj2);
            } else if (!com_google_android_gms_internal_zzffb.zzkq(zzcvt)) {
                break;
            }
        }
        com_google_android_gms_internal_zzffb.zzkp(0);
        com_google_android_gms_internal_zzffb.zzkt(zzks);
        com_google_android_gms_internal_zzfgy_K__V.put(obj, obj2);
    }

    public final int zzb(int i, K k, V v) {
        return zzffg.zzlg(i) + zzffg.zzln(zza(this.zzpin, (Object) k, (Object) v));
    }
}
