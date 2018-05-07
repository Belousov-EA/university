package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

public final class zzbeh extends zzbfm {
    public static final Creator<zzbeh> CREATOR = new zzbei();
    public final zzbec zzfjk;
    private boolean zzfjq;
    public final zzfkq zzfjr;
    public zzbew zzfjx;
    public byte[] zzfjy;
    private int[] zzfjz;
    private String[] zzfka;
    private int[] zzfkb;
    private byte[][] zzfkc;
    private zzctx[] zzfkd;
    public final zzbec zzfke;

    public zzbeh(zzbew com_google_android_gms_internal_zzbew, zzfkq com_google_android_gms_internal_zzfkq, zzbec com_google_android_gms_internal_zzbec, zzbec com_google_android_gms_internal_zzbec2, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr, zzctx[] com_google_android_gms_internal_zzctxArr, boolean z) {
        this.zzfjx = com_google_android_gms_internal_zzbew;
        this.zzfjr = com_google_android_gms_internal_zzfkq;
        this.zzfjk = com_google_android_gms_internal_zzbec;
        this.zzfke = null;
        this.zzfjz = iArr;
        this.zzfka = null;
        this.zzfkb = iArr2;
        this.zzfkc = null;
        this.zzfkd = null;
        this.zzfjq = z;
    }

    zzbeh(zzbew com_google_android_gms_internal_zzbew, byte[] bArr, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr2, boolean z, zzctx[] com_google_android_gms_internal_zzctxArr) {
        this.zzfjx = com_google_android_gms_internal_zzbew;
        this.zzfjy = bArr;
        this.zzfjz = iArr;
        this.zzfka = strArr;
        this.zzfjr = null;
        this.zzfjk = null;
        this.zzfke = null;
        this.zzfkb = iArr2;
        this.zzfkc = bArr2;
        this.zzfkd = com_google_android_gms_internal_zzctxArr;
        this.zzfjq = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbeh)) {
            return false;
        }
        zzbeh com_google_android_gms_internal_zzbeh = (zzbeh) obj;
        return zzbg.equal(this.zzfjx, com_google_android_gms_internal_zzbeh.zzfjx) && Arrays.equals(this.zzfjy, com_google_android_gms_internal_zzbeh.zzfjy) && Arrays.equals(this.zzfjz, com_google_android_gms_internal_zzbeh.zzfjz) && Arrays.equals(this.zzfka, com_google_android_gms_internal_zzbeh.zzfka) && zzbg.equal(this.zzfjr, com_google_android_gms_internal_zzbeh.zzfjr) && zzbg.equal(this.zzfjk, com_google_android_gms_internal_zzbeh.zzfjk) && zzbg.equal(this.zzfke, com_google_android_gms_internal_zzbeh.zzfke) && Arrays.equals(this.zzfkb, com_google_android_gms_internal_zzbeh.zzfkb) && Arrays.deepEquals(this.zzfkc, com_google_android_gms_internal_zzbeh.zzfkc) && Arrays.equals(this.zzfkd, com_google_android_gms_internal_zzbeh.zzfkd) && this.zzfjq == com_google_android_gms_internal_zzbeh.zzfjq;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzfjx, this.zzfjy, this.zzfjz, this.zzfka, this.zzfjr, this.zzfjk, this.zzfke, this.zzfkb, this.zzfkc, this.zzfkd, Boolean.valueOf(this.zzfjq)});
    }

    public final String toString() {
        return "LogEventParcelable[" + this.zzfjx + ", LogEventBytes: " + (this.zzfjy == null ? null : new String(this.zzfjy)) + ", TestCodes: " + Arrays.toString(this.zzfjz) + ", MendelPackages: " + Arrays.toString(this.zzfka) + ", LogEvent: " + this.zzfjr + ", ExtensionProducer: " + this.zzfjk + ", VeProducer: " + this.zzfke + ", ExperimentIDs: " + Arrays.toString(this.zzfkb) + ", ExperimentTokens: " + Arrays.toString(this.zzfkc) + ", ExperimentTokensParcelables: " + Arrays.toString(this.zzfkd) + ", AddPhenotypeExperimentTokens: " + this.zzfjq + "]";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.zzfjx, i, false);
        zzbfp.zza(parcel, 3, this.zzfjy, false);
        zzbfp.zza(parcel, 4, this.zzfjz, false);
        zzbfp.zza(parcel, 5, this.zzfka, false);
        zzbfp.zza(parcel, 6, this.zzfkb, false);
        zzbfp.zza(parcel, 7, this.zzfkc, false);
        zzbfp.zza(parcel, 8, this.zzfjq);
        zzbfp.zza(parcel, 9, this.zzfkd, i, false);
        zzbfp.zzai(parcel, zze);
    }
}
