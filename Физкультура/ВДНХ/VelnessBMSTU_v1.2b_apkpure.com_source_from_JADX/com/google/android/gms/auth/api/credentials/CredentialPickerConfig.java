package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class CredentialPickerConfig extends zzbfm implements ReflectedParcelable {
    public static final Creator<CredentialPickerConfig> CREATOR = new zzc();
    private final boolean mShowCancelButton;
    private int zzeck;
    private final boolean zzefd;
    @Deprecated
    private final boolean zzefe;
    private final int zzeff;

    public static class Builder {
        private boolean mShowCancelButton = true;
        private boolean zzefd = false;
        private int zzefg = 1;

        public CredentialPickerConfig build() {
            return new CredentialPickerConfig();
        }

        @Deprecated
        public Builder setForNewAccount(boolean z) {
            this.zzefg = z ? 3 : 1;
            return this;
        }

        public Builder setPrompt(int i) {
            this.zzefg = i;
            return this;
        }

        public Builder setShowAddAccountButton(boolean z) {
            this.zzefd = z;
            return this;
        }

        public Builder setShowCancelButton(boolean z) {
            this.mShowCancelButton = z;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Prompt {
        public static final int CONTINUE = 1;
        public static final int SIGN_IN = 2;
        public static final int SIGN_UP = 3;
    }

    CredentialPickerConfig(int i, boolean z, boolean z2, boolean z3, int i2) {
        int i3 = 3;
        boolean z4 = true;
        this.zzeck = i;
        this.zzefd = z;
        this.mShowCancelButton = z2;
        if (i < 2) {
            this.zzefe = z3;
            if (!z3) {
                i3 = 1;
            }
            this.zzeff = i3;
            return;
        }
        if (i2 != 3) {
            z4 = false;
        }
        this.zzefe = z4;
        this.zzeff = i2;
    }

    private CredentialPickerConfig(Builder builder) {
        this(2, builder.zzefd, builder.mShowCancelButton, false, builder.zzefg);
    }

    @Deprecated
    public final boolean isForNewAccount() {
        return this.zzeff == 3;
    }

    public final boolean shouldShowAddAccountButton() {
        return this.zzefd;
    }

    public final boolean shouldShowCancelButton() {
        return this.mShowCancelButton;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, shouldShowAddAccountButton());
        zzbfp.zza(parcel, 2, shouldShowCancelButton());
        zzbfp.zza(parcel, 3, isForNewAccount());
        zzbfp.zzc(parcel, 4, this.zzeff);
        zzbfp.zzc(parcel, 1000, this.zzeck);
        zzbfp.zzai(parcel, zze);
    }
}
