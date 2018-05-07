package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference.CompletionListener;

final class zzeel implements zzece {
    private /* synthetic */ zzedk zzmrv;
    private /* synthetic */ zzedn zzmti;
    private /* synthetic */ CompletionListener zzmtl;
    private /* synthetic */ long zzmuf;

    zzeel(zzedn com_google_android_gms_internal_zzedn, zzedk com_google_android_gms_internal_zzedk, long j, CompletionListener completionListener) {
        this.zzmti = com_google_android_gms_internal_zzedn;
        this.zzmrv = com_google_android_gms_internal_zzedk;
        this.zzmuf = j;
        this.zzmtl = completionListener;
    }

    public final void zzbd(String str, String str2) {
        DatabaseError zzbf = zzedn.zzbe(str, str2);
        this.zzmti.zza("setValue", this.zzmrv, zzbf);
        this.zzmti.zza(this.zzmuf, this.zzmrv, zzbf);
        this.zzmti.zza(this.zzmtl, zzbf, this.zzmrv);
    }
}
