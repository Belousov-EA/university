package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class SignInConfiguration extends zzbfm implements ReflectedParcelable {
    public static final Creator<SignInConfiguration> CREATOR = new zzx();
    private final String zzeil;
    private GoogleSignInOptions zzeim;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        this.zzeil = zzbq.zzgm(str);
        this.zzeim = googleSignInOptions;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
            if (!this.zzeil.equals(signInConfiguration.zzeil)) {
                return false;
            }
            if (this.zzeim == null) {
                if (signInConfiguration.zzeim != null) {
                    return false;
                }
            } else if (!this.zzeim.equals(signInConfiguration.zzeim)) {
                return false;
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public final int hashCode() {
        return new zzp().zzs(this.zzeil).zzs(this.zzeim).zzabn();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.zzeil, false);
        zzbfp.zza(parcel, 5, this.zzeim, i, false);
        zzbfp.zzai(parcel, zze);
    }

    public final GoogleSignInOptions zzabr() {
        return this.zzeim;
    }
}
