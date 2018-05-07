package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions extends zzbfm {
    public static final Creator<PolygonOptions> CREATOR = new zzk();
    private int mFillColor;
    private int mStrokeColor;
    private float mStrokeWidth;
    private float zzium;
    private boolean zziun;
    private boolean zziuo;
    @Nullable
    private List<PatternItem> zziup;
    private final List<LatLng> zzivo;
    private final List<List<LatLng>> zzivp;
    private boolean zzivq;
    private int zzivr;

    public PolygonOptions() {
        this.mStrokeWidth = 10.0f;
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mFillColor = 0;
        this.zzium = 0.0f;
        this.zziun = true;
        this.zzivq = false;
        this.zziuo = false;
        this.zzivr = 0;
        this.zziup = null;
        this.zzivo = new ArrayList();
        this.zzivp = new ArrayList();
    }

    PolygonOptions(List<LatLng> list, List list2, float f, int i, int i2, float f2, boolean z, boolean z2, boolean z3, int i3, @Nullable List<PatternItem> list3) {
        this.mStrokeWidth = 10.0f;
        this.mStrokeColor = ViewCompat.MEASURED_STATE_MASK;
        this.mFillColor = 0;
        this.zzium = 0.0f;
        this.zziun = true;
        this.zzivq = false;
        this.zziuo = false;
        this.zzivr = 0;
        this.zziup = null;
        this.zzivo = list;
        this.zzivp = list2;
        this.mStrokeWidth = f;
        this.mStrokeColor = i;
        this.mFillColor = i2;
        this.zzium = f2;
        this.zziun = z;
        this.zzivq = z2;
        this.zziuo = z3;
        this.zzivr = i3;
        this.zziup = list3;
    }

    public final PolygonOptions add(LatLng latLng) {
        this.zzivo.add(latLng);
        return this;
    }

    public final PolygonOptions add(LatLng... latLngArr) {
        this.zzivo.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public final PolygonOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.zzivo.add(add);
        }
        return this;
    }

    public final PolygonOptions addHole(Iterable<LatLng> iterable) {
        ArrayList arrayList = new ArrayList();
        for (LatLng add : iterable) {
            arrayList.add(add);
        }
        this.zzivp.add(arrayList);
        return this;
    }

    public final PolygonOptions clickable(boolean z) {
        this.zziuo = z;
        return this;
    }

    public final PolygonOptions fillColor(int i) {
        this.mFillColor = i;
        return this;
    }

    public final PolygonOptions geodesic(boolean z) {
        this.zzivq = z;
        return this;
    }

    public final int getFillColor() {
        return this.mFillColor;
    }

    public final List<List<LatLng>> getHoles() {
        return this.zzivp;
    }

    public final List<LatLng> getPoints() {
        return this.zzivo;
    }

    public final int getStrokeColor() {
        return this.mStrokeColor;
    }

    public final int getStrokeJointType() {
        return this.zzivr;
    }

    @Nullable
    public final List<PatternItem> getStrokePattern() {
        return this.zziup;
    }

    public final float getStrokeWidth() {
        return this.mStrokeWidth;
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

    public final PolygonOptions strokeColor(int i) {
        this.mStrokeColor = i;
        return this;
    }

    public final PolygonOptions strokeJointType(int i) {
        this.zzivr = i;
        return this;
    }

    public final PolygonOptions strokePattern(@Nullable List<PatternItem> list) {
        this.zziup = list;
        return this;
    }

    public final PolygonOptions strokeWidth(float f) {
        this.mStrokeWidth = f;
        return this;
    }

    public final PolygonOptions visible(boolean z) {
        this.zziun = z;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zzc(parcel, 2, getPoints(), false);
        zzbfp.zzd(parcel, 3, this.zzivp, false);
        zzbfp.zza(parcel, 4, getStrokeWidth());
        zzbfp.zzc(parcel, 5, getStrokeColor());
        zzbfp.zzc(parcel, 6, getFillColor());
        zzbfp.zza(parcel, 7, getZIndex());
        zzbfp.zza(parcel, 8, isVisible());
        zzbfp.zza(parcel, 9, isGeodesic());
        zzbfp.zza(parcel, 10, isClickable());
        zzbfp.zzc(parcel, 11, getStrokeJointType());
        zzbfp.zzc(parcel, 12, getStrokePattern(), false);
        zzbfp.zzai(parcel, zze);
    }

    public final PolygonOptions zIndex(float f) {
        this.zzium = f;
        return this;
    }
}
