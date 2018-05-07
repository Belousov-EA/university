package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.zzcz;
import com.google.android.gms.common.api.internal.zzdd;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import java.util.Map;

public class zzdvv<O extends zzdvw> {
    private static zzbgg zzecc = new zzbgg("BiChannelGoogleApi", "FirebaseAuth: ");
    private GoogleApi<O> zzmeb;
    private GoogleApi<O> zzmec;
    private zzdvy zzmed;
    private O zzmee;
    private Integer zzmef;
    private Integer zzmeg;
    private zzdwb zzmeh;

    private zzdvv(@NonNull Context context, @NonNull Api<O> api, @NonNull O o, @NonNull zzcz com_google_android_gms_common_api_internal_zzcz) {
        this.zzmee = o;
        this.zzmeg = Integer.valueOf(DynamiteModule.zzac(context, "com.google.android.gms.firebase_auth"));
        this.zzmef = Integer.valueOf(DynamiteModule.zzab(context, "com.google.firebase.auth"));
        if (this.zzmeg.intValue() != 0) {
            zzdvw com_google_android_gms_internal_zzdvw = (zzdvw) this.zzmee.clone();
            com_google_android_gms_internal_zzdvw.zzmei = false;
            this.zzmeb = new zzdvz(context, api, com_google_android_gms_internal_zzdvw, com_google_android_gms_common_api_internal_zzcz);
        } else {
            zzecc.zze("No Gms module; NOT initializing GMS implementation", new Object[0]);
            this.zzmeb = null;
        }
        if (this.zzmef.intValue() != 0) {
            this.zzmed = new zzdvy(this, context, api, com_google_android_gms_common_api_internal_zzcz);
        } else {
            zzecc.zze("No Fallback module; NOT setting up for lazy initialization", new Object[0]);
        }
    }

    public zzdvv(@NonNull Context context, Api<O> api, O o, zzcz com_google_android_gms_common_api_internal_zzcz, int i, int i2, Map<String, Integer> map) {
        this(context, api, o, com_google_android_gms_common_api_internal_zzcz);
        this.zzmeh = new zzdvx(i, i2, map, this.zzmeg.intValue() != 0);
    }

    private final GoogleApi zzc(zzdwa com_google_android_gms_internal_zzdwa) {
        if (this.zzmeh.zzd(com_google_android_gms_internal_zzdwa)) {
            zzecc.zzf("getGoogleApiForMethod() returned Fallback", new Object[0]);
            if (this.zzmec == null && this.zzmed != null) {
                zzdvy com_google_android_gms_internal_zzdvy = this.zzmed;
                zzdvw com_google_android_gms_internal_zzdvw = (zzdvw) this.zzmee.clone();
                com_google_android_gms_internal_zzdvw.zzmei = true;
                this.zzmec = com_google_android_gms_internal_zzdvy.zza(com_google_android_gms_internal_zzdvw);
            }
            return this.zzmec;
        }
        zzecc.zzf("getGoogleApiForMethod() returned Gms", new Object[0]);
        return this.zzmeb;
    }

    public final <TResult, A extends zzb> Task<TResult> zza(zzdwa<A, TResult> com_google_android_gms_internal_zzdwa_A__TResult) {
        return zzc(com_google_android_gms_internal_zzdwa_A__TResult).zza((zzdd) com_google_android_gms_internal_zzdwa_A__TResult);
    }

    public final <TResult, A extends zzb> Task<TResult> zzb(zzdwa<A, TResult> com_google_android_gms_internal_zzdwa_A__TResult) {
        return zzc(com_google_android_gms_internal_zzdwa_A__TResult).zzb((zzdd) com_google_android_gms_internal_zzdwa_A__TResult);
    }
}
