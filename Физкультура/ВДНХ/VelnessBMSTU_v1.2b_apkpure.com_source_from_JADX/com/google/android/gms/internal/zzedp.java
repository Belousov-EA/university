package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference.CompletionListener;
import java.util.Map;
import java.util.Map.Entry;

final class zzedp implements zzece {
    private /* synthetic */ zzedk zzmrv;
    private /* synthetic */ zzedn zzmti;
    private /* synthetic */ Map zzmtj;
    private /* synthetic */ CompletionListener zzmtk;

    zzedp(zzedn com_google_android_gms_internal_zzedn, zzedk com_google_android_gms_internal_zzedk, Map map, CompletionListener completionListener) {
        this.zzmti = com_google_android_gms_internal_zzedn;
        this.zzmrv = com_google_android_gms_internal_zzedk;
        this.zzmtj = map;
        this.zzmtk = completionListener;
    }

    public final void zzbd(String str, String str2) {
        DatabaseError zzbf = zzedn.zzbe(str, str2);
        this.zzmti.zza("onDisconnect().updateChildren", this.zzmrv, zzbf);
        if (zzbf == null) {
            for (Entry entry : this.zzmtj.entrySet()) {
                this.zzmti.zzmst.zzh(this.zzmrv.zzh((zzedk) entry.getKey()), (zzekd) entry.getValue());
            }
        }
        this.zzmti.zza(this.zzmtk, zzbf, this.zzmrv);
    }
}
