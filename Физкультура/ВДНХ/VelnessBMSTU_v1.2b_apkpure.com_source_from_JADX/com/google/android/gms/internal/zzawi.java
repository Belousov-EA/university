package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.zzd;
import com.google.android.gms.auth.api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;

public final class zzawi extends zzab<zzawl> {
    private final Bundle zzeet;

    public zzawi(Context context, Looper looper, zzr com_google_android_gms_common_internal_zzr, zzf com_google_android_gms_auth_api_zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 16, com_google_android_gms_common_internal_zzr, connectionCallbacks, onConnectionFailedListener);
        if (com_google_android_gms_auth_api_zzf == null) {
            this.zzeet = new Bundle();
            return;
        }
        throw new NoSuchMethodError();
    }

    protected final Bundle zzaap() {
        return this.zzeet;
    }

    public final boolean zzaay() {
        zzr zzalh = zzalh();
        return (TextUtils.isEmpty(zzalh.getAccountName()) || zzalh.zzc(zzd.API).isEmpty()) ? false : true;
    }

    protected final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        return queryLocalInterface instanceof zzawl ? (zzawl) queryLocalInterface : new zzawm(iBinder);
    }

    protected final String zzhi() {
        return "com.google.android.gms.auth.service.START";
    }

    protected final String zzhj() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }
}
