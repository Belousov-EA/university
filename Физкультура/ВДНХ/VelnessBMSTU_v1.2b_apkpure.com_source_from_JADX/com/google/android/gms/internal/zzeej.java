package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseError;

final class zzeej implements zzece {
    private /* synthetic */ zzedn zzmti;
    private /* synthetic */ zzegd zzmuc;

    zzeej(zzedn com_google_android_gms_internal_zzedn, zzegd com_google_android_gms_internal_zzegd) {
        this.zzmti = com_google_android_gms_internal_zzedn;
        this.zzmuc = com_google_android_gms_internal_zzegd;
    }

    public final void zzbd(String str, String str2) {
        DatabaseError zzbf = zzedn.zzbe(str, str2);
        this.zzmti.zza("Persisted write", this.zzmuc.zzbsy(), zzbf);
        this.zzmti.zza(this.zzmuc.zzbwy(), this.zzmuc.zzbsy(), zzbf);
    }
}
