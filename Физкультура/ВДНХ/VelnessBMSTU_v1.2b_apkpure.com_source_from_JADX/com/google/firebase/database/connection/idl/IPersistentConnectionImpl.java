package com.google.firebase.database.connection.idl;

import android.content.Context;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.firebase_database.ModuleDescriptor;
import com.google.android.gms.internal.zzebg;
import com.google.android.gms.internal.zzebi;
import com.google.android.gms.internal.zzebk;
import com.google.android.gms.internal.zzebm;
import com.google.android.gms.internal.zzebn;
import com.google.android.gms.internal.zzebo;
import com.google.android.gms.internal.zzece;
import com.google.android.gms.internal.zzeiz;
import com.google.android.gms.internal.zzeje;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

@DynamiteApi
public class IPersistentConnectionImpl extends zzu {
    private zzebm zzmqr;

    public static zzt loadDynamic(Context context, zzc com_google_firebase_database_connection_idl_zzc, zzebg com_google_android_gms_internal_zzebg, ScheduledExecutorService scheduledExecutorService, zzebn com_google_android_gms_internal_zzebn) {
        try {
            zzt asInterface = zzu.asInterface(DynamiteModule.zza(context, DynamiteModule.zzgxa, ModuleDescriptor.MODULE_ID).zzhb("com.google.firebase.database.connection.idl.IPersistentConnectionImpl"));
            asInterface.setup(com_google_firebase_database_connection_idl_zzc, new zzad(com_google_android_gms_internal_zzebg), zzn.zzz(scheduledExecutorService), new zzab(com_google_android_gms_internal_zzebn));
            return asInterface;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable e2) {
            throw new RuntimeException(e2);
        }
    }

    private static long zza(Long l) {
        if (l == null) {
            return -1;
        }
        if (l.longValue() != -1) {
            return l.longValue();
        }
        throw new IllegalArgumentException("Tag parameter clashed with NO_TAG value");
    }

    private static zzece zza(zzah com_google_firebase_database_connection_idl_zzah) {
        return new zzaa(com_google_firebase_database_connection_idl_zzah);
    }

    private static Long zzbq(long j) {
        return j == -1 ? null : Long.valueOf(j);
    }

    public void compareAndPut(List<String> list, IObjectWrapper iObjectWrapper, String str, zzah com_google_firebase_database_connection_idl_zzah) {
        this.zzmqr.zza(list, zzn.zzx(iObjectWrapper), str, zza(com_google_firebase_database_connection_idl_zzah));
    }

    public void initialize() {
        this.zzmqr.initialize();
    }

    public void interrupt(String str) {
        this.zzmqr.interrupt(str);
    }

    public boolean isInterrupted(String str) {
        return this.zzmqr.isInterrupted(str);
    }

    public void listen(List<String> list, IObjectWrapper iObjectWrapper, zzq com_google_firebase_database_connection_idl_zzq, long j, zzah com_google_firebase_database_connection_idl_zzah) {
        Long zzbq = zzbq(j);
        List<String> list2 = list;
        this.zzmqr.zza(list2, (Map) zzn.zzx(iObjectWrapper), new zzz(this, com_google_firebase_database_connection_idl_zzq), zzbq, zza(com_google_firebase_database_connection_idl_zzah));
    }

    public void merge(List<String> list, IObjectWrapper iObjectWrapper, zzah com_google_firebase_database_connection_idl_zzah) {
        this.zzmqr.zza((List) list, (Map) zzn.zzx(iObjectWrapper), zza(com_google_firebase_database_connection_idl_zzah));
    }

    public void onDisconnectCancel(List<String> list, zzah com_google_firebase_database_connection_idl_zzah) {
        this.zzmqr.zza((List) list, zza(com_google_firebase_database_connection_idl_zzah));
    }

    public void onDisconnectMerge(List<String> list, IObjectWrapper iObjectWrapper, zzah com_google_firebase_database_connection_idl_zzah) {
        this.zzmqr.zzb((List) list, (Map) zzn.zzx(iObjectWrapper), zza(com_google_firebase_database_connection_idl_zzah));
    }

    public void onDisconnectPut(List<String> list, IObjectWrapper iObjectWrapper, zzah com_google_firebase_database_connection_idl_zzah) {
        this.zzmqr.zzb((List) list, zzn.zzx(iObjectWrapper), zza(com_google_firebase_database_connection_idl_zzah));
    }

    public void purgeOutstandingWrites() {
        this.zzmqr.purgeOutstandingWrites();
    }

    public void put(List<String> list, IObjectWrapper iObjectWrapper, zzah com_google_firebase_database_connection_idl_zzah) {
        this.zzmqr.zza((List) list, zzn.zzx(iObjectWrapper), zza(com_google_firebase_database_connection_idl_zzah));
    }

    public void refreshAuthToken() {
        this.zzmqr.refreshAuthToken();
    }

    public void refreshAuthToken2(String str) {
        this.zzmqr.zzpn(str);
    }

    public void resume(String str) {
        this.zzmqr.resume(str);
    }

    public void setup(zzc com_google_firebase_database_connection_idl_zzc, zzk com_google_firebase_database_connection_idl_zzk, IObjectWrapper iObjectWrapper, zzw com_google_firebase_database_connection_idl_zzw) {
        zzeje com_google_android_gms_internal_zzeje;
        zzebk zza = zzi.zza(com_google_firebase_database_connection_idl_zzc.zzmqj);
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) zzn.zzx(iObjectWrapper);
        zzebn com_google_firebase_database_connection_idl_zzac = new zzac(com_google_firebase_database_connection_idl_zzw);
        switch (com_google_firebase_database_connection_idl_zzc.zzmqk) {
            case 0:
                com_google_android_gms_internal_zzeje = zzeje.NONE;
                break;
            case 1:
                com_google_android_gms_internal_zzeje = zzeje.DEBUG;
                break;
            case 2:
                com_google_android_gms_internal_zzeje = zzeje.INFO;
                break;
            case 3:
                com_google_android_gms_internal_zzeje = zzeje.WARN;
                break;
            case 4:
                com_google_android_gms_internal_zzeje = zzeje.ERROR;
                break;
            default:
                com_google_android_gms_internal_zzeje = zzeje.NONE;
                break;
        }
        this.zzmqr = new zzebo(new zzebi(new zzeiz(com_google_android_gms_internal_zzeje, com_google_firebase_database_connection_idl_zzc.zzmql), new zzaf(com_google_firebase_database_connection_idl_zzk), scheduledExecutorService, com_google_firebase_database_connection_idl_zzc.zzmnr, com_google_firebase_database_connection_idl_zzc.zzmqm, com_google_firebase_database_connection_idl_zzc.zzmnt, com_google_firebase_database_connection_idl_zzc.zzmnu), zza, com_google_firebase_database_connection_idl_zzac);
    }

    public void shutdown() {
        this.zzmqr.shutdown();
    }

    public void unlisten(List<String> list, IObjectWrapper iObjectWrapper) {
        this.zzmqr.zza((List) list, (Map) zzn.zzx(iObjectWrapper));
    }
}
