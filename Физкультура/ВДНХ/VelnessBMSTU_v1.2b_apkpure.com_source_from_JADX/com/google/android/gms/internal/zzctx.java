package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class zzctx extends zzbfm {
    public static final Creator<zzctx> CREATOR = new zzcud();
    private static byte[][] zzfiz = new byte[0][];
    private static zzctx zzjwk = new zzctx("", null, zzfiz, zzfiz, zzfiz, zzfiz, null, null);
    private static final zzcuc zzjwt = new zzcty();
    private static final zzcuc zzjwu = new zzctz();
    private static final zzcuc zzjwv = new zzcua();
    private static final zzcuc zzjww = new zzcub();
    private String zzjwl;
    private byte[] zzjwm;
    private byte[][] zzjwn;
    private byte[][] zzjwo;
    private byte[][] zzjwp;
    private byte[][] zzjwq;
    private int[] zzjwr;
    private byte[][] zzjws;

    public zzctx(String str, byte[] bArr, byte[][] bArr2, byte[][] bArr3, byte[][] bArr4, byte[][] bArr5, int[] iArr, byte[][] bArr6) {
        this.zzjwl = str;
        this.zzjwm = bArr;
        this.zzjwn = bArr2;
        this.zzjwo = bArr3;
        this.zzjwp = bArr4;
        this.zzjwq = bArr5;
        this.zzjwr = iArr;
        this.zzjws = bArr6;
    }

    private static void zza(StringBuilder stringBuilder, String str, int[] iArr) {
        stringBuilder.append(str);
        stringBuilder.append("=");
        if (iArr == null) {
            stringBuilder.append("null");
            return;
        }
        stringBuilder.append("(");
        int length = iArr.length;
        Object obj = 1;
        int i = 0;
        while (i < length) {
            int i2 = iArr[i];
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(i2);
            i++;
            obj = null;
        }
        stringBuilder.append(")");
    }

    private static void zza(StringBuilder stringBuilder, String str, byte[][] bArr) {
        stringBuilder.append(str);
        stringBuilder.append("=");
        if (bArr == null) {
            stringBuilder.append("null");
            return;
        }
        stringBuilder.append("(");
        int length = bArr.length;
        Object obj = 1;
        int i = 0;
        while (i < length) {
            byte[] bArr2 = bArr[i];
            if (obj == null) {
                stringBuilder.append(", ");
            }
            stringBuilder.append("'");
            stringBuilder.append(Base64.encodeToString(bArr2, 3));
            stringBuilder.append("'");
            i++;
            obj = null;
        }
        stringBuilder.append(")");
    }

    private static List<String> zzb(byte[][] bArr) {
        if (bArr == null) {
            return Collections.emptyList();
        }
        List<String> arrayList = new ArrayList(bArr.length);
        for (byte[] encodeToString : bArr) {
            arrayList.add(Base64.encodeToString(encodeToString, 3));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static List<Integer> zzd(int[] iArr) {
        if (iArr == null) {
            return Collections.emptyList();
        }
        List<Integer> arrayList = new ArrayList(iArr.length);
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzctx)) {
            return false;
        }
        zzctx com_google_android_gms_internal_zzctx = (zzctx) obj;
        return zzcuh.equals(this.zzjwl, com_google_android_gms_internal_zzctx.zzjwl) && Arrays.equals(this.zzjwm, com_google_android_gms_internal_zzctx.zzjwm) && zzcuh.equals(zzb(this.zzjwn), zzb(com_google_android_gms_internal_zzctx.zzjwn)) && zzcuh.equals(zzb(this.zzjwo), zzb(com_google_android_gms_internal_zzctx.zzjwo)) && zzcuh.equals(zzb(this.zzjwp), zzb(com_google_android_gms_internal_zzctx.zzjwp)) && zzcuh.equals(zzb(this.zzjwq), zzb(com_google_android_gms_internal_zzctx.zzjwq)) && zzcuh.equals(zzd(this.zzjwr), zzd(com_google_android_gms_internal_zzctx.zzjwr)) && zzcuh.equals(zzb(this.zzjws), zzb(com_google_android_gms_internal_zzctx.zzjws));
    }

    public final String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder("ExperimentTokens");
        stringBuilder.append("(");
        if (this.zzjwl == null) {
            str = "null";
        } else {
            str = "'";
            String str2 = this.zzjwl;
            String str3 = "'";
            str = new StringBuilder((String.valueOf(str).length() + String.valueOf(str2).length()) + String.valueOf(str3).length()).append(str).append(str2).append(str3).toString();
        }
        stringBuilder.append(str);
        stringBuilder.append(", ");
        byte[] bArr = this.zzjwm;
        stringBuilder.append("direct");
        stringBuilder.append("=");
        if (bArr == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append("'");
            stringBuilder.append(Base64.encodeToString(bArr, 3));
            stringBuilder.append("'");
        }
        stringBuilder.append(", ");
        zza(stringBuilder, "GAIA", this.zzjwn);
        stringBuilder.append(", ");
        zza(stringBuilder, "PSEUDO", this.zzjwo);
        stringBuilder.append(", ");
        zza(stringBuilder, "ALWAYS", this.zzjwp);
        stringBuilder.append(", ");
        zza(stringBuilder, "OTHER", this.zzjwq);
        stringBuilder.append(", ");
        zza(stringBuilder, "weak", this.zzjwr);
        stringBuilder.append(", ");
        zza(stringBuilder, "directs", this.zzjws);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.zzjwl, false);
        zzbfp.zza(parcel, 3, this.zzjwm, false);
        zzbfp.zza(parcel, 4, this.zzjwn, false);
        zzbfp.zza(parcel, 5, this.zzjwo, false);
        zzbfp.zza(parcel, 6, this.zzjwp, false);
        zzbfp.zza(parcel, 7, this.zzjwq, false);
        zzbfp.zza(parcel, 8, this.zzjwr, false);
        zzbfp.zza(parcel, 9, this.zzjws, false);
        zzbfp.zzai(parcel, zze);
    }
}
