package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.dynamite.DynamiteModule;

public final class zzdxl extends zzab<zzdxp> implements zzdxk {
    private static zzbgg zzecc = new zzbgg("FirebaseAuth", "FirebaseAuth:");
    private final Context mContext;
    private final zzdxt zzmez;

    public zzdxl(Context context, Looper looper, zzr com_google_android_gms_common_internal_zzr, zzdxt com_google_android_gms_internal_zzdxt, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 112, com_google_android_gms_common_internal_zzr, connectionCallbacks, onConnectionFailedListener);
        this.mContext = (Context) zzbq.checkNotNull(context);
        this.zzmez = com_google_android_gms_internal_zzdxt;
    }

    protected final Bundle zzaap() {
        Bundle zzaap = super.zzaap();
        if (zzaap == null) {
            zzaap = new Bundle();
        }
        if (this.zzmez != null) {
            zzaap.putString("com.google.firebase.auth.API_KEY", this.zzmez.getApiKey());
        }
        return zzaap;
    }

    public final boolean zzagg() {
        return DynamiteModule.zzab(this.mContext, "com.google.firebase.auth") == 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final java.lang.String zzakh() {
        /*
        r4 = this;
        r2 = -1;
        r1 = 0;
        r0 = "firebear.preference";
        r0 = com.google.android.gms.internal.zzdyh.getProperty(r0);
        r3 = android.text.TextUtils.isEmpty(r0);
        if (r3 == 0) goto L_0x0010;
    L_0x000e:
        r0 = "default";
    L_0x0010:
        r3 = r0.hashCode();
        switch(r3) {
            case 103145323: goto L_0x0047;
            case 1544803905: goto L_0x0051;
            default: goto L_0x0017;
        };
    L_0x0017:
        r3 = r2;
    L_0x0018:
        switch(r3) {
            case 0: goto L_0x001d;
            case 1: goto L_0x001d;
            default: goto L_0x001b;
        };
    L_0x001b:
        r0 = "default";
    L_0x001d:
        r3 = r0.hashCode();
        switch(r3) {
            case 103145323: goto L_0x005b;
            default: goto L_0x0024;
        };
    L_0x0024:
        r0 = r2;
    L_0x0025:
        switch(r0) {
            case 0: goto L_0x0065;
            default: goto L_0x0028;
        };
    L_0x0028:
        r0 = zzecc;
        r2 = "Loading module via FirebaseOptions.";
        r3 = new java.lang.Object[r1];
        r0.zze(r2, r3);
        r0 = r4.zzmez;
        r0 = r0.zzmei;
        if (r0 == 0) goto L_0x0075;
    L_0x0037:
        r0 = zzecc;
        r2 = "Preparing to create service connection to fallback implementation";
        r1 = new java.lang.Object[r1];
        r0.zze(r2, r1);
        r0 = r4.mContext;
        r0 = r0.getPackageName();
    L_0x0046:
        return r0;
    L_0x0047:
        r3 = "local";
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x0017;
    L_0x004f:
        r3 = r1;
        goto L_0x0018;
    L_0x0051:
        r3 = "default";
        r3 = r0.equals(r3);
        if (r3 == 0) goto L_0x0017;
    L_0x0059:
        r3 = 1;
        goto L_0x0018;
    L_0x005b:
        r3 = "local";
        r0 = r0.equals(r3);
        if (r0 == 0) goto L_0x0024;
    L_0x0063:
        r0 = r1;
        goto L_0x0025;
    L_0x0065:
        r0 = zzecc;
        r2 = "Loading fallback module override.";
        r1 = new java.lang.Object[r1];
        r0.zze(r2, r1);
        r0 = r4.mContext;
        r0 = r0.getPackageName();
        goto L_0x0046;
    L_0x0075:
        r0 = zzecc;
        r2 = "Preparing to create service connection to gms implementation";
        r1 = new java.lang.Object[r1];
        r0.zze(r2, r1);
        r0 = "com.google.android.gms";
        goto L_0x0046;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdxl.zzakh():java.lang.String");
    }

    public final /* synthetic */ zzdxp zzbrm() throws DeadObjectException {
        return (zzdxp) super.zzakn();
    }

    protected final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
        return queryLocalInterface instanceof zzdxp ? (zzdxp) queryLocalInterface : new zzdxq(iBinder);
    }

    protected final String zzhi() {
        return "com.google.firebase.auth.api.gms.service.START";
    }

    protected final String zzhj() {
        return "com.google.firebase.auth.api.internal.IFirebaseAuthService";
    }
}
