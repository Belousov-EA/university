package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.maps.model.internal.zza;

public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;
    private static zza zziud;

    private BitmapDescriptorFactory() {
    }

    public static BitmapDescriptor defaultMarker() {
        try {
            return new BitmapDescriptor(zzawe().zzawg());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor defaultMarker(float f) {
        try {
            return new BitmapDescriptor(zzawe().zze(f));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromAsset(String str) {
        try {
            return new BitmapDescriptor(zzawe().zzin(str));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        try {
            return new BitmapDescriptor(zzawe().zzd(bitmap));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromFile(String str) {
        try {
            return new BitmapDescriptor(zzawe().zzio(str));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromPath(String str) {
        try {
            return new BitmapDescriptor(zzawe().zzip(str));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromResource(int i) {
        try {
            return new BitmapDescriptor(zzawe().zzea(i));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static void zza(zza com_google_android_gms_maps_model_internal_zza) {
        if (zziud == null) {
            zziud = (zza) zzbq.checkNotNull(com_google_android_gms_maps_model_internal_zza);
        }
    }

    private static zza zzawe() {
        return (zza) zzbq.checkNotNull(zziud, "IBitmapDescriptorFactory is not initialized");
    }
}
