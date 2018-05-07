package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseError;

public final class zzehy implements zzeib {
    private final zzedk zzmks;
    private final zzedh zzmzl;
    private final DatabaseError zzmzm;

    public zzehy(zzedh com_google_android_gms_internal_zzedh, DatabaseError databaseError, zzedk com_google_android_gms_internal_zzedk) {
        this.zzmzl = com_google_android_gms_internal_zzedh;
        this.zzmks = com_google_android_gms_internal_zzedk;
        this.zzmzm = databaseError;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzmks);
        return new StringBuilder(String.valueOf(valueOf).length() + 7).append(valueOf).append(":CANCEL").toString();
    }

    public final void zzbyc() {
        this.zzmzl.zza(this.zzmzm);
    }
}
