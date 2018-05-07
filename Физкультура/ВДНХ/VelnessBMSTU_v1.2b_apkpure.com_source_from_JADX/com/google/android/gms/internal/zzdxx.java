package com.google.android.gms.internal;

import android.app.Activity;
import android.os.RemoteException;
import android.support.annotation.MainThread;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.zzcf;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks;
import com.google.firebase.auth.internal.zzp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

abstract class zzdxx<SuccessT, CallbackT> {
    private boolean zzkuo;
    protected FirebaseApp zzmcx;
    protected String zzmdq;
    protected final int zzmfd;
    protected final zzdya zzmfe = new zzdya();
    protected FirebaseUser zzmff;
    protected zzdxp zzmfg;
    protected CallbackT zzmfh;
    protected zzp zzmfi;
    protected zzdxw<SuccessT> zzmfj;
    protected final List<OnVerificationStateChangedCallbacks> zzmfk = new ArrayList();
    private Activity zzmfl;
    protected Executor zzmfm;
    protected zzdxz zzmfn;
    protected zzdym zzmfo;
    protected zzdyk zzmfp;
    protected zzdyi zzmfq;
    protected zzdys zzmfr;
    protected String zzmfs;
    protected PhoneAuthCredential zzmft;
    boolean zzmfu;
    private SuccessT zzmfv;
    private Status zzmfw;

    static class zza extends LifecycleCallback {
        private List<OnVerificationStateChangedCallbacks> zzmfx;

        private zza(zzcf com_google_android_gms_common_api_internal_zzcf, List<OnVerificationStateChangedCallbacks> list) {
            super(com_google_android_gms_common_api_internal_zzcf);
            this.zzfud.zza("PhoneAuthActivityStopCallback", (LifecycleCallback) this);
            this.zzmfx = list;
        }

        public static void zza(Activity activity, List<OnVerificationStateChangedCallbacks> list) {
            zzcf zzn = LifecycleCallback.zzn(activity);
            if (((zza) zzn.zza("PhoneAuthActivityStopCallback", zza.class)) == null) {
                zza com_google_android_gms_internal_zzdxx_zza = new zza(zzn, list);
            }
        }

        @MainThread
        public final void onStop() {
            synchronized (this.zzmfx) {
                this.zzmfx.clear();
            }
        }
    }

    public zzdxx(int i) {
        this.zzmfd = i;
    }

    private final void zzaq(Status status) {
        if (this.zzmfi != null) {
            this.zzmfi.onError(status);
        }
    }

    private final void zzbrs() {
        zzbrl();
        zzbq.zza(this.zzkuo, (Object) "no success or failure set on method implementation");
    }

    protected abstract void dispatch() throws RemoteException;

    public final zzdxx<SuccessT, CallbackT> zza(OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        synchronized (this.zzmfk) {
            this.zzmfk.add((OnVerificationStateChangedCallbacks) zzbq.checkNotNull(onVerificationStateChangedCallbacks));
        }
        this.zzmfl = activity;
        if (this.zzmfl != null) {
            zza.zza(activity, this.zzmfk);
        }
        this.zzmfm = (Executor) zzbq.checkNotNull(executor);
        return this;
    }

    public final zzdxx<SuccessT, CallbackT> zza(zzp com_google_firebase_auth_internal_zzp) {
        this.zzmfi = (zzp) zzbq.checkNotNull(com_google_firebase_auth_internal_zzp, "external failure callback cannot be null");
        return this;
    }

    public final void zzap(Status status) {
        this.zzkuo = true;
        this.zzmfu = false;
        this.zzmfw = status;
        this.zzmfj.zza(null, status);
    }

    public final zzdxx<SuccessT, CallbackT> zzbc(CallbackT callbackT) {
        this.zzmfh = zzbq.checkNotNull(callbackT, "external callback cannot be null");
        return this;
    }

    public final void zzbd(SuccessT successT) {
        this.zzkuo = true;
        this.zzmfu = true;
        this.zzmfv = successT;
        this.zzmfj.zza(successT, null);
    }

    public abstract void zzbrl();

    public final zzdxx<SuccessT, CallbackT> zzc(FirebaseApp firebaseApp) {
        this.zzmcx = (FirebaseApp) zzbq.checkNotNull(firebaseApp, "firebaseApp cannot be null");
        return this;
    }

    public final zzdxx<SuccessT, CallbackT> zze(FirebaseUser firebaseUser) {
        this.zzmff = (FirebaseUser) zzbq.checkNotNull(firebaseUser, "firebaseUser cannot be null");
        return this;
    }
}
