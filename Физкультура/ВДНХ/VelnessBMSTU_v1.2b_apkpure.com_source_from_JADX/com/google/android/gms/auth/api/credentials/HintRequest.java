package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class HintRequest extends zzbfm implements ReflectedParcelable {
    public static final Creator<HintRequest> CREATOR = new zzh();
    private int zzeck;
    private final String[] zzefi;
    private final boolean zzefl;
    private final String zzefm;
    private final String zzefn;
    private final CredentialPickerConfig zzefp;
    private final boolean zzefq;
    private final boolean zzefr;

    public static final class Builder {
        private String[] zzefi;
        private boolean zzefl = false;
        private String zzefm;
        private String zzefn;
        private CredentialPickerConfig zzefp = new com.google.android.gms.auth.api.credentials.CredentialPickerConfig.Builder().build();
        private boolean zzefq;
        private boolean zzefr;

        public final HintRequest build() {
            if (this.zzefi == null) {
                this.zzefi = new String[0];
            }
            if (this.zzefq || this.zzefr || this.zzefi.length != 0) {
                return new HintRequest();
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

        public final Builder setEmailAddressIdentifierSupported(boolean z) {
            this.zzefq = z;
            return this;
        }

        public final Builder setHintPickerConfig(@NonNull CredentialPickerConfig credentialPickerConfig) {
            this.zzefp = (CredentialPickerConfig) zzbq.checkNotNull(credentialPickerConfig);
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

        public final Builder setPhoneNumberIdentifierSupported(boolean z) {
            this.zzefr = z;
            return this;
        }

        public final Builder setServerClientId(@Nullable String str) {
            this.zzefm = str;
            return this;
        }
    }

    HintRequest(int i, CredentialPickerConfig credentialPickerConfig, boolean z, boolean z2, String[] strArr, boolean z3, String str, String str2) {
        this.zzeck = i;
        this.zzefp = (CredentialPickerConfig) zzbq.checkNotNull(credentialPickerConfig);
        this.zzefq = z;
        this.zzefr = z2;
        this.zzefi = (String[]) zzbq.checkNotNull(strArr);
        if (this.zzeck < 2) {
            this.zzefl = true;
            this.zzefm = null;
            this.zzefn = null;
            return;
        }
        this.zzefl = z3;
        this.zzefm = str;
        this.zzefn = str2;
    }

    private HintRequest(Builder builder) {
        this(2, builder.zzefp, builder.zzefq, builder.zzefr, builder.zzefi, builder.zzefl, builder.zzefm, builder.zzefn);
    }

    @NonNull
    public final String[] getAccountTypes() {
        return this.zzefi;
    }

    @NonNull
    public final CredentialPickerConfig getHintPickerConfig() {
        return this.zzefp;
    }

    @Nullable
    public final String getIdTokenNonce() {
        return this.zzefn;
    }

    @Nullable
    public final String getServerClientId() {
        return this.zzefm;
    }

    public final boolean isEmailAddressIdentifierSupported() {
        return this.zzefq;
    }

    public final boolean isIdTokenRequested() {
        return this.zzefl;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, getHintPickerConfig(), i, false);
        zzbfp.zza(parcel, 2, isEmailAddressIdentifierSupported());
        zzbfp.zza(parcel, 3, this.zzefr);
        zzbfp.zza(parcel, 4, getAccountTypes(), false);
        zzbfp.zza(parcel, 5, isIdTokenRequested());
        zzbfp.zza(parcel, 6, getServerClientId(), false);
        zzbfp.zza(parcel, 7, getIdTokenNonce(), false);
        zzbfp.zzc(parcel, 1000, this.zzeck);
        zzbfp.zzai(parcel, zze);
    }
}
