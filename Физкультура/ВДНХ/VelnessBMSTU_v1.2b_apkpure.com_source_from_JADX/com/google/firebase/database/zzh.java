package com.google.firebase.database;

import com.google.android.gms.internal.zzedk;
import com.google.android.gms.internal.zzedn;
import com.google.android.gms.internal.zzejw;
import com.google.android.gms.internal.zzekd;

public final class zzh {
    public static DataSnapshot zza(DatabaseReference databaseReference, zzejw com_google_android_gms_internal_zzejw) {
        return new DataSnapshot(databaseReference, com_google_android_gms_internal_zzejw);
    }

    public static DatabaseReference zza(zzedn com_google_android_gms_internal_zzedn, zzedk com_google_android_gms_internal_zzedk) {
        return new DatabaseReference(com_google_android_gms_internal_zzedn, com_google_android_gms_internal_zzedk);
    }

    public static MutableData zza(zzekd com_google_android_gms_internal_zzekd) {
        return new MutableData(com_google_android_gms_internal_zzekd);
    }
}
