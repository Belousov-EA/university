package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;

public final class zzcud implements Creator<zzctx> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        byte[][] bArr = null;
        int zzd = zzbfn.zzd(parcel);
        int[] iArr = null;
        byte[][] bArr2 = null;
        byte[][] bArr3 = null;
        byte[][] bArr4 = null;
        byte[][] bArr5 = null;
        byte[] bArr6 = null;
        String str = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 2:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 3:
                    bArr6 = zzbfn.zzt(parcel, readInt);
                    break;
                case 4:
                    bArr5 = zzbfn.zzu(parcel, readInt);
                    break;
                case 5:
                    bArr4 = zzbfn.zzu(parcel, readInt);
                    break;
                case 6:
                    bArr3 = zzbfn.zzu(parcel, readInt);
                    break;
                case 7:
                    bArr2 = zzbfn.zzu(parcel, readInt);
                    break;
                case 8:
                    iArr = zzbfn.zzw(parcel, readInt);
                    break;
                case 9:
                    bArr = zzbfn.zzu(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new zzctx(str, bArr6, bArr5, bArr4, bArr3, bArr2, iArr, bArr);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzctx[i];
    }
}
