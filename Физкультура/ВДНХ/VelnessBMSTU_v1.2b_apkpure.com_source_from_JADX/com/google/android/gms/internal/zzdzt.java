package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.firebase.FirebaseApp.IdTokenListener;
import com.google.firebase.internal.zzc;

final class zzdzt implements IdTokenListener {
    final /* synthetic */ zzecv zzmli;
    private /* synthetic */ zzdzq zzmlj;

    zzdzt(zzdzq com_google_android_gms_internal_zzdzq, zzecv com_google_android_gms_internal_zzecv) {
        this.zzmlj = com_google_android_gms_internal_zzdzq;
        this.zzmli = com_google_android_gms_internal_zzecv;
    }

    public final void zzb(@NonNull zzc com_google_firebase_internal_zzc) {
        this.zzmlj.zzmlf.execute(new zzdzu(this, com_google_firebase_internal_zzc));
    }
}
