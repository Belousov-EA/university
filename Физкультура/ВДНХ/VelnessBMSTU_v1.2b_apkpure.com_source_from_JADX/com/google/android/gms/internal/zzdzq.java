package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.firebase.FirebaseApp;
import java.util.concurrent.ScheduledExecutorService;

public final class zzdzq implements zzect {
    private final ScheduledExecutorService zzmlf;
    private final FirebaseApp zzmlg;

    public zzdzq(@NonNull FirebaseApp firebaseApp, @NonNull ScheduledExecutorService scheduledExecutorService) {
        this.zzmlg = firebaseApp;
        this.zzmlf = scheduledExecutorService;
    }

    public final void zza(zzecv com_google_android_gms_internal_zzecv) {
        this.zzmlg.zza(new zzdzt(this, com_google_android_gms_internal_zzecv));
    }

    public final void zza(boolean z, @NonNull zzecu com_google_android_gms_internal_zzecu) {
        this.zzmlg.getToken(z).addOnSuccessListener(this.zzmlf, new zzdzs(this, com_google_android_gms_internal_zzecu)).addOnFailureListener(this.zzmlf, new zzdzr(this, com_google_android_gms_internal_zzecu));
    }
}
