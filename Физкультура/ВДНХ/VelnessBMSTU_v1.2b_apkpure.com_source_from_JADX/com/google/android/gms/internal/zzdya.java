package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.firebase.auth.PhoneAuthCredential;

final class zzdya extends zzdxo {
    final /* synthetic */ zzdxx zzmfy;

    private zzdya(zzdxx com_google_android_gms_internal_zzdxx) {
        this.zzmfy = com_google_android_gms_internal_zzdxx;
    }

    private final void zza(zzdyg com_google_android_gms_internal_zzdyg) {
        this.zzmfy.zzmfm.execute(new zzdyf(this, com_google_android_gms_internal_zzdyg));
    }

    public final void onFailure(@NonNull Status status) throws RemoteException {
        if (this.zzmfy.zzmfd == 8) {
            this.zzmfy.zzkuo = true;
            this.zzmfy.zzmfu = false;
            zza(new zzdye(this, status));
            return;
        }
        this.zzmfy.zzaq(status);
        this.zzmfy.zzap(status);
    }

    public final void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        zzbq.zza(this.zzmfy.zzmfd == 8, "Unexpected response type " + this.zzmfy.zzmfd);
        this.zzmfy.zzkuo = true;
        this.zzmfy.zzmfu = true;
        zza(new zzdyc(this, phoneAuthCredential));
    }

    public final void zza(@NonNull Status status, @NonNull PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        if (this.zzmfy.zzmfn != null) {
            this.zzmfy.zzkuo = true;
            this.zzmfy.zzmfn.zza(status, phoneAuthCredential);
            return;
        }
        onFailure(status);
    }

    public final void zza(@NonNull zzdyi com_google_android_gms_internal_zzdyi) throws RemoteException {
        zzbq.zza(this.zzmfy.zzmfd == 3, "Unexpected response type " + this.zzmfy.zzmfd);
        this.zzmfy.zzmfq = com_google_android_gms_internal_zzdyi;
        this.zzmfy.zzbrs();
    }

    public final void zza(@NonNull zzdym com_google_android_gms_internal_zzdym, @NonNull zzdyk com_google_android_gms_internal_zzdyk) throws RemoteException {
        zzbq.zza(this.zzmfy.zzmfd == 2, "Unexpected response type: " + this.zzmfy.zzmfd);
        this.zzmfy.zzmfo = com_google_android_gms_internal_zzdym;
        this.zzmfy.zzmfp = com_google_android_gms_internal_zzdyk;
        this.zzmfy.zzbrs();
    }

    public final void zza(@Nullable zzdys com_google_android_gms_internal_zzdys) throws RemoteException {
        zzbq.zza(this.zzmfy.zzmfd == 4, "Unexpected response type " + this.zzmfy.zzmfd);
        this.zzmfy.zzmfr = com_google_android_gms_internal_zzdys;
        this.zzmfy.zzbrs();
    }

    public final void zzb(@NonNull zzdym com_google_android_gms_internal_zzdym) throws RemoteException {
        boolean z = true;
        if (this.zzmfy.zzmfd != 1) {
            z = false;
        }
        zzbq.zza(z, "Unexpected response type: " + this.zzmfy.zzmfd);
        this.zzmfy.zzmfo = com_google_android_gms_internal_zzdym;
        this.zzmfy.zzbrs();
    }

    public final void zzbrn() throws RemoteException {
        zzbq.zza(this.zzmfy.zzmfd == 5, "Unexpected response type " + this.zzmfy.zzmfd);
        this.zzmfy.zzbrs();
    }

    public final void zzbro() throws RemoteException {
        zzbq.zza(this.zzmfy.zzmfd == 6, "Unexpected response type " + this.zzmfy.zzmfd);
        this.zzmfy.zzbrs();
    }

    public final void zzbrp() throws RemoteException {
        zzbq.zza(this.zzmfy.zzmfd == 9, "Unexpected response type " + this.zzmfy.zzmfd);
        this.zzmfy.zzbrs();
    }

    public final void zzow(@NonNull String str) throws RemoteException {
        zzbq.zza(this.zzmfy.zzmfd == 7, "Unexpected response type " + this.zzmfy.zzmfd);
        this.zzmfy.zzmfs = str;
        this.zzmfy.zzbrs();
    }

    public final void zzox(@NonNull String str) throws RemoteException {
        zzbq.zza(this.zzmfy.zzmfd == 8, "Unexpected response type " + this.zzmfy.zzmfd);
        this.zzmfy.zzmdq = str;
        zza(new zzdyb(this, str));
    }

    public final void zzoy(@NonNull String str) throws RemoteException {
        zzbq.zza(this.zzmfy.zzmfd == 8, "Unexpected response type " + this.zzmfy.zzmfd);
        this.zzmfy.zzmdq = str;
        this.zzmfy.zzkuo = true;
        this.zzmfy.zzmfu = true;
        zza(new zzdyd(this, str));
    }
}
