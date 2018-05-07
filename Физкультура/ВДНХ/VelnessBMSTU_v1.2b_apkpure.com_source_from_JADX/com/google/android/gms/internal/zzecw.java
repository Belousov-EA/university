package com.google.android.gms.internal;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.zzh;

public final class zzecw extends zzedh {
    private final zzedn zzmkl;
    private final ChildEventListener zzmrq;
    private final zzeik zzmrr;

    public zzecw(zzedn com_google_android_gms_internal_zzedn, ChildEventListener childEventListener, zzeik com_google_android_gms_internal_zzeik) {
        this.zzmkl = com_google_android_gms_internal_zzedn;
        this.zzmrq = childEventListener;
        this.zzmrr = com_google_android_gms_internal_zzeik;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzecw) && ((zzecw) obj).zzmrq.equals(this.zzmrq) && ((zzecw) obj).zzmkl.equals(this.zzmkl) && ((zzecw) obj).zzmrr.equals(this.zzmrr);
    }

    public final int hashCode() {
        return (((this.zzmrq.hashCode() * 31) + this.zzmkl.hashCode()) * 31) + this.zzmrr.hashCode();
    }

    public final String toString() {
        return "ChildEventRegistration";
    }

    public final zzedh zza(zzeik com_google_android_gms_internal_zzeik) {
        return new zzecw(this.zzmkl, this.zzmrq, com_google_android_gms_internal_zzeik);
    }

    public final zzeia zza(zzehz com_google_android_gms_internal_zzehz, zzeik com_google_android_gms_internal_zzeik) {
        return new zzeia(com_google_android_gms_internal_zzehz.zzbye(), this, zzh.zza(zzh.zza(this.zzmkl, com_google_android_gms_internal_zzeik.zzbsy().zza(com_google_android_gms_internal_zzehz.zzbyd())), com_google_android_gms_internal_zzehz.zzbyb()), com_google_android_gms_internal_zzehz.zzbyf() != null ? com_google_android_gms_internal_zzehz.zzbyf().asString() : null);
    }

    public final void zza(zzeia com_google_android_gms_internal_zzeia) {
        if (!zzbwd()) {
            switch (zzecx.zzmrs[com_google_android_gms_internal_zzeia.zzbye().ordinal()]) {
                case 1:
                    this.zzmrq.onChildAdded(com_google_android_gms_internal_zzeia.zzbyh(), com_google_android_gms_internal_zzeia.zzbyi());
                    return;
                case 2:
                    this.zzmrq.onChildChanged(com_google_android_gms_internal_zzeia.zzbyh(), com_google_android_gms_internal_zzeia.zzbyi());
                    return;
                case 3:
                    this.zzmrq.onChildMoved(com_google_android_gms_internal_zzeia.zzbyh(), com_google_android_gms_internal_zzeia.zzbyi());
                    return;
                case 4:
                    this.zzmrq.onChildRemoved(com_google_android_gms_internal_zzeia.zzbyh());
                    return;
                default:
                    return;
            }
        }
    }

    public final void zza(DatabaseError databaseError) {
        this.zzmrq.onCancelled(databaseError);
    }

    public final boolean zza(zzeic com_google_android_gms_internal_zzeic) {
        return com_google_android_gms_internal_zzeic != zzeic.VALUE;
    }

    public final zzeik zzbvp() {
        return this.zzmrr;
    }

    public final boolean zzc(zzedh com_google_android_gms_internal_zzedh) {
        return (com_google_android_gms_internal_zzedh instanceof zzecw) && ((zzecw) com_google_android_gms_internal_zzedh).zzmrq.equals(this.zzmrq);
    }
}
