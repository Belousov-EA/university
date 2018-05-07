package com.google.android.gms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.common.api.internal.zzcm;
import com.google.android.gms.common.api.internal.zzde;
import com.google.android.gms.common.api.internal.zzg;
import com.google.android.gms.common.internal.zzbj;
import com.google.android.gms.internal.zzceo;
import com.google.android.gms.internal.zzceu;
import com.google.android.gms.internal.zzcev;
import com.google.android.gms.internal.zzcfo;
import com.google.android.gms.internal.zzcgc;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class FusedLocationProviderClient extends GoogleApi<NoOptions> {
    public static final String KEY_VERTICAL_ACCURACY = "verticalAccuracy";

    static class zza extends zzcev {
        private final TaskCompletionSource<Void> zzedx;

        public zza(TaskCompletionSource<Void> taskCompletionSource) {
            this.zzedx = taskCompletionSource;
        }

        public final void zza(zzceo com_google_android_gms_internal_zzceo) {
            zzde.zza(com_google_android_gms_internal_zzceo.getStatus(), null, this.zzedx);
        }
    }

    public FusedLocationProviderClient(@NonNull Activity activity) {
        super(activity, LocationServices.API, null, new zzg());
    }

    public FusedLocationProviderClient(@NonNull Context context) {
        super(context, LocationServices.API, null, new zzg());
    }

    private final zzceu zzc(TaskCompletionSource<Boolean> taskCompletionSource) {
        return new zzk(this, taskCompletionSource);
    }

    public Task<Void> flushLocations() {
        return zzbj.zzb(LocationServices.FusedLocationApi.flushLocations(zzago()));
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public Task<Location> getLastLocation() {
        return zza(new zzg(this));
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public Task<LocationAvailability> getLocationAvailability() {
        return zza(new zzh(this));
    }

    public Task<Void> removeLocationUpdates(PendingIntent pendingIntent) {
        return zzbj.zzb(LocationServices.FusedLocationApi.removeLocationUpdates(zzago(), pendingIntent));
    }

    public Task<Void> removeLocationUpdates(LocationCallback locationCallback) {
        return zzde.zza(zza(zzcm.zzb(locationCallback, LocationCallback.class.getSimpleName())));
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public Task<Void> requestLocationUpdates(LocationRequest locationRequest, PendingIntent pendingIntent) {
        return zzbj.zzb(LocationServices.FusedLocationApi.requestLocationUpdates(zzago(), locationRequest, pendingIntent));
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public Task<Void> requestLocationUpdates(LocationRequest locationRequest, LocationCallback locationCallback, @Nullable Looper looper) {
        zzcfo zza = zzcfo.zza(locationRequest);
        zzci zzb = zzcm.zzb(locationCallback, zzcgc.zzb(looper), LocationCallback.class.getSimpleName());
        return zza(new zzi(this, zzb, zza, zzb), new zzj(this, zzb.zzajo()));
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public Task<Void> setMockLocation(Location location) {
        return zzbj.zzb(LocationServices.FusedLocationApi.setMockLocation(zzago(), location));
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    public Task<Void> setMockMode(boolean z) {
        return zzbj.zzb(LocationServices.FusedLocationApi.setMockMode(zzago(), z));
    }
}
