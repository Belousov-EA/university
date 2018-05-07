package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference.CompletionListener;

final class zzeen implements zzece {
    private /* synthetic */ zzedk zzmrv;
    private /* synthetic */ zzedn zzmti;
    private /* synthetic */ CompletionListener zzmtl;
    private /* synthetic */ zzekd zzmug;

    zzeen(zzedn com_google_android_gms_internal_zzedn, zzedk com_google_android_gms_internal_zzedk, zzekd com_google_android_gms_internal_zzekd, CompletionListener completionListener) {
        this.zzmti = com_google_android_gms_internal_zzedn;
        this.zzmrv = com_google_android_gms_internal_zzedk;
        this.zzmug = com_google_android_gms_internal_zzekd;
        this.zzmtl = completionListener;
    }

    public final void zzbd(String str, String str2) {
        DatabaseError zzbf = zzedn.zzbe(str, str2);
        this.zzmti.zza("onDisconnect().setValue", this.zzmrv, zzbf);
        if (zzbf == null) {
            this.zzmti.zzmst.zzh(this.zzmrv, this.zzmug);
        }
        this.zzmti.zza(this.zzmtl, zzbf, this.zzmrv);
    }
}
