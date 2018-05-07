package com.google.android.gms.internal;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.zzh;

public final class zzegf extends zzedh {
    private final zzedn zzmkl;
    private final zzeik zzmrr;
    private final ValueEventListener zzmww;

    public zzegf(zzedn com_google_android_gms_internal_zzedn, ValueEventListener valueEventListener, zzeik com_google_android_gms_internal_zzeik) {
        this.zzmkl = com_google_android_gms_internal_zzedn;
        this.zzmww = valueEventListener;
        this.zzmrr = com_google_android_gms_internal_zzeik;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzegf) && ((zzegf) obj).zzmww.equals(this.zzmww) && ((zzegf) obj).zzmkl.equals(this.zzmkl) && ((zzegf) obj).zzmrr.equals(this.zzmrr);
    }

    public final int hashCode() {
        return (((this.zzmww.hashCode() * 31) + this.zzmkl.hashCode()) * 31) + this.zzmrr.hashCode();
    }

    public final String toString() {
        return "ValueEventRegistration";
    }

    public final zzedh zza(zzeik com_google_android_gms_internal_zzeik) {
        return new zzegf(this.zzmkl, this.zzmww, com_google_android_gms_internal_zzeik);
    }

    public final zzeia zza(zzehz com_google_android_gms_internal_zzehz, zzeik com_google_android_gms_internal_zzeik) {
        return new zzeia(zzeic.VALUE, this, zzh.zza(zzh.zza(this.zzmkl, com_google_android_gms_internal_zzeik.zzbsy()), com_google_android_gms_internal_zzehz.zzbyb()), null);
    }

    public final void zza(zzeia com_google_android_gms_internal_zzeia) {
        if (!zzbwd()) {
            this.zzmww.onDataChange(com_google_android_gms_internal_zzeia.zzbyh());
        }
    }

    public final void zza(DatabaseError databaseError) {
        this.zzmww.onCancelled(databaseError);
    }

    public final boolean zza(zzeic com_google_android_gms_internal_zzeic) {
        return com_google_android_gms_internal_zzeic == zzeic.VALUE;
    }

    public final zzeik zzbvp() {
        return this.zzmrr;
    }

    public final boolean zzc(zzedh com_google_android_gms_internal_zzedh) {
        return (com_google_android_gms_internal_zzedh instanceof zzegf) && ((zzegf) com_google_android_gms_internal_zzedh).zzmww.equals(this.zzmww);
    }
}
