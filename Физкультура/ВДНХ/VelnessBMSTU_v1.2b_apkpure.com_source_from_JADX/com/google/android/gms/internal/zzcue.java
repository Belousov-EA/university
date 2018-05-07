package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;

public final class zzcue {
    @Deprecated
    private static Api<NoOptions> API = new Api("Phenotype.API", zzebg, zzebf);
    private static final zzf<zzcut> zzebf = new zzf();
    private static final zza<zzcut, NoOptions> zzebg = new zzcuf();
    @Deprecated
    private static zzcug zzjwx = new zzcus();

    public static Uri zzks(String str) {
        String str2 = "content://com.google.android.gms.phenotype/";
        String valueOf = String.valueOf(Uri.encode(str));
        return Uri.parse(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }
}
