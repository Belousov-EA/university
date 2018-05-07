package com.google.firebase.auth.internal;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.internal.zzk;
import com.google.android.gms.internal.zzdym;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseApp.zzb;

public final class zzs implements zzb {
    private volatile int zzmia;
    private final zzk zzmib;
    private volatile boolean zzmic;

    private zzs(@NonNull Context context, @NonNull zzk com_google_firebase_auth_internal_zzk) {
        this.zzmic = false;
        this.zzmia = 0;
        this.zzmib = com_google_firebase_auth_internal_zzk;
        zzk.zza((Application) context.getApplicationContext());
        zzk.zzahb().zza(new zzt(this));
    }

    public zzs(@NonNull FirebaseApp firebaseApp) {
        this(firebaseApp.getApplicationContext(), new zzk(firebaseApp));
    }

    private final boolean zzbsi() {
        return this.zzmia > 0 && !this.zzmic;
    }

    public final void cancel() {
        this.zzmib.cancel();
    }

    public final void zzc(@NonNull zzdym com_google_android_gms_internal_zzdym) {
        if (com_google_android_gms_internal_zzdym != null) {
            long zzbrv = com_google_android_gms_internal_zzdym.zzbrv();
            if (zzbrv <= 0) {
                zzbrv = 3600;
            }
            zzbrv = ((zzbrv * 1000) + com_google_android_gms_internal_zzdym.zzbrw()) - 300000;
            zzk com_google_firebase_auth_internal_zzk = this.zzmib;
            com_google_firebase_auth_internal_zzk.zzmhs = zzbrv;
            com_google_firebase_auth_internal_zzk.zzmht = -1;
            if (zzbsi()) {
                this.zzmib.zzbsd();
            }
        }
    }

    public final void zzgj(int i) {
        if (i > 0 && this.zzmia == 0) {
            this.zzmia = i;
            if (zzbsi()) {
                this.zzmib.zzbsd();
            }
        } else if (i == 0 && this.zzmia != 0) {
            this.zzmib.cancel();
        }
        this.zzmia = i;
    }
}
