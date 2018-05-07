package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zzg;
import com.google.android.gms.common.internal.zzbj;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.common.zzf;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;

public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions> {
    private static final zza zzeha = new zza();
    private static int zzehb = zzb.zzehd;

    enum zzb {
        public static final int zzehd = 1;
        public static final int zzehe = 2;
        public static final int zzehf = 3;
        public static final int zzehg = 4;
        private static final /* synthetic */ int[] zzehh = new int[]{zzehd, zzehe, zzehf, zzehg};

        public static int[] m9xd6228de2() {
            return (int[]) zzehh.clone();
        }
    }

    static class zza implements zzbo<GoogleSignInResult, GoogleSignInAccount> {
        private zza() {
        }

        public final /* synthetic */ Object zzb(Result result) {
            return ((GoogleSignInResult) result).getSignInAccount();
        }
    }

    GoogleSignInClient(@NonNull Activity activity, GoogleSignInOptions googleSignInOptions) {
        super(activity, Auth.GOOGLE_SIGN_IN_API, (ApiOptions) googleSignInOptions, new zzg());
    }

    GoogleSignInClient(@NonNull Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, Auth.GOOGLE_SIGN_IN_API, (ApiOptions) googleSignInOptions, new zzg());
    }

    private final synchronized int zzabd() {
        if (zzehb == zzb.zzehd) {
            Context applicationContext = getApplicationContext();
            int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(applicationContext);
            if (isGooglePlayServicesAvailable == 0) {
                zzehb = zzb.zzehg;
            } else if (zzf.zza(applicationContext, isGooglePlayServicesAvailable, null) != null || DynamiteModule.zzab(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) {
                zzehb = zzb.zzehe;
            } else {
                zzehb = zzb.zzehf;
            }
        }
        return zzehb;
    }

    @NonNull
    public Intent getSignInIntent() {
        Context applicationContext = getApplicationContext();
        switch (zzc.zzehc[zzabd() - 1]) {
            case 1:
                return zze.zzb(applicationContext, (GoogleSignInOptions) zzagm());
            case 2:
                return zze.zza(applicationContext, (GoogleSignInOptions) zzagm());
            default:
                return zze.zzc(applicationContext, (GoogleSignInOptions) zzagm());
        }
    }

    public Task<Void> revokeAccess() {
        return zzbj.zzb(zze.zzb(zzago(), getApplicationContext(), zzabd() == zzb.zzehf));
    }

    public Task<Void> signOut() {
        return zzbj.zzb(zze.zza(zzago(), getApplicationContext(), zzabd() == zzb.zzehf));
    }

    public Task<GoogleSignInAccount> silentSignIn() {
        return zzbj.zza(zze.zza(zzago(), getApplicationContext(), (GoogleSignInOptions) zzagm(), zzabd() == zzb.zzehf), zzeha);
    }
}
