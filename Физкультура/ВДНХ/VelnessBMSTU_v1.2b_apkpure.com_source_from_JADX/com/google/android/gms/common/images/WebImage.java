package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage extends zzbfm {
    public static final Creator<WebImage> CREATOR = new zze();
    private final int zzalv;
    private final int zzalw;
    private int zzeck;
    private final Uri zzfap;

    WebImage(int i, Uri uri, int i2, int i3) {
        this.zzeck = i;
        this.zzfap = uri;
        this.zzalv = i2;
        this.zzalw = i3;
    }

    public WebImage(Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }

    public WebImage(Uri uri, int i, int i2) throws IllegalArgumentException {
        this(1, uri, i, i2);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    public WebImage(JSONObject jSONObject) throws IllegalArgumentException {
        this(zzy(jSONObject), jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }

    private static Uri zzy(JSONObject jSONObject) {
        Uri uri = null;
        if (jSONObject.has("url")) {
            try {
                uri = Uri.parse(jSONObject.getString("url"));
            } catch (JSONException e) {
            }
        }
        return uri;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof WebImage)) {
            return false;
        }
        WebImage webImage = (WebImage) obj;
        return zzbg.equal(this.zzfap, webImage.zzfap) && this.zzalv == webImage.zzalv && this.zzalw == webImage.zzalw;
    }

    public final int getHeight() {
        return this.zzalw;
    }

    public final Uri getUrl() {
        return this.zzfap;
    }

    public final int getWidth() {
        return this.zzalv;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzfap, Integer.valueOf(this.zzalv), Integer.valueOf(this.zzalw)});
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.zzfap.toString());
            jSONObject.put("width", this.zzalv);
            jSONObject.put("height", this.zzalw);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public final String toString() {
        return String.format(Locale.US, "Image %dx%d %s", new Object[]{Integer.valueOf(this.zzalv), Integer.valueOf(this.zzalw), this.zzfap.toString()});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 1, this.zzeck);
        zzbfp.zza(parcel, 2, getUrl(), i, false);
        zzbfp.zzc(parcel, 3, getWidth());
        zzbfp.zzc(parcel, 4, getHeight());
        zzbfp.zzai(parcel, zze);
    }
}
