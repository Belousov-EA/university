package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper.zza;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

public final class GroundOverlayOptions extends zzbfm {
    public static final Creator<GroundOverlayOptions> CREATOR = new zzd();
    public static final float NO_DIMENSION = -1.0f;
    private LatLngBounds zziqr;
    private float zziuh;
    private float zzium;
    private boolean zziun = true;
    private boolean zziuo = false;
    @NonNull
    private BitmapDescriptor zziur;
    private LatLng zzius;
    private float zziut;
    private float zziuu;
    private float zziuv = 0.0f;
    private float zziuw = 0.5f;
    private float zziux = 0.5f;

    GroundOverlayOptions(IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7, boolean z2) {
        this.zziur = new BitmapDescriptor(zza.zzaq(iBinder));
        this.zzius = latLng;
        this.zziut = f;
        this.zziuu = f2;
        this.zziqr = latLngBounds;
        this.zziuh = f3;
        this.zzium = f4;
        this.zziun = z;
        this.zziuv = f5;
        this.zziuw = f6;
        this.zziux = f7;
        this.zziuo = z2;
    }

    private final GroundOverlayOptions zza(LatLng latLng, float f, float f2) {
        this.zzius = latLng;
        this.zziut = f;
        this.zziuu = f2;
        return this;
    }

    public final GroundOverlayOptions anchor(float f, float f2) {
        this.zziuw = f;
        this.zziux = f2;
        return this;
    }

    public final GroundOverlayOptions bearing(float f) {
        this.zziuh = ((f % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public final GroundOverlayOptions clickable(boolean z) {
        this.zziuo = z;
        return this;
    }

    public final float getAnchorU() {
        return this.zziuw;
    }

    public final float getAnchorV() {
        return this.zziux;
    }

    public final float getBearing() {
        return this.zziuh;
    }

    public final LatLngBounds getBounds() {
        return this.zziqr;
    }

    public final float getHeight() {
        return this.zziuu;
    }

    public final BitmapDescriptor getImage() {
        return this.zziur;
    }

    public final LatLng getLocation() {
        return this.zzius;
    }

    public final float getTransparency() {
        return this.zziuv;
    }

    public final float getWidth() {
        return this.zziut;
    }

    public final float getZIndex() {
        return this.zzium;
    }

    public final GroundOverlayOptions image(@NonNull BitmapDescriptor bitmapDescriptor) {
        zzbq.checkNotNull(bitmapDescriptor, "imageDescriptor must not be null");
        this.zziur = bitmapDescriptor;
        return this;
    }

    public final boolean isClickable() {
        return this.zziuo;
    }

    public final boolean isVisible() {
        return this.zziun;
    }

    public final GroundOverlayOptions position(LatLng latLng, float f) {
        boolean z = true;
        zzbq.zza(this.zziqr == null, (Object) "Position has already been set using positionFromBounds");
        zzbq.checkArgument(latLng != null, "Location must be specified");
        if (f < 0.0f) {
            z = false;
        }
        zzbq.checkArgument(z, "Width must be non-negative");
        return zza(latLng, f, NO_DIMENSION);
    }

    public final GroundOverlayOptions position(LatLng latLng, float f, float f2) {
        boolean z = true;
        zzbq.zza(this.zziqr == null, (Object) "Position has already been set using positionFromBounds");
        zzbq.checkArgument(latLng != null, "Location must be specified");
        zzbq.checkArgument(f >= 0.0f, "Width must be non-negative");
        if (f2 < 0.0f) {
            z = false;
        }
        zzbq.checkArgument(z, "Height must be non-negative");
        return zza(latLng, f, f2);
    }

    public final GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        boolean z = this.zzius == null;
        String valueOf = String.valueOf(this.zzius);
        zzbq.zza(z, new StringBuilder(String.valueOf(valueOf).length() + 46).append("Position has already been set using position: ").append(valueOf).toString());
        this.zziqr = latLngBounds;
        return this;
    }

    public final GroundOverlayOptions transparency(float f) {
        boolean z = f >= 0.0f && f <= 1.0f;
        zzbq.checkArgument(z, "Transparency must be in the range [0..1]");
        this.zziuv = f;
        return this;
    }

    public final GroundOverlayOptions visible(boolean z) {
        this.zziun = z;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, this.zziur.zzavz().asBinder(), false);
        zzbfp.zza(parcel, 3, getLocation(), i, false);
        zzbfp.zza(parcel, 4, getWidth());
        zzbfp.zza(parcel, 5, getHeight());
        zzbfp.zza(parcel, 6, getBounds(), i, false);
        zzbfp.zza(parcel, 7, getBearing());
        zzbfp.zza(parcel, 8, getZIndex());
        zzbfp.zza(parcel, 9, isVisible());
        zzbfp.zza(parcel, 10, getTransparency());
        zzbfp.zza(parcel, 11, getAnchorU());
        zzbfp.zza(parcel, 12, getAnchorV());
        zzbfp.zza(parcel, 13, isClickable());
        zzbfp.zzai(parcel, zze);
    }

    public final GroundOverlayOptions zIndex(float f) {
        this.zzium = f;
        return this;
    }
}
