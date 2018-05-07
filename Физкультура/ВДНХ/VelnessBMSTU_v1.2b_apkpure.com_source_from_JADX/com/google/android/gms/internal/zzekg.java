package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzekg {
    public static zzekd zza(Object obj, zzekd com_google_android_gms_internal_zzekd) throws DatabaseException {
        try {
            Map map;
            Object obj2;
            List list;
            Map hashMap;
            int i;
            String str;
            zzekd zza;
            Map hashMap2;
            if (obj instanceof Map) {
                map = (Map) obj;
                if (map.containsKey(".priority")) {
                    com_google_android_gms_internal_zzekd = zzekj.zzc(null, map.get(".priority"));
                }
                if (map.containsKey(".value")) {
                    obj2 = map.get(".value");
                    if (obj2 == null) {
                        return zzeju.zzcaf();
                    }
                    if (obj2 instanceof String) {
                        return new zzekl((String) obj2, com_google_android_gms_internal_zzekd);
                    }
                    if (obj2 instanceof Long) {
                        return new zzekb((Long) obj2, com_google_android_gms_internal_zzekd);
                    }
                    if (obj2 instanceof Integer) {
                        return new zzekb(Long.valueOf((long) ((Integer) obj2).intValue()), com_google_android_gms_internal_zzekd);
                    }
                    if (obj2 instanceof Double) {
                        return new zzejt((Double) obj2, com_google_android_gms_internal_zzekd);
                    }
                    if (obj2 instanceof Boolean) {
                        return new zzejf((Boolean) obj2, com_google_android_gms_internal_zzekd);
                    }
                    if (!(obj2 instanceof Map) || (obj2 instanceof List)) {
                        if (obj2 instanceof Map) {
                            list = (List) obj2;
                            hashMap = new HashMap(list.size());
                            for (i = 0; i < list.size(); i++) {
                                str = i;
                                zza = zza(list.get(i), zzeju.zzcaf());
                                if (!zza.isEmpty()) {
                                    hashMap.put(zzejg.zzpz(str), zza);
                                }
                            }
                            map = hashMap;
                        } else {
                            map = (Map) obj2;
                            if (map.containsKey(".sv")) {
                                return new zzejs(map, com_google_android_gms_internal_zzekd);
                            }
                            hashMap2 = new HashMap(map.size());
                            for (String str2 : map.keySet()) {
                                if (!str2.startsWith(".")) {
                                    zza = zza(map.get(str2), zzeju.zzcaf());
                                    if (!zza.isEmpty()) {
                                        hashMap2.put(zzejg.zzpz(str2), zza);
                                    }
                                }
                            }
                            map = hashMap2;
                        }
                        return map.isEmpty() ? zzeju.zzcaf() : new zzeji(zzeah.zza(map, zzeji.zznbw), com_google_android_gms_internal_zzekd);
                    } else {
                        String str3 = "Failed to parse node with class ";
                        String valueOf = String.valueOf(obj2.getClass().toString());
                        throw new DatabaseException(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
                    }
                }
            }
            obj2 = obj;
            if (obj2 == null) {
                return zzeju.zzcaf();
            }
            if (obj2 instanceof String) {
                return new zzekl((String) obj2, com_google_android_gms_internal_zzekd);
            }
            if (obj2 instanceof Long) {
                return new zzekb((Long) obj2, com_google_android_gms_internal_zzekd);
            }
            if (obj2 instanceof Integer) {
                return new zzekb(Long.valueOf((long) ((Integer) obj2).intValue()), com_google_android_gms_internal_zzekd);
            }
            if (obj2 instanceof Double) {
                return new zzejt((Double) obj2, com_google_android_gms_internal_zzekd);
            }
            if (obj2 instanceof Boolean) {
                return new zzejf((Boolean) obj2, com_google_android_gms_internal_zzekd);
            }
            if (obj2 instanceof Map) {
            }
            if (obj2 instanceof Map) {
                list = (List) obj2;
                hashMap = new HashMap(list.size());
                for (i = 0; i < list.size(); i++) {
                    str = i;
                    zza = zza(list.get(i), zzeju.zzcaf());
                    if (!zza.isEmpty()) {
                        hashMap.put(zzejg.zzpz(str), zza);
                    }
                }
                map = hashMap;
            } else {
                map = (Map) obj2;
                if (map.containsKey(".sv")) {
                    return new zzejs(map, com_google_android_gms_internal_zzekd);
                }
                hashMap2 = new HashMap(map.size());
                for (String str22 : map.keySet()) {
                    if (!str22.startsWith(".")) {
                        zza = zza(map.get(str22), zzeju.zzcaf());
                        if (!zza.isEmpty()) {
                            hashMap2.put(zzejg.zzpz(str22), zza);
                        }
                    }
                }
                map = hashMap2;
            }
            if (map.isEmpty()) {
            }
        } catch (Throwable e) {
            throw new DatabaseException("Failed to parse node", e);
        }
    }
}
