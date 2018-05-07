package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Pattern;

public final class zzelv {
    private static final Pattern zznfh = Pattern.compile("[\\[\\]\\.#$]");
    private static final Pattern zznfi = Pattern.compile("[\\[\\]\\.#\\$\\/\\u0000-\\u001F\\u007F]");

    public static void zzao(zzedk com_google_android_gms_internal_zzedk) throws DatabaseException {
        zzejg zzbwh = com_google_android_gms_internal_zzedk.zzbwh();
        Object obj = (zzbwh == null || !zzbwh.asString().startsWith(".")) ? 1 : null;
        if (obj == null) {
            String str = "Invalid write location: ";
            String valueOf = String.valueOf(com_google_android_gms_internal_zzedk.toString());
            throw new DatabaseException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    public static Map<zzedk, zzekd> zzb(zzedk com_google_android_gms_internal_zzedk, Map<String, Object> map) throws DatabaseException {
        Map treeMap = new TreeMap();
        for (Entry entry : map.entrySet()) {
            zzedk com_google_android_gms_internal_zzedk2 = new zzedk((String) entry.getKey());
            Object value = entry.getValue();
            zzege.zza(com_google_android_gms_internal_zzedk.zzh(com_google_android_gms_internal_zzedk2), value);
            String asString = !com_google_android_gms_internal_zzedk2.isEmpty() ? com_google_android_gms_internal_zzedk2.zzbwk().asString() : "";
            if (asString.equals(".sv") || asString.equals(".value")) {
                String valueOf = String.valueOf(com_google_android_gms_internal_zzedk2);
                throw new DatabaseException(new StringBuilder((String.valueOf(valueOf).length() + 40) + String.valueOf(asString).length()).append("Path '").append(valueOf).append("' contains disallowed child name: ").append(asString).toString());
            }
            Object zzc = asString.equals(".priority") ? zzekj.zzc(com_google_android_gms_internal_zzedk2, value) : zzekg.zza(value, zzeju.zzcaf());
            zzbv(value);
            treeMap.put(com_google_android_gms_internal_zzedk2, zzc);
        }
        zzedk com_google_android_gms_internal_zzedk3 = null;
        for (zzedk com_google_android_gms_internal_zzedk4 : treeMap.keySet()) {
            boolean z = com_google_android_gms_internal_zzedk3 == null || com_google_android_gms_internal_zzedk3.zzj(com_google_android_gms_internal_zzedk4) < 0;
            zzelt.zzcp(z);
            if (com_google_android_gms_internal_zzedk3 == null || !com_google_android_gms_internal_zzedk3.zzi(com_google_android_gms_internal_zzedk4)) {
                com_google_android_gms_internal_zzedk3 = com_google_android_gms_internal_zzedk4;
            } else {
                String valueOf2 = String.valueOf(com_google_android_gms_internal_zzedk3);
                asString = String.valueOf(com_google_android_gms_internal_zzedk4);
                throw new DatabaseException(new StringBuilder((String.valueOf(valueOf2).length() + 42) + String.valueOf(asString).length()).append("Path '").append(valueOf2).append("' is an ancestor of '").append(asString).append("' in an update.").toString());
            }
        }
        return treeMap;
    }

    public static void zzbv(Object obj) {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (!map.containsKey(".sv")) {
                for (Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    Object obj2 = (str == null || str.length() <= 0 || !(str.equals(".value") || str.equals(".priority") || (!str.startsWith(".") && !zznfi.matcher(str).find()))) ? null : 1;
                    if (obj2 == null) {
                        throw new DatabaseException(new StringBuilder(String.valueOf(str).length() + 68).append("Invalid key: ").append(str).append(". Keys must not contain '/', '.', '#', '$', '[', or ']'").toString());
                    }
                    zzbv(entry.getValue());
                }
            }
        } else if (obj instanceof List) {
            for (Object zzbv : (List) obj) {
                zzbv(zzbv);
            }
        } else if ((obj instanceof Double) || (obj instanceof Float)) {
            double doubleValue = ((Double) obj).doubleValue();
            if (Double.isInfinite(doubleValue) || Double.isNaN(doubleValue)) {
                throw new DatabaseException("Invalid value: Value cannot be NaN, Inf or -Inf.");
            }
        }
    }

    public static void zzqh(String str) throws DatabaseException {
        if ((!zznfh.matcher(str).find() ? 1 : null) == null) {
            throw new DatabaseException(new StringBuilder(String.valueOf(str).length() + 101).append("Invalid Firebase Database path: ").append(str).append(". Firebase Database paths must not contain '.', '#', '$', '[', or ']'").toString());
        }
    }

    public static void zzqi(String str) throws DatabaseException {
        if (str.startsWith(".info")) {
            zzqh(str.substring(5));
        } else if (str.startsWith("/.info")) {
            zzqh(str.substring(6));
        } else {
            zzqh(str);
        }
    }

    public static void zzqj(String str) throws DatabaseException {
        if (str != null) {
            Object obj = (str.equals(".info") || !zznfi.matcher(str).find()) ? 1 : null;
            if (obj == null) {
                throw new DatabaseException(new StringBuilder(String.valueOf(str).length() + 68).append("Invalid key: ").append(str).append(". Keys must not contain '/', '.', '#', '$', '[', or ']'").toString());
            }
        }
    }
}
