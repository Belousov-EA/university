package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseError;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class zzedh {
    private AtomicBoolean zzmsl = new AtomicBoolean(false);
    private zzedi zzmsm;
    private boolean zzmsn = false;

    public abstract zzedh zza(zzeik com_google_android_gms_internal_zzeik);

    public abstract zzeia zza(zzehz com_google_android_gms_internal_zzehz, zzeik com_google_android_gms_internal_zzeik);

    public final void zza(zzedi com_google_android_gms_internal_zzedi) {
        this.zzmsm = com_google_android_gms_internal_zzedi;
    }

    public abstract void zza(zzeia com_google_android_gms_internal_zzeia);

    public abstract void zza(DatabaseError databaseError);

    public abstract boolean zza(zzeic com_google_android_gms_internal_zzeic);

    public abstract zzeik zzbvp();

    public final void zzbwc() {
        if (this.zzmsl.compareAndSet(false, true) && this.zzmsm != null) {
            this.zzmsm.zzd(this);
            this.zzmsm = null;
        }
    }

    public final boolean zzbwd() {
        return this.zzmsl.get();
    }

    public abstract boolean zzc(zzedh com_google_android_gms_internal_zzedh);

    public final void zzco(boolean z) {
        this.zzmsn = true;
    }
}
