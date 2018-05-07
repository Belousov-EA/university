package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public class SignInAccount extends zzbfm implements ReflectedParcelable {
    public static final Creator<SignInAccount> CREATOR = new zzf();
    @Deprecated
    private String zzauv;
    @Deprecated
    private String zzegs;
    private GoogleSignInAccount zzehv;

    SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.zzehv = googleSignInAccount;
        this.zzegs = zzbq.zzh(str, "8.3 and 8.4 SDKs require non-null email");
        this.zzauv = zzbq.zzh(str2, "8.3 and 8.4 SDKs require non-null userId");
    }

    public final GoogleSignInAccount getGoogleSignInAccount() {
        return this.zzehv;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 4, this.zzegs, false);
        zzbfp.zza(parcel, 7, this.zzehv, i, false);
        zzbfp.zza(parcel, 8, this.zzauv, false);
        zzbfp.zzai(parcel, zze);
    }
}
