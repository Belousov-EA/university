package com.google.firebase.database.connection.idl;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzebn;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class zzab extends zzx {
    private /* synthetic */ zzebn zzmqu;

    zzab(zzebn com_google_android_gms_internal_zzebn) {
        this.zzmqu = com_google_android_gms_internal_zzebn;
    }

    public final void onDisconnect() {
        this.zzmqu.onDisconnect();
    }

    public final void zza(List<String> list, IObjectWrapper iObjectWrapper, boolean z, long j) {
        this.zzmqu.zza(list, zzn.zzx(iObjectWrapper), z, IPersistentConnectionImpl.zzbq(j));
    }

    public final void zza(List<String> list, List<zzak> list2, IObjectWrapper iObjectWrapper, long j) {
        List list3 = (List) zzn.zzx(iObjectWrapper);
        List arrayList = new ArrayList(list2.size());
        for (int i = 0; i < list2.size(); i++) {
            arrayList.add(zzak.zza((zzak) list2.get(i), list3.get(i)));
        }
        this.zzmqu.zza(list, arrayList, IPersistentConnectionImpl.zzbq(j));
    }

    public final void zzag(IObjectWrapper iObjectWrapper) {
        this.zzmqu.zzai((Map) zzn.zzx(iObjectWrapper));
    }

    public final void zzbuk() {
        this.zzmqu.zzbuk();
    }

    public final void zzcl(boolean z) {
        this.zzmqu.zzcl(z);
    }
}
