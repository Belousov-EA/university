package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.maps.model.internal.zzaa;
import com.google.android.gms.maps.model.internal.zzz;

public final class TileOverlayOptions extends zzbfm {
    public static final Creator<TileOverlayOptions> CREATOR = new zzt();
    private float zzium;
    private boolean zziun = true;
    private float zziuv = 0.0f;
    private zzz zzivz;
    private TileProvider zziwa;
    private boolean zziwb = true;

    TileOverlayOptions(IBinder iBinder, boolean z, float f, boolean z2, float f2) {
        this.zzivz = zzaa.zzbo(iBinder);
        this.zziwa = this.zzivz == null ? null : new zzr(this);
        this.zziun = z;
        this.zzium = f;
        this.zziwb = z2;
        this.zziuv = f2;
    }

    public final TileOverlayOptions fadeIn(boolean z) {
        this.zziwb = z;
        return this;
    }

    public final boolean getFadeIn() {
        return this.zziwb;
    }

    public final TileProvider getTileProvider() {
        return this.zziwa;
    }

    public final float getTransparency() {
        return this.zziuv;
    }

    public final float getZIndex() {
        return this.zzium;
    }

    public final boolean isVisible() {
        return this.zziun;
    }

    public final TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.zziwa = tileProvider;
        this.zzivz = this.zziwa == null ? null : new zzs(this, tileProvider);
        return this;
    }

    public final TileOverlayOptions transparency(float f) {
        boolean z = f >= 0.0f && f <= 1.0f;
        zzbq.checkArgument(z, "Transparency must be in the range [0..1]");
        this.zziuv = f;
        return this;
    }

    public final TileOverlayOptions visible(boolean z) {
        this.zziun = z;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.zzivz.asBinder(), false);
        zzbfp.zza(parcel, 3, isVisible());
        zzbfp.zza(parcel, 4, getZIndex());
        zzbfp.zza(parcel, 5, getFadeIn());
        zzbfp.zza(parcel, 6, getTransparency());
        zzbfp.zzai(parcel, zze);
    }

    public final TileOverlayOptions zIndex(float f) {
        this.zzium = f;
        return this;
    }
}
