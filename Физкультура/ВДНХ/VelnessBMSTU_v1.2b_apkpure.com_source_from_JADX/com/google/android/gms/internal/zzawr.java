package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.support.v4.media.TransportMediator;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;

public final class zzawr extends zzab<zzawn> {
    public zzawr(Context context, Looper looper, zzr com_google_android_gms_common_internal_zzr, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, TransportMediator.KEYCODE_MEDIA_PLAY, com_google_android_gms_common_internal_zzr, connectionCallbacks, onConnectionFailedListener);
    }

    protected final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
        return queryLocalInterface instanceof zzawn ? (zzawn) queryLocalInterface : new zzawo(iBinder);
    }

    protected final String zzhi() {
        return "com.google.android.gms.auth.api.phone.service.SmsRetrieverApiService.START";
    }

    protected final String zzhj() {
        return "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService";
    }
}
