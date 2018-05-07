package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.common.api.internal.zzck;
import com.google.android.gms.common.api.internal.zzn;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.zzag;

public final class zzcfk extends zzcdt {
    private final zzcfd zzilu;

    public zzcfk(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str) {
        this(context, looper, connectionCallbacks, onConnectionFailedListener, str, zzr.zzcl(context));
    }

    public zzcfk(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, zzr com_google_android_gms_common_internal_zzr) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str, com_google_android_gms_common_internal_zzr);
        this.zzilu = new zzcfd(context, this.zzikt);
    }

    public final void disconnect() {
        synchronized (this.zzilu) {
            if (isConnected()) {
                try {
                    this.zzilu.removeAllListeners();
                    this.zzilu.zzavl();
                } catch (Throwable e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
            }
            super.disconnect();
        }
    }

    public final Location getLastLocation() throws RemoteException {
        return this.zzilu.getLastLocation();
    }

    public final void zza(long j, PendingIntent pendingIntent) throws RemoteException {
        zzakm();
        zzbq.checkNotNull(pendingIntent);
        zzbq.checkArgument(j >= 0, "detectionIntervalMillis must be >= 0");
        ((zzcez) zzakn()).zza(j, true, pendingIntent);
    }

    public final void zza(PendingIntent pendingIntent, zzceu com_google_android_gms_internal_zzceu) throws RemoteException {
        this.zzilu.zza(pendingIntent, com_google_android_gms_internal_zzceu);
    }

    public final void zza(zzck<LocationListener> com_google_android_gms_common_api_internal_zzck_com_google_android_gms_location_LocationListener, zzceu com_google_android_gms_internal_zzceu) throws RemoteException {
        this.zzilu.zza((zzck) com_google_android_gms_common_api_internal_zzck_com_google_android_gms_location_LocationListener, com_google_android_gms_internal_zzceu);
    }

    public final void zza(zzceu com_google_android_gms_internal_zzceu) throws RemoteException {
        this.zzilu.zza(com_google_android_gms_internal_zzceu);
    }

    public final void zza(zzcfo com_google_android_gms_internal_zzcfo, zzci<LocationCallback> com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationCallback, zzceu com_google_android_gms_internal_zzceu) throws RemoteException {
        synchronized (this.zzilu) {
            this.zzilu.zza(com_google_android_gms_internal_zzcfo, (zzci) com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationCallback, com_google_android_gms_internal_zzceu);
        }
    }

    public final void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzn<Status> com_google_android_gms_common_api_internal_zzn_com_google_android_gms_common_api_Status) throws RemoteException {
        zzakm();
        zzbq.checkNotNull(geofencingRequest, "geofencingRequest can't be null.");
        zzbq.checkNotNull(pendingIntent, "PendingIntent must be specified.");
        zzbq.checkNotNull(com_google_android_gms_common_api_internal_zzn_com_google_android_gms_common_api_Status, "ResultHolder not provided.");
        ((zzcez) zzakn()).zza(geofencingRequest, pendingIntent, new zzcfl(com_google_android_gms_common_api_internal_zzn_com_google_android_gms_common_api_Status));
    }

    public final void zza(LocationRequest locationRequest, PendingIntent pendingIntent, zzceu com_google_android_gms_internal_zzceu) throws RemoteException {
        this.zzilu.zza(locationRequest, pendingIntent, com_google_android_gms_internal_zzceu);
    }

    public final void zza(LocationRequest locationRequest, zzci<LocationListener> com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationListener, zzceu com_google_android_gms_internal_zzceu) throws RemoteException {
        synchronized (this.zzilu) {
            this.zzilu.zza(locationRequest, (zzci) com_google_android_gms_common_api_internal_zzci_com_google_android_gms_location_LocationListener, com_google_android_gms_internal_zzceu);
        }
    }

    public final void zza(LocationSettingsRequest locationSettingsRequest, zzn<LocationSettingsResult> com_google_android_gms_common_api_internal_zzn_com_google_android_gms_location_LocationSettingsResult, String str) throws RemoteException {
        boolean z = true;
        zzakm();
        zzbq.checkArgument(locationSettingsRequest != null, "locationSettingsRequest can't be null nor empty.");
        if (com_google_android_gms_common_api_internal_zzn_com_google_android_gms_location_LocationSettingsResult == null) {
            z = false;
        }
        zzbq.checkArgument(z, "listener can't be null.");
        ((zzcez) zzakn()).zza(locationSettingsRequest, new zzcfn(com_google_android_gms_common_api_internal_zzn_com_google_android_gms_location_LocationSettingsResult), str);
    }

    public final void zza(zzag com_google_android_gms_location_zzag, zzn<Status> com_google_android_gms_common_api_internal_zzn_com_google_android_gms_common_api_Status) throws RemoteException {
        zzakm();
        zzbq.checkNotNull(com_google_android_gms_location_zzag, "removeGeofencingRequest can't be null.");
        zzbq.checkNotNull(com_google_android_gms_common_api_internal_zzn_com_google_android_gms_common_api_Status, "ResultHolder not provided.");
        ((zzcez) zzakn()).zza(com_google_android_gms_location_zzag, new zzcfm(com_google_android_gms_common_api_internal_zzn_com_google_android_gms_common_api_Status));
    }

    public final LocationAvailability zzavk() throws RemoteException {
        return this.zzilu.zzavk();
    }

    public final void zzb(zzck<LocationCallback> com_google_android_gms_common_api_internal_zzck_com_google_android_gms_location_LocationCallback, zzceu com_google_android_gms_internal_zzceu) throws RemoteException {
        this.zzilu.zzb(com_google_android_gms_common_api_internal_zzck_com_google_android_gms_location_LocationCallback, com_google_android_gms_internal_zzceu);
    }

    public final void zzbj(boolean z) throws RemoteException {
        this.zzilu.zzbj(z);
    }

    public final void zzc(PendingIntent pendingIntent) throws RemoteException {
        zzakm();
        zzbq.checkNotNull(pendingIntent);
        ((zzcez) zzakn()).zzc(pendingIntent);
    }

    public final void zzc(Location location) throws RemoteException {
        this.zzilu.zzc(location);
    }
}
