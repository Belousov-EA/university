package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.util.Log;

final class zzcun extends zzcui<String> {
    zzcun(zzcup com_google_android_gms_internal_zzcup, String str, String str2) {
        super(com_google_android_gms_internal_zzcup, str, str2);
    }

    private final String zzc(SharedPreferences sharedPreferences) {
        try {
            return sharedPreferences.getString(this.zzjxb, null);
        } catch (Throwable e) {
            Throwable th = e;
            String str = "PhenotypeFlag";
            String str2 = "Invalid string value in SharedPreferences for ";
            String valueOf = String.valueOf(this.zzjxb);
            Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2), th);
            return null;
        }
    }

    public final /* synthetic */ Object zzb(SharedPreferences sharedPreferences) {
        return zzc(sharedPreferences);
    }

    public final /* synthetic */ Object zzkt(String str) {
        return str;
    }
}
