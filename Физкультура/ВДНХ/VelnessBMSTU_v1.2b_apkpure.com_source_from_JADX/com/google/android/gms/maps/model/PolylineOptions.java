package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions extends zzbfm {
    public static final Creator<PolylineOptions> CREATOR = new zzl();
    private int mColor;
    private float zzium;
    private boolean zziun;
    private boolean zziuo;
    private float zziut;
    private final List<LatLng> zzivo;
    private boolean zzivq;
    @NonNull
    private Cap zzivt;
    @NonNull
    private Cap zzivu;
    private int zzivv;
    @Nullable
    private List<PatternItem> zzivw;

    public PolylineOptions() {
        this.zziut = 10.0f;
        this.mColor = ViewCompat.MEASURED_STATE_MASK;
        this.zzium = 0.0f;
        this.zziun = true;
        this.zzivq = false;
        this.zziuo = false;
        this.zzivt = new ButtCap();
        this.zzivu = new ButtCap();
        this.zzivv = 0;
        this.zzivw = null;
        this.zzivo = new ArrayList();
    }

    PolylineOptions(List list, float f, int i, float f2, boolean z, boolean z2, boolean z3, @Nullable Cap cap, @Nullable Cap cap2, int i2, @Nullable List<PatternItem> list2) {
        this.zziut = 10.0f;
        this.mColor = ViewCompat.MEASURED_STATE_MASK;
        this.zzium = 0.0f;
        this.zziun = true;
        this.zzivq = false;
        this.zziuo = false;
        this.zzivt = new ButtCap();
        this.zzivu = new ButtCap();
        this.zzivv = 0;
        this.zzivw = null;
        this.zzivo = list;
        this.zziut = f;
        this.mColor = i;
        this.zzium = f2;
        this.zziun = z;
        this.zzivq = z2;
        this.zziuo = z3;
        if (cap != null) {
            this.zzivt = cap;
        }
        if (cap2 != null) {
            this.zzivu = cap2;
        }
        this.zzivv = i2;
        this.zzivw = list2;
    }

    public final PolylineOptions add(LatLng latLng) {
        this.zzivo.add(latLng);
        return this;
    }

    public final PolylineOptions add(LatLng... latLngArr) {
        this.zzivo.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public final PolylineOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.zzivo.add(add);
        }
        return this;
    }

    public final PolylineOptions clickable(boolean z) {
        this.zziuo = z;
        return this;
    }

    public final PolylineOptions color(int i) {
        this.mColor = i;
        return this;
    }

    public final PolylineOptions endCap(@NonNull Cap cap) {
        this.zzivu = (Cap) zzbq.checkNotNull(cap, "endCap must not be null");
        return this;
    }

    public final PolylineOptions geodesic(boolean z) {
        this.zzivq = z;
        return this;
    }

    public final int getColor() {
        return this.mColor;
    }

    @NonNull
    public final Cap getEndCap() {
        return this.zzivu;
    }

    public final int getJointType() {
        return this.zzivv;
    }

    @Nullable
    public final List<PatternItem> getPattern() {
        return this.zzivw;
    }

    public final List<LatLng> getPoints() {
        return this.zzivo;
    }

    @NonNull
    public final Cap getStartCap() {
        return this.zzivt;
    }

    public final float getWidth() {
        return this.zziut;
    }

    public final float getZIndex() {
        return this.zzium;
    }

    public final boolean isClickable() {
        return this.zziuo;
    }

    public final boolean isGeodesic() {
        return this.zzivq;
    }

    public final boolean isVisible() {
        return this.zziun;
    }

    public final PolylineOptions jointType(int i) {
        this.zzivv = i;
        return this;
    }

    public final PolylineOptions pattern(@Nullable List<PatternItem> list) {
        this.zzivw = list;
        return this;
    }

    public final PolylineOptions startCap(@NonNull Cap cap) {
        this.zzivt = (Cap) zzbq.checkNotNull(cap, "startCap must not be null");
        return this;
    }

    public final PolylineOptions visible(boolean z) {
        this.zziun = z;
        return this;
    }

    public final PolylineOptions width(float f) {
        this.zziut = f;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 2, getPoints(), false);
        zzbfp.zza(parcel, 3, getWidth());
        zzbfp.zzc(parcel, 4, getColor());
        zzbfp.zza(parcel, 5, getZIndex());
        zzbfp.zza(parcel, 6, isVisible());
        zzbfp.zza(parcel, 7, isGeodesic());
        zzbfp.zza(parcel, 8, isClickable());
        zzbfp.zza(parcel, 9, getStartCap(), i, false);
        zzbfp.zza(parcel, 10, getEndCap(), i, false);
        zzbfp.zzc(parcel, 11, getJointType());
        zzbfp.zzc(parcel, 12, getPattern(), false);
        zzbfp.zzai(parcel, zze);
    }

    public final PolylineOptions zIndex(float f) {
        this.zzium = f;
        return this;
    }
}
