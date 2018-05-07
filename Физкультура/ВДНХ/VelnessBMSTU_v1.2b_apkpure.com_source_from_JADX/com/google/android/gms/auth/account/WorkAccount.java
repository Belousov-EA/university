package com.google.android.gms.auth.account;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.internal.zzaug;
import com.google.android.gms.internal.zzauq;

public class WorkAccount {
    public static final Api<NoOptions> API = new Api("WorkAccount.API", zzebg, zzebf);
    @Deprecated
    public static final WorkAccountApi WorkAccountApi = new zzaug();
    private static final zzf<zzauq> zzebf = new zzf();
    private static final zza<zzauq, NoOptions> zzebg = new zzf();

    private WorkAccount() {
    }

    public static WorkAccountClient getClient(@NonNull Activity activity) {
        return new WorkAccountClient(activity);
    }

    public static WorkAccountClient getClient(@NonNull Context context) {
        return new WorkAccountClient(context);
    }
}
