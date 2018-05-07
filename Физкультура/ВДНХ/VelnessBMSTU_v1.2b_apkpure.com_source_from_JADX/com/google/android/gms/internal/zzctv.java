package com.google.android.gms.internal;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics.Param;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zzctv {
    private static String[] zzhwc = new String[]{"key", Param.VALUE};
    private static final ConcurrentHashMap<Uri, zzctv> zzjwe = new ConcurrentHashMap();
    private final Uri uri;
    private final ContentResolver zzjwf;
    private final ContentObserver zzjwg;
    private final Object zzjwh = new Object();
    private volatile Map<String, String> zzjwi;

    private zzctv(ContentResolver contentResolver, Uri uri) {
        this.zzjwf = contentResolver;
        this.uri = uri;
        this.zzjwg = new zzctw(this, null);
    }

    public static zzctv zza(ContentResolver contentResolver, Uri uri) {
        zzctv com_google_android_gms_internal_zzctv = (zzctv) zzjwe.get(uri);
        if (com_google_android_gms_internal_zzctv != null) {
            return com_google_android_gms_internal_zzctv;
        }
        zzctv com_google_android_gms_internal_zzctv2 = new zzctv(contentResolver, uri);
        com_google_android_gms_internal_zzctv = (zzctv) zzjwe.putIfAbsent(uri, com_google_android_gms_internal_zzctv2);
        if (com_google_android_gms_internal_zzctv != null) {
            return com_google_android_gms_internal_zzctv;
        }
        com_google_android_gms_internal_zzctv2.zzjwf.registerContentObserver(com_google_android_gms_internal_zzctv2.uri, false, com_google_android_gms_internal_zzctv2.zzjwg);
        return com_google_android_gms_internal_zzctv2;
    }

    private final Map<String, String> zzbco() {
        Map<String, String> hashMap = new HashMap();
        Cursor query = this.zzjwf.query(this.uri, zzhwc, null, null, null);
        if (query != null) {
            while (query.moveToNext()) {
                try {
                    hashMap.put(query.getString(0), query.getString(1));
                } finally {
                    query.close();
                }
            }
        }
        return hashMap;
    }

    public final Map<String, String> zzbcm() {
        Map<String, String> zzbco = zzcui.zzg("gms:phenotype:phenotype_flag:debug_disable_caching", false) ? zzbco() : this.zzjwi;
        if (zzbco == null) {
            synchronized (this.zzjwh) {
                zzbco = this.zzjwi;
                if (zzbco == null) {
                    zzbco = zzbco();
                    this.zzjwi = zzbco;
                }
            }
        }
        return zzbco;
    }

    public final void zzbcn() {
        synchronized (this.zzjwh) {
            this.zzjwi = null;
        }
    }
}
