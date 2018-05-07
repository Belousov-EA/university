package com.google.firebase.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public class UserProfileChangeRequest extends zzbfm {
    public static final Creator<UserProfileChangeRequest> CREATOR = new zzu();
    private String zzegt;
    private String zzmdx;
    private boolean zzmdy;
    private boolean zzmdz;
    private Uri zzmea;

    public static class Builder {
        private String zzegt;
        private boolean zzmdy;
        private boolean zzmdz;
        private Uri zzmea;

        public UserProfileChangeRequest build() {
            return new UserProfileChangeRequest(this.zzegt, this.zzmea == null ? null : this.zzmea.toString(), this.zzmdy, this.zzmdz);
        }

        public Builder setDisplayName(@Nullable String str) {
            if (str == null) {
                this.zzmdy = true;
            } else {
                this.zzegt = str;
            }
            return this;
        }

        public Builder setPhotoUri(@Nullable Uri uri) {
            if (uri == null) {
                this.zzmdz = true;
            } else {
                this.zzmea = uri;
            }
            return this;
        }
    }

    UserProfileChangeRequest(String str, String str2, boolean z, boolean z2) {
        this.zzegt = str;
        this.zzmdx = str2;
        this.zzmdy = z;
        this.zzmdz = z2;
        this.zzmea = TextUtils.isEmpty(str2) ? null : Uri.parse(str2);
    }

    @Nullable
    public String getDisplayName() {
        return this.zzegt;
    }

    @Nullable
    public Uri getPhotoUri() {
        return this.zzmea;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, getDisplayName(), false);
        zzbfp.zza(parcel, 3, this.zzmdx, false);
        zzbfp.zza(parcel, 4, this.zzmdy);
        zzbfp.zza(parcel, 5, this.zzmdz);
        zzbfp.zzai(parcel, zze);
    }
}
