package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;

public final class zzavy extends zzab<zzawd> {
    @Nullable
    private final AuthCredentialsOptions zzegh;

    public zzavy(Context context, Looper looper, zzr com_google_android_gms_common_internal_zzr, AuthCredentialsOptions authCredentialsOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 68, com_google_android_gms_common_internal_zzr, connectionCallbacks, onConnectionFailedListener);
        this.zzegh = authCredentialsOptions;
    }

    protected final Bundle zzaap() {
        return this.zzegh == null ? new Bundle() : this.zzegh.toBundle();
    }

    final AuthCredentialsOptions zzaax() {
        return this.zzegh;
    }

    protected final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        return queryLocalInterface instanceof zzawd ? (zzawd) queryLocalInterface : new zzawe(iBinder);
    }

    protected final String zzhi() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    protected final String zzhj() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }
}
