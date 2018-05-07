package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class CredentialRequest extends zzbfm {
    public static final Creator<CredentialRequest> CREATOR = new zze();
    private int zzeck;
    private final boolean zzefh;
    private final String[] zzefi;
    private final CredentialPickerConfig zzefj;
    private final CredentialPickerConfig zzefk;
    private final boolean zzefl;
    private final String zzefm;
    private final String zzefn;
    private final boolean zzefo;

    public static final class Builder {
        private boolean zzefh;
        private String[] zzefi;
        private CredentialPickerConfig zzefj;
        private CredentialPickerConfig zzefk;
        private boolean zzefl = false;
        @Nullable
        private String zzefm = null;
        @Nullable
        private String zzefn;
        private boolean zzefo = false;

        public final CredentialRequest build() {
            if (this.zzefi == null) {
                this.zzefi = new String[0];
            }
            if (this.zzefh || this.zzefi.length != 0) {
                return new CredentialRequest();
            }
            throw new IllegalStateException("At least one authentication method must be specified");
        }

        public final Builder setAccountTypes(String... strArr) {
            if (strArr == null) {
                strArr = new String[0];
            }
            this.zzefi = strArr;
            return this;
        }

        public final Builder setCredentialHintPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.zzefk = credentialPickerConfig;
            return this;
        }

        public final Builder setCredentialPickerConfig(CredentialPickerConfig credentialPickerConfig) {
            this.zzefj = credentialPickerConfig;
            return this;
        }

        public final Builder setIdTokenNonce(@Nullable String str) {
            this.zzefn = str;
            return this;
        }

        public final Builder setIdTokenRequested(boolean z) {
            this.zzefl = z;
            return this;
        }

        public final Builder setPasswordLoginSupported(boolean z) {
            this.zzefh = z;
            return this;
        }

        public final Builder setServerClientId(@Nullable String str) {
            this.zzefm = str;
            return this;
        }

        @Deprecated
        public final Builder setSupportsPasswordLogin(boolean z) {
            return setPasswordLoginSupported(z);
        }
    }

    CredentialRequest(int i, boolean z, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2, boolean z2, String str, String str2, boolean z3) {
        this.zzeck = i;
        this.zzefh = z;
        this.zzefi = (String[]) zzbq.checkNotNull(strArr);
        if (credentialPickerConfig == null) {
            credentialPickerConfig = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        }
        this.zzefj = credentialPickerConfig;
        if (credentialPickerConfig2 == null) {
            credentialPickerConfig2 = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        }
        this.zzefk = credentialPickerConfig2;
        if (i < 3) {
            this.zzefl = true;
            this.zzefm = null;
            this.zzefn = null;
        } else {
            this.zzefl = z2;
            this.zzefm = str;
            this.zzefn = str2;
        }
        this.zzefo = z3;
    }

    private CredentialRequest(Builder builder) {
        this(4, builder.zzefh, builder.zzefi, builder.zzefj, builder.zzefk, builder.zzefl, builder.zzefm, builder.zzefn, false);
    }

    @NonNull
    public final String[] getAccountTypes() {
        return this.zzefi;
    }

    @NonNull
    public final Set<String> getAccountTypesSet() {
        return new HashSet(Arrays.asList(this.zzefi));
    }

    @NonNull
    public final CredentialPickerConfig getCredentialHintPickerConfig() {
        return this.zzefk;
    }

    @NonNull
    public final CredentialPickerConfig getCredentialPickerConfig() {
        return this.zzefj;
    }

    @Nullable
    public final String getIdTokenNonce() {
        return this.zzefn;
    }

    @Nullable
    public final String getServerClientId() {
        return this.zzefm;
    }

    @Deprecated
    public final boolean getSupportsPasswordLogin() {
        return isPasswordLoginSupported();
    }

    public final boolean isIdTokenRequested() {
        return this.zzefl;
    }

    public final boolean isPasswordLoginSupported() {
        return this.zzefh;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, isPasswordLoginSupported());
        zzbfp.zza(parcel, 2, getAccountTypes(), false);
        zzbfp.zza(parcel, 3, getCredentialPickerConfig(), i, false);
        zzbfp.zza(parcel, 4, getCredentialHintPickerConfig(), i, false);
        zzbfp.zza(parcel, 5, isIdTokenRequested());
        zzbfp.zza(parcel, 6, getServerClientId(), false);
        zzbfp.zza(parcel, 7, getIdTokenNonce(), false);
        zzbfp.zzc(parcel, 1000, this.zzeck);
        zzbfp.zza(parcel, 8, this.zzefo);
        zzbfp.zzai(parcel, zze);
    }
}
