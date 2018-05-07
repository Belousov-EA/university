package com.google.firebase.database.connection.idl;

import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzebn;
import com.google.android.gms.internal.zzecd;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class zzac implements zzebn {
    private /* synthetic */ zzw zzmqv;

    zzac(zzw com_google_firebase_database_connection_idl_zzw) {
        this.zzmqv = com_google_firebase_database_connection_idl_zzw;
    }

    public final void onDisconnect() {
        try {
            this.zzmqv.onDisconnect();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void zza(List<String> list, Object obj, boolean z, Long l) {
        try {
            this.zzmqv.zza((List) list, zzn.zzz(obj), z, IPersistentConnectionImpl.zza(l));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void zza(List<String> list, List<zzecd> list2, Long l) {
        List arrayList = new ArrayList(list2.size());
        List arrayList2 = new ArrayList(list2.size());
        for (zzecd com_google_android_gms_internal_zzecd : list2) {
            arrayList.add(new zzak(com_google_android_gms_internal_zzecd.zzbva(), com_google_android_gms_internal_zzecd.zzbvb()));
            arrayList2.add(com_google_android_gms_internal_zzecd.zzbvc());
        }
        try {
            this.zzmqv.zza((List) list, arrayList, zzn.zzz(arrayList2), IPersistentConnectionImpl.zza(l));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void zzai(Map<String, Object> map) {
        try {
            this.zzmqv.zzag(zzn.zzz(map));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void zzbuk() {
        try {
            this.zzmqv.zzbuk();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final void zzcl(boolean z) {
        try {
            this.zzmqv.zzcl(z);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
