package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

public class zzdmf {
    private static Uri CONTENT_URI = Uri.parse("content://com.google.android.gsf.gservices");
    private static Uri zzlnb = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    private static Pattern zzlnc = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    private static Pattern zzlnd = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzlne = new AtomicBoolean();
    private static HashMap<String, String> zzlnf;
    private static HashMap<String, Boolean> zzlng = new HashMap();
    private static HashMap<String, Integer> zzlnh = new HashMap();
    private static HashMap<String, Long> zzlni = new HashMap();
    private static HashMap<String, Float> zzlnj = new HashMap();
    private static Object zzlnk;
    private static boolean zzlnl;
    private static String[] zzlnm = new String[0];

    public static long getLong(ContentResolver contentResolver, String str, long j) {
        Long valueOf;
        Object zzb = zzb(contentResolver);
        Long l = (Long) zza(zzlni, str, Long.valueOf(0));
        if (l != null) {
            return l.longValue();
        }
        Object obj;
        long j2;
        String zza = zza(contentResolver, str, null);
        if (zza == null) {
            obj = l;
            j2 = 0;
        } else {
            try {
                long parseLong = Long.parseLong(zza);
                valueOf = Long.valueOf(parseLong);
                j2 = parseLong;
            } catch (NumberFormatException e) {
                valueOf = l;
                j2 = 0;
            }
        }
        zza(zzb, zzlni, str, obj);
        return j2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> T zza(java.util.HashMap<java.lang.String, T> r2, java.lang.String r3, T r4) {
        /*
        r1 = com.google.android.gms.internal.zzdmf.class;
        monitor-enter(r1);
        r0 = r2.containsKey(r3);	 Catch:{ all -> 0x0016 }
        if (r0 == 0) goto L_0x0013;
    L_0x0009:
        r0 = r2.get(r3);	 Catch:{ all -> 0x0016 }
        if (r0 == 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
    L_0x0010:
        return r0;
    L_0x0011:
        r0 = r4;
        goto L_0x000f;
    L_0x0013:
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
        r0 = 0;
        goto L_0x0010;
    L_0x0016:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0016 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdmf.zza(java.util.HashMap, java.lang.String, java.lang.Object):T");
    }

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        String str3 = null;
        synchronized (zzdmf.class) {
            zza(contentResolver);
            Object obj = zzlnk;
            String str4;
            if (zzlnf.containsKey(str)) {
                str4 = (String) zzlnf.get(str);
                if (str4 != null) {
                    str3 = str4;
                }
            } else {
                String[] strArr = zzlnm;
                int length = strArr.length;
                int i = 0;
                while (i < length) {
                    if (str.startsWith(strArr[i])) {
                        if (!zzlnl || zzlnf.isEmpty()) {
                            zzlnf.putAll(zza(contentResolver, zzlnm));
                            zzlnl = true;
                            if (zzlnf.containsKey(str)) {
                                str4 = (String) zzlnf.get(str);
                                if (str4 != null) {
                                    str3 = str4;
                                }
                            }
                        }
                    } else {
                        i++;
                    }
                }
                Cursor query = contentResolver.query(CONTENT_URI, null, null, new String[]{str}, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            str4 = query.getString(1);
                            if (str4 != null && str4.equals(null)) {
                                str4 = null;
                            }
                            zza(obj, str, str4);
                            if (str4 != null) {
                                str3 = str4;
                            }
                            if (query != null) {
                                query.close();
                            }
                        }
                    } catch (Throwable th) {
                        if (query != null) {
                            query.close();
                        }
                    }
                }
                zza(obj, str, null);
                if (query != null) {
                    query.close();
                }
            }
        }
        return str3;
    }

    private static Map<String, String> zza(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(zzlnb, null, null, strArr, null);
        Map<String, String> treeMap = new TreeMap();
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    treeMap.put(query.getString(0), query.getString(1));
                } finally {
                    query.close();
                }
            }
        }
        return treeMap;
    }

    private static void zza(ContentResolver contentResolver) {
        if (zzlnf == null) {
            zzlne.set(false);
            zzlnf = new HashMap();
            zzlnk = new Object();
            zzlnl = false;
            contentResolver.registerContentObserver(CONTENT_URI, true, new zzdmg(null));
        } else if (zzlne.getAndSet(false)) {
            zzlnf.clear();
            zzlng.clear();
            zzlnh.clear();
            zzlni.clear();
            zzlnj.clear();
            zzlnk = new Object();
            zzlnl = false;
        }
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzdmf.class) {
            if (obj == zzlnk) {
                zzlnf.put(str, str2);
            }
        }
    }

    private static <T> void zza(Object obj, HashMap<String, T> hashMap, String str, T t) {
        synchronized (zzdmf.class) {
            if (obj == zzlnk) {
                hashMap.put(str, t);
                zzlnf.remove(str);
            }
        }
    }

    public static boolean zza(ContentResolver contentResolver, String str, boolean z) {
        Object zzb = zzb(contentResolver);
        Object obj = (Boolean) zza(zzlng, str, Boolean.valueOf(z));
        if (obj != null) {
            return obj.booleanValue();
        }
        Object zza = zza(contentResolver, str, null);
        if (!(zza == null || zza.equals(""))) {
            if (zzlnc.matcher(zza).matches()) {
                obj = Boolean.valueOf(true);
                z = true;
            } else if (zzlnd.matcher(zza).matches()) {
                obj = Boolean.valueOf(false);
                z = false;
            } else {
                Log.w("Gservices", "attempt to read gservices key " + str + " (value \"" + zza + "\") as boolean");
            }
        }
        zza(zzb, zzlng, str, obj);
        return z;
    }

    private static Object zzb(ContentResolver contentResolver) {
        Object obj;
        synchronized (zzdmf.class) {
            zza(contentResolver);
            obj = zzlnk;
        }
        return obj;
    }
}
