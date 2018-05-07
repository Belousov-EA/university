package com.google.firebase.database;

final class zzs implements Runnable {
    private /* synthetic */ Query zzmkz;
    private /* synthetic */ boolean zzmlc;

    zzs(Query query, boolean z) {
        this.zzmkz = query;
        this.zzmlc = z;
    }

    public final void run() {
        this.zzmkz.zzmkl.zza(this.zzmkz.zzbsz(), this.zzmlc);
    }
}
