package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.internal.view.SupportMenu;
import com.google.android.gms.internal.zzbfn;

public final class zzf implements Creator<SignInAccount> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int zzd = zzbfn.zzd(parcel);
        String str = "";
        GoogleSignInAccount googleSignInAccount = null;
        String str2 = "";
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            switch (SupportMenu.USER_MASK & readInt) {
                case 4:
                    str = zzbfn.zzq(parcel, readInt);
                    break;
                case 7:
                    googleSignInAccount = (GoogleSignInAccount) zzbfn.zza(parcel, readInt, GoogleSignInAccount.CREATOR);
                    break;
                case 8:
                    str2 = zzbfn.zzq(parcel, readInt);
                    break;
                default:
                    zzbfn.zzb(parcel, readInt);
                    break;
            }
        }
        zzbfn.zzaf(parcel, zzd);
        return new SignInAccount(str, googleSignInAccount, str2);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new SignInAccount[i];
    }
}
