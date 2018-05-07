package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzceb;
import com.google.android.gms.internal.zzceq;
import com.google.android.gms.internal.zzcfk;
import com.google.android.gms.internal.zzcfv;

public class LocationServices {
    public static final Api<NoOptions> API = new Api("LocationServices.API", zzebg, zzebf);
    @Deprecated
    public static final FusedLocationProviderApi FusedLocationApi = new zzceb();
    @Deprecated
    public static final GeofencingApi GeofencingApi = new zzceq();
    @Deprecated
    public static final SettingsApi SettingsApi = new zzcfv();
    private static final zzf<zzcfk> zzebf = new zzf();
    private static final com.google.android.gms.common.api.Api.zza<zzcfk, NoOptions> zzebg = new zzy();

    public static abstract class zza<R extends Result> extends zzm<R, zzcfk> {
        public zza(GoogleApiClient googleApiClient) {
            super(LocationServices.API, googleApiClient);
        }

        public final /* bridge */ /* synthetic */ void setResult(Object obj) {
            super.setResult((Result) obj);
        }
    }

    private LocationServices() {
    }

    public static FusedLocationProviderClient getFusedLocationProviderClient(@NonNull Activity activity) {
        return new FusedLocationProviderClient(activity);
    }

    public static FusedLocationProviderClient getFusedLocationProviderClient(@NonNull Context context) {
        return new FusedLocationProviderClient(context);
    }

    public static GeofencingClient getGeofencingClient(@NonNull Activity activity) {
        return new GeofencingClient(activity);
    }

    public static GeofencingClient getGeofencingClient(@NonNull Context context) {
        return new GeofencingClient(context);
    }

    public static SettingsClient getSettingsClient(@NonNull Activity activity) {
        return new SettingsClient(activity);
    }

    public static SettingsClient getSettingsClient(@NonNull Context context) {
        return new SettingsClient(context);
    }

    public static zzcfk zzh(GoogleApiClient googleApiClient) {
        boolean z = true;
        zzbq.checkArgument(googleApiClient != null, "GoogleApiClient parameter is required.");
        zzcfk com_google_android_gms_internal_zzcfk = (zzcfk) googleApiClient.zza(zzebf);
        if (com_google_android_gms_internal_zzcfk == null) {
            z = false;
        }
        zzbq.zza(z, (Object) "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return com_google_android_gms_internal_zzcfk;
    }
}
