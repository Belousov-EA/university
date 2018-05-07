package com.google.android.gms.auth.api;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzc;
import com.google.android.gms.auth.api.signin.internal.zzd;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.internal.zzaur;
import com.google.android.gms.internal.zzaus;
import com.google.android.gms.internal.zzaut;
import com.google.android.gms.internal.zzavp;
import com.google.android.gms.internal.zzavy;
import com.google.android.gms.internal.zzawx;

public final class Auth {
    public static final Api<AuthCredentialsOptions> CREDENTIALS_API = new Api("Auth.CREDENTIALS_API", zzecy, zzecv);
    public static final CredentialsApi CredentialsApi = new zzavp();
    public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API = new Api("Auth.GOOGLE_SIGN_IN_API", zzeda, zzecx);
    public static final GoogleSignInApi GoogleSignInApi = new zzc();
    @KeepForSdk
    public static final Api<zzf> PROXY_API = zzd.API;
    @KeepForSdk
    public static final ProxyApi ProxyApi = new zzawx();
    public static final zzf<zzavy> zzecv = new zzf();
    private static zzf<zzaut> zzecw = new zzf();
    public static final zzf<zzd> zzecx = new zzf();
    private static final zza<zzavy, AuthCredentialsOptions> zzecy = new zza();
    private static final zza<zzaut, NoOptions> zzecz = new zzb();
    private static final zza<zzd, GoogleSignInOptions> zzeda = new zzc();
    private static Api<NoOptions> zzedb = new Api("Auth.ACCOUNT_STATUS_API", zzecz, zzecw);
    private static zzaur zzedc = new zzaus();

    @Deprecated
    public static class AuthCredentialsOptions implements Optional {
        private static AuthCredentialsOptions zzedd = new Builder().zzaat();
        private final String zzede = null;
        private final PasswordSpecification zzedf;
        private final boolean zzedg;

        @Deprecated
        public static class Builder {
            @NonNull
            protected PasswordSpecification zzedf = PasswordSpecification.zzeft;
            protected Boolean zzedh = Boolean.valueOf(false);

            public Builder forceEnableSaveDialog() {
                this.zzedh = Boolean.valueOf(true);
                return this;
            }

            public AuthCredentialsOptions zzaat() {
                return new AuthCredentialsOptions(this);
            }
        }

        public AuthCredentialsOptions(Builder builder) {
            this.zzedf = builder.zzedf;
            this.zzedg = builder.zzedh.booleanValue();
        }

        public final Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", null);
            bundle.putParcelable("password_specification", this.zzedf);
            bundle.putBoolean("force_save_dialog", this.zzedg);
            return bundle;
        }

        public final PasswordSpecification zzaas() {
            return this.zzedf;
        }
    }

    private Auth() {
    }
}
