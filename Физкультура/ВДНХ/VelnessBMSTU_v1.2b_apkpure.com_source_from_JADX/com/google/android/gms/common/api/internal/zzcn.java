package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

public class zzcn extends zzo {
    private TaskCompletionSource<Void> zzedx = new TaskCompletionSource();

    private zzcn(zzcf com_google_android_gms_common_api_internal_zzcf) {
        super(com_google_android_gms_common_api_internal_zzcf);
        this.zzfud.zza("GmsAvailabilityHelper", (LifecycleCallback) this);
    }

    public static zzcn zzp(Activity activity) {
        zzcf zzn = LifecycleCallback.zzn(activity);
        zzcn com_google_android_gms_common_api_internal_zzcn = (zzcn) zzn.zza("GmsAvailabilityHelper", zzcn.class);
        if (com_google_android_gms_common_api_internal_zzcn == null) {
            return new zzcn(zzn);
        }
        if (!com_google_android_gms_common_api_internal_zzcn.zzedx.getTask().isComplete()) {
            return com_google_android_gms_common_api_internal_zzcn;
        }
        com_google_android_gms_common_api_internal_zzcn.zzedx = new TaskCompletionSource();
        return com_google_android_gms_common_api_internal_zzcn;
    }

    public final Task<Void> getTask() {
        return this.zzedx.getTask();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.zzedx.trySetException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }

    protected final void zza(ConnectionResult connectionResult, int i) {
        this.zzedx.setException(zzb.zzy(new Status(connectionResult.getErrorCode(), connectionResult.getErrorMessage(), connectionResult.getResolution())));
    }

    protected final void zzagz() {
        int isGooglePlayServicesAvailable = this.zzfmy.isGooglePlayServicesAvailable(this.zzfud.zzajn());
        if (isGooglePlayServicesAvailable == 0) {
            this.zzedx.setResult(null);
        } else if (!this.zzedx.getTask().isComplete()) {
            zzb(new ConnectionResult(isGooglePlayServicesAvailable, null), 0);
        }
    }
}
