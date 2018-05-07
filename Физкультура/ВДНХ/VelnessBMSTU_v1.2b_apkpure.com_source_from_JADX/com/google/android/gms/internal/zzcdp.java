package com.google.android.gms.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionApi;

public final class zzcdp implements ActivityRecognitionApi {
    public final PendingResult<Status> removeActivityUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.zze(new zzcdr(this, googleApiClient, pendingIntent));
    }

    public final PendingResult<Status> requestActivityUpdates(GoogleApiClient googleApiClient, long j, PendingIntent pendingIntent) {
        return googleApiClient.zze(new zzcdq(this, googleApiClient, j, pendingIntent));
    }
}
