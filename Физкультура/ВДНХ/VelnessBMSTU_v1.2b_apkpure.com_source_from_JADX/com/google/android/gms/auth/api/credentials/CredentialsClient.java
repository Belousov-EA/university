package com.google.android.gms.auth.api.credentials;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.support.annotation.NonNull;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.zzg;
import com.google.android.gms.common.internal.zzbj;
import com.google.android.gms.internal.zzavx;
import com.google.android.gms.tasks.Task;

public class CredentialsClient extends GoogleApi<AuthCredentialsOptions> {
    CredentialsClient(@NonNull Activity activity, @NonNull AuthCredentialsOptions authCredentialsOptions) {
        super(activity, Auth.CREDENTIALS_API, (ApiOptions) authCredentialsOptions, new zzg());
    }

    CredentialsClient(@NonNull Context context, @NonNull AuthCredentialsOptions authCredentialsOptions) {
        super(context, Auth.CREDENTIALS_API, (ApiOptions) authCredentialsOptions, new zzg());
    }

    public Task<Void> delete(@NonNull Credential credential) {
        return zzbj.zzb(Auth.CredentialsApi.delete(zzago(), credential));
    }

    public Task<Void> disableAutoSignIn() {
        return zzbj.zzb(Auth.CredentialsApi.disableAutoSignIn(zzago()));
    }

    public PendingIntent getHintPickerIntent(@NonNull HintRequest hintRequest) {
        return zzavx.zza(getApplicationContext(), (AuthCredentialsOptions) zzagm(), hintRequest);
    }

    public Task<CredentialRequestResponse> request(@NonNull CredentialRequest credentialRequest) {
        return zzbj.zza(Auth.CredentialsApi.request(zzago(), credentialRequest), new CredentialRequestResponse());
    }

    public Task<Void> save(@NonNull Credential credential) {
        return zzbj.zzb(Auth.CredentialsApi.save(zzago(), credential));
    }
}
