package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zze implements Creator<CredentialRequest> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzd = zzbfn.zzd(parcel);
        String str2 = null;
        boolean z2 = false;
        CredentialPickerConfig credentialPickerConfig = null;
        CredentialPickerConfig credentialPickerConfig2 = null;
        String[] strArr = null;
        boolean z3 = false;
        int i = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    z3 = zzbfn.zzc(parcel, readInt);
                    break;
                case 2:
                    strArr = zzbfn.zzaa(parcel, readInt);
                    break;
                case 3:
                    credentialPickerConfig2 = (CredentialPickerConfig) zzbfn.zza(parcel, readInt, CredentialPickerConfig.CREATOR);
                    break;
                case 4:
                    credentialPickerConfig = (CredentialPickerConfig) zzbfn.zza(parcel, readInt, CredentialPickerConfig.CREATOR);
                    break;
                case 5:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 6:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                case 7:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 8:
                    z = zzbfn.zzc(parcel, readInt);
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
        return new CredentialRequest(i, z3, strArr, credentialPickerConfig2, credentialPickerConfig, z2, str2, str, z);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new CredentialRequest[i];
    }
}
