package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzu;
import com.google.android.gms.common.util.zzy;
import java.util.HashMap;
import java.util.Map;

public final class zzcxt {
    private static boolean DEBUG = false;
    private static String TAG = "WakeLock";
    private static String zzkcd = "*gcore*:";
    private final Context mContext;
    private final String zzgdn;
    private final String zzgdp;
    private final WakeLock zzkce;
    private WorkSource zzkcf;
    private final int zzkcg;
    private final String zzkch;
    private boolean zzkci;
    private final Map<String, Integer[]> zzkcj;
    private int zzkck;

    public zzcxt(Context context, int i, String str) {
        this(context, 1, str, null, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    private zzcxt(Context context, int i, String str, String str2, String str3) {
        this(context, 1, str, null, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    private zzcxt(Context context, int i, String str, String str2, String str3, String str4) {
        this.zzkci = true;
        this.zzkcj = new HashMap();
        zzbq.zzh(str, "Wake lock name can NOT be empty");
        this.zzkcg = i;
        this.zzkch = null;
        this.zzgdp = null;
        this.mContext = context.getApplicationContext();
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.zzgdn = str;
        } else {
            String valueOf = String.valueOf(zzkcd);
            String valueOf2 = String.valueOf(str);
            this.zzgdn = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        this.zzkce = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (zzy.zzcy(this.mContext)) {
            if (zzu.zzgs(str3)) {
                str3 = context.getPackageName();
            }
            this.zzkcf = zzy.zzaa(context, str3);
            WorkSource workSource = this.zzkcf;
            if (workSource != null && zzy.zzcy(this.mContext)) {
                if (this.zzkcf != null) {
                    this.zzkcf.add(workSource);
                } else {
                    this.zzkcf = workSource;
                }
                try {
                    this.zzkce.setWorkSource(this.zzkcf);
                } catch (IllegalArgumentException e) {
                    Log.wtf(TAG, e.toString());
                }
            }
        }
    }

    private final String zzkz(String str) {
        return this.zzkci ? !TextUtils.isEmpty(null) ? null : this.zzkch : this.zzkch;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void acquire(long r13) {
        /*
        r12 = this;
        r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = 0;
        r1 = 1;
        r2 = 0;
        r4 = r12.zzkz(r0);
        monitor-enter(r12);
        r0 = r12.zzkcj;	 Catch:{ all -> 0x008a }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x008a }
        if (r0 == 0) goto L_0x0016;
    L_0x0012:
        r0 = r12.zzkck;	 Catch:{ all -> 0x008a }
        if (r0 <= 0) goto L_0x0026;
    L_0x0016:
        r0 = r12.zzkce;	 Catch:{ all -> 0x008a }
        r0 = r0.isHeld();	 Catch:{ all -> 0x008a }
        if (r0 != 0) goto L_0x0026;
    L_0x001e:
        r0 = r12.zzkcj;	 Catch:{ all -> 0x008a }
        r0.clear();	 Catch:{ all -> 0x008a }
        r0 = 0;
        r12.zzkck = r0;	 Catch:{ all -> 0x008a }
    L_0x0026:
        r0 = r12.zzkci;	 Catch:{ all -> 0x008a }
        if (r0 == 0) goto L_0x0047;
    L_0x002a:
        r0 = r12.zzkcj;	 Catch:{ all -> 0x008a }
        r0 = r0.get(r4);	 Catch:{ all -> 0x008a }
        r0 = (java.lang.Integer[]) r0;	 Catch:{ all -> 0x008a }
        if (r0 != 0) goto L_0x0078;
    L_0x0034:
        r0 = r12.zzkcj;	 Catch:{ all -> 0x008a }
        r2 = 1;
        r2 = new java.lang.Integer[r2];	 Catch:{ all -> 0x008a }
        r3 = 0;
        r5 = 1;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x008a }
        r2[r3] = r5;	 Catch:{ all -> 0x008a }
        r0.put(r4, r2);	 Catch:{ all -> 0x008a }
        r0 = r1;
    L_0x0045:
        if (r0 != 0) goto L_0x004f;
    L_0x0047:
        r0 = r12.zzkci;	 Catch:{ all -> 0x008a }
        if (r0 != 0) goto L_0x0071;
    L_0x004b:
        r0 = r12.zzkck;	 Catch:{ all -> 0x008a }
        if (r0 != 0) goto L_0x0071;
    L_0x004f:
        com.google.android.gms.common.stats.zze.zzamf();	 Catch:{ all -> 0x008a }
        r0 = r12.mContext;	 Catch:{ all -> 0x008a }
        r1 = r12.zzkce;	 Catch:{ all -> 0x008a }
        r1 = com.google.android.gms.common.stats.zzc.zza(r1, r4);	 Catch:{ all -> 0x008a }
        r2 = 7;
        r3 = r12.zzgdn;	 Catch:{ all -> 0x008a }
        r5 = 0;
        r6 = r12.zzkcg;	 Catch:{ all -> 0x008a }
        r7 = r12.zzkcf;	 Catch:{ all -> 0x008a }
        r7 = com.google.android.gms.common.util.zzy.zzb(r7);	 Catch:{ all -> 0x008a }
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        com.google.android.gms.common.stats.zze.zza(r0, r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x008a }
        r0 = r12.zzkck;	 Catch:{ all -> 0x008a }
        r0 = r0 + 1;
        r12.zzkck = r0;	 Catch:{ all -> 0x008a }
    L_0x0071:
        monitor-exit(r12);	 Catch:{ all -> 0x008a }
        r0 = r12.zzkce;
        r0.acquire(r10);
        return;
    L_0x0078:
        r1 = 0;
        r3 = 0;
        r3 = r0[r3];	 Catch:{ all -> 0x008a }
        r3 = r3.intValue();	 Catch:{ all -> 0x008a }
        r3 = r3 + 1;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x008a }
        r0[r1] = r3;	 Catch:{ all -> 0x008a }
        r0 = r2;
        goto L_0x0045;
    L_0x008a:
        r0 = move-exception;
        monitor-exit(r12);	 Catch:{ all -> 0x008a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcxt.acquire(long):void");
    }

    public final boolean isHeld() {
        return this.zzkce.isHeld();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void release() {
        /*
        r8 = this;
        r0 = 0;
        r2 = 1;
        r1 = 0;
        r4 = r8.zzkz(r0);
        monitor-enter(r8);
        r0 = r8.zzkci;	 Catch:{ all -> 0x006b }
        if (r0 == 0) goto L_0x0019;
    L_0x000c:
        r0 = r8.zzkcj;	 Catch:{ all -> 0x006b }
        r0 = r0.get(r4);	 Catch:{ all -> 0x006b }
        r0 = (java.lang.Integer[]) r0;	 Catch:{ all -> 0x006b }
        if (r0 != 0) goto L_0x0049;
    L_0x0016:
        r0 = r1;
    L_0x0017:
        if (r0 != 0) goto L_0x0021;
    L_0x0019:
        r0 = r8.zzkci;	 Catch:{ all -> 0x006b }
        if (r0 != 0) goto L_0x0042;
    L_0x001d:
        r0 = r8.zzkck;	 Catch:{ all -> 0x006b }
        if (r0 != r2) goto L_0x0042;
    L_0x0021:
        com.google.android.gms.common.stats.zze.zzamf();	 Catch:{ all -> 0x006b }
        r0 = r8.mContext;	 Catch:{ all -> 0x006b }
        r1 = r8.zzkce;	 Catch:{ all -> 0x006b }
        r1 = com.google.android.gms.common.stats.zzc.zza(r1, r4);	 Catch:{ all -> 0x006b }
        r2 = 8;
        r3 = r8.zzgdn;	 Catch:{ all -> 0x006b }
        r5 = 0;
        r6 = r8.zzkcg;	 Catch:{ all -> 0x006b }
        r7 = r8.zzkcf;	 Catch:{ all -> 0x006b }
        r7 = com.google.android.gms.common.util.zzy.zzb(r7);	 Catch:{ all -> 0x006b }
        com.google.android.gms.common.stats.zze.zza(r0, r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x006b }
        r0 = r8.zzkck;	 Catch:{ all -> 0x006b }
        r0 = r0 + -1;
        r8.zzkck = r0;	 Catch:{ all -> 0x006b }
    L_0x0042:
        monitor-exit(r8);	 Catch:{ all -> 0x006b }
        r0 = r8.zzkce;	 Catch:{ RuntimeException -> 0x006e }
        r0.release();	 Catch:{ RuntimeException -> 0x006e }
    L_0x0048:
        return;
    L_0x0049:
        r3 = 0;
        r3 = r0[r3];	 Catch:{ all -> 0x006b }
        r3 = r3.intValue();	 Catch:{ all -> 0x006b }
        if (r3 != r2) goto L_0x0059;
    L_0x0052:
        r0 = r8.zzkcj;	 Catch:{ all -> 0x006b }
        r0.remove(r4);	 Catch:{ all -> 0x006b }
        r0 = r2;
        goto L_0x0017;
    L_0x0059:
        r3 = 0;
        r5 = 0;
        r5 = r0[r5];	 Catch:{ all -> 0x006b }
        r5 = r5.intValue();	 Catch:{ all -> 0x006b }
        r5 = r5 + -1;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x006b }
        r0[r3] = r5;	 Catch:{ all -> 0x006b }
        r0 = r1;
        goto L_0x0017;
    L_0x006b:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x006b }
        throw r0;
    L_0x006e:
        r0 = move-exception;
        goto L_0x0048;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcxt.release():void");
    }

    public final void setReferenceCounted(boolean z) {
        this.zzkce.setReferenceCounted(false);
        this.zzkci = false;
    }
}
