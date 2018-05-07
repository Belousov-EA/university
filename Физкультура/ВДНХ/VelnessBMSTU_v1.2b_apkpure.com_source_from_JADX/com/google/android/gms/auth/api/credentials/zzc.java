package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zzc implements Creator<CredentialPickerConfig> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i = 0;
        int zzd = zzbfn.zzd(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 1:
                    z3 = zzbfn.zzc(parcel, readInt);
                    break;
                case 2:
                    z2 = zzbfn.zzc(parcel, readInt);
                    break;
                case 3:
                    z = zzbfn.zzc(parcel, readInt);
                    break;
                case 4:
                    i = zzbfn.zzg(parcel, readInt);
                    break;
                case 1000:
                    i2 = zzbfn.zzg(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new CredentialPickerConfig(i2, z3, z2, z, i);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new CredentialPickerConfig[i];
    }
}
