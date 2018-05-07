package com.google.android.gms.common.util;

import android.content.Context;
import android.os.DropBoxManager;
import android.util.Log;
import com.google.android.gms.common.internal.zzbq;

public final class zzf {
    private static final String[] zzgea = new String[]{"android.", "com.android.", "dalvik.", "java.", "javax."};
    private static DropBoxManager zzgeb = null;
    private static boolean zzgec = false;
    private static int zzged = -1;
    private static int zzgee = 0;

    public static boolean zza(Context context, Throwable th) {
        return zza(context, th, 536870912);
    }

    private static boolean zza(Context context, Throwable th, int i) {
        try {
            zzbq.checkNotNull(context);
            zzbq.checkNotNull(th);
        } catch (Throwable e) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e);
        }
        return false;
    }
}
