package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.zzbq;

public final class zzo {
    private static zzo zzeif = null;
    private zzz zzeig;
    private GoogleSignInAccount zzeih = this.zzeig.zzabt();
    private GoogleSignInOptions zzeii = this.zzeig.zzabu();

    private zzo(Context context) {
        this.zzeig = zzz.zzbt(context);
    }

    public static synchronized zzo zzbr(@NonNull Context context) {
        zzo zzbs;
        synchronized (zzo.class) {
            zzbs = zzbs(context.getApplicationContext());
        }
        return zzbs;
    }

    private static synchronized zzo zzbs(Context context) {
        zzo com_google_android_gms_auth_api_signin_internal_zzo;
        synchronized (zzo.class) {
            if (zzeif == null) {
                zzeif = new zzo(context);
            }
            com_google_android_gms_auth_api_signin_internal_zzo = zzeif;
        }
        return com_google_android_gms_auth_api_signin_internal_zzo;
    }

    public final synchronized void clear() {
        this.zzeig.clear();
        this.zzeih = null;
        this.zzeii = null;
    }

    public final synchronized void zza(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        zzz com_google_android_gms_auth_api_signin_internal_zzz = this.zzeig;
        zzbq.checkNotNull(googleSignInAccount);
        zzbq.checkNotNull(googleSignInOptions);
        com_google_android_gms_auth_api_signin_internal_zzz.zzo("defaultGoogleSignInAccount", googleSignInAccount.zzaba());
        com_google_android_gms_auth_api_signin_internal_zzz.zza(googleSignInAccount, googleSignInOptions);
        this.zzeih = googleSignInAccount;
        this.zzeii = googleSignInOptions;
    }

    public final synchronized GoogleSignInAccount zzabl() {
        return this.zzeih;
    }

    public final synchronized GoogleSignInOptions zzabm() {
        return this.zzeii;
    }
}
