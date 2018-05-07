package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.internal.zzcdp;
import com.google.android.gms.internal.zzcfk;

public class ActivityRecognition {
    public static final Api<NoOptions> API = new Api("ActivityRecognition.API", zzebg, zzebf);
    @Deprecated
    public static final ActivityRecognitionApi ActivityRecognitionApi = new zzcdp();
    public static final String CLIENT_NAME = "activity_recognition";
    private static final zzf<zzcfk> zzebf = new zzf();
    private static final com.google.android.gms.common.api.Api.zza<zzcfk, NoOptions> zzebg = new zza();

    public static abstract class zza<R extends Result> extends zzm<R, zzcfk> {
        public zza(GoogleApiClient googleApiClient) {
            super(ActivityRecognition.API, googleApiClient);
        }

        public final /* bridge */ /* synthetic */ void setResult(Object obj) {
            super.setResult((Result) obj);
        }
    }

    private ActivityRecognition() {
    }

    public static ActivityRecognitionClient getClient(Activity activity) {
        return new ActivityRecognitionClient(activity);
    }

    public static ActivityRecognitionClient getClient(Context context) {
        return new ActivityRecognitionClient(context);
    }
}
