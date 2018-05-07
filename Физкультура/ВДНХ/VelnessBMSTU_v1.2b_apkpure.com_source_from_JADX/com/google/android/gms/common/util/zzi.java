package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;

public final class zzi {
    private static Boolean zzgeg;
    private static Boolean zzgeh;
    private static Boolean zzgei;
    private static Boolean zzgej;
    private static Boolean zzgek;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zza(android.content.res.Resources r5) {
        /*
        r4 = 3;
        r1 = 1;
        r2 = 0;
        if (r5 != 0) goto L_0x0006;
    L_0x0005:
        return r2;
    L_0x0006:
        r0 = zzgeg;
        if (r0 != 0) goto L_0x0041;
    L_0x000a:
        r0 = r5.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        if (r0 <= r4) goto L_0x0048;
    L_0x0014:
        r0 = r1;
    L_0x0015:
        if (r0 != 0) goto L_0x003a;
    L_0x0017:
        r0 = zzgeh;
        if (r0 != 0) goto L_0x0032;
    L_0x001b:
        r0 = r5.getConfiguration();
        r3 = r0.screenLayout;
        r3 = r3 & 15;
        if (r3 > r4) goto L_0x004a;
    L_0x0025:
        r0 = r0.smallestScreenWidthDp;
        r3 = 600; // 0x258 float:8.41E-43 double:2.964E-321;
        if (r0 < r3) goto L_0x004a;
    L_0x002b:
        r0 = r1;
    L_0x002c:
        r0 = java.lang.Boolean.valueOf(r0);
        zzgeh = r0;
    L_0x0032:
        r0 = zzgeh;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x003b;
    L_0x003a:
        r2 = r1;
    L_0x003b:
        r0 = java.lang.Boolean.valueOf(r2);
        zzgeg = r0;
    L_0x0041:
        r0 = zzgeg;
        r2 = r0.booleanValue();
        goto L_0x0005;
    L_0x0048:
        r0 = r2;
        goto L_0x0015;
    L_0x004a:
        r0 = r2;
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.zzi.zza(android.content.res.Resources):boolean");
    }

    @TargetApi(20)
    public static boolean zzcs(Context context) {
        if (zzgei == null) {
            boolean z = zzq.zzamm() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
            zzgei = Boolean.valueOf(z);
        }
        return zzgei.booleanValue();
    }

    @TargetApi(24)
    public static boolean zzct(Context context) {
        return (!zzq.isAtLeastN() || zzcu(context)) && zzcs(context);
    }

    @TargetApi(21)
    public static boolean zzcu(Context context) {
        if (zzgej == null) {
            boolean z = zzq.zzamn() && context.getPackageManager().hasSystemFeature("cn.google");
            zzgej = Boolean.valueOf(z);
        }
        return zzgej.booleanValue();
    }

    public static boolean zzcv(Context context) {
        if (zzgek == null) {
            boolean z = context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded");
            zzgek = Boolean.valueOf(z);
        }
        return zzgek.booleanValue();
    }
}
