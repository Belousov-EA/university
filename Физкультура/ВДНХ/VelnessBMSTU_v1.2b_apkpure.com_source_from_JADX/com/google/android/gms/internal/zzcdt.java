package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;

public class zzcdt extends zzab<zzcez> {
    private final String zziks;
    protected final zzcfu<zzcez> zzikt = new zzcdu(this);

    public zzcdt(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, zzr com_google_android_gms_common_internal_zzr) {
        super(context, looper, 23, com_google_android_gms_common_internal_zzr, connectionCallbacks, onConnectionFailedListener);
        this.zziks = str;
    }

    protected final Bundle zzaap() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.zziks);
        return bundle;
    }

    protected final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return queryLocalInterface instanceof zzcez ? (zzcez) queryLocalInterface : new zzcfa(iBinder);
    }

    protected final String zzhi() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    protected final String zzhj() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }
}
