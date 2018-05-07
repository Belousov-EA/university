package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.zzbfn;
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken;

public final class zzc implements Creator<ForceResendingToken> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        while (parcel.dataPosition() < zzd) {
            zzbfn.zzb(parcel, parcel.readInt());
        }
        zzbfn.zzaf(parcel, zzd);
        return new ForceResendingToken();
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new ForceResendingToken[i];
    }
}
