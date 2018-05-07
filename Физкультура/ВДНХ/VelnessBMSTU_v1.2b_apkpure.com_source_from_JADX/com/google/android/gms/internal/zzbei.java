package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzbei implements Creator<zzbeh> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        zzctx[] com_google_android_gms_internal_zzctxArr = null;
        int zzd = zzbfn.zzd(parcel);
        boolean z = true;
        byte[][] bArr = null;
        int[] iArr = null;
        String[] strArr = null;
        int[] iArr2 = null;
        byte[] bArr2 = null;
        zzbew com_google_android_gms_internal_zzbew = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    com_google_android_gms_internal_zzbew = (zzbew) zzbfn.zza(parcel, readInt, zzbew.CREATOR);
                    break;
                case 3:
                    bArr2 = zzbfn.zzt(parcel, readInt);
                    break;
                case 4:
                    iArr2 = zzbfn.zzw(parcel, readInt);
                    break;
                case 5:
                    strArr = zzbfn.zzaa(parcel, readInt);
                    break;
                case 6:
                    iArr = zzbfn.zzw(parcel, readInt);
                    break;
                case 7:
                    bArr = zzbfn.zzu(parcel, readInt);
                    break;
                case 8:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 9:
                    com_google_android_gms_internal_zzctxArr = (zzctx[]) zzbfn.zzb(parcel, readInt, zzctx.CREATOR);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzbeh(com_google_android_gms_internal_zzbew, bArr2, iArr2, strArr, iArr, bArr, z, com_google_android_gms_internal_zzctxArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbeh[i];
    }
}
