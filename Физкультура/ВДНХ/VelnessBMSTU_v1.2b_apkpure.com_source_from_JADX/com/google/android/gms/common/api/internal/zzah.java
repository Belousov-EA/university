package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.v4.util.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzbq;

public class zzah extends zzo {
    private zzbm zzfmi;
    private final ArraySet<zzh<?>> zzfqs = new ArraySet();

    private zzah(zzcf com_google_android_gms_common_api_internal_zzcf) {
        super(com_google_android_gms_common_api_internal_zzcf);
        this.zzfud.zza("ConnectionlessLifecycleHelper", (LifecycleCallback) this);
    }

    public static void zza(Activity activity, zzbm com_google_android_gms_common_api_internal_zzbm, zzh<?> com_google_android_gms_common_api_internal_zzh_) {
        zzcf zzn = LifecycleCallback.zzn(activity);
        zzah com_google_android_gms_common_api_internal_zzah = (zzah) zzn.zza("ConnectionlessLifecycleHelper", zzah.class);
        if (com_google_android_gms_common_api_internal_zzah == null) {
            com_google_android_gms_common_api_internal_zzah = new zzah(zzn);
        }
        com_google_android_gms_common_api_internal_zzah.zzfmi = com_google_android_gms_common_api_internal_zzbm;
        zzbq.checkNotNull(com_google_android_gms_common_api_internal_zzh_, "ApiKey cannot be null");
        com_google_android_gms_common_api_internal_zzah.zzfqs.add(com_google_android_gms_common_api_internal_zzh_);
        com_google_android_gms_common_api_internal_zzbm.zza(com_google_android_gms_common_api_internal_zzah);
    }

    private final void zzahy() {
        if (!this.zzfqs.isEmpty()) {
            this.zzfmi.zza(this);
        }
    }

    public final void onResume() {
        super.onResume();
        zzahy();
    }

    public final void onStart() {
        super.onStart();
        zzahy();
    }

    public final void onStop() {
        super.onStop();
        this.zzfmi.zzb(this);
    }

    protected final void zza(ConnectionResult connectionResult, int i) {
        this.zzfmi.zza(connectionResult, i);
    }

    protected final void zzagz() {
        this.zzfmi.zzagz();
    }

    final ArraySet<zzh<?>> zzahx() {
        return this.zzfqs;
    }
}
