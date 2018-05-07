package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasAccountOptions;
import com.google.android.gms.common.api.Api.ApiOptions.HasGoogleSignInAccountOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.internal.zzah;
import com.google.android.gms.common.api.internal.zzbm;
import com.google.android.gms.common.api.internal.zzbo;
import com.google.android.gms.common.api.internal.zzbw;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.common.api.internal.zzck;
import com.google.android.gms.common.api.internal.zzcm;
import com.google.android.gms.common.api.internal.zzcq;
import com.google.android.gms.common.api.internal.zzcv;
import com.google.android.gms.common.api.internal.zzcz;
import com.google.android.gms.common.api.internal.zzdd;
import com.google.android.gms.common.api.internal.zzdn;
import com.google.android.gms.common.api.internal.zzg;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collection;
import java.util.Collections;

public class GoogleApi<O extends ApiOptions> {
    private final Context mContext;
    private final int mId;
    private final Looper zzall;
    private final Api<O> zzfin;
    private final O zzfme;
    private final zzh<O> zzfmf;
    private final GoogleApiClient zzfmg;
    private final zzcz zzfmh;
    protected final zzbm zzfmi;

    public static class zza {
        public static final zza zzfmj = new zzd().zzagq();
        public final zzcz zzfmk;
        public final Looper zzfml;

        private zza(zzcz com_google_android_gms_common_api_internal_zzcz, Account account, Looper looper) {
            this.zzfmk = com_google_android_gms_common_api_internal_zzcz;
            this.zzfml = looper;
        }
    }

