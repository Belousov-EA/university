package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzm;

final class zzbem extends zzm<Status, zzbeo> {
    private final zzbeh zzfkf;

    zzbem(zzbeh com_google_android_gms_internal_zzbeh, GoogleApiClient googleApiClient) {
        super(zzbdy.API, googleApiClient);
        this.zzfkf = com_google_android_gms_internal_zzbeh;
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Status) obj);
    }

    protected final /* synthetic */ void zza(zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        zzbeo com_google_android_gms_internal_zzbeo = (zzbeo) com_google_android_gms_common_api_Api_zzb;
        zzbeq com_google_android_gms_internal_zzben = new zzben(this);
        try {
            zzbeh com_google_android_gms_internal_zzbeh = this.zzfkf;
            if (com_google_android_gms_internal_zzbeh.zzfjk != null && com_google_android_gms_internal_zzbeh.zzfjr.zzpqs.length == 0) {
                com_google_android_gms_internal_zzbeh.zzfjr.zzpqs = com_google_android_gms_internal_zzbeh.zzfjk.zzafv();
            }
            if (com_google_android_gms_internal_zzbeh.zzfke != null && com_google_android_gms_internal_zzbeh.zzfjr.zzpqz.length == 0) {
                com_google_android_gms_internal_zzbeh.zzfjr.zzpqz = com_google_android_gms_internal_zzbeh.zzfke.zzafv();
            }
            com_google_android_gms_internal_zzbeh.zzfjy = zzfjs.zzc(com_google_android_gms_internal_zzbeh.zzfjr);
            ((zzbes) com_google_android_gms_internal_zzbeo.zzakn()).zza(com_google_android_gms_internal_zzben, this.zzfkf);
        } catch (Throwable e) {
            Log.e("ClearcutLoggerApiImpl", "derived ClearcutLogger.MessageProducer ", e);
            zzu(new Status(10, "MessageProducer"));
        }
    }

    protected final /* synthetic */ Result zzb(Status status) {
        return status;
    }
}
