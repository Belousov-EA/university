package com.google.android.gms.internal;

import com.google.common.net.HttpHeaders;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.TreeMap;

public final class zzao {
    static List<zzl> zza(Map<String, String> map) {
        List<zzl> arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            arrayList.add(new zzl((String) entry.getKey(), (String) entry.getValue()));
        }
        return arrayList;
    }

    static Map<String, String> zza(List<zzl> list) {
        Map<String, String> treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (zzl com_google_android_gms_internal_zzl : list) {
            treeMap.put(com_google_android_gms_internal_zzl.getName(), com_google_android_gms_internal_zzl.getValue());
        }
        return treeMap;
    }

    public static zzc zzb(zzp com_google_android_gms_internal_zzp) {
        Object obj;
        long j;
        Object obj2;
        long currentTimeMillis = System.currentTimeMillis();
        Map map = com_google_android_gms_internal_zzp.zzac;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        String str = (String) map.get(HttpHeaders.DATE);
        if (str != null) {
            j2 = zzf(str);
        }
        str = (String) map.get(HttpHeaders.CACHE_CONTROL);
        if (str != null) {
            String[] split = str.split(",");
            obj = null;
            j = 0;
            j4 = 0;
            for (String trim : split) {
                String trim2 = trim2.trim();
                if (trim2.equals("no-cache") || trim2.equals("no-store")) {
                    return null;
                }
                if (trim2.startsWith("max-age=")) {
                    try {
                        j4 = Long.parseLong(trim2.substring(8));
                    } catch (Exception e) {
                    }
                } else if (trim2.startsWith("stale-while-revalidate=")) {
                    try {
                        j = Long.parseLong(trim2.substring(23));
                    } catch (Exception e2) {
                    }
                } else if (trim2.equals("must-revalidate") || trim2.equals("proxy-revalidate")) {
                    obj = 1;
                }
            }
            j3 = j4;
            j4 = j;
            obj2 = 1;
        } else {
            obj = null;
            obj2 = null;
        }
        str = (String) map.get(HttpHeaders.EXPIRES);
        long zzf = str != null ? zzf(str) : 0;
        str = (String) map.get(HttpHeaders.LAST_MODIFIED);
        long zzf2 = str != null ? zzf(str) : 0;
        str = (String) map.get(HttpHeaders.ETAG);
        if (obj2 != null) {
            j3 = currentTimeMillis + (1000 * j3);
            j = obj != null ? j3 : (1000 * j4) + j3;
        } else if (j2 <= 0 || zzf < j2) {
            j = 0;
            j3 = 0;
        } else {
            j = (zzf - j2) + currentTimeMillis;
            j3 = j;
        }
        zzc com_google_android_gms_internal_zzc = new zzc();
        com_google_android_gms_internal_zzc.data = com_google_android_gms_internal_zzp.data;
        com_google_android_gms_internal_zzc.zza = str;
        com_google_android_gms_internal_zzc.zze = j3;
        com_google_android_gms_internal_zzc.zzd = j;
        com_google_android_gms_internal_zzc.zzb = j2;
        com_google_android_gms_internal_zzc.zzc = zzf2;
        com_google_android_gms_internal_zzc.zzf = map;
        com_google_android_gms_internal_zzc.zzg = com_google_android_gms_internal_zzp.allHeaders;
        return com_google_android_gms_internal_zzc;
    }

    static String zzb(long j) {
        return zzo().format(new Date(j));
    }

    public static String zzb(Map<String, String> map) {
        String str = "ISO-8859-1";
        String str2 = (String) map.get(HttpHeaders.CONTENT_TYPE);
        if (str2 != null) {
            String[] split = str2.split(";");
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split("=");
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    private static long zzf(String str) {
        try {
            return zzo().parse(str).getTime();
        } catch (Throwable e) {
            zzae.zza(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    private static SimpleDateFormat zzo() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
