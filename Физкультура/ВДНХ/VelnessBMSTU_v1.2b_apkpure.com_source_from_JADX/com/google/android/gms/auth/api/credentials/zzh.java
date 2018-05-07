package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zzh implements Creator<HintRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzd = zzbfn.zzd(parcel);
        String str2 = null;
        String[] strArr = null;
        boolean z2 = false;
        boolean z3 = false;
        CredentialPickerConfig credentialPickerConfig = null;
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    credentialPickerConfig = (CredentialPickerConfig) zzbfn.zza(parcel, readInt, CredentialPickerConfig.CREATOR);
                    break;
                case 2:
                    z3 = zzbfn.zzc(parcel, readInt);
                    break;
                case 3:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 4:
                    strArr = zzbfn.zzaa(parcel, readInt);
                    break;
                case 5:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 6:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 7:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 1000:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new HintRequest(i, credentialPickerConfig, z3, z2, strArr, z, str2, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new HintRequest[i];
    }
}
