package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public class ActionCodeSettings extends zzbfm {
    public static final Creator<ActionCodeSettings> CREATOR = new zzb();
    private final String zzah;
    private int zzeed;
    private final String zzmcn;
    private final String zzmco;
    private final String zzmcp;
    private final boolean zzmcq;
    private final String zzmcr;
    private final boolean zzmcs;
    private String zzmct;

    public static class Builder {
        private String zzah;
        private String zzmcn;
        private String zzmcp;
        private boolean zzmcq;
        private String zzmcr;
        private boolean zzmcs;

        private Builder() {
            this.zzmcs = false;
        }

        public ActionCodeSettings build() {
            return new ActionCodeSettings();
        }

        public Builder setAndroidPackageName(@NonNull String str, boolean z, @Nullable String str2) {
            this.zzmcp = str;
            this.zzmcq = z;
            this.zzmcr = str2;
            return this;
        }

        public Builder setHandleCodeInApp(boolean z) {
            this.zzmcs = z;
            return this;
        }

        public Builder setIOSBundleId(@NonNull String str) {
            this.zzmcn = str;
            return this;
        }

        public Builder setUrl(@NonNull String str) {
            this.zzah = str;
            return this;
        }
    }

    private ActionCodeSettings(Builder builder) {
        this.zzah = builder.zzah;
        this.zzmcn = builder.zzmcn;
        this.zzmco = null;
        this.zzmcp = builder.zzmcp;
        this.zzmcq = builder.zzmcq;
        this.zzmcr = builder.zzmcr;
        this.zzmcs = builder.zzmcs;
    }

    ActionCodeSettings(String str, String str2, String str3, String str4, boolean z, String str5, boolean z2, String str6, int i) {
        this.zzah = str;
        this.zzmcn = str2;
        this.zzmco = str3;
        this.zzmcp = str4;
        this.zzmcq = z;
        this.zzmcr = str5;
        this.zzmcs = z2;
        this.zzmct = str6;
        this.zzeed = i;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean canHandleCodeInApp() {
        return this.zzmcs;
    }

    public boolean getAndroidInstallApp() {
        return this.zzmcq;
    }

    public String getAndroidMinimumVersion() {
        return this.zzmcr;
    }

    public String getAndroidPackageName() {
        return this.zzmcp;
    }

    public String getIOSBundle() {
        return this.zzmcn;
    }

    public String getUrl() {
        return this.zzah;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, getUrl(), false);
        zzbfp.zza(parcel, 2, getIOSBundle(), false);
        zzbfp.zza(parcel, 3, this.zzmco, false);
        zzbfp.zza(parcel, 4, getAndroidPackageName(), false);
        zzbfp.zza(parcel, 5, getAndroidInstallApp());
        zzbfp.zza(parcel, 6, getAndroidMinimumVersion(), false);
        zzbfp.zza(parcel, 7, canHandleCodeInApp());
        zzbfp.zza(parcel, 8, this.zzmct, false);
        zzbfp.zzc(parcel, 9, this.zzeed);
        zzbfp.zzai(parcel, zze);
    }

    public final void zzgl(@NonNull int i) {
        this.zzeed = 1;
    }

    public final void zzou(@NonNull String str) {
        this.zzmct = str;
    }
}
