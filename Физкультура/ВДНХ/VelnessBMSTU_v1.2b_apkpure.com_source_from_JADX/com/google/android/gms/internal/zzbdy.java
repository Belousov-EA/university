package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import java.util.ArrayList;

public final class zzbdy {
    @Deprecated
    public static final Api<NoOptions> API = new Api("ClearcutLogger.API", zzebg, zzebf);
    private static zzf<zzbeo> zzebf = new zzf();
    private static zza<zzbeo, NoOptions> zzebg = new zzbdz();
    private static final zzctx[] zzfix = new zzctx[0];
    private static final String[] zzfiy = new String[0];
    private static final byte[][] zzfiz = new byte[0][];
    private final String packageName;
    private final zzd zzddz;
    private final int zzfja;
    private String zzfjb;
    private int zzfjc = -1;
    private String zzfjd;
    private String zzfje;
    private final boolean zzfjf;
    private int zzfjg = 0;
    private final zzbee zzfjh;
    private zzbed zzfji;
    private final zzbeb zzfjj;

    public zzbdy(Context context, int i, String str, String str2, String str3, boolean z, zzbee com_google_android_gms_internal_zzbee, zzd com_google_android_gms_common_util_zzd, zzbed com_google_android_gms_internal_zzbed, zzbeb com_google_android_gms_internal_zzbeb) {
        this.packageName = context.getPackageName();
        this.zzfja = zzbz(context);
        this.zzfjc = -1;
        this.zzfjb = str;
        this.zzfjd = null;
        this.zzfje = null;
        this.zzfjf = true;
        this.zzfjh = com_google_android_gms_internal_zzbee;
        this.zzddz = com_google_android_gms_common_util_zzd;
        this.zzfji = new zzbed();
        this.zzfjg = 0;
        this.zzfjj = com_google_android_gms_internal_zzbeb;
        zzbq.checkArgument(true, "can't be anonymous with an upload account");
    }

    private static int[] zzb(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            int intValue = ((Integer) obj).intValue();
            int i3 = i2 + 1;
            iArr[i2] = intValue;
            i2 = i3;
        }
        return iArr;
    }

    private static int zzbz(Context context) {
        int i = 0;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.wtf("ClearcutLogger", "This can't happen.");
            return i;
        }
    }

    public final zzbea zzi(byte[] bArr) {
        return new zzbea(this, bArr);
    }
}
