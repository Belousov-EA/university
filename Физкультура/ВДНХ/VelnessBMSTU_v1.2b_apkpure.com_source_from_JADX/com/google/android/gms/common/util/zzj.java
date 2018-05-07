package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
import com.google.firebase.analytics.FirebaseAnalytics.Param;

public final class zzj {
    private static IntentFilter zzgel = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static long zzgem;
    private static float zzgen = Float.NaN;

    @TargetApi(20)
    public static int zzcw(Context context) {
        int i = 1;
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, zzgel);
        int i2 = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        int i3 = (zzq.zzamm() ? powerManager.isInteractive() : powerManager.isScreenOn() ? 1 : 0) << 1;
        if (i2 == 0) {
            i = 0;
        }
        return i3 | i;
    }

    public static synchronized float zzcx(Context context) {
        float f;
        synchronized (zzj.class) {
            if (SystemClock.elapsedRealtime() - zzgem >= 60000 || Float.isNaN(zzgen)) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver(null, zzgel);
                if (registerReceiver != null) {
                    zzgen = ((float) registerReceiver.getIntExtra(Param.LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                zzgem = SystemClock.elapsedRealtime();
                f = zzgen;
            } else {
                f = zzgen;
            }
        }
        return f;
    }
}
