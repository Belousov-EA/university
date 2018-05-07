package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions extends zzbfm implements ReflectedParcelable {
    public static final Creator<StreetViewPanoramaOptions> CREATOR = new zzai();
    private Boolean zzisc;
    private Boolean zzisi = Boolean.valueOf(true);
    private StreetViewPanoramaCamera zzitn;
    private String zzito;
    private LatLng zzitp;
    private Integer zzitq;
    private Boolean zzitr = Boolean.valueOf(true);
    private Boolean zzits = Boolean.valueOf(true);
    private Boolean zzitt = Boolean.valueOf(true);

    StreetViewPanoramaOptions(StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b, byte b2, byte b3, byte b4, byte b5) {
        this.zzitn = streetViewPanoramaCamera;
        this.zzitp = latLng;
        this.zzitq = num;
        this.zzito = str;
        this.zzitr = zza.zza(b);
        this.zzisi = zza.zza(b2);
        this.zzits = zza.zza(b3);
        this.zzitt = zza.zza(b4);
        this.zzisc = zza.zza(b5);
    }

    public final Boolean getPanningGesturesEnabled() {
        return this.zzits;
    }

    public final String getPanoramaId() {
        return this.zzito;
    }

    public final LatLng getPosition() {
        return this.zzitp;
    }

    public final Integer getRadius() {
        return this.zzitq;
    }

    public final Boolean getStreetNamesEnabled() {
        return this.zzitt;
    }

    public final StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.zzitn;
    }

    public final Boolean getUseViewLifecycleInFragment() {
        return this.zzisc;
    }

    public final Boolean getUserNavigationEnabled() {
        return this.zzitr;
    }

    public final Boolean getZoomGesturesEnabled() {
        return this.zzisi;
    }

    public final StreetViewPanoramaOptions panningGesturesEnabled(boolean z) {
        this.zzits = Boolean.valueOf(z);
        return this;
    }

    public final StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.zzitn = streetViewPanoramaCamera;
        return this;
    }

    public final StreetViewPanoramaOptions panoramaId(String str) {
        this.zzito = str;
        return this;
    }

    public final StreetViewPanoramaOptions position(LatLng latLng) {
        this.zzitp = latLng;
        return this;
    }

    public final StreetViewPanoramaOptions position(LatLng latLng, Integer num) {
        this.zzitp = latLng;
        this.zzitq = num;
        return this;
    }

    public final StreetViewPanoramaOptions streetNamesEnabled(boolean z) {
        this.zzitt = Boolean.valueOf(z);
        return this;
    }

    public final String toString() {
        return zzbg.zzx(this).zzg("PanoramaId", this.zzito).zzg("Position", this.zzitp).zzg("Radius", this.zzitq).zzg("StreetViewPanoramaCamera", this.zzitn).zzg("UserNavigationEnabled", this.zzitr).zzg("ZoomGesturesEnabled", this.zzisi).zzg("PanningGesturesEnabled", this.zzits).zzg("StreetNamesEnabled", this.zzitt).zzg("UseViewLifecycleInFragment", this.zzisc).toString();
    }

    public final StreetViewPanoramaOptions useViewLifecycleInFragment(boolean z) {
        this.zzisc = Boolean.valueOf(z);
        return this;
    }

    public final StreetViewPanoramaOptions userNavigationEnabled(boolean z) {
        this.zzitr = Boolean.valueOf(z);
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbfp.zze(parcel);
        zzbfp.zza(parcel, 2, getStreetViewPanoramaCamera(), i, false);
        zzbfp.zza(parcel, 3, getPanoramaId(), false);
        zzbfp.zza(parcel, 4, getPosition(), i, false);
        zzbfp.zza(parcel, 5, getRadius(), false);
        zzbfp.zza(parcel, 6, zza.zzb(this.zzitr));
        zzbfp.zza(parcel, 7, zza.zzb(this.zzisi));
        zzbfp.zza(parcel, 8, zza.zzb(this.zzits));
        zzbfp.zza(parcel, 9, zza.zzb(this.zzitt));
        zzbfp.zza(parcel, 10, zza.zzb(this.zzisc));
        zzbfp.zzai(parcel, zze);
    }

    public final StreetViewPanoramaOptions zoomGesturesEnabled(boolean z) {
        this.zzisi = Boolean.valueOf(z);
        return this;
    }
}