    @MainThread
    public GoogleApi(@NonNull Activity activity, Api<O> api, O o, zza com_google_android_gms_common_api_GoogleApi_zza) {
        zzbq.checkNotNull(activity, "Null activity is not permitted.");
        zzbq.checkNotNull(api, "Api must not be null.");
        zzbq.checkNotNull(com_google_android_gms_common_api_GoogleApi_zza, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = activity.getApplicationContext();
        this.zzfin = api;
        this.zzfme = o;
        this.zzall = com_google_android_gms_common_api_GoogleApi_zza.zzfml;
        this.zzfmf = zzh.zza(this.zzfin, this.zzfme);
        this.zzfmg = new zzbw(this);
        this.zzfmi = zzbm.zzcj(this.mContext);
        this.mId = this.zzfmi.zzais();
        this.zzfmh = com_google_android_gms_common_api_GoogleApi_zza.zzfmk;
        zzah.zza(activity, this.zzfmi, this.zzfmf);
        this.zzfmi.zza(this);
    }

    @Deprecated
    public GoogleApi(@NonNull Activity activity, Api<O> api, O o, zzcz com_google_android_gms_common_api_internal_zzcz) {
        this(activity, (Api) api, (ApiOptions) o, new zzd().zza(com_google_android_gms_common_api_internal_zzcz).zza(activity.getMainLooper()).zzagq());
    }

    protected GoogleApi(@NonNull Context context, Api<O> api, Looper looper) {
        zzbq.checkNotNull(context, "Null context is not permitted.");
        zzbq.checkNotNull(api, "Api must not be null.");
        zzbq.checkNotNull(looper, "Looper must not be null.");
        this.mContext = context.getApplicationContext();
        this.zzfin = api;
        this.zzfme = null;
        this.zzall = looper;
        this.zzfmf = zzh.zzb(api);
        this.zzfmg = new zzbw(this);
        this.zzfmi = zzbm.zzcj(this.mContext);
        this.mId = this.zzfmi.zzais();
        this.zzfmh = new zzg();
    }

    @Deprecated
    public GoogleApi(@NonNull Context context, Api<O> api, O o, Looper looper, zzcz com_google_android_gms_common_api_internal_zzcz) {
        this(context, (Api) api, null, new zzd().zza(looper).zza(com_google_android_gms_common_api_internal_zzcz).zzagq());
    }

    public GoogleApi(@NonNull Context context, Api<O> api, O o, zza com_google_android_gms_common_api_GoogleApi_zza) {
        zzbq.checkNotNull(context, "Null context is not permitted.");
        zzbq.checkNotNull(api, "Api must not be null.");
        zzbq.checkNotNull(com_google_android_gms_common_api_GoogleApi_zza, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = context.getApplicationContext();
        this.zzfin = api;
        this.zzfme = o;
        this.zzall = com_google_android_gms_common_api_GoogleApi_zza.zzfml;
        this.zzfmf = zzh.zza(this.zzfin, this.zzfme);
        this.zzfmg = new zzbw(this);
        this.zzfmi = zzbm.zzcj(this.mContext);
        this.mId = this.zzfmi.zzais();
        this.zzfmh = com_google_android_gms_common_api_GoogleApi_zza.zzfmk;
        this.zzfmi.zza(this);
    }

    @Deprecated
    public GoogleApi(@NonNull Context context, Api<O> api, O o, zzcz com_google_android_gms_common_api_internal_zzcz) {
        this(context, (Api) api, (ApiOptions) o, new zzd().zza(com_google_android_gms_common_api_internal_zzcz).zzagq());
    }

    private final <A extends zzb, T extends zzm<? extends Result, A>> T zza(int i, @NonNull T t) {
        t.zzahi();
        this.zzfmi.zza(this, i, (zzm) t);
        return t;
    }

    private final <TResult, A extends zzb> Task<TResult> zza(int i, @NonNull zzdd<A, TResult> com_google_android_gms_common_api_internal_zzdd_A__TResult) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzfmi.zza(this, i, com_google_android_gms_common_api_internal_zzdd_A__TResult, taskCompletionSource, this.zzfmh);
        return taskCompletionSource.getTask();
    }

    private final zzs zzagp() {
        GoogleSignInAccount googleSignInAccount;
        Account account;
        Collection zzabb;
        zzs com_google_android_gms_common_internal_zzs = new zzs();
        if (this.zzfme instanceof HasGoogleSignInAccountOptions) {
            googleSignInAccount = ((HasGoogleSignInAccountOptions) this.zzfme).getGoogleSignInAccount();
            if (googleSignInAccount != null) {
                account = googleSignInAccount.getAccount();
                com_google_android_gms_common_internal_zzs = com_google_android_gms_common_internal_zzs.zze(account);
                if (this.zzfme instanceof HasGoogleSignInAccountOptions) {
                    googleSignInAccount = ((HasGoogleSignInAccountOptions) this.zzfme).getGoogleSignInAccount();
                    if (googleSignInAccount != null) {
                        zzabb = googleSignInAccount.zzabb();
                        return com_google_android_gms_common_internal_zzs.zze(zzabb);
                    }
                }
                zzabb = Collections.emptySet();
                return com_google_android_gms_common_internal_zzs.zze(zzabb);
            }
        }
        account = this.zzfme instanceof HasAccountOptions ? ((HasAccountOptions) this.zzfme).getAccount() : null;
        com_google_android_gms_common_internal_zzs = com_google_android_gms_common_internal_zzs.zze(account);
        if (this.zzfme instanceof HasGoogleSignInAccountOptions) {
            googleSignInAccount = ((HasGoogleSignInAccountOptions) this.zzfme).getGoogleSignInAccount();
            if (googleSignInAccount != null) {
                zzabb = googleSignInAccount.zzabb();
                return com_google_android_gms_common_internal_zzs.zze(zzabb);
            }
        }
        zzabb = Collections.emptySet();
        return com_google_android_gms_common_internal_zzs.zze(zzabb);
    }

    public final Context getApplicationContext() {
        return this.mContext;
    }

    public final int getInstanceId() {
        return this.mId;
    }

    public final Looper getLooper() {
        return this.zzall;
    }

    @WorkerThread
    public zze zza(Looper looper, zzbo<O> com_google_android_gms_common_api_internal_zzbo_O) {
        return this.zzfin.zzage().zza(this.mContext, looper, zzagp().zzgf(this.mContext.getPackageName()).zzgg(this.mContext.getClass().getName()).zzald(), this.zzfme, com_google_android_gms_common_api_internal_zzbo_O, com_google_android_gms_common_api_internal_zzbo_O);
    }

    public final <L> zzci<L> zza(@NonNull L l, String str) {
        return zzcm.zzb(l, this.zzall, str);
    }

    public zzcv zza(Context context, Handler handler) {
        return new zzcv(context, handler, zzagp().zzald());
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T zza(@NonNull T t) {
        return zza(0, (zzm) t);
    }

    public final Task<Boolean> zza(@NonNull zzck<?> com_google_android_gms_common_api_internal_zzck_) {
        zzbq.checkNotNull(com_google_android_gms_common_api_internal_zzck_, "Listener key cannot be null.");
        return this.zzfmi.zza(this, (zzck) com_google_android_gms_common_api_internal_zzck_);
    }

    public final <A extends zzb, T extends zzcq<A, ?>, U extends zzdn<A, ?>> Task<Void> zza(@NonNull T t, U u) {
        zzbq.checkNotNull(t);
        zzbq.checkNotNull(u);
        zzbq.checkNotNull(t.zzajo(), "Listener has already been released.");
        zzbq.checkNotNull(u.zzajo(), "Listener has already been released.");
        zzbq.checkArgument(t.zzajo().equals(u.zzajo()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.zzfmi.zza(this, (zzcq) t, (zzdn) u);
    }

    public final <TResult, A extends zzb> Task<TResult> zza(zzdd<A, TResult> com_google_android_gms_common_api_internal_zzdd_A__TResult) {
        return zza(0, (zzdd) com_google_android_gms_common_api_internal_zzdd_A__TResult);
    }

    public final Api<O> zzagl() {
        return this.zzfin;
    }

    public final O zzagm() {
        return this.zzfme;
    }

    public final zzh<O> zzagn() {
        return this.zzfmf;
    }

    public final GoogleApiClient zzago() {
        return this.zzfmg;
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T zzb(@NonNull T t) {
        return zza(1, (zzm) t);
    }

    public final <TResult, A extends zzb> Task<TResult> zzb(zzdd<A, TResult> com_google_android_gms_common_api_internal_zzdd_A__TResult) {
        return zza(1, (zzdd) com_google_android_gms_common_api_internal_zzdd_A__TResult);
    }

    public final <A extends zzb, T extends zzm<? extends Result, A>> T zzc(@NonNull T t) {
        return zza(2, (zzm) t);
    }
}
