package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference.CompletionListener;

final class zzedq implements zzece {
    private /* synthetic */ zzedk zzmrv;
    private /* synthetic */ zzedn zzmti;
    private /* synthetic */ CompletionListener zzmtl;

    zzedq(zzedn com_google_android_gms_internal_zzedn, zzedk com_google_android_gms_internal_zzedk, CompletionListener completionListener) {
        this.zzmti = com_google_android_gms_internal_zzedn;
        this.zzmrv = com_google_android_gms_internal_zzedk;
        this.zzmtl = completionListener;
    }

    public final void zzbd(String str, String str2) {
        DatabaseError zzbf = zzedn.zzbe(str, str2);
        if (zzbf == null) {
            this.zzmti.zzmst.zzq(this.zzmrv);
        }
        this.zzmti.zza(this.zzmtl, zzbf, this.zzmrv);
    }
}
