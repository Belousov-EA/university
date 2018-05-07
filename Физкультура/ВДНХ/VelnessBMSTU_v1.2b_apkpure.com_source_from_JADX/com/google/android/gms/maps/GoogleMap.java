package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import android.view.View;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.zzd;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.zzg;
import com.google.android.gms.maps.model.internal.zzj;
import com.google.android.gms.maps.model.internal.zzp;
import com.google.android.gms.maps.model.internal.zzw;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate zziqy;
    private UiSettings zziqz;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    @Deprecated
    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnCameraIdleListener {
        void onCameraIdle();
    }

    public interface OnCameraMoveCanceledListener {
        void onCameraMoveCanceled();
    }

    public interface OnCameraMoveListener {
        void onCameraMove();
    }

    public interface OnCameraMoveStartedListener {
        public static final int REASON_API_ANIMATION = 2;
        public static final int REASON_DEVELOPER_ANIMATION = 3;
        public static final int REASON_GESTURE = 1;

        void onCameraMoveStarted(int i);
    }

    public interface OnCircleClickListener {
        void onCircleClick(Circle circle);
    }

    public interface OnGroundOverlayClickListener {
        void onGroundOverlayClick(GroundOverlay groundOverlay);
    }

    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnInfoWindowCloseListener {
        void onInfoWindowClose(Marker marker);
    }

    public interface OnInfoWindowLongClickListener {
        void onInfoWindowLongClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface OnMyLocationClickListener {
        void onMyLocationClick(@NonNull Location location);
    }

    public interface OnPoiClickListener {
        void onPoiClick(PointOfInterest pointOfInterest);
    }

    public interface OnPolygonClickListener {
        void onPolygonClick(Polygon polygon);
    }

    public interface OnPolylineClickListener {
        void onPolylineClick(Polyline polyline);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    static final class zza extends zzd {
        private final CancelableCallback zzisa;

        zza(CancelableCallback cancelableCallback) {
            this.zzisa = cancelableCallback;
        }

        public final void onCancel() {
            this.zzisa.onCancel();
        }

        public final void onFinish() {
            this.zzisa.onFinish();
        }
    }

    public GoogleMap(IGoogleMapDelegate iGoogleMapDelegate) {
        this.zziqy = (IGoogleMapDelegate) zzbq.checkNotNull(iGoogleMapDelegate);
    }

    public final Circle addCircle(CircleOptions circleOptions) {
        try {
            return new Circle(this.zziqy.addCircle(circleOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        try {
            zzg addGroundOverlay = this.zziqy.addGroundOverlay(groundOverlayOptions);
            return addGroundOverlay != null ? new GroundOverlay(addGroundOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions markerOptions) {
        try {
            zzp addMarker = this.zziqy.addMarker(markerOptions);
            return addMarker != null ? new Marker(addMarker) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions polygonOptions) {
        try {
            return new Polygon(this.zziqy.addPolygon(polygonOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) {
        try {
            return new Polyline(this.zziqy.addPolyline(polylineOptions));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        try {
            zzw addTileOverlay = this.zziqy.addTileOverlay(tileOverlayOptions);
            return addTileOverlay != null ? new TileOverlay(addTileOverlay) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate) {
        try {
            this.zziqy.animateCamera(cameraUpdate.zzavz());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, int i, CancelableCallback cancelableCallback) {
        try {
            this.zziqy.animateCameraWithDurationAndCallback(cameraUpdate.zzavz(), i, cancelableCallback == null ? null : new zza(cancelableCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        try {
            this.zziqy.animateCameraWithCallback(cameraUpdate.zzavz(), cancelableCallback == null ? null : new zza(cancelableCallback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.zziqy.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.zziqy.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final IndoorBuilding getFocusedBuilding() {
        try {
            zzj focusedBuilding = this.zziqy.getFocusedBuilding();
            return focusedBuilding != null ? new IndoorBuilding(focusedBuilding) : null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.zziqy.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.zziqy.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.zziqy.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.zziqy.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.zziqy.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.zziqz == null) {
                this.zziqz = new UiSettings(this.zziqy.getUiSettings());
            }
            return this.zziqz;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.zziqy.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.zziqy.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.zziqy.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.zziqy.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate cameraUpdate) {
        try {
            this.zziqy.moveCamera(cameraUpdate.zzavz());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void resetMinMaxZoomPreference() {
        try {
            this.zziqy.resetMinMaxZoomPreference();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBuildingsEnabled(boolean z) {
        try {
            this.zziqy.setBuildingsEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setContentDescription(String str) {
        try {
            this.zziqy.setContentDescription(str);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean z) {
        try {
            return this.zziqy.setIndoorEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        if (infoWindowAdapter == null) {
            try {
                this.zziqy.setInfoWindowAdapter(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setInfoWindowAdapter(new zzg(this, infoWindowAdapter));
    }

    public final void setLatLngBoundsForCameraTarget(LatLngBounds latLngBounds) {
        try {
            this.zziqy.setLatLngBoundsForCameraTarget(latLngBounds);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setLocationSource(LocationSource locationSource) {
        if (locationSource == null) {
            try {
                this.zziqy.setLocationSource(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setLocationSource(new zzl(this, locationSource));
    }

    public final boolean setMapStyle(MapStyleOptions mapStyleOptions) {
        try {
            return this.zziqy.setMapStyle(mapStyleOptions);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMapType(int i) {
        try {
            this.zziqy.setMapType(i);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMaxZoomPreference(float f) {
        try {
            this.zziqy.setMaxZoomPreference(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMinZoomPreference(float f) {
        try {
            this.zziqy.setMinZoomPreference(f);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public final void setMyLocationEnabled(boolean z) {
        try {
            this.zziqy.setMyLocationEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        if (onCameraChangeListener == null) {
            try {
                this.zziqy.setOnCameraChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnCameraChangeListener(new zzt(this, onCameraChangeListener));
    }

    public final void setOnCameraIdleListener(OnCameraIdleListener onCameraIdleListener) {
        if (onCameraIdleListener == null) {
            try {
                this.zziqy.setOnCameraIdleListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnCameraIdleListener(new zzx(this, onCameraIdleListener));
    }

    public final void setOnCameraMoveCanceledListener(OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        if (onCameraMoveCanceledListener == null) {
            try {
                this.zziqy.setOnCameraMoveCanceledListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnCameraMoveCanceledListener(new zzw(this, onCameraMoveCanceledListener));
    }

    public final void setOnCameraMoveListener(OnCameraMoveListener onCameraMoveListener) {
        if (onCameraMoveListener == null) {
            try {
                this.zziqy.setOnCameraMoveListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnCameraMoveListener(new zzv(this, onCameraMoveListener));
    }

    public final void setOnCameraMoveStartedListener(OnCameraMoveStartedListener onCameraMoveStartedListener) {
        if (onCameraMoveStartedListener == null) {
            try {
                this.zziqy.setOnCameraMoveStartedListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnCameraMoveStartedListener(new zzu(this, onCameraMoveStartedListener));
    }

    public final void setOnCircleClickListener(OnCircleClickListener onCircleClickListener) {
        if (onCircleClickListener == null) {
            try {
                this.zziqy.setOnCircleClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnCircleClickListener(new zzo(this, onCircleClickListener));
    }

    public final void setOnGroundOverlayClickListener(OnGroundOverlayClickListener onGroundOverlayClickListener) {
        if (onGroundOverlayClickListener == null) {
            try {
                this.zziqy.setOnGroundOverlayClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnGroundOverlayClickListener(new zzn(this, onGroundOverlayClickListener));
    }

    public final void setOnIndoorStateChangeListener(OnIndoorStateChangeListener onIndoorStateChangeListener) {
        if (onIndoorStateChangeListener == null) {
            try {
                this.zziqy.setOnIndoorStateChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnIndoorStateChangeListener(new zza(this, onIndoorStateChangeListener));
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        if (onInfoWindowClickListener == null) {
            try {
                this.zziqy.setOnInfoWindowClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnInfoWindowClickListener(new zzd(this, onInfoWindowClickListener));
    }

    public final void setOnInfoWindowCloseListener(OnInfoWindowCloseListener onInfoWindowCloseListener) {
        if (onInfoWindowCloseListener == null) {
            try {
                this.zziqy.setOnInfoWindowCloseListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnInfoWindowCloseListener(new zzf(this, onInfoWindowCloseListener));
    }

    public final void setOnInfoWindowLongClickListener(OnInfoWindowLongClickListener onInfoWindowLongClickListener) {
        if (onInfoWindowLongClickListener == null) {
            try {
                this.zziqy.setOnInfoWindowLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnInfoWindowLongClickListener(new zze(this, onInfoWindowLongClickListener));
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        if (onMapClickListener == null) {
            try {
                this.zziqy.setOnMapClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnMapClickListener(new zzy(this, onMapClickListener));
    }

    public final void setOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) {
        if (onMapLoadedCallback == null) {
            try {
                this.zziqy.setOnMapLoadedCallback(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnMapLoadedCallback(new zzk(this, onMapLoadedCallback));
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        if (onMapLongClickListener == null) {
            try {
                this.zziqy.setOnMapLongClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnMapLongClickListener(new zzz(this, onMapLongClickListener));
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        if (onMarkerClickListener == null) {
            try {
                this.zziqy.setOnMarkerClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnMarkerClickListener(new zzb(this, onMarkerClickListener));
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        if (onMarkerDragListener == null) {
            try {
                this.zziqy.setOnMarkerDragListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnMarkerDragListener(new zzc(this, onMarkerDragListener));
    }

    public final void setOnMyLocationButtonClickListener(OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
        if (onMyLocationButtonClickListener == null) {
            try {
                this.zziqy.setOnMyLocationButtonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnMyLocationButtonClickListener(new zzi(this, onMyLocationButtonClickListener));
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener) {
        if (onMyLocationChangeListener == null) {
            try {
                this.zziqy.setOnMyLocationChangeListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnMyLocationChangeListener(new zzh(this, onMyLocationChangeListener));
    }

    public final void setOnMyLocationClickListener(OnMyLocationClickListener onMyLocationClickListener) {
        if (onMyLocationClickListener == null) {
            try {
                this.zziqy.setOnMyLocationClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnMyLocationClickListener(new zzj(this, onMyLocationClickListener));
    }

    public final void setOnPoiClickListener(OnPoiClickListener onPoiClickListener) {
        if (onPoiClickListener == null) {
            try {
                this.zziqy.setOnPoiClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnPoiClickListener(new zzs(this, onPoiClickListener));
    }

    public final void setOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener) {
        if (onPolygonClickListener == null) {
            try {
                this.zziqy.setOnPolygonClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnPolygonClickListener(new zzp(this, onPolygonClickListener));
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        if (onPolylineClickListener == null) {
            try {
                this.zziqy.setOnPolylineClickListener(null);
                return;
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
        this.zziqy.setOnPolylineClickListener(new zzq(this, onPolylineClickListener));
    }

    public final void setPadding(int i, int i2, int i3, int i4) {
        try {
            this.zziqy.setPadding(i, i2, i3, i4);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean z) {
        try {
            this.zziqy.setTrafficEnabled(z);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        snapshot(snapshotReadyCallback, null);
    }

    public final void snapshot(SnapshotReadyCallback snapshotReadyCallback, Bitmap bitmap) {
        try {
            this.zziqy.snapshot(new zzr(this, snapshotReadyCallback), (zzn) (bitmap != null ? zzn.zzz(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.zziqy.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
