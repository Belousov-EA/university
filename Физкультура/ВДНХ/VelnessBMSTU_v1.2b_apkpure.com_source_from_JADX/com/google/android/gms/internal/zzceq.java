package com.google.android.gms.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GeofencingRequest.Builder;
import com.google.android.gms.location.zzag;
import java.util.List;

public final class zzceq implements GeofencingApi {
    private final PendingResult<Status> zza(GoogleApiClient googleApiClient, zzag com_google_android_gms_location_zzag) {
        return googleApiClient.zze(new zzces(this, googleApiClient, com_google_android_gms_location_zzag));
    }

    public final PendingResult<Status> addGeofences(GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        return googleApiClient.zze(new zzcer(this, googleApiClient, geofencingRequest, pendingIntent));
    }

    @Deprecated
    public final PendingResult<Status> addGeofences(GoogleApiClient googleApiClient, List<Geofence> list, PendingIntent pendingIntent) {
        Builder builder = new Builder();
        builder.addGeofences(list);
        builder.setInitialTrigger(5);
        return addGeofences(googleApiClient, builder.build(), pendingIntent);
    }

    public final PendingResult<Status> removeGeofences(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return zza(googleApiClient, zzag.zzb(pendingIntent));
    }

    public final PendingResult<Status> removeGeofences(GoogleApiClient googleApiClient, List<String> list) {
        return zza(googleApiClient, zzag.zzac(list));
    }
}
