package com.google.firebase.database.connection.idl;

import android.content.Context;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzebi;
import com.google.android.gms.internal.zzebl;
import com.google.android.gms.internal.zzebm;
import com.google.android.gms.internal.zzebn;
import com.google.android.gms.internal.zzece;
import java.util.List;
import java.util.Map;

public final class zzf implements zzebm {
    private final zzt zzmqo;

    private zzf(zzt com_google_firebase_database_connection_idl_zzt) {
        this.zzmqo = com_google_firebase_database_connection_idl_zzt;
    }

    private static zzah zza(zzece com_google_android_gms_internal_zzece) {
        return new zzh(com_google_android_gms_internal_zzece);
    }

    public static zzf zza(Context context, zzc com_google_firebase_database_connection_idl_zzc, zzebi com_google_android_gms_internal_zzebi, zzebn com_google_android_gms_internal_zzebn) {
        return new zzf(IPersistentConnectionImpl.loadDynamic(context, com_google_firebase_database_connection_idl_zzc, com_google_android_gms_internal_zzebi.zzbuc(), com_google_android_gms_internal_zzebi.zzbud(), com_google_android_gms_internal_zzebn));
    }

    public final void initialize() {
        try {
            this.zzmqo.initialize();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void interrupt(String str) {
        try {
            this.zzmqo.interrupt(str);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final boolean isInterrupted(String str) {
        try {
            return this.zzmqo.isInterrupted(str);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void purgeOutstandingWrites() {
        try {
            this.zzmqo.purgeOutstandingWrites();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void refreshAuthToken() {
        try {
            this.zzmqo.refreshAuthToken();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void resume(String str) {
        try {
            this.zzmqo.resume(str);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void shutdown() {
        try {
            this.zzmqo.shutdown();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void zza(List<String> list, zzece com_google_android_gms_internal_zzece) {
        try {
            this.zzmqo.onDisconnectCancel(list, zza(com_google_android_gms_internal_zzece));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void zza(List<String> list, Object obj, zzece com_google_android_gms_internal_zzece) {
        try {
            this.zzmqo.put(list, zzn.zzz(obj), zza(com_google_android_gms_internal_zzece));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void zza(List<String> list, Object obj, String str, zzece com_google_android_gms_internal_zzece) {
        try {
            this.zzmqo.compareAndPut(list, zzn.zzz(obj), str, zza(com_google_android_gms_internal_zzece));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void zza(List<String> list, Map<String, Object> map) {
        try {
            this.zzmqo.unlisten(list, zzn.zzz(map));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void zza(List<String> list, Map<String, Object> map, zzebl com_google_android_gms_internal_zzebl, Long l, zzece com_google_android_gms_internal_zzece) {
        long longValue;
        zzq com_google_firebase_database_connection_idl_zzg = new zzg(this, com_google_android_gms_internal_zzebl);
        if (l != null) {
            try {
                longValue = l.longValue();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        longValue = -1;
        this.zzmqo.listen(list, zzn.zzz(map), com_google_firebase_database_connection_idl_zzg, longValue, zza(com_google_android_gms_internal_zzece));
    }

    public final void zza(List<String> list, Map<String, Object> map, zzece com_google_android_gms_internal_zzece) {
        try {
            this.zzmqo.merge(list, zzn.zzz(map), zza(com_google_android_gms_internal_zzece));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void zzb(List<String> list, Object obj, zzece com_google_android_gms_internal_zzece) {
        try {
            this.zzmqo.onDisconnectPut(list, zzn.zzz(obj), zza(com_google_android_gms_internal_zzece));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void zzb(List<String> list, Map<String, Object> map, zzece com_google_android_gms_internal_zzece) {
        try {
            this.zzmqo.onDisconnectMerge(list, zzn.zzz(map), zza(com_google_android_gms_internal_zzece));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void zzpn(String str) {
        try {
            this.zzmqo.refreshAuthToken2(str);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
