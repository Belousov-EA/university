package com.google.android.gms.internal;

final class zzebp implements Runnable {
    private /* synthetic */ boolean zzmos;
    final /* synthetic */ zzebo zzmot;

    zzebp(zzebo com_google_android_gms_internal_zzebo, boolean z) {
        this.zzmot = com_google_android_gms_internal_zzebo;
        this.zzmos = z;
    }

    public final void run() {
        this.zzmot.zzmlr.zzb("Trying to fetch auth token", null, new Object[0]);
        zzebj.zzc(this.zzmot.zzmob == zzeby.Disconnected, "Not in disconnected state: %s", this.zzmot.zzmob);
        this.zzmot.zzmob = zzeby.GettingToken;
        this.zzmot.zzmon = 1 + this.zzmot.zzmon;
        this.zzmot.zzmnp.zza(this.zzmos, new zzebq(this, this.zzmot.zzmon));
    }
}
