package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public final class zzceb implements FusedLocationProviderApi {
    public final PendingResult<Status> flushLocations(GoogleApiClient googleApiClient) {
        return googleApiClient.zze(new zzceg(this, googleApiClient));
    }

    public final Location getLastLocation(GoogleApiClient googleApiClient) {
        try {
            return LocationServices.zzh(googleApiClient).getLastLocation();
        } catch (Exception e) {
            return null;
        }
    }

    public final LocationAvailability getLocationAvailability(GoogleApiClient googleApiClient) {
        try {
            return LocationServices.zzh(googleApiClient).zzavk();
        } catch (Exception e) {
            return null;
        }
    }

    public final PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.zze(new zzcel(this, googleApiClient, pendingIntent));
    }

    public final PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, LocationCallback locationCallback) {
        return googleApiClient.zze(new zzced(this, googleApiClient, locationCallback));
    }

    public final PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, LocationListener locationListener) {
        return googleApiClient.zze(new zzcek(this, googleApiClient, locationListener));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
        return googleApiClient.zze(new zzcej(this, googleApiClient, locationRequest, pendingIntent));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        return googleApiClient.zze(new zzcei(this, googleApiClient, locationRequest, locationCallback, looper));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
        zzbq.checkNotNull(Looper.myLooper(), "Calling thread must be a prepared Looper thread.");
        return googleApiClient.zze(new zzcec(this, googleApiClient, locationRequest, locationListener));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
        return googleApiClient.zze(new zzceh(this, googleApiClient, locationRequest, locationListener, looper));
    }

    public final PendingResult<Status> setMockLocation(GoogleApiClient googleApiClient, Location location) {
        return googleApiClient.zze(new zzcef(this, googleApiClient, location));
    }

    public final PendingResult<Status> setMockMode(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.zze(new zzcee(this, googleApiClient, z));
    }
}
