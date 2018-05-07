package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Patterns;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@KeepForSdkWithMembers
public class ProxyRequest extends zzbfm {
    public static final Creator<ProxyRequest> CREATOR = new zza();
    public static final int HTTP_METHOD_DELETE = 3;
    public static final int HTTP_METHOD_GET = 0;
    public static final int HTTP_METHOD_HEAD = 4;
    public static final int HTTP_METHOD_OPTIONS = 5;
    public static final int HTTP_METHOD_PATCH = 7;
    public static final int HTTP_METHOD_POST = 1;
    public static final int HTTP_METHOD_PUT = 2;
    public static final int HTTP_METHOD_TRACE = 6;
    public static final int LAST_CODE = 7;
    public static final int VERSION_CODE = 2;
    public final byte[] body;
    public final int httpMethod;
    public final long timeoutMillis;
    public final String url;
    private int versionCode;
    private Bundle zzegj;

    @KeepForSdkWithMembers
    public static class Builder {
        private long zzcvj = 3000;
        private String zzegk;
        private int zzegl = ProxyRequest.HTTP_METHOD_GET;
        private byte[] zzegm = null;
        private Bundle zzegn = new Bundle();

        public Builder(String str) {
            zzbq.zzgm(str);
            if (Patterns.WEB_URL.matcher(str).matches()) {
                this.zzegk = str;
                return;
            }
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 51).append("The supplied url [ ").append(str).append("] is not match Patterns.WEB_URL!").toString());
        }

        public ProxyRequest build() {
            if (this.zzegm == null) {
                this.zzegm = new byte[0];
            }
            return new ProxyRequest(2, this.zzegk, this.zzegl, this.zzcvj, this.zzegm, this.zzegn);
        }

        public Builder putHeader(String str, String str2) {
            zzbq.zzh(str, "Header name cannot be null or empty!");
            Bundle bundle = this.zzegn;
            if (str2 == null) {
                str2 = "";
            }
            bundle.putString(str, str2);
            return this;
        }

        public Builder setBody(byte[] bArr) {
            this.zzegm = bArr;
            return this;
        }

        public Builder setHttpMethod(int i) {
            boolean z = i >= 0 && i <= ProxyRequest.LAST_CODE;
            zzbq.checkArgument(z, "Unrecognized http method code.");
            this.zzegl = i;
            return this;
        }

        public Builder setTimeoutMillis(long j) {
            zzbq.checkArgument(j >= 0, "The specified timeout must be non-negative.");
            this.zzcvj = j;
            return this;
        }
    }

    ProxyRequest(int i, String str, int i2, long j, byte[] bArr, Bundle bundle) {
        this.versionCode = i;
        this.url = str;
        this.httpMethod = i2;
        this.timeoutMillis = j;
        this.body = bArr;
        this.zzegj = bundle;
    }

    public Map<String, String> getHeaderMap() {
        Map linkedHashMap = new LinkedHashMap(this.zzegj.size());
        for (String str : this.zzegj.keySet()) {
            linkedHashMap.put(str, this.zzegj.getString(str));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public String toString() {
        String str = this.url;
        return new StringBuilder(String.valueOf(str).length() + 42).append("ProxyRequest[ url: ").append(str).append(", method: ").append(this.httpMethod).append(" ]").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 1, this.url, false);
        zzbfp.zzc(parcel, 2, this.httpMethod);
        zzbfp.zza(parcel, 3, this.timeoutMillis);
        zzbfp.zza(parcel, 4, this.body, false);
        zzbfp.zza(parcel, 5, this.zzegj, false);
        zzbfp.zzc(parcel, 1000, this.versionCode);
        zzbfp.zzai(parcel, zze);
    }
}
