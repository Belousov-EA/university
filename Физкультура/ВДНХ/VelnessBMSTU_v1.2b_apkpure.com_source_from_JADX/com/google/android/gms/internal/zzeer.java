package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.Map;

public final class zzeer {
    private static final zzeer zzmuz = new zzeer();
    private final Map<zzedc, Map<String, zzedn>> zzmva = new HashMap();

    public static zzedn zza(zzedc com_google_android_gms_internal_zzedc, zzeeq com_google_android_gms_internal_zzeeq, FirebaseDatabase firebaseDatabase) throws DatabaseException {
        return zzmuz.zzb(com_google_android_gms_internal_zzedc, com_google_android_gms_internal_zzeeq, firebaseDatabase);
    }

    private final zzedn zzb(zzedc com_google_android_gms_internal_zzedc, zzeeq com_google_android_gms_internal_zzeeq, FirebaseDatabase firebaseDatabase) throws DatabaseException {
        zzedn com_google_android_gms_internal_zzedn;
        com_google_android_gms_internal_zzedc.zzbvl();
        String str = com_google_android_gms_internal_zzeeq.host;
        String str2 = com_google_android_gms_internal_zzeeq.zzjrg;
        str2 = new StringBuilder((String.valueOf(str).length() + 9) + String.valueOf(str2).length()).append("https://").append(str).append("/").append(str2).toString();
        synchronized (this.zzmva) {
            if (!this.zzmva.containsKey(com_google_android_gms_internal_zzedc)) {
                this.zzmva.put(com_google_android_gms_internal_zzedc, new HashMap());
            }
            Map map = (Map) this.zzmva.get(com_google_android_gms_internal_zzedc);
            if (map.containsKey(str2)) {
                throw new IllegalStateException("createLocalRepo() called for existing repo.");
            }
            com_google_android_gms_internal_zzedn = new zzedn(com_google_android_gms_internal_zzeeq, com_google_android_gms_internal_zzedc, firebaseDatabase);
            map.put(str2, com_google_android_gms_internal_zzedn);
        }
        return com_google_android_gms_internal_zzedn;
    }

    public static void zzd(zzedc com_google_android_gms_internal_zzedc) {
        zzeer com_google_android_gms_internal_zzeer = zzmuz;
        zzeew com_google_android_gms_internal_zzeew = com_google_android_gms_internal_zzedc.zzmse;
        if (com_google_android_gms_internal_zzeew != null) {
            com_google_android_gms_internal_zzeew.zzo(new zzeeu(com_google_android_gms_internal_zzeer, com_google_android_gms_internal_zzedc));
        }
    }

    public static void zze(zzedc com_google_android_gms_internal_zzedc) {
        zzeer com_google_android_gms_internal_zzeer = zzmuz;
        zzeew com_google_android_gms_internal_zzeew = com_google_android_gms_internal_zzedc.zzmse;
        if (com_google_android_gms_internal_zzeew != null) {
            com_google_android_gms_internal_zzeew.zzo(new zzeev(com_google_android_gms_internal_zzeer, com_google_android_gms_internal_zzedc));
        }
    }

    public static void zzk(zzedn com_google_android_gms_internal_zzedn) {
        com_google_android_gms_internal_zzedn.zzo(new zzees(com_google_android_gms_internal_zzedn));
    }

    public static void zzl(zzedn com_google_android_gms_internal_zzedn) {
        com_google_android_gms_internal_zzedn.zzo(new zzeet(com_google_android_gms_internal_zzedn));
    }
}
