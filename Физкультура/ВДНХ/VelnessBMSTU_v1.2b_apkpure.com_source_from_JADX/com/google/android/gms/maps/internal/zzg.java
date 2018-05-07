package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import com.google.android.gms.maps.model.internal.IPolylineDelegate.zza;
import com.google.android.gms.maps.model.internal.zzd;
import com.google.android.gms.maps.model.internal.zze;
import com.google.android.gms.maps.model.internal.zzh;
import com.google.android.gms.maps.model.internal.zzj;
import com.google.android.gms.maps.model.internal.zzk;
import com.google.android.gms.maps.model.internal.zzp;
import com.google.android.gms.maps.model.internal.zzq;
import com.google.android.gms.maps.model.internal.zzs;
import com.google.android.gms.maps.model.internal.zzt;
import com.google.android.gms.maps.model.internal.zzw;
import com.google.android.gms.maps.model.internal.zzx;

public final class zzg extends zzeu implements IGoogleMapDelegate {
    zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IGoogleMapDelegate");
    }

    public final zzd addCircle(CircleOptions circleOptions) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) circleOptions);
        zzbe = zza(35, zzbe);
        zzd zzbg = zze.zzbg(zzbe.readStrongBinder());
        zzbe.recycle();
        return zzbg;
    }

    public final com.google.android.gms.maps.model.internal.zzg addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) groundOverlayOptions);
        zzbe = zza(12, zzbe);
        com.google.android.gms.maps.model.internal.zzg zzbh = zzh.zzbh(zzbe.readStrongBinder());
        zzbe.recycle();
        return zzbh;
    }

    public final zzp addMarker(MarkerOptions markerOptions) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) markerOptions);
        zzbe = zza(11, zzbe);
        zzp zzbk = zzq.zzbk(zzbe.readStrongBinder());
        zzbe.recycle();
        return zzbk;
    }

    public final zzs addPolygon(PolygonOptions polygonOptions) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) polygonOptions);
        zzbe = zza(10, zzbe);
        zzs zzbl = zzt.zzbl(zzbe.readStrongBinder());
        zzbe.recycle();
        return zzbl;
    }

    public final IPolylineDelegate addPolyline(PolylineOptions polylineOptions) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) polylineOptions);
        zzbe = zza(9, zzbe);
        IPolylineDelegate zzbm = zza.zzbm(zzbe.readStrongBinder());
        zzbe.recycle();
        return zzbm;
    }

    public final zzw addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) tileOverlayOptions);
        zzbe = zza(13, zzbe);
        zzw zzbn = zzx.zzbn(zzbe.readStrongBinder());
        zzbe.recycle();
        return zzbn;
    }

    public final void animateCamera(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzb(5, zzbe);
    }

    public final void animateCameraWithCallback(IObjectWrapper iObjectWrapper, zzc com_google_android_gms_maps_internal_zzc) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzc);
        zzb(6, zzbe);
    }

    public final void animateCameraWithDurationAndCallback(IObjectWrapper iObjectWrapper, int i, zzc com_google_android_gms_maps_internal_zzc) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzbe.writeInt(i);
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzc);
        zzb(7, zzbe);
    }

    public final void clear() throws RemoteException {
        zzb(14, zzbe());
    }

    public final CameraPosition getCameraPosition() throws RemoteException {
        Parcel zza = zza(1, zzbe());
        CameraPosition cameraPosition = (CameraPosition) zzew.zza(zza, CameraPosition.CREATOR);
        zza.recycle();
        return cameraPosition;
    }

    public final zzj getFocusedBuilding() throws RemoteException {
        Parcel zza = zza(44, zzbe());
        zzj zzbi = zzk.zzbi(zza.readStrongBinder());
        zza.recycle();
        return zzbi;
    }

    public final void getMapAsync(zzap com_google_android_gms_maps_internal_zzap) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzap);
        zzb(53, zzbe);
    }

    public final int getMapType() throws RemoteException {
        Parcel zza = zza(15, zzbe());
        int readInt = zza.readInt();
        zza.recycle();
        return readInt;
    }

    public final float getMaxZoomLevel() throws RemoteException {
        Parcel zza = zza(2, zzbe());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final float getMinZoomLevel() throws RemoteException {
        Parcel zza = zza(3, zzbe());
        float readFloat = zza.readFloat();
        zza.recycle();
        return readFloat;
    }

    public final Location getMyLocation() throws RemoteException {
        Parcel zza = zza(23, zzbe());
        Location location = (Location) zzew.zza(zza, Location.CREATOR);
        zza.recycle();
        return location;
    }

    public final IProjectionDelegate getProjection() throws RemoteException {
        IProjectionDelegate iProjectionDelegate;
        Parcel zza = zza(26, zzbe());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            iProjectionDelegate = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IProjectionDelegate");
            iProjectionDelegate = queryLocalInterface instanceof IProjectionDelegate ? (IProjectionDelegate) queryLocalInterface : new zzbr(readStrongBinder);
        }
        zza.recycle();
        return iProjectionDelegate;
    }

    public final IUiSettingsDelegate getUiSettings() throws RemoteException {
        IUiSettingsDelegate iUiSettingsDelegate;
        Parcel zza = zza(25, zzbe());
        IBinder readStrongBinder = zza.readStrongBinder();
        if (readStrongBinder == null) {
            iUiSettingsDelegate = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            iUiSettingsDelegate = queryLocalInterface instanceof IUiSettingsDelegate ? (IUiSettingsDelegate) queryLocalInterface : new zzbx(readStrongBinder);
        }
        zza.recycle();
        return iUiSettingsDelegate;
    }

    public final boolean isBuildingsEnabled() throws RemoteException {
        Parcel zza = zza(40, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isIndoorEnabled() throws RemoteException {
        Parcel zza = zza(19, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isMyLocationEnabled() throws RemoteException {
        Parcel zza = zza(21, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final boolean isTrafficEnabled() throws RemoteException {
        Parcel zza = zza(17, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }

    public final void moveCamera(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzb(4, zzbe);
    }

    public final void onCreate(Bundle bundle) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) bundle);
        zzb(54, zzbe);
    }

    public final void onDestroy() throws RemoteException {
        zzb(57, zzbe());
    }

    public final void onEnterAmbient(Bundle bundle) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) bundle);
        zzb(81, zzbe);
    }

    public final void onExitAmbient() throws RemoteException {
        zzb(82, zzbe());
    }

    public final void onLowMemory() throws RemoteException {
        zzb(58, zzbe());
    }

    public final void onPause() throws RemoteException {
        zzb(56, zzbe());
    }

    public final void onResume() throws RemoteException {
        zzb(55, zzbe());
    }

    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) bundle);
        zzbe = zza(60, zzbe);
        if (zzbe.readInt() != 0) {
            bundle.readFromParcel(zzbe);
        }
        zzbe.recycle();
    }

    public final void onStart() throws RemoteException {
        zzb(101, zzbe());
    }

    public final void onStop() throws RemoteException {
        zzb(102, zzbe());
    }

    public final void resetMinMaxZoomPreference() throws RemoteException {
        zzb(94, zzbe());
    }

    public final void setBuildingsEnabled(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(41, zzbe);
    }

    public final void setContentDescription(String str) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeString(str);
        zzb(61, zzbe);
    }

    public final boolean setIndoorEnabled(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzbe = zza(20, zzbe);
        boolean zza = zzew.zza(zzbe);
        zzbe.recycle();
        return zza;
    }

    public final void setInfoWindowAdapter(zzh com_google_android_gms_maps_internal_zzh) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzh);
        zzb(33, zzbe);
    }

    public final void setLatLngBoundsForCameraTarget(LatLngBounds latLngBounds) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) latLngBounds);
        zzb(95, zzbe);
    }

    public final void setLocationSource(ILocationSourceDelegate iLocationSourceDelegate) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) iLocationSourceDelegate);
        zzb(24, zzbe);
    }

    public final boolean setMapStyle(MapStyleOptions mapStyleOptions) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (Parcelable) mapStyleOptions);
        zzbe = zza(91, zzbe);
        boolean zza = zzew.zza(zzbe);
        zzbe.recycle();
        return zza;
    }

    public final void setMapType(int i) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeInt(i);
        zzb(16, zzbe);
    }

    public final void setMaxZoomPreference(float f) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzb(93, zzbe);
    }

    public final void setMinZoomPreference(float f) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeFloat(f);
        zzb(92, zzbe);
    }

    public final void setMyLocationEnabled(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(22, zzbe);
    }

    public final void setOnCameraChangeListener(zzl com_google_android_gms_maps_internal_zzl) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzl);
        zzb(27, zzbe);
    }

    public final void setOnCameraIdleListener(zzn com_google_android_gms_maps_internal_zzn) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzn);
        zzb(99, zzbe);
    }

    public final void setOnCameraMoveCanceledListener(zzp com_google_android_gms_maps_internal_zzp) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzp);
        zzb(98, zzbe);
    }

    public final void setOnCameraMoveListener(zzr com_google_android_gms_maps_internal_zzr) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzr);
        zzb(97, zzbe);
    }

    public final void setOnCameraMoveStartedListener(zzt com_google_android_gms_maps_internal_zzt) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzt);
        zzb(96, zzbe);
    }

    public final void setOnCircleClickListener(zzv com_google_android_gms_maps_internal_zzv) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzv);
        zzb(89, zzbe);
    }

    public final void setOnGroundOverlayClickListener(zzx com_google_android_gms_maps_internal_zzx) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzx);
        zzb(83, zzbe);
    }

    public final void setOnIndoorStateChangeListener(zzz com_google_android_gms_maps_internal_zzz) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzz);
        zzb(45, zzbe);
    }

    public final void setOnInfoWindowClickListener(zzab com_google_android_gms_maps_internal_zzab) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzab);
        zzb(32, zzbe);
    }

    public final void setOnInfoWindowCloseListener(zzad com_google_android_gms_maps_internal_zzad) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzad);
        zzb(86, zzbe);
    }

    public final void setOnInfoWindowLongClickListener(zzaf com_google_android_gms_maps_internal_zzaf) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzaf);
        zzb(84, zzbe);
    }

    public final void setOnMapClickListener(zzaj com_google_android_gms_maps_internal_zzaj) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzaj);
        zzb(28, zzbe);
    }

    public final void setOnMapLoadedCallback(zzal com_google_android_gms_maps_internal_zzal) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzal);
        zzb(42, zzbe);
    }

    public final void setOnMapLongClickListener(zzan com_google_android_gms_maps_internal_zzan) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzan);
        zzb(29, zzbe);
    }

    public final void setOnMarkerClickListener(zzar com_google_android_gms_maps_internal_zzar) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzar);
        zzb(30, zzbe);
    }

    public final void setOnMarkerDragListener(zzat com_google_android_gms_maps_internal_zzat) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzat);
        zzb(31, zzbe);
    }

    public final void setOnMyLocationButtonClickListener(zzav com_google_android_gms_maps_internal_zzav) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzav);
        zzb(37, zzbe);
    }

    public final void setOnMyLocationChangeListener(zzax com_google_android_gms_maps_internal_zzax) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzax);
        zzb(36, zzbe);
    }

    public final void setOnMyLocationClickListener(zzaz com_google_android_gms_maps_internal_zzaz) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzaz);
        zzb(107, zzbe);
    }

    public final void setOnPoiClickListener(zzbb com_google_android_gms_maps_internal_zzbb) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzbb);
        zzb(80, zzbe);
    }

    public final void setOnPolygonClickListener(zzbd com_google_android_gms_maps_internal_zzbd) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzbd);
        zzb(85, zzbe);
    }

    public final void setOnPolylineClickListener(zzbf com_google_android_gms_maps_internal_zzbf) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzbf);
        zzb(87, zzbe);
    }

    public final void setPadding(int i, int i2, int i3, int i4) throws RemoteException {
        Parcel zzbe = zzbe();
        zzbe.writeInt(i);
        zzbe.writeInt(i2);
        zzbe.writeInt(i3);
        zzbe.writeInt(i4);
        zzb(39, zzbe);
    }

    public final void setTrafficEnabled(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(18, zzbe);
    }

    public final void setWatermarkEnabled(boolean z) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, z);
        zzb(51, zzbe);
    }

    public final void snapshot(zzbs com_google_android_gms_maps_internal_zzbs, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzbs);
        zzew.zza(zzbe, (IInterface) iObjectWrapper);
        zzb(38, zzbe);
    }

    public final void snapshotForTest(zzbs com_google_android_gms_maps_internal_zzbs) throws RemoteException {
        Parcel zzbe = zzbe();
        zzew.zza(zzbe, (IInterface) com_google_android_gms_maps_internal_zzbs);
        zzb(71, zzbe);
    }

    public final void stopAnimation() throws RemoteException {
        zzb(8, zzbe());
    }

    public final boolean useViewLifecycleWhenInFragment() throws RemoteException {
        Parcel zza = zza(59, zzbe());
        boolean zza2 = zzew.zza(zza);
        zza.recycle();
        return zza2;
    }
}
