package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.common.internal.zzbq;

public final class zzavx {
    public static PendingIntent zza(Context context, @Nullable AuthCredentialsOptions authCredentialsOptions, HintRequest hintRequest) {
        zzbq.checkNotNull(context, "context must not be null");
        zzbq.checkNotNull(hintRequest, "request must not be null");
        if (authCredentialsOptions == null) {
            zzbfq zzaas = (authCredentialsOptions != null || authCredentialsOptions.zzaas() == null) ? PasswordSpecification.zzeft : authCredentialsOptions.zzaas();
            Intent putExtra = new Intent("com.google.android.gms.auth.api.credentials.PICKER").putExtra("com.google.android.gms.credentials.hintRequestVersion", 2).putExtra("com.google.android.gms.credentials.RequestType", "Hints").putExtra("com.google.android.gms.credentials.ClaimedCallingPackage", null);
            zzbfr.zza(zzaas, putExtra, "com.google.android.gms.credentials.PasswordSpecification");
            zzbfr.zza((zzbfq) hintRequest, putExtra, "com.google.android.gms.credentials.HintRequest");
            return PendingIntent.getActivity(context, 2000, putExtra, 134217728);
        }
        if (authCredentialsOptions != null) {
        }
        Intent putExtra2 = new Intent("com.google.android.gms.auth.api.credentials.PICKER").putExtra("com.google.android.gms.credentials.hintRequestVersion", 2).putExtra("com.google.android.gms.credentials.RequestType", "Hints").putExtra("com.google.android.gms.credentials.ClaimedCallingPackage", null);
        zzbfr.zza(zzaas, putExtra2, "com.google.android.gms.credentials.PasswordSpecification");
        zzbfr.zza((zzbfq) hintRequest, putExtra2, "com.google.android.gms.credentials.HintRequest");
        return PendingIntent.getActivity(context, 2000, putExtra2, 134217728);
    }
}
