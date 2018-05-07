package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzh;
import org.json.JSONObject;

public final class zzdym extends zzbfm {
    public static final Creator<zzdym> CREATOR = new zzdyn();
    private String zzmcv;
    private String zzmeo;
    private Long zzmgl;
    private String zzmgm;
    private Long zzmgn;

    public zzdym() {
        this.zzmgn = Long.valueOf(System.currentTimeMillis());
    }

    zzdym(String str, String str2, Long l, String str3, Long l2) {
        this.zzmeo = str;
        this.zzmcv = str2;
        this.zzmgl = l;
        this.zzmgm = str3;
        this.zzmgn = l2;
    }

    public static zzdym zzpa(@NonNull String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzdym com_google_android_gms_internal_zzdym = new zzdym();
            com_google_android_gms_internal_zzdym.zzmeo = jSONObject.optString("refresh_token", null);
            com_google_android_gms_internal_zzdym.zzmcv = jSONObject.optString("access_token", null);
            com_google_android_gms_internal_zzdym.zzmgl = Long.valueOf(jSONObject.optLong("expires_in"));
            com_google_android_gms_internal_zzdym.zzmgm = jSONObject.optString("token_type", null);
            com_google_android_gms_internal_zzdym.zzmgn = Long.valueOf(jSONObject.optLong("issued_at"));
            return com_google_android_gms_internal_zzdym;
        } catch (Throwable e) {
            Log.d("GetTokenResponse", "Failed to read GetTokenResponse from JSONObject");
            throw new zzdvu(e);
        }
    }

    public final String getAccessToken() {
        return this.zzmcv;
    }

    public final boolean isValid() {
        return zzh.zzamg().currentTimeMillis() + 300000 < this.zzmgn.longValue() + (this.zzmgl.longValue() * 1000);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.zzmeo, false);
        zzbfp.zza(parcel, 3, this.zzmcv, false);
        zzbfp.zza(parcel, 4, Long.valueOf(zzbrv()), false);
        zzbfp.zza(parcel, 5, this.zzmgm, false);
        zzbfp.zza(parcel, 6, Long.valueOf(this.zzmgn.longValue()), false);
        zzbfp.zzai(parcel, zze);
    }

    public final String zzabg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("refresh_token", this.zzmeo);
            jSONObject.put("access_token", this.zzmcv);
            jSONObject.put("expires_in", this.zzmgl);
            jSONObject.put("token_type", this.zzmgm);
            jSONObject.put("issued_at", this.zzmgn);
            return jSONObject.toString();
        } catch (Throwable e) {
            Log.d("GetTokenResponse", "Failed to convert GetTokenResponse to JSON");
            throw new zzdvu(e);
        }
    }

    public final String zzbru() {
        return this.zzmeo;
    }

    public final long zzbrv() {
        return this.zzmgl == null ? 0 : this.zzmgl.longValue();
    }

    public final long zzbrw() {
        return this.zzmgn.longValue();
    }

    public final void zzoz(@NonNull String str) {
        this.zzmeo = zzbq.zzgm(str);
    }
}
