package com.google.firebase.auth.internal;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzdvu;
import com.google.android.gms.internal.zzdyk;
import com.google.android.gms.internal.zzdyo;
import com.google.firebase.auth.UserInfo;
import org.json.JSONObject;

public final class zzf implements UserInfo {
    @NonNull
    private String zzauv;
    @Nullable
    private String zzegs;
    @Nullable
    private String zzegt;
    @Nullable
    private String zzimi;
    @NonNull
    private String zzmcu;
    @Nullable
    private String zzmdx;
    @Nullable
    private Uri zzmea;
    private boolean zzmgh;
    @Nullable
    private String zzmgp;

    public zzf(@NonNull zzdyk com_google_android_gms_internal_zzdyk, @NonNull String str) {
        zzbq.checkNotNull(com_google_android_gms_internal_zzdyk);
        zzbq.zzgm(str);
        this.zzauv = zzbq.zzgm(com_google_android_gms_internal_zzdyk.getLocalId());
        this.zzmcu = str;
        this.zzegs = com_google_android_gms_internal_zzdyk.getEmail();
        this.zzegt = com_google_android_gms_internal_zzdyk.getDisplayName();
        Uri photoUri = com_google_android_gms_internal_zzdyk.getPhotoUri();
        if (photoUri != null) {
            this.zzmdx = photoUri.toString();
            this.zzmea = photoUri;
        }
        this.zzmgh = com_google_android_gms_internal_zzdyk.isEmailVerified();
        this.zzmgp = null;
        this.zzimi = com_google_android_gms_internal_zzdyk.getPhoneNumber();
    }

    public zzf(@NonNull zzdyo com_google_android_gms_internal_zzdyo) {
        zzbq.checkNotNull(com_google_android_gms_internal_zzdyo);
        this.zzauv = com_google_android_gms_internal_zzdyo.zzbrx();
        this.zzmcu = zzbq.zzgm(com_google_android_gms_internal_zzdyo.getProviderId());
        this.zzegt = com_google_android_gms_internal_zzdyo.getDisplayName();
        Uri photoUri = com_google_android_gms_internal_zzdyo.getPhotoUri();
        if (photoUri != null) {
            this.zzmdx = photoUri.toString();
            this.zzmea = photoUri;
        }
        this.zzegs = com_google_android_gms_internal_zzdyo.getEmail();
        this.zzimi = com_google_android_gms_internal_zzdyo.getPhoneNumber();
        this.zzmgh = false;
        this.zzmgp = com_google_android_gms_internal_zzdyo.getRawUserInfo();
    }

    private zzf(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, boolean z, @Nullable String str7) {
        this.zzauv = str;
        this.zzmcu = str2;
        this.zzegs = str3;
        this.zzimi = str4;
        this.zzegt = str5;
        this.zzmdx = str6;
        this.zzmgh = z;
        this.zzmgp = str7;
    }

    @Nullable
    public static zzf zzpb(@NonNull String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new zzf(jSONObject.optString("userId"), jSONObject.optString("providerId"), jSONObject.optString("email"), jSONObject.optString("phoneNumber"), jSONObject.optString("displayName"), jSONObject.optString("photoUrl"), jSONObject.optBoolean("isEmailVerified"), jSONObject.optString("rawUserInfo"));
        } catch (Throwable e) {
            Log.d("DefaultAuthUserInfo", "Failed to unpack UserInfo from JSON");
            throw new zzdvu(e);
        }
    }

    @Nullable
    public final String getDisplayName() {
        return this.zzegt;
    }

    @Nullable
    public final String getEmail() {
        return this.zzegs;
    }

    @Nullable
    public final String getPhoneNumber() {
        return this.zzimi;
    }

    @Nullable
    public final Uri getPhotoUrl() {
        if (!TextUtils.isEmpty(this.zzmdx) && this.zzmea == null) {
            this.zzmea = Uri.parse(this.zzmdx);
        }
        return this.zzmea;
    }

    @NonNull
    public final String getProviderId() {
        return this.zzmcu;
    }

    @Nullable
    public final String getRawUserInfo() {
        return this.zzmgp;
    }

    @NonNull
    public final String getUid() {
        return this.zzauv;
    }

    public final boolean isEmailVerified() {
        return this.zzmgh;
    }

    @Nullable
    public final String zzabg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.zzauv);
            jSONObject.putOpt("providerId", this.zzmcu);
            jSONObject.putOpt("displayName", this.zzegt);
            jSONObject.putOpt("photoUrl", this.zzmdx);
            jSONObject.putOpt("email", this.zzegs);
            jSONObject.putOpt("phoneNumber", this.zzimi);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.zzmgh));
            jSONObject.putOpt("rawUserInfo", this.zzmgp);
            return jSONObject.toString();
        } catch (Throwable e) {
            Log.d("DefaultAuthUserInfo", "Failed to jsonify this object");
            throw new zzdvu(e);
        }
    }
}
